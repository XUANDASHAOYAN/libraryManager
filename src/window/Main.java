/*该部分设置了用户登录的主界面*/
package window;
import java.awt.*;
import java.awt.event.*;


public class Main {
	Menu menu1,menu2,menu3,menu4;
	Menu menu11,menu12;
	MenuItem add1,change1,delete1,add2,change2,delete2,menu21,
	         menu22,menu31,menu32,menu41,menu42;
	private void initComponents() {
		Frame myframe = new Frame("图书管理系统");
		myframe.setBounds(400,400,600,500);
		myframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		MenuBar menubar = new MenuBar();
		menu1 = new Menu("基础维护");
		menu2 = new Menu("借阅管理");
		menu3 = new Menu("查询管理");
		menu4 = new Menu("系统管理");
		//基础维护--图书维护部分
		menu11 = new Menu("图书维护");
		menu12 = new Menu("读者维护");
		add1 = new MenuItem("图书添加");
		add1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAdd bookadd = new BookAdd();
				bookadd.bookAddInterface();
			}
		});
		
		change1 = new MenuItem("图书修改");
		change1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookUpdate bookupdate = new BookUpdate();
				bookupdate.bookUpdateInterface();
			}
		});
		
		delete1 = new MenuItem("图书删除");
		delete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookDelete bookdelete = new BookDelete();
				bookdelete.bookDeleteInterface();
			}
		});
		//基础维护--读者维护部分
		menu11.add(add1);
		menu11.add(change1);
		menu11.add(delete1);
		menu1.add(menu11);
		add2 = new MenuItem("读者添加");
		add2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderAdd readeradd = new ReaderAdd();
				readeradd.readerAddInterface();
			}
		});
		change2 = new MenuItem("读者修改");
		change2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderUpdate readerupdate = new ReaderUpdate();
				readerupdate.readerUpdateInterface();
			}
		});
		delete2 = new MenuItem("读者删除");
		delete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderDelete readerdelete = new ReaderDelete();
				readerdelete.readerDeleteInterface();
			}
		});
		menu12.add(add2);
		menu12.add(change2);
		menu12.add(delete2);
		menu1.add(menu12);
		menubar.add(menu1);
		//借阅管理
		menu21 = new MenuItem("借书");
		menu21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Borrow_book borrow_book = new Borrow_book();
				borrow_book.borrow_book();
			}
		});
		menu22 = new MenuItem("还书");
		menu22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Return_book return_book = new Return_book();
				return_book.return_book();
			}
		});
		menu2.add(menu21);
		menu2.add(menu22);
		menubar.add(menu2);
		//查询管理
		menu31 = new MenuItem("图书查询");
		menu31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookQuery bookquery = new BookQuery();
				bookquery.bookQueryInterface();
			}
		});
		menu32 = new MenuItem("读者查询");
		menu32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderQuery readerquery = new ReaderQuery();
				readerquery.readerQueryInterface();
			}
		});
		menu3.add(menu31);
		menu3.add(menu32);
		menubar.add(menu3);
		//系统管理
		menu41 = new MenuItem("修改密码");
		menu41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePassword updatepwd = new UpdatePassword();
				updatepwd.updatePwdInterface();
			}
		});
		menu42 = new MenuItem("退出系统");
		menu42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		menu4.add(menu41);
		menu4.add(menu42);
		menubar.add(menu4);
		
		myframe.setMenuBar(menubar);
		myframe.setVisible(true);
	}
	public void setPurView(byte purview) {
		//用户以何种身份登录系统
		initComponents();
		switch (purview) {
		   //一般用户登录
		    case 0:
			   menu1.setEnabled(false);
			   menu2.setEnabled(false);
			   break;
			//管理员登录
		    case 1:
		    	break;
		}
	}
	//主函数
	public static void main(String args[]) {
		Login log = new Login();
		log.login();
	}
}
