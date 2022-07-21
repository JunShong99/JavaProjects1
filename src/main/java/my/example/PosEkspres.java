package my.example;

import java.util.Scanner;

//ABSTRACTION
public class PosEkspres extends PosEkspresItem {


    public void amount4() {
        PosEkspres posEkspres=new PosEkspres();
        posEkspres.choice();
        posEkspres.address();
    }


    @Override
    public void address() {


    }
}

//ABSTRACTION
abstract class PosEkspresItem extends PosEkspresPayment {
    static Scanner input=new Scanner(System.in);
    public void choice() {

        Scanner input = new Scanner(System.in);

        int choice;

        /*Display Menu*/
        System.out.printf("1. Input your data\n");
        System.out.printf("2. Return to Main Menu\n");

        System.out.printf("Enter your choice\t:");
        choice = input.nextInt();
        while (choice > 2) {
            System.out.printf("Invalid Input!!! Please key in correct data!!!\n");
            System.out.printf("Enter your choice\t:");
            choice = input.nextInt();
        }
        while (choice <= 2) {
            break;
        }

        if (choice == 1) {

            Table();

            PosEkspres posEkspres=new PosEkspres();
            posEkspres.packageType();

            Voucher voucher=new Voucher();
            voucher.showContent();

            System.out.printf("Enter your choice\t:");
            choice = input.nextInt();

            while (choice > 2) {
                System.out.printf("Invalid Input!!! Please key in correct data!!!\n");
                System.out.printf("Enter your choice\t:");
                choice = input.nextInt();
            }
            System.out.println();
            while (choice <= 2) {
                break;
            }
        }
        if (choice == 2) {
            Main main=new Main();
            main.choice();
        }


    }

    public void Table() {

        int line;

        /*Display Table*/
        PosEkspres posEkspres=new PosEkspres();
        posEkspres.displayLists();

        System.out.printf("\nJenis\t\t\t  LG\t\t\t\t  LE(C5)\t\t\t LD(B4)\t\t\t     LK\n");
        posEkspres.displayLists();
        System.out.printf("\nSaiz\t\t   220mm*110mm\t\t\t229mm*162mm\t\t  353mm*250mm\t\t 340mm*250mm\n\n");
        System.out.printf("Berat Max\t\t 100g\t\t\t\t   250g\t\t\t\t  500g\t\t\t\t1000g\n\n");
        System.out.printf("Berat Max\t\t 3mm\t\t\t\t   5mm\t\t\t\t  10mm\t\t\t\t25mm\n\n");
        System.out.printf("Harga\t\t\tRM3.18\t\t\t\t  Rm3.71\t\t\t RM4.77\t\t\t    RM7.42\n");
        posEkspres.displayLists();
    }
}


//ABSTRACTION
abstract class PosEkspresPayment extends PosEkspresLists {
    public static double totalcharge4[] = new double[3];

    public void packageType() {

        Scanner input = new Scanner(System.in);

        /*Declaration*/
        int quantity;
        int customer;
        String ItemType;
        double weight;
        double totalprice = 0;

        for (customer = 0; customer < totalcharge4.length; customer++) {

            /*Display Customer*/
            System.out.printf("\n\nCustomer %d:\n", customer + 1);
            System.out.printf("----------------------\n");

            totalcharge4[customer] = 0;

            /*Input First Item Type*/
            System.out.printf("\nEnter your item (LG/LE/LD/LK/X to quit)):");
            ItemType = input.next();
            ItemType = ItemType.toUpperCase();

            /*Loop*/
            while (!ItemType.equals("X")) {

                /*Input Quantity*/
                System.out.printf("Enter your quantity\t\t\t\t\t:");
                quantity = input.nextInt();


                /*Input Weight*/
                System.out.printf("Enter your weight\t\t\t\t\t:");
                weight = input.nextDouble();


                while (weight > 1000) {
                    System.out.printf("Invalid Input!!! Please key in correct data!!!\n");
                    System.out.printf("Enter your weight\t\t:");
                    weight = input.nextDouble();
                }
                while (weight <= 1000) {
                    break;
                }

                /*Call calTotalPrice*/
                totalprice = calTotalPrice(quantity, weight);

                /*Display Charges*/
                System.out.printf("Charges in %s is RM%.2f\n", ItemType, totalprice);

                /*Accumulate Total Charge*/
                totalcharge4[customer] += totalprice;

                /*Input First Item Type*/
                System.out.printf("\nEnter your item (LG/LE/LD/LK/X to quit)):");
                ItemType = input.next();
                ItemType = ItemType.toUpperCase();

            }
            System.out.printf("All charges in RM%.2f\n", totalcharge4[customer]);

        }


        Voucher voucher = new Voucher();
        voucher.star();
        for (int i = 0; i < 3; i++) {
            double voucher1, voucher2;

            //POLYMORPHISM (overloading)
            System.out.println("customer " + (1 + i));
            if (totalcharge4[i] >= 0 && totalcharge4[i] <= 29) {
                System.out.println("Redeem lazada voucher at minimum spent of RM30!");
            } else if (totalcharge4[i] >= 30 && totalcharge4[i] <= 50) {
                voucher1 = voucher.number(1.50, 1.50);
                System.out.println(voucher1 + "% lazada ticket voucher");
            } else {
                voucher2 = voucher.number(2, 2, 2);
                System.out.println(voucher2 + "% lazada ticket voucher");
            }

        }
        voucher.star();
    }

    public double[] getTotalCharge() {
        return totalcharge4;
    }


    public double calTotalPrice(int quantity, double weight) {

        double price = 0;
        double totalprice;

        if (weight <= 100) {
            price = 3.18;
        }
        if (weight > 100 && weight <= 250) {
            price = 3.71;
        }
        if (weight > 250 && weight <= 500) {
            price = 4.77;
        }
        if (weight > 500 && weight <= 1000) {
            price = 7.42;
        }

        totalprice = price * quantity;

        return totalprice;
    }

}
//ABSTRACTION
abstract class  PosEkspresLists extends PosLajuMalaysia{
    public void displayLists() {
        int line = 1;
        while (line <= 100) {
            System.out.printf("%c", 45);
            line++;
        }
    }


}

class Voucher  {

    //POLYMORPHISM (overloading)
    public double number(double x, double y) {
        return x + y;
    }

    public double number(double x, double y, double z) {
        return x + y + z;
    }

    public void star() {
        System.out.println("**************************************************");
    }



    public void showContent(){
        Notes notes=new Notes();

        //ENCAPSULATION setters and getters
        notes.setNum2(2);
        System.out.println(notes.getNum2()+". Return to Main Menu");
    }


}