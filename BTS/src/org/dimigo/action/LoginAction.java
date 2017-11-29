/**
 * 
 */
package org.dimigo.action;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.service.UserService;
import org.dimigo.vo.UserVO;

/**
 * <pre>
 * org.dimigo.action
 *	 |_LoginAction
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 25.
 * </pre>
 * 
 * @author : Jeon
 * @version : 1.0
 */
public class LoginAction implements IAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dimigo.action.IAction#execute(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {

			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();

			request.setCharacterEncoding("utf-8");

			// id, pw 받아옴
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			// String name = request.getParameter("name");

			System.out.printf("id : %s, pw : %s", id, pw);
			System.out.println();

			// VO에 입력값 담기
			UserVO user = new UserVO();
			user.setId(id);
			user.setPw(pw);

			UserService service = new UserService();

			// login service 호출
			// result2 -> 
			UserVO result2 = service.login(user);
			System.out.println(result2);

			if (result2 != null) {
				// 세션에 사용자 생성
				HttpSession session = request.getSession();
				session.setAttribute("user", result2);

				RequestDispatcher rd = request.getRequestDispatcher("jsp/main.jsp");
				rd.forward(request, response);

			} else {
				
				throw new Exception("Invalid username or password");

			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/main.jsp");
			rd.forward(request, response);
			
		}

	}
}
