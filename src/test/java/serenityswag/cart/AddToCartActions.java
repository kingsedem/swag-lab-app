package serenityswag.cart;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import serenityswag.inventory.ProductList;

public class AddToCartActions extends UIInteractions {

    @Step("Add {0} to the cart")
    public void item(String itemName) {
        $(ProductList.addToCartButtonFor(itemName)).click();
    }
}
