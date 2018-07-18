package window;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import db.BookDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import entity.Book;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
public class BookQuery {
	TextField booknum;
	private String heads[] = {"图书编号","图书名称","图书类别","作者","译者","出版社","出版日期","价格","库存数量"};
	Frame f;
	public void bookQueryInterface() {
		f = new Frame("图书查询");
		f.setBounds(400,400,680,250);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
		
		f.setLayout(null);
		
		
		Label l1 = new Label("图书编号");
		booknum = new TextField();
		Button b1 = new Button("查询");
		Button b2 = new Button("关闭");
		
		l1.setBounds(80,30,50,20);
		f.add(l1);
		booknum.setBounds(150,30,130,20);
		f.add(booknum);
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
	
	private void init()
	  {
		String sql = "select * from book";
		Object results[][] = getResults(BookDao.selectBookList(sql));
	    JTable table = new JTable(results , heads);
	    JTableHeader head = table.getTableHeader();
	    
	    f.add(head);
		head.setBounds(8,62,680,20);
		f.add(table);
		table.setBounds(8,82,680,150);
	  }
	
	private void btn_cxActionPerformed(ActionEvent e) {
		String id = booknum.getText();
	    String sql = "select * from book";
	    if(id != null && id.length() >0) {
	    	sql = "select * from book where id = '"+id+"'";
	    }
		Object results[][] = getResults(BookDao.selectBookList(sql));
		JTable table = new JTable(results,heads);
		JTableHeader head = table.getTableHeader();
		
		f.add(head);
		head.setBounds(8,62,680,20);
		f.add(table);
		table.setBounds(8,82,680,150);
	}
	private Object[][] getResults(List<Book> list){
		Object Results[][] = new Object[list.size()][heads.length];
		for(int i=0;i<list.size();i++) {
			Book book = (Book) list.get(i);
			Results[i][0] = book.getID();
			Results[i][1] = book.getName();
			Results[i][2] = book.getType();
			Results[i][3] = book.getAuthor();
			Results[i][4] = book.getTranslator();
			Results[i][5] = book.getPublisher();
			Results[i][6] = book.getPublish_time();
			Results[i][7] = book.getPrice();
			Results[i][8] = book.getStock();
		}
		return Results;
	}
}
