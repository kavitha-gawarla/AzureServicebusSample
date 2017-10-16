package com.sample.azureexample;

import com.microsoft.windowsazure.services.servicebus.ServiceBusConfiguration;
import com.microsoft.windowsazure.services.servicebus.ServiceBusContract;
import com.microsoft.windowsazure.services.servicebus.ServiceBusService;
import com.sample.azureexample.producer.MessageSenderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kavitha on 10/9/2017.
 */
@Configuration
public class AzureServiceBusConfig {


    @Bean
    public com.microsoft.windowsazure.Configuration connectionFactory(){
        return ServiceBusConfiguration.configureWithSASAuthentication(
                "testSampleServicebus",
                "RootManageSharedAccessKey",
                "DGRJwhuIKTrM/w3BQJPvirQiyCJCjWl3fJjC9hGG5m8=",
                ".servicebus.windows.net"

        );
    }

    @Bean
    public ServiceBusContract serviceBusContract(){
        System.out.println("service bus contract");
        ServiceBusContract service = ServiceBusService.create(connectionFactory());

        return service;
    }

//    @Bean
//    public MessageSenderImpl messageSender(){
//        MessageSenderImpl ms=new MessageSenderImpl();
//       // ms.setServiceBusContract(serviceBusContract());
//        return ms;
//    }
}
