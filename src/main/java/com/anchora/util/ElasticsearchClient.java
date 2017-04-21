package com.anchora.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class ElasticsearchClient {
//	private static Logger logger = Logger.getLogger(ElasticsearchClient.class);

	private static TransportClient client = null;

	@SuppressWarnings({ "resource", "unchecked" })
	public static TransportClient getClient() {
		if (client == null) {
			synchronized (client) {
				if (client == null) {
					try {
//						logger.info("try connect to elasticsearch client........");
						System.out.println("try connect to elasticsearch client........");
						client = new PreBuiltTransportClient(Settings.EMPTY)
								.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.7.251"), 9200));
					} catch (UnknownHostException e) {
						client.close();
//						logger.error(e.getMessage());
						System.out.println(e.getMessage());
					}
//					logger.info("connect to elasticsearch client success..");
					System.out.println("connect to elasticsearch client success..");
					return client;
				}
				return client;
			}
		} else {
			return client;
		}
	}

}
