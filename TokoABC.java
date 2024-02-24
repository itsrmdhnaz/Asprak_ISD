import java.util.ArrayList;

public class TokoABC {

  public static void main(String[] args) {
    StorageItem<ATK> atkStorage = new StorageItem<ATK>();
    StorageItem<Bag> bagStorage = new StorageItem<Bag>();

    atkStorage.addItem(
      new ATK("A001", "Spidol", "Staedtler Lumocolor Hitam", 50)
    );
    atkStorage.addItem(new ATK("A002", "Pensil", "Faber Castell 2B", 40));
    atkStorage.addItem(new ATK("A003", "Pulpen", "Pilot G-2", 30));
    atkStorage.addItem(new ATK("A004", "Spidol", "Sakura Pen-Touch Putih", 20));
    atkStorage.addItem(new ATK("A005", "Spidol", "Sakura Pen-Touch Hitam", 10));

    atkStorage.addItem(new ATK("B001", "Buku Tulis", "Quartet Hardcover", 50));
    atkStorage.addItem(new ATK("B002", "Kertas HVS", "PaperOne A4", 100));
    atkStorage.addItem(new ATK("B003", "Buku Tulis", "Moleskine Cahier", 30));
    atkStorage.addItem(new ATK("B004", "Kertas Karton", "Board Paper", 40));
    atkStorage.addItem(
      new ATK("B005", "Buku Tulis", "Oxford Black n' Red", 35)
    );

    System.out.println("Daftar ATK:");
    atkStorage.displayStorageItem();

    atkStorage.removeItem(
      new ATK("A005", "Spidol", "Sakura Pen-Touch Hitam", 10)
    );

    atkStorage.editItem(
      3,
      new ATK("A004", "Spidol", "Sakura Pen-Touch Putih", 15)
    );

    System.out.println("\nDaftar ATK setelah perubahan:");
    atkStorage.displayStorageItem();

    bagStorage.addItem(
      new Bag("C001", "Tempat Pensil", "Stationery Organizer", 30)
    );
    bagStorage.addItem(new Bag("C002", "Tas", "Canvas Backpack", 15));
    bagStorage.addItem(
      new Bag("C003", "Tempat Pensil", "Mesh Pencil Case", 25)
    );
    bagStorage.addItem(new Bag("C004", "Tas", "Leather Shoulder Bag", 12));
    bagStorage.addItem(
      new Bag("C005", "Tempat Pensil", "Wooden Pencil Holder", 20)
    );

    System.out.println("\nDaftar Bag:");
    bagStorage.displayStorageItem();

    bagStorage.removeItem(
      new Bag("C005", "Tempat Pensil", "Wooden Pencil Holder", 20)
    );

    bagStorage.editItem(3, new Bag("C004", "Tas", "Leather Shoulder Bag", 10));

    System.out.println("\nDaftar Bag setelah perubahan:");
    bagStorage.displayStorageItem();
  }
}

class StorageItem<T> {

  private ArrayList<T> items;

  public StorageItem() {
    items = new ArrayList<T>();
  }

  public void addItem(T item) {
    items.add(item);
  }

  public void removeItem(T item) {
    items.remove(item);
  }

  public void editItem(int index, T newItem) {
    items.set(index, newItem);
  }

  public void displayStorageItem() {
    for (T item : items) {
      System.out.println(item.toString());
    }
  }
}

class Bag {

  private String kodeBarang;
  private String jenisBarang;
  private String namaBarang;
  private int stok;

  public Bag(
    String kodeBarang,
    String jenisBarang,
    String namaBarang,
    int stok
  ) {
    this.kodeBarang = kodeBarang;
    this.jenisBarang = jenisBarang;
    this.namaBarang = namaBarang;
    this.stok = stok;
  }

  @Override
  public String toString() {
    return (
      "Bag [kodeBarang=" +
      kodeBarang +
      ", jenisBarang=" +
      jenisBarang +
      ", namaBarang=" +
      namaBarang +
      ", stok=" +
      stok +
      "]"
    );
  }
}

class ATK {

  private String kodeBarang;
  private String jenisBarang;
  private String namaBarang;
  private int stok;

  public ATK(
    String kodeBarang,
    String jenisBarang,
    String namaBarang,
    int stok
  ) {
    this.kodeBarang = kodeBarang;
    this.jenisBarang = jenisBarang;
    this.namaBarang = namaBarang;
    this.stok = stok;
  }

  @Override
  public String toString() {
    return (
      "ATK [kodeBarang=" +
      kodeBarang +
      ", jenisBarang=" +
      jenisBarang +
      ", namaBarang=" +
      namaBarang +
      ", stok=" +
      stok +
      "]"
    );
  }
}
