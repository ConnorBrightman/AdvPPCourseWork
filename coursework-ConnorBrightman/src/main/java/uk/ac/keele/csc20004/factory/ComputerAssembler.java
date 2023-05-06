/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory;

import uk.ac.keele.csc20004.factory.computers.Computer;

/**
 * Interface defining the functionality of a production line 
 * worker (an assembler). Basically their only job is to assemble
 * a Computer, assuming the necessay parts are available.
 */
public interface ComputerAssembler {
    /**
     * The method that creates a new maxchine from its components. 
     * It will use the stations to validate the components (those
     * need to be available), then engrave a serial number on 
     * the machine and unload the stations.
     * 
     * @return a new Computer, created from components
     * @throws InterruptedException due to our simulation via sleep()
     */
    public Computer assemble() throws InterruptedException;
}
