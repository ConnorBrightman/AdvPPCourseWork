/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.sample;

import uk.ac.keele.csc20004.factory.ComputerBox;
import uk.ac.keele.csc20004.factory.ComputerCompany;

/**
 * An example of a thread simulating the sales manager 
 */
public class SampleSalesManager extends Thread {
    protected final ComputerCompany company;

    public SampleSalesManager(ComputerCompany company) {
        this.company = company;
    }

    /**
     * Note that this implementation performs busy waiting to check
     * the queues, so it *does not* meet the requirements 
     * for the coursework 
     */
    @Override
    public void run() {
        try {
            while(true) {
                Thread.sleep(500);
                ComputerBox box = company.sell();
                if (box != null) {
                    System.out.println("Sold: " + box);
                }
            }    
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
