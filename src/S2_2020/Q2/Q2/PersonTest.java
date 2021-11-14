package S2_2020.Q2.Q2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
     // Implement your test cases
    // Hint: The java.lang.Integer.intValue() is an inbuilt method in Java that returns the value of an Integer as an int.

    // ########## YOUR CODE STARTS HERE ##########
    //To test the `calcInsurancePrice()` method, which returns void, you can use the `getHealthInsurancePrice()` method, for example:
    //Person p = new Person("XYZ", 10, "XYZ", true, true);
    //assertEquals(0, p.getHealthInsurancePrice().intValue());


    @Test(timeout=1000)
    public void test() {
        Person person = new Person(" ",1,"policeman1",true,false);
        assertEquals(350, person.getHealthInsurancePrice().intValue());

    }

    @Test(timeout=1000)
    public void test2() {
        Person person = new Person(" ",41,null,true,false);
        assertEquals(400, person.getHealthInsurancePrice().intValue());

    }

    @Test(timeout=1000)
    public void test3() {
        Person person = new Person(" ",1,"",true,false);
        assertEquals(200, person.getHealthInsurancePrice().intValue());

    }

    @Test(timeout=1000)
    public void test4() {
        Person person = new Person(" ",41,"policeman",false,true);
        assertEquals(500, person.getHealthInsurancePrice().intValue());

    }

    @Test(timeout=1000)
    public void test5() {
        Person person = new Person(" ",41,"policeman",true,true);
        assertEquals(1100, person.getHealthInsurancePrice().intValue());

    }

    @Test(timeout=1000)
    public void test6() {
        Person person = new Person(" ",41,"policeman",false,false);
        assertEquals(360, person.getHealthInsurancePrice().intValue());

    }
    // ########## YOUR CODE ENDS HERE ##########

}
