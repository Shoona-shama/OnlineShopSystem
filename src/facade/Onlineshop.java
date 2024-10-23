package facade;

import domain.Ware;

// import javax.swing.*;
import java.util.ArrayList;
 // import java.util.zip.GZIPInputStream;

public class Onlineshop {

    ArrayList<Ware> availableProducts;
    private ArrayList<Ware> shoppingCart;
    public Ware pr;

    public Onlineshop() {

        availableProducts = new ArrayList<>();
        shoppingCart = new ArrayList<>();

        availableProducts.add(pr = new Ware("Cookingbooks", "700g", 20, 35.99));
        availableProducts.add(pr = new Ware("CD", "20g", 67, 8.69));
        availableProducts.add(pr = new Ware("Stationary", "45", 36, 10.99));
        availableProducts.add(pr = new Ware("Cassette", "10g", 20, 3.99));
        availableProducts.add(pr = new Ware("Cabels", "10", 39, 13.99));
        availableProducts.add(pr = new Ware("Headphones", "12", 10, 33.89));


        /**  JFrame frame = new JFrame();
         String[] columnNames = {"Name", "Preis", "Gewicht" , "Bestand"};
         Object[][] wareData = {
         {"Gieskanne", new Double (3.99), new Integer(250), new Integer(17)},
         {"Hut", new Double(21.98), new Integer(120), new Integer(123)},
         {"Schraubenset", new Double(2.99), new Integer(287), new Integer(99)},
         {"Dosenwurst",new Double(3.99), new Integer(200), new Integer(7) },
         {"Gartenschlau", new Double(18.99), new Integer(1300), new Integer(23) }
         {"Akkuschrauber" , new Double(25.0) new Integer(900), new Integer(13)}
         };
         JTable table = new JTable(wareData, columnNames);
         **/

    }

    public String displayAvailableProducts() {
        StringBuilder productList = new StringBuilder();
        for (Ware pr : availableProducts) {
            productList.append(pr.getProduktName());
            productList.append(" ");
            productList.append("gewicht:" + pr.getGewicht());
            productList.append(" ");
            productList.append("bestand:" + pr.getBestand());
            productList.append(" ");
            productList.append("preis:" + pr.getPreis());
            productList.append(" ");
            productList.append("\n ");
        }
        return productList.toString();
    }

    public String addToShoppingCart(String produktName) {
        for (Ware pr : availableProducts) {
            if (pr.getProduktName().equalsIgnoreCase(produktName)) {
                if (pr.getBestand() > 0) {
                    shoppingCart.add(pr);
                    pr.setBestand(pr.getBestand() - 1);
                    return produktName + " added to the shopping cart!";
                } else {
                    return "Sorry, " + produktName + " is out of stock.";
                }
            }
        }
        return "Product " + produktName + " not found in the store.";
    }


    public boolean areProductsAvailable() {
        for (Ware pr : availableProducts){
            if (pr.getBestand() > 0) {
                return true;
            }
        }
        return false;
    }




}




