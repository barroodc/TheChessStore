package com.solvd.onlinestore.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

public class ConnectionPool {
    private static final int maximumConnections = 10;
    private static int currentConnections = 0;
    private static ConnectionPool instance;
    private static ArrayBlockingQueue<Connection> poolConnects;
    private static AtomicReference<String> url = new AtomicReference<>();
    private static AtomicReference<String> userName = new AtomicReference<>();
    private static AtomicReference<String> password = new AtomicReference<>();

    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    public static String getUrl() {
        return url.get();
    }

    public static void setUrl(String url) {
        ConnectionPool.url.set(url);
    }

    public static String getUserName() {
        return userName.get();
    }

    public static void setUserName(String userName) {
        ConnectionPool.userName.set(userName);
    }

    public static String getPassword() {
        return password.get();
    }

    public static void setPassword(String password) {
        ConnectionPool.password.set(password);
    }

    public static void setPoolConnects(ArrayBlockingQueue<Connection> poolConnects) {
        ConnectionPool.poolConnects = poolConnects;
    }


    public ConnectionPool() {
    }


    public static ConnectionPool getInstance(){
        if (instance == null) {
            synchronized (ConnectionPool.class){
                instance = new ConnectionPool();
                poolConnects = new ArrayBlockingQueue<>(10);
            }
        }
        return instance;

    }

    public static synchronized Connection getConnection() throws Exception {
        Connection result = null;
        boolean finished = false;
        if (currentConnections < maximumConnections) {
            try {
                FileInputStream input = new FileInputStream("src/main/resources/db.properties");
                AtomicReference<Properties> properties = new AtomicReference<>(new Properties());
                properties.get().load(input);
                url = new AtomicReference<>(properties.get().getProperty("url"));
                userName = new AtomicReference<>(properties.get().getProperty("username"));
                password = new AtomicReference<>(properties.get().getProperty("password"));
                currentConnections++;
                Class.forName("com.mysql.cj.jdbc.Driver");
                result = DriverManager.getConnection(url.get(), userName.get(), password.get());
                finished = true;
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        }
        if (!finished) {
            Connection con = poolConnects.take();
            LOGGER.info("Connection successful.");

            result = con;
        }
        return result;
    }

    public synchronized void releaseConnection (Connection connection){
        if (poolConnects.add(connection)) {
            if (poolConnects.size() <= maximumConnections) {
                LOGGER.info("Success");
            } else {
                LOGGER.error("Warning: Failure to pool");
            }
        }
    }
}
