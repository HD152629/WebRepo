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
public class Train {
	
	public static List<TrainVO> trainAPI(String leavestation, String arrivestation, String departdate) {
		
		String result = null;
		// URL 생성
		try {
			String key = "NXoMXINxQHgYOmskZvj0l7J3irwacnpXkSWEuUfadgeHSgsP5RvbKjRHM%2FUBhVJ7HEtNgGerFddf8zx%2FjqJ5MQ%3D%3D";
			StringBuilder urlBuilder = new StringBuilder("http://openapi.tago.go.kr/openapi/service/TrainInfoService/getStrtpntAlocFndTrainInfo"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + key); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("depPlaceId","UTF-8") + "=" + URLEncoder.encode(leavestation, "UTF-8")); /*출발기차역ID*/
	        urlBuilder.append("&" + URLEncoder.encode("arrPlaceId","UTF-8") + "=" + URLEncoder.encode(arrivestation, "UTF-8")); /*도착기차역ID*/
	        urlBuilder.append("&" + URLEncoder.encode("depPlandTime","UTF-8") + "=" + URLEncoder.encode(departdate, "UTF-8")); /*출발일*/
	        urlBuilder.append("&" + URLEncoder.encode("trainGradeCode","UTF-8") + "=" + URLEncoder.encode("00", "UTF-8")); /*차량종류(KTX,무궁화)*/
	        
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
	
	private static List<TrainVO> getResult(String result) {
		// 파싱
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document document = builder.parse(new InputSource(new StringReader(result)));
			
			NodeList numOfRows = document.getElementsByTagName("numOfRows");
			Node rows = numOfRows.item(0);
			int cnt = Integer.parseInt(rows.getTextContent());
//			System.out.println(cnt);
			
			NodeList adultcharge = document.getElementsByTagName("adultcharge");
			NodeList arrplacename = document.getElementsByTagName("arrplacename");
			NodeList arrplandtime = document.getElementsByTagName("arrplandtime");
			NodeList depplacename = document.getElementsByTagName("depplacename");
			NodeList depplandtime = document.getElementsByTagName("depplandtime");
			NodeList traingradename = document.getElementsByTagName("traingradename");
			List<TrainVO> list = new ArrayList<TrainVO>();
			
			for (int i=0; i<cnt; i++) {			
				String f1 = adultcharge.item(i).getTextContent();
				String f2 = arrplacename.item(i).getTextContent();
				String f3 = arrplandtime.item(i).getTextContent();
				String f4 = depplacename.item(i).getTextContent();
				String f5 = depplandtime.item(i).getTextContent();
				String f6 = traingradename.item(i).getTextContent();
				
				TrainVO vo = new TrainVO(f1, f2, f3, f4, f5, f6);
				list.add(vo);
			}
			
			return list;
		
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return null;
	}

}
