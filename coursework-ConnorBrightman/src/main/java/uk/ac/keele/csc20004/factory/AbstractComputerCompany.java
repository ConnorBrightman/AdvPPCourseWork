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

/**
 * 
 */
public abstract class AbstractComputerCompany implements ComputerCompany {
    protected AssemblyStation<RAM> ramStation;
    protected AssemblyStation<GPU> gpuStation;
    protected AssemblyStation<MotherBoard> mbStation;

    protected final int boxSize;

    protected PackagingArea domesticPackagingArea;
    protected PackagingArea internationalPackagingArea;

    public AbstractComputerCompany(int boxSize) {
        this.boxSize = boxSize;

        ramStation = new AssemblyStation<>();
        gpuStation = new AssemblyStation<>();
        mbStation = new AssemblyStation<>();

        domesticPackagingArea = new PackagingArea(boxSize, true);
        internationalPackagingArea = new PackagingArea(boxSize, false);
    }
    
    public AssemblyStation<RAM> getRAMAssemblyStation() {
        return ramStation;
    }

    public AssemblyStation<GPU> getGPUAssemblyStation() {
        return gpuStation;
    }

    public AssemblyStation<MotherBoard> getMBAssemblyStation() {
        return mbStation;
    }
    


    @Override
    public void enqueueForDomesticPackaging(Computer c) {
        domesticPackagingArea.add(c);
    }
    
    @Override
    public ComputerBox getDomesticPackage() {
        return domesticPackagingArea.getPackage();
    }

    @Override
    public void enqueueForInternationalPackaging(Computer c) {
        internationalPackagingArea.add(c);
    }

    @Override
    public ComputerBox getInternationalPackage() {
        return internationalPackagingArea.getPackage();
    }

}
