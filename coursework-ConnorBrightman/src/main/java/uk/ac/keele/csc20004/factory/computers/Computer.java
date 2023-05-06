/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.computers;

/**
 * Interface defining the  basic characteristics of a computer for 
 * our (simulated) manufacturing company. Just as for the hardware parts, 
 * an assembled computer is characterised by having a cost and a 
 * production time.
 */
public interface Computer {    

    /**
     * Sets a serial number for this computer.
     * For a serial number to be valid, it needs to
     * correspond to the sum of the serial numbers of 
     * the computer's components
     * 
     * @param serialNo the serial number for this machine
     */
    public void engrave(int serialNo);

    /**
     * Returns the cost (in "money units") of this machine.
     * The cost will typically result from the sum of the costs 
     * of its hardware components. 
     * 
     * @return the cost of this machine
     */
    public double getCost();

    /**
     * This method can be used when simulating the production
     * of a new machine by putting a thread to sleep.
     * 
     * @return the time (in ms) it takes to produce this component
     */
    public long getProductionTime();
}
