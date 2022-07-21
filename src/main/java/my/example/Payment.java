package my.example;

import java.util.Scanner;

public class Payment {

    public void amount5() {
        DisplayReceipt displayReceipt=new DisplayReceipt();
        CustomerPayment customerPayment=new CustomerPayment();
        customerPayment.showPayment();
    }

    public void showContent(){
        String note="1. Exit";
        System.out.println(note);
    }

}


class Receipt {
    //constructor  //super
    public Receipt() {
        /*Display Menu*/
        System.out.printf("1. Display Receipt\n");
        System.out.printf("2. Return to Main Menu\n");
    }
}


class DisplayReceipt extends Receipt {
    //constructor
    public DisplayReceipt() {
        System.out.printf("Enter your choice\t:");
    }
}


class CustomerPayment extends Payment {
    static Scanner input = new Scanner(System.in);

    //POLYMORPHISM (overriding)
    public void showContent(){
        super.showContent();
        System.out.println("2. Return to Main Menu");
    }

    public void showPayment() {

        NextDayDelivery nextDayDelivery=new NextDayDelivery();

        SameDayDeliveryPayment sameDayDeliveryPaymentOne = new SameDayDeliveryPayment() {

            @Override
            public void address() {

            }

            @Override
            public void choice() {

            }
        };
        SameDayDeliveryPayment sameDayDeliveryPaymentTwo = new SameDayDeliveryPayment() {


            @Override
            public void address() {

            }

            @Override
            public void choice() {

            }
        };

         SameDayDeliveryPayment sameDayDeliveryPaymentThree = new SameDayDeliveryPayment() {


             @Override
             public void address() {

             }

             @Override
            public void choice() {

            }
        };

        SameDayDeliveryPayment sameDayDeliveryPayment = new SameDayDeliveryPayment(sameDayDeliveryPaymentOne, sameDayDeliveryPaymentTwo, sameDayDeliveryPaymentThree) {


            @Override
            public void address() {

            }

            @Override
            public void choice() {

            }
        };

       PrepaidBoxEnvelop prepaidBoxEnvelop = new PrepaidBoxEnvelop();
        PosEkspres posEkspres=new PosEkspres();

        double totalcharge1[] = nextDayDelivery.getTotalCharge();
        double totalcharge2[] = sameDayDeliveryPayment.getTotalPrice();
        double totalcharge3[] = prepaidBoxEnvelop.getTotalCharge();
        double totalcharge4[] = posEkspres.getTotalCharge();


        int customer;
        int line;
        int choice = 0;
        double grandtotal = 0;


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



            for (customer = 0; customer < totalcharge1.length; customer++) {

                /*Display Customer*/
                System.out.printf("\nCustomer %d:\n", customer + 1);
                System.out.printf("------------------\n");

                //Calculate Grand Total
                grandtotal = totalcharge1[customer] + totalcharge2[customer] + totalcharge3[customer] + totalcharge4[customer];

                //Display Receipt
                System.out.printf("Total Charge:\n");
                System.out.printf("Next-Day Delivery\t\t\tRM%10.2f\n", totalcharge1[customer]);
                System.out.printf("Same-Day Delivery\t\t\tRM%10.2f\n", totalcharge2[customer]);
                System.out.printf("Prepaid Box & Envelope\t\tRM%10.2f\n", totalcharge3[customer]);
                System.out.printf("Pos Ekspres\t\t\t\t\tRM%10.2f\n", totalcharge4[customer]);
                line = 1;
                while (line <= 60) {
                    System.out.printf("%c", 45);
                    line++;
                }
                System.out.printf("\nTotal \t\t\t\t\t\tRM%10.2f\n\n", grandtotal);

            }



            CustomerPayment customerPayment=new CustomerPayment();
            customerPayment.showContent();

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


}
