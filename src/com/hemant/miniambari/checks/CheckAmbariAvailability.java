package com.hemant.miniambari.checks;

import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;

import com.hemant.miniambari.conf.ReadConfiguration;

public class CheckAmbariAvailability {

	int status;

	public int sendAmbariState() {

		ReadConfiguration readConf = new ReadConfiguration();

		try {
			//String link = "http://" + readConf.getAmbariHost().trim() + ":" + readConf.getAmbariPort().trim()
			//		+ "/api/v1/clusters/" + readConf.getAmbariClusterName() + "/hosts";
			String link = "http://" + readConf.getAmbariHost().trim() + ":" + readConf.getAmbariPort().trim() + "/api/v1/";
			URL url = new URL(link);

			String authStr = readConf.getAmbariAdminUsr().trim() + ":" + readConf.getAmbariAdminPwd().trim();

			String authEncoded = Base64.encodeBase64String(authStr.getBytes());

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Authorization", "Basic " + authEncoded);
			connection.setRequestProperty("X-Requested-By", "ambari");

			if (connection.getResponseCode() != 200)
				status = 0;
			else
				status = 1;

		} catch (Exception ex) {
			status = 9;
			ex.printStackTrace();
		}
		return status;
	}
}
