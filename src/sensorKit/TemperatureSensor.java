package sensorKit;

import java.time.LocalDate;

import provided.Range;
import provided.SensorOutputType;

public class TemperatureSensor extends Sensor {
    private final double tempError;
    private final double outputSensitivity;
    private final double tempResolution;
    private final int bits;

    public TemperatureSensor(String partNumber, String manufacturer, double price, Range<Double> vs,
            SensorOutputType sot, LocalDate manifacturingDate, double tempResolution, double tempError, int bits) {
        super(partNumber, manufacturer, price, vs, sot, manifacturingDate);

        if (super.getSot() == SensorOutputType.ANALOG)
            throw new BadArgumentsForSensorTypeException("sot errato " + super.getSot());

        this.tempResolution = tempResolution;
        this.tempError = tempError;
        this.bits = bits;
        this.outputSensitivity = 0D;
    }

    public TemperatureSensor(String partNumber, String manufacturer, double price, Range<Double> vs,
            SensorOutputType sot, LocalDate manifacturingDate, double tempError, double outputSensitivity) {
        super(partNumber, manufacturer, price, vs, sot, manifacturingDate);

        if (super.getSot() == SensorOutputType.DIGITAL)
            throw new BadArgumentsForSensorTypeException();

        this.tempError = tempError;
        this.outputSensitivity = outputSensitivity;
        this.tempResolution = 0D;
        this.bits = 0;
    }

    public double getTempError() {
        return tempError;
    }

    public double getOutputSensitivity() {
        return outputSensitivity;
    }

    public double getTempResolution() {
        return tempResolution;
    }

    public int getBits() {
        return bits;
    }

    @Override
    public boolean hasValidPartNumber() {
        return super.getPartNumber().matches("^AD\\d{4}$") || super.getPartNumber().matches("^ADT\\d{4}$");
    }

    @Override
    public String toString() {
        String string = "";
        string += ((super.getSot().equals(SensorOutputType.ANALOG))
                ? "***Analog Temperature Sensor***\nTemperature Error (Deg): " + tempError
                        + "\nOutputSensitivity (mV/°C): " + outputSensitivity
                : "***Digital Temperature Sensor***\nTemperature Resolution (°/LSB): " + tempResolution
                        + "\nTemperature Error (Deg): " + tempError + "\nBits: " + bits);
        return string + super.toString();
    }

}
