import java.sql.*;


public abstract class Sales{

    public static boolean checkAvailability(Booking book) throws Exception{
        Connection connection = Admin.connect("bookingsystem");
        String query="select * from booking where seatNo=? and busNo=? and date=? and startingg = ? and destination = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, book.seatNo);
        statement.setString(2, book.busNo);
        statement.setString(3, book.date);
        statement.setInt(4, book.starting);
        statement.setInt(5, book.destination);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){

            return false;
        }
        return true;


        
    }
    public static void addBooking(Booking booking) throws Exception{

        Connection connection = Admin.connect("bookingsystem");
        
        String query="insert into booking(customerUserName,seatNo,busNo,date,startingg,destination) values(?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, booking.custUserName);
        statement.setInt(2, booking.seatNo);
        statement.setString(3, booking.busNo);
        statement.setString(4, booking.date);
        statement.setInt(5,booking.starting);
        statement.setInt(6, booking.destination);

        statement.executeUpdate();



    }

    

    
    
}
