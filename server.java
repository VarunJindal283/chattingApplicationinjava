package chattingApplicationinjava;

import javax.swing.*; //extended packages of java, for JFrame class
import java.awt.*; // for Color class
import java.awt.event.*; // actionListener interface(for providing functionalities like clicking on ImageIcon)

public class server extends JFrame implements ActionListener{
    //constructor is made because we want to show the frame as soon as main is called
    server(){

        setLayout(null); // to show differnet differnet types of layouts

        // if you want to divide Frame into parts use JPanel class
        JPanel p1=new JPanel();
        p1.setBackground(new Color(7, 94, 84)); // setting the background color of upper part using rgb values
        // setBounds will only work when behind object's setLayout is null
        p1.setBounds(0, 0, 450, 70); // setting the position and size of p1 panel margin from left, margin for top, width, height respectively
        p1.setLayout(null); // for working of top label setBounds
        add(p1);


        //  for show the icon on top left corner
        // try and catch is used because getSystemResource is not working it's giving null location execption
        // for arrow image
        try {
            // if system is unable to fetch the image from the computer then it will show the test instead
            JLabel back;
            if(ClassLoader.getSystemResource("icons/1.jpg")!=null){
                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/1.jpg")); //ClassLoader.getSystemResource helps in getting the image from system
                Image i2=i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT); // scaling the size of image
                ImageIcon i3=new ImageIcon(i2); //i2 can't be directly passed into JLabel so we have used ImageIcon class to convert scaled image into ImageIcon
                back=new JLabel(i3); // we can't set image icon directly on the frame so we used JLabel
                back.setBounds(5,20,25,25);
                p1.add(back); // for adding the image over the panel
            }
            else{
                back=new JLabel("Arrow");
                back.setBounds(5,20,25,25);
                p1.add(back);
            }
            
            // for providing the mouse click functionality to the JLabel
            back.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent ae){
                    System.exit(0); //for turing the whole server off or we can use setVisible=false but it will hide the Frame but don't turn off the program
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }


        // for get information about method and classes used, remember to check above try and catch block
        // for profile image
        try{
            JLabel profile;
            if(ClassLoader.getSystemResource("icons/1.jpg")!=null){
                ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("/icons/1.jpg"));
                Image i5=i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                ImageIcon i6=new ImageIcon(i5);
                profile=new JLabel(i6);
                profile.setBounds(40, 10, 50, 50);
                p1.add(profile);
            }
            else{
                profile=new JLabel("Profile");
                profile.setBounds(40, 10, 50, 50);
                p1.add(profile);
            }
        }catch(Exception e){
            System.out.println(e);
        }


        // for video icon
        try{
            JLabel video;
            if(ClassLoader.getSystemResource("icons/1.jpg")!=null){
                ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icons/1.jpg"));
                Image i8=i7.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                ImageIcon i9=new ImageIcon(i8);
                video=new JLabel(i9);
                video.setBounds(300, 20, 30, 30);
                p1.add(video);
            }
            else{
                video=new JLabel("Video");
                video.setBounds(300, 20, 30, 30);
                p1.add(video);
            }
        }catch(Exception e){
            System.out.println(e);
        }


        // for phone
        try{
            JLabel phone;
            if(ClassLoader.getSystemResource("icons/1.jpg")!=null){
                ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icons/1.jpg"));
                Image i11=i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
                ImageIcon i12=new ImageIcon(i11);
                phone=new JLabel(i12);
                phone.setBounds(360, 20, 25, 30);
                p1.add(phone);
            }
            else{
                phone=new JLabel("Phone");
                phone.setBounds(360, 20, 35, 30);
                p1.add(phone);
            }
        }catch(Exception e){
            System.out.println(e);
        }


        try{
            JLabel morebutton;
            if(ClassLoader.getSystemResource("icons/1.jpg")!=null){
                ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("icons/1.jpg"));
                Image i14=i13.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
                ImageIcon i15=new ImageIcon(i14);
                morebutton=new JLabel(i15);
                morebutton.setBounds(420, 20, 10, 25);
                p1.add(morebutton);
            }
            else{
                morebutton=new JLabel("morebutton");
                morebutton.setBounds(420, 20, 10, 25);
                p1.add(morebutton);
            }
        }catch(Exception e){
            System.out.println(e);
        }


        // writting the name
        JLabel name=new JLabel("Varun");
        name.setBounds(110, 15, 100,  18);
        p1.add(name);

        setSize(450,700); //method from JFrame class to set the width and height of frame respectively
        setLocation(200,50); //Frame is default set at top left corner, this function is used to provide margins from left and top side respectively
        getContentPane().setBackground(Color.WHITE);
        
        //it should be at last so that after all changes you can see the frame
        setVisible(true); //frame is default hidden to show the frame we use this method from JFrame class
    }

    // overriding  the abstract method of interface ActionListener
    @Override
    public void actionPerformed(ActionEvent ae){
        
    }

    public static void main(String[] args){
        new server(); // will make the object of class server and will call the constructor
    }
}
