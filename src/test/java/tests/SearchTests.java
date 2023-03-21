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
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void CheckGoogle() {

        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("google");
        });
        step("Verify content", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0));
        });
    }

    @Test()
    @Tag("android")
    void checkSettingsTest() {
        step("Type search", () -> {
            $(id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });
        step("Check button log in", () -> {
            $(id("org.wikipedia.alpha:id/explore_overflow_settings")).shouldHave(text("Settings"));
            $(id("org.wikipedia.alpha:id/explore_overflow_settings")).click();
        });
        step("Verify content", () -> {
            $(id("android:id/title")).shouldHave(text("Wikipedia language"));
        });

    }

    @Test()
    @Tag("ios")
    void loginTestFlight() {
        step("Type search", () -> {
            $(accessibilityId("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });
        step("Check button log in", () -> {
            $(id("org.wikipedia.alpha:id/explore_overflow_account_name")).shouldHave(text("Settings"));
            $(id("org.wikipedia.alpha:id/explore_overflow_account_name")).click();
        });
        step("Verify content", () -> {
            $(id("org.wikipedia.alpha:id/action_bar")).shouldHave(text("Settings"));
        });

    }
}