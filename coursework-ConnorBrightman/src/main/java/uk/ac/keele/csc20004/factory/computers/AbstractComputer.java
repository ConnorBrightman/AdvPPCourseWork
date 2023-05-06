/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.computers;

import java.util.Arrays;

import uk.ac.keele.csc20004.factory.components.HardwareComponent;

/**
 * This abstract class provides a basic implementation of the
 * methods common to all types of machines. In particular, it
 * defines the cost as the sum of the costs of the components, and
 * the production time as equal to the cost.
 * It also defines the method to engrave a serial number for the machine:
 * note that the serial number *must* correspond to the sum of the srial numbers
 * of the components (basically: a way to check the machine was built properly)
 */
public abstract class AbstractComputer implements Computer {
    protected final static int INVALID_SERIAL = -1;

    protected HardwareComponent[] components;

    private int serialNo;

    /**
     * Any machine is defined as a collection of parts, so
     * the constructor just takes an array of generic HardwarePart
     * 
     * @param components an array containing the components
     */
    public AbstractComputer(HardwareComponent[] components) {
        this.components = new HardwareComponent[components.length];
        this.components = Arrays.copyOf(components, this.components.length);
    }

    /**
     * Simulates the engraving of a serial number on this machine:
     * note that the serial number *must* correspond to the sum of the srial numbers
     * of the components (basically: a way to check the machine was built properly)
     */
    @Override
    public void engrave(int serialNo) {
        int checkSerial = 0;
        for (HardwareComponent component : components) {
            if (!component.isSerialValid()) {
                throw new IllegalStateException("Attempt to use non engraved component for computer!");
            }
            checkSerial += component.getSerialNo();
        }

        if (serialNo != checkSerial) {
            this.serialNo = INVALID_SERIAL;
            throw new IllegalStateException("Attempt to set illegal serial number for computer!");
        } else {
            this.serialNo = serialNo;
        }
    }

    /**
     * @return true if a serial number was created for this machine
     */
    public boolean isSerialValid() {
        return (serialNo != INVALID_SERIAL);
    }

    @Override
    public double getCost() {
        double cost = 0;
        for (HardwareComponent p : components) {
            cost += p.getCost();
        }

        return cost;
    }

    @Override
    public long getProductionTime() {
        return Math.round(getCost());
    }

    @Override
    public String toString() {
        String descr = "[";

        for (HardwareComponent p : components) {
            descr += p.toString() + ";";
        }

        descr += "]";
        return descr;
    }
}
