package School_Management.Hibernate;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/VerifyStudent")
public class VerifyStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		
		String id=req.getParameter("id");
		
		int id1=Integer.parseInt(id);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mahi");
		EntityManager em=emf.createEntityManager();
		
		Student s=new Student();
		if(s.getId()==id1)
		{
			em.find(Student.class, id1);
			System.out.println(s.getId());
			System.out.println(s.getName());
			System.out.println(s.getStream());
			System.out.println(s.getFee());
		}
		else {
			 System.out.println("Student Is Not Fond");
		}
	}
}
