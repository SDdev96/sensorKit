package sensorKit;

import provided.SensorFilter;
import provided.SensorOutputType;

public class I2CSensorFilter implements SensorFilter {

    @Override
    public boolean checkSensor(Sensor s) {
        return s.getSot().equals(SensorOutputType.I2C);
    }

}
