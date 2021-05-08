package tn.esprit.spring.service;

import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SendSmsService {

	public String sendsms(String body,String to){
		   System.err.println("Hani hne :p ");
		Twilio.init("AC2637b6d1d8654cd47c2af2feab126df7","197cf18a75b7345a58331a68929366be");

     Message message = Message
             .creator(new PhoneNumber(to), // to
                     new PhoneNumber("+16673031530"), // from
                     body)
             .create();
  
     if(message.getSid()!=null)
     return "Message sent";
     else
     	return "Error";
     	
	}
}
