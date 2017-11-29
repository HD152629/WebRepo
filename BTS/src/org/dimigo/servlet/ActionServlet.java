package org.dimigo.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dimigo.action.BusAction;
import org.dimigo.action.BusSearchAction;
import org.dimigo.action.IAction;
import org.dimigo.action.LoginAction;
import org.dimigo.action.LogoutAction;
import org.dimigo.action.SignupAction;
import org.dimigo.action.TrainAction;
import org.dimigo.action.TrainSearchAction;
import org.dimigo.action.SubwaySearchAction;
import org.dimigo.action.SubwayAction;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, IAction> actions = new HashMap<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException{
    	actions.put("train", new TrainAction());
    	actions.put("trainsearch", new TrainSearchAction());
    	actions.put("subway", new SubwayAction());
    	actions.put("subwaysearch", new SubwaySearchAction());
    	actions.put("bus", new BusAction());
    	actions.put("bussearch", new BusSearchAction());
    	actions.put("login", new LoginAction());
    	actions.put("logout", new LogoutAction());
    	actions.put("signup", new SignupAction());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String uri = request.getRequestURI();
			String actionName = uri.substring(uri.lastIndexOf("/") + 1);
			System.out.println("uri : " + uri);
			actionName = actionName.substring(0, actionName.lastIndexOf("."));
			System.out.println("uri : " + actionName);

			IAction action = actions.get(actionName);
			if (action == null) {
				throw new Exception(actionName + "에 해당하는 ActionClass가 없습니다.");

			}
			action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/error.jsp");
			rd.forward(request, response);
		}

	}
	
	

}
