package Hibernate.Hibernate_demo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity

@AttributeOverrides(
		{
			@AttributeOverride(name = "@id",column=@Column(name="re_id")), 
			@AttributeOverride(name = "@id",column=@Column(name="re_fn")), 
			@AttributeOverride(name = "@id",column=@Column(name="re_ln")), 

		}
		)
@Table(name="DailyEmployee")

//@DiscriminatorValue(value="dailyempTable")

public class DailyEmp  extends Employee{
	
	public Double getDailywages() {
		return dailywages;
	}
	public void setDailywages(Double dailywages) {
		this.dailywages = dailywages;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	Double dailywages;
	@Column(name="experience")
	int exp;

}
