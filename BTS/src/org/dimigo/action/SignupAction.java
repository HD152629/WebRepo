/**
 * 
 */
package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.service.UserService;
import org.dimigo.vo.UserVO;

/**
 * <pre>
 * org.dimigo.action
 *	 |_SignupAction
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 27.
 * </pre>
 * 
 * @author : Jeon
 * @version : 1.0
 */
public class SignupAction implements IAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dimigo.action.IAction#execute(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		try {
			response.setContentType("application/json;charset=utf-8");

			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			System.out.println(id + " " + pw + " " + name + " \n");

			UserVO user = new UserVO(id, pw, name);
			user.setId(id);
			user.setPw(pw);
			user.setName(name);


			UserService service = new UserService();
			service.signup(user);
			// id, pwd 사용자 인증 체크
			boolean result = true;

			if (result) {
				RequestDispatcher rd = request.getRequestDispatcher("jsp/main.jsp");
				rd.forward(request, response);
			} else {
				throw new Exception("회원 가입시 오류가 발생했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/signup.jsp");
			rd.forward(request, response);
		}
	}


}
