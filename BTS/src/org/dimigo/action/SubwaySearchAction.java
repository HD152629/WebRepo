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
import org.dimigo.api.SubwayId;
import org.dimigo.api.TrainId;
import org.dimigo.vo.SubwayIdVO;
import org.dimigo.vo.SubwayVO;
import org.dimigo.vo.TrainIdVO;

/**
 * <pre>
 * org.dimigo.action
 *	 |_StationSearch
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 23.
 * </pre>
 * 
 * @author : Jeon
 * @version : 1.0
 */
public class SubwaySearchAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();

			request.setCharacterEncoding("utf-8");

			// 지하펄역 키워드
			String subwayStationName = request.getParameter("subwayStationName");

			// id리스트 에 값 담기
			List<SubwayIdVO> subwayidresult = SubwayId.SubwayIdAPI(subwayStationName);
			System.out.println(subwayidresult);

			if (subwayidresult != null) {
				
				request.setAttribute("idresult", subwayidresult);


				RequestDispatcher rd = request.getRequestDispatcher("jsp/subway.jsp");
				rd.forward(request, response);

			} else{
				System.out.println("에러발생, 에러발생");
				throw new Exception("검색 결과가 없습니다");
			}

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("error2", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/subway.jsp");
			rd.forward(request, response);

		}
	}

}
