package demoqa.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import demoqa.utils.BrowserUtils;
import demoqa.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UploadAndDownload {
    @BeforeEach
    void setUp() {
        Driver.getPage().navigate("https://demoqa.com/");
        Driver.getPage().getByText("Elements").click();
        Driver.getPage().getByText("Upload and Download").click();
    }

    @AfterEach
    void tearDown() {
        BrowserUtils.sleepWithThread(3);
        Driver.closeDriver();
    }

    @Test
    void navigateUploadAndDownloadPage() {
        assertThat(Driver.getPage()).hasURL("https://demoqa.com/upload-download");
    }

    @Test
    void textBoxVisible() {
        // Assert to Text Box title is visible after clicking Text Box
        assertThat(Driver.getPage().getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Upload and Download"))).isVisible();
    }

    @Test
    void chooseAndDownload() {
        Driver.getPage().locator("#uploadFile").setInputFiles(Paths.get("src/test/resources/TestForPlaywright.txt"));
        BrowserUtils.sleepWithThread(3);
        Driver.getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Download")).click();
        BrowserUtils.sleepWithThread(3);

    }
}
