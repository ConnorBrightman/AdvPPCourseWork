/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory;

import uk.ac.keele.csc20004.factory.components.AssemblyStation;
import uk.ac.keele.csc20004.factory.components.GPU;
import uk.ac.keele.csc20004.factory.components.MotherBoard;
import uk.ac.keele.csc20004.factory.components.RAM;
import uk.ac.keele.csc20004.factory.computers.Computer;
import uk.ac.keele.csc20004.factory.computers.Server;

/**
 * A class defining the functionality of a production line 
 * worker (an assembler), in this case specialised in producing 
 * Servers. Basically their only job is to assemble
 * a Server, assuming the necessay stations are available.
 */
public class ServerAssembler implements ComputerAssembler {
    protected final ComputerCompany company;

    /**
     * Creates a new worker, specialised to produce servers.
     * 
     * @param company a reference to the company where the worker is employed
     */
    public ServerAssembler(ComputerCompany company) {
        this.company = company;
    }

    /**
     * The method that creates a new Laptop from its components. 
     * It will acceess the stations to validate the components, in the 
     * order specific to a server, then engrave a serial number on 
     * the machine and unload the stations.
     * 
     * @return a new Computer, created from components
     * @throws InterruptedException due to our simulation via sleep()
     */
    @Override
    public Computer assemble() throws InterruptedException {
        // start assembling, following the instructions for a server
        AssemblyStation<RAM> ramStation = company.getRAMAssemblyStation();
        AssemblyStation<GPU> gpuStation = company.getGPUAssemblyStation();
        AssemblyStation<MotherBoard> mbStation = company.getMBAssemblyStation();

        // first, process ram on its station
        ramStation.load(new RAM());
        RAM processedRam = ramStation.engraveComponent();

        // then, process gpu on its station
        gpuStation.load(new GPU());
        GPU processedGPU = gpuStation.engraveComponent();

        // finally process motherboard on its station
        mbStation.load(new MotherBoard());
        MotherBoard processedMB = mbStation.engraveComponent();

        Computer server = new Server(processedRam, processedGPU, processedMB);

        int serialNo = processedRam.getSerialNo() +
                processedGPU.getSerialNo() +
                processedMB.getSerialNo();

        server.engrave(serialNo);

        ramStation.unload();
        gpuStation.unload();
        mbStation.unload();

        return server;
    }

}
