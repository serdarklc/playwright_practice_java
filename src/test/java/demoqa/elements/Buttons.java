package demoqa.elements;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;
import demoqa.utils.BrowserUtils;
import demoqa.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Buttons {
    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://demoqa.com/");
        Driver.getPage().getByText("Elements").click();
        Driver.getPage().getByText("Buttons").click();
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }

    @Test
    void navigateElementsPage() {
        // Navigating the Buttons page check URL
        assertThat(Driver.getPage()).hasURL("https://demoqa.com/buttons");
    }

    @Test
    void textWebTablesVisible() {
        // Assert to Button title is visible after clicking Text Box
        assertThat(Driver.getPage().getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Buttons"))).isVisible();
    }

    @Test
    void doubleClick() {
       // ElementHandle doubleClickButton = Driver.getPage().querySelector("Double Click Me");
        Locator doubleClickButton = Driver.getPage().locator("#doubleClickBtn");
        doubleClickButton.dblclick();
        assertTrue(Driver.getPage().locator("#doubleClickMessage").textContent().contains("double click"));
    }

    @Test
    void rightClickMeButton() {
        Driver.getPage().querySelector("#rightClickBtn").click(new ElementHandle.ClickOptions().setButton(MouseButton.RIGHT));
        assertTrue(Driver.getPage().locator("#rightClickMessage").textContent().equals("You have done a right click"));
    }

    @Test
    void clickMeButton() {
        //  We have to use setExact method to match with Click Me button
        Driver.getPage().getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Click Me").setExact(true)).click();
        assertTrue(Driver.getPage().locator("#dynamicClickMessage").textContent().contains("dynamic click"));
    }

    @Test
    void testAllButton() {
        doubleClick();
        rightClickMeButton();
        clickMeButton();
    }
}