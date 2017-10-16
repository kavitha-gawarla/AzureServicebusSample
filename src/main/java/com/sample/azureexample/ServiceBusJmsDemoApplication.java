package com.sample.azureexample;

/**
 * Created by Kavitha on 10/8/2017.
 */
import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.credentials.ApplicationTokenCredentials;
import com.microsoft.azure.credentials.AzureCliCredentials;
import com.microsoft.azure.management.Azure;
import com.microsoft.azure.management.servicebus.AuthorizationKeys;
import com.microsoft.azure.management.servicebus.NamespaceAuthorizationRule;
import com.microsoft.azure.management.servicebus.ServiceBusNamespace;
import com.microsoft.windowsazure.Configuration;
import com.microsoft.windowsazure.services.servicebus.ServiceBusConfiguration;
import com.microsoft.windowsazure.services.servicebus.ServiceBusContract;
import com.microsoft.windowsazure.services.servicebus.ServiceBusService;
import com.microsoft.windowsazure.services.servicebus.models.BrokeredMessage;
import com.sample.azureexample.service.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@EnableJms
public class ServiceBusJmsDemoApplication {

    public static void main(String[] args) {
       // SpringApplication.run(ServiceBusJmsDemoApplication.class, args);
       // sendMessage();
        ConfigurableApplicationContext context = SpringApplication.run(ServiceBusJmsDemoApplication.class, args);
        MessageService messageService = context.getBean(MessageService.class);
	      messageService.sendMessage("Hello, My second JMS Message");
    }



    private static void sendMessage() {

        try {

            Configuration config =
                    ServiceBusConfiguration.configureWithSASAuthentication(
                            "testSampleServicebus",
                            "RootManageSharedAccessKey",
                            "DGRJwhuIKTrM/w3BQJPvirQiyCJCjWl3fJjC9hGG5m8=",
                            ".servicebus.windows.net"

                    );
            ServiceBusContract service = ServiceBusService.create(config);
            BrokeredMessage message = new BrokeredMessage("Hello");
            message.setSessionId("23424");
            service.sendQueueMessage("myfirsttestqueue", message);
        } catch (Exception ex) {
        }


    }



}