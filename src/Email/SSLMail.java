package Email;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SSLMail {

    private String recipient;
    private String subject;
    private String messageText;

    private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    private static final int SMTP_HOST_PORT = 465;
    private static final String SMTP_AUTH_USER = "pw1hkr@gmail.com";
    private static final String SMTP_AUTH_PWD = "08cd5408";


    public SSLMail(String recipient, String subject, String messageText) {
        this.recipient = recipient;
        this.subject = subject;
        this.messageText = messageText;
    }

    public void sendMail() throws Exception {
        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", SMTP_HOST_NAME);
        props.put("mail.smtps.auth", "true");
        // props.put("mail.smtps.quitwait", "false");

        Session mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        // ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(messageText);

        MimeMessage message = new MimeMessage(mailSession);
        message.setHeader("Content-Type", "text/plain; charset=\"UTF-8\"");
        message.setText(messageText, "UTF-8");
        message.setSubject(subject, "UTF-8");
        message.setContent(messageText, "text/plain; charset=\"UTF-8\"");




        message.addRecipient(Message.RecipientType.TO,
                new InternetAddress(recipient));

        transport.connect
                (SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER, SMTP_AUTH_PWD);

        transport.sendMessage(message,
                message.getRecipients(Message.RecipientType.TO));
        transport.close();
    }


}

