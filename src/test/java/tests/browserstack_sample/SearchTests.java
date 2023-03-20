package tests.browserstack_sample;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class SearchTests extends TestBase {


    @Test
    void successfulSearchTest() throws InterruptedException {
        $(accessibilityId("Search Wikipedia")).click();
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("java");
        $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                .shouldHave(sizeGreaterThan(0));

    }

}