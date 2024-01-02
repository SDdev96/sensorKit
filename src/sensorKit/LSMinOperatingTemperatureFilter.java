package sensorKit;

import provided.SensorFilter;

public class LSMinOperatingTemperatureFilter implements SensorFilter {
    private final double minTemperature;

    public LSMinOperatingTemperatureFilter(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public boolean checkSensor(Sensor s) {
        return ((s instanceof LightSensor)
                ? ((Double) minTemperature).equals(((LightSensor) s).getOperatingTemperature().getLow())
                : false);
    }

}
