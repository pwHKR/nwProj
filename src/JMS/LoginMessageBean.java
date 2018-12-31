package JMS;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {

        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/RegQueue"),
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/RegConnectionFactory")
})
public class LoginMessageBean implements javax.jms.MessageListener {
    public LoginMessageBean() {
    }

    @Override
    public void onMessage(Message message) {


        TextMessage msg = null;
        String smessage="";

        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
                smessage = msg.getText();
                System.out.println(((TextMessage) message).getText());


            }
        } catch (JMSException e) {

        } catch (Throwable te) {

        }
    }
}
