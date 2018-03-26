package institute.management;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author Srinivas
 */
public class Student 
{
    public int Student_Id;
    public String Student_Name;
    public int Student_Age;
    public String Student_Sex;
    public String Student_Address;
    public BigInteger  Student_Mobile;
    
    
    //Reading the input value
    Scanner value = new Scanner(System.in);
    
    //Creating a Object 
   public static InstituteManagement Obj_ims = new InstituteManagement();
    
    
    public  void AddStudent()
    {
        System.out.println("Adding a Student is Processing...");
        System.out.print("Enter A Student Id:");
        Student_Id = value.nextInt();
        String str = "SELECT idstudent from student WHERE idstudent="+Student_Id;
        int sid = DBManager.CheckidQuery(str);
        if(sid!=0)
        {
            System.out.println("The Given StudentID is already in the Database");
                
            System.out.println("Type any Character and Press Enter key....");
            value = new Scanner(System.in);
            char c = value.next().charAt(0);
            Obj_ims.StudentMenu();
        }
        else
        {
            try
            {
                //Getting the Values from Console
                System.out.print("Enter A Student Name:");
                Student_Name = value.next();
                System.out.print("Enter A Student Age:");
                Student_Age = value.nextInt();
                System.out.print("Enter A Student Sex:");
                Student_Sex = value.next();
                System.out.print("Enter A Student Address:");
                Student_Address = value.next();
                System.out.print("Enter A Student Mobile:");
                Student_Mobile = value.nextBigInteger();

                //Inserting the Values
                
                str = "INSERT INTO student (idstudent,name,age,sex,address,mobile) value('"+Student_Id+"','"+Student_Name+"','"+Student_Age+"','"+Student_Sex+"','"+Student_Address+"','"+Student_Mobile+"')";
                System.out.println("The Query is"+str);
                System.out.println("Values are Inserted");
                DBManager.ExequteQuery(str);
                 
            }
            catch(Exception exp)
            {
                exp.printStackTrace();
            }
        }
       
       
        
    }
    public  void DeleteStudent()
    {
        //System.out.println("Deleting a Student is Processing...");
        System.out.println("To Delete a Student Provide the StudentID:");
        System.out.print("Enter a Student ID:");
        Student_Id = value.nextInt();
        String str = "SELECT idstudent from student WHERE idstudent="+Student_Id;
        int sid = DBManager.CheckidQuery(str);
        if(sid==0)
        {
            System.out.println("The Given StudentID is Not Available  in the Student Table");
                
            System.out.println("Type any Character and Press Enter key....");
            value = new Scanner(System.in);
            char c = value.next().charAt(0);
            Obj_ims.StudentMenu();
        } 
        try
        {
            str = "DELETE FROM student WHERE idstudent="+Student_Id;
            System.out.println("The Query is "+str);
            DBManager.ExequteQuery(str);
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        /*
        str = "DELETE FROM student WHERE idstudent="+Student_Id;
        System.out.println("The Query is "+str);
        DBManager.ExequteQuery(str);
        */
    }
    public  void DisplayStudents()
    {
        try
        {
           // System.out.println("Displaying a Student is Processing...");
            //String str = "SELECT idstudent,name,age,sex,address,mobile FROM student";
            String str = "SELECT * FROM STUDENT";
            System.out.println("The Query is "+str);
            ResultSet rs = DBManager.StudentsDisplayQuery(str);

            while(rs.next())
            {
                //Getting the Values from the Database
               int S_Id = rs.getInt("idstudent");
               String S_Name = rs.getString("name");
               int S_Age = rs.getInt("age");
               String S_Sex = rs.getString("sex");
               String S_Address = rs.getString("address");
               BigDecimal S_Mobile = rs.getBigDecimal("mobile");

                //Displaying the values
               System.out.print(S_Id + "\t" + S_Name + "\t" + S_Age + "\t" + S_Sex + "\t" + S_Address + "\t" + S_Mobile);

               System.out.println();            
            }
            rs.close();
          System.out.println("Type any Character and Press Enter key....");
          Scanner value = new Scanner(System.in);
          char c = value.next().charAt(0);
          Obj_ims.StudentMenu();
        }
        catch(Exception exp)
         {
             exp.printStackTrace();
         }
            
    }
    public void UpdateStudent()
    {
         
        System.out.println("Updating a Student is Processing...");
        System.out.println("To Update a Student Details Provide the StudentID");
        System.out.print("Enter A Student Id:");
        Student_Id = value.nextInt();
        String str = "SELECT idstudent from student WHERE idstudent="+Student_Id;
        int sid = DBManager.CheckidQuery(str);
        if(sid==0)
        {
            System.out.println("The Given StudentID is Not Available in the Student Table");
                
            System.out.println("Type any Character and Press Enter key....");
            value = new Scanner(System.in);
            char c = value.next().charAt(0);
            Obj_ims.StudentMenu();
        }
        else
        {
            try
            {
                //Getting the Values from Console
                System.out.print("Enter A Student Name:");
                Student_Name = value.next();
                System.out.print("Enter A Student Age:");
                Student_Age = value.nextInt();
                System.out.print("Enter A Student Sex:");
                Student_Sex = value.next();
                System.out.print("Enter A Student Address:");
                Student_Address = value.next();
                System.out.print("Enter A Student Mobile:");
                Student_Mobile = value.nextBigInteger();

                //Updating  the Values
                
                str = "UPDATE student "+"SET idstudent = '"+Student_Id+"',name = '"+Student_Name+"',age = '"+Student_Age+"',sex = '"+Student_Sex+"',address = '"+Student_Address+"',mobile = '"+Student_Mobile+"' WHERE idstudent ='"+Student_Id+"'";
                System.out.println("The Query is"+str);
                System.out.println("Values are Updated");
                DBManager.ExequteQuery(str);
                 
            }
            catch(Exception exp)
            {
                exp.printStackTrace();
            }
        }
       
       
      
         
    }
}
