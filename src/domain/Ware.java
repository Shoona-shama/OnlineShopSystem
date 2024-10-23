package domain;

public class Ware {
    private int bestand;
    private String gewicht;
    private String produktName;
    private double preis;
   // ArrayList<Waren> waren = new ArrayList<>();
     public Ware(String produktName , String gewicht , int bestand , double preis ){
        this.gewicht = gewicht;
        this.preis = preis;
        this.produktName = produktName;
        this.bestand = bestand;
        }

    public int getBestand() {
        return bestand;
    }

    public String  getGewicht() {
        return gewicht;
    }

    public String getProduktName() {
        return produktName;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public void setProduktName(String produktName) {
        this.produktName = produktName;
    }

    public void setGewicht(String gewicht) {
        this.gewicht = gewicht;
    }

    public void setBestand(int bestand) {
        this.bestand = bestand;
    }


}









