package Hibernate.Hibernate_demo;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.*;
public class App {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sf = md.getSessionFactoryBuilder().build();
        Session s = sf.openSession();
        Transaction t;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter operation (insert, update, delete, view):");
        String operation = sc.next(); 

        switch (operation) {
            case "insert":
                Employee e = new Employee();
                e.setFn("Sandhya");
                e.setLn("Arava");
                
                
//                Criteria c = s.createCriteria("Employee.class");
//                c.add(Restrictions.gt("id",2));
                
                t = s.beginTransaction();
                s.save(e);
                t.commit();
                System.out.println("Record Inserted Successfully");
                break;

            case "update":
                System.out.println("Enter employee ID to update:");
                int updateId = sc.nextInt();
                Employee r = s.find(Employee.class, updateId);

                if (r != null) {
                    System.out.println("First name before update: " + r.getFn());
                    System.out.println("Last name before update: " + r.getLn());

                    r.setFn("KRISH");
                    r.setLn("Arava");

                    t = s.beginTransaction();
                    s.update(r);
                    t.commit();

                    System.out.println("Record Updated Successfully");
                    System.out.println("First name after update: " + r.getFn());
                    System.out.println("Last name after update: " + r.getLn());
                } else {
                    System.out.println("Employee not found");
                }
                break;

            case "delete":
                System.out.println("Enter employee ID to delete:");
                int deleteId = sc.nextInt();
                Employee d = s.find(Employee.class, deleteId);

                if (d != null) {
                    t = s.beginTransaction();
                    s.delete(d);
                    t.commit();
                    Criteria ca = s.createCriteria("Employee.class");
                    ca.add(Restrictions.gt("id",2));
                    List<Employee> l;
                    l=ca.list();
                    System.out.println("FIrst row first name"+l.get(0).getFn());
                    System.out.println("FIrst row first name"+l.get(0).getLn());

                    
                    System.out.println("Employee Record Deleted Successfully");
                } 
                 else {
                    System.out.println("Employee not found");
                }
                break;

            case "view":
                Query<Employee> query = s.createQuery("FROM Employee", Employee.class);
                List<Employee> employees = query.list();
                System.out.println("List of Employees:");
                for (Employee emp : employees) {
                    System.out.println("ID: " + emp.getId() + ", First Name: " + emp.getFn() + ", Last Name: " + emp.getLn());
                }
                break;

            default:
                System.out.println("Invalid operation");
                break;
        }

        s.close();
        sf.close();
        sc.close();
    }
}
