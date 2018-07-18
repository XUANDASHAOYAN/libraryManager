/*ʵ��[����ά��]�е�ͼ����Ϣ�޸�*/
package window;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import db.BaseDao;
import db.BookDao;
import entity.Book;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import util.Constant;

public class BookUpdate {
	TextField booknum,booknumq,bookname,bookauthor,booktranslator,bookpublisher,bookpublish_time,bookprice,bookstock;
	JComboBox bookstyle;
	Frame framebook;
	public void bookUpdateInterface() {
		framebook = new Frame("�޸�ͼ����Ϣ");
		framebook.setBounds(400,400,480,280);
		framebook.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				framebook.dispose();
			}
		});
		framebook.setLayout(null);
		
		Label bu = new Label("ͼ����");
		booknum = new TextField();
		Button search = new Button("��ѯ");
		bu.setBounds(50,50,50,20);
		framebook.add(bu);
		booknum.setBounds(120,50,80,20);
		framebook.add(booknum);
		search.setBounds(250,50,50,20);
		framebook.add(search);
		//Ϊ����ѯ����ť���ü�����
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_queryActionPerformed(e);
			}
		});
		Label bu1 = new Label("ͼ����");
		booknumq = new TextField();
		Label bu2 = new Label("ͼ������");
		bookname = new TextField();
		Label bu3 = new Label("ͼ�����");
		bookstyle = new JComboBox(Constant.Book);
		Label bu4 = new Label("����");
		bookauthor = new TextField();
		Label bu5 = new Label("����");
		booktranslator = new TextField();
		Label bu6 = new Label("������");
		bookpublisher = new TextField();
		Label bu7 = new Label("����ʱ��");
		bookpublish_time = new TextField();
		Label bu8 = new Label("�۸�");
		bookprice = new TextField();
		Label bu9 = new Label("�������");
		bookstock = new TextField();
		
		bu1.setBounds(50,80,50,20);
		framebook.add(bu1);
		booknumq.setBounds(120,80,80,20);
		framebook.add(booknumq);
		
		bu2.setBounds(250,80,50,20);
		framebook.add(bu2);
		bookname.setBounds(320,80,80,20);
		framebook.add(bookname);
		
		bu3.setBounds(50,110,50,20);
		framebook.add(bu3);
		bookstyle.setBounds(120,110,80,20);
		framebook.add(bookstyle);
		
		bu4.setBounds(250,110,50,20);
		framebook.add(bu4);
		bookauthor.setBounds(320,110,80,20);
		framebook.add(bookauthor);
		
		bu5.setBounds(50,140,50,20);
		framebook.add(bu5);
		booktranslator.setBounds(120,140,80,20);
		framebook.add(booktranslator);
		
		bu6.setBounds(250,140,50,20);
		framebook.add(bu6);
		bookpublisher.setBounds(320,140,80,20);
		framebook.add(bookpublisher);
		
		bu7.setBounds(50,170,50,20);
		framebook.add(bu7);
		bookpublish_time.setBounds(120,170,80,20);
		framebook.add(bookpublish_time);
		
		bu8.setBounds(250,170,50,20);
		framebook.add(bu8);
		bookprice.setBounds(320,170,80,20);
		framebook.add(bookprice);
		
		bu9.setBounds(50,200,50,20);
		framebook.add(bu9);
		bookstock.setBounds(120,200,80,20);
		framebook.add(bookstock);
		
		Button cer = new Button("����");
		Button clo = new Button("ȡ��");
		cer.setBounds(250,230,60,20);
		clo.setBounds(350,230,60,20);
		framebook.add(cer);
		framebook.add(clo);
		
		clo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framebook.dispose();
			}
		});
		//Ϊ"����"��ť����������
		cer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_saveActionPerformed(e);
			}
		});
		framebook.setVisible(true);
	}
	//��������ѯ����ť��ִ��
	private void btn_queryActionPerformed(ActionEvent e) {
		String id = booknum.getText();
		Book book = BookDao.selectBook(id);
		//��ѯ�õ�ͼ����Ϣ
		if(book != null) {
			booknumq.setText(book.getID());
			bookname.setText(book.getName());
			bookstyle.setSelectedItem(book.getType());
			bookauthor.setText(book.getAuthor());
			booktranslator.setText(book.getTranslator());
			bookpublisher.setText(book.getPublisher());
			bookpublish_time.setText(book.getPublish_time().toString());
			bookprice.setText(String.valueOf(book.getPrice()));
			bookstock.setText(String.valueOf(book.getStock()));
		}
	}
	//���������桱��ť��ִ��
	private void btn_saveActionPerformed(ActionEvent e) {
		//��ȡ׼���޸ĵ�ͼ����Ϣ
		String id = booknumq.getText();
		String name = bookname.getText();
		String type = bookstyle.getSelectedItem().toString();
		String author = bookauthor.getText();
		String translator = booktranslator.getText();
		String publisher = bookpublisher.getText();
		String publish_time = bookpublish_time.getText();
		String price = bookprice.getText();
		String stock = bookstock.getText();
		
		String sqlbooku = "update book set name = '"+name+"',type = '"+type+"',author = '"+author+"',translator = '"+translator+"',"
				          + "publisher = '"+publisher+"',publish_time = '"+publish_time+"',price = '"+price+"',stock = '"+stock+"' "
				          		+ "where id = '"+id+"'";
		int i = BaseDao.executeUpdate(sqlbooku);
		if(i != -1) {
			framebook.dispose();
			JOptionPane.showMessageDialog(null,"�޸ĳɹ�");
		}
	}
}
