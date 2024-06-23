package com.example.ManyToMany;

import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Session session=  new Configuration().configure().addAnnotatedClass(Actor.class).addAnnotatedClass(Role.class).buildSessionFactory().openSession();
        session.beginTransaction();
    	Actor a1=new Actor();
        a1.setName("Prabhas");
        a1.setPhone("9876");
        
        Actor a2=new Actor();
        a2.setName("Salaman");
        a2.setPhone("9879");
        
        Role r1=new Role();
        r1.setName("Police");
        r1.setDescription("a decent police");
        
        Role r2=new Role();
        r2.setName("Villain");
        r2.setDescription("a not decent");
        
        a1.getRole().add(r1);
        a1.getRole().add(r2);
        
        a2.getRole().add(r1);
        a2.getRole().add(r2);
        
        r1.getActors().add(a1);
        r1.getActors().add(a2);
        
        r2.getActors().add(a1);
      
        
        session.save(a1);
        session.save(a2);
        session.save(r1);
        session.save(r2);
        
        session.beginTransaction().commit();
        
        
        
        
        
    }
}
