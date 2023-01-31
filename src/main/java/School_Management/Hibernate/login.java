package School_Management.Hibernate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		
		String uname=req.getParameter("user_id");
		String pass=req.getParameter("password");
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("mahi");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Query query=em.createQuery("select b from principal b where email=?1 and pass=?2");
		query.setParameter(1, uname);
		query.setParameter(2, pass);
		
		List<principal> p=query.getResultList();
		
		if(p.size() > 0)
		{
			PrintWriter pw=resp.getWriter();
			pw.write("login .....");
			
			RequestDispatcher rd=req.getRequestDispatcher("main.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
				}
		else
		{
			PrintWriter pw=resp.getWriter();
			pw.write("invalidet credentil....");
			
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
		
		}
		
	}

}
