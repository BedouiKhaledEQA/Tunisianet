package steps;

import com.Tunisianet.Base;
import com.Tunisianet.Pages.login_Page;
import com.Tunisianet.Pages.register_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login_steps extends Base {
    @Given("User open the browser")
    public void user_open_the_browser() {
        luncher();

    }
    @When("User fill the email and password and click on login button")
    public void user_fill_the_email_and_password_and_click_on_login_button() throws InterruptedException {
        login_Page.getInstance().performLogin();

    }
    @Then("User should navigate at Homepage")
    public void user_should_navigate_at_homepage() throws InterruptedException {
        login_Page.getInstance().performLoginAssertion();

    }
}
