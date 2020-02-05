import java.io.Serializable;

public class Volunteer implements Serializable {
    private static final long serialVersionUID = 1L;
    String firstName;
    String lastName;
    String phone;
    String eMail;
    String worship;
    String welcome;
    String production;
    String communityGroups;
    String childrenMinistry;
    String studentMinistry;
    String moreInfo;

    public Volunteer(String firstName, String lastName, String phone, String eMail, String worship, String welcome,
            String production, String communityGroups, String childrenMinistry, String studentMinistry,
            String moreInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.eMail = eMail;
        this.worship = worship;
        this.welcome = welcome;
        this.production = production;
        this.communityGroups = communityGroups;
        this.childrenMinistry = childrenMinistry;
        this.studentMinistry = studentMinistry;
        this.moreInfo = moreInfo;
    }
}