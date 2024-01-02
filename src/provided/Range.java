package provided;

@SuppressWarnings({ "unchecked", "rawtypes" })

public class Range<T extends Number & Comparable> {

    private final T low;
    private final T high;

    public Range(T low, T high) {
        if (low.compareTo(high) >= 0)
            throw new IllegalArgumentException("Bad range initialization.");

        this.low = low;
        this.high = high;
    }

    public T getLow() {
        return low;
    }

    public T getHigh() {
        return high;
    }

    public boolean contains(T number) {
        return (number.compareTo(low) >= 0 && number.compareTo(high) <= 0);
    }

    @Override
    public String toString() {
        return low + " ~ " + high;
    }

}
