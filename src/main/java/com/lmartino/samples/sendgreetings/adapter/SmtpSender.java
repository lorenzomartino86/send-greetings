package com.lmartino.samples.sendgreetings.adapter;


import com.lmartino.samples.sendgreetings.domain.Message;
import com.lmartino.samples.sendgreetings.domain.MessageSender;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SmtpSender implements MessageSender{
    private final String sender;
    private Session session;

    public SmtpSender(String smtpHost, int smtpPort, String sender){;
        this.sender = sender;
        generateMailSession(smtpHost, smtpPort);
    }

    public void sendMessage(Message message) {
        final MimeMessage mailMessage = generateMailMessage(message);
        try {
            Transport.send(mailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    private MimeMessage generateMailMessage(Message message) {
        final String recipient = message.getEmail();
        final String subject = message.getSubject();
        final String body = message.getBody();
        MimeMessage mailMessage = new MimeMessage(session);
        try {
            mailMessage.setFrom(new InternetAddress(sender));
            mailMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recipient));
            mailMessage.setSubject(subject);
            mailMessage.setText(body);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mailMessage;
    }

    private void generateMailSession(String smtpHost, int smtpPort) {
        java.util.Properties props = new java.util.Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", "" + smtpPort);
        session = Session.getInstance(props, null);
    }
}
