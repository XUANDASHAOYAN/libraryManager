/*ʵ��[����ά��]�е�ͼ�����*/
package window;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import util.Constant;
import db.BaseDao;

public class BookAdd {
	TextField booknum,bookname,bookauthor,booktranslator,
	          bookpublisher,bookpublish_time,bookprice,bookstock; 
	JComboBox bookstyle;
	Frame framebook;
	public void bookAddInterface() {
		framebook = new Frame("���ͼ��");
		framebook.setBounds(400,400,450,250);
		framebook.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				framebook.dispose();
			}
		});
		Label b1 = new Label("ͼ����");
		Label b2 = new Label("ͼ������");
		Label b3 = new Label("ͼ�����");
		Label b4 = new Label("����");
		Label b5 = new Label("����");
		Label b6 = new Label("������");
		Label b7 = new Label("����ʱ��");
		Label b8 = new Label("�۸�");
		Label b9 = new Label("�������");
		Button cer = new Button("ȷ��");
		Button clo = new Button("ȡ��");
		
		booknum = new TextField();
		bookname = new TextField();
		bookstyle = new JComboBox(Constant.Book);
		bookauthor = new TextField();
		booktranslator = new TextField();
		bookpublisher = new TextField();
		bookpublish_time = new TextField();
		bookprice = new TextField();
		bookstock = new TextField();
		
		framebook.setLayout(null);
		//���á����桱�͡��رա���ť
		cer.setBounds(250,200,60,20);
		clo.setBounds(350,200,60,20);
		framebook.add(cer);
		framebook.add(clo);
		
		b1.setBounds(50,50,50,20);
		framebook.add(b1);
		booknum.setBounds(120,50,80,20);
		framebook.add(booknum);
		
		b2.setBounds(250,50,50,20);
		framebook.add(b2);
		bookname.setBounds(320,50,80,20);
		framebook.add(bookname);
		
		b3.setBounds(50,80,50,20);
		framebook.add(b3);
		bookstyle.setBounds(120,80,80,20);
		framebook.add(bookstyle);
		
		b4.setBounds(250,80,50,20);
		framebook.add(b4);
		bookauthor.setBounds(320,80,80,20);
		framebook.add(bookauthor);
		
		b5.setBounds(50,110,50,20);
		framebook.add(b5);
		booktranslator.setBounds(120,110,80,20);
		framebook.add(booktranslator);
		
		b6.setBounds(250,110,50,20);
		framebook.add(b6);
		bookpublisher.setBounds(320,110,80,20);
		framebook.add(bookpublisher);
		
		b7.setBounds(50,140,50,20);
		framebook.add(b7);
		bookpublish_time.setBounds(120,140,80,20);
		framebook.add(bookpublish_time);
		
		b8.setBounds(250,140,50,20);
		framebook.add(b8);
		bookprice.setBounds(320,140,80,20);
		framebook.add(bookprice);
		
		b9.setBounds(50,170,50,20);
		framebook.add(b9);
		bookstock.setBounds(120,170,80,20);
		framebook.add(bookstock);
		
		framebook.setVisible(true);
		
		//Ϊ�����桱��ť��Ӷ���������
		cer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_saveActionPerformed(e);
			}
		});
		
		//Ϊ���رա���ť��Ӷ���������
		clo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framebook.dispose(); //�ر��Ӵ��ڣ������رո�����
			}
		});
	}
	
	private void btn_saveActionPerformed(ActionEvent e) {
		String id = booknum.getText();
		String name = bookname.getText();
		String type = bookstyle.getSelectedItem().toString();
		String author = bookauthor.getText();
		String translator = booktranslator.getText();
		String publisher = bookpublisher.getText();
		String publish_time = bookpublish_time.getText();
		String price = bookprice.getText();
		String stock = bookstock.getText();
		
		String sqlbook = "insert into book(id,name,type,author,translator,publisher,publish_time,price,stock) "
				+ "values("
				+ "'"+id+"','"+name+"','"+type+"','"+author+"','"+translator+"','"+publisher+"','"+publish_time+"','"+price+"','"+stock+"')";
		int i = BaseDao.executeUpdate(sqlbook);
		if(i!=-1) {
			framebook.dispose();
			JOptionPane.showMessageDialog(null,"��ӳɹ�");
		}
	}
}
