package com.hemant.miniambari.pojo;

import java.util.ArrayList;
import java.util.List;

import com.hemant.miniambari.api.AllAmbari;
import com.hemant.miniambari.api.CheckServiceState;

public class AmbariMetrics {
	
	public List<ServiceInfo> getServicesInfo(){
		
		CheckServiceState checkServiceState = new CheckServiceState();
	
		List<ServiceInfo> serviceInfoList = new ArrayList<ServiceInfo>();
		List<String> ambariServiceList = new ArrayList<String>();
		
		AllAmbari allAmbari = new AllAmbari();
		ambariServiceList = allAmbari.getAmbariServiceList();
		
		for(String ambariService: ambariServiceList) {
			ServiceInfo serviceInfo = new ServiceInfo();
			serviceInfo.setServiceName(ambariService);
			serviceInfo.setServiceComponentInfo(checkServiceState.checkServiceState(ambariService));
			serviceInfoList.add(serviceInfo);
		}
		return serviceInfoList;
	}

}
