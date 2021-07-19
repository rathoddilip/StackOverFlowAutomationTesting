package com.selenium.stackoverflow.utility;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class EmailReport {
    private static final String USERNAME = "diliprathodtest@gmail.com";
    private static final String PASSWORD = "Login@123";
    private static final String RECIPIENT = "diliprathodtest@gmail.com";

    //this method is used to send mail by giving the details of body subject, to address, attachment path
    public static void sendMail() {

        String[] to = {RECIPIENT}; // list of recipient email addresses
        String subject = "Test Report";
        String body = "StackOverFlow test report";
        String reportPath = "/home/arjun/Dilip/StackOverFlowApplicationAutomationTesting/src/Log4jReport/TestReport.log";

        sendFromGMail(to, subject, body, reportPath);
    }

    private static void sendFromGMail(String[] to, String subject, String body, String reportPath) {

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(EmailReport.USERNAME));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (InternetAddress address : toAddress) {
                message.addRecipient(Message.RecipientType.TO, address);
            }
            message.setSubject(subject);

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Now set the actual message
            messageBodyPart.setText(body);

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = "StackOverFlow test report";
            DataSource source = new FileDataSource(reportPath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);


            Transport.send(message, message.getAllRecipients());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}