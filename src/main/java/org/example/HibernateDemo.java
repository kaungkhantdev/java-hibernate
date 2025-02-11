package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDemo {

    public void run() {
        Blog blog = new Blog();
        blog.setId(1);
        blog.setTitle("Technology");
        blog.setContent("Tech Content.");

        Configuration config = new Configuration();
        config.addAnnotatedClass(org.example.Blog.class);
        config.configure("hibernate.cfg.xml");

        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(blog);

        transaction.commit();
        System.out.println(blog);

    }
}
