package chattingApplicationinjava;

import javax.swing.*; //extended packages of java, for JFrame class
import java.awt.*; // for Color class

public class server extends JFrame {
    //constructor is made because we want to show the frame as soon as main is called
    server(){
        setSize(450,700); //method from JFrame class to set the width and height of frame respectively
        setLocation(200,50); //Frame is default set at top left corner, this function is used to provide margins from left and top side respectively
        getContentPane().setBackground(Color.WHITE);
        
        //it should be at last so that after all changes you can see the frame
        setVisible(true); //frame is default hidden to show the frame we use this method from JFrame class
    }

    public static void main(String[] args){
        new server();
    }
}
