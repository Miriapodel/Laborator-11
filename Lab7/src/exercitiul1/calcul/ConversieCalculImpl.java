package exercitiul1.calcul;

import exercitiul1.model.Currency;

//clasa adaptor. Are metoda calculRata implementata minimal
public class ConversieCalculImpl implements ConversieCalcul{
    @Override
    public float conversieValutaToEur(Currency currency, float amount) throws Exception {
        float value;

        switch (currency){
            case EUR -> value = amount;
            case GBP-> value = amount * 4;
            case RON -> value = amount *2;
            case TRY -> value =  amount * 6;
            case USD -> value = amount * 3;
            default -> throw new Exception("wrong currency");
        }
        return value;
    }

    @Override
    public float calculRata() {
        return 0;
    }
    
}
