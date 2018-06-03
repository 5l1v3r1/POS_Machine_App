import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class addWindow extends JFrame implements ActionListener{
	public addWindow() {
		setSize(800,400);
		getContentPane().setBackground(Color.YELLOW);;
		setLayout(new FlowLayout());
		
		JLabel message =new JLabel("새 직원의 정보를 입력하세요");
		JButton yesButton= new JButton("저장");
		yesButton.setActionCommand("exit_yes");
		yesButton.addActionListener(this);
		JButton noButton= new JButton("취소");
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
			dispose();
		else if(actionCmd.equals("exit_no"))
			dispose();
		
	}
}

public class Employee extends JPanel implements ActionListener{
	private int id;
	private String name;
	private double pay;
	private String position;
	private String date_in;
	private String phone;
	
	public Employee() {
		String title[] = {"번호", "이름" ,"급여","직급", "입사일", "연락처"};
		String info[][]= {
		};
		DefaultTableModel model = new DefaultTableModel(info,title);
		JTable table= new JTable(model);
		JScrollPane sp= new JScrollPane(table);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
		
		JTextField numberfield =new JTextField(5);
		JTextField namefield = new JTextField(5);
		JTextField payfield = new JTextField(5);
		JTextField positionfield = new JTextField(5);
		JTextField datefield = new JTextField(10);
		JTextField phonefield = new JTextField(10);
		
		panel.add(numberfield);
		panel.add(namefield);
		panel.add(payfield);
		panel.add(positionfield);
		panel.add(datefield);
		panel.add(phonefield);
		
		JButton addBtn =new JButton("추가");
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String inputStr[] =new String[6];
				
				inputStr[0]= numberfield.getText();
				inputStr[1]= namefield.getText();
				inputStr[2]= payfield.getText();
				inputStr[3]= positionfield.getText();
				inputStr[4]= datefield.getText();
				inputStr[5]= phonefield.getText();
				model.addRow(inputStr);
				
				numberfield.setText("");
				namefield.setText("");
				payfield.setText("");
				positionfield.setText("");
				datefield.setText("");
				phonefield.setText("");
				
			}
		});
		
		JButton delBtn = new JButton("삭제");
		delBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(table.getSelectedRow() == -1)
					return;
				else
					model.removeRow(table.getSelectedRow());
			}
		});
		
	    panel.add(addBtn);
		panel.add(delBtn);
		
		add(sp,BorderLayout.CENTER);
		add(panel,BorderLayout.SOUTH);
		
		/*
		JPanel addPanel=new JPanel();
        JButton addbutton=new JButton("추가 ");
        addbutton.setActionCommand("add");
        addbutton.addActionListener(this);
        addPanel.add(addbutton);
        // 상세정보창 패널 생성
        JPanel infoPanel=new JPanel();
        //상세정보창 버튼 패널 및 버튼 생성 
        JPanel infobuttonPanel=new JPanel();
        JButton fixbutton=new JButton("편집 ");
        fixbutton.addActionListener(this);
        fixbutton.setActionCommand("fix");
        JButton delbutton=new JButton("삭제 ");
        delbutton.setActionCommand("del");
        delbutton.addActionListener(this);
        infobuttonPanel.setLayout(new FlowLayout());
        infobuttonPanel.add(fixbutton);
        infobuttonPanel.add(delbutton);
        //상세정보창 텍스트에리어 생성
      
        infoPanel.add(infobuttonPanel);
        
        add(sp);  
        add(infoPanel);
        add(addPanel);*/
		
	}
	  


	public void actionPerformed(ActionEvent e) {
		String btnStr = e.getActionCommand();
		
		if(btnStr.equals("add")) {
			addWindow checkers =new addWindow();
			checkers.setVisible(true);
		}
	}
	
}