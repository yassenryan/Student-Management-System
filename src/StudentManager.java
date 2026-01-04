import java.util.ArrayList;

public class StudentManager{

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

}
