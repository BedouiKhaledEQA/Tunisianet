package steps;

import com.Tunisianet.Base;
import com.Tunisianet.Pages.register_Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class register_steps extends Base {
    @When("User fill the data in the form and click on save button")
    public void user_fill_the_data_in_the_form_and_click_on_save_button() throws InterruptedException {
        register_Page.getInstance().performRegister();

    }
    @Then("User account should be registered")
    public void user_account_should_be_registered() {
        //register_Page.getInstance().performRegisterAssertion();

    }
}
