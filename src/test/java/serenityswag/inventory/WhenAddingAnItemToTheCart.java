package serenityswag.inventory;

import io.cucumber.java.Before;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.SerenityReports;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.cart.AddToCartActions;
import serenityswag.cart.ShoppingCartBadge;

import static org.assertj.core.api.Assertions.assertThat;

import static serenityswag.authentication.actions.User.STANDARD_USER;


@ExtendWith(SerenityJUnit5Extension.class)
public class WhenAddingAnItemToTheCart extends UIInteractionSteps {

    @Managed(driver = "chrome")
    WebDriver driver;
    @Steps
    LoginActions login;

    @Before
    public void login(){
        login.as(STANDARD_USER);
    }

    ShoppingCartBadge shoppingCartBadge;

    @Steps
    AddToCartActions addToCart;
    @Test
    public void theCorrectItemCountShouldBeShown(){
     // Check that the shopping cart badge is empty

        Serenity.reportThat("The shopping cart badge should be empty",
                () ->  assertThat(shoppingCartBadge.count()).isEmpty());

     // Add 1 item to the cart
        addToCart.item("Sauce Labs Backpack");

//     //The shopping cart badge should be "1"
        Serenity.reportThat("The shopping cart badge should be '1'",
                () -> assertThat(shoppingCartBadge.count()).isEqualTo("1"));
    }


    @Test
    public void allTheItemsShouldAppearInTheCart(){

    }
}
