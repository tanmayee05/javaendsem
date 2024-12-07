package Hibernate.Hibernate_demo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
//import javax.persistence.Transient;

@Entity

@AttributeOverrides(
		{
			@AttributeOverride(name = "@id",column=@Column(name="re_id")), 
			@AttributeOverride(name = "@id",column=@Column(name="re_fn")), 
			@AttributeOverride(name = "@id",column=@Column(name="re_ln")), 

		}
		)

@Table(name = "RegularEmployee")

//@DiscriminatorValue(value ="regularempTable")

public class RegularEmp extends Employee {
    Double salary;
    
    @Column(name = "designation")
    String design;
    
    String dept;
    
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
