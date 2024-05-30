import java.sql.*;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class MainPage
{
    public static void main(String[] args)
    {
        System.out.println("--------------------------------------------------------------");
        System.out.println("*                                                            *");
        System.out.println("*                  Employee Training System                  *");
        System.out.println("*                  Made By:- Dhruvi Suthar                   *");
        System.out.println("*                                                            *");
        System.out.println("--------------------------------------------------------------");
        Scanner sc= new Scanner(System.in);
        int choice;
        while(true)
        {
            Menu.menu();
            System.out.print("Enter Your Choice: ");
            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    Register.reg();
                    break;
                case 2:
                    Approval.approve();
                    break;
                case 3:
                    Final.final_list();
                    break;
                case 4:
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("*                        Thank You!                          *");
                    System.out.println("--------------------------------------------------------------");
                    return;
            }
        }
    }
}
