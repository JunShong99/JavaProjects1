package my.example;

import java.util.Scanner;

//ABSTRACTION
public  class NextDayDelivery extends NextDayDeliveryItem{
    static Scanner input = new Scanner(System.in);

    //ENCAPSULATION
    private String name;
    private String identityCardNumber;
    private String address;

    //setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void amount1(){
        NextDayDelivery nextDayDelivery=new NextDayDelivery();
        nextDayDelivery.choice();
        nextDayDelivery.address();

    }

    @Override
    public void address(){


        NextDayDelivery nextDayDelivery=new NextDayDelivery();

        //setters and getters
        System.out.print("Enter your name:");
        nextDayDelivery.setName(input.nextLine());
        System.out.println(nextDayDelivery.getName());

        //setters and getters
        System.out.print("Enter your Identity Card Number:");
        nextDayDelivery.setIdentityCardNumber(input.next());
        System.out.println(nextDayDelivery.getIdentityCardNumber());

        //setters and getters
        System.out.print("Enter your delivery address: ");
        input.nextLine();
        nextDayDelivery.setAddress(input.nextLine());
        System.out.println(nextDayDelivery.getAddress());



    }
}
//ABSTRACTION
abstract class NextDayDeliveryItem extends NextDayDeliveryPayment {

    static Scanner input = new Scanner(System.in);
    public void choice() {
        int choice;

        /*Display Menu*/
        System.out.printf("1. Input your data\n");
        System.out.printf("2. Return to Main Menu\n");

        System.out.printf("Enter your choice\t\t\t:");
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
            NextDayDelivery nextDayDelivery=new NextDayDelivery();
            nextDayDelivery.packageType();

            ExtraNotesOne extraNotesOne = new ExtraNotesOne();
            extraNotesOne.showContent();

            System.out.printf("Enter your choice\t\t\t:");
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


    public static void Table() {

        int line;

        /*Display Table*/
        NextDayDelivery nextDayDelivery=new NextDayDelivery();
        nextDayDelivery.displayLists();

        System.out.printf("\n\t\t\tDocument (below 2kg)\t\t\t\tParcel(above 2kg)\n");

        nextDayDelivery.displayLists();
        System.out.printf("\n\t   First 500gm\t   Subsequent 250gm\t\t2.001-2.5kg\t\tSubsequent 500gm\n");

        nextDayDelivery.displayLists();
        System.out.printf("\nZone 1\t\t4.90\t\t\t0.80\t\t\t\t10.50\t\t\t0.50\n");
        System.out.printf("\nZone 2\t\t5.40\t\t\t1.00\t\t\t\t16.00\t\t\t2.00\n");
        System.out.printf("\nZone 3\t\t6.90\t\t\t1.50\t\t\t\t21.00\t\t\t3.00\n");
        System.out.printf("\nZone 4\t\t7.40\t\t\t1.50\t\t\t\t26.00\t\t\t3.50\n");
        System.out.printf("\nZone 5\t\t7.90\t\t\t2.00\t\t\t\t31.00\t\t\t4.00\n");

        nextDayDelivery.displayLists();
    }
}
//ABSRACTION
abstract class NextDayDeliveryPayment extends NextDayDeliveryLists {
    public static double totalcharge1[] = new double[3];



    public void packageType() {

        Scanner input = new Scanner(System.in);

        /*Declaration*/
        int zone;
        int customer;
        String packagetype;
        double weight = 0;
        double charge1 = 0;

        for (customer = 0; customer < totalcharge1.length; customer++) {

            /*Display Customer*/
            System.out.printf("\nCustomer %d:\n", customer + 1);
            System.out.printf("----------------------\n");

            totalcharge1[customer] = 0;

            /*Input First Package Type*/
            System.out.printf("\nEnter your package type(document/parcel/X to quit)\t\t:");
            packagetype = input.next();
            packagetype = packagetype.toUpperCase();

            /*Loop*/
            while (!packagetype.equals("X")) {

                /*input weight and zone*/
                System.out.printf("Enter your weight\t\t\t:");
                weight = input.nextDouble();
                System.out.printf("Enter your zone\t\t\t\t:");
                zone = input.nextInt();
                while (zone > 5) {
                    System.out.printf("Invalid Input!!! Please key in correct data!!!\n");
                    System.out.printf("Enter your zone\t\t\t\t:");
                    zone = input.nextInt();
                }
                while (zone <= 5) {
                    break;
                }

                /*Call calCharge*/
                charge1 = calCharge(weight, zone);

                /*Display Charges*/
                System.out.printf("Charges in %s is RM%.2f\n", packagetype, charge1);

                /*Accuumulate Total Charge*/
                totalcharge1[customer] += charge1;

                /*Input First Package Type*/
                System.out.printf("\nEnter your package type\t\t:");
                packagetype = input.next();
                packagetype = packagetype.toUpperCase();

            }
            System.out.printf("All charges in RM%.2f\n", totalcharge1[customer]);
        }
    }

    public static double calCharge(double weight, int zone) {

        double charge1 = 0;


        switch (zone) {

            case 1:
                if (weight <= 2000) {
                    if (weight <= 2000) {
                        charge1 = 4.90 + (weight - 500) / 250 * 0.80;
                    }
                    if (weight <= 500) {
                        charge1 = 4.90;
                    }
                }
                if (weight > 2000) {
                    if (weight <= 2500) {
                        charge1 = 10.50;
                    }
                    if (weight > 2500) {
                        charge1 = 10.50 + (weight - 2500) / 500 * 0.50;
                    }
                }
                break;
            case 2:
                if (weight <= 2000) {
                    if (weight <= 2000) {
                        charge1 = 5.40 + (weight - 500) / 250 * 1.00;
                    }
                    if (weight <= 500) {
                        charge1 = 5.40;
                    }
                }
                if (weight > 2000) {
                    if (weight <= 2500) {
                        charge1 = 16.00;
                    }
                    if (weight > 2500) {
                        charge1 = 16.00 + (weight - 2500) / 500 * 2.00;
                    }
                }
                break;
            case 3:
                if (weight <= 2000) {
                    if (weight <= 2000) {
                        charge1 = 6.90 + (weight - 500) / 250 * 1.50;
                    }
                    if (weight <= 500) {
                        charge1 = 6.90;
                    }
                }
                if (weight > 2000) {
                    if (weight <= 2500) {
                        charge1 = 21.00;
                    }
                    if (weight > 2500) {
                        charge1 = 21.00 + (weight - 2500) / 500 * 3.00;
                    }
                }
                break;
            case 4:
                if (weight <= 2000) {
                    if (weight <= 2000) {
                        charge1 = 7.40 + (weight - 500) / 250 * 1.50;
                    }
                    if (weight <= 500) {
                        charge1 = 7.40;
                    }
                }
                if (weight > 2000) {
                    if (weight <= 2500) {
                        charge1 = 26.00;
                    }
                    if (weight > 2500) {
                        charge1 = 26.00 + (weight - 2500) / 500 * 3.50;
                    }
                }
                break;
            case 5:
                if (weight <= 2000) {
                    if (weight <= 2000) {
                        charge1 = 7.90 + (weight - 500) / 250 * 2.00;
                    }
                    if (weight <= 500) {
                        charge1 = 7.90;
                    }
                }
                if (weight > 2000) {
                    if (weight <= 2500) {
                        charge1 = 31.00;
                    }
                    if (weight > 2500) {
                        charge1 = 31.00 + (weight - 2500) / 500 * 4.00;
                    }
                }
                break;

        }

        return charge1;
    }

    public static double[] getTotalCharge() {
        return totalcharge1;
    }
}


//ABSTRACTION
abstract class NextDayDeliveryLists extends PosLajuMalaysia  {


    public void displayLists() {
        int line = 1;
        while (line <= 100) {
            System.out.printf("%c", 45);
            line++;
        }
    }


}
class NotesOne{
    public void showContent(){
        System.out.println();
        System.out.println("1. Exit");
    }
}

//POLYMORPHISM (overriding) //INHERITANCE
class ExtraNotesOne extends NotesOne{

    @Override
    public void showContent(){
        super.showContent();
        System.out.println("2. Return to Main Menu");
    }
}