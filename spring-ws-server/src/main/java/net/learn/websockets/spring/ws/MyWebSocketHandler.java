package net.learn.websockets.spring.ws;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {

	@Override
	protected void handleTextMessage(final WebSocketSession session, final TextMessage message) throws Exception {

		System.out.println("Message from client -- " + message.getPayload());

		final TextMessage txtMsg = new TextMessage("Server got your message - " + message.getPayload());
		session.sendMessage(txtMsg);

	}
}
