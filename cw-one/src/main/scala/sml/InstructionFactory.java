package sml;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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

    private Instruction instr = null;

    public Instruction generateInstruction(String[] fields) {
        Class instrclass = this.generateClass(fields); // generate class of the instruction from opcode e.g. bnz, add

        //Get the constructor arguments by parsing the program line as ints or strings
        Object[] cparams = new Object[fields.length - 1]; // initialise array to the length of fields - 1 (as we don't want opcode)

        for (int i = 0; i <= fields.length; i++) {
            try {
                cparams[i] = Integer.parseInt(fields[i]); // if it doesn't parse as an Integer we want to keep as a string
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
            try {
                cparams[i] = fields[i];
            } catch (IllegalStateException ex) { //exception if incompatible types? Do we need to handle exceptions here?
                ex.printStackTrace();
            }
        }

        // Get the constructor argument types, i.e. ints or strings
        Class[] cparamsTypes = new Class[fields.length - 1]; //inititialise empty Class array to the length of fields
        for (int i = 0; i < fields.length; i++) {
            cparamsTypes[i] = cparams[i].getClass();
        }

        Constructor cons = null;
        try {
            cons = instrclass.getConstructor(cparamsTypes); // NoSuchMethodException
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        }
        try {
            instr = (Instruction) cons.newInstance(cparams); //InstantationException, IllegalAccessException, InvocationTargetException
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return instr;
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
        String firstLetter = classType.substring(0).toUpperCase();
        String className = firstLetter.concat(classType.substring(1,3)).concat("Instruction");
        try {
            instrcl = Class.forName(className);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return instrcl;
    }

    public static void main(String[] Args) {
        Class instrcl = null;
        String [] fields =

    }

}

