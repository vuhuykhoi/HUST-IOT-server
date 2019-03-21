package org.agriculture.demo.controller;

import org.agriculture.demo.services.PublishService;
import org.agriculture.demo.services.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeviceController {
	@Autowired
	private PublishService publishService = new PublishService();
	
	@Autowired
	private SubscribeService subscribeService = new SubscribeService();
	  
	@GetMapping("/control")
	public String controlDevice() {
		return "controlDevice";
	}
	
	@GetMapping("control/light/on")
	public String turnOnLight() {
		publishService.publishMessageOneTime("device/light","on");
		return "controlDevice";
	}
	
	@GetMapping("control/light/off")
	public String turnOffLight() {
		publishService.publishMessageOneTime("device/light","off");
		return "controlDevice";
	}
}
