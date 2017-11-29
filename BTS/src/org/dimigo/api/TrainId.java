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

import org.dimigo.vo.SubwayIdVO;
import org.dimigo.vo.SubwayVO;
import org.dimigo.vo.TrainIdVO;
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
public class TrainId {
	
	public static List<TrainIdVO> TrainIdAPI(String cityCode) {
		
		String result = null;
		// URL 생성
		try {
			String key = "NXoMXINxQHgYOmskZvj0l7J3irwacnpXkSWEuUfadgeHSgsP5RvbKjRHM%2FUBhVJ7HEtNgGerFddf8zx%2FjqJ5MQ%3D%3D";
			StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/TrainInfoService/getCtyAcctoTrainSttnList"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + key); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("cityCode","UTF-8") + "=" + URLEncoder.encode(cityCode, "UTF-8")); /*키워드*/
	        
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
		}
		
		return getResult(result);
     }
	
	private static List<TrainIdVO> getResult(String result) {
		// 파싱
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document document = builder.parse(new InputSource(new StringReader(result)));
			
			NodeList numOfRows = document.getElementsByTagName("numOfRows");
			Node rows = numOfRows.item(0);
			int cnt = Integer.parseInt(rows.getTextContent());
			System.out.println(cnt);
			
			NodeList nodeid = document.getElementsByTagName("nodeid");
			NodeList nodename = document.getElementsByTagName("nodename");
						
			List<TrainIdVO> list = new ArrayList<TrainIdVO>();
			
			for (int i=0; i<cnt; i++) {			
				String f1 = nodeid.item(i).getTextContent();
				String f2 = nodename.item(i).getTextContent();

				
				TrainIdVO vo = new TrainIdVO(f1, f2);
				
				list.add(vo);
			}
			
			return list;
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
