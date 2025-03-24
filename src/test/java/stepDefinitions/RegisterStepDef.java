package stepDefinitions;
import java.util.Map;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountSuccessPage;
import pageObjects.MyAccountHomePage;
import pageObjects.RegisterPage;
import utilities.StringUtilities;

public class RegisterStepDef {
	MyAccountHomePage map = new MyAccountHomePage(BaseClass.getDriver());
	RegisterPage rp = new RegisterPage(BaseClass.getDriver());
	AccountSuccessPage asp = new AccountSuccessPage(BaseClass.getDriver());
	Logger logger = BaseClass.getLogger();
	@Given("user is on register page")
	public void user_is_on_register_page() {
		map.clickOnMyAcc();
		map.clickRegisterBtn();
		logger.info("click action successful for on my account and register button");
	}

	@When("user provides test data with following inputs perform continue action")
	public void user_provides_test_data_with_following_inputs_perform_continue_action(DataTable dataTable) {
	    Map<String, String> registerData = dataTable.asMap(String.class, String.class);
	    rp.setRegisterData(registerData.get("firstName"), 
	    			       registerData.get("lastName"),
	    			       StringUtilities.generateRandomMail(), 
	    			       StringUtilities.generateMobileNum(),
	    			       registerData.get("password"),
	    			       registerData.get("confirmPass"));
	    logger.info("provided test data to the register fields and clicked on continue button");
	}

	@Then("verify account registration success message is displayed")
	public void verify_account_registration_success_message_is_displayed() {
		boolean registerCreateStatus = asp.registerSucStatus();
		Assert.assertTrue(registerCreateStatus);
		logger.info("Scenario got completed");
	}




}
