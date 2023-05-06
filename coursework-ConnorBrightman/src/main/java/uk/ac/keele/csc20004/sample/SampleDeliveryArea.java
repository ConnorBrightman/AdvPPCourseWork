/* **********************
 * CSC-20004 COURSEWORK *
 * 2022/23 First sit    *
 * **********************/
package uk.ac.keele.csc20004.sample;

import java.util.ArrayDeque;

import uk.ac.keele.csc20004.factory.ComputerBox;
import uk.ac.keele.csc20004.factory.DeliveryArea;

/**
 * A sample implementation of a delivery area.
 * Note that this implementation *does not* fully meet the
 * requirements for the coursework.
 * In particular: there is no check on size constraints.
 */
public class SampleDeliveryArea implements DeliveryArea {

    // the queue for domestic delivery of boxes
    // note that this data structure *does not* meet the coursework requirements
    // you'll have to make your own choice when addressing the tasks
    private ArrayDeque<ComputerBox> homeDelivery = new ArrayDeque<>();

    // the queue for international delivery of boxes
    // note that this data structure *does not* meet the coursework requirements
    // you'll have to make your own choice when addressing the tasks
    private ArrayDeque<ComputerBox> intlDelivery = new ArrayDeque<>();

    public SampleDeliveryArea() {
    }

    public void pushDomestic(ComputerBox box) {
        homeDelivery.push(box);
    }

    public void pushInternational(ComputerBox box) {
        intlDelivery.push(box);
    }

    public ComputerBox poll() {
        if (intlDelivery.isEmpty()) {
            return homeDelivery.poll();
        } else {
            return intlDelivery.poll();
        }
    }
}