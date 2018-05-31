import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

 class CheckOnExit implements WindowListener{
	public CheckOnExit() {
		// TODO Auto-generated constructor stub
	}
	
	public void windowOpened(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {
		ConfirmWindow checkers =new ConfirmWindow();
		checkers.setVisible(true);
	}
	
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
}

class ConfirmWindow extends JFrame implements ActionListener{
	public ConfirmWindow() {
		setSize(300,200);
		getContentPane().setBackground(Color.YELLOW);;
		setLayout(new FlowLayout());
		
		JLabel message =new JLabel("Are you sure to exit?");
		JButton yesButton= new JButton("Yes");
		yesButton.addActionListener(this);
		JButton noButton= new JButton("No");
		noButton.addActionListener(this);
		
		add(message);
		add(yesButton);
		add(noButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCmd =e.getActionCommand();
		if(actionCmd.equals("Yes"))
			System.exit(0);
		else if(actionCmd.equals("No"))
			dispose();
		
	}
}
public class StartRestaurant extends JFrame implements ActionListener{
	public static final int WIDTH =10000;
	public static final int HEIGHT =10000;
	JPanel employeePanel,vipPanel,tablePanel,storagePanel,menusPanel;
	
	public StartRestaurant() {
		super("Restaurant Program");
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new CheckOnExit());
		
	    // 날짜, 마감	버튼
		JLabel date=new JLabel("2018-5-30");
		JButton endButton= new JButton("end");
		JPanel datePanel =new JPanel();
		datePanel.setLayout(new FlowLayout());
		datePanel.add(date);
		datePanel.add(endButton);
		
		//매출 , 잔고, 종료 버튼
		JLabel todayIncome = new JLabel("today: 120 $");
		JLabel totalMoney= new JLabel("total: 15000 $");
		JButton exitButton =new JButton("exit");
		JPanel moneyPanel= new JPanel();
		moneyPanel.setLayout(new GridLayout(3, 1));
		moneyPanel.add(todayIncome);
		moneyPanel.add(totalMoney);
		moneyPanel.add(exitButton);
		
		JPanel topPanel= new JPanel();
		topPanel.setLayout(new GridLayout(1, 2));
		topPanel.add(datePanel);
		topPanel.add(moneyPanel);
		add(topPanel,BorderLayout.NORTH);                
		
		JPanel menuPanel=new JPanel();
		menuPanel.setLayout(new GridLayout(1, 5));
		menuPanel.setBackground(Color.LIGHT_GRAY);
		
		JButton tableButton=new JButton("Table");
		tableButton.setBackground(Color.GRAY);
		tableButton.addActionListener(this);
		menuPanel.add(tableButton);
		
		JButton storageButton=new JButton("Storage");
		storageButton.setBackground(Color.GRAY);
		storageButton.addActionListener(this);
		menuPanel.add(storageButton);
		
		JButton vipButton=new JButton("VIPs");
		vipButton.setBackground(Color.GRAY);
		vipButton.addActionListener(this);
		menuPanel.add(vipButton);
		
		JButton menuButton=new JButton("Menu");
		menuButton.setBackground(Color.GRAY);
		menuButton.addActionListener(this);
		menuPanel.add(menuButton);
		
		JButton employeeButton=new JButton("Employee");
		employeeButton.setBackground(Color.GRAY);
		employeeButton.addActionListener(this);
		menuPanel.add(employeeButton);
		
		add(menuPanel,BorderLayout.CENTER);
		
		vipPanel = new JPanel();
		vipPanel.setLayout(new FlowLayout());
		vipPanel.setBackground(Color.RED);
		JButton aa= new JButton("haha123");
		vipPanel.add(aa);
		//add(vipPanel,BorderLayout.SOUTH);
		vipPanel.setVisible(false);
		
		employeePanel = new JPanel();
		employeePanel.setLayout(new FlowLayout());
		employeePanel.setBackground(Color.BLUE);
		JButton bb= new JButton("haha");
		employeePanel.add(bb);
	//	add(employeePanel);
		employeePanel.setVisible(false);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String btnStr = e.getActionCommand();
		
		if(btnStr.equalsIgnoreCase("Employee")) {
			add(employeePanel,BorderLayout.SOUTH);
			
		}
		else if(btnStr.equalsIgnoreCase("VIPs"))
			vipPanel.setVisible(true);
		//if(btsStr.equals("TableButton"))
		
	}
}
