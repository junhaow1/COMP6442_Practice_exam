package S2_2020.Q2.Q2;

import java.util.HashMap;
import java.util.Map;

public class PersonRepository {

    static Map<Integer, Person> personMap = new HashMap<Integer, Person>();
    SequenceGenerator sequenceGenerator;

    public Person save(Person person) {
        if(person.getId() != null) {
            throw new RuntimeException("Person instance must have null id");
        }
        person.setId(sequenceGenerator.nextVal());
        System.out.println(person.getId());
        personMap.put(person.getId(), person);
        return person;
    }

    public Person findById(Integer id) {
        return personMap.get(id);
    }

    public boolean setSequenceGenerator(SequenceGenerator sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
        return true;
    }
}
