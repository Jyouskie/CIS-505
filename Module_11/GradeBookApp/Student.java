package Module_11.GradeBookApp;

public class Student {

    private String firstName;
    private String lastName;
    private String course;
    private String grade;

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(String firstName, String lastName, String course, String grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.grade = grade;
    }

    // Getters and setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    // For CSV file: firstName,lastName,course,grade
    public String toCsv() {
        return String.format("%s,%s,%s,%s",
                firstName, lastName, course, grade);
    }

    // For showing in the UI results box
    @Override
    public String toString() {
        return String.format("%s %s - %s - %s",
                firstName, lastName, course, grade);
    }
}
