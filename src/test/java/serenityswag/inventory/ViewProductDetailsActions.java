package serenityswag.inventory;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class ViewProductDetailsActions extends UIInteractionSteps {
    @Step("View product details for product '{0}'")
    public void forProductsWithName(String firstItemName) {

        $(ProductList.productDetailsLinkFor(firstItemName)).click();
    }
}
