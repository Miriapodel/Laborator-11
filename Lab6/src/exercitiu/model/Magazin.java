package exercitiu.model;

import exercitiu.calcul.FunctieGenerica;
import exercitiu.model.Proprietar;

public class Magazin {
    private int id;
    private String numeMagazin;
    private Proprietar proprietar;
    private int venit;
    private int suprafata;
    private int chirie;

    public Magazin(int id, String numeMagazin, Proprietar proprietar, int venit, int suprafata) {
        this.id = id;
        this.numeMagazin = numeMagazin;
        this.proprietar = proprietar;
        this.venit = venit;
        this.suprafata = suprafata;
    }

    public void setChirie(FunctieGenerica functieGenerica) {
        this.chirie = functieGenerica.calculChirie(suprafata);
    }

    public int getChirie(){
        return chirie;
    }
    public int getId() {
        return id;
    }

    public String getNumeMagazin() {
        return numeMagazin;
    }

    public Proprietar getProprietar() {
        return proprietar;
    }

    public int getVenit() {
        return venit;
    }

    public int getSuprafata() {
        return suprafata;
    }

    @Override
    public String toString() {
        return "\n\n\t\tMagazin{" +
                "id=" + id +
                ", numeMagazin='" + numeMagazin + '\'' +
                ", proprietar=" + proprietar +
                ", venit=" + venit +
                ", suprafata=" + suprafata +
                ", chirie=" + chirie +
                '}';
    }
}
