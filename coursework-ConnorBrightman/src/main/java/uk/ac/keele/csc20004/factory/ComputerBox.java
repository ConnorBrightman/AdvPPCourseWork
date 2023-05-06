/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory;

import java.util.Arrays;

import uk.ac.keele.csc20004.factory.computers.Computer;

public class ComputerBox {
    private Computer[] computers;
    private final boolean domestic;

    public ComputerBox(Computer[] computers, boolean domestic) {
        this.computers = new Computer[computers.length];
        this.computers = Arrays.copyOf(computers, this.computers.length);

        this.domestic = domestic;
    }

    public int size() {
        return computers.length;
    }

    public double getCost() {
        double cost = 0.0;
        for (Computer computer : computers) {
            cost += computer.getCost();
        }
        
        return cost;
    }
    
    @Override
    public String toString() {
        char prefix = domestic ? 'D': 'I'; 
        String descr = prefix+"Box[£" + getCost() + "]: ";
        for (Computer computer : computers) {
            descr += computer;
            descr += " ";
        }
        return descr;
    }
}
