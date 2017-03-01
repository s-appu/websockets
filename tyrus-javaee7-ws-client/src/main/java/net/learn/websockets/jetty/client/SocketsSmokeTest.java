package net.learn.websockets.jetty.client;

import java.io.IOException;
import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;

import org.junit.Before;
import org.junit.Test;

public class SocketsSmokeTest {

	private WebSocketContainer webSocketContainer;
	private HelloEndpoint helloEndpoint1;
	private HelloEndpoint helloEndpoint2;
	private HelloEndpoint helloEndpoint3;

	@Before
	public void init() {
		this.webSocketContainer = ContainerProvider.getWebSocketContainer();
		this.helloEndpoint1 = new HelloEndpoint();
		this.helloEndpoint2 = new HelloEndpoint();
		this.helloEndpoint3 = new HelloEndpoint();
	}

	@Test
	public void pingServer() throws DeploymentException, IOException, InterruptedException {
		this.webSocketContainer.connectToServer(this.helloEndpoint1,
				URI.create("ws://localhost:8080/jetty-ws-server/hello"));
		this.webSocketContainer.connectToServer(this.helloEndpoint2,
				URI.create("ws://localhost:8080/jetty-ws-server/hello"));

		this.helloEndpoint1.sendMessage("hello1 - v1");
		this.helloEndpoint1.sendMessage("hello1 - v2");
		this.helloEndpoint2.sendMessage("hello2");
		this.helloEndpoint1.sendMessage("hello1 - v3");

		Thread.sleep(2000);
	}

	@Test
	public void pingSpringServer() throws DeploymentException, IOException, InterruptedException {

		this.webSocketContainer.connectToServer(this.helloEndpoint3, URI.create("ws://localhost:8080/ws/sport"));
		this.helloEndpoint3.sendMessage("hello1 - v1");

		Thread.sleep(2000);
	}
}
