/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bagli_sirali;

/**
 *
 * @author EXCALIBUR
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Sayi {
    int veri;
    int adres;

    public Sayi(int veri, int adres) {
        this.veri = veri;
        this.adres = adres;
    }

    @Override
    public String toString() {
        return veri + "\t\t\t" + adres;
    }
}

public class Bagli_Sirali {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dosya adını girin: ");
        String dosyaAdi = scanner.nextLine();
        scanner.close();

        try {
            File dosya = new File(dosyaAdi);
            Scanner dosyaOkuyucu = new Scanner(dosya);

            int sayiAdres = 0;
            Sayi[] dizi = new Sayi[100]; 
          
            System.out.println("x\t\t\ty");
            System.out.println("--------------------------------");

            
            while (dosyaOkuyucu.hasNextLine()) {
                String satir = dosyaOkuyucu.nextLine().trim();
                if (!satir.isEmpty()) {
                    int sayi = Integer.parseInt(satir);
                    dizi[sayiAdres] = new Sayi(sayi, sayiAdres);
                    sayiAdres++;
                }
            }

            
            for (int i = 0; i < dizi.length; i++) {
                if (dizi[i] != null) {
                    System.out.println(dizi[i].veri + "\t\t\t" + dizi[i].adres);
                }
            }

            
            for (int i = 0; i < sayiAdres - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < sayiAdres; j++) {
                    if (dizi[j] != null && dizi[minIndex] != null && dizi[j].veri < dizi[minIndex].veri) {
                        minIndex = j;
                    }
                }
                // Swap
                Sayi temp = dizi[minIndex];
                dizi[minIndex] = dizi[i];
                dizi[i] = temp;
            }

           
            System.out.println("--------------------------------");
            for (int i = 0; i < sayiAdres; i++) {
                if (dizi[i] != null) {
                    System.out.println(dizi[i].veri + "\t\t\t" + i);
                }
            }

            dosyaOkuyucu.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı: " + dosyaAdi);
        } catch (NumberFormatException e) {
            System.out.println("Dosyada beklenmeyen bir format hatası var.");
        }
    }
}
