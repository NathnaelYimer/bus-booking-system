import java.sql.*;

public class Admin extends User{

    Admin(String userName, String name, int phoneNo, String password) {
        super(userName, name, phoneNo, password);
        this.type = "admin";
    }

    public static boolean authenticateUser(String userName,String password) throws Exception{

        Connection connection = Admin.connect("bookingsystem");
        
        String query="select password from userTable where userName =?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, userName);
        
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            if (resultSet.getString("password").equals(password)){
                return true;
            }

        }
        return false;

    }

    public static void addUser(User user) throws Exception{
            
            Connection connection = Admin.connect("bookingsystem");
            
            String query="insert into userTable values(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
    
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getName());
            statement.setString(3, user.password());
            statement.setInt(4, user.getphoneNo());
            statement.setString(5, "user");
            statement.executeUpdate();
    
    






    }
    public static boolean checkIfInDB(String userName) throws Exception{

        Connection connection = Admin.connect("bookingsystem");
        
        String query="select * from userTable where userName =?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, userName);

        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return true;
        }
        

        return false;

    }

    public static Connection connect(String databaseName) throws Exception{
        String url = "jdbc:mysql://localhost:3306/"+databaseName;
        String uname = "root";
        String pass = "";
        Class.forName("com.mysql.jdbc.Driver");


        Connection connection = DriverManager.getConnection(url, uname, pass);

        return connection;


    }
    
    
}
