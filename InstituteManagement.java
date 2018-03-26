package institute.management;
import java.util.Scanner;

/**
 *
 * @author Srinivas
 */
public class InstituteManagement 
{
    //Creating a Object for Course Class
    public static Course Obj_Course = new Course();
   
    //Creating a Object for DatabaseManage Class
    public static DBManager Obj_DBMang = new DBManager();
    
    //Creating a Object for Student Class
    public static Student Obj_Student = new Student();
    
    
    public static void main(String[] args)
    
    {
        System.out.println("Welcome to Institute Management System");
        Obj_DBMang.ConnectDatabase();
        MainMenu();
                               
    }
    public static void MainMenu()
    {
        System.out.println("Institue Managment System");
        System.out.println("1.Manage The Course Details ");
        System.out.println("2.Manage The Studnet Details");
        System.out.println("3.Exit");
        
        Scanner  value = new Scanner(System.in);
        System.out.print("Enter  your choice:");
        int Choice= value.nextInt();
        switch(Choice)
          {
              case 1:
                    System.out.println("Managing The Course is called");
                    CourseMenu();
                    break;
              case 2:
                    System.out.println("Managing The Studnet  is called");
                    StudentMenu();
                    break;
              default:
                    System.out.println("Exist");
                    System.exit(0);
            
           }
       
    }
    public static void CourseMenu()
    {
        System.out.println("Institute Managment System");
        System.out.println("1.Add a Course");
        System.out.println("2.Delete a Course");
        System.out.println("3.Display the Courses Details");
        System.out.println("4.Update the Courses");
        System.out.println("5.Goto MainMenu");
        System.out.println("6.Exit");
        Scanner  value = new Scanner(System.in);
        System.out.print("Enter  your choice:");
        int Choice= value.nextInt();
        switch(Choice)
          {
              case 1:
                    System.out.println("Adding a Course function is called");
                    Obj_Course.AddCourse();
                    break;
              case 2:
                    System.out.println("Deleting a Course function is called");
                    Obj_Course.DeleteCourse();
                    break;
              case 3:
                    System.out.println("Displaying a Courses function is called");
                    Obj_Course.DisplayCourses();
                    break;
              case 4:
                    System.out.println("Updating a Course function is called");
                    Obj_Course.UpdateCourse();
                    break;
              case 5:
                    MainMenu();
                    break;
              default:
                    System.out.println("Exist");
                    System.exit(0);
             
          }

    }
    
    public static void StudentMenu()
    {
        System.out.println("Student Managment System");
        System.out.println("1.Add a Student");
        System.out.println("2.Delete a Student");
        System.out.println("3.Dispaly the Student Details");
        System.out.println("4.Update the Student");
        System.out.println("5.Goto MainMenu");
        System.out.println("6.Exit");
        Scanner  value = new Scanner(System.in);
        System.out.print("Enter  your choice:");
        int Choice= value.nextInt();
        switch(Choice)
          {
              case 1:
                    System.out.println("Adding a Student function is called");
                    Obj_Student.AddStudent();
                    break;
              case 2:
                    System.out.println("Deleting a Student function is called");
                    Obj_Student.DeleteStudent();
                    break;
              case 3:
                    System.out.println("Displaying a Student is called");
                    Obj_Student.DisplayStudents();
                    break;
              case 4:
                    System.out.println("Updating a Student function is called");
                    Obj_Student.UpdateStudent();
                    break;
              case 5:
                    MainMenu();
                    break;
              default:
                    System.out.println("Exist");
                    System.exit(0);
             
          }

    }
}
