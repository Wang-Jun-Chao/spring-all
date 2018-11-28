package com.example.spring.boot.socketio;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-11-28 11:22
 **/
@Service
public class SocketIoServiceImpl implements SocketIoService, DisposableBean {
    private final static Logger logger = LoggerFactory.getLogger(SocketIoServiceImpl.class);

    private ConcurrentMap<String, ClientInfo> MAP = new ConcurrentHashMap<>();
    @Autowired
    private SocketIOServer                    server;

    /**
     * 添加connect事件，当客户端发起连接时调用，本文中将clientid与sessionid存入数据库
     * //方便后面发送消息时查找到对应的目标client,
     *
     * @param client
     */
    @OnConnect
    @Override
    public void onConnect(SocketIOClient client) {

        String clientId = client.getHandshakeData().getSingleUrlParam("clientid");
        ClientInfo clientInfo = MAP.get(clientId);
        if (clientInfo == null) {
            clientInfo = new ClientInfo();
            clientInfo.setClientId(clientId);
            clientInfo.setConnected(true);
            clientInfo.setMostSignBits(client.getSessionId().getMostSignificantBits());
            clientInfo.setLeastSignificantBits(client.getSessionId().getLeastSignificantBits());
            clientInfo.setLastConnectedTime(LocalDateTime.now());
            MAP.put(clientId, clientInfo);
        }


        logger.warn("IP: " + client.getRemoteAddress().toString()
                + " UUID: " + client.getSessionId().toString() + " 设备建立连接");
    }


    @OnEvent("message")
    @Override
    public void onEvent(SocketIOClient client, AckRequest request, MessageInfo data) {
        String targetClientId = data.getTargetClientId();
        ClientInfo clientInfo = MAP.get(targetClientId);
        if (clientInfo != null && clientInfo.isConnected()) {
            UUID uuid = new UUID(clientInfo.getMostSignBits(), clientInfo.getLeastSignificantBits());
            System.out.println(uuid.toString());
            MessageInfo sendData = new MessageInfo();
            sendData.setSourceClientId(data.getSourceClientId());
            sendData.setTargetClientId(data.getTargetClientId());
            sendData.setMsgType("chat");
            sendData.setMsgContent(data.getMsgContent());
            client.sendEvent("message", sendData);
            server.getClient(uuid).sendEvent("message", sendData);
        }
    }

    /**
     * 添加@OnDisconnect事件，客户端断开连接时调用，刷新客户端信息
     */
    @OnDisconnect
    @Override
    public void onDisconnect(SocketIOClient client) {
        String clientId = client.getHandshakeData().getSingleUrlParam("clientid");
        MAP.remove(clientId);
        logger.warn("IP: " + client.getRemoteAddress().toString()
                + " UUID: " + client.getSessionId().toString() + " 设备断开连接");
    }

    /**
     * 给所有连接客户端推送消息
     *
     * @param eventType 推送的事件类型
     * @param message   推送的内容
     */
    public void sendMessageToAllClient(String eventType, String message) {
        Collection<SocketIOClient> clients = server.getAllClients();
        for (SocketIOClient client : clients) {
            client.sendEvent(eventType, message);
        }
    }

    @Override
    public void destroy() throws Exception {
        server.stop();
    }
}
