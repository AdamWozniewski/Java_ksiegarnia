package ksiegarnia;

/**
 * Created by Adam on 17.12.2016.
 */
public class Uzytkownik {
    private static int id=1;
    private String name,surname,psswd;
    private double wallet;

    public Uzytkownik(String _name,String _psswd){
        this.name=_name;
//        this.surname=_surname;
        this.wallet=0;
        this.psswd=_psswd;
        this.id+=1;
    }

    public void upgradeWallet(String kwota){
        double kwota_d=Double.parseDouble(kwota);
        this.wallet=kwota_d;
    }

    public double getHajs(){
        return this.wallet;
    }
    public String getName(){
        return this.name;
    }
}
