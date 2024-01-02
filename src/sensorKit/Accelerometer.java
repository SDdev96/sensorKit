package sensorKit;

import java.time.LocalDate;

import provided.Range;
import provided.SensorOutputType;

public class Accelerometer extends Sensor {
    private final double range;
    private final int sensingAxis;
    private final double bandwidth;

    public Accelerometer(String partNumber, String manufacturer, double price, Range<Double> vs, SensorOutputType sot,
            LocalDate manifacturingDate, double range, int sensingAxis, double bandwidth) {
        super(partNumber, manufacturer, price, vs, sot, manifacturingDate);
        this.range = range;
        this.sensingAxis = sensingAxis;
        this.bandwidth = bandwidth;
    }

    public double getRange() {
        return range;
    }

    public int getSensingAxis() {
        return sensingAxis;
    }

    public double getBandwidth() {
        return bandwidth;
    }

    @Override
    public boolean hasValidPartNumber() {
        return super.getPartNumber().matches("^(ADXL\\d{3}|ADIS\\d{5})$");
    }

    @Override
    public String toString() {
        return "***Accelerometer***" + "\nRange (g): " + range + "\nNumber of sensing Axis:" + sensingAxis
                + "\nBandwidth (kHZ): " + bandwidth + super.toString();
    }
}
