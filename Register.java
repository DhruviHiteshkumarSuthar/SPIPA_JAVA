import java.util.Scanner;
import java.sql.*;
import com.mysql.jdbc.Driver;
class Register
{
    public static void reg()
    {
        try
        {
            String url="jdbc:mysql://localhost:3306/project";
            String username="root";
            String password="0000";
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st=con.createStatement();
            int empid, phone, roll, firstm, secondm, total, cid;
            String name, email, gender, cat, dis, state, course;
            System.out.println("--------------------------------------------------------------");
            System.out.println("*                      Registration Page                     *");
            System.out.println("--------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------");
            System.out.println("Personal Information:");
            System.out.println("--------------------------------------------------------------");
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter Your Employee ID: ");
            empid= sc.nextInt();
            System.out.print("Enter Your Name: ");
            name= sc.next();
            System.out.print("Enter Your Phone No.: ");
            phone= sc.nextInt();
            System.out.print("Enter Your Email: ");
            email= sc.next();
            System.out.print("Enter Your Gender(M or F): ");
            gender= sc.next();
            System.out.print("Enter Your Category(GEN/SC/ST/EWS/SEBC): ");
            cat= sc.next();
            System.out.print("Do you have any disability(Y or N): ");
            dis= sc.next();
            System.out.print("Enter Your Sate: ");
            state= sc.next();
            System.out.println("--------------------------------------------------------------");
            System.out.println("Exam Information:");
            System.out.println("--------------------------------------------------------------");
            System.out.print("Enter Your Roll No.: ");
            roll= sc.nextInt();
            System.out.print("Enter Your First Exam Marks: ");
            firstm= sc.nextInt();
            System.out.print("Enter Your Second Exam Marks: ");
            secondm= sc.nextInt();
            total= firstm+secondm;
            System.out.println("Enter Your Total Marks: "+total);
            System.out.println("--------------------------------------------------------------");
            System.out.println("Course Information:");
            System.out.println("--------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------");
            System.out.println("Course Name and short forms:");
            System.out.println("1: CCC+ Training (CCC+)");
            System.out.println("2: Leadership Skills (LS)");
            System.out.println("3: Public Governance (PG)");
            System.out.println("4: Office Administration (OA)");
            System.out.println("--------------------------------------------------------------");
            System.out.print("Enter Your preferred Course: ");
            course= sc.next();
            String inq="insert into proemp values("+empid+","+"\""+name+"\""+","+phone+","+"\""+email+"\""+","+
                    "\""+gender+"\""+","+"\""+cat+"\""+","+"\""+dis+"\""+","+"\""+state+"\""+","+roll+","+firstm+","
                    +secondm+","+total+","+"\""+course+"\""+")";
            int result=st.executeUpdate(inq);
            System.out.println("--------------------------------------------------------------");
            System.out.println("Your Registration is complete!!");
            System.out.println("--------------------------------------------------------------");
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
