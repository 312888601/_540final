package UI;

import java.util.Scanner;

public class Mainmenu{

    //print out main menu
    public static void print(){
        System.out.println(
             "\n" +
                     " _    _       _  ________ _   _______ \n" +
                     "| |  | |     | |/ _| ___ \\ | | | ___ \\\n" +
                     "| |  | | ___ | | |_| |_/ / | | | |_/ /\n" +
                     "| |/\\| |/ _ \\| |  _|  __/| | | | ___ \\\n" +
                     "\\  /\\  / (_) | | | | |   | |_| | |_/ /\n" +
                     " \\/  \\/ \\___/|_|_| \\_|    \\___/\\____/ \n"
        );
        System.out.println("Please select your role.");
        System.out.println("1. Admin");
        System.out.println("2. Publisher");
        System.out.println("3. Editor");
        System.out.println("4. Distributor");
        System.out.println("5. Report");
        System.out.println("6. Exit");

        Scanner scanner=new Scanner(System.in);
        String a=scanner.nextLine();
        switch (a){
            case "1": Adminmenu.print();
            break;

            case "2": Publishermenu.print();
            break;

            case "3": Editormenu.print();
            break;

            case "4": Distributormenu.print();

            case "5": Reportmenu.print();
            case "6": {
                break;
            }
        }

    }
}
