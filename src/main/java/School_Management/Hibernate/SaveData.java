package School_Management.Hibernate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.Entity;
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

@WebServlet("/registration")
public class SaveData extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
//		String mob=req.getParameter("mob");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mahi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		int id1=Integer.parseInt(id);
//		int mob1=Integer.parseInt(mob);
		principal p=new principal();
		p.setName(name);
		p.setAge(id1);
		p.setEmail(email);
		p.setPassword(pass);
//		p.setMob(mob1);
		
		et.begin();
		em.persist(p);
		et.commit();
		
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.forward(req, resp);
		
		PrintWriter pw=resp.getWriter();
		pw.println("Your successsfully register....");
	}
	

}
