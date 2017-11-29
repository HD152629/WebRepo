/**
 * 
 */
package org.dimigo.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.api.*;
import org.dimigo.vo.TrainVO;

/**
 * <pre>
 * org.dimigo.api
 *	 |_subwayAPI
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 19.
 * </pre>
 * 
 * @author : Jeon
 * @version : 1.0
 */
public class TrainAction implements IAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dimigo.action.iAction#execute(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {

			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();

			request.setCharacterEncoding("utf-8");
			
			// 출발, 도착역, 출발일
			String leavestation = request.getParameter("leavestation");
			String arrivestation = request.getParameter("arrivestation");
			String departdate = request.getParameter("departdate");
			
			// 리스트에 담기
			List<TrainVO> trainresult = Train.trainAPI(leavestation, arrivestation, departdate);
			
			request.setAttribute("list", trainresult);
			
			System.out.println(trainresult); // 파싱값 출력 toString

			RequestDispatcher rd = request.getRequestDispatcher("jsp/train.jsp");
			rd.forward(request, response);

		} catch (Exception e) {

		}

	}

}
