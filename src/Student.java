public class Student {
    private final int id;
    private String name;
    private String department;
    private int age;

    public Student(int i,String n,String d,int a){
        age=a;
        name=n;
        department=d;
        id=i;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getAge() {
        return age;
    }
    public String getName(){
        return  name;
    }

    public String getDepartment() {
        return department;
    }

    public  int  getId() {
        return id;
    }
    public String display() {
        return "ID: "+id + ", Name: "+name+ ", Age: "+age+", Department: "+department;
    }
}
