package demoqa.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import demoqa.utils.BrowserUtils;
import demoqa.utils.CRMUtil;
import demoqa.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckBox {

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://demoqa.com/");
        Driver.getPage().getByText("Elements").click();
        Driver.getPage().getByText("Check Box").click();
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }

    @Test
    void navigateCheckBoxPage() {
        assertThat(Driver.getPage()).hasURL("https://demoqa.com/checkbox");
    }

    @Test
    void selectHomeFolder() {
        Locator homeFolder = Driver.getPage().locator(".rct-title");
        homeFolder.check();
        assertTrue(homeFolder.isChecked());

        Locator result = Driver.getPage().getByTestId("result");
        System.out.println(result.textContent());
    }

    @Test
    void checkSubFolder() {
        Driver.getPage().locator("//button[@title='Toggle']").click();

        // Selecting Check boxes
        Locator desktopFolder = Driver.getPage().getByText("Desktop", new Page.GetByTextOptions().setExact(true));
        desktopFolder.check();
        assertTrue(desktopFolder.isChecked());
        BrowserUtils.sleepWithThread(1);

        Locator documentsFolder = Driver.getPage().getByText("Documents", new Page.GetByTextOptions().setExact(true));
        documentsFolder.check();
        assertTrue(documentsFolder.isChecked());
        BrowserUtils.sleepWithThread(1);

        Locator downloadsFolder = Driver.getPage().getByText("Downloads", new Page.GetByTextOptions().setExact(true));
        downloadsFolder.check();
        assertTrue(downloadsFolder.isChecked());
        BrowserUtils.sleepWithThread(1);

        // Unchecking checkboxes
        desktopFolder.uncheck();
        assertFalse(desktopFolder.isChecked());
        BrowserUtils.sleepWithThread(1);
        documentsFolder.uncheck();
        assertFalse(documentsFolder.isChecked());
        BrowserUtils.sleepWithThread(1);
        downloadsFolder.uncheck();
        assertFalse(downloadsFolder.isChecked());
    }

    @Test
    void expandCollapseButtons() {
        Locator expandButton = Driver.getPage().getByLabel("Expand all");
        expandButton.click();
        Locator folders = null ;

        for (int i = 0; i < 17; i++) {
            folders = Driver.getPage().locator(".rct-text").nth(i);
            if (folders.isVisible()){
                System.out.println(folders.textContent());
            }
        }

        BrowserUtils.sleepWithThread(2);

        Locator collapseButton = Driver.getPage().getByLabel("Collapse all");
        collapseButton.click();
        for (int i = 1; i < 17; i++) {
            folders = Driver.getPage().locator(".rct-text").nth(i);
            assertFalse(folders.isVisible());
        }
    }
}
