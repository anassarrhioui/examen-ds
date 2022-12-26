package me.arrhioui.clientqueryservice.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "data")
@Getter
@Setter
public class ConsulConfig {

    private long parameter1;

    private long parameter2;
}
