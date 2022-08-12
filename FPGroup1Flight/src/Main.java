import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    private Scanner sc = new Scanner(System.in);
    private int choice, jam, harga;
    private String nama, namaPesawat, asal, tujuan, metodeBayar, kodePesawat, kodeBooking;
    private Random rand = new Random();
    ArrayList<Flight> fList = new ArrayList<Flight>();

    public void printView() {
        // TODO Auto-generated method stub
        System.out.println("List Pesanan : \n");
        for (Flight f : fList) {
            System.out.println("" + f.getKodeBooking() + " | " + f.getNamaPemesan()+ " | " +f.getKodePesawat() + " | "
                    + f.getNamaPesawat() + " | " + f.getAsal() + " | " + f.getTujuan() + " | " + f.getJamKeberangkatan() + " | "
                    + f.getHarga() + " | " + f.getMetodeBayar());
        }
    }

    public void printMenu() {
        // TODO Auto-generated method stub
        System.out.println("The Flight of the World\n1. Pesan Penerbangan\n2. Cek Pesanan\n3. Exit\nChoose [1-3] >> ");
    }

    public Main() {
        // TODO Auto-generated constructor stub
        do {
            printMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: {
                    do {
                        System.out.print("Masukkan nama Anda : ");
                        nama = sc.nextLine();
                    } while (nama.length() < 3 || nama.length() > 100);

                    do {
                        System.out.print("Nama maskapai yang Anda inginkan [Garuda/AirAsia/LionAir] *case insensitive : ");
                        namaPesawat = sc.nextLine();
                    } while (!namaPesawat.equalsIgnoreCase("garuda") && !namaPesawat.equalsIgnoreCase("airasia")
                            && !namaPesawat.equalsIgnoreCase("lionair"));

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

                    do {
                        System.out.print("Jam Keberangkatan [1-24] : ");
                        jam = sc.nextInt();
                        sc.nextLine();
                    } while (jam < 1 || jam > 24);

                    String jamKeberangkatan = jam + ":00:00";

                    do {
                        System.out.print("Metode Pembayaran [Gopay/M-Banking/OVO] *case sensitive : ");
                        metodeBayar = sc.nextLine();
                    } while (!metodeBayar.equals("Gopay") && !metodeBayar.equals("M-Banking") && !metodeBayar.equals("OVO"));

                    int random_int = (int) Math.floor(Math.random() * (999 - 500 + 1) + 500);
                    kodeBooking = "BOOK-" + random_int;

                    Flight fl = new Flight(nama, asal, tujuan, kodePesawat, namaPesawat, kodeBooking, harga, metodeBayar, jamKeberangkatan);
                    fList.add(fl);
                    System.out.println("List Added");
                    break;
                }
                case 2: {
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
