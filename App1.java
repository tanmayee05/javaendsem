package Hibernate.Hibernate_demo;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;


public class App1 
{
	@SuppressWarnings("deprecation")
    public static void main( String[] args )
    {
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    	Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
    	SessionFactory sf = md.getSessionFactoryBuilder().build();
    	Session s = sf.openSession();
    	Transaction t;
    	Employee e = new Employee();
    	e.setFn("virat");
    	e.setLn("kohli");
    	s.save(e);
    	t= s.beginTransaction();
    	t.commit();
    	System.out.println("Employee record inserted succesfully");
    	RegularEmp re = new RegularEmp();
        re.setFn("dennis");
        re.setLn("ritche");
        re.setDept("CSE");
        re.setDesign("Professor");
        re.setSalary(100000.00);
        
        s.save(re);
    	t= s.beginTransaction();
    	t.commit();
    	System.out.println("Regular Employee record inserted succesfully");

    	DailyEmp de = new DailyEmp();
    	de.setFn("james");
    	de.setLn("Gosling ");
    	de.setDailywages(200000.00);
    	de.setExp(35);
    	
    	 s.save(de);
     	t= s.beginTransaction();
     	t.commit();
     	System.out.println("Daily Employee record inserted succesfully");

    	
    	
    	
    	 
    	 //these are Hibernate Query Language(HQL)
    	 
    	 /*Employee e=new Employee();
    	 e.setFn("sonu");
    	 e.setLn("vishnu");
    	 s.save(e);
    	 t=s.beginTransaction();
    	 t.commit();
    	 System.out.println("Record is inserted successfully!");
    	 
    	 //update
    	 
    	 Employee r =s.find(Employee.class, 12);
    	 System.out.println("first name before update: "+r.getFn());
    	 System.out.println("Last name before update: "+r.getLn());
    	 r.setFn("sonu");
    	 r.setLn("oju");
    	 
    	 s.save(r); //session object saves the record in employee table
    	 t=s.beginTransaction();
    	 t.commit();
    	 
    	 System.out.println("Record is updated  successfully!");
    	 System.out.println("first name after update: "+r.getFn());
    	 System.out.println("last name after update: "+r.getLn());
    	 
    	 //delete
    	  
    	  
    	 Employee r =s.find(Employee.class,9 );
    	 s.delete(r);
    	 t=s.beginTransaction();
    	 t.commit();
         System.out.println("record is deleted");*/
         
         
         //Hibernate Criteria  Query Language
//         
//         Criteria c=s.createCriteria(Employee.class);
//         c.add(Restrictions.gt("id",2));
//         List<Employee> l = c.list();
//         
//         System.out.println("First row first name "+l.get(0).getFn());
//         System.out.println("First row last name "+l.get(0).getLn());
//         System.out.println("First row first name "+l.get(1).getFn());
//         System.out.println("First row last name "+l.get(1).getLn());
//         
    	
    	
         
        
         
         
    	 
    }
}
