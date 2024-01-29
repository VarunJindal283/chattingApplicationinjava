package chattingApplicationinjava;

import javax.swing.*; //extended packages of java, for JFrame class
import javax.swing.border.*; // for EmptyBorder
import java.awt.*; // for Color class
import java.awt.event.*; // actionListener interface(for providing functionalities like clicking on ImageIcon)
import java.util.*; // for calender class
import java.text.*; // for date format
import java.net.*; // for sockets
import java.io.*; // for data input/output stream

public class server implements ActionListener{

    static JFrame f=new JFrame();
    //declaring it globally because we need it in another method
    JTextField text;
    static JPanel a1;
    static Box vertical=Box.createVerticalBox(); // we have to create a vertical box so that messages can be show below one and one
    static JPanel dummya1=new JPanel();
    static JScrollPane scrollPane=new JScrollPane(dummya1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    static DataOutputStream dout;
    
    //constructor is made because we want to show the frame as soon as main is called
    server(){

        f.setLayout(null); // to show differnet differnet types of layouts

        // if you want to divide Frame into parts use JPanel class
        JPanel p1=new JPanel();
        p1.setBackground(new Color(7, 94, 84)); // setting the background color of upper part using rgb values
        // setBounds will only work when behind object's setLayout is null
        p1.setBounds(0, 0, 450, 70); // setting the position and size of p1 panel margin from left, margin for top, width, height respectively
        p1.setLayout(null); // for working of top label setBounds
        f.add(p1);


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
        JLabel name=new JLabel("Varun"); // for writing the name of the profile holder
        name.setBounds(110, 15, 100,  18);
        name.setForeground(Color.WHITE); // for changing the test color
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18)); // setting font type, style and size respectively
        p1.add(name);


        // showing status
        JLabel status = new JLabel("Active Now");
        status.setBounds(110, 35, 100, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(status);


        // now making text area
        a1=new JPanel();
        a1.setBounds(5, 75, 440, 570);
        f.add(a1);


        // adding text field section below text area
        text=new JTextField(); // for making of the text writing bar
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(text);


        // adding button at side of the text field section
        JButton send=new JButton("Send"); // for making button with text
        send.setBounds(320, 655, 123, 40);
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this); // adding event listener on JButton class
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(send);

        f.setSize(450,700); //method from JFrame class to set the width and height of frame respectively
        f.setLocation(200,50); //Frame is default set at top left corner, this function is used to provide margins from left and top side respectively
        f.setUndecorated(true); // for removing header section
        f.getContentPane().setBackground(Color.WHITE);
        
        //it should be at last so that after all changes you can see the frame
        f.setVisible(true); //frame is default hidden to show the frame we use this method from JFrame class
    }

    // overriding  the abstract method of interface ActionListener
    @Override
    public void actionPerformed(ActionEvent ae){
        String out=text.getText(); // to get the string present inside the text box when send button is clicked
        // JLabel output=new JLabel(out); // adding the text to JLabel
        // JPanel p2=new JPanel(); // adding the JLabel to JPanel
        // p2.add(output);

        JPanel p2=formatLabel(out); // getting it from below function

        // a1.setLayout(new BorderLayout()); // converting the text area layout to border layout that will help us to align the things on five positions

        JPanel right = new JPanel(new BorderLayout()); // making a JPanel that will have border layout
        right.add(p2, BorderLayout.LINE_END); // we can't directly pass the text to this function so we have used p2 and placed it on right side of new panel
        vertical.add(right); // adding the right JPanel to vertical box which will align messages one below one
        vertical.add(Box.createVerticalStrut(15)); // adding the space between JPanels in vertical box

        dummya1.setLayout(new BorderLayout());
        dummya1.add(vertical, BorderLayout.PAGE_START); // here we are adding the vertical box to dummy a1 on starting of the text box

        scrollPane.setPreferredSize(new Dimension(440, 570)); // setting width and height after which scroll will start working

        a1.add(scrollPane); // here we are adding scroll to a1

        try{
            dout.writeUTF(out); // writing message in socket
        }catch(Exception e){
            e.printStackTrace();
        }

        text.setText(""); // for setting the text box empty after sending the message
        
        // we have to reload the page as we click on the button so we will use repaint, invalidate and validate function
        f.repaint();
        f.invalidate();
        f.validate();
    }

    public static JPanel formatLabel(String out){
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // for getting the things we add in JPanel aligned in Y-axis

        String modifiedOut="<html><p style=\"width: 150px\">" + out + "</p></html>"; // we have use html paragraph tag to make the width of box 150px
        JLabel output=new JLabel(modifiedOut);
        output.setFont(new Font("Tahoma", Font.PLAIN, 16)); // changing the font of the output label
        output.setBackground(new Color(37, 211, 102)); // changing the background color of output label
        output.setOpaque(true); // default the background of label is transparent we have to make it opaque to show the background color
        output.setBorder(new EmptyBorder(15, 15, 15, 50)); // for providing padding to the panel
        panel.add(output);

        Calendar cal = Calendar.getInstance(); // getting the date and time
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // for formatting the time we get from above command

        JLabel time=new JLabel(); // creating a new JLabel for adding the time
        time.setText(sdf.format(cal.getTime())); // setting the text inside the JLabel after formatting the value we got from Calender object

        panel.add(time); // adding the time to the panel

        return panel;
    }

    public static void main(String[] args){
        new server(); // will make the object of class server and will call the constructor

        try{
            ServerSocket skt=new ServerSocket(6001); // making a server at port 6001
            // for infinitely accepting messages which are sent by client
            while(true){
                Socket s=skt.accept(); // this will accept the connection from client and stores in socket s
                DataInputStream din=new DataInputStream(s.getInputStream()); // this will help to read data from socket
                dout=new DataOutputStream(s.getOutputStream()); // this will help to write data in socket
                // for infinitely writing and reading messages in socket s
                while(true){
                    String msg=din.readUTF(); // msg contains message sent by client
                    JPanel panel=formatLabel(msg); // format message same as we have formatted above message
                    
                    JPanel left=new JPanel(new BorderLayout());// making left for adding panel to the left
                    left.add(panel, BorderLayout.LINE_START);// panel added to line start of left
                    vertical.add(left); //left added to vertical
                    vertical.add(Box.createVerticalStrut(15));
                    
                    dummya1.setLayout(new BorderLayout());
                    dummya1.add(vertical, BorderLayout.PAGE_START);

                    a1.add(scrollPane);
                    
                    f.validate(); // body refreshed
                }
            }
        }catch(Exception e){
            e.printStackTrace(); // returns lines at which error has occurred
        }
    }
}
