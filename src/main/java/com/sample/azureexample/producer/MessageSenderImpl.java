package com.sample.azureexample.producer;

import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.services.servicebus.ServiceBusContract;
import com.microsoft.windowsazure.services.servicebus.models.BrokeredMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by Kavitha on 10/9/2017.
 */
@Component
public class MessageSenderImpl implements MessageSender {


    @Autowired
    JmsTemplate jmsTemplate;



//    public JmsTemplate getJmsTemplate() {
//        return jmsTemplate;
//    }
//
//
//
//    public void setJmsTemplate(JmsTemplate jmsTemplate) {
//        this.jmsTemplate = jmsTemplate;
//    }



    @Override
    public void sendMessage(String msg) {

        jmsTemplate.send(new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {

                return session.createTextMessage(msg);
            }
        });
    }

//    @Autowired
//    public ServiceBusContract serviceBusContract;
//
//    @Autowired
//
//    @Override
//    public void sendMessage(String msg) {
//
//        BrokeredMessage message = new BrokeredMessage(msg);
//        message.setSessionId("23424");
//        try {
//            serviceBusContract.sendQueueMessage("myfirsttestqueue", message);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//
//    }


//    public void sendMessage2(String msg) {
//
//        BrokeredMessage message = new BrokeredMessage(msg);
//        message.setSessionId("234241");
//        try {
//            serviceBusContract.sendQueueMessage("myfirsttestqueue", message);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//
//    }
}
