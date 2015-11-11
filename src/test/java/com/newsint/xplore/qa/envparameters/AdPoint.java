package com.newsint.xplore.qa.envparameters;

/**
 * Created with IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 08/04/13
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
 */
public class AdPoint {

    /*
      This Class filed provides the URL's & Credentials for all the Perspective Environments of Adpoint

    Note: Any Change in the URL or Credentials will have to be reflected here as well !!

    */



    private static final String adPoint_HomePage = "http://autouser:Qw3rty2013@test.nwi.adpoint.me/";
     //"http://demouser:Adpoint123@uat.newsint.lineup.com/";
     //"http://autouser:Qw3rty2013@test.nwi.adpoint.me/";
    private static final String User_Valid = "";
    private static final String Pass_Valid = "";
    private static final String User_Invalid = "someuser";
    private static final String Pass_Invalid = "nevergoingtowork";
    private static final String err_InvalidUser = "";
    private static final String err_InvalidPass = "";




    public static String getAdPoint_HomePage() {
        return adPoint_HomePage;
    }

    public static String getUser_Valid() {
        return User_Valid;
    }

    public static String getPass_Valid() {
        return Pass_Valid;
    }

    public static String getUser_Invalid() {
        return User_Invalid;
    }

    public static String getPass_Invalid() {
        return Pass_Invalid;
    }

    public static String getErr_InvalidUser() {
        return err_InvalidUser;
    }

    public static String getErr_InvalidPass() {
        return err_InvalidPass;
    }


}
