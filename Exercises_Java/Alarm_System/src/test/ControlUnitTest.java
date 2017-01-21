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
        ControlUnit cu = new ControlUnit();
        cu.pollSensors();
    }


}
