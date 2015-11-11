package com.newsint.xplore.qa.pageobjects.salesforce;

/**
 * Created by IntelliJ IDEA.
 * User: ggogia
 * Date: 02/07/12
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 */
public class AccountsPage {

    public static final String accountOwner = "//td[2][@class='dataCol col02']";
    public static final String accountPageHeading = "//h2[@class='pageDescription']";
    public static final String accRecordType = "//select[@id='p3']";
    public static final String continueBTN = "//input[@value='Continue']";
    public static final String newAccBTN = "//input[@value='New Account']";

    //New Account Page objects
    public static final String edit = "//input[@Value= ' Edit ']";
    public static final String accountName = "#acc2";
    public static final String accName = "//input[@id='acc2']";
    public static final String accNameFilled = "//div[@id='acc2_ileinner']";
    public static final String phone = "#acc10";
    public static final String website = "#acc12";
    public static final String email = "//input[@id='00N3000000AiE3j']";
    public static final String externalID = "//div[@id='00N3000000AeABf_ileinner']";
    public static final String webDealerId = "//div[@id='00N3000000BOAJC_ileinner']";
    public static final String dynamicTeleTracking = "//input[@id='00N3000000BdxxI']";
    public static final String telephoneTrackingNum = "//input[@id = '00N3000000B09oB']";
    public static final String SAPId = "//input[@id= '00N3000000AeABh']";
    public static final String CreCheck = "//input[@id='00N3000000Ar7w6']";
    public static final String creCheckBox = "//div[@id='00N3000000Ar7w6_ileinner']";
    public static final String creditRefnum = "//div[@id='00N3000000Ar7w7_ileinner']";
    public static final String CreRefNum = "//input[@id='00N3000000Ar7w7']";
    public static final String billCountry = "//input[@id='acc17country']";
    public static final String type = "#acc6";
    public static final String accType = "//select[@id='acc6']";
    public static final String accSubType = "//select[@id = '00N3000000AeABi']";
    public static final String creditCheckPassed = "table.detailList tbody tr td:nth-child(4) input";

    public static final String billingStreet = "#acc17street";
    public static final String billingCity = "#acc17city";
    public static final String billingPostcode = "#acc17zip";
    public static final String region = "//select[@id='00N3000000AeABg']";

    public static final String parentAccount = "#acc3";
    public static final String parentAcc = "//div[@id='acc3_ileinner']";
    public static final String viewHierarchyLink = "//td[2]/div/a[contains(text(), '[View Hierarchy]')]";
    public static final String copyBillingAddress = "//a[contains(text(), 'Copy Billing Address to Mailing Address')]";
    //Account details page objects
    //created account name for verifying
    public static final String accountNameCreated = "//div[@id='acc2_ileinner']";
    public static final String dealerID = "//table[@class='detailList']/tbody/tr[5]/td[2]";

    //Contacts section on the Accounts page
    public static final String contactsLinkWithinAnAccountPage = "//span[@class='listTitle'][contains(text(), 'Contacts')]";
    public static final String contactsSectionWithinAccountPage = "//td[@class='pbTitle']/h3[contains(text(), 'Contacts')]";
//    public static final String newContactBTNOnAccountPage = "//div[@class='pbHeader']/table/tbody/tr/td[2]";
    public static final String newContactBTNOnAccountPage = "//input[@value='New Contact']";
//    public static final String firstContactRow = "//tr[@class='dataRow even last first']/th/a";
    public static final String firstContactRow = "//table[@class='list']/tbody/tr[2]/th/a";

    //Account Hierarchy page objects
    public static final String accountHierarchyHeading = "//h1[@class='pageType']";

    public static final String topmostElement = "//tr[@class='dataRow even first highlight']/th/a";
    public static final String nextElement = "//table[@class='list']/tbody/tr[2]/th/a";

    public static final String errorMessageEnterAValue = "//div[@class='errorMsg']";







}
