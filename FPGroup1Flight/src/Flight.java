import java.time.LocalTime;

public class Flight {

    private String namaPemesan;
    private String asal;
    private String tujuan;
    private String kodePesawat;
    private String namaPesawat;
    private String kodeBooking;
    private int harga;
    private String metodeBayar;
    private String jamKeberangkatan;

    public Flight() {
        // TODO Auto-generated constructor stub
    }

    public Flight(String namaPemesan, String asal, String tujuan, String kodePesawat, String namaPesawat,
                  String kodeBooking, int harga, String metodeBayar, String jamKeberangkatan) {
        super();
        this.namaPemesan = namaPemesan;
        this.asal = asal;
        this.tujuan = tujuan;
        this.kodePesawat = kodePesawat;
        this.namaPesawat = namaPesawat;
        this.kodeBooking = kodeBooking;
        this.harga = harga;
        this.metodeBayar = metodeBayar;
        this.jamKeberangkatan = jamKeberangkatan;
    }


    public String getNamaPemesan() {
        return namaPemesan;
    }

    public void setNamaPemesan(String namaPemesan) {
        this.namaPemesan = namaPemesan;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getKodePesawat() {
        return kodePesawat;
    }

    public void setKodePesawat(String kodePesawat) {
        this.kodePesawat = kodePesawat;
    }

    public String getNamaPesawat() {
        return namaPesawat;
    }

    public void setNamaPesawat(String namaPesawat) {
        this.namaPesawat = namaPesawat;
    }

    public String getKodeBooking() {
        return kodeBooking;
    }

    public void setKodeBooking(String kodeBooking) {
        this.kodeBooking = kodeBooking;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getMetodeBayar() {
        return metodeBayar;
    }

    public void setMetodeBayar(String metodeBayar) {
        this.metodeBayar = metodeBayar;
    }

    public String getJamKeberangkatan() {
        return jamKeberangkatan;
    }

    public void setJamKeberangkatan(String jamKeberangkatan) {
        this.jamKeberangkatan = jamKeberangkatan;
    }
}
