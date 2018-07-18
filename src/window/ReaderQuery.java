package window;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import db.BaseDao;
import db.ReaderDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import entity.Reader;

import javax.swing.JTable;
import db.ReaderDao;
import javax.swing.table.JTableHeader;
public class ReaderQuery {
	TextField readernum;
	private String heads[] = {"读者编号","读者姓名","读者类别","性别","最大可借数量","可借天数"};
	Frame f;
	public void readerQueryInterface() {
		f = new Frame("读者查询");
		f.setBounds(400,400,450,250);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
		
		f.setLayout(null);
		
		Label l1 = new Label("读者编号");
		readernum = new TextField();
		Button b1 = new Button("查询");
		Button b2 = new Button("关闭");
		
		l1.setBounds(80,30,50,20);
		f.add(l1);
		readernum.setBounds(150,30,130,20);
		f.add(readernum);
		b1.setBounds(300,30,80,20);
		f.add(b1);
		b2.setBounds(580,210,80,20);
		f.add(b2);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_cxActionPerformed(e);
			}
		});
		
		init();
		f.setVisible(true);
	}
	
	private void init() {
		String id = readernum.getText();
		String sql = "select * from reader";
		
		Object[][] results = getResults(ReaderDao.selectReaderList(sql));
		JTable table = new JTable(results,heads);
		JTableHeader head = table.getTableHeader();
		
		f.add(head);
		head.setBounds(8,62,680,20);
		f.add(table);
		table.setBounds(8,82,680,150);	
	}
	
	private void btn_cxActionPerformed(ActionEvent e) {
		String id = readernum.getText();
		String sql = "select * from reader";//没有输入编号时仍显示所有读者信息
		if(id != null && id.length()>0) {
			sql = "select * from reader where id = '"+id+"'";
		}
		
		Object[][] results = getResults(ReaderDao.selectReaderList(sql));
		JTable table = new JTable(results,heads);
		JTableHeader head = table.getTableHeader();
		
		f.add(head);
		head.setBounds(8,62,680,20);
		f.add(table);
		table.setBounds(8,82,680,150);	
	}
	private Object[][] getResults(List list){
		Object Results[][] = new Object[list.size()][heads.length];
		for(int i=0;i<list.size();i++) {
			Reader reader = (Reader) list.get(i);
			Results[i][0] = reader.getId();
			Results[i][1] = reader.getName();
			Results[i][2] = reader.getType();
			Results[i][3] = reader.getSex();
			Results[i][4] = reader.getMax_num();
			Results[i][5] = reader.getDays_num();
		}
		return Results;
	}
}
