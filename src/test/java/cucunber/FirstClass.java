package cucunber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstClass {

    @Given("^g Input num (\\d+)$")
    public void g(int i){
        System.out.println("g" + i);
    }

    @When("^w Input num (\\d+)$")
    public void v(int i){
        System.out.println("w" + i);
    }

    @Then("^t Input num (\\d+)$")
    public void t(int i){
        System.out.println("t" + i);
    }

}
