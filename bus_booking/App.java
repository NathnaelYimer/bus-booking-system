import javax.swing.*;

import com.toedter.calendar.JCalendar;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.DefaultTableModel;


public class App {
    public static void main(String[] args) throws Exception {
        
        
        
        
        JFrame myFrame = new Frame();
        JFrame adminFrame = new Frame();
        adminFrame.setVisible(false);

        JButton loginButton = Frame.fButton("Login");
        loginButton.setBounds(400, 180, 150, 30);
        JButton createAccount = Frame.fButton("Create Account");
        createAccount.setBounds(400, 215, 150, 30);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(350, 145, 250, 30);
        JTextField userTextField = Frame.fTextField();
        userTextField.setText("Username");
        passwordField.setText("Password");
        userTextField.setBounds(350, 110, 250, 30);
        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setBounds(360,30,350,70);
        welcomeLabel.setText("WELCOME!");
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setFont(new Font("MV Boli",Font.BOLD,50));
        
        JLabel titleLabel = new JLabel();
        titleLabel.setBounds(200,100,500,750);
        titleLabel.setIcon(Frame.imageIcon);
        titleLabel.setIconTextGap(-25);
        
        Bus bus1 = new Bus("Habesha", "H01");
        Bus bus2 = new Bus("Abay", "A01");
        Bus bus3 = new Bus("ODA", "O01");
        Bus bus4 = new Bus("Selam", "S01");
        Bus bus5 = new Bus("Habesha", "H02");
        Bus bus6 = new Bus("Ethio", "E01");
        Bus[] buses ={bus1,bus2,bus3,bus4,bus5,bus6};

        Location[] destination = {new Location(2, "Bahir Dar"), new Location(1, "Addis Ababa"),
            new Location(3, "Hawassa"),new Location(4, "Arba Minch"),new Location(5, "Gondar"),
            new Location(6, "Mekele"),new Location(7, "Jimma")};
        
        Location[] startingLocations = {new Location(2, "Bahir Dar"), new Location(1, "Addis Ababa"),
            new Location(3, "Hawassa"),new Location(4, "Arba Minch"),new Location(5, "Gondar"),
            new Location(6, "Mekele"),new Location(7, "Jimma")};
            
            
        JLabel choosebusLabel = new JLabel();
        choosebusLabel.setText("Choose Bus");
        choosebusLabel.setFont(new Font("MV Boli",Font.BOLD,30));
        choosebusLabel.setBounds(30, 40, 500, 40);
        
        JComboBox<Bus> jComboBox = new JComboBox<Bus>(buses);
        jComboBox.setBounds(30,100,250,30);
        
        JLabel chooseStartingLabel = new JLabel();
        chooseStartingLabel.setText("Choose Starting Place");
        chooseStartingLabel.setFont(new Font("MV Boli",Font.BOLD,30));
        chooseStartingLabel.setBounds(30, 160, 500, 40);

        JComboBox<Location> startingComboBox = new JComboBox<>(startingLocations);
        startingComboBox.setBounds(30,220,250,30);

        JLabel chooseDestinationLabel = new JLabel();
        chooseDestinationLabel.setText("Choose Destination");
        chooseDestinationLabel.setFont(new Font("MV Boli",Font.BOLD,30));
        chooseDestinationLabel.setBounds(30, 280, 500, 40);

        JComboBox<Location> destinatiComboBox = new JComboBox<Location>(destination);
        destinatiComboBox.setBounds(30,340,250,30);




        JLabel chooseSeatLabel = new JLabel();
        chooseSeatLabel.setText("Choose Seat Number");
        chooseSeatLabel.setFont(new Font("MV Boli",Font.BOLD,25));
        chooseSeatLabel.setBounds(30,400,250,30);
    

        
        
        JPanel loginPanel = Frame.fJPanel();
        JPanel mainPanel = Frame.fJPanel();
        mainPanel.setVisible(false);
        JPanel signUpPanel = Frame.fJPanel();
        signUpPanel.setVisible(false);
        
        loginPanel.add(welcomeLabel);
        loginPanel.add(titleLabel);
        loginPanel.add(userTextField);
        loginPanel.add(passwordField);
        loginPanel.add(createAccount);
        loginPanel.add(loginButton);


        
        JMenuBar menuBar = new JMenuBar();
        JMenu setting = new JMenu("Setting");
        JMenuItem profile = new JMenuItem("Profile");
        JMenuItem today = new JMenuItem("Today");
        JMenuItem logout = new JMenuItem("log out");






        ActionListener t = new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(ae.getSource() == today){
                JOptionPane.showMessageDialog(null, "Today is: " +new Date().toString(), "Today's date ", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(ae.getSource() == profile) {

                    JPanel profilePanel = Frame.fJPanel();
                    profilePanel.setBounds(0, 0, 200, 300);
                    String userType = User.userType(userTextField.getText());
                    String usern = User.getName(userTextField.getText());
                    int phonenoo= User.getPhone(userTextField.getText());

                    JLabel tLabel = new JLabel("Type:" +userType);
                    tLabel.setFont(new Font("MV Boli",Font.BOLD,20));
                    tLabel.setBounds(20, 125, 200, 30);

                    JLabel nLabel = new JLabel("Name: "+usern);
                    nLabel.setFont(new Font("MV Boli",Font.BOLD,20));
                    nLabel.setBounds(20, 20, 200, 30);
                    JLabel uLabel = new JLabel("User Name: "+userTextField.getText());
                    uLabel.setFont(new Font("MV Boli",Font.BOLD,20));
                    uLabel.setBounds(20, 55, 200, 30);
                    JLabel pLabel = new JLabel("PhoneNO: "+phonenoo);
                    nLabel.setFont(new Font("MV Boli",Font.BOLD,20));
                    nLabel.setBounds(20, 90, 200, 30);
                    profilePanel.add(tLabel);
                    profilePanel.add(nLabel);
                    profilePanel.add(uLabel);
                    profilePanel.add(pLabel);
                    
                    mainPanel.add(profilePanel);
                    profilePanel.setVisible(true);

                    try {
                        Thread.sleep(7000);
                    } catch (InterruptedException e) {
                        JOptionPane.showMessageDialog(null, e, null, JOptionPane.ERROR_MESSAGE);
                    }

                    profilePanel.setVisible(false);

                    
                    
                    
                    
                }
                else if (ae.getSource() == logout){

                    myFrame.setVisible(true);
                    loginPanel.setVisible(true);
                    mainPanel.setVisible(false);
                    menuBar.setVisible(false);

                }

            }
        };

        today.addActionListener(t);
        logout.addActionListener(t);
        profile.addActionListener(t);
        
        setting.add(today);
        setting.add(profile);
        setting.add(logout);
        ActionListener loginListener = new ActionListener(){
            public void actionPerformed(ActionEvent ae){

                String uName = userTextField.getText();
                String uPass = String.valueOf(passwordField.getPassword());
                try {
                    if (Admin.authenticateUser(uName, uPass)){
                        if(User.userType(uName).equals("admin")){

                            
                            adminFrame.setVisible(true);
                            DefaultTableModel tableModelB = new DefaultTableModel();
                            DefaultTableModel tableModelBo = new DefaultTableModel();
                            DefaultTableModel tableModelU = new DefaultTableModel();
                            JTable tableBo = new JTable(tableModelBo);
                            JTable tableU = new JTable(tableModelU);
                            JTable tableB = new JTable(tableModelB);
                            tableBo.setFillsViewportHeight(true);
                            tableModelBo.addColumn("bookingId");
                            tableModelBo.addColumn("customerName");
                            tableModelBo.addColumn("SeatNo");
                            tableModelBo.addColumn("BusNo");
                            tableModelBo.addColumn("date");

                            tableModelB.addColumn("busNo");
                            tableModelB.addColumn("busName");

                            tableModelU.addColumn("User Name");
                            tableModelU.addColumn("Name");
                            tableModelU.addColumn("Phone No");
                            


                            JPanel bookingPanel = Frame.fJPanel();
                            bookingPanel.setVisible(false);
                            JPanel userPanel = Frame.fJPanel();
                            userPanel.setVisible(false);
                            JPanel busPanel = Frame.fJPanel();
                            busPanel.setVisible(false);

                            JButton Fetch = Frame.fButton("Fetch");
                            
                            


                            JRadioButton busFetch = new JRadioButton();
                            busFetch.setText("Get List of Buses");
                            JRadioButton userFetch = new JRadioButton();
                            userFetch.setText("Get Users List");
                            JRadioButton bookingFetch = new JRadioButton();
                            bookingFetch.setText("view Booking Histoy");

                            busFetch.setBounds(300, 200, 200, 50);
                            userFetch.setBounds(300, 260, 200, 50);
                            bookingFetch.setBounds(300, 310, 200, 50);
                            Fetch.setBounds(340, 360, 150, 50);


                            ButtonGroup nbButtonGroup = new ButtonGroup();
                            nbButtonGroup.add(busFetch);
                            nbButtonGroup.add(userFetch);
                            nbButtonGroup.add(bookingFetch);

                            bookingPanel.add(tableBo);
                            userPanel.add(tableU);
                            busPanel.add(tableB);
                            userPanel.setLayout(new FlowLayout());
                            busPanel.setLayout(new FlowLayout());
                            busPanel.add(tableB);
                            userPanel.add(tableU);
                            bookingPanel.add(tableBo);
                            bookingPanel.setLayout(new FlowLayout());
                            
                            adminFrame.add(Fetch);
                            adminFrame.add(busFetch);
                            adminFrame.add(userFetch);
                            adminFrame.add(bookingPanel);
                            adminFrame.add(userPanel);
                            adminFrame.add(busPanel);
                            myFrame.setVisible(false);
                            
                            ActionListener fetchListen = new ActionListener(){
                                public void actionPerformed(ActionEvent ae){
                                    if(busFetch.isSelected()){

                                        
                                        try {
                                            Connection connection = Admin.connect("bookingsystem");
                                            String query="select * from bus";
                                            Statement statement = connection.createStatement();
                                            ResultSet rSet = statement.executeQuery(query);
                                            Fetch.setVisible(false);
                                            busFetch.setVisible(false);
                                            userFetch.setVisible(false);
                                            bookingFetch.setVisible(false);
                                            busPanel.setVisible(true);

                                            while(rSet.next()){
                                                
                                                String id = rSet.getString("busNo");
                                                String busName = rSet.getString("busName");
                                                
                                                tableModelB.addRow(new Object[]{id,busName});
                                                
                                    
                                    
                                    
                                            }                                    


                                        } catch (Exception e) {
                                            JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                    else if(bookingFetch.isSelected()){
                                            Connection connection;
                                            try {
                                                connection = Admin.connect("bookingsystem");
                                                String query="select * from booking";
                                                Statement statement = connection.createStatement();
                                                ResultSet rSet = statement.executeQuery(query);
                                                bookingPanel.setVisible(true);

                                                while(rSet.next()){

                                                    int id = rSet.getInt("bookingId");
                                                    String cuName = rSet.getString("customerUserName");
                                                    int seat = rSet.getInt("seatNo");
                                                    String busNo = rSet.getString("busNo");
                                                    String date = rSet.getString("date");
                                        
                                                    tableModelBo.addRow(new Object[]{id,cuName,seat,busNo,date});
                                                    
                                                    
                                        
                                                }
                                        
                                            } catch (Exception e) {
                                                JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
                                            }
                                            
                                    }
                                    else if (userFetch.isSelected()){

                                        Connection connection;
                                            try {
                                                connection = Admin.connect("bookingsystem");
                                                String query="select userName,name,phoneNo from userTable";
                                                Statement statement = connection.createStatement();
                                                ResultSet rSet = statement.executeQuery(query);
                                                
                                                userPanel.setVisible(true);
                                                
                                                while(rSet.next()){

                                                    String uName = rSet.getString("userName");
                                                    String na = rSet.getString("name");
                                                    int pho= rSet.getInt("phoneNo");
                                        
                                                    tableModelU.addRow(new Object[]{uName,na,pho});
                                                    
                                                    
                                        
                                                }
                                        
                                            } catch (Exception e) {
                                                JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
                                            }


                                    }
                                }
                            };


                            Fetch.addActionListener(fetchListen);


                            
                            adminFrame.add(busFetch);
                            adminFrame.add(bookingFetch);
                            adminFrame.add(userFetch);
                            adminFrame.add(Fetch);
                            adminFrame.setVisible(true);
                        }
                        
                        
                        JCalendar calendar = new JCalendar();
                        calendar.getDayChooser().setMinSelectableDate(new Date());
                        JButton book = Frame.fButton("Book");
                        book.setBounds(530, 520, 150, 50);

                        
                        
                        calendar.setBackground(Color.BLACK);
                        calendar.setBounds(400, 100, 400, 400);
                        JLabel chooseDate = new JLabel();
                        chooseDate.setText("Choose Date");
                        chooseDate.setBounds(550, 30, 400, 50);
                        chooseDate.setFont(new Font("MV Boli",Font.BOLD,25));

                    

                        JRadioButton seat1 = new JRadioButton("Seat-1");
                        seat1.setBounds(30,460,150,30);
                        seat1.setFocusable(false);
                        JRadioButton seat2 = new JRadioButton("Seat-2");
                        seat2.setBounds(30,495,150,30);
                        seat2.setFocusable(false);
                        JRadioButton seat3 = new JRadioButton("Seat-3");
                        seat3.setBounds(30,530,150,30);
                        seat3.setFocusable(false);
                        JRadioButton seat4 = new JRadioButton("Seat-4");
                        seat4.setBounds(30,565,150,30);
                        seat4.setFocusable(false);
                        JRadioButton seat5 = new JRadioButton("Seat-5");
                        seat5.setBounds(30,600,150,30);
                        seat5.setFocusable(false);

                        ActionListener bookListener = new ActionListener(){
                            public void actionPerformed(ActionEvent ae){

                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                String datee = dateFormat.format(calendar.getDate());
                                String custName = userTextField.getText();
                                int sNo;
                                if(seat1.isSelected()){sNo = 1;}
                                else if(seat2.isSelected()){sNo =2;}
                                else if(seat3.isSelected()){sNo = 3;}
                                else if(seat4.isSelected()){sNo = 4;}
                                else{sNo = 5;}

                                String bId= ((Bus)jComboBox.getSelectedItem()).busNo;
                                int sId = ((Location)startingComboBox.getSelectedItem()).Lid;
                                int dId = ((Location)destinatiComboBox.getSelectedItem()).Lid;

                                

                                Booking book = new Booking(custName, sNo, bId, datee,sId,dId);
                                try {
                                    if (sId == dId){
                                        JOptionPane.showMessageDialog(null, "Destination can't be Your staritng point", null, JOptionPane.ERROR_MESSAGE);
                                    }
                                    else if(Sales.checkAvailability(book)){
                                        JTextArea bill = new JTextArea();

                                        bill.setBounds(190, 460, 160, 140);
                                        Sales.addBooking(book);
                                        String mess ="Customer Name: " +User.getName(custName)+"\n"+"Bus: "+bId +"\n"
                                        +"Starting Point: " +startingComboBox.getSelectedItem()+"\n"+"Destination: " +destinatiComboBox.getSelectedItem()+"\n"+
                                        "Seat No:" + sNo+"\n"+"Date: "+datee+"\n" +"please pay using mobile banking\n use 100045678987";
                                        JOptionPane.showMessageDialog(null, "Your Seat has been Booked", "congratulations", JOptionPane.INFORMATION_MESSAGE);
                                        bill.append(mess);
                                        mainPanel.add(bill);
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "Sorry that seat is booked on +" + datee, null, JOptionPane.INFORMATION_MESSAGE);
                                    }
                                } catch (Exception e) {
                                    // JOptionPane.showMessageDialog(null, e, null, JOptionPane.ERROR_MESSAGE);
                                    
                                }
                                






                            

                            }
                        };
                        book.addActionListener(bookListener);

                        ButtonGroup buttonGroup = new ButtonGroup();
                        buttonGroup.add(seat1);
                        buttonGroup.add(seat2);
                        buttonGroup.add(seat3);
                        buttonGroup.add(seat4);
                        buttonGroup.add(seat5);
                        
                        menuBar.add(setting);
                        myFrame.setJMenuBar(menuBar);
                        menuBar.setBounds(0, 0, 900, 10);
                        menuBar.setVisible(true);
                        mainPanel.add(chooseSeatLabel);
                        mainPanel.add(chooseStartingLabel);
                        mainPanel.add(startingComboBox);
                        mainPanel.add(chooseDestinationLabel);
                        mainPanel.add(destinatiComboBox);
                        mainPanel.add(seat1);
                        mainPanel.add(seat2);
                        mainPanel.add(seat3);
                        mainPanel.add(seat4);
                        mainPanel.add(seat5);
                        mainPanel.add(choosebusLabel);
                        mainPanel.add(jComboBox);
                        mainPanel.add(book);
                        mainPanel.add(calendar);
                        mainPanel.add(chooseDate);
                        mainPanel.setVisible(true);
                        loginPanel.setVisible(false);
                    }
                    else{
                        // JOptionPane messagePane = new JOptionPane();
                        if (Admin.checkIfInDB(uName)){
                            JOptionPane.showMessageDialog(null, "Your password is wrong", "erorr",JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Wrong User name", "erorr",JOptionPane.ERROR_MESSAGE);

                        }
                        

                        
                    }
                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
                    
                }
                
                
                
                
            }
        };
        loginButton.addActionListener(loginListener);

        ActionListener createAccountListener = new ActionListener(){
            public void actionPerformed(ActionEvent ae){

                JTextField namTextField = Frame.fTextField();
                namTextField.setText("Enter Your Name");
                namTextField.setBounds(350, 110, 250, 30);
                JTextField userNamTextField = Frame.fTextField();
                userNamTextField.setText("Use a unique UserName");
                userNamTextField.setBounds(350, 145, 250, 30);
                JTextField phoneNoField = Frame.fTextField();
                phoneNoField.setText("Five digits is enough");
                phoneNoField.setBounds(350, 180, 250, 30);
                JPasswordField passField = new JPasswordField();
                passField.setText("password");
                passField.setBounds(350, 215, 250, 30);

                

                
                JButton signButton = Frame.fButton("Sign UP");
                signButton.setBounds(400, 250, 150, 30);

                ActionListener signUpListner = new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                        String name = namTextField.getText();
                        String uname = userNamTextField.getText();
                        int phoneno =Integer.parseInt(phoneNoField.getText());
                        String password = String.valueOf(passField.getPassword());

                        try {
                            if(Admin.checkIfInDB(uname)){
                                JOptionPane.showMessageDialog(null, "user name already exist ", "error",JOptionPane.ERROR_MESSAGE);
                            }
                            else if (name.equals("") | uname.equals("") | password.equals("")){
                                JOptionPane.showMessageDialog(null, "All fields are required", "error",JOptionPane.ERROR_MESSAGE);
                    
                            }
                            else{
                                User user = new User(uname, name, phoneno, password);

                                Admin.addUser(user);
                                signUpPanel.setVisible(false);
                                loginPanel.add(welcomeLabel);
                                loginPanel.add(titleLabel);

                                loginPanel.setVisible(true);
                            }
                        } catch (Exception e) {
                            
                            JOptionPane.showMessageDialog(null, e.getMessage(),null, JOptionPane.ERROR_MESSAGE);
                        }


                    }
                };
                signButton.addActionListener(signUpListner);
                
                signUpPanel.add(namTextField);
                signUpPanel.add(userNamTextField);
                signUpPanel.add(phoneNoField);
                signUpPanel.add(passField);
                signUpPanel.add(signButton);
                signUpPanel.add(welcomeLabel);
                signUpPanel.add(titleLabel);
                
                signUpPanel.setVisible(true);           
                loginPanel.setVisible(false);
                
                

                
                
            }
        };
        createAccount.addActionListener(createAccountListener);
        
        

        

        
        myFrame.add(signUpPanel);
        myFrame.add(mainPanel);
        myFrame.add(loginPanel);
        adminFrame.add(menuBar);
        
    

        
    
    }
}
