package demoqa.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import demoqa.utils.BrowserUtils;
import demoqa.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrokenLinksImages {
    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://demoqa.com/");
        Driver.getPage().getByText("Elements").click();
        Driver.getPage().getByText("Broken Links - Images", new Page.GetByTextOptions().setExact(true)).click();
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }


    @Test
    void brokenImage() {
        Locator images = Driver.getPage().locator("img");
        int count = images.count();

        for (int i = 0; i < count; i++) {
            // Check naturalWidth of each image
            int naturalWidth = (int) images.nth(i).evaluate("img => img.naturalWidth");

            // If naturalWidth is 0, image is broken
            if (naturalWidth == 0) {
                System.out.println("Broken image found: " + images.nth(i).getAttribute("src"));
            } else {
                System.out.println("Image is OK: " + images.nth(i).getAttribute("src"));
            }
        }
    }

    @Test
    void brokenLink() {
    }
}

