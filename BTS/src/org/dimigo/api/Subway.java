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

import org.dimigo.vo.SubwayVO;
import org.dimigo.vo.TrainVO;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * <pre>
 * Subway
 * |_ Subway
 * 
 * 1. 개요 : 
 * 2. 작성일 : 2017. 11. 21.
 * </pre>
 *
 * @author : teacher
 * @version : 1.0
 */
public class Subway {
	
	public static List<SubwayVO> SubwayAPI(String subwayStation, String dailyTypeCode, String upDownTypeCode) throws Exception {
		
		String result = null;
		// URL 생성
		try {
			String key = "NXoMXINxQHgYOmskZvj0l7J3irwacnpXkSWEuUfadgeHSgsP5RvbKjRHM%2FUBhVJ7HEtNgGerFddf8zx%2FjqJ5MQ%3D%3D";
			StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/SubwayInfoService/getSubwaySttnAcctoSchdulList"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + key); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("subwayStationId","UTF-8") + "=" + URLEncoder.encode(subwayStation, "UTF-8")); /*지하철역ID*/
	        urlBuilder.append("&" + URLEncoder.encode("dailyTypeCode","UTF-8") + "=" + URLEncoder.encode(dailyTypeCode, "UTF-8")); /*요일구분코드*/
	        urlBuilder.append("&" + URLEncoder.encode("upDownTypeCode","UTF-8") + "=" + URLEncoder.encode(upDownTypeCode, "UTF-8")); /*상하행구분코드*/
	        
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
	
	private static List<SubwayVO> getResult(String result) throws Exception {
		// 파싱 부분
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document document = builder.parse(new InputSource(new StringReader(result)));
			
			NodeList numOfRows = document.getElementsByTagName("numOfRows");
			Node rows = numOfRows.item(0);
			int cnt = Integer.parseInt(rows.getTextContent());
			System.out.println(cnt);
			
			NodeList subwayStationNm = document.getElementsByTagName("subwayStationNm");
			NodeList dailyTypeCode = document.getElementsByTagName("dailyTypeCode");
			NodeList upDownTypeCode = document.getElementsByTagName("upDownTypeCode");
			NodeList depTime = document.getElementsByTagName("depTime");
			NodeList arrTime = document.getElementsByTagName("arrTime");
			NodeList endSubwayStationNm = document.getElementsByTagName("endSubwayStationNm");
			
			List<SubwayVO> list = new ArrayList<SubwayVO>();
			
			for (int i=0; i<cnt; i++) {			
				String f1 = subwayStationNm.item(i).getTextContent();
				String f2 = dailyTypeCode.item(i).getTextContent();
				String f3 = upDownTypeCode.item(i).getTextContent();
				String f4 = depTime.item(i).getTextContent();
				String f5 = arrTime.item(i).getTextContent();
				String f6 = endSubwayStationNm.item(i).getTextContent();
				
				SubwayVO vo = new SubwayVO(f1, f2, f3, f4, f5, f6);
				list.add(vo);
			}
			
			return list;
		
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("검색 결과가 없습니다.");
		}
		
	}

}
