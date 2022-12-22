package tn.esprit.spring.entities;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class ComplaintSearchCriteria {
	private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
	private CategorieComplaint categoriecomplaint;

    public String getFirstName() {
        return firstName;
    }

    public CategorieComplaint getCategoriecomplaint() {
		return categoriecomplaint;
	}

	public void setCategoriecomplaint(CategorieComplaint categoriecomplaint) {
		this.categoriecomplaint = categoriecomplaint;
	}

	public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
