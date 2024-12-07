package Hibernate.Hibernate_demo;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity

//class name will be name of the table

@AttributeOverrides(
		{
			@AttributeOverride(name = "@id",column=@Column(name="re_id")), 
			@AttributeOverride(name = "@id",column=@Column(name="re_fn")), 
			@AttributeOverride(name = "@id",column=@Column(name="re_ln")), 

		}
		)

@DiscriminatorColumn(name="emp",discriminatorType = DiscriminatorType.STRING)

//@DiscriminatorValue(value="employeeTable")

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;//primary key
	String fn,ln;
	//first name 
	//@Transient only for cls 
	//string collge ; it is wrong it will be in class but not in table(no where related to table)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}

}