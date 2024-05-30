import java.util.Scanner;
import java.sql.*;
import com.mysql.jdbc.Driver;

public class Approval
{
    public static void approve()
    {
        try
        {
            String url="jdbc:mysql://localhost:3306/project";
            String username="root";
            String password="0000";
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st=con.createStatement();
            String un,pwd;
            int rno;
            Scanner sc= new Scanner(System.in);
            System.out.println("--------------------------------------------------------------");
            System.out.println("*                       Approval Page                        *");
            System.out.println("--------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------");
            System.out.println("Please Login:");
            System.out.println("--------------------------------------------------------------");
            System.out.print("Enter your Username: ");
            un= sc.next();
            System.out.print("Enter your Password: ");
            pwd= sc.next();
            if(un.equals("spipa") && pwd.equals("spipa123"))
            {
                System.out.println("--------------------------------------------------------------");
                System.out.println("*                          WELCOME                           *");
                System.out.println("--------------------------------------------------------------");
                System.out.println("--------------------------------------------------------------");
                System.out.print("Enter the Roll No. of the employee for the details: ");
                rno=sc.nextInt();
                System.out.println("--------------------------------------------------------------");
                System.out.println("The details are: ");
                String sq="select * from proemp where roll="+rno;
                ResultSet rs=st.executeQuery(sq);
                while(rs.next())
                {
                    System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getInt(3)
                            +" | "+rs.getString(4)+" | "+rs.getString(5)+" | "+rs.getString(6)
                            +" | "+rs.getString(7)+" | "+rs.getString(8)+" | "+rs.getInt(9)
                            +" | "+rs.getInt(10)+" | "+rs.getInt(11)+" | "+rs.getInt(12)
                            +" | "+rs.getString(13)+" | ");
                }
                System.out.println("--------------------------------------------------------------");
                System.out.println("Is the candidate approved?");
                System.out.println("--------------------------------------------------------------");
                String sq2="select * from proemp where roll="+rno+" and total>=110";
                int result=st.executeUpdate("insert into approv ("+sq2+")");
                String sq3="select roll,name,gender,total,course from approv";
                int result2=st.executeUpdate("insert into final ("+sq3+")");
                if(result>0)
                {
                    System.out.println("The Employee is Approved!!");
                    System.out.println("--------------------------------------------------------------");
                }
                else
                {
                    System.out.println("The Employee is not Approved..");
                    System.out.println("--------------------------------------------------------------");
                }
            }
            else
            {
                System.out.println("--------------------------------------------------------------");
                System.out.println("*             Failed to login!! Please try again.            *");
                System.out.println("--------------------------------------------------------------");
            }
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
