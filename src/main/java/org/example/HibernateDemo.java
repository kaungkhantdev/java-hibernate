package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HibernateDemo {

    public void run() {

        Tag tag = new Tag();
        tag.setId(1);
        tag.setName("hello");

        Tag tag1 = new Tag();
        tag1.setId(2);
        tag1.setName("hello tag 3");

        var picture = new Picture();
        picture.setId(1);
        picture.setUrl("hello");

        var picture1 = new Picture();
        picture1.setId(2);
        picture1.setUrl("hello url");


        Blog blog = new Blog();
        blog.setId(1);
        blog.setTitle("Technology Next three Hi");
        blog.setContent("Tech Content");
        blog.setTags(Arrays.asList(tag, tag1));
        blog.setPictures(Arrays.asList(picture, picture1));

        Blog blog1 = new Blog();
        blog1.setId(2);
        blog1.setTitle("Technology Next three");
        blog1.setContent("Tech Content haha");
        blog1.setTags(Arrays.asList(tag, tag1));
        blog1.setPictures(Arrays.asList(picture, picture1));

        tag.setBlog(blog);
        tag1.setBlog(blog);

        picture.setBlogs(Arrays.asList(blog, blog1));
        picture1.setBlogs(Arrays.asList(blog, blog1));


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Blog.class)
                .addAnnotatedClass(org.example.Tag.class)
                .addAnnotatedClass(org.example.Picture.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

         Transaction transaction = session.beginTransaction();

        // save
         session.persist(tag);
         session.persist(tag1);
         session.persist(picture);
         session.persist(picture1);
         session.persist(blog);
         session.persist(blog1);

         transaction.commit();

        // get
        // Blog blog2 = null;
        // blog2 = session.get(Blog.class, 1);

        // update
        // session.merge(blog);

        // delete
        // Transaction transaction = session.beginTransaction();
        // Blog blog3 = session.get(Blog.class, 2);
        // session.remove(blog3);

        // transaction.commit();
        session.close();
        sf.close();

        System.out.println(blog);

    }
}
