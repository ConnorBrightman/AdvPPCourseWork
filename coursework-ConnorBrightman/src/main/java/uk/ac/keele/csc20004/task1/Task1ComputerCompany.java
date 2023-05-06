/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.task1;


import uk.ac.keele.csc20004.factory.AbstractComputerCompany;
import uk.ac.keele.csc20004.factory.ComputerBox;
import uk.ac.keele.csc20004.factory.ComputerCompany;
import uk.ac.keele.csc20004.factory.DeliveryArea;
import uk.ac.keele.csc20004.sample.*;

public class Task1ComputerCompany extends AbstractComputerCompany {
    // TODO add your variables here if necessary
    DeliveryArea deliveries = new SampleDeliveryArea();

    public Task1ComputerCompany(int boxSize) {
        super(boxSize);
        // TODO add your code here if necessary
    }

    @Override
    public void enqueueForDomesticDelivery(ComputerBox b) {
        // TODO add your code here
    }

    @Override
    public void enqueueForInternationalDelivery(ComputerBox b) {
        // TODO add your code here
    }

    @Override
    public ComputerBox sell() {
        // TODO add your code here and return the appropriate value
        return null;
    }

    public static void main(String[] args) {
        // TODO add your code here to show how
        // you can simulate the operations of the company in
        // a sequential setting using the classes you implemented
        int boxSize = 8;
        ComputerCompany company = new SampleConcurrentCompany(boxSize);

        int numWorkers = 9;
        

    }

}
