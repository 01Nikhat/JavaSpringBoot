import java.util.Scanner;

public class InputExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Your phone number...");
        int number = sc.nextInt();
        sc.nextLine();  // consume the leftover newline

        System.out.println("Enter Your Name :");
        String name  = sc.nextLine();

        System.out.println("Hello "+ name + ", Your phone number is :"+ number);
    }
}
