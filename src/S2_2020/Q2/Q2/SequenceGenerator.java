package S2_2020.Q2.Q2;

public class SequenceGenerator {

    private static Integer ID_GENERATOR = 0;

    public Integer nextVal() {
        ID_GENERATOR++;
        return ID_GENERATOR;
    }
}
