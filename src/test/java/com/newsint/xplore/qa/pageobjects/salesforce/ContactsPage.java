package com.newsint.xplore.qa.pageobjects.salesforce;

/**
 * Created by IntelliJ IDEA.
 * User: ggogia
 * Date: 02/07/12
 * Time: 11:36
 * To change this template use File | Settings | File Templates.
 */
public class ContactsPage {

    public static final String contactInfoTopOfPage = "//div[2][@class='bDescription']";
    public static final String contactPageHeading = "//h2[@class='pageDescription']";
    public static final String contactOwner = "//div[@id='con1_ileinner']]";
    public static final String contactNameCreated = "#con2_ileinner";
    public static final String accountNameCreated = "//div[@id='con4_ileinner']/a";

    //Edit, Clone and Request Update Buttons on the Contact page
    public static final String editBTN = "//input[@value=' Edit ']";
    public static final String requestUpdateBTN = "//input[@value='Request Update']";

    public static final String editLink = "//span[contains(text(), 'Edit')]";
    public static final String createNewContactLink = "//span[contains(text(), 'Create New View')]";

    //New contact Page objects
    public static final String title = "#name_salutationcon2";
    public static final String firstName = "#name_firstcon2";
    public static final String lastName = "#name_lastcon2";
    public static final String accountNameToBeCreated = "#con4";
    public static final String accountTitle = "#con5";
    public static final String phone = "#con10";
    public static final String primaryContactCheckbox = "//input[@tabindex='7']";
    public static final String inactiveContactCheckbox = "#00NS00000013k8E";
    public static final String email = "#con15";
    //Mandatory address fields
    public static final String billingStreet = "#con19street";
    public static final String billingCity = "#con19city";
    public static final String postcode = "#con19zip";

    public static final String copyBillingAddressToMailingAddressLink = "//span[contains(text(), 'Copy Billing Address to Mailing Address')]";

    public static final String errorMessageEnterAValue = "//div[@class='errorMsg']";


}
