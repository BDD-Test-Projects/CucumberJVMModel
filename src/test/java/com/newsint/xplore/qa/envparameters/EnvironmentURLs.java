package com.newsint.xplore.qa.envparameters;

/**
 * Created by IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 03/04/12
 * Time: 11:29
 * To change this template use File | Settings | File Templates.
 */
public class EnvironmentURLs {

    //Environment & Credentials ###########################################################################

    public static final String User_Valid = "autotestuser1@driving.com";
    public static final String PassWord_Valid = "Qw3rty123";
    public static final String User_InValid = "invaliduser";
    public static final String PassWord_InValid = "nevergoingtowork";
    public static final String newEmail = "hrautotester2@hotrod.com";
    public static final String newPassword ="NewPass99";
    public static String envTag = "si";//System.getProperty("env").toLowerCase();
    public static String HomePage = "http://hotrod-web-"+envTag+".herokuapp.com";

    public static String MyGaragePage = "http://hotrod-web-"+envTag+".herokuapp.com/garage" ;
    public static String ProfilePage = "http://hotrod-web-"+envTag+".herokuapp.com/user";


    //API URLS ############################################################################################

    public static String API_BASE_URL = "http://hotrod-api-"+envTag+".herokuapp.com";
    public static String API_USER = "UWaich4chahw";
    public static String API_PASS = "5zcKypXJbFas";

    //Salesforce URL's & Credentials #####################################################################
    public static final String SalesforceLoginPage = "https://test.salesforce.com/";
    public static final String User_valid_salesforce = "adminuser.automation@driving.com.si";
    public static final String Password_valid_salesforce = "W@pping1";
    public static final String SalesUser = "salesuser1@driving.com.si";
    public static final String SalesSupportUser = "sales.supportuser@driving.com.si";
    public static final String AdminUser = User_valid_salesforce;
    public static final String Password = "W@pping3";


    }



















