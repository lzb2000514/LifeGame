package lifegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JSlider;


import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Main extends JFrame{

	public Map map;
	private static JPanel button_panel1;
	private static JPanel button_panel2;
	public JButton button=null;
	public JButton button_1=null;
	public JButton button_2=null;
	public JButton button_3=null;
	public JButton button_4=null;
	public JButton button_5=null;
	public JButton button_6=null;
	public JComboBox comboBox;
	private static JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Main();
	}

	/**
	 * Create the application.
	 */
	public Main() {
		
		map = new Map(40,40);
		map.setLayout(null);
		map.setBounds(130, 0, 40*15+1, 40*15+1);
		map.setBackground(Color.WHITE);
		map.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(map.isAdd)
				{
					int x=e.getX();
					int y=e.getY();
					map.generation1[(int)((y-y%15)/15)][(int)((x-x%15)/15)]=1;
					map.setTempMap();
				}
				else if(map.isKill)
				{
					int x=e.getX();
					int y=e.getY();
					map.generation1[(int)((y-y%15)/15)][(int)((x-x%15)/15)]=0;
					map.setTempMap();
				}	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		    @Override
			public void mouseReleased(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
        });
        add(map);
        new Thread(map).start();
		this.setBounds(100, 100, 900, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//添加第一套按钮
		control1(); 
		//添加第二套按钮
		control2();
		this.setVisible(true);
		//解决鼠标滑过才能显示按钮的问题
		
		button.requestFocus();
		button_1.requestFocus();
		button_2.requestFocus();
		button_3.requestFocus();
		
		button_4.requestFocus();
		button_5.requestFocus();
		button_6.requestFocus();
		lblNewLabel.setText("调整速度");
		lblNewLabel.requestFocus();
		lblNewLabel.repaint();
		comboBox.requestFocus();
		
		//设置按钮初始颜色
		button.setBackground(Color.WHITE);
		button_1.setBackground(Color.WHITE);
		button_2.setBackground(Color.WHITE);
		button_3.setBackground(Color.WHITE);
		button_4.setBackground(Color.WHITE);
		button_5.setBackground(Color.WHITE);
		button_6.setBackground(Color.WHITE);
		
	}

	/*
	 * control1()方法实现对第一组按钮的设置和监听
	 */
	public void control1(){
		//添加细胞监听
		button_panel1=new JPanel();
		button = new JButton("\u6DFB\u52A0\u7EC6\u80DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button.setBackground(Color.PINK);
				button_1.setBackground(Color.WHITE);
				button_2.setBackground(Color.WHITE);
				button_3.setBackground(Color.WHITE);
				button_4.setBackground(Color.WHITE);
				button_5.setBackground(Color.WHITE);
				button_6.setBackground(Color.WHITE);
				map.isAdd=true;
				map.isKill=false;
			}
		});
		button.setBounds(14, 26, 93, 44);
		button_panel1.add(button);
		
		//删除细胞监听
		button_1 = new JButton("\u5220\u9664\u7EC6\u80DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button.setBackground(Color.WHITE);
				button_1.setBackground(Color.PINK);
				button_2.setBackground(Color.WHITE);
				button_3.setBackground(Color.WHITE);
				button_4.setBackground(Color.WHITE);
				button_5.setBackground(Color.WHITE);
				button_6.setBackground(Color.WHITE);
				map.isAdd=false;
				map.isKill=true;
			}
		});
		button_1.setBounds(14, 98, 93, 44);
		button_panel1.add(button_1);
		
		//随机生成界面监听
		button_2 = new JButton("\u968F\u673A\u751F\u6210");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button.setBackground(Color.WHITE);
				button_1.setBackground(Color.WHITE);
				button_2.setBackground(Color.PINK);
				button_3.setBackground(Color.WHITE);
				button_4.setBackground(Color.WHITE);
				button_5.setBackground(Color.WHITE);
				button_6.setBackground(Color.WHITE);
				map.isAdd=false;
				map.isKill=false;
				map.setRandom();
			}
		});
		button_2.setBounds(14, 169, 93, 44);
		button_panel1.add(button_2);
		
		//清空界面监听
		button_3 = new JButton("\u6E05\u7A7A\u754C\u9762");
		button_3.setBounds(14, 244, 93, 44);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button.setBackground(Color.WHITE);
				button_1.setBackground(Color.WHITE);
				button_2.setBackground(Color.WHITE);
				button_3.setBackground(Color.PINK);
				button_4.setBackground(Color.WHITE);
				button_5.setBackground(Color.WHITE);
				button_6.setBackground(Color.WHITE);
				map.isAdd=false;
				map.isKill=false;
				map.clearAll();
			}
		});
		button_panel1.add(button_3);

		button_panel1.setLayout(null);
		button_panel1.setBounds(0, 0, 120, 1000);
		add(button_panel1);
		
	}
	
	/*
	 * control2()方法实现对第二组按钮的设置和监听
	 */
	public void control2(){
		button_panel2=new JPanel();
		//单代演变监听
		button_4 = new JButton("\u5355\u4EE3\u6F14\u53D8");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button.setBackground(Color.WHITE);
				button_1.setBackground(Color.WHITE);
				button_2.setBackground(Color.WHITE);
				button_3.setBackground(Color.WHITE);
				button_4.setBackground(Color.PINK);
				button_5.setBackground(Color.WHITE);
				button_6.setBackground(Color.WHITE);
				map.isAdd=false;
				map.isKill=false;
				map.setNext();
			}
		});
		button_4.setBounds(750, 26, 93, 44);
		button_panel2.add(button_4);
		
		//开始演变监听
		button_5 = new JButton("\u5F00\u59CB\u6F14\u53D8");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button.setBackground(Color.WHITE);
				button_1.setBackground(Color.WHITE);
				button_2.setBackground(Color.WHITE);
				button_3.setBackground(Color.WHITE);
				button_4.setBackground(Color.WHITE);
				button_5.setBackground(Color.PINK);
				button_6.setBackground(Color.WHITE);
				map.isAdd=false;
				map.isKill=false;
				map.is_start=true;
				//map.speed=comboBox.getSelectedIndex();
				map.start();
			}
		});
		button_5.setBounds(750, 98, 93, 44);
		button_panel2.add(button_5);
		
		//暂停演变监听
		button_6 = new JButton("\u6682\u505C\u6F14\u53D8");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button.setBackground(Color.WHITE);
				button_1.setBackground(Color.WHITE);
				button_2.setBackground(Color.WHITE);
				button_3.setBackground(Color.WHITE);
				button_4.setBackground(Color.WHITE);
				button_5.setBackground(Color.WHITE);
				button_6.setBackground(Color.PINK);
				map.isAdd=false;
				map.isKill=false;
				map.is_start=false;
			}
		});
		button_6.setBounds(750, 169, 93, 44);
		button_panel2.add(button_6);
		
		String[] s= {"1","2","3","4","5","6","7","8","9"};
		comboBox = new JComboBox(s);
		comboBox.setBounds(813, 251, 37, 31);
		comboBox.addItemListener(new ItemListener()
				{
					public void itemStateChanged(ItemEvent event)
					{
						map.speed=1.1-(comboBox.getSelectedIndex()+1)*0.1;
					}
				});
		button_panel2.add(comboBox);
		
		lblNewLabel = new JLabel("调整速度");
		lblNewLabel.setPreferredSize(new Dimension(65,37));
		lblNewLabel.setBounds(750, 248, 65, 37);
		
		button_panel2.add(lblNewLabel);
		
		lblNewLabel.repaint();
		button_panel2.setLayout(null);
		button_panel2.setBounds(750, 0, 150, 1000);
		add(button_panel2);
	}
	
	
}
