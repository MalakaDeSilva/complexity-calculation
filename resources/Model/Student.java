package Model;

public class Student extends Users {

    private String stdid;
    private String[] subjects;

    public Student(String stdid, String[] subjects, String uid, String firstName, String lastName, String password, String email, String gender, String hometown, String type) {
        super(uid, firstName, lastName, password, email, gender, hometown, type);
        this.stdid = stdid;
        this.subjects = subjects;
    }

    public String getStdid() {
        return stdid;
    }

    public void setStdid(String stdid) {
        this.stdid = stdid;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }
}
