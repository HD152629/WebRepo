/**
 * 
 */
package org.dimigo.service;

import java.sql.Connection;

import org.dimigo.dao.UserDao;
import org.dimigo.vo.UserVO;

/**
 * <pre>
 * org.dimigo.service
 *	 |_UserService
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 25.
 * </pre>
 * 
 * @author : Jeon
 * @version : 1.0
 */
public class UserService extends AbstractService {


	public UserVO login(UserVO user) throws Exception {

		Connection conn = null;

		try {
			conn = getConnection();

			UserDao dao = new UserDao(conn);
			// 사용중인 아이디인지 체크
			UserVO result = dao.searchUser(user);
			
			System.out.println("result in UserSerivce =====>>>" + result);

			return result;
			
		} finally {
			if (conn != null)
				conn.close();
		}


	}

	public UserVO signup(UserVO user) throws Exception {
		// DB에 사용자 등록
		Connection conn = null;
		try {
			conn = getConnection();

			UserDao dao = new UserDao(conn);
			UserVO result = dao.searchUser(user);

			if (result != null) {
				throw new Exception("이미 사용중인 아이디입니다.");
			}

			dao.insertUser(user);

		} finally {
			if (conn != null)
				conn.close();
		}
		return user;
	}

}
