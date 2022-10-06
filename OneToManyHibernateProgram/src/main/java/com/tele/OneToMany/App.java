package com.tele.OneToMany;

/*--Create one to many relationship one Teacher and their Courses.
A teacher name Mrudula can give multiple courses likeJava Programming,
Python programming, Angular Programming but a course is given by only one teacher--*/

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Rajani
 *
 */

public class App 
{
    public static void main( String[] args )
    {
    	//Configuration of teacher and course class
    	Configuration con=new Configuration().configure().addAnnotatedClass(Teacher.class);
    	Configuration con1=new Configuration().configure().addAnnotatedClass(Courses.class);
    	SessionFactory sf=con.buildSessionFactory();                //create object of sessionFactory
    	Session session=sf.openSession();                           //create object of session
    	Transaction ts=session.beginTransaction();                  //object of transaction
    	
    	//store data of teacher and course
    	Courses course1=new Courses(331,"Java Programming");         
  	  	Courses course2=new Courses(361,"Python Programming");
        Courses course3=new Courses(391,"Angular Programming");
      	Teacher t1=new Teacher(123,"Mrudula") ;
 
    	
    	Courses course4=new Courses(341,"Hindi");
        Courses course5=new Courses(351,"English");
        Courses course6=new Courses(371,"Math");
    	Teacher t2=new Teacher(222,"radha");
    	
    	t1.getCourses().add(course1);
    	t1.getCourses().add(course2);
    	t1.getCourses().add(course3);
    	t2.getCourses().add(course4);
    	t2.getCourses().add(course5);
    	t2.getCourses().add(course6);
    	
    	//save session 
    	session.save(t1);
        session.save(t2);
        
        System.out.println(" Before updation details of Teacher and courses");
    	Query q=session.createQuery("from Teacher");
    	List<Teacher> trainer1=q.list();
    	for(Teacher t:trainer1)
    	{
    		System.out.println(" Teacher id: "+t.getId()+" Teacher name: "+t.getName());
    	}
  
    	Query m=session.createQuery("from Courses");
    	List<Courses> cour1=m.list();
    	for(Courses c:cour1)
    	{
    		System.out.println(" Course id: "+c.getid()+" Course name: "+c.getname());
    	}
    
  
    	
    	
    	// Updating Teacher entity
        Teacher teach=(Teacher)session.get(Teacher.class,222);
        teach.setName("Rima");     
        session.getTransaction();
        System.out.println("\n Updation Completed");
        
        
        
        System.out.println("After updation details of Teacher and courses ");
    	Query q1=session.createQuery("from Teacher");
    	List<Teacher> trainer2=q.list();
    	for(Teacher t:trainer2)
    	{
    		System.out.println(" Teacher id: "+t.getId()+" Teacher name: "+t.getName());
    	}
    	
    	Query m1=session.createQuery("from Courses");
    	List<Courses> cour2=m.list();
    	for(Courses c:cour2)
    	{
    		System.out.println(" Course id: "+c.getid()+" Course name: "+c.getname());
    	}
    	
    	
        
        
        // Deletion from Teacher Entity 
       Teacher teach1=(Teacher)session.get(Teacher.class,222);
        session.delete(teach1);      
        session.getTransaction();
        System.out.println("\n Deletion completed ");
        
        
        System.out.println("After Deletion details of Teacher and courses ");
    	Query q2=session.createQuery("from Teacher");
    	List<Teacher> trainer3=q.list();
    	for(Teacher t:trainer3)
    	{
    		System.out.println(" Teacher id: "+t.getId()+" Teacher name: "+t.getName());
    	}
    	
    	Query m2=session.createQuery("from Courses");
    	List<Courses> cour3=m.list();
    	for(Courses c:cour3)
    	{
    		System.out.println(" Course id: "+c.getid()+" Course name: "+c.getname());
    	}
    	
    	
    	ts.commit();
    	session.close();
    	

    }
}
