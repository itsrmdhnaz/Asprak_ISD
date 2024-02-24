import java.util.ArrayList;
import java.util.Scanner;

public class Answer {

  /**
   * 
Soal : 

Hotel Horizon yang memiliki beberapa kamar yang dapat disewakan. Toko tersebut membutuhkan 
sistem pengelolaan kamar untuk mencatat informasi setiap kamar yang dapat disewa oleh pelanggan.
Hotel memiliki beberapa kamar dengan ID dan tipe tertentu, serta kapasitas berbeda. 
Kamar-kamar ini dapat disewa dengan tarif sewa per malam tertentu

Sistem pengelolaan ini memungkinkan pihak hotel untuk:
Menambah Kamar
Menampilkan Daftar Kamar
Menghapus Kamartersebut dari daftar.
Mengedit Tarif Sewa Kamartarif sewa baru.

Pelanggan yang ingin menginap dapat memilih kamar berdasarkan preferensi mereka, 
dan pihak hotel dapat dengan mudah mengelola dan memperbarui informasi kamar-kamar tersebut. 
Sistem ini membantu pihak hotel dalam memberikan layanan yang lebih baik kepada pelanggan mereka.

Buatlah program Java yang mengimplementasikan sistem pengelolaan kamar hotel dengan menerapkan
ArrayList dan Generic
   */

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PengelolaSewa<Kamar> pengelolaSewa = new PengelolaSewa<>();

    while (true) {
      System.out.println("\nMenu:");
      System.out.println("1. Tambah Kamar");
      System.out.println("2. Tampilkan Kamar");
      System.out.println("3. Hapus Kamar");
      System.out.println("4. Edit Tarif Sewa Kamar");
      System.out.println("5. Keluar");
      System.out.print("Masukkan pilihan Anda: ");
      int pilihan = scanner.nextInt();
      scanner.nextLine();

      switch (pilihan) {
        case 1:
          System.out.print("ID Kamar: ");
          String idKamar = scanner.nextLine();
          System.out.print("Tipe Kamar: ");
          String tipeKamar = scanner.nextLine();
          System.out.print("Kapasitas: ");
          int kapasitas = scanner.nextInt();
          System.out.print("Tarif Sewa: Rp. ");
          double tarifSewa = scanner.nextDouble();
          Kamar kamar = new Kamar(idKamar, tipeKamar, kapasitas, tarifSewa);
          pengelolaSewa.tambahKamar(kamar);
          System.out.println("Kamar berhasil ditambahkan.");
          break;
        case 2:
          pengelolaSewa.tampilkanKamar();
          break;
        case 3:
          System.out.print("Masukkan ID kamar yang akan dihapus: ");
          String idKamarHapus = scanner.nextLine();
          pengelolaSewa.hapusKamar(idKamarHapus);
          break;
        case 4:
          System.out.print("Masukkan ID kamar yang akan diubah: ");
          String idKamarUbah = scanner.nextLine();

          pengelolaSewa.editKamar(idKamarUbah, scanner);
          break;
        case 5:
          System.out.println("Keluar...");
          System.exit(0);
        default:
          System.out.println(
            "Pilihan tidak valid. Masukkan angka dari 1 hingga 5."
          );
      }
    }
  }
}

class Kamar {

  private String idKamar;
  private String tipeKamar;
  private int kapasitas;
  private double tarifSewa;

  public Kamar(
    String idKamar,
    String tipeKamar,
    int kapasitas,
    double tarifSewa
  ) {
    this.idKamar = idKamar;
    this.tipeKamar = tipeKamar;
    this.kapasitas = kapasitas;
    this.tarifSewa = tarifSewa;
  }

  public String getIdKamar() {
    return idKamar;
  }

  public String getTipeKamar() {
    return tipeKamar;
  }

  public int getKapasitas() {
    return kapasitas;
  }

  public double getTarifSewa() {
    return tarifSewa;
  }

  public void setTarifSewa(double tarifSewa) {
    this.tarifSewa = tarifSewa;
  }
}

class PengelolaSewa<T extends Kamar> {

  private ArrayList<T> kamarList;

  public PengelolaSewa() {
    this.kamarList = new ArrayList<>();
  }

  public void tambahKamar(T kamar) {
    kamarList.add(kamar);
  }

  public void tampilkanKamar() {
    if (kamarList.isEmpty()) {
      System.out.println("Tidak ada kamar yang tersedia.");
    } else {
      System.out.println("Daftar Kamar:");
      int index = 1;
      for (T kamar : kamarList) {
        System.out.println(
          (index++) +
          ". " +
          kamar.getTipeKamar() +
          " (ID: " +
          kamar.getIdKamar() +
          ") - Kapasitas: " +
          kamar.getKapasitas() +
          ", Tarif Sewa: Rp. " +
          kamar.getTarifSewa()
        );
      }
    }
  }

  public void hapusKamar(String idKamar) {
    boolean found = false;
    for (T kamar : kamarList) {
      if (kamar.getIdKamar().equals(idKamar)) {
        kamarList.remove(kamar);
        System.out.println(
          "Kamar dengan ID " + idKamar + " dihapus dari daftar."
        );
        found = true;
        break;
      }
    }

    if (!found) {
      System.out.println("Kamar dengan ID " + idKamar + " tidak ditemukan.");
    }
  }

  public void editKamar(String idKamar, Scanner sc) {
    boolean found = false;
    for (T kamar : kamarList) {
      if (kamar.getIdKamar().equals(idKamar)) {
        System.out.print("Masukkan tarif sewa baru: Rp. ");
        double tarifSewaBaru = sc.nextDouble();
        kamar.setTarifSewa(tarifSewaBaru);
        System.out.println(
          "Tarif Sewa Kamar dengan ID " + idKamar + " diperbarui."
        );
        found = true;
        break;
      }
    }

    if (!found) {
      System.out.println("Kamar dengan ID " + idKamar + " tidak ditemukan.");
    }
  }
}
