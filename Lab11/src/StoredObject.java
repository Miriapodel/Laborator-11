import java.sql.Timestamp;

public class StoredObject {
    private Object myInfo;
    private boolean expired;
    private Timestamp expirationTime;

    public StoredObject(Object myInfo) {
        this.myInfo = myInfo;

        expirationTime = new Timestamp(System.currentTimeMillis() + 1000);
    }

    public Timestamp getExpirationTime() {
        return expirationTime;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean isExpired() {
        return expired;
    }
}
