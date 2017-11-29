/**
 * 
 */
package org.dimigo.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dimigo.vo.BusIdVO;
import org.dimigo.vo.BusVO;
import org.dimigo.vo.TrainVO;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * <pre>
 * train
 * |_ Train
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 21.
 * </pre>
 *
 * @author : teacher
 * @version : 1.0
 */
public class BusId {
	
	public static List<BusIdVO> BusIdAPI(String terminalNm) throws Exception {
		
		String result = null;
		// URL생성
		try {
			String key = "NXoMXINxQHgYOmskZvj0l7J3irwacnpXkSWEuUfadgeHSgsP5RvbKjRHM%2FUBhVJ7HEtNgGerFddf8zx%2FjqJ5MQ%3D%3D";
			StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/ExpBusInfoService/getExpBusTrminlList"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + key); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("terminalNm","UTF-8") + "=" + URLEncoder.encode(terminalNm, "UTF-8")); /*역 이름*/
	         
	        System.out.println(urlBuilder);
	        
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        
	        result = sb.toString();
	        System.out.println(result);
	        System.out.println(getResult(result));
	        
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("검색 에러 발생");
		}
		
		return getResult(result);
     }
	
	private static List<BusIdVO> getResult(String result) throws Exception {
		// 파싱 부분
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document document = builder.parse(new InputSource(new StringReader(result)));
			
			NodeList numOfRows = document.getElementsByTagName("totalCount");
			Node rows = numOfRows.item(0);
			int cnt = Integer.parseInt(rows.getTextContent());
//			System.out.println(cnt);
			
			NodeList terminalid = document.getElementsByTagName("terminalId");
			NodeList terminalnm = document.getElementsByTagName("terminalNm");
			
			List<BusIdVO> list = new ArrayList<BusIdVO>();
			
			for (int i=0; i<cnt; i++) {			
				String f1 = terminalid.item(i).getTextContent();
				String f2 = terminalnm.item(i).getTextContent();
		
				BusIdVO vo = new BusIdVO(f1, f2);
				list.add(vo);
			}
			
			return list;
		
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("검색 결과가 없습니다.");
		}
		
	}

}
