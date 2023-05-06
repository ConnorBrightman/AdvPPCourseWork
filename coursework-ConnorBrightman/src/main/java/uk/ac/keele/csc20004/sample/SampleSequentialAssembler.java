/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.sample;

import uk.ac.keele.csc20004.factory.ComputerAssembler;
import uk.ac.keele.csc20004.factory.ComputerCompany;
import uk.ac.keele.csc20004.factory.components.AssemblyStation;
import uk.ac.keele.csc20004.factory.components.GPU;
import uk.ac.keele.csc20004.factory.computers.Computer;

/**
 * A sample class to show how to implement a worker in a sequential setting.
 * Note that this implementation *does not* fully meet the
 * requirements for the coursework
 */
public class SampleSequentialAssembler implements ComputerAssembler {
    protected final ComputerCompany company;

    /**
     * Creates a new sample worker 
     * 
     * @param company a reference to the company where the assembler is employed
     */
    public SampleSequentialAssembler(ComputerCompany company) {
        this.company = company;
    }

    /**
     * Note that this implementation *does not* necessarily fully meet the
     * requirements for the coursework
     */
    public Computer assemble() throws InterruptedException {
        AssemblyStation<GPU> gpuStation = company.getGPUAssemblyStation();

        // process gpu on its station
        gpuStation.load(new GPU());
        GPU processedGPU = gpuStation.engraveComponent();

        Computer sc = new SampleComputer(processedGPU);

        int serialNo = processedGPU.getSerialNo();

        sc.engrave(serialNo);

        gpuStation.unload();

        return sc;
    }

}
