package hu.petrik;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

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

        System.out.println("Harcos OOP \n Üdvözletem!" +
                "\n Kérem, adja meg a nevét!");
        String harcosNev = sc.nextLine();
        System.out.println("Azt is adja meg, hogy milyen harcosként szeretne játszani (1 és 3 között: 1-nek van a legtöbb életere, 3-nak a legnagyobb támadása)");
        int harcosSablon = sc.nextInt();

        Harcos felhasznaloHarcos = new Harcos(harcosNev, harcosSablon);
        System.out.println("Ei. Egg. Tolyás.");

    }
}
