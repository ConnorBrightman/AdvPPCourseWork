/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.task2;

import uk.ac.keele.csc20004.factory.AbstractComputerCompany;
import uk.ac.keele.csc20004.factory.ComputerBox;

/**
 * TASK 2 REPORT
 * Use this javadoc to submit your report.
 * Please address the following points:
 * 
 * 1) What are the potential issues due to concurrent access to the stations and queue? 
 *    How did you handle them?
 * 
 * 2) How did you make sure that your solution is not causing deadlock/livelock?
 * 
 * 
 * 3) Discuss whether starvation may occur, and where; and what is your approach 
 *    to deal with it
 * 
 * @author USE YOU STUDENT ID HERE
 */
public class Task2ComputerCompany extends AbstractComputerCompany {
    // TODO add your variables here if necessary

    public Task2ComputerCompany(int boxSize) {
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
        // a concurrent setting using the classes you implemented

    }
}