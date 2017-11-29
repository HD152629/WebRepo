/**
 * 
 */
package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <pre>
 * org.dimigo.action
 *	 |_LogoutAction
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 26.
 * </pre>
 * 
 * @author :  Jeon
 * @version : 1.0
 */
public class LogoutAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();

		session.invalidate();

		RequestDispatcher rd = request.getRequestDispatcher("jsp/main.jsp");
		rd.forward(request, response);
	}

}
