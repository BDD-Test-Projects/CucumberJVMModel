package com.newsint.xplore.qa.pageobjects.adpoint;

/**
 * Created with IntelliJ IDEA.
 * User: Vinod Kumar M
 * Date: 12/04/13
 * Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
public class Clients {


    public static final String NewCustomer = "//span[contains(text(), 'New customer')]";
    public static final String MyCustomer = "//span[contains(text(), 'My customers')]";
    public static final String Oppurtnty = "//span[contains(text(), 'Oppurtunities')]";
    public static final String ClientTools = "//span[contains(text(), 'Client tools')]";

    public static final String MainInfo_tab = "//span[contains(text(), 'Main info')]";
    public static final String Other_tab = "//span[contains(text(), 'Other')]";
    public static final String InvoicingInfo_tab = "//span[contains(text(), 'Invoicing info')]";
    public static final String BankAcc_tab = "//span[contains(text(), 'Bank account')]";

    // ## A & B Section ##########################################
    public static final String Custname = "//input[@id = 'ctl00_body_TabContainer1_tabMainInfo_tbName']";
    public static final String EngName = "//input[@id='ctl00_body_TabContainer1_tabMainInfo_tbIntName']";

    public static final String Regno = "//input[@id='ctl00_body_TabContainer1_tabMainInfo_tbRegNo']";
    public static final String Taxno = "//input[@id='ctl00_body_TabContainer1_tabMainInfo_tbTaxNo']";
    public static final String OwnerList = "//select[@id='ctl00_body_TabContainer1_tabMainInfo_cmbAccountManagerName']";
    public static final String Phone_num = "//input[@id='ctl00_body_TabContainer1_tabMainInfo_tbPhone']";
    public static final String Fax_num = "//input[@id = 'ctl00_body_TabContainer1_tabMainInfo_tbFax']";
    public static final String Email = "//input[@id='ctl00_body_TabContainer1_tabMainInfo_tbMail']";
    public static final String Web = "//input[@id = 'ctl00_body_TabContainer1_tabMainInfo_tbWeb']";

    //## C & D Section ###########################################

    public static final String MediaAgency = "//input[@id='ctl00_body_TabContainer1_tabMainInfo_MediaAgencySelector_tbCustomerName']";
    public static final String CreativeAgency = "//input[@id='ctl00_body_TabContainer1_tabMainInfo_CreativeAgencySelector_tbCustomerName']";
    public static final String Agent = "//input[@id='ctl00_body_TabContainer1_tabMainInfo_AgentSelector_tbCustomerName']";
    public static final String SegmentList = "//select[@id='ctl00_body_TabContainer1_tabMainInfo_cmbMarketID']";
    public static final String ActiveList = "//select[@id='ctl00_body_TabContainer1_tabMainInfo_cmbActive']";

    public static final String IsAgencyList = "//select[@id='ctl00_body_TabContainer1_tabMainInfo_cmbAgency']";
    public static final String LocalHoldList = "//select[@id='ctl00_body_TabContainer1_tabMainInfo_cmbHoldingID']";
    public static final String InterHoldList = "//select[@id='ctl00_body_TabContainer1_tabMainInfo_cmbIntlHoldingID']";
    public static final String DefVouchersCopies = "//input[@id='ctl00_body_TabContainer1_tabMainInfo_tbVouchers']";
    public static final String DefAdType = "//select[@id='ctl00_body_TabContainer1_tabMainInfo_cmbAdType']";

    public static final String Source = "//select[@id='ctl00_body_TabContainer1_tabOther_cmbCustomerSourceID']";

    /*Buttons in the Screen ######################*/

    public static final String SaveBTN = "//input[@id='ctl00_body_btnSave']";
    public static final String BackBTN = "//input[@id='ctl00_body_btnBack']";
    public static final String DeleteBTN = "//input[@id='ctl00_body_btnDelete']";
    public static final String MergeRemove = "//input[@id='ctl00_body_btnMerge']";


    public static final String ClientHeader = "//span[@id = 'ctl00_head_cpHeader_lblCustomerName']";
    public static final String ClientSearchByName = "//input[@id='ctl00_body_gvList_ctl01_tbFilterName']";
    public static final String ModifyCustomer = "//a[@id='ctl00_head_cpHeader_hlModifyCustomer']";
    public static final String NewOrder = "//a[@id='ctl00_head_cpHeader_hlNewOrder']";
    public static final String NewContract = "//a[@id='ctl00_head_cpHeader_hlNewContract']";
    public static final String NewContact = "//a[@id='ctl00_head_cpHeader_hlNewContact']";
    public static final String NewActivity = "//a[@id='ctl00_head_cpHeader_hlNewActivity']";
    public static final String NewOppurtunity = "//a[@id='ctl00_head_cpHeader_hlNewOpportunity']";


    public static final String ContracTab = "//span[contains(text(), 'Contracts')]";
    public static final String ContactTab = "//span[contains(text(), 'Contacts')]";
    public static final String Detail = "//a[contains(text(), 'Detail')]";
    public static final String Edit = "//a[contains(text(), 'Edit')]";

}
