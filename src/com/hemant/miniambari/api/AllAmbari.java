package com.hemant.miniambari.api;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import javax.json.Json              ;
import javax.json.JsonArray         ;
import javax.json.JsonObject        ;
import javax.json.JsonReader        ;

import com.hemant.miniambari.conf.ReadConfiguration;

public class AllAmbari {
	
	
	public static void main(String []args) {
	}
	
	public List<String> getAmbariHostList(){
		
		ReadConfiguration readConf = new ReadConfiguration();
		List<String> hostList = new ArrayList<String>();
		
		try {		
			String link = "http://" + readConf.getAmbariHost().trim() + ":" + readConf.getAmbariPort().trim() + "/api/v1/clusters/"+readConf.getAmbariClusterName()+"/hosts";
			URL url = new URL(link);
			
			String authStr = readConf.getAmbariAdminUsr().trim() + ":" + readConf.getAmbariAdminPwd().trim();

			String authEncoded = Base64.encodeBase64String(authStr.getBytes());

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Authorization", "Basic " + authEncoded);
			connection.setRequestProperty("X-Requested-By", "ambari");
			
			if (connection.getResponseCode() != 200) {
                //Update the Logger
				System.out.println("no hello " + connection.getResponseCode() + "   " + link );
            } else {

                InputStreamReader istr = new InputStreamReader((connection.getInputStream()));
                JsonReader jsonReader = Json.createReader(istr);
                JsonObject jsonObject   = jsonReader.readObject() ; 
                JsonArray itemsArray = jsonObject.getJsonArray("items");
                
                for (int hosts = 0; hosts < itemsArray.size(); hosts++) {
                	hostList.add((itemsArray.getJsonObject(hosts).getJsonObject("Hosts").getString("host_name")));
                }
            }
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return hostList;
	}
	
	public List<String> getAmbariServiceList(){
		
		List<String> serviceList = new ArrayList<String>();
		ReadConfiguration readConf = new ReadConfiguration();
		
		try {		
			String link = "http://" + readConf.getAmbariHost().trim() + ":" + readConf.getAmbariPort().trim() + "/api/v1/clusters/"+readConf.getAmbariClusterName()+"/services";
			URL url = new URL(link);
			
			String authStr = readConf.getAmbariAdminUsr().trim() + ":" + readConf.getAmbariAdminPwd().trim();

			String authEncoded = Base64.encodeBase64String(authStr.getBytes());

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Authorization", "Basic " + authEncoded);
			connection.setRequestProperty("X-Requested-By", "ambari");
			
			if (connection.getResponseCode() != 200) {
                //Update the Logger
				System.out.println("no hello " + connection.getResponseCode() + "   " + link );
            } else {

                InputStreamReader istr = new InputStreamReader((connection.getInputStream()));
                JsonReader jsonReader = Json.createReader(istr);
                JsonObject jsonObject   = jsonReader.readObject() ; 
                JsonArray itemsArray = jsonObject.getJsonArray("items");
                
                for (int hosts = 0; hosts < itemsArray.size(); hosts++) {
                	serviceList.add((itemsArray.getJsonObject(hosts).getJsonObject("ServiceInfo").getString("service_name")));
                }
            }
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return serviceList;
	}
	
	public List<String> getAmbariServiceComponentList(String service){
		List<String> serviceComponentList = new ArrayList<String>();
		ReadConfiguration readConf = new ReadConfiguration();
		
		try {		
			String link = "http://" + readConf.getAmbariHost().trim() + ":" + readConf.getAmbariPort().trim() + "/api/v1/clusters/"+readConf.getAmbariClusterName()+"/services/" + service.trim() + "/components";
			URL url = new URL(link);
			
			String authStr = readConf.getAmbariAdminUsr().trim() + ":" + readConf.getAmbariAdminPwd().trim();

			String authEncoded = Base64.encodeBase64String(authStr.getBytes());

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Authorization", "Basic " + authEncoded);
			connection.setRequestProperty("X-Requested-By", "ambari");
			
			if (connection.getResponseCode() != 200) {
                //Update the Logger
				System.out.println("no hello " + connection.getResponseCode() + "   " + link );
            } else {

                InputStreamReader istr = new InputStreamReader((connection.getInputStream()));
                JsonReader jsonReader = Json.createReader(istr);
                JsonObject jsonObject   = jsonReader.readObject() ; 
                JsonArray itemsArray = jsonObject.getJsonArray("items");
                
                for (int hosts = 0; hosts < itemsArray.size(); hosts++) {
                	serviceComponentList.add((itemsArray.getJsonObject(hosts).getJsonObject("ServiceComponentInfo").getString("component_name")));
                }
            }
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return serviceComponentList;
	}
	
}
	
