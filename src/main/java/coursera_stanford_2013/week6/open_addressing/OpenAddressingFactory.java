package coursera_stanford_2013.week6.open_addressing;

public class OpenAddressingFactory {
    public static OpenAddressing getInstance(OpenAddressingType type) {
        switch (type) {
            case LINEAR_PROBING:
                return new LinearProbing();
            case QUADRATIC_PROBING:
                return new QuadraticProbing();
            case DOUBLE_HASHING:
                return new DoubleHashing();
            default:
                throw new IllegalArgumentException("Unknown open addressing type!");
        }
    }
}
