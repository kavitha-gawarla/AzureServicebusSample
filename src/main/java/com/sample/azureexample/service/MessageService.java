package com.sample.azureexample.service;

import com.sample.azureexample.producer.MessageSenderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Kavitha on 10/9/2017.
 */
@Service
public class MessageService {

@Autowired
MessageSenderImpl messageSenderImpl;


public void sendMessage(String msg){

	messageSenderImpl.sendMessage(msg);
}

}
