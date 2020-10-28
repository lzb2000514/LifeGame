package lifegame;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.junit.Test;

public class MainTest {
	@Test
	public void test1() {//���԰�ť�Ƿ�ɹ�����
		Main m=new Main();
		boolean[] flag=new boolean[7];//����߸���ť�Ƿ񱻳ɹ�����
		if(m.button!=null)
			flag[0]=true;
		if(m.button_1!=null)
			flag[1]=true;
		if(m.button_2!=null)
			flag[2]=true;
		if(m.button_3!=null)
			flag[3]=true;
		if(m.button_4!=null)
			flag[4]=true;
		if(m.button_5!=null)
			flag[5]=true;
		if(m.button_6!=null)
			flag[6]=true;
		//�Խ����һ���
		for(int i=0;i<7;i++)
		{
			assertEquals(true,flag[i]);
		}
	}
	
	@Test
	public void test2() {//���԰�ť�ļ��������Ƿ�����ʵ��
		Main m=new Main();
		boolean[] flag=new boolean[7];//����߸���ť�ļ����Ƿ�����ʵ��
		//��ʼ��
		for(int i=0;i<7;i++)
		{
			flag[i]=false;
		}
		//ģ���һ����ť
		m.button.doClick();
		if(m.button.getBackground()==Color.PINK)
		{
			flag[0]=true;
		}
		//ģ��ڶ�����ť
		m.button_1.doClick();
		if(m.button_1.getBackground()==Color.PINK)
		{
			flag[1]=true;
		}
		//ģ���������ť
		m.button_2.doClick();
		if(m.button_2.getBackground()==Color.PINK)
		{
			flag[2]=true;
		}
		//ģ����ĸ���ť
		m.button_3.doClick();
		if(m.button_3.getBackground()==Color.PINK)
		{
			flag[3]=true;
		}
		//ģ��������ť
		m.button_4.doClick();
		if(m.button_4.getBackground()==Color.PINK)
		{
			flag[4]=true;
		}
		//ģ���������ť
		m.button_5.doClick();
		if(m.button_5.getBackground()==Color.PINK)
		{
			flag[5]=true;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ģ����߸���ť
		m.button_6.doClick();
		if(m.button_6.getBackground()==Color.PINK)
		{
			flag[6]=true;
		}
		//�Խ����һ���
		for(int i=0;i<7;i++)
		{
			assertEquals(true,flag[i]);
		}
	}
	
	@Test
	public void test3() {
		Main m=new Main();
		m.comboBox.setSelectedIndex(2);//ģ��������ֵΪ2
		boolean flag=true;
		if(m.comboBox.getSelectedIndex()!=2)
			flag=false;
		assertEquals(true,flag);
	}
	
	@Test 
	public void test4() throws AWTException {
		
		Main m=new Main();
		Robot robot = new Robot();
		m.button.doClick();//ģ������Ӱ�ť
		robot.mouseMove(500, 500);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.delay(100);
		boolean flag=false;
		for(int i=0;i<m.map.row;i++)
		{
			for(int j=0;j<m.map.column;j++)
			{
				if(m.map.generation1[i][j]==1)
					flag=true;
			}
		}
		assertEquals(true,flag);
	}
	
	@Test
	public void test5() {
		Main m=new Main();
		boolean flag=true;
		for(int i=0;i<m.map.row;i++)
		{
			for(int j=0;j<m.map.column;j++)
			{
				if(m.map.generation1[i][j]!=0
						||m.map.generation2[i][j]!=0)
					flag=false;
			}
		}
		assertEquals(true,flag);
	}

}
