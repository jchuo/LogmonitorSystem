package com.anchora.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class ElasticsearchClient {

	private static TransportClient client = null;

	@SuppressWarnings({ "resource", "unchecked" })
	public TransportClient getClient() {
		if (client == null) {
			synchronized (client) {
				if (client == null) {
					try {
						client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(
								new InetSocketTransportAddress(InetAddress.getByName("host2"), 9300));
					} catch (UnknownHostException e) {
						client.close();
						e.printStackTrace();
					}
					return client;
				}
				return client;
			}
		} else {
			return client;
		}
	}

}
