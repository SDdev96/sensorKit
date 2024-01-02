package sensorKit;

import java.time.LocalDate;

import provided.LightSensorType;
import provided.Range;
import provided.SensorOutputType;

public class LightSensor extends Sensor {
    private final double wavelength;
    private final boolean proximityDetection;
    private final Range<Double> operatingTemperature;
    private final LightSensorType lst;

    public LightSensor(String partNumber, String manufacturer, double price, Range<Double> vs, SensorOutputType sot,
            LocalDate manifacturingDate, double wavelength, boolean proximityDetection,
            Range<Double> operatingTemperature, LightSensorType lst) {
        super(partNumber, manufacturer, price, vs, sot, manifacturingDate);
        this.wavelength = wavelength;
        this.proximityDetection = proximityDetection;
        this.operatingTemperature = operatingTemperature;
        this.lst = lst;
    }

    public LightSensor(String partNumber, String manufacturer, double price, Range<Double> vs, SensorOutputType sot,
            LocalDate manifacturingDate, double wavelength,
            Range<Double> operatingTemperature) {
        this(partNumber, manufacturer, price, vs, sot, manifacturingDate, wavelength, false, operatingTemperature,
                null);
    }

    public double getWaveLength() {
        return wavelength;
    }

    public boolean hasProximityDetection() {
        return proximityDetection;
    }

    public Range<Double> getOperatingTemperature() {
        return operatingTemperature;
    }

    public LightSensorType getLst() {
        return lst;
    }

    @Override
    public final boolean hasValidPartNumber() {
        return super.getPartNumber().matches("^APDS\\d{7}$") || super.getPartNumber().matches("^VCNL\\d{4}$");
    }

    @Override
    public String toString() {
        return "***LightSensor***" + "\nWavelength (nm): " + wavelength + "\nProximityDetection: " + proximityDetection
                + "\nOperating Temperature (°C): " + operatingTemperature + "\nLight Sensor Type: " + lst
                + super.toString();
    }

}
