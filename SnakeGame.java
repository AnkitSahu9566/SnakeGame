import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
class FDemo extends JFrame
{ 
   JPDemo jp;
   JPDemo jp1;
   
	FDemo()
	{
		setTitle("Snake Game level-2");

	jp=new JPDemo();
	add(jp); 
	}
}
class JPDemo extends JPanel implements ActionListener,KeyListener
{  
JTextField tx1,tx2;
JLabel u1,u2,s1; 
JButton b1,b2,b3;
ImageIcon img1,img2,img3;
Image dot,head,food;
int dots=5;
int x[]=new int[100];
int y[]=new int[100];
boolean start_game=false;
boolean left=false,right=true,up=false,down=false;
int r1=0,r2=0;
Timer t;
int tt=200;
int Score=0;
int hightest_score;
	JPDemo()
	{   setLayout(null);
	
	Font f1=new Font("",Font.BOLD,50);
	s1=new JLabel();
	s1.setForeground(Color.red);
	s1.setBounds(250,250,700,50);
	s1.setFont(f1);
	add(s1);
		Font f=new Font("",Font.BOLD,30);
			tx1=new JTextField(10);
			tx1.setSize(150,40);
		tx1.setLocation(200,850);
		tx1.setFont(f); 
		tx1.setText(""+Score);
		add(tx1);
		
		u1=new JLabel("Score");
			u1.setSize(100,40);
		u1.setLocation(50,850);
		u1.setForeground(Color.red);
		u1.setFont(f);
		add(u1);
		
				tx2=new JTextField(10);
			tx2.setSize(150,40);
		tx2.setLocation(700,850);
		tx2.setFont(f); 
		tx2.setText(""+hightest_score);
		add(tx2);
		
		u2=new JLabel("Highest Score");
			u2.setSize(250,40);
		u2.setLocation(400,850);
		u2.setForeground(Color.red);
		u2.setFont(f);
		add(u2);
		
		b1=new JButton("NEW");
		b1.setSize(100,40);
		b1.setLocation(950,850);
		add(b1);
		b1.setBackground(Color.red);
		b1.addActionListener(this);
		
		
		b2=new JButton("stop");
		b2.setSize(100,40);
		b2.setLocation(1070,850);
		add(b2);
		b2.setBackground(Color.green);
		b2.addActionListener(this);
		
		
		b3=new JButton("Resume");
		b3.setSize(100,40);
		b3.setLocation(1190,850);
		add(b3);
		b3.setBackground(Color.yellow);
		b3.addActionListener(this);
		
		x[0]=120;
		y[0]=100;
		
		x[1]=100;
		y[1]=100;
		
		x[2]=80;
		y[2]=100;
		
		x[3]=60;
		y[3]=100;
		
		x[4]=40;
		y[4]=100;
		setBackground(Color.black);
		
		img1=new ImageIcon("dot.png");
		dot=img1.getImage(); 
		img2=new ImageIcon("head1.png");
		head=img2.getImage(); 
		img3=new ImageIcon("food.png");
		food=img3.getImage(); 
		
		
		t=new Timer(tt,this);
		t.start();
		
	
		
		addKeyListener(this);
		setFocusable(true);
		randomDemo();
		
		
	}
	void randomDemo()
	{
		r1=(int)Math.round(Math.random()*70+1);
		r1=r1*20;
		r2=(int)Math.round(Math.random()*41+1);
		r2=r2*20;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Color c1=new Color(132,0,20);
		 g.setColor(c1);
		g.fillRect(00,00,10,838);
		g.fillRect(1470,00,10,838);
		g.fillRect(00,00,1470,10);
		g.fillRect(00,838,1480,10);
		
		//bound....
		g.setColor(Color.blue);
		g.fillRect(200,00,10,150);
		g.fillRect(800,00,10,500);
		g.fillRect(1200,00,10,500);
		g.fillRect(300,538,10,300);
		g.fillRect(600,438,10,400);
	 
	 g.drawImage(food,r1,r2,this); 
	 
		for(int i=0;i<dots;i++)
			{
				if(i==0)
				{  	g.drawImage(head,x[i],y[i],this); }
				else
				{ 	g.drawImage(dot,x[i],y[i],this); }
			}
	
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1){
			
  FDemo f1=new FDemo();
  f1.setVisible(true);
  f1.setSize(1500,950);
  f1.setLocation(10,10);
			 }
			 //stop
		if(e.getSource()==b2){t.stop();}
		if(e.getSource()==b3){
			
			t.start();
			start_game=true;
		b3.addKeyListener(this);
			
			}
		
		if(((x[0]>=160 && x[0]<=239) && (y[0]>=00 && y[0]<=150)) || ((x[0]>=760 && x[0]<=820) && (y[0]>=00 && y[0]<=500))
			||((x[0]>=1160 && x[0]<=1210) && (y[0]>=00 && y[0]<=500)) ||((x[0]>=260 && x[0]<=320) && (y[0]>=538 && y[0]<=838))
		    ||((x[0]>=560 && x[0]<=620) && (y[0]>=440 && y[0]<=880)))
		{ randomDemo();
		 }
	    else if(x[0]==r1 && y[0]==r2)
		{
			dots++;
			Score=Score+50;
			tx1.setText(" "+Score);
			if(hightest_score<Score)
			{
				hightest_score=Score;
				tx2.setText(""+hightest_score);
				}
			if(dots%5==0)
			{
				tt=tt-20;
		t=new Timer(tt,this);
		t.start();
			}
			randomDemo();
		}
		
		
		//bound..lost
		/*g.setColor(Color.blue);
		g.fillRect(200,00,10,150);
		g.fillRect(800,00,10,500);
		g.fillRect(1200,00,10,500);
		g.fillRect(300,538,10,300);
		g.fillRect(600,438,10,400);*/
		
		if(((x[0]>=160 && x[0]<=239) && (y[0]>=00 && y[0]<=150)) || ((x[0]>=760 && x[0]<=820) && (y[0]>=00 && y[0]<=500))
			||((x[0]>=1160 && x[0]<=1210) && (y[0]>=00 && y[0]<=500)) ||((x[0]>=260 && x[0]<=320) && (y[0]>=538 && y[0]<=838))
		    ||((x[0]>=560 && x[0]<=620) && (y[0]>=440 && y[0]<=880)))
		{
			t.stop();
			s1.setText("GAME OVER YOU LOST");
		}
		
		
		
		
		
		
		//start
		if(start_game)
		{
		
		for(int i=dots;i>0;i--)
		{
		 
		 
			x[i]=x[i-1];
			y[i]=y[i-1];
		  	 
		}
		if(right)
		{
		x[0]=x[0]+20;
		}
		if(left)
		{
		x[0]=x[0]-20;
		}
		if(up)
		{
		y[0]=y[0]-20;
		}
		if(down)
		{
		y[0]=y[0]+20;
		}
		
		//when at rigth end comes from left
		if(x[0]>=1500)
		{
			x[0]=0;
		}
		else if(y[0]>=840)
		{
			y[0]=0;
			
		}
		else if(x[0]<=10)
		{
			x[0]=1480;
			
		}
		else if(y[0]<=10)
		{
			y[0]=840;
			
		}
		
		}
		repaint();
		
	}
	public void keyReleased(KeyEvent e){}
	public void keyPressed(KeyEvent e)
	{
		start_game=true;
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			left=true; right=false; up=false; down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			left=false; right=true; up=false; down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			left=false; right=false; up=true; down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			left=false; right=false; up=false; down=true;
		}
	}
	public void keyTyped(KeyEvent e){}	

}
class SnakeGame
{
  public static void main(String args[]) 
  {
	  
  FDemo f=new FDemo();
  f.setVisible(true);
  f.setSize(1500,950);
  f.setLocation(10,10);
  f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
  
  }
}