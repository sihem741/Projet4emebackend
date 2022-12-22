package tn.esprit.spring.repositories;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.ComplaintSearchCriteria;
import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.ComplaintPage;
@Repository
public class ComplaintCriteriaRepository {
	EntityManager entityManager;
	 CriteriaBuilder criteriaBuilder;
	 public ComplaintCriteriaRepository(EntityManager entityManager) {
	        this.entityManager = entityManager;
	        this.criteriaBuilder = entityManager.getCriteriaBuilder();
	    }
	public Page<Complaint> findAllWithFilters(ComplaintPage complaintPage , ComplaintSearchCriteria complaintSearchCriteria){
		CriteriaQuery<Complaint> criteriaQuery = criteriaBuilder.createQuery(Complaint.class);
		Root<Complaint> complaintRoot = criteriaQuery.from(Complaint.class);
		 Predicate predicate = getPredicate(complaintSearchCriteria ,complaintRoot);
		 criteriaQuery.where(predicate);
		 setOrder( complaintPage, criteriaQuery, complaintRoot);
		 
		 TypedQuery<Complaint> typedQuery = entityManager.createQuery(criteriaQuery);
		 typedQuery.setFirstResult(complaintPage.getPageNumber() * complaintPage.getPageSize());
	        typedQuery.setMaxResults(complaintPage.getPageSize());
	        
	        Pageable pageable = getPageable(complaintPage);
	        
	        long complaintCount = getComplaintCount(predicate);
	        
	        return new PageImpl<>(typedQuery.getResultList(), pageable,complaintCount);
	}
	
	
	private long getComplaintCount(Predicate predicate) {
		CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Complaint> countRoot = countQuery.from(Complaint.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
	
	}
	private Pageable getPageable(ComplaintPage complaintPage) {
		Sort sort = Sort.by(complaintPage.getSortDirection(), complaintPage.getSortBy());
        return PageRequest.of(complaintPage.getPageNumber(),complaintPage.getPageSize(), sort);
	}
	private void setOrder(ComplaintPage complaintPage,
			CriteriaQuery<Complaint> criteriaQuery,
			Root<Complaint> complaintRoot) {
		//sort
		if(complaintPage.getSortDirection().equals(Sort.Direction.ASC)){
            criteriaQuery.orderBy(criteriaBuilder.asc(complaintRoot.get(complaintPage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(complaintRoot.get(complaintPage.getSortBy())));
        }
		

		
	}
	private Predicate getPredicate(ComplaintSearchCriteria complaintSearchCriteria, Root<Complaint> complaintRoot) {
		List<Predicate> predicates = new ArrayList<>();
		if(Objects.nonNull(complaintSearchCriteria.getCategoriecomplaint())){
            predicates.add(
                    criteriaBuilder.like(complaintRoot.get("Categoriecomplaint"),
                            "%" + complaintSearchCriteria.getCategoriecomplaint() + "%")
            );
        }
        if(Objects.nonNull(complaintSearchCriteria.getFirstName())){
            predicates.add(
                    criteriaBuilder.like(complaintRoot.get("firstName"),
                            "%" + complaintSearchCriteria.getFirstName() + "%")
            );
        }
        if(Objects.nonNull(complaintSearchCriteria.getLastName())){
            predicates.add(
                    criteriaBuilder.like(complaintRoot.get("lastName"),
                            "%" + complaintSearchCriteria.getLastName() + "%")
            );
            
}return criteriaBuilder.and(predicates.toArray(new Predicate[0]));}}
