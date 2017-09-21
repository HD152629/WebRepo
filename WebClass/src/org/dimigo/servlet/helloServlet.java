package org.dimigo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class helloServlet
 */
@WebServlet/*<-어노테이션*/(description = "첫번째 서블릿", urlPatterns = { "/hello" })
public class helloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public helloServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력데이터 처리
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		System.out.printf("id : %s, name : %s\n",id,name);
		
		// 출력데이터(Content Type 설정)
//		response.setCharacterEncoding("utf-8"); // 한글 타입
		
		response.setContentType("text/html;charset=utf-8");	//HTML Content Type
		PrintWriter out = response.getWriter();
		/*
		 * 위에 2줄 순서 중요함.
		 * 
		 */
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Servelt Test</title>");
		out.print("</head>");
		out.print("<h1>Hello, Servlet</h1>");
		out.print("<h1>안녕 디지몬</h1>");
		out.print("<h2>id : " + id + ", name : "+name+"</h2>");
		out.print("</body>");
		out.print("</html>");

}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() 호출됨");
		doGet(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		// 최초 메모리 로딩시에 1회 호출
		System.out.println("init() 호출");
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service() 호출");
		super.service(arg0, arg1);
	}
	
	@Override
	public void destroy() {
		// 메모리에서 해제 시 호출됨
		// 서비를 중단시키거나, 소스가 변겨오딘 경우
		System.out.println("destroy() 호출");
	}
}
