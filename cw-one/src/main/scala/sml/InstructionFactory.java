package sml;

import java.lang.reflect.Constructor;
import sml.Instruction;

/**
 * Created by lucieburgess on 19/02/2017.
 * The InstructionFactory needs to generate instructions as in the commented out code in the Translator class
 * fields(1) match {
 * case ADD =>
 * program = program :+ AddInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
 * case LIN =>
 * program = program :+ LinInstruction(fields(0), fields(2).toInt, fields(3).toInt)
 * @return an Instruction which depends on the type of instruction parameters given in the line
 *         Need to generate a constructor depending on the type of instruction
 *         Generate the class name and therefore the type of instruction
 *         And then populate the constructor with the parameters given in the array 'fields'
 *         Fields(1) is the same as the prefix of the class. So should be able to generate classname from the prefix
 *         The remaining parameters are either ints or strings. If they are ints you can parse them as ints
 *          Look at the Java 8 Reflect API tutorial - see docs.oracle.com/javase/tutorial/reflect/index.html
 */
public class InstructionFactory {

    public InstructionFactory() {
        this = null;
    }

    private Instruction generateInstruction(Object[] fields) {

        Instruction instr = ??? //Generate constructor from the class depending on the parameters in fields()
        //TO DO
    }

    /**
     * @param fields
     * @return the class of the instruction to be instantiated
     */
    private Class generateClass(Object[] fields) {
        Class instrclass = null;
        String classType = fields[1].toString().toLowerCase();
        String firstLetter = classType.substring(0).toUpperCase();
        String className = firstLetter.concat(classType.substring(1,2)).concat("Instruction");
        try {
            instrclass = Class.forName(className);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return instrclass;
    }



}