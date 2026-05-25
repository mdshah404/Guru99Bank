package pages;

import base.BasePage;
import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    private String userId="input[name='uid']";
    private String password="input[name='password']";
    private String loginBtn="input[name='btnLogin']";

    public LoginPage(Page page){
        super(page);
    }

    public void login(String user,String pass){

        type(userId,user);
        type(password,pass);
        click(loginBtn);
    }
}