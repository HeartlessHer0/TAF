
import org.testng.annotations.Test;

public class GroupsTest {
    @Test(groups = "Smoke")
    public void stepb(){
        System.out.println("stepb...");
    }
    @Test(groups = "Regression")
    public void stepa() {System.out.println("stepa...");}
    @Test(groups = "Regression")
    public void stepd(){
        System.out.println("stepd...");
    }
    @Test(groups = {"Smoke","Regression"} )
    public void stepc(){
        System.out.println("stepc...");
    }
}
