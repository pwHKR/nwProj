package Web.MVC.Controller.Bean;

import javax.ejb.Stateless;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.io.IOException;

@Stateless(name = "SendMessageEJB")
public class SendMessageBean {
    public SendMessageBean() {
    }

    public void sendMessage(String message,String className) throws IOException {
        try{
            Context ctx = new InitialContext();
            ConnectionFactory connectionFactory = (ConnectionFactory)ctx.lookup("jms/RegConnectionFactory");
            Queue queue = (Queue)ctx.lookup("jms/RegQueue");

            javax.jms.Connection  connection = connectionFactory.createConnection();
            javax.jms.Session        session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            TextMessage JMSmessage = session.createTextMessage();
            JMSmessage.setText(message);
            System.out.println( "***** "+className+": Sent the message to YourQueue:"+ JMSmessage.getText());
            messageProducer.send(JMSmessage);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
