package serializare.model;

import java.io.Serializable;

public class Persoana implements Serializable {

    private String nume;
    private String prenume;
    private int varsta;
    private static int index;

    public Persoana(String nume, String prenume, int varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        index++;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "numne='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                '}';
    }
}
