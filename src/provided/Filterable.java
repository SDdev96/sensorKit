package provided;

import java.util.Comparator;

import sensorKit.Sensor;
import sensorKit.SensorKit;

public interface Filterable {

    SensorKit filter(SensorFilter sf, Comparator<Sensor> c);

}
