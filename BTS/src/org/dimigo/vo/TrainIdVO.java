/**
 * 
 */
package org.dimigo.vo;

/**
 * <pre>
 * org.dimigo.vo
 *	 |_TrainIdVO
 * 
 * 1. 개요:
 * 2. 작성일 : 2017. 11. 24.
 * </pre>
 * 
 * @author		: Jeon
 * @version		: 1.0
 */
public class TrainIdVO {
	
	private String nodeId;		/*기차역ID*/
	private String nodeName;	/*기차역이름*/
	
	/**
	 * @param nodeId
	 * @param nodeName
	 */
	public TrainIdVO(String nodeId, String nodeName) {
		super();
		this.nodeId = nodeId;
		this.nodeName = nodeName;
	}
	
	/**
	 * @return the nodeId
	 */
	public String getNodeId() {
		return nodeId;
	}
	/**
	 * @param nodeId the nodeId to set
	 */
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	/**
	 * @return the nodeName
	 */
	public String getNodeName() {
		return nodeName;
	}

	/**
	 * @param nodeName the nodeName to set
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
	@Override
	public String toString() {
		return "기차역ID : " + nodeId
				+ ", 기차역명 : " + nodeName;
	}


}
