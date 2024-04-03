/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bagli_sirali;

/**
 *
 * @author EXCALIBUR
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class VeriElemani {
    int veri;
    int adres;

    public VeriElemani(int veri, int adres) {
        this.veri = veri;
        this.adres = adres;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-5d", veri, adres);
    }
}

public class Bagli_Sirali {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dosya adini girin: ");
        String dosyaAdi = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            String line;
            VeriElemani[] veriDizisi = new VeriElemani[100]; 
            int index = 0;

            while ((line = br.readLine()) != null) {
                int veri = Integer.parseInt(line);
                veriDizisi[index++] = new VeriElemani(veri, index); 
            }

            System.out.println("Dizinin Baslangic Durumu:");
            for (int i = 0; i < index; i++) {
                System.out.println(String.format("%-5d %-5s", veriDizisi[i].veri, veriDizisi[i].adres)); // Başlangıç durumunu ekrana yazdır
            }

           
            for (int i = 0; i < index - 1; i++) {
                for (int j = i + 1; j < index; j++) {
                    if (veriDizisi[i].veri > veriDizisi[j].veri) {
                        VeriElemani temp = veriDizisi[i];
                        veriDizisi[i] = veriDizisi[j];
                        veriDizisi[j] = temp;
                    }
                }
            }

            System.out.println("\nDizinin Siralanmis Durumu:");
            for (int i = 0; i < index; i++) {
                System.out.println(String.format("%-5d %-5s", veriDizisi[i].veri, veriDizisi[i].adres)); // Sıralanmış durumu ekrana yazdır
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
