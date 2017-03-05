package sml;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by lucieburgess on 23/02/2017.
 */
public class InstructionFactoryTestJava {

    String[] fields = {"F3", "mul", "21", "25", "7"};
    InstructionFactory instrFact = new InstructionFactory();

    @Test
    public void generateClassFromOpcodeReturnsCorrectClass() {
        Class instrClass = instrFact.generateClass(fields);
        assertEquals(instrClass, MulInstruction.class);
    }

}
