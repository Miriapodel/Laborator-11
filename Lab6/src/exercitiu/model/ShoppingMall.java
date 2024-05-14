package exercitiu.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingMall {
    private List<Magazin> magazinList = new ArrayList<>();

    public List<Magazin> getMagazinList() {
        return magazinList;
    }

    public void addMagazin(Magazin magazin) {
        this.magazinList.add(magazin);
    }

    public List<Magazin> getByProprietar(Proprietar proprietar){
        List<Magazin> magazinList1 = new ArrayList<>();
        for(Magazin m : magazinList){

            if(m.getProprietar().equals(proprietar)){
                magazinList1.add(m);
            }
        }
        return magazinList1;
    }

    public int getChirieByProprietar(Proprietar proprietar){
        List<Magazin> magazinList1 = getByProprietar(proprietar);
        int chirie = 0;

        for(Magazin m : magazinList1){
            chirie = chirie + m.getChirie();
        }
        return chirie;
    }

}
