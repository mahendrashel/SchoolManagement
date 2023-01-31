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

@WebServlet("/registration")

public class Servlate1 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		
String name=req.getParameter("name");
		
		String mobilenumber =req.getParameter("moblienumber");
		String email=req.getParameter("email");
		String password =req.getParameter("password");
		
		int mobilenumber1=Integer.parseInt(mobilenumber);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mahi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		principal p=new principal();
		
		p.setName(name);
		p.setEmail(email);
		p.setMobno(mobilenumber1);
		p.setPassword(password);
		
		et.begin();
		
		em.persist(p);
		et.commit();
		
		RequestDispatcher rd = req.getRequestDispatcher("Login.html");
		rd.forward(req, resp);
		resp.setContentType("text/html");
		
		PrintWriter w=resp.getWriter();
		w.write("invalid input");
		 rd.include(req, resp);
	}
}
