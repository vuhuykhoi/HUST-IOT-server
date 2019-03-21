package org.agriculture.demo.services;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Service;

@Service
public class PublishService {
	
      int qos = 2;
      String broker =   "tcp://iot.eclipse.org:1883";
      String clientId = "publisher";
      MemoryPersistence persistence = new MemoryPersistence();
      
      public void publishMessageOneTime(String topic, String content) {
    	  try {
   
	          MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
	          MqttConnectOptions connOpts = new MqttConnectOptions();
	          connOpts.setCleanSession(true);
	          System.out.println("Connecting to broker: " + broker);
	          sampleClient.connect(connOpts);
	          System.out.println("Connected");
	          System.out.println("Publishing message: " + content);
	          MqttMessage message = new MqttMessage(content.getBytes());
	          message.setQos(qos);
	          sampleClient.publish(topic, message);
	          System.out.println("Message published");
	          sampleClient.disconnect();
	          System.out.println("Disconnected");
                      
          } catch (MqttException me) {
	          System.out.println("reason " + me.getReasonCode());
	          System.out.println("msg " + me.getMessage());
	          System.out.println("loc " + me.getLocalizedMessage());
	          System.out.println("cause " + me.getCause());
	          System.out.println("excep " + me);
	          me.printStackTrace();    
          }
      }
      
      public void publishMessageByCycle() {
    	  
      }
      public void publishAsyncMessage() {
    	  
      }
}

