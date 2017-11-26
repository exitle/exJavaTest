package d6_20171126.enums;

/**
 * Created: 26.11.17.
 */
public enum Gender {
    MALE("Male"), FEMALE("Female"), UNKNOWN("Unknown");

    String description;

    private Gender(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
