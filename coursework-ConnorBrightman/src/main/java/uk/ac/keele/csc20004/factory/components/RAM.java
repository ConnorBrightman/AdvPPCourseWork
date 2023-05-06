/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.components;

import uk.ac.keele.csc20004.SimulationParameters;

/**
 * A concrete implementation of a hardware coponent: a RAM unit.
 */
public class RAM extends HardwareComponent {
    public RAM() {
        super();
    }

    @Override
    public double getCost() {
        return SimulationParameters.RAM_COST;
    }
    
    @Override
    public String toString() {
        return "r(" + super.toString() + ")";
    }
}
