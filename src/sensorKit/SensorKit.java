package sensorKit;

import java.util.List;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import provided.Filterable;
import provided.SensorFilter;

@SuppressWarnings("unused")

public class SensorKit implements Filterable, Iterable<Sensor> {
    private final String name;
    private List<Sensor> kit;

    public SensorKit(String name) {
        this.name = name;
        kit = new LinkedList<>();
    }

    public void add(Sensor s) throws BadSensorPartNumberException {
        if (!s.hasValidPartNumber())
            throw new BadSensorPartNumberException("PartNumber errata " + s.getPartNumber());

        kit.add(s);
    }

    public void remove(Sensor s) {
        kit.remove(s);
    }

    public void sort(Comparator<Sensor> c) {
        if (c == null)
            java.util.Collections.sort(kit);

        kit.sort(c);
    }

    @Override
    public Iterator<Sensor> iterator() {
        return kit.iterator();
    }

    @Override
    public SensorKit filter(SensorFilter sf, Comparator<Sensor> c) {
        SensorKit newKit = new SensorKit("filtered Kit");
        for (Sensor s : kit) {
            if (sf.checkSensor(s))
                try {
                    newKit.add(s);
                } catch (BadSensorPartNumberException e) {
                    e.printStackTrace();
                }
        }
        newKit.sort(c);
        return newKit;
    }

    public String toString() {
        StringBuilder string = new StringBuilder("This " + name + " contains " + kit.size() + " sensors\n");
        for (Sensor sensor : kit)
            string.append(sensor);
        // Iterator<Sensor> iter = this.iterator();
        // while (iter.hasNext()) {
        // string.append(iter.next() + "\n");
        // }

        return string.toString();
    }
}
