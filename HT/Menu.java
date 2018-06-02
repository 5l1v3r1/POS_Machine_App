import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.TextArea;
 
// 두 번째 탭
public class Menu extends JPanel
{
    public Menu(){
        String title[] = {"번호","음식 종류 "};
        String info[][]= {{"1","불고기버거 "},
        		{"2","치즈버거 "}
        };
         // 테이블 생성
         JTable table=new JTable(info,title);
//       table.setValueAt("치즈버거  ", 0, 0);
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
     }
    
    
    public void actionPerformed(ActionEvent e) {
		String btnStr = e.getActionCommand();
		
		
	}
 
}

