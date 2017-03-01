package net.learn.websockets.spring.ws;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	public void registerWebSocketHandlers(final WebSocketHandlerRegistry registry) {
		registry.addHandler(this.webSocketHandler(), "/ws/sport");
	}

	public MyWebSocketHandler webSocketHandler() {
		return new MyWebSocketHandler();
	}

}
