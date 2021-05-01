import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {

        String input="";
        //Parse data
        Item ipd = new Item("ipd", "Super iPad",549.99);
        Item mbp = new Item("mbp", "MacBook Pro",1399.99);
        Item atv = new Item("atv", "Apple TV",109.50);
        Item vga = new Item("vga", "VGA adapter",30.00);
        //Set rule
        ArrayList<Rule> rules = new ArrayList();
        rules.add(new BuyXGetY(2,1, atv));
        rules.add(new DiscountMoreThanX(4, 499.99, ipd));
        rules.add(new BuyAGiveB(mbp,vga));

        Checkout co = new Checkout(rules);
        Item itemlist [] = new Item[]{ipd,mbp,atv,vga};

        while (!input.equals("Q")) {
            System.out.println("=================Shopping-R-Us================");
            System.out.println(String.format("|%4s |%18s |%18s|","SKU", "Name", "Price"));
            System.out.println("----------------------------------------------");

            for (Item item:itemlist) {
                System.out.println(String.format("|%4s |%18s |%18.2f|",item.getSKU(), item.getName(),item.getPrice()));
            }
            System.out.println("================String Operations=============");
            System.out.println("1. Add Super iPad to your cart");
            System.out.println("2. Add MacBook Pro to your cart");
            System.out.println("3. Add Apple TV to your cart");
            System.out.println("4. Add VGA adapter to your cart");
            System.out.println("5. Check the total price");
            System.out.println("6. Clear the cart");
            System.out.println("================String Operations=============");
            System.out.println("Please enter 1,2,3 or 4 to select an option");
            System.out.println("Enter \"Q\" to terminate the program");
            input = sc.nextLine();

            switch (input) {
                case "1":
                    co.scan(ipd);
                    System.out.println("Super iPad added to your cart");
                    break;
                case "2":
                    co.scan(mbp);
                    System.out.println("MacBook Pro added to your cart");
                    break;
                case "3":
                    co.scan(atv);
                    System.out.println("Apple TV added to your cart");
                    break;
                case "4":
                    co.scan(vga);
                    System.out.println("VGA adapter added to your cart");
                    break;
                case "5":
                    System.out.println(String.format("Total expected: $%.2f", co.total()));
                    break;
                case "6":
                    co.clear();
                    break;
                case "Q":
                    break;
                default:
                    break;
            }
        }
        sc.close();


    }


}
