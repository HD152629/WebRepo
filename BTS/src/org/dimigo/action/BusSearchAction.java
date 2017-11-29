/**
 * 
 */
package org.dimigo.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.api.BusId;
import org.dimigo.api.Train;
import org.dimigo.vo.BusIdVO;
import org.dimigo.vo.TrainVO;

/**
 * <pre>
 * org.dimigo.action
 *	 |_BusSearchAction
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 23.
 * </pre>
 * 
 * @author : Jeon
 * @version : 1.0
 */
public class BusSearchAction implements IAction {

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

			// 터미널 이름 받기
			String terminalNm = request.getParameter("terminalNm");

			// 값 리스트에 담기
			List<BusIdVO> busidresult = BusId.BusIdAPI(terminalNm);

			System.out.println(busidresult); // 파싱값 출력 toString

			if (busidresult != null) {
				
				request.setAttribute("idresult", busidresult);
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/bus.jsp");
				rd.forward(request, response);
				
			} else {
				System.out.println("에러발생, 에러발생");
				throw new Exception("검색 결과가 없습니다");	
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error2", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/bus.jsp");
			rd.forward(request, response);
		}

	}

}
