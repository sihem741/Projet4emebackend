package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.domain.Sort;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ComplaintPage   {
	
	 private int pageNumber = 0;
	    private int pageSize = 10;
	    private Sort.Direction sortDirection = Sort.Direction.ASC;
	    private String sortBy = "lastName";

	    public int getPageNumber() {
	        return pageNumber;
	    }

	    public void setPageNumber(int pageNumber) {
	        this.pageNumber = pageNumber;
	    }

	    public int getPageSize() {
	        return pageSize;
	    }

	    public void setPageSize(int pageSize) {
	        this.pageSize = pageSize;
	    }

	    public Sort.Direction getSortDirection() {
	        return sortDirection;
	    }

	    public void setSortDirection(Sort.Direction sortDirection) {
	        this.sortDirection = sortDirection;
	    }

	    public String getSortBy() {
	        return sortBy;
	    }

	    public void setSortBy(String sortBy) {
	        this.sortBy = sortBy;
	    }
}
