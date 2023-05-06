/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory;

import java.util.ArrayDeque;
import uk.ac.keele.csc20004.factory.computers.Computer;

/**
 * A temporary storage area for computers, before being packaged into 
 * boxes. Due to how the company is organised, this area will also need
 * to take separate care of computers destined to the domestic and to the
 * international market. This class can be used to either of them.
 * 
 * In this implementation, computers are added to an internal queue until 
 * a sufficient number is present that fills a box: when this happens, a new
 * box is created and added to a second internal queue, waiting for someone to
 * retrieve it. 
 * 
 * Note that this implementation is thread-safe.
 */
public class PackagingArea {
    private final int boxSize;
    private final boolean domestic;

    private ArrayDeque<ComputerBox> boxes = new ArrayDeque<>();
    private Computer[] computers;

    private int counter;

    /**
     * Creates the internal structures to handle a packaging area. 
     * 
     * @param boxSize the number of computers necesary to fill a box
     * @param domestic true if this area is for the domestic market (this parameter 
     * serves only to "brand" the boxes appropriately)
     */
    public PackagingArea(int boxSize, boolean domestic) {
        this.boxSize = boxSize;
        computers = new Computer[boxSize];
        counter = 0;

        this.domestic = domestic;
    }

    /**
     * Adds a new computer to the area. If this computer is the
     * last one necessary to fill a box, a new box will be created, 
     * and the temporary storage area is reset.
     * @param c the new computer
     */
    public synchronized void add(Computer c) {
        computers[counter] = c;
        counter++;

        // if enough computers to fill a box, produce one
        // and reset temp storage area
        if (counter == boxSize) {
            boxes.push(new ComputerBox(computers, domestic));
            computers = new Computer[boxSize];
            counter = 0;
        }
    }

    /**
     * Returns a box, if one had already been created. Note that this method
     * will return null, if no box is available. 
     * 
     * @return a box full with computers.
     */
    public synchronized ComputerBox getPackage() {
        return boxes.poll();
    }
}
