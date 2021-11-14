package S2_2020.Q2.Q2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PersonRepositoryTest {

    SequenceGenerator sequenceGenerator;
    PersonRepository personRepository;

    @Before
    public void before() {
        sequenceGenerator = new SequenceGenerator();
        personRepository = new PersonRepository();
        personRepository.setSequenceGenerator(sequenceGenerator);
    }

    // Implement your test cases
    // Hint: The java.lang.Integer.intValue() is an inbuilt method in Java that returns the value of an Integer as an int.

    // ########## YOUR CODE STARTS HERE ##########

    @Test(expected = RuntimeException.class)
    public void testException() {
        Person person = new Person(" ",1,"policeman1",true,false);
        person.setId(1);
        personRepository.save(person);

    }

    @Test(timeout=1000)
    public void test() {
        Person person = new Person("1 ",1,"policeman1",true,false);
        personRepository.save(person);


        assertEquals(Integer.valueOf(1), person.getId());
        assertEquals(person,personRepository.findById(Integer.valueOf(1)));

    }

    // ########## YOUR CODE ENDS HERE ##########


}
