package base;

import com.microsoft.playwright.Page;

public class BasePage {

    protected Page page;

    public BasePage(Page page){
        this.page = page;
    }

    public void click(String locator){
        page.click(locator);
    }

    public void type(String locator,String text){
        page.fill(locator,text);
    }

    public String getText(String locator){
        return page.textContent(locator);
    }

    public boolean isVisible(String locator){
        return page.isVisible(locator);
    }
}