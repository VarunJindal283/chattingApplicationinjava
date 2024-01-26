package chattingApplicationinjava;

import javax.swing.*; //extended packages of java, for JFrame class
import java.awt.*; // for Color class

public class server extends JFrame {
    //constructor is made because we want to show the frame as soon as main is called
    server(){

        setLayout(null); // to show differnet differnet types of layouts

        // if you want to divide Frame into parts use JPanel class
        JPanel p1=new JPanel();
        p1.setBackground(new Color(7, 94, 84)); // setting the background color of upper part using rgb values
        // setBounds will only work when behind object's setLayout is null
        p1.setBounds(0, 0, 450, 70); // setting the position and size of p1 panel margin from left, margin for top, width, height respectively
        add(p1);


        //  for show the icon on top left corner
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("/icons/1.jpg")); //ClassLoader.getSystemResource helps in getting the image from system



        setSize(450,700); //method from JFrame class to set the width and height of frame respectively
        setLocation(200,50); //Frame is default set at top left corner, this function is used to provide margins from left and top side respectively
        getContentPane().setBackground(Color.WHITE);
        
        //it should be at last so that after all changes you can see the frame
        setVisible(true); //frame is default hidden to show the frame we use this method from JFrame class
    }

    public static void main(String[] args){
        new server(); // will make the object of class server and will call the constructor
    }
}
