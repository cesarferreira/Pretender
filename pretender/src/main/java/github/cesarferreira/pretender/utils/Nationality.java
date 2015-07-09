package github.cesarferreira.pretender.utils;


public enum Nationality {
    AU("AU"), ES("ES"), FI("FI"), FR("FR"), GB("GB"), IE("IE"), NL("NL"), US("US");

    private final String name;

    private Nationality(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    public String toString() {
        return name;
    }

    }
