package com.hemant.miniambari.api;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.apache.commons.codec.binary.Base64;


import com.hemant.miniambari.conf.ReadConfiguration;
import com.hemant.miniambari.pojo.ServiceComponentInfo;

public class CheckServiceState {
	
	List<ServiceComponentInfo> listServiceComponentInfo;
	
	public List<ServiceComponentInfo> checkServiceState(String ambariService) {
		
		ReadConfiguration readConf = new ReadConfiguration();		
		AllAmbari allAmbari = new AllAmbari();	
		
		
		List<String> componentList = allAmbari.getAmbariServiceComponentList(ambariService);
		listServiceComponentInfo = new ArrayList<ServiceComponentInfo>();
		for(String componentName: componentList){
			ServiceComponentInfo serviceComponentInfo = new ServiceComponentInfo();
			serviceComponentInfo.setComponentName(componentName);
			
			try {		
				String link = "http://" + readConf.getAmbariHost().trim() + ":" + readConf.getAmbariPort().trim() + "/api/v1/clusters/"+readConf.getAmbariClusterName()
				+"/services/"
				+ ambariService
				+ "/components/"
				+ componentName
				+ "?fields=ServiceComponentInfo/started_count,ServiceComponentInfo/total_count,ServiceComponentInfo/state";				
				URL url = new URL(link);				
				String authStr = readConf.getAmbariAdminUsr().trim() + ":" + readConf.getAmbariAdminPwd().trim();
				String authEncoded = Base64.encodeBase64String(authStr.getBytes());
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.setRequestProperty("Authorization", "Basic " + authEncoded);
				connection.setRequestProperty("X-Requested-By", "ambari");				
				if (connection.getResponseCode() != 200) {
					System.out.println("no hello " + connection.getResponseCode() + "   " + link );
	            } else {
	                InputStreamReader istr = new InputStreamReader((connection.getInputStream()));
	                JsonReader jsonReader = Json.createReader(istr);
	                JsonObject jsonObject   = jsonReader.readObject() ; 
	                JsonObject jsonSCObject  = jsonObject.getJsonObject("ServiceComponentInfo");
	                int started_count = jsonSCObject.getInt("started_count");
	                int total_count = jsonSCObject.getInt("total_count");
	                serviceComponentInfo.setStarted_count(started_count);
	                serviceComponentInfo.setTotal_count(total_count);
	                serviceComponentInfo.setUnknown_count(total_count-started_count);  
	            }
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			listServiceComponentInfo.add(serviceComponentInfo);
			
		}
		return listServiceComponentInfo;
	}
}
