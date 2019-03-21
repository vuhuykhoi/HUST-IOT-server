package org.agriculture.demo.services;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Service;

@Service
public class SubscribeService implements MqttCallback {
	/** The broker url. */
    private static final String brokerUrl = "tcp://iot.eclipse.org:1883";

    /** The client id. */
    private static final String clientId = "subscriber";

	public void subscribe(String topic) {

	        MemoryPersistence persistence = new MemoryPersistence();
	        try {

	            MqttClient sampleClient = new MqttClient(brokerUrl, clientId, persistence);
	            MqttConnectOptions connOpts = new MqttConnectOptions();
	            connOpts.setCleanSession(true);

	            System.out.println("checking");

	            System.out.println("Mqtt Connecting to broker: " + brokerUrl);
	            sampleClient.connect(connOpts);
	            System.out.println("Mqtt Connected");

	            sampleClient.setCallback(this);
	            sampleClient.subscribe(topic);

	            System.out.println("Subscribed");
	            System.out.println("Listening");

	        } catch (MqttException me) {

	            System.out.println("Mqtt reason " + me.getReasonCode());
	            System.out.println("Mqtt msg " + me.getMessage());
	            System.out.println("Mqtt loc " + me.getLocalizedMessage());
	            System.out.println("Mqtt cause " + me.getCause());
	            System.out.println("Mqtt excep " + me);
	        }
	    }

	@Override
	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// TODO Auto-generated method stub
		   System.out.println("Mqtt topic : " + topic);
	       System.out.println("Mqtt msg : " + message.toString());
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
	}

}
