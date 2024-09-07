package demoqa.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Driver {

    // Constructor is creating
    public Driver(){}

    // We are creating Singleton Design Pattern
    static private Playwright playwright;
    static private Browser browser;
    static private Page page;

    public static Page getPage() {

        // We are deciding the browser type
        String browserFromConfig = ConfigurationReader.getProperty("browser");

        if (page == null) {
            playwright = Playwright.create();
            playwright.selectors().setTestIdAttribute("id");
            // instead of data-testid, id is used bc of it hasn't known yet from devs
            // data-testid belongs to Playwright as a default setting
            // we manipulated it

            switch (browserFromConfig.toLowerCase()) {
                case "chrome":
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    page = browser.newContext().newPage();
                    break;

                case "firefox":
                    browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                    page = browser.newContext().newPage();
                    break;
            }
        }

        return page;
    }


    public static void closeDriver() {
        if (page != null) {
            page.close();
            page = null;
            browser.close();
            browser = null;
            playwright.close();
            playwright = null;
        }
    }
}
