package d2_20171022.classes1;

/**
 * Created by exitle on 22.10.17.
 */
public class Pracownik {
    private String imie;
    private String nazwisko;
    private double pensja;
    private int wiek;

    public Pracownik(String imie, String nazwisko, double pensja, int wiek) {
        if (imie.length() < 5 || !Character.isUpperCase(imie.charAt(0))) {
            System.err.println("Imie musi mieć conajmniej 5 liter i zaczynać się z wielkiej litery.");
        } else if (nazwisko.length() < 5 || !Character.isUpperCase(nazwisko.charAt(0))) {
            System.err.println("Nazwisko musi mieć conajmniej 5 liter i zaczynać się z wielkiej litery.");
        } else {
            this.imie = imie;
            this.nazwisko = nazwisko;
            this.pensja = pensja;
            this.wiek = wiek;
        }
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public double getPensja() {
        return pensja;
    }

    public double getRocznaPensja() {
        return pensja * 12;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }
}
