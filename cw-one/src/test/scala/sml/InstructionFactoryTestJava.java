package sml;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by lucieburgess on 23/02/2017, Updated 05/05/2017
 */
public class InstructionFactoryTestJava {

    String[] fields = {"F3", "mul", "21", "25", "7"};
    InstructionFactory instrFactory = new InstructionFactory();

    @Test
    public void generateClassFromOpcodeReturnsCorrectClass() {
        Class instrClass = instrFactory.generateClass(fields);
        System.out.println(instrClass.toString());
        assertEquals (instrClass, sml.MulInstruction.class);
    }

    @Test
    public void generateConstructorObjectsReturnsObjectArray() {
        Class instrclass = instrFactory.generateClass(fields);
        Constructor[] cons = instrclass.getConstructors();
        Object[] result = instrFactory.generateConstructorObjects(fields, cons[0].getParameterTypes());
        System.out.println(result.toString());
    }

    @Test
    public void generateInstructionReturnsInstruction() {
        Instruction instr = instrFactory.generateInstruction(fields);
        System.out.println(instr.toString());
    }

}
