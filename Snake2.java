import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class FDemo1 extends JFrame
{JPDemo1 jp;
	FDemo1()
	{
		super.setTitle("Snake Game level-1");
		jp=new JPDemo1();
		add(jp);
		
	}
}
class JPDemo1 extends JPanel implements ActionListener,KeyListener
{
int tt=200;
JLabel s1;
ImageIcon img1,img2,img3;
Image dot,head,food;
int dots=5;	
int x[]=new int[100];
int y[]=new int[100];
int r1=0,r2=0;
boolean Start_game=false;
boolean left=false,right=true,up=false,down=false;
Timer t;


	JPDemo1()
	{   
	setLayout(null);
		x[0]=100;
		y[0]=100;
		
		x[1]=80;
		y[1]=100;
		
		x[2]=60;
		y[2]=100;
		
		x[3]=40;
		y[3]=100;
		
		x[4]=20;
		y[4]=100;
		
		Font f=new Font("",Font.BOLD,50);
	s1=new JLabel();
	s1.setBackground(Color.black);
	s1.setForeground(Color.red);
	s1.setBounds(250,250,700,50);
	s1.setFont(f);
	add(s1);
		Color c1=new Color(132,0,20);
		setBackground(c1);
		
		img1=new ImageIcon("head1.png");
		head=img1.getImage();
		img2=new ImageIcon("dot.png");
		dot=img2.getImage();
		img3=new ImageIcon("food.png");
		food=img3.getImage();
		
		 t=new Timer(tt,this);
		t.start();
		
		random();
		setFocusable(true);
		addKeyListener(this);
		
	}
	void random()
	{
		r1=(int)Math.round(Math.random()*50+1);
		r1=r1*20;
		r2=(int)Math.round(Math.random()*39+1);
		r2=r2*20;
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.fillRect(5,0,10,900);
		g.fillRect(0,0,1500,10);
		g.fillRect(1490,0,10,880);
		g.fillRect(0,865,1500,10);
		
		
		g.drawImage(food,r1,r2,this);
	
	  for(int i=0;i<dots;i++)
	  {
		if(i==0)
		{
		g.drawImage(head,x[i],y[i],this);
		}else{
		g.drawImage(dot,x[i],y[i],this);
		}
	  }
	}
	  public void keyReleased(KeyEvent e){}
	  public void keyPressed(KeyEvent e)
	  {
		  Start_game=true;
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			left=true;right=false;up=false;down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			left=false;right=true;up=false;down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			left=false;right=false;up=true;down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			left=false;right=false;up=false;down=true;
		}
				
	  }
	  public void keyTyped(KeyEvent e){}
	 
	
	
	public void actionPerformed(ActionEvent e)
	{  
	if(r1==x[0] && r2==y[0])
		{
			dots++;
			if(dots%5==0){t=new Timer(tt-30,this);t.start();}
			random();
		}
		if(Start_game)
		{
		for(int i=dots;i>0;i--)
		{
			x[i]=x[i-1];
			y[i]=y[i-1];
		
		}
		
			if(left)
			{x[0]=x[0]-20;}
			if(right)
			{x[0]=x[0]+20;}
			if(up)
			{y[0]=y[0]-20;}
			if(down)
			{y[0]=y[0]+20;}
		if((x[0]>=1400 && y[0]>=0) || (x[0]>=0 && y[0]>=880) || (x[0]>=0 && y[0]<=10)|| (x[0]<=10 && y[0]>=0))
		{  t.stop();
	    s1.setText("GAME OVER YOU LOST");
		}
		
		   
		  
		 
		 }
		repaint();
	}
	
	
}
class Snake2
{
	public static void main(String arg[])
	{
	FDemo1 f=new FDemo1();
	f.setVisible(true);
	f.setSize(1520,920);
	f.setLocation(10,10);
	f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
}
