package serializare.model;

import java.io.Serializable;

public class Nod implements Serializable {
    private Object data;
    private Nod next;

    public Nod(Object data) {
        this.data = data;
        this.next = null;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Nod getNext() {
        return next;
    }

    public void setNext(Nod next) {
        this.next = next;
    }

}
