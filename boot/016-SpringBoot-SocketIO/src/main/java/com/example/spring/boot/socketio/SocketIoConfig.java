package com.example.spring.boot.socketio;

import com.corundumstudio.socketio.AuthorizationListener;
import com.corundumstudio.socketio.HandshakeData;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-11-28 10:51
 **/
@Configuration
public class SocketIoConfig {
    private final static Logger logger = LoggerFactory.getLogger(SocketIoConfig.class);

    @Bean(name = "socketIoConfiguration")
    @ConfigurationProperties("socketio.server")
    public com.corundumstudio.socketio.Configuration configuration() {
        com.corundumstudio.socketio.Configuration configuration = new com.corundumstudio.socketio.Configuration();

        configuration.setAuthorizationListener(new AuthorizationListener() {
            @Override
            public boolean isAuthorized(HandshakeData handshakeData) {
                return true;
            }
        });

        return configuration;
    }

    @Bean
    public SocketIOServer socketIOServer(com.corundumstudio.socketio.Configuration configuration) {
        return new SocketIOServer(configuration);
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketServer) {
        return new SpringAnnotationScanner(socketServer);
    }
}
