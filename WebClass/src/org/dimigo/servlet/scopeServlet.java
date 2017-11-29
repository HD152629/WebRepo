package org.dimigo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class scopeServlet
 */
@WebServlet("/scope")
public class scopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public scopeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			// id, pwd 값을 뽑아서 sysout
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			request.setCharacterEncoding("utf-8");
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
	
			System.out.printf("id : %s pwd : %s\n", id, pwd);
			
			if(id==null || id.trim().equals(""))
				throw new Exception("아이디는 필수 항목");
			
			// 1. requests scope (거래단위별)
			// request하고 또하면 유지 안됨
			request.setAttribute("key", "rValue");
			
			// 2.session scope (클라이언트별 사용자정보)
			request.getSession().setAttribute("key", "sValue");
			
			// 3. application scope (전체 어플리케이션 공유정보)
			request.getServletContext().setAttribute("key", "aValue");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/scope.jsp");
			rd.forward(request, response);
			
		} catch(Exception e) {
			
			request.setAttribute("error", e.getMessage());
			// session은 왜 안된다고?
			RequestDispatcher rd = request.getRequestDispatcher("jsp/scope.jsp");
			rd.forward(request, response);
			
		}
	}

}
