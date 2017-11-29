/**
 * 
 */
package org.dimigo.vo;

/**
 * <pre>
 * org.dimigo.vo
 *	 |_SubwayVO
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 23.
 * </pre>
 * 
 * @author		: Jeon
 * @version		: 1.0
 */
public class SubwayVO {

 
	private String subwayStationNm;		/*지하철역 름*/
	private String dailyTypeCode;		/*요일코드*/
	private String upDownTypeCode;		/*상하행코드*/
	private String depTime;				/*출발시간*/
	private String arrTime;				/*도착시간*/
	private String endSubwayStationNm;	/*종점역이름*/
	
	/**
	 * @param subwayStationNm
	 * @param dailyTypeCode
	 * @param upDownTypeCode
	 * @param depTime
	 * @param arrTime
	 * @param endSubwayStationNm
	 */
	public SubwayVO(String subwayStationNm, String dailyTypeCode, String upDownTypeCode, String depTime, String arrTime,
			String endSubwayStationNm) {
		super();
		this.subwayStationNm = subwayStationNm;
		this.dailyTypeCode = dailyTypeCode;
		this.upDownTypeCode = upDownTypeCode;
		this.depTime = depTime;
		this.arrTime = arrTime;
		this.endSubwayStationNm = endSubwayStationNm;
	}

	public SubwayVO(){
		
	}
	
	/**
	 * @return the subwayStationNm
	 */
	public String getSubwayStationNm() {
		return subwayStationNm;
	}
	/**
	 * @param subwayStationNm the subwayStationNm to set
	 */
	public void setSubwayStationNm(String subwayStationNm) {
		this.subwayStationNm = subwayStationNm;
	}
	/**
	 * @return the dailyTypeCode
	 */
	public String getDailyTypeCode() {
		return dailyTypeCode;
	}
	/**
	 * @param dailyTypeCode the dailyTypeCode to set
	 */
	public void setDailyTypeCode(String dailyTypeCode) {
		this.dailyTypeCode = dailyTypeCode;
	}
	/**
	 * @return the upDownTypeCode
	 */
	public String getUpDownTypeCode() {
		return upDownTypeCode;
	}
	/**
	 * @param upDownTypeCode the upDownTypeCode to set
	 */
	public void setUpDownTypeCode(String upDownTypeCode) {
		this.upDownTypeCode = upDownTypeCode;
	}
	/**
	 * @return the depTime
	 */
	public String getDepTime() {
		return depTime;
	}
	/**
	 * @param depTime the depTime to set
	 */
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	/**
	 * @return the arrTime
	 */
	public String getArrTime() {
		return arrTime;
	}
	/**
	 * @param arrTime the arrTime to set
	 */
	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}
	/**
	 * @return the endSubwayStationNm
	 */
	public String getEndSubwayStationNm() {
		return endSubwayStationNm;
	}
	/**
	 * @param endSubwayStationNm the endSubwayStationNm to set
	 */
	public void setEndSubwayStationNm(String endSubwayStationNm) {
		this.endSubwayStationNm = endSubwayStationNm;
	}
	
	@Override
	public String toString() {
		return "지하철역명 : " + subwayStationNm + ", 상하행구분코드 : " + upDownTypeCode + ", 요일구분코드 : " + dailyTypeCode +
				", 출발시간 : " + arrTime + ", 도착시간  : " + depTime + ", 종점지하철명 : " + endSubwayStationNm +"\n";
	}	

	
}
