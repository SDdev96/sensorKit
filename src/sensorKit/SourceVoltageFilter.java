package sensorKit;

import provided.SensorFilter;

@SuppressWarnings("unused")

public class SourceVoltageFilter implements SensorFilter {
    private final double vs;

    public SourceVoltageFilter(double vs) {
        this.vs = vs;
    }

    @Override
    public boolean checkSensor(Sensor s) {
        return s.getVoltage().contains(vs);
    }

}
