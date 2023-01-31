package School_Management.Hibernate;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.OverridesAttribute;

@WebServlet("/addstudent")
public class AddStudentServlate extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String fees=req.getParameter("fees");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mahi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
	
		int id1=Integer.parseInt(id);
		Student s=new Student();
		
		s.setId(id1);
		s.setName(name);
		s.setFee(Integer.parseInt(fees));
		
		et.begin();
		em.persist(s);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Student Detail Added Successsfully...");
		resp.setContentType("text/html");
		RequestDispatcher rd=req.getRequestDispatcher("student.html");
		rd.include(req, resp);
		
	
	}
	

}

