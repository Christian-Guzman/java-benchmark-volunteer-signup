import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Volunteer> applications = load();
        Volunteer application = start();
        applications.add(application);
        save(applications);
    }

    private static ArrayList<Volunteer> load() {
        try {
            FileInputStream fileStream = new FileInputStream("Iam1of90-Applications.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<Volunteer> applications = (ArrayList<Volunteer>) os.readObject();
            os.close();
            return applications;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<Volunteer>();
        }
    }

    private static Volunteer start() {
        System.out.print("First Name: ");
        String firstName = in.nextLine();
        System.out.print("Last Name: ");
        String lastName = in.nextLine();
        System.out.print("Phone: ");
        String phone = in.nextLine();
        System.out.print("Email: ");
        String eMail = in.nextLine();
        System.out.print(" -Are you interested in volunteering on the Worship team? (Yes/No): ");
        String worship = in.nextLine().toLowerCase();
        System.out.print(" -Are you interested in volunteering on the Welcome team? (Yes/No): ");
        String welcome = in.nextLine().toLowerCase();
        System.out.print(" -Are you interested in volunteering on the Production team? (Yes/No): ");
        String production = in.nextLine().toLowerCase();
        System.out.print(" -Are you interested in leading a Community Group? (Yes/No): ");
        String communityGroups = in.nextLine().toLowerCase();
        System.out.print(" -Are you interested in teaching in Children's Ministry? (Yes/No): ");
        String childrenMinistry = in.nextLine().toLowerCase();
        System.out.print(" -Are you interested in volunteering in Student Ministry? (Yes/No): ");
        String studentMinistry = in.nextLine().toLowerCase();
        System.out.print(" -Are you interested in hearing more information about volunteer opportunities? (Yes/No): ");
        String moreInfo = in.nextLine().toLowerCase();
        System.out.println("--Good Stuff we'll get back to you asap.");
        return new Volunteer(firstName, lastName, phone, eMail, worship, welcome, production, communityGroups,
                childrenMinistry, studentMinistry, moreInfo);
    }

    private static void save(ArrayList<Volunteer> applications) {
        try {
            FileOutputStream fileStream = new FileOutputStream("Iam1of90-Applications.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(applications);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save applications.");
        }
    }
}