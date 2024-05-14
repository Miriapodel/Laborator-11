package exercitiul1.model;

public enum Currency {
    RON("Romania", "RO"),
    EUR("Uniunea Europeana","UE") ,
    TRY("Turcia","TR"),
    USD("United States of America" , "US"),
    GBP("United Kingdom", "UK");

    private final String zone;
    private final String shortName;

    Currency(String zone, String shortName) {
        this.zone = zone;
        this.shortName = shortName;
    }

    public String getZone() {
        return zone;
    }

    public String getShortName() {
        return shortName;
    }
}
