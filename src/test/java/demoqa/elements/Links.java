package demoqa.elements;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import demoqa.utils.BrowserUtils;
import demoqa.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Links {
    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://demoqa.com/");
        Driver.getPage().getByText("Elements").click();
        Driver.getPage().getByText("Links", new Page.GetByTextOptions().setExact(true)).click();
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }

    @Test
    void navigateElementsPage() {
        // Navigating the Buttons page check URL
        assertThat(Driver.getPage()).hasURL("https://demoqa.com/links");
    }

    @Test
    void textWebTablesVisible() {
        // Assert to Button title is visible after clicking Text Box
        assertThat(Driver.getPage().getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Links"))).isVisible();
    }

    @Test
    void allLinks() {
        // all link on the page are locating
        List<ElementHandle> links = Driver.getPage().querySelectorAll("#linkWrapper a");
        for (ElementHandle link : links) {
            System.out.println(link.textContent());
        }
    }

    @Test
    void clickHomeLink() {
        // Open new tab header
        String headerOpenNewTab = Driver.getPage().getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Following links will open new tab")).textContent();
        Assertions.assertEquals("Following links will open new tab", headerOpenNewTab);
        // Wait for the new tab to open when clicking the link
        Page newPage = Driver.getPage().waitForPopup(() -> {
            Driver.getPage().click("#simpleLink"); // Click the link that opens a new tab
        });
        // Wait for the new tab to load content
        newPage.waitForLoadState();
        // Assert the URL of the new tab
        String newPageURL = newPage.url();
        Assertions.assertEquals("https://demoqa.com/", newPageURL);
        // Assert the title of the new tab
        String newPageTitle = newPage.title();
        Assertions.assertEquals("DEMOQA", newPageTitle);
    }

    @Test
    void clickHomeYzRNc() {
        // Wait for the new tab to open when clicking the link
        Page newPage = Driver.getPage().waitForPopup(() -> {
            Driver.getPage().click("#dynamicLink"); // Click the link that opens a new tab
        });
        // Wait for the new tab to load content
        newPage.waitForLoadState();
        // Assert the URL of the new tab
        String newPageURL = newPage.url();
        Assertions.assertEquals("https://demoqa.com/", newPageURL);
        // Assert the title of the new tab
        String newPageTitle = newPage.title();
        Assertions.assertEquals("DEMOQA", newPageTitle);
    }

    @Test
    void name() {
        // Array of API call buttons with expected responses
        String[][] apiCallData = {
                {"#created", "201"},
                {"#no-content", "204"},
                {"#moved", "301"},
                {"#bad-request", "400"},
                {"#unauthorized", "401"},
                {"#forbidden", "403"},
                {"#invalid-url", "404"}
        };

        // Iterate through the array and validate each API call link
        for (String[] apiCall : apiCallData) {
            clickAndValidateApiCall(apiCall[0], apiCall[1]);
        }
    }

    private void clickAndValidateApiCall(String locator, String expectedResponse) {
        // Wait for the element to be visible
        Driver.getPage().locator(locator).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        // Click the element
        Driver.getPage().locator(locator).click();

        // Sleep for 2 seconds (can be replaced by more reliable wait conditions if needed)
        BrowserUtils.sleepWithThread(2);

        // Validate the response content
        Assertions.assertTrue(Driver.getPage().locator("#linkResponse").textContent().contains(expectedResponse),
                "Expected response code " + expectedResponse + " not found for " + locator);
    }
}

