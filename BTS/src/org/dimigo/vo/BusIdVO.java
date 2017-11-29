/**
 * 
 */
package org.dimigo.vo;

/**
 * <pre>
 * org.dimigo.vo
 *	 |_BusidVO
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 23.
 * </pre>
 * 
 * @author		: Jeon
 * @version		: 1.0
 */
public class BusIdVO {
	
	private String terminalId;	/*터미널 id*/
	private String terminalNm;	/*터미널 이름*/
	/**
	 * @param terminalId
	 * @param terminalNm
	 */
	public BusIdVO(String terminalId, String terminalNm) {
		super();
		this.terminalId = terminalId;
		this.terminalNm = terminalNm;
	}
	/**
	 * @return the terminalId
	 */
	public String getTerminalId() {
		return terminalId;
	}
	/**
	 * @param terminalId the terminalId to set
	 */
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	/**
	 * @return the terminalNm
	 */
	public String getTerminalNm() {
		return terminalNm;
	}
	/**
	 * @param terminalNm the terminalNm to set
	 */
	public void setTerminalNm(String terminalNm) {
		this.terminalNm = terminalNm;
	}
	
	@Override
	public String toString() {
		return "터미널ID : " + terminalId
				+ ", 터미널명 : " + terminalNm;
	}	
	



}
