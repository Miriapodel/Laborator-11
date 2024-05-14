import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyCache extends Thread{
    private Map<Integer, StoredObject> cache = new ConcurrentHashMap<>();

    @Override
    public void run() {
        while(true) {

            try {
                sleep(2000);


                for (Map.Entry<Integer, StoredObject> entry : cache.entrySet()) {
                    if (entry.getValue().getExpirationTime().getTime() < System.currentTimeMillis()) {
                        entry.getValue().setExpired(true);

                        System.out.println("A expirat obiectul cu cheia " + entry.getKey());
                    }
                }

                if (!checkExpired()) {
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean checkExpired() {
        for (Map.Entry<Integer, StoredObject> entry : cache.entrySet()) {
            if (!entry.getValue().isExpired()) {
                return true;
            }
        }

        return false;
    }

    public void put(int key, StoredObject obj) {
        cache.put(key, obj);
    }
}
