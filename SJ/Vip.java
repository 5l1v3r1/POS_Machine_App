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


public class Vip extends JPanel implements ActionListener{
	private int id;
	private String name;
	private double pay;
	private String position;
	private String date_in;
	private String phone;
	
	public Vip() {
		String title[] = {"번호", "등급" ,"이름","마일리지",  "연락처"};
		String info[][]= {
		};
		DefaultTableModel model = new DefaultTableModel(info,title);
		JTable table= new JTable(model);
		JScrollPane sp= new JScrollPane(table);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
		
		JTextField numberfield =new JTextField(5);
		JTextField levelfield = new JTextField(5);
		JTextField namefield = new JTextField(5);
		JTextField mileagefield = new JTextField(5);
		JTextField phonefield = new JTextField(10);
		
		panel.add(numberfield);
		panel.add(levelfield);
		panel.add(namefield);
		panel.add(mileagefield);
		panel.add(phonefield);
		
		JButton addBtn =new JButton("추가");
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String inputStr[] =new String[5];
				
				inputStr[0]= numberfield.getText();
				inputStr[1]= levelfield.getText();
				inputStr[2]= namefield.getText();
				inputStr[3]= mileagefield.getText();
				inputStr[4]= phonefield.getText();
				model.addRow(inputStr);
				
				numberfield.setText("");
				namefield.setText("");
				mileagefield.setText("");
				levelfield.setText("");
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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}