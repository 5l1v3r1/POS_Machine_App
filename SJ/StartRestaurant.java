import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

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
		yesButton.setActionCommand("exit_yes");
		yesButton.addActionListener(this);
		JButton noButton= new JButton("No");
		noButton.setActionCommand("exit_no");
		noButton.addActionListener(this);
		
		add(message);
		add(yesButton);
		add(noButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCmd =e.getActionCommand();
		if(actionCmd.equals("exit_yes"))
			System.exit(0);
		else if(actionCmd.equals("exit_no"))
			dispose();
		
	}
}

class Bye extends JFrame implements ActionListener{
	public Bye() {
		setSize(300,200);
		getContentPane().setBackground(Color.YELLOW);;
		setLayout(new FlowLayout());
		
		JLabel message =new JLabel("Are you sure to exit?");
		JButton yesButton= new JButton("Yes");
		yesButton.setActionCommand("exit_yes");
		yesButton.addActionListener(this);
		JButton noButton= new JButton("No");
		noButton.setActionCommand("exit_no");
		noButton.addActionListener(this);
		
		add(message);
		add(yesButton);
		add(noButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCmd =e.getActionCommand();
		if(actionCmd.equals("exit_yes"))
			System.exit(0);
		else if(actionCmd.equals("exit_no"))
			dispose();
		
	}
}
public class StartRestaurant extends JFrame implements ActionListener{
	public static final int WIDTH =1100;
	public static final int HEIGHT =600;
	JPanel employeePanel,vipPanel,tablePanel,storagePanel,menusPanel;
	
	public StartRestaurant() {
		super("Restaurant Program");
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new CheckOnExit());
		
	    // 날짜, 마감	버튼
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd ", Locale.KOREA );
		Date currentTime = new Date ();
		String mTime = mSimpleDateFormat.format ( currentTime );
		System.out.println ( mTime );


		JLabel date=new JLabel(mTime);
		//마감 
		JButton endButton= new JButton("마감 ");
		JPanel datePanel =new JPanel();
		datePanel.setLayout(new FlowLayout());
		datePanel.add(date);
		datePanel.add(endButton);
	
		
		//매출 , 잔고, 종료 버튼
		JLabel todayIncome = new JLabel("오늘 매출 : 120 $");
		JLabel totalMoney= new JLabel("전체 잔고 : 15000 $");
		//종료
		JButton exitButton =new JButton("종료 ");
		exitButton.setActionCommand("exit");
		exitButton.setSize(50,50);
		exitButton.addActionListener(this);
		JPanel moneyPanel= new JPanel();
		moneyPanel.setLayout(new GridLayout(3,1));
		moneyPanel.add(todayIncome);
		moneyPanel.add(totalMoney);
		moneyPanel.add(exitButton);
		moneyPanel.setSize(100,50);
		
		//메뉴 탭 //다른 클래스의 내용을 추가시켜줄 경우 그 쪽의세부요소를 직접 넣어주자.
		JPanel tabPanel=new JPanel();
		TapMenu menu=new TapMenu();
		JTabbedPane tab=menu.getTab();
		
		tabPanel.setLayout(new BorderLayout());
		tabPanel.add(tab);
		tabPanel.setSize(500, 500);
		add(tabPanel,BorderLayout.CENTER);
		
		JPanel topPanel= new JPanel();
		topPanel.setLayout(new GridLayout(1, 2));
		topPanel.add(datePanel);
		topPanel.add(moneyPanel);
		add(topPanel,BorderLayout.NORTH);  
		
		
		/*JPanel menuPanel=new JPanel();
		menuPanel.setLayout(new GridLayout(1, 5));
		menuPanel.setBackground(Color.LIGHT_GRAY);*/
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String btnStr = e.getActionCommand();
		if(btnStr.equalsIgnoreCase("exit")) {
			Bye exBye=new Bye();
			exBye.setVisible(true);
		}
		
		if(btnStr.equalsIgnoreCase("Employee")) {
			add(employeePanel,BorderLayout.SOUTH);
		}
		else if(btnStr.equalsIgnoreCase("VIPs"))
			vipPanel.setVisible(true);
		//if(btsStr.equals("TableButton"))
		
	}
}