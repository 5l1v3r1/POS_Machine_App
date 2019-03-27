import java.awt.GridLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Table extends JPanel {
 
	public Table()
	{
	
		//테이블 패널 생성 
		JPanel tpanel=new JPanel();
		tpanel.setLayout(new GridLayout(2,4));
		//테이블 버튼 및레이블 생성 
		JButton[] tabelb=new JButton[8];
		JLabel[] label=new JLabel[8];
		
		for(int i=0;i<8;i++)
		{
			String tt="테이블"+i;
			String ts="t"+i;
			String tl=""+i;
			tabelb[i]=new JButton(tt);
			tabelb[i].setActionCommand(ts);
			tabelb[i].setSize(30,50);
			label[i]=new JLabel(tl);
			tabelb[i].add(label[i]);
			tpanel.add(tabelb[i]);
		}
		
		//추가 결제 버튼 생성 및 그에 대한 패널
		JPanel ordpanel=new JPanel();
		JButton add=new JButton("추가 ");
		add.setActionCommand("add");
		JButton pay= new JButton("결제 ");
		pay.setActionCommand("pay");
		ordpanel.add(add);
		ordpanel.add(pay);
		
		//메뉴 가격 표 생성 및 그에대한 패널
		JPanel chartpanel=new JPanel();
		String title[] = {"번호","메뉴 ","가격 "};
		String data[][] = {
		            {"1","치즈버거 ","1000"},
		            {"2","불고기버거 ","1200"},
		            {"3","데리버거 ","1500"},
		     };
		JTable table = new JTable(data, title);
		JScrollPane sp = new JScrollPane(table); 
		chartpanel.add(sp);
		
		
		add(chartpanel);
		add(tpanel);
		add(ordpanel);
		
		
	}
}
