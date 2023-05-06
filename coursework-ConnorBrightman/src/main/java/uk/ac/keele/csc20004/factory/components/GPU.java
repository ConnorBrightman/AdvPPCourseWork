/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.components;

import uk.ac.keele.csc20004.SimulationParameters;

/**
 * A concrete implementation of a hardware coponent: a GPU.
 */
public class GPU extends HardwareComponent {
    public GPU() {
        super();
    }

    @Override
    public double getCost() {
        return SimulationParameters.GPU_COST;
    }
    
    @Override
    public String toString() {
        return "g(" + super.toString() + ")";
    }
}
