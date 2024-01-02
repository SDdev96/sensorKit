package sensorKit;

public class ManifacturingDateComparator implements java.util.Comparator<Sensor> {

    @Override
    public int compare(Sensor o1, Sensor o2) {
        return (o1.getManifacturingDate().equals(o2.getManifacturingDate()) ? o1.compareTo(o2)
                : o1.getManifacturingDate().compareTo(o2.getManifacturingDate()));
    }
}
