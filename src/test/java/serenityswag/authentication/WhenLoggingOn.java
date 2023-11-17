package serenityswag.authentication;


import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.openqa.selenium.WebDriver;

import serenityswag.authentication.actions.LoginActions;
import serenityswag.inventory.InventoryPage;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.actions.User.*;


@ExtendWith(SerenityJUnit5Extension.class)
public class WhenLoggingOn  {
    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    LoginActions login;
    InventoryPage inventoryPage;


    @Test
    public void usersCanLogOnViaTheHomePage(){
        login.as(STANDARD_USER);
        //login.as(LOCKED_OUT_USER);
        //login.as(VISUAL_USER);

        //Should see product catalog
        Serenity.reportThat("The inventory page should be displayed with the correct title",
                () -> assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("Products"));
    }
}
