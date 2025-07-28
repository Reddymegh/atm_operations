package main_atm;
import java.util.Scanner;
public class ATMsimulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AtmOperationImp imp = new AtmOperationImp();

        int atmNumber = 123;
        int atmPin = 123;

        System.out.println("WELCOME TO ATM MACHINE");
        System.out.print("ENTER THE ATM NUMBER: ");
        int enteredAtmNumber = scan.nextInt();
        System.out.print("ENTER THE ATM PIN: ");
        int enteredAtmPin = scan.nextInt();

        if (atmNumber == enteredAtmNumber && atmPin == enteredAtmPin) {
            System.out.println("\n✅ Login Successful!");
            imp.viewBalance();
            imp.viewMiniStatement();

            while (true) {
                System.out.println(
                    "\n===== ATM MENU =====\n" +
                    "1. View Available Balance\n" +
                    "2. Withdraw Amount\n" +
                    "3. Deposit Amount\n" +
                    "4. Mini Statement\n" +
                    "5. Exit"
                );
                System.out.print("Enter your choice: ");
                int choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        imp.viewBalance();
                        break;
                    case 2:
                        System.out.print("Enter the amount to withdraw: ");
                        double withdrawAmt = scan.nextDouble();
                        imp.withdrawAmount(withdrawAmt);
                        break;
                    case 3:
                        System.out.print("Enter the amount to deposit: ");
                        double depositAmt = scan.nextDouble();
                        imp.depositAmount(depositAmt);
                        break;
                    case 4:
                        imp.viewMiniStatement();
                        break;
                    case 5:
                        System.out.println("Collect your ATM card\nThank you for using our services!");
                        scan.close(); // good practice
                        return;
                    default:
                        System.out.println("❌ Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("❌ Incorrect ATM number or PIN.");
        }

        scan.close();
    }
}
