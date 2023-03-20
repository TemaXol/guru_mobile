package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    @Tag("android")
    void successfulSearchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("java");
        });
        step("Verify content", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0));
        });
    }

    @Tag("android")
    @Test
    void openTheLinkTest() {
        step("click on the link on the main page", () -> {
            $(id("org.wikipedia.alpha:id/horizontal_scroll_list_item_text")).click();
        });
        step("Verify content found", () ->
                $(id("org.wikipedia.alpha:id/view_news_fullscreen_story_text"))
                        .shouldHave(text(
                                "At the Academy Awards, Everything Everywhere All at Once wins seven awards, including Best Picture and Best Actress for Michelle Yeoh (pictured).")));
    }

    @Test()
    @Tag("ios")
    void iosCheckInputTest() {
        step("Type search", () -> {
            $(accessibilityId("Text Button")).click();
        });
        step("Check that text input should be visible ", () -> {
            $(accessibilityId("Text Input")).shouldBe(visible);
        });
    }

}