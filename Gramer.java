/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gramer;
import java.util.Scanner;

public class Gramer {
    public static void main(String[] args) {
        String[] ozne = {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin", "Naki"};
        String[] nesne = {"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};
        String[] yuklem = {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Lutfen bir cumle giriniz:");
        String cumle = scanner.nextLine().trim(); 

        String[] kelimeler = cumle.split("\\s+"); 

        if (kelimeler.length < 3) {
            System.out.println("HAYIR.");
            return;
        }

        if (kontrolIslem(kelimeler[0], ozne) && kontrolIslem(kelimeler[1], nesne) && kontrolIslem(kelimeler[2], yuklem)) {
            System.out.println("EVET");
        } else {
            System.out.println("HAYIR");
        }
    }

   
    private static boolean kontrolIslem(String kelime, String[] dizi) {
        for (String kelimeDiziler : dizi) {
            if (kelime.equals(kelimeDiziler)) {
                return true;
            }
        }
        return false;
    }
}
