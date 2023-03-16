import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int[] RastgeleGelir = new int[12];
        for (int i = 0; i < RastgeleGelir.length; i++) {
            RastgeleGelir[i] = random.nextInt(100, 1001);
        }
        //1-Gelir Listesi :
        System.out.println(Arrays.toString(RastgeleGelir));
        System.out.println("***********************************************************");
        //2-Gelir Listesi Gösterme:
        GelirListesiniGösterme(RastgeleGelir);
        System.out.println("***********************************************************");
        //3-Ençok Gelir Getiren Ay:
        EncokGelirGetirenAy(RastgeleGelir);
        System.out.println("***********************************************************");
        //4-Gider:
            //a-Gider Listesi:
        int[] RastgeleGider = new int[12];
        for (int j = 0; j < RastgeleGider.length; j++) {
            RastgeleGider[j] = random.nextInt(100, 1001);
        }
        System.out.println(Arrays.toString(RastgeleGider));
        System.out.println("***********************************************************");
            //b-Maksimum Gider Gider listesi gösterme
        GiderListesiniGösterme(RastgeleGider);
        System.out.println("***********************************************************");
            //c-Maksimum Gider Ayı
        EncokGiderAyi(RastgeleGider);
        System.out.println("***********************************************************");
        //5-Kar:
        int[] KarListesi=new int[12];
        for (int i=0;i<KarListesi.length;i++){
            if (RastgeleGelir[i]>RastgeleGider[i]){
                KarListesi[i]=RastgeleGelir[i]-RastgeleGider[i];
            }else {
                KarListesi[i]=0;
            }
        }
        System.out.println(Arrays.toString(KarListesi));
        //Kar Liste:
        yillikKarlistesi(KarListesi);
        System.out.println("***********************************************************");
        //6-Ciro:
            //a-Net Kar:
        yillikToplamNetKar(KarListesi);
            //b-Yıllık Toplam Vergi:
        yillikToplamVergi(KarListesi);

        int toplamVergi=yillikToplamVergi(KarListesi);
        int toplamKar=yillikToplamNetKar(KarListesi);
            //c-yıllık ciro
        ciro(toplamVergi,toplamKar);
        System.out.println("***********************************************************");
        int Ciro=ciro(toplamVergi,toplamKar);
        //7- şirketin durumu hakkında :
        sirketYillikGenelDurum(Ciro);

    }

    public static void GelirListesiniGösterme(int[] RastgeleGelir) {
        for (int i = 0; i < RastgeleGelir.length; i++) {
            System.out.println((i + 1) + ". Ayın geliri  :" + RastgeleGelir[i]);
        }
    }
    public static int EncokGelirGetirenAy(int[] RastgeleGelir) {
        int MaksimumGelir = RastgeleGelir[0];
        int MaksimumAy = 0;
        for (int i = 0; i < RastgeleGelir.length; i++) {
            if (RastgeleGelir[i] > MaksimumGelir) {
                MaksimumGelir = RastgeleGelir[i];
                MaksimumAy = i + 1;
            }
        }
        System.out.println("En çok Gelir  " + MaksimumAy + ". Ayda gerçekleşmiştir");
        System.out.println("Maksimum Gelir Miktarı  :" + MaksimumGelir);
        return MaksimumGelir;
    }
    public static void GiderListesiniGösterme(int[] RastgeleGider) {
        for (int i = 0; i < RastgeleGider.length; i++) {
            System.out.println((i + 1) + ". Ayın gideri  :" + RastgeleGider[i]);
        }
    }
    public static int EncokGiderAyi(int[] RastgeleGider) {
        int MaksimumGider = RastgeleGider[0];
        int MaksimumAy = 0;
        for (int i = 0; i < RastgeleGider.length; i++) {
            if (RastgeleGider[i] > MaksimumGider) {
                MaksimumGider = RastgeleGider[i];
                MaksimumAy = i + 1;
            }
        }
        System.out.println("En çok Gider  " + MaksimumAy + ". Ayda gerçekleşmiştir");
        System.out.println("Maksimum Gider Miktarı  :" + MaksimumGider);
        return MaksimumGider;
    }
    public static void yillikKarlistesi(int[] KarListesi){
        for (int i=0;i<KarListesi.length;i++){
            System.out.println((i+1)+".  Ay Karı  :"+KarListesi[i]);
        }
    }
    public static int yillikToplamNetKar(int[] KarListesi){
        int ToplamKar=KarListesi[0];
        int NetKar=0;
        for (int i=0;i<KarListesi.length;i++){
            ToplamKar +=KarListesi[i];
        }
        NetKar=(ToplamKar*70)/100;
        System.out.println("Yıllık Toplam Net Kar  :"+NetKar);
        return NetKar;
    }
    public static int yillikToplamVergi(int[] KarListesi){
        int ToplamVergi=0;
        int ToplamKar=KarListesi[0];

        for (int i=0;i<KarListesi.length;i++){
            ToplamKar +=KarListesi[i];
        }
        ToplamVergi=(ToplamKar*30)/100;
        System.out.println("Yıllık Toplam Vergi Miktarı  :"+ToplamVergi);
        return ToplamVergi;

    }
    public static int ciro(int toplamVergi, int toplamKar){
        int yillikCiro=toplamKar-toplamVergi;
        System.out.println("Yıllık toplam ciro :"+yillikCiro);
        return yillikCiro;

    }
    public static String sirketYillikGenelDurum(int Ciro){
        String durum="";
        if (Ciro<250){
            durum="iflas";
        } else if (Ciro>=250 && Ciro<=500) {
            durum="rist altında ";

        } else if (Ciro >=500 && Ciro <=750) {
            durum ="ortalama";

        } else if (Ciro >=750 && Ciro <= 1000) {
            durum="iyi";

        }else {
            durum="Mükemmel";
        }
        System.out.println("Şirketin durumu şuanda "+durum);


        return durum;
    }

}

