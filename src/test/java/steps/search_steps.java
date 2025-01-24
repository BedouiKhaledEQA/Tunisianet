package steps;

import com.Tunisianet.Base;
import com.Tunisianet.Pages.search_Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class search_steps extends Base {
    @When("user fill the item looking for in the searching box and click on search button")
    public void user_fill_the_item_looking_for_in_the_searching_box_and_click_on_search_button() throws InterruptedException {
        search_Page.getInstance().perform_Search_Item();

    }
    @Then("item should be displayed")
    public void item_should_be_displayed() {
        search_Page.getInstance().perform_Assertion_Item();

    }

}
