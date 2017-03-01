package net.learn.websockets.jetty.client;

import java.io.IOException;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

public class HelloEndpoint extends Endpoint {

    private Session session;

    @Override
    public void onOpen( final Session session, final EndpointConfig config ) {
        this.session = session;

        this.session.addMessageHandler( new MessageHandler.Whole<String>() {

            public void onMessage( final String message ) {
                System.out.println( "!!!!! Recieved from server " + message );

            }

        } );

    }

    public void sendMessage( final String message ) throws IOException {
        this.session.getBasicRemote().sendText( message );
    }

}
