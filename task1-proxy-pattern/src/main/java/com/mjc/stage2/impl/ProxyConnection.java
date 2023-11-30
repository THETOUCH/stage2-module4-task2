package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private RealConnection realConnection;
    private ConnectionPool connectionPool;
    @Override
    public void close() {
        connectionPool = ConnectionPool.getInstance();
        this.realConnection = realConnection;
        connectionPool.getConnection();
    }

    @Override
    public boolean isClosed() {
        return realConnection.isClosed();
    }

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
        connectionPool = ConnectionPool.getInstance();
    }

    public void reallyClose() {
        // Write your code here!
        connectionPool.releaseConnection(realConnection);
    }
    // Implement methods here!
}
