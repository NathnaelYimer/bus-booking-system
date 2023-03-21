import javax.swing.*;
import java.awt.*;


public class Frame extends JFrame{

    static Color preferedColor = new Color(90,50,250);
    static Image image = new ImageIcon("icon.png").getImage().getScaledInstance(500, 500, java.awt.Image.SCALE_SMOOTH);
    static ImageIcon imageIcon = new ImageIcon(image);

    Frame(){

        // Frame
        this.setVisible(true);
        this.setSize(900, 750);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(imageIcon.getImage());
        this.getContentPane().setBackground(preferedColor);
        this.setLayout(null);

    }

    public static JButton fButton(String name){
        JButton button;
        button = new JButton(name);
        button.setFocusable(false);
        button.setSize(150,30);
        return button;
    }

    public static JTextField fTextField(){

        JTextField textField;
        textField = new JTextField();
        textField.setSize(250, 30);

        return textField;
    }
    public static JPanel fJPanel(){
        JPanel jpanel;
        jpanel = new JPanel();
        jpanel.setBounds(0,15,900,735);
        jpanel.setBackground(preferedColor);
        jpanel.setLayout(null);
        return jpanel;
    }
}