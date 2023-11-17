package serenityswag.authentication.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.steps.UIInteractionSteps;



public class LoginActions extends UIInteractionSteps {

    @Step("Login as {0}")
    public void as(User user) {
        openUrl("https://www.saucedemo.com/");
        // Login as a standard user
//        $("[data-test='username']").sendKeys(user.getUsername());
//        $("[data-test='password']").sendKeys(user.getPassword());
//        $("[data-test='login-button']").click();

         $(LoginForm.USER_NAME).sendKeys(user.getUsername());
         $(LoginForm.PASSWORD).sendKeys(user.getPassword());
         $(LoginForm.LOGIN_BUTTON).click();


    }


}
