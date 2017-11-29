/**
 * 
 */
package org.dimigo.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 * org.dimigo.api
 *	 |_ApiAction
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 28.
 * </pre>
 * 
 * @author : Jeon
 * @version : 1.0
 */
public interface ApiAction {
	
	void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
