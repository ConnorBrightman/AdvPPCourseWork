/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.components;

import uk.ac.keele.csc20004.SimulationParameters;

/**
 * A concrete implementation of a hardware coponent: a Motherboard.

 */
public class MotherBoard extends HardwareComponent {
    public MotherBoard() {
        super();
    }

    @Override
    public double getCost() {
        return SimulationParameters.MB_COST;
    }
    
    @Override
    public String toString() {
        return "m(" + super.toString() + ")";
    }
}
