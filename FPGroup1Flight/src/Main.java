import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    //buat scanner agar bisa dipakai untuk scan
    private Scanner sc = new Scanner(System.in);

    //declare semua variabel penampung yang diperlukan
    private int choice, jam, harga;
    private String nama, namaPesawat, asal, tujuan, metodeBayar, kodePesawat, kodeBooking;

    //buat variabel untuk random (dibutuhkan untuk kode booking)
    private Random rand = new Random();

    //Arraylist untuk menyimpan pemesanan yang sudah dibuat
    ArrayList<Flight> fList = new ArrayList<Flight>();

    //fungsi yang nantinya dipanggil untuk print semua pemesanan penerbangan yang ada di dalam arrayList Flight
    public void printView() {
        // TODO Auto-generated method stub
        System.out.println("List Pesanan : \n");
        for (Flight f : fList) {
            System.out.println("" + f.getKodeBooking() + " | " + f.getNamaPemesan()+ " | " +
                    f.getKodePesawat() + " | " + f.getNamaPesawat() + " | " + f.getAsal() + " | " +
                    f.getTujuan() + " | " + f.getJamKeberangkatan() + " | "
                    + f.getHarga() + " | " + f.getMetodeBayar());
        }
    }

    //fungsi untuk print menu utama.
    public void printMenu() {
        // TODO Auto-generated method stub
        System.out.println("The Flight of the World\n" +
                "1. Pesan Penerbangan\n" +
                "2. Cek Pesanan\n" +
                "3. Exit\n" +
                "Choose [1-3] >> ");
    }

    public Main() {
        // TODO Auto-generated constructor stub
        //do while akan mengulang selama pengguna tidak memilih nomor 3 / exit.
        do {
            //panggil fungsi printMenu
            printMenu();
            //scan pilihan pengguna, apakah 1 / 2 / 3
            choice = sc.nextInt();
            sc.nextLine();

            //masuk ke pilihan pengguna sesuai nomor.
            switch (choice) {
                case 1: {
                    //input nama, apabila panjang kurang dr 3 karakter atau lebih dr 100 karakter,
                    //maka akan diminta input ulang
                    do {
                        System.out.print("Masukkan nama Anda : ");
                        nama = sc.nextLine();
                    } while (nama.length() < 3 || nama.length() > 100);

                    //input maskapai, apabila nama maskapai yang diinput tidak sesuai,
                    //maka akan diminta input ulang
                    do {
                        System.out.print("Nama maskapai yang Anda inginkan [Garuda/AirAsia/LionAir] " +
                                "*case insensitive : ");
                        namaPesawat = sc.nextLine();
                    } while (!namaPesawat.equalsIgnoreCase("garuda") &&
                            !namaPesawat.equalsIgnoreCase("airasia") &&
                            !namaPesawat.equalsIgnoreCase("lionair"));

                    //harga akan diset sesuai maskapai yang digunakan
                    //kode pesawat akan diset sesuai maskapai yang digunakan
                    if (namaPesawat.toLowerCase().equals("garuda")) {
                        harga = 2000000;
                        kodePesawat = "GR-0076";
                    } else if (namaPesawat.toLowerCase().equals("airasia")) {
                        harga = 1500000;
                        kodePesawat = "AR-0033";
                    } else if (namaPesawat.toLowerCase().equals("lionair")) {
                        harga = 1200000;
                        kodePesawat = "LA-0099";
                    }

                    System.out.print("Asal : ");
                    asal = sc.nextLine();

                    System.out.print("Tujuan : ");
                    tujuan = sc.nextLine();

                    //input jam, apabila jam tidak sesuai (1-24), maka akan diminta input ulang
                    do {
                        System.out.print("Jam Keberangkatan [1-24] : ");
                        jam = sc.nextInt();
                        sc.nextLine();
                    } while (jam < 1 || jam > 24);

                    String jamKeberangkatan = jam + ":00:00";

                    //input metode bayar, apabila tidak sesuai yang tersedia, maka akan diminta input ulang.
                    do {
                        System.out.print("Metode Pembayaran [Gopay/M-Banking/OVO] *case sensitive : ");
                        metodeBayar = sc.nextLine();
                    } while (!metodeBayar.equals("Gopay") &&
                            !metodeBayar.equals("M-Banking") &&
                            !metodeBayar.equals("OVO"));

                    //melakukan random untuk mendapatkan kode booking
                    int random_int = (int) Math.floor(Math.random() * (999 - 500 + 1) + 500);
                    kodeBooking = "BOOK-" + random_int;

                    //membuat objek bernama fl,
                    // dimasukkan semua variabel yang sudah diisi dengan data oleh pengguna.
                    Flight fl = new Flight(nama, asal, tujuan, kodePesawat, namaPesawat,
                            kodeBooking, harga, metodeBayar, jamKeberangkatan);
                    //objek fl dimasukkan ke dalam arraylist.
                    fList.add(fl);
                    System.out.println("List Added");
                    break;
                }
                case 2: {
                    //menampilkan semua pemesanan penerbangan, apabila kosong,
                    // maka yang diprint adalah "no flight order"
                    if (fList.size() == 0) System.out.println("No Flight Order");
                    else {
                        printView();
                    }
                    break;
                }
            }
        } while (choice != 3);
    }

    public static void main(String[] args) {
        new Main();
    }
    
}
