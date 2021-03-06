package com.wh136.xyz.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
//表示开启使用STOMP协议来传输基于代理的消息，Broker就是代理的意思。
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker(AppConfig.BROKER);
    }
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //这一行代码用来注册STOMP协议节点，同时指定使用SockJS协议。
        registry.addEndpoint(AppConfig.ENDPOINT).withSockJS();
    }
}