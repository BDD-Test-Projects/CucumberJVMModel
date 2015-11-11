package com.newsint.xplore.qa.pageobjects.salesforce;

/**
 * Created by IntelliJ IDEA.
 * User: ggogia
 * Date: 06/07/12
 * Time: 11:52
 * To change this template use File | Settings | File Templates.
 */
public class OpportunityPage {

    public static final String opportunityPageHeading = "//h2[@class='pageDescription']";

    //New Opportunity Page objects
    public static final String opportunityName = "#opp3";
    public static final String contactName = "//input[@tabindex='9']";
    public static final String closeDate = "//span[@class='dateInput dateOnlyInput']/span/a";
    public static final String stage = "#opp11";
    public static final String approvalStatus = "//select[@tabindex='8']";
    public static final String accountName = "//div[@class='pbSubsection']/table/tbody/tr[2]/td[2]/div/a";

    //Opportunity page BTNs -- Edit button is common to many other pages and hence not here (Edit button on HomePage)
    public static final String addProductBTN = "//input[@name='addProd']";
    public static final String sharingBTN = "//td[@id='topButtonRow']/input[@value='Sharing']";
    public static final String submitForApprovalBTN = "//td[@id='topButtonRow']/input[@value='Submit for Approval']";

    public static final String errorMessageEnterAValue = "//div[@class='errorMsg']";

//    public static final String submitForApprovalBTN = "//input[@value='Submit for Approval']";
    public static final String standardProduct = "//input[@id='01uS0000003IraE']";

}
