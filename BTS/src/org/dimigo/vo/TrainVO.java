/**
 * 
 */
package org.dimigo.vo;

/**
 * <pre>
 * org.dimigo.vo
 *	 |_TrainVO
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 22.
 * </pre>
 * 
 * @author		: Jeon
 * @version		: 1.0
 */
public class TrainVO {
	
	private String adultcharge;		/*운임*/
	private String arrplacename;	/*도착역이름*/
	private String arrplandtime;	/*도착시간*/
	private String depplacename;	/*출발역이름*/
	private String depplandtime;	/*출발시간*/	
	private String traingradename;	/*기차등급*/
	
	
	/**
	 * @param adultcharge
	 * @param arrplacename
	 * @param arrplandtime
	 * @param depplacename
	 * @param depplandtime
	 * @param traingradename
	 */
	public TrainVO(String adultcharge, String arrplacename, String arrplandtime, String depplacename,
			String depplandtime, String traingradename) {
		super();
		this.adultcharge = adultcharge;
		this.arrplacename = arrplacename;
		this.arrplandtime = arrplandtime;
		this.depplacename = depplacename;
		this.depplandtime = depplandtime;
		this.traingradename = traingradename;
	}
	
	/**
	 * 
	 */
	public TrainVO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the adultcharge
	 */
	public String getAdultcharge() {
		return adultcharge;
	}
	/**
	 * @param adultcharge the adultcharge to set
	 */
	public void setAdultcharge(String adultcharge) {
		this.adultcharge = adultcharge;
	}
	/**
	 * @return the arrplacename
	 */
	public String getArrplacename() {
		return arrplacename;
	}
	/**
	 * @param arrplacename the arrplacename to set
	 */
	public void setArrplacename(String arrplacename) {
		this.arrplacename = arrplacename;
	}
	/**
	 * @return the arrplandtime
	 */
	public String getArrplandtime() {
		return arrplandtime;
	}
	/**
	 * @param arrplandtime the arrplandtime to set
	 */
	public void setArrplandtime(String arrplandtime) {
		this.arrplandtime = arrplandtime;
	}
	/**
	 * @return the depplacename
	 */
	public String getDepplacename() {
		return depplacename;
	}
	/**
	 * @param depplacename the depplacename to set
	 */
	public void setDepplacename(String depplacename) {
		this.depplacename = depplacename;
	}
	/**
	 * @return the depplandtime
	 */
	public String getDepplandtime() {
		return depplandtime;
	}
	/**
	 * @param depplandtime the depplandtime to set
	 */
	public void setDepplandtime(String depplandtime) {
		this.depplandtime = depplandtime;
	}
	/**
	 * @return the traingradename
	 */
	public String getTraingradename() {
		return traingradename;
	}
	/**
	 * @param traingradename the traingradename to set
	 */
	public void setTraingradename(String traingradename) {
		this.traingradename = traingradename;
	}
	
	@Override
	public String toString() {
		return "차량종류 : " + traingradename + ", 출발시간 : " + depplandtime + ", 도착시간 : " + arrplandtime +
				", 출발지 : " + depplacename + "도착지 : " + arrplacename + ", 운임 : " + adultcharge +"\n";
	}	
//
//	@Override
//	public String toString() {
//		return "TrainVO [adultcharge=" + adultcharge + ", arrplacename=" + arrplacename + ", arrplandtime="
//				+ arrplandtime + ", depplacename=" + depplacename + ", depplandtime=" + depplandtime
//				+ ", traingradename=" + traingradename + "]";
//	}	

}
