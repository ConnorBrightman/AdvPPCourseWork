/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.sample;

import uk.ac.keele.csc20004.factory.components.GPU;
import uk.ac.keele.csc20004.factory.components.HardwareComponent;
import uk.ac.keele.csc20004.factory.computers.AbstractComputer;

/**
 * A sample class to show how a new type of computer can
 * be defined: in this case, it's completely imaginary as 
 * it is made up of a GPU only.
 */
public class SampleComputer extends AbstractComputer {

    /**
     * Creates a new "sample computer"
     * 
     * @param gpu the only component of this type of machine
     */
    public SampleComputer(GPU gpu) {
        super(new HardwareComponent[]{gpu});
    }

    @Override
    public String toString() {
        return "SC" + super.toString();
    }

}
