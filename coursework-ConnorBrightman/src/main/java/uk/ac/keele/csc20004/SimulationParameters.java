/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004;

import java.util.Random;

/**
 * This is just a helper class to keep all the simulation parameters
 * in one place.
 */
public class SimulationParameters {
    private static final Random r = new Random();

    // the cost of the RAM component (influences assembly time)
    public static final double RAM_COST = 100.0;

    // the cost of the Motherboard component (influences assembly time)
    public static final double MB_COST = 500.0;

    // the cost of the GPU component (influences assembly time)
    public static final double GPU_COST = 200.0;

    // how many items (of any product) need to go in a box
    public static final int BOX_SIZE = 3;

    // the number of workers (for domestic and international)
    public static final int NUM_WORKERS = 3;

    // the maximum size of the delivery queues
    public static final int MAX_QUEUE_SIZE = 20;

    // probability to generate a premium computer
    public static final float PROB_PREMIUM_COMPUTER = 0.3f;


    /**
     * Helper method to generate a boolean with a given probabilty.
     * 
     * @param p the probability of getting true (a float: needs to be between 0.0 and 1.0)
     * @return a boolean generated with probability p
     */
    public static boolean getRandomBoolean(float p) {
        return r.nextFloat() < p;
    }

}
