import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

class User {
    private String username;
    private String password;
    private String profile;

    public User(String username, String password, String profile) {
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Question {
    private String question;
    private Map<String, String> options;
    private String correctOption;

    public Question(String question, Map<String, String> options, String correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class OnlineExamSystem {
    private static User currentUser;
    private static Timer timer;

    public static void main(String[] args) {
        Map<String, User> users = new HashMap<>();
        users.put("user1", new User("user1", "password1", "Student1"));
        users.put("user2", new User("user2", "password2", "Student2"));
        Map<Integer, Question> questions = new HashMap<>();
        Map<String, String> options = new HashMap<>();
        options.put("A", "Option A");
        options.put("B", "Option B");
        options.put("C", "Option C");
        options.put("D", "Option D");
        questions.put(1, new Question("What is 1 + 1?", options, "B"));

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("1. Login");
            System.out.println("2. Update Profile and Password");
            System.out.println("3. Start Exam");
            System.out.println("4. Logout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login(users);
                    break;
                case 2:
                    updateProfile();
                    break;
                case 3:
                    startExam(questions);
                    break;
                case 4:
                    logout();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void login(Map<String, User> users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            currentUser = users.get(username);
            System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
    private static void updateProfile() {
        System.out.println("Updating profile...");
    }
    private static void startExam(Map<Integer, Question> questions) {
        System.out.println("Starting exam...");
    }
    private static void logout() {
        currentUser = null;
        System.out.println("Logged out successfully.");
    }
}
