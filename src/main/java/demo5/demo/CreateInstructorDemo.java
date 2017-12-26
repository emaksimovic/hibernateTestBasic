package main.java.demo5.demo;

import demo5.entity.Course;
import demo5.entity.Instructor;
import demo5.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by maxa on 12/24/2017.
 */
public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .addAnnotatedClass(Course.class)
                                        .buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("creating new object");
            Instructor tmpInstructor = new Instructor("TestFirst","TestLast","TestEmail");
            InstructorDetail tmpInstructorDetail = new InstructorDetail("testChannel","testHobby");
            tmpInstructor.setInstructorDetail(tmpInstructorDetail);
            session.beginTransaction();
            System.out.println("saving new object");
            session.save(tmpInstructor);
            session.getTransaction().commit();

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            InstructorDetail resultInstructorDetail = session.get(InstructorDetail.class, "2");
          /*  List<Student> resultStudents = session
                    .createQuery("from Student s where s.lastName='TestLast'")
                    .getResultList();*/
            session.getTransaction().commit();
//            resultStudents.forEach(System.out::println);
            System.out.println(resultInstructorDetail);
            System.out.println(resultInstructorDetail.getInstructor());

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Instructor resultInstructor = session.get(Instructor.class, "3");
            System.out.println(resultInstructor);
            System.out.println(resultInstructor.getCourses());

           /* Course tmpCourse = new Course("Programming");
            Course tmpCourse1 = new Course("Art");
            tmpInstructor.addCourse(tmpCourse);
            tmpInstructor.addCourse(tmpCourse1);

            session.save(tmpCourse);
            session.save(tmpCourse1);*/

            session.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }

        System.out.println("done");
    }
}
