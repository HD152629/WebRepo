/**
 * 
 */
package org.dimigo.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.api.SubwayId;
import org.dimigo.api.TrainId;
import org.dimigo.vo.SubwayIdVO;
import org.dimigo.vo.TrainIdVO;

/**
 * <pre>
 * org.dimigo.action
 *	 |_TrainSearchAction
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 24.
 * </pre>
 * 
 * @author : Jeon
 * @version : 1.0
 */
public class TrainSearchAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();

			request.setCharacterEncoding("utf-8");
			
			// 도시코드 
			String cityCode = request.getParameter("cityCode");
			
			System.out.println(cityCode);
			
			// 리스트에 담기
			List<TrainIdVO> trainidresult = TrainId.TrainIdAPI(cityCode);

			request.setAttribute("idresult", trainidresult);

			System.out.println(trainidresult);

			RequestDispatcher rd = request.getRequestDispatcher("jsp/train.jsp");
			rd.forward(request, response);

		} catch (Exception e) {

		}

	}

}
