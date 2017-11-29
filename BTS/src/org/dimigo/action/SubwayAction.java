/**
 * 
 */
package org.dimigo.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.api.Subway;
import org.dimigo.api.Train;
import org.dimigo.vo.SubwayVO;
import org.dimigo.vo.TrainVO;

/**
 * <pre>
 * org.dimigo.action
 *	 |_SubwayAction
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 23.
 * </pre>
 * 
 * @author : Jeon
 * @version : 1.0
 */
public class SubwayAction implements IAction {

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

			// 지하철역ID, 요일코드, 상하행코드
			String subwayStationId = request.getParameter("subwayStationId");
			String dailyTypeCode = request.getParameter("dailyTypeCode");
			String upDownTypeCode = request.getParameter("upDownTypeCode");

			System.out.println(subwayStationId + " " + dailyTypeCode + " " + upDownTypeCode);

			List<SubwayVO> subwayresult = Subway.SubwayAPI(subwayStationId, dailyTypeCode, upDownTypeCode);
			System.out.println(subwayresult);

			if (subwayresult != null) {

				request.setAttribute("list", subwayresult);

				RequestDispatcher rd = request.getRequestDispatcher("jsp/subway.jsp");
				rd.forward(request, response);

			} else {
				System.out.println("에러발생, 에러발생");
				throw new Exception("검색 결과가 없습니다");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/subway.jsp");
			rd.forward(request, response);

		}
	}

}
