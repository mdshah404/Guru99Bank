package pages;

import base.BasePage;
import com.microsoft.playwright.Page;

public class NewCustomerPage extends BasePage {

    private String newCustomerLink="text=New Customer";
    private String name="input[name='name']";
    private String gender="input[value='m']";
    private String dob="input[name='dob']";
    private String address="textarea[name='addr']";
    private String city="input[name='city']";
    private String state="input[name='state']";
    private String pin="input[name='pinno']";
    private String mobile="input[name='telephoneno']";
    private String email="input[name='emailid']";
    private String password="input[name='password']";
    private String submit="input[name='sub']";

    public NewCustomerPage(Page page){
        super(page);
    }

    public void addCustomer(){

        click(newCustomerLink);

        type(name,"John");
        click(gender);
        type(dob,"01011990");
        type(address,"New York");
        type(city,"NY");
        type(state,"NY");
        type(pin,"123456");
        type(mobile,"9876543210");
        type(email,"john"+System.currentTimeMillis()+"@mail.com");
        type(password,"test123");

        click(submit);
    }
}