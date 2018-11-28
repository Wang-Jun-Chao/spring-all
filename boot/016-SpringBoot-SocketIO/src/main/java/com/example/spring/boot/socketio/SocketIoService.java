package com.example.spring.boot.socketio;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-11-28 11:21
 **/
public interface SocketIoService {
    void onConnect(SocketIOClient client);

    void onEvent(SocketIOClient client, AckRequest request, MessageInfo data);

    void onDisconnect(SocketIOClient client);

}
