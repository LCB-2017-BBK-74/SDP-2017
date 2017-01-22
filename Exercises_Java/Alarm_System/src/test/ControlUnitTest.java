package test;

import impl.ControlUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlUnitTest {

    /**
     * Current setup of ControlUnit does not lend itself easily to tests so this simply checks that all 6 sensors
     * are listed when either triggered or polled
     */
    @Test
    public void createNewControlUnitPrintsSomeText(){
        for (int i = 0; i < 20; i++) {
            System.out.println("This is test " + i);
            ControlUnit cu = new ControlUnit();
            cu.pollSensors();
        }
    }

    @Test
    public void constructorCreatesListOfSizeSix() {
        ControlUnit cu = new ControlUnit();
        assertEquals(6, cu.getSensors().size());
    }


}
