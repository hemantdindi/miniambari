package com.hemant.miniambari.pojo;

import java.util.List;

public class ServiceInfo {
	
	@Override
	public String toString() {
		return "ServiceInfo [serviceName=" + serviceName + ", serviceComponentInfo=" + serviceComponentInfo + "]";
	}
	public String serviceName;
	public List<ServiceComponentInfo> serviceComponentInfo;
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public List<ServiceComponentInfo> getServiceComponentInfo() {
		return serviceComponentInfo;
	}
	public void setServiceComponentInfo(List<ServiceComponentInfo> serviceComponentInfo) {
		this.serviceComponentInfo = serviceComponentInfo;
	}
	

}
