/**
 * 
 */
package org.dimigo.vo;

/**
 * <pre>
 * org.dimigo.vo
 *	 |_SubwayIdVO
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 24.
 * </pre>
 * 
 * @author		: Jeon
 * @version		: 1.0
 */
public class SubwayIdVO {
	
	private String subwayStationId;		/*지하철역 ID*/
	private String subwayStationName;	/*지하철역 이름*/
	
	/**
	 * @param subwayStationId
	 * @param subwayStationName
	 */
	public SubwayIdVO(String subwayStationId, String subwayStationName) {
		super();
		this.subwayStationId = subwayStationId;
		this.subwayStationName = subwayStationName;
	}
	
	/**
	 * @return the subwayStationId
	 */
	public String getSubwayStationId() {
		return subwayStationId;
	}
	/**
	 * @param subwayStationId the subwayStationId to set
	 */
	public void setSubwayStationId(String subwayStationId) {
		this.subwayStationId = subwayStationId;
	}
	/**
	 * @return the subwayStationName
	 */
	public String getSubwayStationName() {
		return subwayStationName;
	}
	/**
	 * @param subwayStationName the subwayStationName to set
	 */
	public void setSubwayStationName(String subwayStationName) {
		this.subwayStationName = subwayStationName;
	}
	
	@Override
	public String toString() {
		return "지하철역ID : " + subwayStationId
				+ ", 지하철역명 : " + subwayStationName;
	}


	

}
