package exercitiu;

import exercitiu.calcul.FunctieGenerica;
import exercitiu.calcul.MagazinAlimentarCalculImpl;
import exercitiu.calcul.MagazinChimicaleCalculImpl;
import exercitiu.calcul.MagazinHaineCalculImpl;
import exercitiu.model.Magazin;
import exercitiu.model.Proprietar;
import exercitiu.model.ShoppingMall;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        ShoppingMall shoppingMall = initShoppingMall();
        sortare1(shoppingMall);

        sortare2(shoppingMall);

        chirieByProprietar(shoppingMall);

    }

    private static void chirieByProprietar(ShoppingMall shoppingMall) {
        Set<Proprietar> proprietarList = getProprietars(shoppingMall);

        System.out.println("\n3) Chirie by Proprietar");
        for(Proprietar p : proprietarList){
            System.out.println("Proprietar " + p + " a platit chirie = " + shoppingMall.getChirieByProprietar(p));
        }
    }

    /*
    lista de magazine ale unui proprietar, afisare sortata dupa numeMagazin, venit, chirie, suprafata
     */
    private static void sortare2(ShoppingMall shoppingMall) {
        Set<Proprietar> proprietarList = getProprietars(shoppingMall);
        System.out.println("\n\n2) Magazine by proprietar: ");
        for(Proprietar p : proprietarList){
            List<Magazin> magazinByProprietar = shoppingMall.getByProprietar(p);
            Collections.sort(magazinByProprietar,
                    Comparator.comparing(Magazin::getNumeMagazin)
                    .thenComparing(Magazin::getVenit)
                    .thenComparing(Magazin::getChirie)
                    .thenComparing(Magazin::getSuprafata));
            System.out.println("Proprietar " + p + " magazine : " + shoppingMall.getByProprietar(p));
        }
    }

    private static Set<Proprietar> getProprietars(ShoppingMall shoppingMall) {
        List<Magazin> list = shoppingMall.getMagazinList();
        Set<Proprietar> proprietarList = new HashSet<>();
        for(Magazin m : list){
            proprietarList.add(m.getProprietar());
        }
        return proprietarList;
    }

    /*
    lista de magazine sortata dupa: nume proprietar, prenume proprietar, chiria platita
     */
    private static void sortare1(ShoppingMall shoppingMall) {

        Collections.sort(shoppingMall.getMagazinList(),
                Comparator.comparing(Magazin::getProprietar, Comparator.comparing(Proprietar::getNume))
                .thenComparing(Magazin::getProprietar, Comparator.comparing(Proprietar::getPrenume))
                .thenComparing(Magazin::getChirie)
        );

        System.out.println("1) Lista magazine: " + shoppingMall.getMagazinList());
    }

    private static ShoppingMall initShoppingMall() {
        Proprietar proprietar1 = new Proprietar("Dan", "Georgescu", 50);
        Proprietar proprietar2 = new Proprietar("Ana", "Andrei", 35);
        Proprietar proprietar3 = new Proprietar("Petre", "Pop", 27);
        Proprietar proprietar4 = new Proprietar("Anca", "Georgescu", 27);

        FunctieGenerica functieGenericaMagHaineChirie = new MagazinHaineCalculImpl();
        FunctieGenerica functieGenericaMagAlimentarChirie = new MagazinAlimentarCalculImpl();
        FunctieGenerica functieGenericaMagChimicaleChirie = new MagazinChimicaleCalculImpl();

        Magazin magazinAlimentar1 = new Magazin(1, "Alimentara", proprietar1, 1000, 200);
        magazinAlimentar1.setChirie(functieGenericaMagAlimentarChirie);
        Magazin magazinAlimentar2 = new Magazin(2, "MegaShop", proprietar3, 2000, 300);
        magazinAlimentar2.setChirie(functieGenericaMagAlimentarChirie);

        Magazin magazinHaine1 = new Magazin(3, "Prod SRL", proprietar3, 100, 150);
        magazinHaine1.setChirie(functieGenericaMagHaineChirie);
        Magazin magazinHaine2 = new Magazin(4, "Prod SRL", proprietar1, 100, 150);
        magazinHaine2.setChirie(functieGenericaMagHaineChirie);

        Magazin magazinChimicale1 = new Magazin(5, "Chim Prod SRL", proprietar3, 100, 250);
        magazinChimicale1.setChirie(functieGenericaMagChimicaleChirie);
        Magazin magazinChimicale2 = new Magazin(6, "impex SRL", proprietar2, 400, 50);
        magazinChimicale2.setChirie(functieGenericaMagChimicaleChirie);
        Magazin magazinChimicale3 = new Magazin(7, "mega impex SRL", proprietar4, 300, 500);
        magazinChimicale3.setChirie(functieGenericaMagChimicaleChirie);
        ShoppingMall shoppingMall = new ShoppingMall();
        shoppingMall.addMagazin(magazinAlimentar1);
        shoppingMall.addMagazin(magazinAlimentar2);
        shoppingMall.addMagazin(magazinHaine1);
        shoppingMall.addMagazin(magazinHaine2);
        shoppingMall.addMagazin(magazinChimicale1);
        shoppingMall.addMagazin(magazinChimicale2);
        shoppingMall.addMagazin(magazinChimicale3);
        return shoppingMall;
    }
}
