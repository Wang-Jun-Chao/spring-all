package com.example.spring.boot.socketio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-11-28 14:18
 **/
public class ClientInfo {
    private final static Logger logger = LoggerFactory.getLogger(ClientInfo.class);
    private String clientId;
    private boolean connected;
    private long mostSignBits;
    private long leastSignificantBits;
    private LocalDateTime lastConnectedTime;

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setMostSignBits(long mostSignBits) {
        this.mostSignBits = mostSignBits;
    }

    public long getMostSignBits() {
        return mostSignBits;
    }

    public void setLeastSignificantBits(long leastSignificantBits) {
        this.leastSignificantBits = leastSignificantBits;
    }

    public long getLeastSignificantBits() {
        return leastSignificantBits;
    }

    public void setLastConnectedTime(LocalDateTime lastConnectedTime) {
        this.lastConnectedTime = lastConnectedTime;
    }

    public LocalDateTime getLastConnectedTime() {
        return lastConnectedTime;
    }
}
