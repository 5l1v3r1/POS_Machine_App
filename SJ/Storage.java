import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.TextArea;

	
public class Storage extends JPanel { 
	// 첫 번째 탭 
	public Storage()
	{
	    String title[] = {"번호","이름 ", "재고 ", "주문 ","가격 "};
	    String data[][] = {
	            {"1","빵 ","10", "주문완료 ","100"},
	            {"2","패티 ","10", "주문완료 ", "100"},
	            {"3","치즈 ","10","주문완료 " ,"26"}
	     };
	     // 테이블 생성
	    JTable table = new JTable(data, title);
	    JScrollPane sp = new JScrollPane(table); 
	 // 추가버튼 패널생성
        JPanel addPanel=new JPanel();
        JButton addbutton=new JButton("추가 ");
        addbutton.setActionCommand("add");
        addPanel.add(addbutton);
        // 상세정보창 패널 생성
        JPanel infoPanel=new JPanel();
        //상세정보창 버튼 패널 및 버튼 생성 
        JPanel infobuttonPanel=new JPanel();
        JButton fixbutton=new JButton("편집 ");
        fixbutton.setActionCommand("fix");
        JButton delbutton=new JButton("삭제 ");
        delbutton.setActionCommand("del");
        infobuttonPanel.setLayout(new FlowLayout());
        infobuttonPanel.add(fixbutton);
        infobuttonPanel.add(delbutton);
        //상세정보창 텍스트에리어 생성
        TextArea infoprint=new TextArea(10,40);
        infoprint.setText("test case");
        infoPanel.add(infoprint);
        infoPanel.add(infobuttonPanel);
	    add(sp);  
	    add(infoPanel);
	    add(addPanel);
	  ;
	}
}
