import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StudentManager manager=new StudentManager();
        manager.loadFromFile();
        while(true){
            System.out.println("*************** Student Management System ***************");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. List All Students");
            System.out.println("6. Save Data to File");
            System.out.println("7. Exit");
            int choice=scanner.nextByte();
            if(choice==7)
                break;
            else{
            switch (choice){
                case 1:{
                    System.out.print("ID:");
                    int id=scanner.nextByte();
                    scanner.nextLine();
                    System.out.print("Name:");
                    String name=scanner.nextLine();
                    System.out.print("Age:");
                    int age=scanner.nextByte();
                    scanner.nextLine();
                    System.out.print("Department:");
                    String department=scanner.nextLine();
                    manager.addStudent(new Student(id,name,department,age));
                    break;
                }
                case 2:{
                    System.out.println("Enter ID to update");
                    int id= scanner.nextByte();
                    System.out.println("What do you want to update");
                    System.out.println("1: Name , 2: Age , 3: Department , 4: All Data");
                    int dec=scanner.nextByte();
                    scanner.nextLine();
                    switch (dec){
                        case 1:{
                            System.out.print("Name:");
                            String name=scanner.nextLine();
                            manager.updateStudentName(id,name);
                            break;
                        }
                        case 2:{
                            System.out.print("Age:");
                            int age=scanner.nextByte();
                            scanner.nextLine();
                            manager.updateStudentAge(id,age);
                            break;
                        }
                        case 3:{
                            System.out.print("Department:");
                            String department=scanner.nextLine();
                            manager.updateStudentDepartment(id,department);
                            break;
                        }
                        case 4:{
                            System.out.print("Name:");
                            String newName=scanner.nextLine();
                            System.out.print("Age:");
                            int newAge=scanner.nextByte();
                            scanner.nextLine();
                            System.out.print("Department:");
                            String newDepartment=scanner.nextLine();
                            manager.updateStudent(id,newName,newDepartment,newAge);
                            break;
                        }
                    }
                }
                case 3:{
                    System.out.println("Enter ID to delete");
                    int id= scanner.nextByte();
                    scanner.nextLine();
                    if(manager.deleteStudent(id)){
                        System.out.println("Deleted Successfully");
                    }
                    else
                        System.out.println("Student not found");
                    break;
                }
                case 4:{
                    System.out.println("Enter ID to search for");
                    int id= scanner.nextByte();
                    scanner.nextLine();
                    Student found= manager.findStudentById(id);
                    if(found==null)
                        System.out.println("Student not found");
                    else
                        System.out.println(found.display());
                    break;
                }
                case 5: {
                    manager.printAllStudents();
                    break;
                }
                case 6: {
                    manager.saveToFile();
                    break;
                }

            }


        }}


    }
}