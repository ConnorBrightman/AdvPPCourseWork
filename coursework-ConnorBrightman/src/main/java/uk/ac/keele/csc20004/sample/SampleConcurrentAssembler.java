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
 * A sample class to show how to implement a worker in a concurrent setting.
 * Note that this implementation *does not* fully meet the
 * requirements for the coursework
 */
public class SampleConcurrentAssembler extends Thread implements ComputerAssembler {
    private final ComputerCompany company;
    private final boolean domestic;

    /**
     * Creates a new sample worker 
     * 
     * @param company a reference to the company where the assembler is employed
     * @param domestic true if the worker belongs to the domestic production line
     */
    public SampleConcurrentAssembler(ComputerCompany company, boolean domestic) {
        this.company = company;
        this.domestic = domestic;
    }

    /**
     * Note that this implementation *does not* necessarily fully meet the
     * requirements for the coursework
     */
    public SampleComputer assemble() throws InterruptedException {
        AssemblyStation<GPU> gpuStation = company.getGPUAssemblyStation();

        synchronized (gpuStation) {
            // process gpu on its station
            gpuStation.load(new GPU());
            GPU processedGPU = gpuStation.engraveComponent();

            SampleComputer sc = new SampleComputer(processedGPU);

            int serialNo = processedGPU.getSerialNo();

            sc.engrave(serialNo);

            gpuStation.unload();

            return sc;
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Computer sc = assemble();
                Thread.sleep(100);

                if (domestic) {
                    company.enqueueForDomesticPackaging(sc);
                    System.out.println("Produced for domestic delivery: " + sc);
                } else {
                    company.enqueueForInternationalPackaging(sc);
                    System.out.println("Produced for international delivery: " + sc);
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
