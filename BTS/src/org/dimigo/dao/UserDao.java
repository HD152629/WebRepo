/**
 * 
 */
package org.dimigo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.dimigo.vo.UserVO;

/**
 * <pre>
 * org.dimigo.dao
 *	 |_UserDao
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 25.
 * </pre>
 * 
 * @author : Jeon
 * @version : 1.0
 */
public class UserDao {

	private Connection conn = null;

	/**
	 * @param conn
	 */
	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public UserVO searchUser(UserVO vo) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM USER WHERE ID = ? and PW = ?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			System.out.println("searchUser id====>>>" + vo.getId());
			System.out.println("searchUser pw====>>>" + vo.getPw());
			System.out.println("searchUser name====>>>" + vo.getName());
			
			
			rs = pstmt.executeQuery();

			UserVO result = null;
			
			// 다음 줄 즉, DB에 찾아진게 있으면 실행
			if (rs.next()) {	
				result = new UserVO();
				result.setId(rs.getString(1));
				result.setPw(rs.getString(2));
				result.setName(rs.getString(3));
				System.out.println("rs.next ======>>>>>" + rs.getString(3));
			}

			
			System.out.println("searchUser result ===>>>>>> " + result);

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("사용자 조회 오류");
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}

	}
	
	public void insertUser(UserVO vo) throws Exception{
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO USER VALUES(?,?,?)";
		
		try{
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2,vo.getPw());
			pstmt.setString(3,vo.getName());
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt==0) throw new Exception("사용자 등록을 실패");	
			
		} catch(Exception e){
			e.printStackTrace();
			throw new Exception("사용자 조회시 오류 발생");
		} finally{
			if(pstmt != null) pstmt.close();
		}
		
		
		
	}
	
	

}
