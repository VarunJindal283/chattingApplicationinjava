package chattingApplicationinjava;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class client extends JFrame implements ActionListener{


    JPanel body;
    JTextField text;
    Box vertical=Box.createVerticalBox();
    JScrollPane scrollPane = new JScrollPane(vertical);
    client(){
        setLayout(null);

        // green header main panel
        JPanel header=new JPanel();
        header.setBackground(new Color(7, 94, 84));
        header.setBounds(0, 0, 450, 70);
        header.setLayout(null);
        add(header);


        // arrow on header panel
        try {
            JLabel arrow;
            if(ClassLoader.getSystemResource("icons/1.jpg")!=null){
                ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/1.jpg"));
                Image i2=i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                ImageIcon i3=new ImageIcon(i2);
                arrow=new JLabel(i3);
                arrow.setBounds(5, 20, 25, 25);
                header.add(arrow);
            }
            else{
                arrow=new JLabel("<html><p style=\"font-size:280%;\">&larr</p></html>");
                arrow.setBounds(5, 20, 25, 25);
                header.add(arrow);
            }

            arrow.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent ae){
                    System.exit(0);
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }

        // profile on header panel
        try{
            if(ClassLoader.getSystemResource("icons/1.jpg")!=null){
                ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/1.jpg"));
                Image i5=i4.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                ImageIcon i6=new ImageIcon(i5);
                JLabel profile=new JLabel(i6);
                profile.setBounds(40, 10, 50, 50);
                header.add(profile);
            }
            else{
                JPanel profile=new JPanel();
                profile.setBounds(40, 10, 50, 50);
                profile.setBackground(Color.DARK_GRAY);
                header.add(profile);
            }
        }catch(Exception e){
            System.out.println(e);
        }

        // video icon on header panel
        try{
            if(ClassLoader.getSystemResource("icons/1.jpg")!=null){
                ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icons/1.jpg"));
                Image i8=i7.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                ImageIcon i9=new ImageIcon(i8);
                JLabel video=new JLabel(i9);
                video.setBounds(300, 20, 30, 30);
                header.add(video);
            }
            else{
                JLabel video=new JLabel("<html><p style=\"font-size:350%;\">&#9729;</p></html>");
                video.setBounds(300, 22, 40, 30);
                header.add(video);
            }
        }catch(Exception e){
            System.out.println(e);
        }

        // phone icon on header panel
        try{
            if(ClassLoader.getSystemResource("icons/1.jpg")!=null){
                ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icons/1.jpg"));
                Image i11=i10.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                ImageIcon i12=new ImageIcon(i11);
                JLabel phone=new JLabel(i12);
                phone.setBounds(360, 20, 25, 30);
                header.add(phone);
            }
            else{
                JLabel phone=new JLabel("<html><p style=\"font-size:210%\">&#9742;</p></html>");
                phone.setBounds(370, 18, 25, 30);
                header.add(phone);
            }
        }catch(Exception e){
            System.out.println(e);
        }

        // more icon on header panel
        try{
            if(ClassLoader.getSystemResource("icons/1.jpg")!=null){
                ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("icons/1.jpg"));
                Image i14=i13.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
                ImageIcon i15=new ImageIcon(i14);
                JLabel more=new JLabel(i15);
                more.setBounds(420, 20, 10, 25);
                header.add(more);
            }
            else{
                JLabel more=new JLabel("<html><p style=\"font-size:200%;\">&#8942;</p></html>");
                more.setBounds(420, 20, 10, 25);
                header.add(more);
            }
        }catch(Exception e){
            System.out.println(e);
        }

        // name on header panel
        JLabel name=new JLabel("Varun");
        name.setBounds(110, 15, 100, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        header.add(name);

        // status on header panel
        JLabel status=new JLabel("Active Now");
        status.setBounds(110, 35, 100, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        header.add(status);

        // adding body panel below header
        body=new JPanel();
        body.setBounds(5, 75, 440, 570);
        add(body);

        // adding footer panel below body
        JPanel footer=new JPanel();
        footer.setBounds(0, 645, 450, 55);
        footer.setBackground(Color.lightGray);
        footer.setLayout(null);
        add(footer);

        // text bar on footer panel
        text=new JTextField();
        text.setBounds(5, 10, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        footer.add(text);

        // send button on footer panel
        JButton send=new JButton("Send");
        send.setBounds(320, 10, 123, 40);
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        footer.add(send);

        // whole frame configuration
        setSize(450, 700);
        setLocation(200, 70);
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae){
        //getting text from input text box
        String out=text.getText();

        // making panel conntaining text from input box
        JPanel msgpanel=formatPanel(out);
        
        // add msgpanel to right panel which will place it at ending of the line
        JPanel right=new JPanel(new BorderLayout());
        right.add(msgpanel, BorderLayout.LINE_END);

        
        
        // right is add to vertical box plus a strut for providing the space between two msgs
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));


        
        // setPreferredSize(new Dimension(450, 110));
        // add(scrollPane, BorderLayout.CENTER);
        
        
        // vertical box is placed above body to add msg one below one
        body.setLayout(new BorderLayout());
        body.add(vertical, BorderLayout.PAGE_START);



        // for refreshing the body, to get new text on screen
        repaint();
        invalidate();
        validate();
        
    }

    public static JPanel formatPanel(String out){
        // modified string so that we can get msg width max width 150px
        String modifiedOut="<html><p style=\"width:150px;\">" + out + "</p></html>";

        // adding the modified string to label and styling it
        JLabel msgLabel=new JLabel(modifiedOut);
        msgLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        msgLabel.setBackground(new Color(37, 211, 102));
        msgLabel.setOpaque(true);
        msgLabel.setBorder(new EmptyBorder(15, 15, 15, 50));

        // adding the label to panel
        JPanel msgPanel=new JPanel();
        msgPanel.add(msgLabel);

        // returning the final panel
        return msgPanel;
    }
    public static void main(String[] args){
        new client();
    }
}
