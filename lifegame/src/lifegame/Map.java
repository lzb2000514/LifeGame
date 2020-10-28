package lifegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;


public class Map extends JPanel implements Runnable{
    public int row, column;
    int [][] generation1;//当前细胞状态图
    int [][] generation2;
    boolean isAdd=false;//标记当前点击点是否需要添加
    boolean isKill=false;//标记当前点击点是否需要删除
    boolean is_start=false;//标记当前是否正在演变
    double speed=1;
    
    public Map(int row,int column)
    {
    	setPreferredSize(new Dimension(row*15,column*15));
    	//this.setBackground(Color.blue);
    	this.column=column;
    	this.row=row;
    	//初始化数组
    	generation1=new int[row][column];
        generation2=new int[row][column];
    	for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				generation1[i][j]=0;
				generation2[i][j]=0;
			}
		}
    	this.setVisible(true);
    }
	
	public void paintComponent(Graphics g)
	{	
		super.paintComponent(g);
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				if(generation1[i][j]==1)
				{
					g.setColor(Color.BLACK);
					g.fillRect((j)*15, (i)*15, 15, 15);
				}
				else
				{
					g.setColor(Color.BLACK);
					g.drawRect((j)*15, (i)*15, 15, 15);
				}
				
			}
		}
	}
	
	@Override
	public void run() {
		while(true)
		{
			synchronized(this)
			{
				if(is_start)
				{
				sleep(speed);
				
				generation2=Algorithm.calnextGeneration(generation1, row, column);
				generation1=generation2;
				repaint();
				}
				else
				{
					try
					{
						this.wait();
					}catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	/*
	 * 刷新时间控制
	 */
	private void sleep(double x)
	{
		try {
			Thread.sleep((long) (500*x));
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
	
	//设置临时图像
	public void setTempMap()
	{
		is_start=false;
		synchronized(this)
		{
			repaint();
		}
	}
	
	//随机生成细胞图像
	public void setRandom()
	{
		Random a=new Random();
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				int aa=Math.abs(a.nextInt(7));
				if(aa==0){
					generation1[i][j]=1; 	
				}else{
					generation1[i][j]=0;
				}
			}
		}
		setTempMap();
	}
	
	//清空所有细胞
	public void clearAll()
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
				generation1[i][j]=0;
			}
		}
		setTempMap();
	}
	
	//进行单步演变
	public void setNext()
	{
		generation1=Algorithm.calnextGeneration(generation1, row, column);
		setTempMap();
	}
	
	//进行开始演变
	public void start()
	{
		synchronized(this)
		{
			is_start=true;
			this.notifyAll();
		}
		
	}
	
}

