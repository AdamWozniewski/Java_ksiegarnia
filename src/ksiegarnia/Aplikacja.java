package ksiegarnia;

//import com.sun.java.util.jar.pack.Instruction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Adam on 17.12.2016.
 */


public class Aplikacja {
    public static void pozyczKsiazke(String id_book,ArrayList<Ksiazka> ksiegarnia){
        int id_w=Integer.parseInt(id_book);
        for (Ksiazka k:ksiegarnia) {
            if(id_w==k.id){
                k.changeAccess(false);
                System.out.println("Wypożyczono :  " +k.getTitle());
                break;
            }
        }
    }

    public static void offset(){
        for (int i=0;i<=50;i++){
            System.out.println(".");
        }
    }
    public static void AddNewBook(ArrayList<ksiegarnia.Ksiazka> tablica){

        Scanner input=new Scanner(System.in);
        String name,title,isbn,author;
        boolean access;

        access=true;

        for(;;){
            System.out.println("Podaj ISBN książki");
            isbn=input.nextLine();

            System.out.println("Podaj tytul książki");
            title=input.nextLine();

            System.out.println("Podaj Autora książki");
            author=input.nextLine();

            if(!isbn.equals("stop") || !title.equals("stop") || !author.equals("stop") || !isbn.equals("stop") ){
                tablica.add(new Ksiazka(isbn,title,author,access));
                System.out.println("--------------------------------- dodano! aby przerwać wpisz 'stop'");
            }
            else{
                break;
            }
        }


    }

    public static void ShowAllBook(ArrayList<Ksiazka> tablica,String moder){
        int j=1;

        if(moder.equals("admin")){
            for (Ksiazka i: tablica ) {
                System.out.println(j+"  "+i.title);
                j++;
            }
        }
        else{
            for (Ksiazka i: tablica ) {
                if(i.access==true){
                    System.out.println(j+"  "+i.title+"   "+i.getId());
                }
                j++;
            }
        }
//        Aplikacja.offset();
    }

    public static int  yourChoise(String wybor){
        while(!wybor.equals("stop")){
            switch(wybor){
                case "1": System.out.println("");break;
                default: System.out.println("Nieznane polecenie");
            }
        }
        return 0;
    }

//    public static void userWalletPlus(Uzytkownik u1 , double hajs){
//        u1.upgradeWallet(hajs);
//    }


    public static void main(String[] args) throws IOException {

        Scanner input=new Scanner(System.in);
        ArrayList<Ksiazka> tablicaKsiazek = new ArrayList<Ksiazka>();
        ArrayList<Uzytkownik> tablicaUzytkownikow = new ArrayList<Uzytkownik>();


        tablicaKsiazek.add(new Ksiazka("123654asf","ksiazka1","ziom1",true));
        tablicaKsiazek.add(new Ksiazka("123654asfasfasf","ksiazka2","ziom2",true));

        tablicaUzytkownikow.add(new Uzytkownik("ziomek1","ziomek1"));
        tablicaUzytkownikow.add(new Uzytkownik("ziomek2","ziomek2"));


        String texter,psswd,lgn;

        System.out.println("--------------- Zaloguj się ---------------");
        System.out.println("login : ");
        lgn=input.nextLine();
        System.out.println("hasło : ");
        psswd=input.nextLine();


        if(psswd.equals("admin") && lgn.equals("admin")){

            System.out.println("zalogowano jako ADMIN ");
            System.out.println("Co chcesz zrobić ?");

            System.out.println("1. Dodaj nową Książkę | 2. Wylistuj Wsiążki | 3. Sprawdź ilość użytkowników | 4. " + "Zakończ");

            texter=input.nextLine();

            while(!texter.equals("4")){


                switch (texter){
                    case "1": AddNewBook(tablicaKsiazek);break;
                    case "2": ShowAllBook(tablicaKsiazek,psswd);break;
                }
//                offset();
                System.out.println("Co chcesz teraz zrobić ?");
                System.out.println("1. Dodaj nową Książkę | 2. Wylistuj Wsiążki | 3. Sprawdź ilość użytkowników | 4. " + "Zakończ");
                texter=input.nextLine();
            }


        }
        else{

            Uzytkownik momentUser=new Uzytkownik(lgn,psswd);
            offset();
            System.out.println("zalogowano jako użytkownik: "+lgn);
            System.out.println("Co chcesz zrobić ?");
            System.out.println("1. Pożycz książkę | 2. Wylistuj dostępne ksiązki | 3. zasil portfel | 4. piniondz w " +
                    "portfelu" +" 5. Zakończ");
            texter=input.nextLine();
            while(!texter.equals("5")) {

                switch (texter){
                    case "1":
                        System.out.println("Wpisz ID danej książki");
                        texter=input.nextLine();
                        pozyczKsiazke(texter,tablicaKsiazek);break;
                    case "2": ShowAllBook(tablicaKsiazek,psswd);break;
                    case  "3":
                        System.out.println("jaka Kwota  ?");
                        texter=input.nextLine();

                        momentUser.upgradeWallet(texter);break;
                    case "4": System.out.println("Na koncie masz : "+momentUser.getHajs()); break;
                }

                System.out.println("Co chcesz teraz zrobić ?");
                System.out.println("1. Pożycz książkę | 2. Wylistuj dostępne ksiązki | 3. zasil portfel | 4. piniondz w " +
                        "portfelu" +" 5. Zakończ");
                texter=input.nextLine();
            }


//            System.out.println("zalogowano jako użytkownik: "+lgn);
        }







    }
}
