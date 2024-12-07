package com.klef.jfsd.exam;

import org.hibernate.*;
import org.hibernate.criterion.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Insert records
            Project project1 = new Project();
            project1.setProjectName("E-Commerce Platform");
            project1.setDuration(12);
            project1.setBudget(100000);
            project1.setTeamLead("Alice");

            Project project2 = new Project();
            project2.setProjectName("CRM Software");
            project2.setDuration(8);
            project2.setBudget(80000);
            project2.setTeamLead("Bob");

            session.save(project1);
            session.save(project2);

            // Commit transaction
            transaction.commit();

            // Aggregate Functions using Criteria
            Criteria criteria = session.createCriteria(Project.class);

            // Count
            criteria.setProjection(Projections.rowCount());
            System.out.println("Total Projects: " + criteria.uniqueResult());

            // Max
            criteria.setProjection(Projections.max("budget"));
            System.out.println("Max Budget: " + criteria.uniqueResult());

            // Min
            criteria.setProjection(Projections.min("budget"));
            System.out.println("Min Budget: " + criteria.uniqueResult());

            // Sum
            criteria.setProjection(Projections.sum("budget"));
            System.out.println("Total Budget: " + criteria.uniqueResult());

            // Average
            criteria.setProjection(Projections.avg("budget"));
            System.out.println("Average Budget: " + criteria.uniqueResult());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}