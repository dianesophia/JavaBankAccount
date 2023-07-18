import java.util.*;

public class BankAccount {
    static Scanner sc = new Scanner(System.in);
    static HashMap<String, String> map = new HashMap<>();
    public static String firstName;
    public static String lastName;
    public static String homeAddress;
    public static String email;
    public static String username;
    public static String password;

    public static void main(String[] args) {
        int userInput = 0;
        boolean exitProgram = false;

        do {
            System.out.println("================================");
            System.out.println("Bank System");
            System.out.println("MENU");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("================================");
            System.out.print("Enter Option: ");
            userInput = sc.nextInt();

            switch (userInput) {
                case 1:
                    Register register = new Register();
                    register.registerAccount();
                    break;
                case 2:
                    Login login = new Login();
                    login.loginAccount();
                    exitProgram = true;
                    break;
                case 3:
                    exitProgram = true;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (!exitProgram && userInput != 2);
    }

    static class Register {
        public void registerAccount() {
            System.out.println("\n\n=====================================================");
            System.out.print("Firstname: ");
            firstName = sc.next();
            System.out.print("Lastname: ");
            lastName = sc.next();
            System.out.print("Home address: ");
            homeAddress = sc.next();
            System.out.print("Email: ");
            email = sc.next();
            System.out.print("Username: ");
            username = sc.next();
            System.out.print("Password: ");
            password = sc.next();
            System.out.println("\nCongratulations, you have successfully registered.\n");
            System.out.println("=====================================================");

            map.put(username, password);

            System.out.print("Would you like to make your first deposit? YES or NO: ");
            String ans = sc.next();

            if (ans.equalsIgnoreCase("YES")) {
                if (deposit() >= 250) {
                    openMenu(firstName);
                } else {
                    System.out.println("Sorry, you cannot open your account until you deposit at least 250.");
                }
            } else if (ans.equalsIgnoreCase("NO")) {
                System.out.println("Sorry, you cannot open your account until you deposit at least 250.");
            }

            System.out.print("Enter 0 to go back to the main menu or 1 to exit the program: ");
            int option = sc.nextInt();
            if (option == 1) {
                System.out.println("Exiting the program...");
                System.exit(0);
            }
        }

        private double deposit() {
            System.out.print("Enter deposit amount: ");
            return sc.nextDouble();
        }

        private void openMenu(String firstname) {
            System.out.println("\n================================");
            System.out.println("Welcome, " + firstname + "! Your account is now open.");
            System.out.println("================================\n");
            // Add logic for account menu options
        }
    }

    static class Login {
        public void loginAccount() {
            System.out.println("\n================================");
            System.out.print("Enter your Username: ");
            String username = sc.next();
            System.out.print("Enter your password: ");
            String password = sc.next();
            System.out.println("================================\n");

            if (map.containsKey(username) && map.get(username).equals(password)) {
                System.out.println("\nYou have successfully logged in.");
                System.out.println("Welcome " + firstName + "!");
            } else {
                System.out.println("Invalid username or password.");
                System.exit(0);
            }

            int userInput = 0;
            boolean exitProgram = false;

            do {
                System.out.println("MENU: ");
                System.out.println("1. View Account");
                System.out.println("2. View Balance");
                System.out.println("3. View History");
                System.out.println("4. Withdraw");
                System.out.println("5. Deposit");
                System.out.println("6. Logout");
                System.out.println("================================");
                System.out.print("Enter Option: ");
                userInput = sc.nextInt();

                switch (userInput) {
                    case 1:
                        // Add logic for View Account
                        break;
                    case 2:
                        // Add logic for View Balance
                        break;
                    case 3:
                        // Add logic for View History
                        break;
                    case 4:
                        // Add logic for Withdraw
                        break;
                    case 5:
                        // Add logic for Deposit
                        break;
                    case 6:
                        exitProgram = true;
                        System.out.println("Logging out...");
                        break;
                    default:
                        System.out.println("Invalid option!");
                        break;
                }
            } while (!exitProgram);
        }
    }
}
