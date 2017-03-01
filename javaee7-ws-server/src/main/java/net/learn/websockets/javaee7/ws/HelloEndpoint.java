package net.learn.websockets.javaee7.ws;

import java.io.IOException;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/hello")
public class HelloEndpoint {

    private Session session;
    private String message1 = "";

    @OnOpen
    public void onCreateSession( final Session session ) {
        this.session = session;
    }

    @OnMessage
    public void onTextMessage( final String message ) {
        System.out.println( "Message = " + message );
        this.message1 = this.message1 + message;
        if ( this.session != null && this.session.isOpen() ) {
            try {
                this.session.getBasicRemote().sendText( " @server " + message + " - " + this.message1 );
            } catch ( final IOException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
