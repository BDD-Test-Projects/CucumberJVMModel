package com.newsint.xplore.qa;
import net.masterthought.cucumber.ReportBuilder;
import org.codehaus.jackson.map.ser.std.StdArraySerializers;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
/**
 * Created with IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 22/02/13
 * Time: 14:26
 * To change this template use File | Settings | File Templates.
 */
public class ReportManager {

    private static final String jsonPath = "/target/cucumber.json";
    private static final String reportDirectory="/target/cucumber-html-reports";
    private static final String userDirector = System.getProperty("user.dir");
    private static final String reportFile = "/target/cucumber-html-reports/feature-overview.html";

    private static final String SMTP_HOST_NAME = "mailhost.se.newsint.co.uk";
    private static final String SMTP_PORT = "25";
    private static final String emailMsgTxt = "Hi, <br/> <br/> PFA Automation Test Results for Sunday Times Driving Testing. <br/><br/> " +
            "Thanks. <br/><br/> Note: This is an automatic generated e-mail";
    private static final String emailSubjectTxt = "Automation Results - Sunday Times Driving";
    private static final String emailFromAddress = "vinod.mohan@newsint.co.uk";
    private static final String[] sendTo = { "vinod.mohan@newsint.co.uk","mvinodkumer@gmail.com"};

    public static void main(String[] args) throws Exception {
        GenerateReport();
        String[] fileNames = {userDirector+reportFile,userDirector+reportFile};
        //Send Email with HTML report as attachment
        /*
       try {
           sendMessage(Arrays.asList(sendTo), emailSubjectTxt, emailMsgTxt, emailFromAddress, fileNames);
       } catch (MessagingException e) {
           e.printStackTrace();
       } */
    }

    public static void GenerateReport()throws Exception {
        File reportOutputDirectory = new File(userDirector+reportDirectory);
        List<String> jsonReportFiles = new ArrayList<String>();
        jsonReportFiles.add(userDirector+jsonPath);

        String buildNumber = "1";
        String pluginUrl = "";
        String buildProjectName = "Xplore Workspace";
        Boolean skippedFails = false;
        Boolean undefinedFails = false;
        Boolean flashCharts = true;
        Boolean runWithJenkins = false;
        Boolean artifactsEnabled = false;
        String artifactsString  = "";

        /*ReportBuilder reportBuilder = new ReportBuilder(jsonReportFiles,reportOutputDirectory,
                pluginUrl,buildNumber,buildProjectName,skippedFails,undefinedFails,flashCharts,
                runWithJenkins);*/
        ReportBuilder reportBuilder = new ReportBuilder(jsonReportFiles, reportOutputDirectory, pluginUrl, buildNumber, buildProjectName, skippedFails, undefinedFails,
                flashCharts,runWithJenkins, artifactsEnabled, artifactsString);

        reportBuilder.generateReports();
    }

    protected static void addAtachments(String[] attachments, Multipart multipart)
            throws MessagingException {
        for (int i = 0; i <= attachments.length - 1; i++) {
            String filename = attachments[i];
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();

            DataSource source = new FileDataSource(filename);
            attachmentBodyPart.setDataHandler(new DataHandler(source));

            attachmentBodyPart.setFileName(filename);
            multipart.addBodyPart(attachmentBodyPart);
        }
    }

    protected static void sendMessage(List<String> recipients, String subject,
                                      String messageContent, String from, String[] attachments)
            throws MessagingException {

        boolean debug = true;

        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.socketFactory.port", SMTP_PORT);
        //props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("test.times.t7", "testing123");
                    }
                });

        session.setDebug(debug);

        Message message = new MimeMessage(session);
        InternetAddress addressFrom = new InternetAddress(from);
        message.setFrom(addressFrom);

        for (String recipient : recipients) {
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(recipient));
        }

        message.setSubject(subject);

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(messageContent, "text/html");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        addAtachments(attachments, multipart);
        message.setContent(multipart);
        Transport.send(message);
    }







}
