package org.dimigo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.vo.UserVO;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 여기는 콘솔에 sysout 하는 부분
		System.out.printf("id : %s, pw : %s\n",id,pwd);
		
		// id, pwd 사용자 인증 체크
		boolean result= true;
		
		if(result){
			
			// 세션에 사용자 정보를 생성하여 담기
			HttpSession session = request.getSession();
			
			UserVO user = new UserVO();
			user.setId(id);
			user.setName("홍길동");
			user.setNickname("의적");
			
			session.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
			rd.forward(request, response);
			
		}
		else{
			
			// error 던져서 login.jsp 로 가서  if("error".equals(request.getAttribute("msg"))) 이부분 동작하게 
			request.setAttribute("msg", "error");
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
			rd.forward(request, response);
			
		}
		
		
		
		out.close();		
	}

}

//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	response.setContentType("application/json; charset=utf-8");
//	PrintWriter out = response.getWriter();
//	
//	String id = request.getParameter("id");
//	String pw = request.getParameter("pw");
//	
//	System.out.printf("id : %s, pw : %s\n",id,pw);
//	
//	/*
//	 * {
//	 *   "id : "test"
//	 * }
//	 */
////	
////	out.println("{");
////	out.println("\"id \" : " + "\"" +  id + "\"");
////	out.println("}");
//	
//	// JSON Simple library 사용
////	JSONObject json = new JSONObject();
////	json.put("id", id);
////	System.out.println(json.toJSONString());
////	out.write(json.toJSONString());
////	
////	
////	out.close();
//	
//	// Gson library를 사용하도록 소스 작성하기
//	
//	Gson gson = new Gson();
//	JsonObject object = new JsonObject();
//	object.addProperty("id", id);
//	
//	out.write(gson.toJson(object));
//	out.close();
//	
//}
//
//}
