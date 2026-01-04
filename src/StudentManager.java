import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class StudentManager{

    public void loadFromFile() {
        File file = new File("students.txt");
        if (!file.exists()) return; // Do nothing if file doesn't exist

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // Since you saved it using s.display(), we just print it for now
                System.out.println("Loaded record: " + line);
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
    private ArrayList<Student >students =new ArrayList<Student>();

    public boolean addStudent(Student student) {
        int id=student.getId();
        Student duplicate =findStudentById(id);
        if(duplicate==null) {
            students.add(student);
            return true;
        }
        return false;
    }

    public Student findStudentById(int id){
        for (Student s:students) {
            if(s.getId()==id)
                return s;
        }
        return null;
    }

    public boolean updateStudent(int id,String name,String department ,int age){
        Student s=findStudentById(id);
        if(s!=null){
            s.setAge(age);
            s.setDepartment(department);
            s.setName(name);
            return true;
        }
        else
            return false;
    }
    public boolean updateStudentDepartment(int id,String department){
        Student s=findStudentById(id);
        if(s!=null){
            s.setDepartment(department);
            return true;
        }
        else
            return false;
    }
    public boolean updateStudentName(int id,String name){
        Student s=findStudentById(id);
        if(s!=null){
            s.setName(name);
            return true;
        }
        else
            return false;
    }
    public boolean updateStudentAge(int id,int age){
        Student s=findStudentById(id);
        if(s!=null){
            s.setAge(age);
            return true;
        }
        else
            return false;
    }

    public boolean deleteStudent(int id){
        Student s=findStudentById(id);
        if(s!=null) {
            students.remove(s);
            return true;
        }
        return false;
    }

    public void printAllStudents(){
        if(students.isEmpty()){
            System.out.println("No students to show");
        }
        else
        {
            for (Student s:students) {
                System.out.println(s.display());
            }
        }
    }
    public void saveToFile() {
        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter("students.txt"))) {
            if (students.isEmpty()) {
                writer.println("No students in the system.");
            } else {
                for (Student s : students) {
                    writer.println(s.display()); // This saves the same text you see on screen
                }
            }
            System.out.println("Data successfully saved to students.txt!");
        } catch (java.io.IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

}
