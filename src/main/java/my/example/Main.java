package my.example;

import java.util.Scanner;

public class Main
{

    public static void main(String[]args){

        Main main=new Main();
        main.choice();
    }

    public void choice(){

       NextDayDelivery nextDayDelivery= new NextDayDelivery();
       SameDayDelivery sameDayDelivery= new SameDayDelivery();
       PrepaidBoxEnvelop prepaidBoxEnvelop= new PrepaidBoxEnvelop();
       PosEkspres posEkspres= new PosEkspres();
       Payment payment= new Payment();



        Scanner input=new Scanner(System.in);
        int choice;

        /*Display Main Menu*/
        System.out.printf("Main Menu\n");

        Main main=new Main();
        main.line();

        /*Display Main Menu*/
        System.out.printf("\n1. Next-Day Delivery\n");
        System.out.printf("2. Same-Day Delivery\n");
        System.out.printf("3. Prepaid Box & Envelope\n");
        System.out.printf("4. Pos Ekspres\n");
        System.out.printf("5. Receipt\n");
        System.out.printf("6. Exit\n\n");

        System.out.printf("Please select your choice\t:");
        choice=input.nextInt();
        while(choice>6){
            System.out.printf("Invalid Input!!! Please key in correct data!!!\n");
            System.out.printf("Please select your choice:");
            choice=input.nextInt();
        }while(choice<=6){
            break;
        }
        /*Selection*/
        if(choice==1){
            nextDayDelivery.amount1();

        }if (choice==2){
            sameDayDelivery.amount2();

        }if(choice==3){
            prepaidBoxEnvelop.amount3();

        }if(choice==4){
            posEkspres.amount4();

        }if(choice==5){
            payment.amount5();

        }if(choice==6){
            System.out.printf("Thank You for Using Our System.\n");
        }

    }

    //Encapsulation
    private void line() {
        int line = 1;
        while (line <= 100) {
            System.out.printf("%c", 45);
            line++;
        }
    }

}