/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory;

import uk.ac.keele.csc20004.factory.components.AssemblyStation;
import uk.ac.keele.csc20004.factory.components.GPU;
import uk.ac.keele.csc20004.factory.components.MotherBoard;
import uk.ac.keele.csc20004.factory.components.RAM;
import uk.ac.keele.csc20004.factory.computers.Computer;

/**
 * Interface defining the functionalities that are expected
 * in our simulation of a company manufaturing computers.
 */
public interface ComputerCompany {
    /**
     * @return the station hadling RAM components
     */
    public AssemblyStation<RAM> getRAMAssemblyStation();

    /**
     * @return the station hadling GPU components
     */
    public AssemblyStation<GPU> getGPUAssemblyStation();

    /**
     * @return the station hadling MotherBoard components
     */
    public AssemblyStation<MotherBoard> getMBAssemblyStation();

    /**
     * Adds the computer to the temporary storage area, before
     * the machine can be packaged into a box for domestic delivery.
     * 
     * @param c the newly produced Computer to be put in a box
     */
    public void enqueueForDomesticPackaging(Computer c);

    /**
     * @return a box of Computers intended for domestic delivery
     */
    public ComputerBox getDomesticPackage();

    /**
     * Adds the computer to the temporary storage area, before
     * the machine can be packaged into a box for international delivery.
     * 
     * @param c the newly produced Computer to be put in a box
     */
    public void enqueueForInternationalPackaging(Computer c);

     /**
     * @return a box of Computers intended for international delivery
     */
    public ComputerBox getInternationalPackage();

    /**
     * Adds a computer box to the domestic delivery queue,
     * ready to be sold.
     * 
     * @param b the box to be sold to the domestic market
     * @throws InterruptedException due to our simulation via sleep()
     */
    public void enqueueForDomesticDelivery(ComputerBox b) throws InterruptedException;

    /**
     * Adds a computer box to the international delivery queue,
     * ready to be sold.
     * 
     * @param b the box to be sold to the international market
     * @throws InterruptedException due to our simulation via sleep()
     */
    public void enqueueForInternationalDelivery(ComputerBox b) throws InterruptedException;

    /**
     * Simulates the sale of a box of computers, by retrieving an element
     * from the queue of packaged machines. The requirement is that the
     * international delivery queue is checked first, then the domestic one.
     * 
     * @throws InterruptedException due to our simulation via sleep()
     */
    public ComputerBox sell() throws InterruptedException;
}
