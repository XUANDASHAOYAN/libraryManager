/*实现[基础维护]中的图书删除*/
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

public class BookDelete {
	TextField booknum,booknumq,bookname,bookauthor,booktranslator,bookpublisher,bookpublish_time,bookprice,bookstock;
	JComboBox bookstyle;
	Frame framebook;
	public void bookDeleteInterface() {
		framebook = new Frame("删除图书信息");
		framebook.setBounds(400,400,480,280);
		framebook.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				framebook.dispose();
			}
		});
		framebook.setLayout(null);
		
		Label bu = new Label("图书编号");
		booknum = new TextField();
		Button search = new Button("查询");
		bu.setBounds(50,50,50,20);
		framebook.add(bu);
		booknum.setBounds(120,50,80,20);
		framebook.add(booknum);
		search.setBounds(250,50,50,20);
		framebook.add(search);
		
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_queryActionPerformed(e);
			}
		});
		Label bu1 = new Label("图书编号");
		booknumq = new TextField();
		Label bu2 = new Label("图书名称");
		bookname = new TextField();
		Label bu3 = new Label("图书类别");
		bookstyle = new JComboBox(Constant.Book);
		Label bu4 = new Label("作者");
		bookauthor = new TextField();
		Label bu5 = new Label("译者");
		booktranslator = new TextField();
		Label bu6 = new Label("出版社");
		bookpublisher = new TextField();
		Label bu7 = new Label("出版时间");
		bookpublish_time = new TextField();
		Label bu8 = new Label("价格");
		bookprice = new TextField();
		Label bu9 = new Label("库存数量");
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
		
		Button cer = new Button("删除");
		Button clo = new Button("取消");
		cer.setBounds(250,230,60,20);
		clo.setBounds(350,230,60,20);
		framebook.add(cer);
		framebook.add(clo);
		
		clo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framebook.dispose();
			}
		});
		//为"删除"按钮创建监听器
		cer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_delActionPerformed(e);
			}
		});
		framebook.setVisible(true);
	}
	private void btn_queryActionPerformed(ActionEvent e) {
		String id = booknum.getText();
		Book book = BookDao.selectBook(id);
		//查询得到图书信息
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
	private void btn_delActionPerformed(ActionEvent e) {
		//获取准备修改的图书信息
		String id = booknumq.getText();
		String sqlbooku = "delete book where id = '"+id+"'";
		int i = BaseDao.executeUpdate(sqlbooku);
		if(i != -1) {
			framebook.dispose();
			JOptionPane.showMessageDialog(null,"删除成功");
		}
	}
}
