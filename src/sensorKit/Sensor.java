package sensorKit;

import java.time.LocalDate;

import provided.Range;
import provided.SensorOutputType;

@SuppressWarnings("unused")

public abstract class Sensor implements Comparable<Sensor> {
    private final String partNumber;
    private final String manufacturer;
    private final LocalDate manifacturingDate;
    private final double price;
    private final SensorOutputType sot;
    private final Range<Double> vs;

    public Sensor(String partNumber, String manufacturer, double price, Range<Double> vs,
            SensorOutputType sot, LocalDate manifacturingDate) {
        this.partNumber = partNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.vs = vs;
        this.sot = sot;
        this.manifacturingDate = manifacturingDate;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public SensorOutputType getSot() {
        return sot;
    }

    LocalDate getManifacturingDate() {
        return manifacturingDate;
    }

    // Aggiunto da me per accedere ai metodi di Range per la classe
    // SourceVoltageFilter
    public Range<Double> getVoltage() {
        return vs;
    }

    public abstract boolean hasValidPartNumber();

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (other == null)
            return false;

        if (getClass() != other.getClass())
            return false;

        return this.partNumber.equals(((Sensor) other).partNumber);
    }

    @Override
    public int hashCode() {
        final int hash = 31;
        return hash * ((partNumber == null) ? 0 : partNumber.hashCode());
    }

    @Override
    public final int compareTo(Sensor o) {
        return this.partNumber.compareTo(o.partNumber);
    }

    @Override
    public String toString() {
        return "Part Number: " + partNumber + "\nManufacturer: " + manufacturer + "\nPrice($): " + price
                + "\nSource voltage range (V): " + vs + "\nOutput type: " + sot + "\nManifacturing Date: "
                + manifacturingDate + "\n\n";
    }
}
