/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.computers;

import uk.ac.keele.csc20004.factory.components.GPU;
import uk.ac.keele.csc20004.factory.components.HardwareComponent;
import uk.ac.keele.csc20004.factory.components.MotherBoard;
import uk.ac.keele.csc20004.factory.components.RAM;

/**
 * A concrete implementation of a Computer: a Server. 
 * Basically, the constructor just contraints the hardware components 
 * to be the ones that define a Laptop according to the coursework specs
 */
public class Server extends AbstractComputer {
    public Server(RAM ram, GPU gpu, MotherBoard mb) {
        super(new HardwareComponent[]{ram, gpu, mb});
    }
    
    
    @Override
    public String toString() {
        return "S" + super.toString();
    }
}
