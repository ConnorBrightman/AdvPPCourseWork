/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.factory.components;

/**
 * A generic class to represent the stations where the 
 * hardware components can be processed (i.e. receive their serial number).
 * The generic type T can be any of RAM, MotherBoard or GPU.
 */
public class AssemblyStation<T extends HardwareComponent> {
    private static int serialCounter = 0;

    protected T component = null;

    /**
     * Load a new component on the assembly stations.
     * The station is supposed to be empty before a component can be loaded.
     * 
     * @param component the component to load onto the station.
     */
    public void load(T component) {
        if(this.component != null) {
            throw new IllegalStateException("Attempt to load component on a busy station!");
        }
        this.component = component;
    }

    /**
     * This method represents the processing at a working station:
     * the compoment that was previously loaded onto the station will
     * receive a serial number.
     * 
     * @return the compoment, complete with the serial number
     * @throws InterruptedException
     */
    public T engraveComponent() throws InterruptedException {
        if(this.component == null) {
            throw new IllegalStateException("Attempt to engrave a component on an empty station!");
        }

        T engravedComponent = component;
        engravedComponent.setSerialNo(serialCounter++);

        Thread.sleep(engravedComponent.getAssemblyTime());

        return engravedComponent;
    }

    public void unload() {
        component = null;
    }
}