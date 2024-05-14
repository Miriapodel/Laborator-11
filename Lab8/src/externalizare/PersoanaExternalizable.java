package externalizare;

import java.io.*;

//pentru serializare si deserializare este necesar constructorul default
public class PersoanaExternalizable implements Externalizable {
    private static final long serialVersionUID = 1L;
    private String nume;
    private String prenume;
    private int varsta;
    private static int index;

    public PersoanaExternalizable(){}
    public PersoanaExternalizable(String nume, String prenume, int varsta) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        index++;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(nume);
        out.writeUTF(prenume);
        out.writeInt(varsta);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        nume = in.readUTF();
        prenume = in.readUTF();
        varsta = in.readInt();
    }
}
