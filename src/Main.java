import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter max Subscribers: ");
        int size = scanner.nextInt();
        SpotifyPage spotify = new SpotifyPage("Sweetener", size);

        while(true) {
            int type = 0;
            int sid = 0;
            System.out.println("1. Subscribe?/2.Search Id?:");
            int choose = scanner.nextInt();
            if(choose == 1){
                System.out.println("Choose Subscription type: ");
                System.out.println("1.Basic\n2.Premium");
                type = scanner.nextInt();
            } else if(choose == 2){
                System.out.println("Enter ID to search: ");
                sid = scanner.nextInt();
                spotify.searchByID(sid);
            }

            switch(type){
                case 1:
                    System.out.println("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Monthly Fee (100/200/300): ");
                    double fee = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Date joined(e.g Jan152019): ");
                    String date = scanner.nextLine();
                    spotify.addSubscriber(new BasicSubscriber(id, name, fee, date));
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("ID: ");
                    int pid = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Name: ");
                    String pname = scanner.nextLine();
                    System.out.println("Monthly Fee (500/700/900): ");
                    double pfee = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Premium Year: ");
                    int year = scanner.nextInt();
                    spotify.addSubscriber(new PremiumSubscriber(pid, pname, pfee, year));
                    break;
                default:
                    break;
            }

            System.out.println("Continue?(Y/N): ");
            char option = scanner.next().charAt(0);
            if (option == 'N') {
                break;
            }
        }
        scanner.nextLine();
        System.out.println("Check total monthly income?(Y/N): ");
        char yn = scanner.next().charAt(0);
        if(yn == 'Y'){
            double money = spotify.totalMonthlyIncome();
            System.out.println("Total monthly income: " + money);
        }
        else{
            System.out.println("Completed!");
        }
        spotify.display();

    }
}