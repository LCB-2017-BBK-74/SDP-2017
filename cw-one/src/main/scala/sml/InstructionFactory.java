package sml;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import sml.Instruction;

/**
 * Created by lucieburgess on 19/02/2017.
 * The InstructionFactory needs to generate instructions as in the commented out code in the Translator class
 *
 * First of all generateInstruction generates the class of the instruction from the opcode e.g. bnz, add
 * Then it gets the Constructor of each class
 * Gets the arguments of the instruction Constructor
 * And finally instantiates it as an object, handling the exceptions
 * Look at the Java 8 Reflect API tutorial - see docs.oracle.com/javase/tutorial/reflect/index.html
 *
 * @return an Instruction which depends on the type of instruction parameters given in the line
 */
public class InstructionFactory {

    public Instruction generateInstruction(String[] fields) {

        Instruction instr = null;

        try {
            Class instrclass = this.generateClass(fields);
            Constructor[] cons = instrclass.getConstructors();
            Object[] consparams = generateConstructorObjects(fields, cons[0].getParameterTypes());
            instr = (Instruction) cons[0].newInstance(consparams);
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return instr;
    }

    Object[] generateConstructorObjects(String[] fields, Class[] cparams) { //package-private

        if (fields.length != cparams.length) {
            throw new IllegalArgumentException("Instruction objects and construction parameters must be same length");
        }
        Object[] resultObject = new Object[fields.length];

        for (int i = 0; i < fields.length; i++) {
            try {
                if (cparams[i].getName().equals("int")) {
                    resultObject[i] = Integer.parseInt(fields[i]); //parse as Int
                } else {
                    resultObject[i] = fields[i]; //parse as String
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        return resultObject;
    }

    /**
     * This method generates the class of the instruction from the instruction opcode, assuming provided in the text file
     * as either upper case or lower case letters.
     * @param fields the array of strings passed in by the Translator
     * @return the class of the instruction to be instantiated
     */
    public Class generateClass(String[] fields) {
        Class instrcl = null;
        String classType = fields[1].toLowerCase();
        String firstLetter = classType.substring(0,1).toUpperCase();
        String className = "sml.".concat(fields[1].substring(0,1).toUpperCase()).concat(fields[1].substring(1).toLowerCase()).concat("Instruction");
        try {
            instrcl = Class.forName(className);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return instrcl;
    }

}

