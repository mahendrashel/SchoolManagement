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

@WebServlet("/deletestudent")
public class DeleteStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		
		
String id = req.getParameter("id");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mahi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
	
		Student s=new Student();
		
		int id1=Integer.parseInt(id);
		s.setId(id1);
		s=em.find(Student.class, id1);
		if(s!=null)
		{
			
		et.begin();
		em.remove(s);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("Student Detail Deleted Successsfully...");
		resp.setContentType("text/html");
		RequestDispatcher rd=req.getRequestDispatcher("student.html");
		rd.include(req, resp);
		}
		else
		{
			PrintWriter pw=resp.getWriter();
			pw.write("Data not found...");
			resp.setContentType("text/html");
			RequestDispatcher rd=req.getRequestDispatcher("student.html");
			rd.include(req, resp);
		}
	}

}
