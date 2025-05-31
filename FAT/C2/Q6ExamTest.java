package C2;

class Exam {
    private int duration; // in minutes
    private String status; // "Scheduled" or "Not Scheduled"

    public Exam(int duration, String status) {
        this.duration = duration;
        this.status = status;
    }

    class Timer {
        public void showTimer() {
            System.out.println("Exam Duration: " + duration + " minutes");
            System.out.println("Exam Status: " + status);
        }
    }
}

class StudentExam extends Exam {
    private String studentName;
    private String regno;

    public StudentExam(String studentName, String regno, int duration, String status) {
        super(duration, status);
        this.studentName = studentName;
        this.regno = regno;
    }

    public void displayDetails() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Registration No: " + regno);
        Timer timer = new Timer();
        timer.showTimer();
        System.out.println("--------------------------");
    }
}

public class Q6ExamTest {
    public static void main(String[] args) {
        StudentExam[] students = new StudentExam[5];

        students[0] = new StudentExam("Arjun", "22CS001", 90, "Scheduled");
        students[1] = new StudentExam("Divya", "22CS002", 120, "Not Scheduled");
        students[2] = new StudentExam("Ravi", "22CS003", 60, "Scheduled");
        students[3] = new StudentExam("Meena", "22CS004", 45, "Scheduled");
        students[4] = new StudentExam("Karan", "22CS005", 30, "Not Scheduled");

        System.out.println("Exam Details for Students:\n");

        for (StudentExam student : students) {
            student.displayDetails();
        }
    }
}
