/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory;

/**
 * An interface to define common methods to implement a delivery area,
 * which is a waiting space for Computer boxes before being sold. 
 * It necessarily needs to handle two queues, one for domestic, the 
 * other for internatinonal delivery.
 */
public interface DeliveryArea {
    /**
     * Adds a box to the domestic delivery queue. 
     * 
     * @param box the box to be sold to the domestic market.
     * @throws InterruptedException due to our simulation via sleep()
     */
    public void pushDomestic(ComputerBox box) throws InterruptedException;

    /**
     * Adds a box to the international delivery queue. 
     * 
     * @param box the box to be sold to the international market.
     * @throws InterruptedException due to our simulation via sleep()
     */
    public void pushInternational(ComputerBox box) throws InterruptedException;

    /**
     * Simulates the sale of a box of computers, by retrieving an element
     * from the queue of packaged machines. The requirement is that the
     * international delivery queue is checked first, then the domestic one.
     * 
     * @throws InterruptedException due to our simulation via sleep()
     */
    public ComputerBox poll() throws InterruptedException;
}
