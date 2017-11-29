/**
 * 
 */
package org.dimigo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 * org.dimigo.action
 *	 |_iAction
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 21.
 * </pre>
 * 
 * @author		: Jeon
 * @version		: 1.0
 */
public interface IAction {
	
	void execute(HttpServletRequest request, HttpServletResponse response)throws Exception;

	
}
