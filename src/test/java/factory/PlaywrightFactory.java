package factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    private static ThreadLocal<Page> page = new ThreadLocal<>();
    private static ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static ThreadLocal<Playwright> playwright = new ThreadLocal<>();

    public static Page initBrowser(String browserName){

        playwright.set(Playwright.create());

        switch(browserName){

            case "firefox":
                browser.set(playwright.get().firefox().launch());
                break;

            case "webkit":
                browser.set(playwright.get().webkit().launch());
                break;

            default:
                browser.set(playwright.get().chromium().launch(
                        new BrowserType.LaunchOptions().setHeadless(false)));
        }

        BrowserContext context = browser.get().newContext();

        page.set(context.newPage());

        return page.get();
    }

    public static Page getPage(){
        return page.get();
    }

    public static void closeBrowser(){

        browser.get().close();
        playwright.get().close();
    }
}