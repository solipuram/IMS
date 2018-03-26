package institute.management;
import java.util.Scanner;

/**
 *
 * @author Srinivas
 */
public class Course 
{
    public int C_Id;
    public String C_Name;
    public String C_Duration;
    public int C_Fees;
    
    public static InstituteManagement Obj_ims = new InstituteManagement ();
        public void AddCourse()
        {
            System.out.println("Add Course function is Processing ....");
            
            System.out.println("Enter The Course Details");
            //Reading the value from the console
            Scanner  value = new Scanner(System.in);
            System.out.print("Enter  Courseid:");
            C_Id = value.nextInt();
            System.out.print("Enter  Course Name:");
            C_Name = value.next();
            System.out.print("Enter  Course Duration:");
            C_Duration = value.next();
            System.out.print("Enter  Course Fees:");
            C_Fees = value.nextInt();
            //Checking the cid duplication
            String str = "SELECT idcourse from course WHERE idcourse= "+C_Id;
            int cid = DBManager.CheckidQuery(str);
            if(cid!=0)
            {
                System.out.println("The Given CourseID is already in the Course Table");
                
                System.out.println("Type any Character and Press Enter key....");
                value = new Scanner(System.in);
                char c = value.next().charAt(0);
                Obj_ims.CourseMenu();
            }
            else
            {
                try
                {
                    System.out.println("Inserting Values into the Course table in ims db...");
                    System.out.println("Values are inserting......");
                    String sql = "INSERT INTO `course`(idcourse,name,duration,fees) VALUE ('"+C_Id+"','"+C_Name+"','"+C_Duration+"','"+C_Fees+"');";
                    System.out.println("The Insert query is:"+sql);
                    DBManager.ExequteQuery(sql);
                
                }
                catch(Exception exp)
                {
                    exp.printStackTrace();
                }
            }
          
        }
        public void DeleteCourse()
        {
            System.out.println("Delete Course function is Processing ....");
            System.out.println("For Deleting the Course Enter a Courseid");
            Scanner  value = new Scanner(System.in);
            System.out.print("Enter  Courseid:");
            C_Id = value.nextInt();
            String str = "SELECT idcourse from course WHERE idcourse= "+C_Id;
            int get_id = DBManager.CheckidQuery(str);
            if (get_id==0)
            {
                System.out.println("The Given CourseID is not in the Course Table");
                
                System.out.println("Type any Character and Press Enter key....");
                value = new Scanner(System.in);
                char c = value.next().charAt(0);
                Obj_ims.CourseMenu();
                
            }
            else
            {
                 try
                {
                    //Deleting a record 
                    System.out.println("Deleting is process....");
                    str = "DELETE FROM course " + "WHERE idcourse = '"+get_id+"'";
                    System.out.println("The Insert query is:"+str);
                    DBManager.ExequteQuery(str);
                }
                catch(Exception exp)
                {
                    exp.printStackTrace();
                }
            }
            
        }
        
        public void DisplayCourses()
        {
            try
            {
                System.out.println("Display Course function is Processing ....");
                String str = "SELECT idcourse,name,duration,fees FROM course";
                System.out.println("The Insert query is:"+str);
                    
                DBManager.CoursesDisplayQuery(str);
            }
            catch(Exception exp)
            {
                exp.printStackTrace();
            }
                              
          
        }
        public void UpdateCourse()
        {
            System.out.println("Update Course function is Processing ....");
            System.out.println("To Update  The Course Details provide the courseid");
            System.out.print("Enter a Courseid:");
            Scanner value = new Scanner(System.in);
            int CheckC_Id = value.nextInt();
           
            //Checking the Courseid Duplication
            
            String str = "SELECT idcourse from course WHERE idcourse= "+CheckC_Id;
            int getid = DBManager.CheckidQuery(str);
            if(getid==0)
            {
                System.out.println("The Given CourseID is not  available in the Course Table");
                
                System.out.println("Type any Character and Press Enter key....");
                value = new Scanner(System.in);
                char c = value.next().charAt(0);
                Obj_ims.CourseMenu();
            }
            else
            {
                try
                {
                    System.out.println("Enter new values");
                    System.out.print("Enter New Course id:");
                    C_Id = value.nextInt();
                    System.out.print("Enter New Course Name:");
                    C_Name = value.next();
                    System.out.print("Enter  New Course Duration:");
                    C_Duration = value.next();
                    System.out.print("Enter New Course Fee:");
                    C_Fees = value.nextInt();
                    str = "UPDATE course "+"SET idcourse = '"+C_Id+"',name = '"+C_Name+"',duration = '"+C_Duration+"',fees = '"+C_Fees+"' WHERE idcourse = '"+CheckC_Id+"'";
                    System.out.println("The query is :"+str);
                    DBManager.ExequteQuery(str);

                }
                catch(Exception exp)
                {
                    exp.printStackTrace();
                }
            }
          
            
                 
        }
        
        
}        
