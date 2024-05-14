import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyCache cache = new MyCache();

        StoredObject obj1 = new StoredObject("obj1");
        StoredObject obj2 = new StoredObject("obj2");
        StoredObject obj3 = new StoredObject("obj3");
        StoredObject obj4 = new StoredObject("obj4");

        cache.put(1, obj1);
        cache.put(2, obj2);
        cache.put(3, obj3);
        cache.put(4, obj4);

        cache.start();

        for (int i = 0; i < 100; i++) {
            sleep(100);

            StoredObject obj = new StoredObject("obj" + i);
            cache.put(i, obj);
        }

    }
}
