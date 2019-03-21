package org.agriculture.demo.services;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;

import ch.qos.logback.classic.Logger;

public abstract class BaseService implements MqttCallback{
	private String broker =   "tcp://iot.eclipse.org:1883";
	
	MqttConnectOptions connOpts = new MqttConnectOptions();
	MqttClient mqttClient;
	private Logger logger;
	String subscribeTopic;
	
	BaseService(Logger log, String clienId, String subscribeTopic){
		
	}
}
