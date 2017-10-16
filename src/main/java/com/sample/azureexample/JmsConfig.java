package com.sample.azureexample;

/**
 * Created by Kavitha on 10/8/2017.
 */
import org.apache.qpid.jms.JmsConnectionFactory;
import org.apache.qpid.jms.JmsQueue;
import org.apache.qpid.jms.policy.JmsDefaultPrefetchPolicy;
import org.apache.qpid.jms.policy.JmsPrefetchPolicy;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Session;
import java.io.UnsupportedEncodingException;

@Configuration
@EnableConfigurationProperties(ServiceBusProperties.class)
@PropertySource("servicebus.properties")
public class JmsConfig {

    private ServiceBusProperties props;

    public JmsConfig(ServiceBusProperties props) {
        this.props = props;
    }

    @Bean
    ConnectionFactory getConnectionFactory() {
        ConnectionFactory connectionFactory = new JmsConnectionFactory(props.getUserName(), props.getPassword(), props.getHostName());
        return connectionFactory;
    }

    @Bean
    JmsTemplate newJmsTemplate(ConnectionFactory connectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(getConnectionFactory());
        jmsTemplate.setDefaultDestination(newJmsQueue());
        return jmsTemplate;
    }

    @Bean
    Queue newJmsQueue() {
        return new JmsQueue(props.getQueue());
    }


}