import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Final
{
    public static void final_list()
    {
        try
        {
            String url="jdbc:mysql://localhost:3306/project";
            String username="root";
            String password="0000";
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st=con.createStatement();
            String un,pwd,co,gn;
            int choice;
            Scanner sc= new Scanner(System.in);
            System.out.println("--------------------------------------------------------------");
            System.out.println("*                       Final List                           *");
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
                System.out.println("                   1) List According to course                ");
                System.out.println("                   2) List According to gender                ");
                System.out.println("                   3) Complete List                           ");
                System.out.println("--------------------------------------------------------------");
                System.out.print("Enter Your Choice: ");
                choice=sc.nextInt();
                if(choice==1)
                {
                    System.out.print("Enter Course: ");
                    co= sc.next();
                    String sq="select * from final where course="+"\""+co+"\"";
                    ResultSet rs=st.executeQuery(sq);
                    while(rs.next())
                    {
                        System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)
                                +" | "+rs.getInt(4) +" | "+rs.getString(5)+" | ");
                    }
                }
                else if(choice==2)
                {
                    System.out.print("Enter Gender: ");
                    gn= sc.next();
                    String sq="select * from final where gender="+"\""+gn+"\"";
                    ResultSet rs=st.executeQuery(sq);
                    while(rs.next())
                    {
                        System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)
                                +" | "+rs.getInt(4) +" | "+rs.getString(5)+" | ");
                    }
                }
                else if(choice==3)
                {
                    System.out.println("The complete list: ");
                    String sq="select * from final group by course";
                    ResultSet rs=st.executeQuery(sq);
                    while(rs.next())
                    {
                        System.out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getString(3)
                                +" | "+rs.getInt(4) +" | "+rs.getString(5)+" | ");
                    }
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
