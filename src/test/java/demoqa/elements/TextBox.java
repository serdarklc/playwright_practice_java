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

public class TextBox {

    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://demoqa.com/");
        Driver.getPage().getByText("Elements").click();
        Driver.getPage().getByText("Text Box").click();
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }

    @Test
    void navigateElementsPage() {
        assertThat(Driver.getPage()).hasURL("https://demoqa.com/text-box");
    }

    @Test
    void textBoxVisible() {
        // Assert to Text Box title is visible after clicking Text Box
        assertThat(Driver.getPage().getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Text Box"))).isVisible();
    }

    @Test
    void submitTextBox() {
        //Submit TextBox using CRM data
        CRMUtil.loginTextBox();
        BrowserUtils.sleepWithThread(3);
        //Write result after clicking submit
        for (int i = 0; i < 4; i++) {
            Locator submitedField = Driver.getPage().locator("div[class='border col-md-12 col-sm-12'] p").nth(i);
            Assertions.assertTrue(submitedField.isVisible());
            System.out.println(submitedField.textContent());
        }
    }
}
