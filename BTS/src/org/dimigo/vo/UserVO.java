/**
 * 
 */
package org.dimigo.vo;

/**
 * <pre>
 * org.dimigo.vo
 *	 |_UserVO
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 25.
 * </pre>
 * 
 * @author : Jeon
 * @version : 1.0
 */
public class UserVO {

	private String id;
	private String pw;
	private String name;

	@Override
	public String toString() {
		return "아이디 : " + id + ", 비밀번호 : " + pw + ", 이름 : " + name + "\n";
	}



	/**
	 * @param id
	 * @param pw
	 * @param name
	 */
	public UserVO(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	/**
	 * 
	 */
	public UserVO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the pw
	 */
	public String getPw() {
		return pw;
	}

	/**
	 * @param pw
	 *            the pw to set
	 */
	public void setPw(String pw) {
		this.pw = pw;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}
