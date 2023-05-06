/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.components;

/**
 * An abstract class defining the basic characteristics of a hardware
 * component for our (simulated) computer factory: a component will
 * be characterised by a unique serial number, a cost and the time it
 * takes to produce it (in this implementation, it is assumed that the
 * time, in ms, is the same as the cost).
 */
public abstract class HardwareComponent {
    private final static int INVALID_SERIAL = -1;
    protected int serialNo;

    /**
     * The constructor creates a new component without a serial number
     * (i.e. with an invalid one). The cost is not known in this abstract 
     * implementation and will need to be specified in the concrete ones.
     */
    public HardwareComponent() {
        this.serialNo = INVALID_SERIAL;
    }

    /**
     * The constructor will only need the serial number; 
     * 
     * @param serialNo the serial number for this part
     */
    void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * Return the serial number of the part
     * 
     * @return the serial number of the part
     */
    public int getSerialNo() {
        return serialNo;
    }

    public boolean isSerialValid() {
        return (serialNo != INVALID_SERIAL);
    }

    /**
     * Returns the cost (in "money units") of this part.
     * The cost is not known in this abstract implementation and
     * will need to be specified in the concrete ones.
     * 
     * @return the cost of this component
     */
    public abstract double getCost();

    /**
     * This method can be used when simulating the assembling
     * of a hardware component by putting a thread to sleep.
     * 
     * @return the time (in ms) it takes to produce this component
     */
    public long getAssemblyTime() {
        return Math.round(getCost());
    }

    @Override
    public String toString() {
        return Integer.toString(serialNo);
    }
}
