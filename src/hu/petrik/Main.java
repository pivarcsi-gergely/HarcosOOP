package hu.petrik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static List<Harcos> harcosLista;

    public static void beolvasas(String fajlNev){
        harcosLista = new ArrayList<>();
        try{
            FileReader fr = new FileReader(fajlNev);
            BufferedReader br = new BufferedReader(fr);
            String sor = br.readLine();
            while (sor != null){
                String[] adatok = sor.split(";");
                Harcos harcosPeldany = new Harcos(adatok[0], Integer.parseInt(adatok[1]));
                harcosLista.add(harcosPeldany);
                sor = br.readLine();
            }
            fr.close();
            br.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        beolvasas("harcosok.csv");
        System.out.println(harcosLista);
        Harcos harcos = new Harcos("Abc", 2);
        System.out.println("Ei. Egg. Tolyás.");

    }
}
