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

public class Borrow_book {
	TextField booknum,readernum,bookname,readername,bookpublisher,readertype,
	          bookpublish_time,readersex,bookborrow_date,bookreturn_date;
	Frame frameborrow;
	public void borrow_book() {
		frameborrow = new Frame("����");
		frameborrow.setBounds(400,400,450,250);
		frameborrow.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frameborrow.dispose();
			}
		});
		frameborrow.setLayout(null);
		
		Label l1 = new Label("ͼ����");
		booknum = new TextField();
		Label l2 = new Label("���߱��");
		readernum = new TextField();
		Label l3 = new Label("ͼ������");
		bookname = new TextField();
		Label l4 = new Label("��������");
		readername = new TextField();
		Label l5 = new Label("������");
		bookpublisher = new TextField();
		Label l6 = new Label("�������");
		readertype = new TextField();
		Label l7 = new Label("����ʱ��");
		bookpublish_time = new TextField();
		Label l8 = new Label("�����Ա�");
		readersex = new TextField();
		Label l9 = new Label("��������");
		bookborrow_date = new TextField();
		Label l10 = new Label("��������");
		bookreturn_date = new TextField();
		
		l1.setBounds(50,50,50,20);
		frameborrow.add(l1);
		booknum.setBounds(120,50,80,20);
		frameborrow.add(booknum);
		//Ϊͼ�����ı�����Ӽ��̼����¼�
		booknum.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				tf_book_idKeyTyped(e);
			}
		});
		
		l2.setBounds(250,50,50,20);
		frameborrow.add(l2);
		readernum.setBounds(320,50,80,20);
		frameborrow.add(readernum);
		
		readernum.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				tf_reader_idKeyTyped(e);
			}
		});
		
		l3.setBounds(50,80,50,20);
		frameborrow.add(l3);
		bookname.setBounds(120,80,80,20);
		frameborrow.add(bookname);
		
		l4.setBounds(250,80,50,20);
		frameborrow.add(l4);
		readername.setBounds(320,80,80,20);
		frameborrow.add(readername);
		
		l5.setBounds(50,110,50,20);
		frameborrow.add(l5);
		bookpublisher.setBounds(120,110,80,20);
		frameborrow.add(bookpublisher);
		
		l6.setBounds(250,110,50,20);
		frameborrow.add(l6);
		readertype.setBounds(320,110,80,20);
		frameborrow.add(readertype);
		
		l7.setBounds(50,140,50,20);
		frameborrow.add(l7);
		bookpublish_time.setBounds(120,140,80,20);
		frameborrow.add(bookpublish_time);
		
		l8.setBounds(250,140,50,20);
		frameborrow.add(l8);
		readersex.setBounds(320,140,80,20);
		frameborrow.add(readersex);
		
		l9.setBounds(50,170,50,20);
		frameborrow.add(l9);
		bookborrow_date.setBounds(120,170,80,20);
		frameborrow.add(bookborrow_date);
		
		l10.setBounds(250,170,50,20);
		frameborrow.add(l10);
		bookreturn_date.setBounds(320,170,80,20);
		frameborrow.add(bookreturn_date);
		
		Button cer = new Button("���");
		Button clo = new Button("�ر�");
		cer.setBounds(250,200,60,20);
		clo.setBounds(350,200,60,20);
		frameborrow.add(cer);
		frameborrow.add(clo);
		clo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameborrow.dispose();
			}
		});
		cer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_borrowActionPerformed(e);
			}
		});
		
		frameborrow.setVisible(true);
	}
	//ͼ�����ı����»س�����ִ��
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
	//���߱���ı���س������º�ִ��
	private void tf_reader_idKeyTyped(KeyEvent e) {
		if(e.getKeyChar()=='\n') {
			String id  = readernum.getText();
			Reader reader = ReaderDao.selectReader(id);
			if(reader!=null) {
				readername.setText(reader.getName());
				readertype.setText(reader.getType());
				readersex.setText(reader.getSex());
				//���ý��顢��������
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
		String borrow_date = bookborrow_date.getText();
		String back_date = bookreturn_date.getText();
		String sql = "insert into borrow(book_id,reader_id,borrow_date,back_date,is_back) values('"+book_id+"','"+reader_id+"',"
				      + "'"+borrow_date+"','"+back_date+"',0)";
		int i = BaseDao.executeUpdate(sql);
		if(i!=-1) {
			frameborrow.dispose();
			JOptionPane.showMessageDialog(null,"����ɹ�");
		}
	}
}
