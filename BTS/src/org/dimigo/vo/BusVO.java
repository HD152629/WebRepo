/**
 * 
 */
package org.dimigo.vo;

/**
 * <pre>
 * org.dimigo.vo
 *	 |_BusVO
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 23.
 * </pre>
 * 
 * @author		: Jeon
 * @version		: 1.0
 */
public class BusVO {
	
	private String gradeNm;			/*버스등급*/
	private String depPlandTime;	/*출발시간*/
	private String arrPlandTime;	/*도착시간*/
	private String depPlaceNm;		/*출발정류장이름*/
	private String arrplaceNm;		/*도착정류장이름*/
	private String Charge;			/*운임*/	
	
	/**
	 * @param gradeNm
	 * @param depPlandTime
	 * @param arrPlandTime
	 * @param depPlaceNm
	 * @param arrplaceNm
	 * @param charge
	 */
	public BusVO(String gradeNm, String depPlandTime, String arrPlandTime, String depPlaceNm, String arrplaceNm,
			String charge) {
		super();
		this.gradeNm = gradeNm;
		this.depPlandTime = depPlandTime;
		this.arrPlandTime = arrPlandTime;
		this.depPlaceNm = depPlaceNm;
		this.arrplaceNm = arrplaceNm;
		this.Charge = charge;
	}
	
	/**
	 * @return the gradeNm
	 */
	public String getGradeNm() {
		return gradeNm;
	}
	/**
	 * @param gradeNm the gradeNm to set
	 */
	public void setGradeNm(String gradeNm) {
		this.gradeNm = gradeNm;
	}
	/**
	 * @return the depPlandTime
	 */
	public String getDepPlandTime() {
		return depPlandTime;
	}
	/**
	 * @param depPlandTime the depPlandTime to set
	 */
	public void setDepPlandTime(String depPlandTime) {
		this.depPlandTime = depPlandTime;
	}
	/**
	 * @return the arrPlandTime
	 */
	public String getArrPlandTime() {
		return arrPlandTime;
	}
	/**
	 * @param arrPlandTime the arrPlandTime to set
	 */
	public void setArrPlandTime(String arrPlandTime) {
		this.arrPlandTime = arrPlandTime;
	}
	/**
	 * @return the depPlaceNm
	 */
	public String getDepPlaceNm() {
		return depPlaceNm;
	}
	/**
	 * @param depPlaceNm the depPlaceNm to set
	 */
	public void setDepPlaceNm(String depPlaceNm) {
		this.depPlaceNm = depPlaceNm;
	}
	/**
	 * @return the arrplaceNm
	 */
	public String getArrplaceNm() {
		return arrplaceNm;
	}
	/**
	 * @param arrplaceNm the arrplaceNm to set
	 */
	public void setArrplaceNm(String arrplaceNm) {
		this.arrplaceNm = arrplaceNm;
	}
	/**
	 * @return the charge
	 */
	public String getCharge() {
		return Charge;
	}
	/**
	 * @param charge the charge to set
	 */
	public void setCharge(String charge) {
		Charge = charge;
	}
	
	@Override
	public String toString() {
		return "버스등급 : " + gradeNm 
				+ ", 출발시간 : " + depPlandTime
				+ ", 도착시간 : " + arrPlandTime
				+ ", 출발지 : " + depPlaceNm
				+ ", 도착지  : " + arrplaceNm
				+ ", 운임 : " + Charge +"\n";
	}	

	

}
