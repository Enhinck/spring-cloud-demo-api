package com.enhinck.demo.websocket;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

/**
 * @author hueb
 * @date 2018/6/13
 */
//@ServerEndpoint("/websocket")
//@Component
public class MyWebSocket {

    private static Logger logger = Logger.getLogger(MyWebSocket.class.getName());

    static Queue<Session> sessions = new ConcurrentLinkedQueue<>();
    Session session;
    
    //连接
    @OnOpen
    public void onOpen(Session session) {
        //连接上后给客户端一个消息
    	this.session = session;
    	sessions.add(session);
        sendMsg(session, "连接服务器成功！当前session size:" + sessions.size());
    }

    //关闭
    @OnClose
    public void onClose(Session session) {
    	sessions.remove(session);
        logger.log(Level.INFO, "连接已关闭！");
    }

    //接收客户端消息
    @OnMessage
    public String onMessage(String message) {
        logger.log(Level.INFO, "客户端发送消息：" + message);
        for (Session session : sessions) {
        	   sendMsg(session, message);
		}
        return "SUCCESS";
    }

    //异常
    @OnError
    public void onError(Session session, Throwable throwable) {
        sendMsg(session, throwable.getMessage());
    }

    //发送消息给客户端
    public synchronized void sendMsg(Session session, String msg) {
        try {
            session.getBasicRemote().sendText(msg);
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }
    }
    
    public  void sendMsg2All(String msg) {
        try {
        	 for (Session session : sessions) {
          	   sendMsg(session, msg);
  		}
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        }
    }
}
