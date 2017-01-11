package com.lidong.dubbo.web.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.lidong.dubbo.util.JsonUtil;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


/**
 * @version 1.0.0
 * @author ldiong
 *
 */
public class WebSocketHandler extends TextWebSocketHandler {
    private List<WebSocketSession> socketSessions = new ArrayList<WebSocketSession>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        socketSessions.add(session);
        super.afterConnectionEstablished(session);
    }
    private Map<String, WebSocketSession> clients = new ConcurrentHashMap<String,WebSocketSession>();
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
    	  System.out.println("receive a message." + message.getPayload());  
    	  
//    	  User user = new User();
//    	  user.setId(1234);
//    	  user.setName("lidong");
//    	  user.setAge(52);
//    	  user.setPassword("123456789");
//		  String bean2json = JsonUtils.bean2json(user);
//    	  sendMessageToUser(new TextMessage(bean2json));
    	  
    	  
    	  if(!clients.containsKey(session.getId()))
  		{
  			clients.put(session.getId(), session);
  		}
  		String payload = message.getPayload().toString();
  		Map<String, Object> datas = JsonUtil.json2bean(payload, Map.class);
  		String type = datas.get("type").toString();
  		
  		if("1".equals(type))
  		{
  			datas.put("pcount", clients.keySet().size() + "");
  		}
  		else if("3".equals(type))
  		{
  			clients.remove(session.getId());
  			datas.put("pcount", clients.keySet().size() + "");
  		}
  		
  		TextMessage tm = new TextMessage(JsonUtil.bean2json(datas));
  		sendToAll(tm);

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        socketSessions.remove(session);
        super.afterConnectionClosed(session, status);
    }

    public void sendMessageToUser(TextMessage message) throws IOException {
        System.out.println("服务器发给用户的消息"+message.getPayload());
        for (WebSocketSession   socketSession : socketSessions){
            if (socketSession.isOpen()) {
            	
                socketSession.sendMessage(message);
            }
        }
        System.out.println("--------------------end--------------------------"); 
		
    }
    
    
    
    private void sendToAll(TextMessage tm)
	{
		try
		{
			for(WebSocketSession session : clients.values())
			{
				if(session.isOpen())
				{
					session.sendMessage(tm);
				}
				else
				{
					clients.remove(session.getId());
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}