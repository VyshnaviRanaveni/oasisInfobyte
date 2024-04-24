import java.util.Scanner;
import java.util.HashMap;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class ReservationSystem {
    private HashMap<String, String> reservations;

    public ReservationSystem() {
        reservations = new HashMap<>();
    }

    public void makeReservation(String username, String reservationDetails) {
        reservations.put(username, reservationDetails);
        System.out.println("Reservation made successfully for " + username + ": " + reservationDetails);
    }

    public void cancelReservation(String username) {
        if (reservations.containsKey(username)) {
            reservations.remove(username);
            System.out.println("Reservation cancelled successfully for " + username);
        } else {
            System.out.println("No reservation found for " + username);
        }
    }
}

public class OnlineReservationSystem {
    private static HashMap<String, User> users = new HashMap<>();
    private static ReservationSystem reservationSystem = new ReservationSystem();

    public static void main(String[] args) {
        // Populate users (for demo purposes)
        users.put("user1", new User("user1", "password1"));
        users.put("user2", new User("user2", "password2"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Make Reservation");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    cancelReservation(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            System.out.println("Login successful");
        } else {
            System.out.println("Invalid username or password");
        }
    }

    private static void makeReservation(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        if (!users.containsKey(username)) {
            System.out.println("User not found");
            return;
        }
        System.out.print("Enter reservation details: ");
        String reservationDetails = scanner.nextLine();
        reservationSystem.makeReservation(username, reservationDetails);
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        reservationSystem.cancelReservation(username);
    }
}