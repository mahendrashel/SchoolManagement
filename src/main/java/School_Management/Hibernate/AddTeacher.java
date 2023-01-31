package School_Management.Hibernate;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/AddTeacher")
public class AddTeacher extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String subject=req.getParameter("subject");
		String sal=req.getParameter("sal");
		
	  int id1=Integer.parseInt(id);
	  Double sal1=Double.parseDouble(sal);
	  
	  
	  EntityManagerFactory emf=Persistence.createEntityManagerFactory("mahi");
	  EntityManager em=emf.createEntityManager();
	  EntityTransaction et=em.getTransaction();
	  
	  Teacher t=new Teacher();
	 
	  t.setId(id1);
	  t.setName(name);
	  t.setSub(subject);
	  t.setSal(sal1);
	  
	  et.begin();
	  em.persist(t);
	  et.commit();
	  
	  PrintWriter w=resp.getWriter();
	  w.write("Teachear Is Added");
	  RequestDispatcher rd=req.getRequestDispatcher("teacher.html");
	  rd.include(req, resp);
	  resp.setContentType("text/html");
	}
}
