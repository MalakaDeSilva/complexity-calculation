package Model;

public class Users {

    private static final String userprefix = "U100";
    private static final String techprefix = "T100";
    private static int uiditer = 1;
    private static int tiditer = 1;
    protected String uid;
    protected String firstName;
    protected String lastName;
    protected String password;
    protected String email;
    protected String gender;
    protected String hometown;
    protected String type;

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void generateUid() {
        this.uid = Users.userprefix + Users.uiditer;
        Users.uiditer++;
    }

    public void generateTechID() {
        this.uid = Users.techprefix + Users.tiditer;
        Users.tiditer++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Users(String uid, String firstName, String lastName, String password, String email, String gender, String hometown, String type) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.hometown = hometown;
        this.type = type;
    }

}
