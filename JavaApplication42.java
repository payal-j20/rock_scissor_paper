package javaapplication42;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
public class JavaApplication42 extends Frame implements ActionListener  {
    int o=0,m=0;
    JFrame f=new JFrame();
    JButton r=new JButton("rock");
    JButton p=new JButton("paper");
    JButton s=new JButton("scissor");
    JButton play_again=new JButton("Play again");
    JLabel l=new JLabel();
    JLabel result=new JLabel();
    JLabel me=new JLabel();
    JLabel opp=new JLabel();
    public JavaApplication42(){
        me.setBounds(0,0,150, 40);
        opp.setBounds(200,0,150, 40);
        r.setBounds(130,100,100, 40);
        r.addActionListener(this);
        p.setBounds(130,150,100, 40);
        p.addActionListener(this);
        s.setBounds(130,200,100, 40);
        s.addActionListener(this);
        f.add(r);
        f.add(p);
        f.add(s);
        f.add(me);
        f.add(opp);
        me.setText("My Score : "+0);
        opp.setText("Opposite Score : "+0);
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)  {
        JavaApplication42 ab=new JavaApplication42();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String res="";
        String all[]={"rock","scissor","paper"};
        Random r_v=new Random();
        int r_select=r_v.nextInt(all.length);
        String v=all[r_select];
        JButton name=(JButton)e.getSource();
        System.out.println(name.getText());
        String user_v=name.getText();
        if(name.getText()!="Play again"){  
            if(v==user_v){
                System.out.println("Match is draw");
                res="Match is draw";
            }
            else if(v.equals("paper")&&user_v.equals("rock")){
                System.out.println("You loose");
                o++;
                opp.setText("Opposite Score : "+o);
                res="You loose";
            }
            else if(v.equals("rock")&&user_v.equals("scissor")){
                System.out.println("You loose");
                o++;
                opp.setText("Opposite Score : "+o);
                res="You loose";
            }
            else if(v.equals("scissor")&&user_v.equals("paper")){
                System.out.println("You loose");
                o++;
                opp.setText("Opposite Score : "+o);
                res="You loose";
            }
            else{
                System.out.println("You win!!");
                m++;
                me.setText("My Score : "+m);
                res="You win!!";
            }
            r.setEnabled(false);
            s.setEnabled(false);
            p.setEnabled(false);
        }
        l.setBounds(130,250,190, 40);
        f.add(l);
        l.setText("Opposite player : "+v);
        result.setBounds(130,270,190, 40);
        f.add(result);
        result.setText("Score : "+res);
        f.add(play_again);
        play_again.setBounds(130,310,100, 40);
        play_again.addActionListener(this);
        play_again.setVisible(true);
        JButton again=(JButton)e.getSource();
        if(again.getText().equals("Play again")){
            play_again.setVisible(false);
            l.setText(" ");
            result.setText(" ");
            r.setEnabled(true);
            s.setEnabled(true);
            p.setEnabled(true);
        }
    }
}