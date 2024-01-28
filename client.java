package chattingApplicationinjava;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class client extends JFrame implements ActionListener{

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

        //profile on header panel
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
                header.add(profile);
            }
        }catch(Exception e){
            System.out.println(e);
        }

        // whole frame configuration
        setSize(450, 770);
        setLocation(200, 70);
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae){

    }
    public static void main(String[] args){
        new client();
    }
}
