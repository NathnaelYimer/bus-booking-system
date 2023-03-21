import java.sql.*;

import javax.swing.JOptionPane;

public class User {

    private String name;
    private String userName;
    private String password;
    private int phoneNo;
    String type="user";


    User(String userName,String name,int phoneNo,String password){ 

        this.userName = userName;
        this.name = name;
        this.phoneNo = phoneNo;
        this.password = password;

    }


    public String getUserName(){
        return this.userName;
    }
    public String getName(){
        return this.name;
    }
    public String password(){
        return this.password;
    }
    public int getphoneNo(){
        return this.phoneNo;
    }
    @Override
    public String toString(){
        return name;
    }
    
    public static String userType(String userName){
        try {
        Connection connection = Admin.connect("bookingsystem");
        String query="select userType from userTable where userName =?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, userName);

        ResultSet resultSet = statement.executeQuery();
        

        
        resultSet.next();
        
        return resultSet.getString("userType");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return "user";
        

    }
    public static String getName(String userName){
        try {
            
        Connection connection = Admin.connect("bookingsystem");
        
        String query="select name userTable where userName =?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, userName);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet.getString("name");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;

    }
    public static int getPhone(String userName){
        try {
            
        Connection connection = Admin.connect("bookingsystem");
        
        String query="select phoneno userTable where userName =?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, userName);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet.getInt("phoneNo");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return 0;

    }





    
}
