package ui;

import domain.Ware;
import facade.Onlineshop;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Wilkommen {
    private Wilkommen ui ;
    private Onlineshop shop;
    private Scanner sc ;
    ArrayList<Ware> waren = new ArrayList<>();
    public Wilkommen() throws FileNotFoundException{
        sc = new Scanner(System.in);
        shop = new Onlineshop();
        this.wilkommenZumShop();
    }

    private void wilkommenZumShop() {
        System.out.println("-------------------------------------------");
        System.out.println("Willkomen bei Rhenus, den Online Baumarkt !");
        System.out.println(" ^ " + "  ^  " + "     ^     " + "    ^    " + "  ^  ");
        System.out.println("Home" + "About us" + "Alle Produkte" + "Bestseller" + "Sale");
        String kundeInput = sc.nextLine();
        System.out.println(kundeInput + " ");
        if (!kundeInput.equals("Alle Produkte")) {
            System.out.println(" falsche Eingabe ! ");
        } else {
            do {
                System.out.println(shop.displayAvailableProducts());
                System.out.println("Bitte wählen Sie ein Produkt aus:");
                String chosenProdukt = sc.nextLine();
                String result = shop.addToShoppingCart(chosenProdukt);
                System.out.println(result + " ");
                if (!shop.areProductsAvailable()) {
                    System.out.println("All products are out of stock. No more products can be added.");
                    break;
                }
                System.out.println("do you wish to add another product ? ");
                String continueShopping = sc.nextLine();
                if (!continueShopping.equalsIgnoreCase("yes")) {
                   // System.out.println(shop.displayAvailableProducts());
                    shop.addToShoppingCart(chosenProdukt);
                    break;
                }

            }while (shop.areProductsAvailable()) ;


        }
    }


            public static void main (String[]args){
                    try {
                        new Wilkommen();
                        //not necessary if we applied the products to the constructor directly
                        //only necessary if we import the excel file !
                    } catch (FileNotFoundException e) {
                        System.out.println("Produktliste könnte nicht geladen werden.");
                        System.out.println("Auf wiedersehen ! ");
                    }
                    System.out.println(" danke für Ihren Einkauf ! - Auf wiedersehen !");
                }

            }