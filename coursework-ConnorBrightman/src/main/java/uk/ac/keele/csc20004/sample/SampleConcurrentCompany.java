/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.sample;

import uk.ac.keele.csc20004.SimulationParameters;
import uk.ac.keele.csc20004.factory.AbstractComputerCompany;
import uk.ac.keele.csc20004.factory.ComputerBox;
import uk.ac.keele.csc20004.factory.ComputerCompany;
import uk.ac.keele.csc20004.factory.DeliveryArea;

/**
 * An example of a simualted company, in a concurrent setting.
 */
public class SampleConcurrentCompany extends AbstractComputerCompany {
    DeliveryArea deliveries = new SampleDeliveryArea();

    public SampleConcurrentCompany(int boxSize) {
        super(boxSize);
    }

    /**
     * Note that this implementation *does not* necessarily meet the requirements
     * for the coursework. You will need to implement appropriate synchronization
     * 
     * @param b the box to be addedd to domestic delivery
     */
    @Override
    public void enqueueForDomesticDelivery(ComputerBox b) throws InterruptedException {
        synchronized(deliveries) {
            deliveries.pushDomestic(b);
        }
    }

    @Override
    public void enqueueForInternationalDelivery(ComputerBox b) throws InterruptedException {
        synchronized(deliveries) {
            deliveries.pushInternational(b);  
        }
    }

    @Override
    public ComputerBox sell() throws InterruptedException {
        synchronized(deliveries) {
            return deliveries.poll();
        }
    }
    /**
     * The method to implement a demo of the oprtations of the company in a
     * concurrent setting.
     * Note that this implementation *does not* necessarily meet the requirements
     * for the coursework.
     * The purpose of this code is only to show how the classes in the provided 
     * starting code may fit together 
     * 
     * @param args to provide args from the command line (not used)
     */
    public static void main(String[] args) {
        int boxSize = 10;
        ComputerCompany company = new SampleConcurrentCompany(boxSize);

        int numWorkers = SimulationParameters.NUM_WORKERS;

        Thread domesticWorkers[] = new Thread[numWorkers];
        for (int i = 0; i < numWorkers; i++) {
            domesticWorkers[i] = new SampleConcurrentAssembler(company, true);
        }

        Thread internationalWorkers[] = new Thread[numWorkers];
        for (int i = 0; i < numWorkers; i++) {
            internationalWorkers[i] = new SampleConcurrentAssembler(company, false);
        }

        Thread salesManager = new SampleSalesManager(company);

        for (int i = 0; i < numWorkers; i++) {
            domesticWorkers[i].start();
            internationalWorkers[i].start();
        }

        salesManager.start();

        try {
            while(true) {
                Thread.sleep(500);
                ComputerBox dbox = company.getDomesticPackage();
                if (dbox != null) {
                    company.enqueueForDomesticDelivery(dbox);
                    System.out.println("New box for domestic delivery: " + dbox);
                }
                ComputerBox ibox = company.getInternationalPackage();
                if (ibox != null) {
                    company.enqueueForInternationalDelivery(ibox);
                    System.out.println("New box for international delivery: " + ibox);
                }
            }
    
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
