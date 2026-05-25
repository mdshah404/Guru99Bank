package pages;

import base.BasePage;
import com.microsoft.playwright.Page;

public class ManagerHomePage extends BasePage {

    private String managerText="text=Welcome To Manager";

    public ManagerHomePage(Page page){
        super(page);
    }

    public boolean verifyManagerLogin(){

        return isVisible(managerText);
    }
}