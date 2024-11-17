import java.util.Scanner;

// Kelas induk
class Barang {
    private String kodeBarang;
    private String namaBarang;
    private double hargaBarang;

    public Barang(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public double getHargaBarang() {
        return hargaBarang;
    }

    public void displayInfo() {
        System.out.println("Kode Barang: " + kodeBarang);
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Harga Barang: " + hargaBarang);
    }
}

// Kelas turunan
class Transaksi extends Barang {
    private int jumlahBeli;

    public Transaksi(String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(kodeBarang, namaBarang, hargaBarang);
        this.jumlahBeli = jumlahBeli;
    }

    public double hitungTotal() {
        return getHargaBarang() * jumlahBeli;
    }

    public int getJumlahBeli() {
        return jumlahBeli;
    }
}

// Kelas utama
public class ProgramTransaksi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input data transaksi
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();

            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();

            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = scanner.nextDouble();
            if (hargaBarang < 0) {
                throw new IllegalArgumentException("Harga barang tidak boleh negatif!");
            }

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = scanner.nextInt();
            if (jumlahBeli <= 0) {
                throw new IllegalArgumentException("Jumlah beli harus lebih dari 0!");
            }

            // Membuat objek transaksi
            Transaksi transaksi = new Transaksi(kodeBarang, namaBarang, hargaBarang, jumlahBeli);

            // Menampilkan hasil transaksi
            System.out.println("\n--- Data Transaksi ---");
            System.out.println("No Faktur: " + noFaktur);
            transaksi.displayInfo();
            System.out.println("Jumlah Beli: " + transaksi.getJumlahBeli());
            System.out.println("Total: " + transaksi.hitungTotal());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
