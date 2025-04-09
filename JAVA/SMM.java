import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
//제출본

class elements{
    String name;
    int birth_year;
    boolean sex;

    public elements(String name, int birth_year, boolean sex){
        this.name = name;
        this.birth_year = birth_year;
        this.sex = sex;
    }

    public void displayInfo() {
        System.out.println(name + ", " + birth_year + ", " + sex);
    }
}


class Staff_element extends elements{
    int year_join;
    int salary;
    
    public Staff_element(String name, int birth_year, boolean sex, int year_join, int salary){
        super(name, birth_year, sex);
        this.year_join = year_join;
        this.salary = salary;
    }
}

class Student_element extends elements{
    int year_admission;
    double grade;

    public Student_element(String name, int birth_year, boolean sex, int year_admission, double grade){
        super(name, birth_year, sex);
        this.year_admission = year_admission;
        this.grade = grade;
    }
}

public class SMM{
    static ArrayList<Staff_element> staffList = new ArrayList<>();
    static ArrayList<Student_element> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Staff");
            System.out.println("2. Add Student");
            System.out.println("3. Remove Staff");
            System.out.println("4. Remove Student");
            System.out.println("5. List All Staff");
            System.out.println("6. List All Students");
            System.out.println("7. Export all members to CSV");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStaff();
                case 2 -> addStudent();
                case 3 -> removeStaff();
                case 4 -> removeStudent();
                case 5 -> listStaff();
                case 6 -> listStudents();
                case 7 -> exportAllMembersToCSV();
                case 0 -> {
                    System.out.println("Program exited.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void addStaff() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Birth Year: ");
        int birthYear = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Sex (M = true/F = false): ");
        String sex = scanner.nextLine();
        System.out.print("Year of Joining: ");
        int year = scanner.nextInt();
        System.out.print("Salary: ");
        int salary = scanner.nextInt();
        scanner.nextLine();

        boolean boolsex = Change_sex(sex);

        staffList.add(new Staff_element(name, birthYear, boolsex, year, salary));
        System.out.println("Staff added.");
    }

    static void addStudent() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Birth Year: ");
        int birthYear = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Sex (M = true/F = false): ");
        String sex = scanner.nextLine();
        System.out.print("Year of Admission: ");
        int year = scanner.nextInt();
        System.out.print("Grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine();

        boolean boolsex = Change_sex(sex);

        studentList.add(new Student_element(name, birthYear, boolsex, year, grade));
        System.out.println("Student added.");
    }

    static void removeStaff() {
        System.out.print("Enter name to remove: ");
        String name = scanner.nextLine();
        staffList.removeIf(s -> s.name.equals(name));
        System.out.println("Staff removed if name matched.");
    }

    static void removeStudent() {
        System.out.print("Enter name to remove: ");
        String name = scanner.nextLine();
        studentList.removeIf(s -> s.name.equals(name));
        System.out.println("Student removed if name matched.");
    }

    static void listStaff() {
        if (staffList.isEmpty()) {
            System.out.println("No staff members.");
            return;
        }
        for (Staff_element s : staffList) s.displayInfo();
    }

    static void listStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student members.");
            return;
        }
        for (Student_element s : studentList) s.displayInfo();
    }
    
    static void exportAllMembersToCSV() {
        System.out.print("Enter file name (ex: members.csv): ");
        String fileName = scanner.nextLine();

        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.println("Category,Name,BirthYear,Sex,JoinOrAdmissionYear,SalaryOrGrade");

            for (Staff_element s : staffList) {
                pw.printf("Staff,%s,%d,%s,%d,%d%n",
                        s.name, s.birth_year, s.sex ? "M" : "F", s.year_join, s.salary);
            }

            for (Student_element s : studentList) {
                pw.printf("Student,%s,%d,%s,%d,%.2f%n",
                        s.name, s.birth_year, s.sex ? "M" : "F", s.year_admission, s.grade);
            }

            System.out.println("CSV file saved as: " + fileName);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static boolean Change_sex(String sex){

        sex = sex.trim().toLowerCase();

        return sex.equals("male") || sex.equals("m")|| sex.equals("true") || sex.equals("t");
        
    }
}
