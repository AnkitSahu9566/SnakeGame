import java.awt.*; 
import javax.swing.*;  
import java.awt.event.*;  
 class GDemo extends JFrame implements ActionListener
{   
    JButton b1,b2;  
	GDemo()
	{
		setTitle("Snake Game(levels)");
		 
	setLayout(null);
	Font f=new Font("",Font.BOLD,20);
   JLabel l1=new JLabel("WELCOME TO SNAKE GAME!!!..");
   l1.setBounds(50,50,400,40); 
   l1.setFont(f);
   l1.setForeground(Color.red);
   add(l1);
        b1=new JButton("Level 1");  
        b1.setBounds(50,100,200,200);  
        b2=new JButton("Level 2");  
        b2.setBounds(300,100,200,200);  
		add(b1);
		add(b2);

        b1.addActionListener(this);  
        b2.addActionListener(this); 		
	
 
    }   
    public void actionPerformed(ActionEvent e) 
	{  
  
    if(e.getSource()==b1){
	    FDemo1 f1=new FDemo1();
		f1.setVisible(true);
		f1.setSize(1520,920);
		f1.setLocation(10,10);}		 
    if(e.getSource()==b2)
		 {
			FDemo f3=new FDemo();
			f3.setVisible(true);
			f3.setSize(1500,950);
			f3.setLocation(10,10);} 
        }  
    }
 class SGame{
public static void main(String[] args) {  
  GDemo f= new GDemo(); 
  f.setLocation(100,100);
  
     f.setSize(600,400);  
        f.setLayout(null);  
        f.setVisible(true); 
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
  
	
}  
}  