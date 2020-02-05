import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ChurchEmployee {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Volunteer> applications = load();
        displayVolunteers(applications);
        tryToCall(applications);
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

    private static void displayVolunteers(ArrayList<Volunteer> applications) {
        System.out.println("-- You running about " + applications.size() + " application(s) --");
        System.out
                .println("------------------------------------------------------------------------------------------");
        int i = 0;
        ArrayList<String> interests = new ArrayList<String>();
        for (Volunteer Volunteer : applications) {
            if (Volunteer.worship.equals("yes")) {
                interests.add("Worship");
            }
            if (Volunteer.welcome.equals("yes")) {
                interests.add("Welcome");
            }
            if (Volunteer.production.equals("yes")) {
                interests.add("Production");
            }
            if (Volunteer.communityGroups.equals("yes")) {
                interests.add("Community Groups");
            }
            if (Volunteer.childrenMinistry.equals("yes")) {
                interests.add("Children's Ministry");
            }
            if (Volunteer.studentMinistry.equals("yes")) {
                interests.add("Student's Ministry");
            }
            if (Volunteer.moreInfo.equals("yes")) {
                interests.add("More Info");
            }
            System.out.println("Application: " + i);
            System.out.println("* " + Volunteer.firstName + " " + Volunteer.lastName + " - " + "[" + Volunteer.phone
                    + "]" + " - " + "[" + Volunteer.eMail + "]");
            System.out.println("- " + "Interests :" + interests);
            System.out.println(
                    "------------------------------------------------------------------------------------------");
            i++;
        }
    }

    private static void tryToCall(ArrayList<Volunteer> applications) {

        while (true) {
            System.out.print("Would you like to call one of the applicants (Yes/No): ");
            String callOrNo = in.nextLine().toLowerCase();
            if (callOrNo.equals("yes")) {
                System.out.print("Which applicant number would you like to call: ");
                Integer applicantID = Integer.parseInt(in.nextLine());
                System.out.println("Calling " + applications.get(applicantID).firstName + " "
                        + applications.get(applicantID).lastName);
                System.out.print(
                        "I'm sorry, but the person you are calling has a voice mailbox that has not been setup yet. Goodbye.");
                break;
            } else {
                break;
            }
        }
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
