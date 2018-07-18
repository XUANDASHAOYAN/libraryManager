package window;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import entity.Book;
import db.BaseDao;
import db.ReaderDao;
import db.BookDao;
import entity.Reader;
import util.DateUtils;

public class Return_book {
	TextField booknum,readernum,bookname,readername,bookpublisher,readertype,
	          bookpublish_time,readersex,bookborrow_date,bookreturn_date;
	Frame frame;
	public void return_book() {
		frame = new Frame("借书");
		frame.setBounds(400,400,450,250);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		frame.setLayout(null);
		
		Label l1 = new Label("图书编号");
		booknum = new TextField();
		Label l2 = new Label("读者编号");
		readernum = new TextField();
		Label l3 = new Label("图书名称");
		bookname = new TextField();
		Label l4 = new Label("读者姓名");
		readername = new TextField();
		Label l5 = new Label("出版社");
		bookpublisher = new TextField();
		Label l6 = new Label("读者类别");
		readertype = new TextField();
		Label l7 = new Label("出版时间");
		bookpublish_time = new TextField();
		Label l8 = new Label("读者性别");
		readersex = new TextField();
		Label l9 = new Label("借书日期");
		bookborrow_date = new TextField();
		Label l10 = new Label("还书日期");
		bookreturn_date = new TextField();
		
		l1.setBounds(50,50,50,20);
		frame.add(l1);
		booknum.setBounds(120,50,80,20);
		frame.add(booknum);
		
		booknum.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				tf_book_idKeyTyped(e);
			}
		});
		
		l2.setBounds(250,50,50,20);
		frame.add(l2);
		readernum.setBounds(320,50,80,20);
		frame.add(readernum);
		
		readernum.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				tf_reader_idKeyTyped(e);
			}
		});
		
		l3.setBounds(50,80,50,20);
		frame.add(l3);
		bookname.setBounds(120,80,80,20);
		frame.add(bookname);
		
		l4.setBounds(250,80,50,20);
		frame.add(l4);
		readername.setBounds(320,80,80,20);
		frame.add(readername);
		
		l5.setBounds(50,110,50,20);
		frame.add(l5);
		bookpublisher.setBounds(120,110,80,20);
		frame.add(bookpublisher);
		
		l6.setBounds(250,110,50,20);
		frame.add(l6);
		readertype.setBounds(320,110,80,20);
		frame.add(readertype);
		
		l7.setBounds(50,140,50,20);
		frame.add(l7);
		bookpublish_time.setBounds(120,140,80,20);
		frame.add(bookpublish_time);
		
		l8.setBounds(250,140,50,20);
		frame.add(l8);
		readersex.setBounds(320,140,80,20);
		frame.add(readersex);
		
		l9.setBounds(50,170,50,20);
		frame.add(l9);
		bookborrow_date.setBounds(120,170,80,20);
		frame.add(bookborrow_date);
		
		l10.setBounds(250,170,50,20);
		frame.add(l10);
		bookreturn_date.setBounds(320,170,80,20);
		frame.add(bookreturn_date);
		
		Button cer = new Button("归还");
		Button clo = new Button("关闭");
		cer.setBounds(250,200,60,20);
		clo.setBounds(350,200,60,20);
		frame.add(cer);
		frame.add(clo);
		clo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		cer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_borrowActionPerformed(e);
			}
		});
		
		frame.setVisible(true);
	}
	
	private void tf_book_idKeyTyped(KeyEvent e) {
		if(e.getKeyChar() == '\n') {
			String id = booknum.getText();
			Book book = BookDao.selectBook(id);
			if(book != null) {
				bookname.setText(book.getName());
				bookpublisher.setText(book.getPublisher());
				bookpublish_time.setText(book.getPublish_time().toString());
			}
		}
	}
	private void tf_reader_idKeyTyped(KeyEvent e) {
		if(e.getKeyChar()=='\n') {
			String id  = readernum.getText();
			Reader reader = ReaderDao.selectReader(id);
			if(reader!=null) {
				readername.setText(reader.getName());
				readertype.setText(reader.getType());
				readersex.setText(reader.getSex());
				//设置借书、还书日期
				int days = reader.getMax_num();
				String today = DateUtils.getDate();
				bookborrow_date.setText(today);
				bookreturn_date.setText(DateUtils.getAfterDay(today,days));
			}
		}
	}
	private void btn_borrowActionPerformed(ActionEvent e) {
		String book_id = booknum.getText();
		String reader_id = readernum.getText();
		
		String sql = "update borrow set is_back = 1 where book_id = '"+book_id+"'and reader_id = '"+reader_id+"'";
		int i = BaseDao.executeUpdate(sql);
		if(i!=-1) {
			frame.dispose();
			JOptionPane.showMessageDialog(null,"还书成功");
		}
	}
}
