import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student {
    private int studentId;
    private String name;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}

class Course {
    private int courseId;
    private String courseName;

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }
}

class Enrollment {
    private int studentId;
    private int courseId;
    private double grade;

    public Enrollment(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = -1; // Default grade indicating not graded yet
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

public class students {
    private List<Student> students;
    private List<Course> courses;
    private List<Enrollment> enrollments;

    public students() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        enrollments = new ArrayList<>();
    }

    public void addStudent(int studentId, String name) {
        students.add(new Student(studentId, name));
    }

    public void addCourse(int courseId, String courseName) {
        courses.add(new Course(courseId, courseName));
    }

    public void enrollStudent(int studentId, int courseId) {
        enrollments.add(new Enrollment(studentId, courseId));
    }

    public void assignGrade(int studentId, int courseId, double grade) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId && enrollment.getCourseId() == courseId) {
                enrollment.setGrade(grade);
                break;
            }
        }
    }

    public void printStudentTranscript(int studentId) {
        System.out.println("Transcript for Student ID: " + studentId);
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId) {
                Course course = getCourseById(enrollment.getCourseId());
                System.out.println("Course: " + course.getCourseName() + ", Grade: " + enrollment.getGrade());
            }
        }
    }

    private Course getCourseById(int courseId) {
        for (Course course : courses) {
            if (course.getCourseId() == courseId) {
                return course;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        students  system = new students();

        system.addStudent(1, "John");
        system.addStudent(2, "Alice");

        system.addCourse(101, "Mathematics");
        system.addCourse(102, "History");

        system.enrollStudent(1, 101);
        system.enrollStudent(1, 102);
        system.enrollStudent(2, 101);

        system.assignGrade(1, 101, 85);
        system.assignGrade(1, 102, 92);
        system.assignGrade(2, 101, 78);

        system.printStudentTranscript(1);
    }
}
