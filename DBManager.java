package institute.management;
//import static institute.management.InstituteManagement.DisplayMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Srinivas
 */
public class DBManager 
{
    static Connection conn = null;
    static Statement stmt = null;
    
    //JDBC Driver name
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    ////JDBC Driver url 
    static final String DB_URL="jdbc:mysql://localhost:3306/ims";
    
    //Database login detials
    static final String USER = "root";
    static final String PASS = "root";
    
    public static InstituteManagement Obj_ims = new InstituteManagement ();
   
    public static ResultSet rs;
    
    public static void ConnectDatabase()
    {
        try
        {
            //Register the jdbc Driber
            Class.forName("com.mysql.jdbc.Driver");

            //Connect to the database
            System.out.println("Connecting to  the databse.....");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Database Connected sucessfully.....");

        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }
    public static void ExequteQuery(String str)
    {
       try
       {
            stmt = conn.createStatement();
            stmt.executeUpdate(str);
            System.out.println("Type any Character and Press Enter key....");
            Scanner value = new Scanner(System.in);
            char c = value.next().charAt(0);
            Obj_ims.MainMenu();
            

       }
        catch(Exception exp)
         {
             exp.printStackTrace();
         }
    }
    
    public static void CoursesDisplayQuery(String str)
    {
       try
       {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(str);
//          System.out.println("rs is "+rs);
             while(rs.next())
                {
                   //Getting the Values from the Database
                    
                   int C_Id =rs.getInt("idcourse");
                   String C_Name = rs.getString("name");
                   String C_Duration = rs.getString("duration");
                   int C_Fees = rs.getInt("fees");
                   
                   //Displaying the values
                   System.out.print("idcourse: "+C_Id);
                   System.out.print(", CName: "+C_Name);
                   System.out.print(", Duration: "+C_Duration);
                   System.out.print(", Fee: "+C_Fees);
                   System.out.println();
                                 
                }
                rs.close();
              System.out.println("Type any Character and Press Enter key....");
              Scanner value = new Scanner(System.in);
              char c = value.next().charAt(0);
              Obj_ims.CourseMenu();
            
       }
        catch(Exception exp)
         {
             exp.printStackTrace();
         }
     
    }
    
    
    public static int CheckidQuery(String str)
    {
        int cid=0;        try
        {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(str);
            while(rs.next())
            {
                //cid = rs.getInt("idcourse");
                cid = rs.getInt(1);
                if(cid!=0)
                return cid;
            }
            rs.close();
            
        }
        catch(Exception exp)
         {
             exp.printStackTrace();
         }
       
        return cid;
    }
    
//Student methods
    
     public static ResultSet StudentsDisplayQuery(String str)
    {
       try
       {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(str);
            return rs;
//          System.out.println("rs is "+rs);
//             while(rs.next())
//                {
//                    //Getting the Values from the Database
//                   int S_Id = rs.getInt("idstudent");
//                   String S_Name = rs.getString("name");
//                   int S_Age = rs.getInt("age");
//                   String S_Sex = rs.getString("sex");
//                   String S_Address = rs.getString("address");
//                   BigDecimal S_Mobile = rs.getBigDecimal("mobile");
//                  
//                    //Displaying the values
//                   System.out.print("SId: "+S_Id);
//                   System.out.print(", SName: "+S_Name);
//                   System.out.print(", Age: "+S_Age);
//                   System.out.print(", Sex: "+S_Sex);
//                   System.out.print(", Address: "+S_Address);
//                   System.out.print(", Mobile: "+S_Mobile);
//                   System.out.println();            
//                }
//                rs.close();
//              System.out.println("Type any Character and Press Enter key....");
//              Scanner value = new Scanner(System.in);
//              char c = value.next().charAt(0);
//              Obj_ims.StudentMenu();
            
       }
        catch(Exception exp)
         {
             exp.printStackTrace();
         }
        return null;
     
    }
}



