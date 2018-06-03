import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Employee extends JPanel implements ActionListener{
	private int id;
	private String name;
	private double pay;
	private String position;
	private String date_in;
	private String phone;
	private static int cnt =0;
	
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
		//JTextField datefield = new JTextField(10);
		JTextField phonefield = new JTextField(10);
		
		panel.add(numberfield);
		panel.add(namefield);
		panel.add(payfield);
		panel.add(positionfield);
		//panel.add(datefield);
		panel.add(phonefield);
		
		
		/* 파일에 저장된 직원들 불러오기 */
		File file =new File("employee.txt");
		if(file.exists()) {
			String line;
			String inputStr[] =new String[6];
			StringTokenizer st;
			Scanner inputStream= null;
			
			try {
				inputStream= new Scanner(new FileInputStream("employee.txt"));
			}
			catch(FileNotFoundException er) {
				er.printStackTrace();
			}
			
			while(inputStream.hasNextLine()) {
				int i=0;
				line = inputStream.nextLine();
				st= new StringTokenizer(line, " ");
				while(st.hasMoreTokens()) {
					inputStr[i++]=st.nextToken();
				}
				model.addRow(inputStr);
			}
		}
		
		
		JButton addBtn =new JButton("추가");
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				PrintWriter outputStream = null;
				String inputStr[] =new String[6];
			
				try {
					String fileName ="employee.txt";
					outputStream =new PrintWriter(new FileOutputStream(fileName,true));	
				}
						
				catch(FileNotFoundException er){
					System.out.println("Error opening employee.txt");
					er.printStackTrace();
				}
				
				inputStr[0]= numberfield.getText();
				outputStream.print(inputStr[0]+" ");
				inputStr[1]= namefield.getText();
				outputStream.print(inputStr[1]+" ");
				inputStr[2]= payfield.getText();
				outputStream.print(inputStr[2]+" ");
				inputStr[3]= positionfield.getText();
				outputStream.print(inputStr[3]+" ");
				SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyy.MM.dd", Locale.KOREA );
				Date currentTime = new Date ();
				String mTime = mSimpleDateFormat.format ( currentTime );
				inputStr[4]= mTime;
				outputStream.print(inputStr[4]+" ");
				inputStr[5]= phonefield.getText();
				outputStream.println(inputStr[5]);
				
				outputStream.close();
				
				model.addRow(inputStr);
		
				numberfield.setText("");
				namefield.setText("");
				payfield.setText("");
				positionfield.setText("");
				//datefield.setText("");
				phonefield.setText("");
				
			}
		});
		
		JButton delBtn = new JButton("삭제");
		delBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(table.getSelectedRow());
				if(table.getSelectedRow() == -1)
					return;
				else {
					Scanner inputStream= null;
					PrintWriter outputStream =null;
					
					try {
						inputStream= new Scanner(new FileInputStream("employee.txt"));
						outputStream =new PrintWriter(new FileOutputStream("temp.txt",true));	
					}
					catch(FileNotFoundException er){
						er.printStackTrace();
					}
					
					int i=0,cnt=0;
					while(inputStream.hasNextLine() ) {
						if(i !=  table.getSelectedRow()) {
							String line = inputStream.nextLine();
							outputStream.println(line);
						}
						else
							inputStream.nextLine();
						i++;	
					}
					outputStream.close();
					
					File file =new File("employee.txt");
					file.delete();
					file =new File("temp.txt");
					File dest =new File("employee.txt");
					file.renameTo(dest);
					
					model.removeRow(table.getSelectedRow());
				}
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