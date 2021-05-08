package tn.esprit.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import tn.esprit.spring.service.SendSmsService;

@Controller
@RequestMapping("SmsAPi")
public class SmsController {
	
	@Autowired
	SendSmsService sms_serv;
	@RequestMapping("/sendsms")
	public String sendsms(@RequestParam("body") String body,@RequestParam("to") String to){
		return sms_serv.sendsms(body,to);
	}
	

}
