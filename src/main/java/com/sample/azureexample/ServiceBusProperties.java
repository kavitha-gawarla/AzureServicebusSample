package com.sample.azureexample;

/**
 * Created by Kavitha on 10/8/2017.
 */
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

@ConfigurationProperties(prefix = "servicebus")
public class ServiceBusProperties {
    @Value("${servicebus.hostname}")
    private String hostName;

    @Value("${servicebus.username}")
    private String userName;

    @Value("${servicebus.password}")
    private String password;

    @Value("${servicebus.queue}")
    private String queue;

    public String getHostName() {
        return hostName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getQueue() {
        return queue;
    }
}