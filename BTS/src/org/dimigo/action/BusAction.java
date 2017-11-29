/**
 * 
 */
package org.dimigo.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.api.Bus;
import org.dimigo.api.Subway;
import org.dimigo.vo.BusVO;
import org.dimigo.vo.SubwayVO;

/**
 * <pre>
 * org.dimigo.action
 *	 |_BusAction
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 23.
 * </pre>
 * 
 * @author		: Jeon
 * @version		: 1.0
 */
public class BusAction implements IAction{

	/* (non-Javadoc)ㅇ
	 * @see org.dimigo.action.IAction#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();

			request.setCharacterEncoding("utf-8");

			String depTerminalId = request.getParameter("depTerminalId");
			String arrTerminalId = request.getParameter("arrTerminalId");
			String depPlandTime = request.getParameter("depPlandTime");

			List<BusVO> busresult = Bus.BusAPI(depTerminalId,arrTerminalId,depPlandTime);
			System.out.println(busresult);
			
			if(busresult!=null){
				
				request.setAttribute("list", busresult);				
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/bus.jsp");
				rd.forward(request, response);
				
			}else{
				System.out.println("에러발생, 에러발생");
				throw new Exception("검색 결과가 없습니다");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/bus.jsp");
			rd.forward(request, response);
			
		}
	}

}
