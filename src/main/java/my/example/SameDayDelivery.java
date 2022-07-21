package my.example;

import java.util.Scanner;


//ABSTRACTION
public class SameDayDelivery extends SameDayDeliveryItem{


    public void amount2() {
        SameDayDelivery sameDayDelivery=new SameDayDelivery();
        sameDayDelivery.choice();

    }


    @Override
    public void address() {

    }

}

//ABSTRACTION
abstract class SameDayDeliveryItem extends SameDayDeliveryPayment {

    static Scanner input = new Scanner(System.in);

    public void choice() {

        Scanner input = new Scanner(System.in);

        int choice;

        /*Display Menu*/
        System.out.printf("1. Input your data\n");
        System.out.printf("2. Return to Main Menu\n");


        System.out.printf("Enter your choice\t\t:");
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


            SameDayDelivery sameDayDelivery=new SameDayDelivery();
            sameDayDelivery.box();

            Notes notes = new Notes("Main Menu");


            System.out.printf("Enter your choice\t\t\t:");
            choice = input.nextInt();
            while (choice > 2) {
                System.out.printf("Invalid Input!!! Please key in correct data!!!\n");
                System.out.printf("Enter your choice\t\t\t:");
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

    public static void Table() {

        /*Display Table*/
        SameDayDelivery sameDayDelivery=new SameDayDelivery();
        sameDayDelivery.displayLists();
        System.out.printf("\nWeight\t\t\t\tLocal Town\t\t\t\t\t\t\t\tCross Town\n\t\t");
        int line = 1;
        while (line <= 80) {
            System.out.printf("%c", 45);
            line++;
        }
        System.out.printf("\n\t\t  Domestic Charge\tSurcharge\tTotal\t  Domestic Charge\tSurcharge\tTotal\n");
        sameDayDelivery.displayLists();
        System.out.printf("\nBelow 500gm\t\t4.90\t\t  6.00\t\t10.90\t\t   5.40\t\t\t  7.50\t\t12.90\n");
        System.out.printf("500gm-750gm\t\t5.70\t\t  6.00\t\t11.70\t\t   6.40\t\t\t  7.50\t\t13.90\n");
        System.out.printf("750gm-1kg\t\t6.50\t\t  6.00\t\t12.50\t\t   7.40\t\t\t  7.50\t\t14.90\n");
        sameDayDelivery.displayLists();
        System.out.println();
    }
}



//ABSTRACTION
abstract class SameDayDeliveryPayment extends SameDayDeliveryLists {

    public  double totalcharge2[] = new double[3];

    //ENCAPSULATION
    private int number;
    private double weight;
    private String towntype;

    SameDayDeliveryPayment one;
    SameDayDeliveryPayment two;
    SameDayDeliveryPayment three;

    //setters and getters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getTowntype() {
        return towntype;
    }

    public void setTowntype(String towntype) {
        this.towntype = towntype;
    }


    //constructor
    public  SameDayDeliveryPayment() {

    }

    //constructor
    public  SameDayDeliveryPayment( SameDayDeliveryPayment one, SameDayDeliveryPayment two, SameDayDeliveryPayment three){
        this.one=one;
        this.two=two;
        this.three=three;
    }



    public void box() {
        //cannot be instantiated
        SameDayDelivery   sameDayDeliveryOne  = new SameDayDelivery();
        SameDayDelivery   sameDayDeliveryTwo  = new SameDayDelivery();
        SameDayDelivery   sameDayDeliveryThree  = new SameDayDelivery();


        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");

        //setters and getters //Customer 1, enter your input here
        sameDayDeliveryOne.setNumber(1);
        System.out.print("number :"+sameDayDeliveryOne.getNumber()+"\t\t\t\t\t");
        sameDayDeliveryOne.setWeight(25);
        System.out.print("weight :"+sameDayDeliveryOne.getWeight()+"\t\t\t\t\t");
        sameDayDeliveryOne.setTowntype("local");
        System.out.print("towntype :"+sameDayDeliveryOne.getTowntype()+"\t\t\t\t\t");
        sameDayDeliveryOne.packageType();

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();





        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");

        //setters and getters  //Customer 2, enter your input here
        sameDayDeliveryTwo.setNumber(2);
        System.out.print("number :"+sameDayDeliveryTwo.getNumber()+"\t\t\t\t\t");
        sameDayDeliveryTwo.setWeight(600);
        System.out.print("weight :"+sameDayDeliveryTwo.getWeight()+"\t\t\t\t\t");
        sameDayDeliveryTwo.setTowntype("local");
        System.out.print("towntype :"+sameDayDeliveryTwo.getTowntype()+"\t\t\t\t\t");
        sameDayDeliveryTwo.packageType();

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();





        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");

        //setters and getters   //Customer 3, enter your input here
        sameDayDeliveryThree.setNumber(3);
        System.out.print("number :"+sameDayDeliveryThree.getNumber()+"\t\t\t\t\t");
        sameDayDeliveryThree.setWeight(800);
        System.out.print("weight :"+sameDayDeliveryThree.getWeight()+"\t\t\t\t\t");
        sameDayDeliveryThree.setTowntype("cross");
        System.out.print("towntype :"+sameDayDeliveryThree.getTowntype()+"\t\t\t\t\t");
        sameDayDeliveryThree.packageType();

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();

    }



    public double []getTotalPrice () {

                                       //enter to display 5.receipt value
        totalcharge2[0]=one.calPaymentB(25,"local");
        totalcharge2[1]=two.calPaymentB(600,"local");
        totalcharge2[2]=three.calPaymentB(800,"cross");
        return totalcharge2;
    }

    public void packageType(){

        if(number == 1) {
            System.out.printf("\n\nCustomer %d:\n", 1);
            System.out.printf("----------------------\n");
        }
        else if(number == 2) {
            System.out.printf("\n\nCustomer %d:\n", 2);
            System.out.printf("----------------------\n");
        }
        else if(number == 3) {
            System.out.printf("\n\nCustomer %d:\n", 3);
            System.out.printf("----------------------\n");
        }

        int customer=0;


        totalcharge2[customer]=0;
        double pay=calPaymentB(weight,towntype);


        System.out.printf("\nCharges in %s is RM%.2f\n", towntype, pay);
        totalcharge2[customer] += pay;

        System.out.printf("All charges in RM%.2f\n", totalcharge2[customer]);

    }



    public double calPaymentB(double  weight, String towntype) {

        double payment = 0;
        double surcharge = 0;
        double domestic_charge = 0;

        switch (towntype.toUpperCase()) {

            case "LOCAL":
                if (weight <= 500) {
                    domestic_charge = 4.90;
                    surcharge = 6.00;
                }
                if (weight > 500 && weight <= 750) {
                    domestic_charge = 5.70;
                    surcharge = 6.00;
                }
                if (weight > 750 && weight <= 1000) {
                    domestic_charge = 6.50;
                    surcharge = 6.00;
                }
                break;
            case "CROSS":
                if (weight <= 500) {
                    domestic_charge = 5.40;
                    surcharge = 7.50;
                }
                if (weight > 500 && weight <= 750) {
                    domestic_charge = 6.40;
                    surcharge = 7.50;
                }
                if (weight > 750 && weight <= 1000) {
                    domestic_charge = 7.40;
                    surcharge = 7.50;
                }
                break;
        }
        payment = domestic_charge + surcharge;
        return payment;
    }
}



//ABSTRACTION
abstract class SameDayDeliveryLists extends PosLajuMalaysia {

    public void displayLists() {
        int line = 1;
        while (line <= 100) {
            System.out.printf("%c", 45);
            line++;
        }
    }
}


class Notes{
    //ENCAPSULATION
    private int num2;

    //setters and getters
    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

   //this
    public Notes() {
        System.out.println();
        System.out.println("1. Exit");
    }

    public Notes(String str) {
        this();
        System.out.println("2. Return to "+str);
    }


}
