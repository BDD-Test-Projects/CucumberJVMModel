package com.newsint.xplore.qa.pageobjects.salesforce;

/**
 * Created by IntelliJ IDEA.
 * User: ggogia
 * Date: 29/06/12
 * Time: 10:29
 * To change this template use File | Settings | File Templates.
 */
public class HomePage {

    public static final String leadsTab = "#Lead_Tab";
    public static final String accountsTab = "#tabBar li:nth-child(5)";
    public static final String contactsTab = "#tabBar li:nth-child(6)";
//  public static final String contactsTab = "//li[@id='Contact_Tab']";
    public static final String search = "//input[@id='phSearchInput']";
    public static final String searchBTN = "//input[@id='phSearchButton']";

    public static final String activateSideMenu = "//div[@id='pinIndicator']";

    //RHS ORG MENU
    public static final String groupMenu = "//div[@id='tsidButton']";
    public static final String orgLabel = "//span[@id = 'tsidLabel']";
    public static final String orgMenu = "//div/[@id='tsidMenu']";
    public static final String newIntLNK = "//a[contains(text(), 'News International')]";


    //Create New... dropdown menu on the LHS
    public static final String createNewDropdown = "#createNewButton.menuButtonButton";

    public static final String accountOptionFromDropdown = "a.menuButtonMenuLink.accountMru";
    public static final String contactsOptionFromDropdown = "a.contactMru.menuButtonMenuLink";
    public static final String leadsOptionFromDropdown = "a.leadMru.menuButtonMenuLink";
    public static final String opportunityFromDropdown = "a.menuButtonMenuLink.opportunityMru";


    //Custom Links section
    public static final String customerServicesUserLink = "//a[contains(text(), 'Customer Services User')]";
    public static final String salesSupportUserLink = "//a[contains(text(), 'Sales Support User')]";
    public static final String northEastSalesUserLink = "//a[contains(text(), 'North East Sales User')]";
    public static final String headOfDealerSalesLink = "//a[contains(text(), 'Head of Dealer Sales')]";


    //Customer Services User
    public static final String loginBTNForDifferentUsers = "//input[@value=' Login ']";
    public static final String customerServicesUserLoggedIn = "//span[@id='menuButtonLabel'][contains(text(), 'Customer Service...')]";
    public static final String userLogoutBTN = "//a[contains(text(), 'Logout')]";


    //Edit Link Page objects
    public static final String newBTN = "//input[@value=' New ']";
    public static final String saveBTN = "//input[@value=' Save ']";
    public static final String saveAsBTN = "//input[@value='Save As']";
    public static final String deleteBTN = "//input[@value='Delete']";
    public static final String cancelBTN = "//input[@value='Cancel']";
    public static final String saveAndNewBTN = "//input[@value= 'Save & New']";
    public static final String editBTN = "//div[@class='pbHeader']/table/tbody/tr/td[2]/input[@value=' Edit ']";
    public static final String errorMessage = "//div[@id='errorDiv_ep']";








}
