/*�ò����������û���¼��������*/
package window;
import java.awt.*;
import java.awt.event.*;


public class Main {
	Menu menu1,menu2,menu3,menu4;
	Menu menu11,menu12;
	MenuItem add1,change1,delete1,add2,change2,delete2,menu21,
	         menu22,menu31,menu32,menu41,menu42;
	private void initComponents() {
		Frame myframe = new Frame("ͼ�����ϵͳ");
		myframe.setBounds(400,400,600,500);
		myframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		MenuBar menubar = new MenuBar();
		menu1 = new Menu("����ά��");
		menu2 = new Menu("���Ĺ���");
		menu3 = new Menu("��ѯ����");
		menu4 = new Menu("ϵͳ����");
		//����ά��--ͼ��ά������
		menu11 = new Menu("ͼ��ά��");
		menu12 = new Menu("����ά��");
		add1 = new MenuItem("ͼ�����");
		add1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAdd bookadd = new BookAdd();
				bookadd.bookAddInterface();
			}
		});
		
		change1 = new MenuItem("ͼ���޸�");
		change1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookUpdate bookupdate = new BookUpdate();
				bookupdate.bookUpdateInterface();
			}
		});
		
		delete1 = new MenuItem("ͼ��ɾ��");
		delete1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookDelete bookdelete = new BookDelete();
				bookdelete.bookDeleteInterface();
			}
		});
		//����ά��--����ά������
		menu11.add(add1);
		menu11.add(change1);
		menu11.add(delete1);
		menu1.add(menu11);
		add2 = new MenuItem("�������");
		add2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderAdd readeradd = new ReaderAdd();
				readeradd.readerAddInterface();
			}
		});
		change2 = new MenuItem("�����޸�");
		change2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderUpdate readerupdate = new ReaderUpdate();
				readerupdate.readerUpdateInterface();
			}
		});
		delete2 = new MenuItem("����ɾ��");
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
		//���Ĺ���
		menu21 = new MenuItem("����");
		menu21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Borrow_book borrow_book = new Borrow_book();
				borrow_book.borrow_book();
			}
		});
		menu22 = new MenuItem("����");
		menu22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Return_book return_book = new Return_book();
				return_book.return_book();
			}
		});
		menu2.add(menu21);
		menu2.add(menu22);
		menubar.add(menu2);
		//��ѯ����
		menu31 = new MenuItem("ͼ���ѯ");
		menu31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookQuery bookquery = new BookQuery();
				bookquery.bookQueryInterface();
			}
		});
		menu32 = new MenuItem("���߲�ѯ");
		menu32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReaderQuery readerquery = new ReaderQuery();
				readerquery.readerQueryInterface();
			}
		});
		menu3.add(menu31);
		menu3.add(menu32);
		menubar.add(menu3);
		//ϵͳ����
		menu41 = new MenuItem("�޸�����");
		menu41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePassword updatepwd = new UpdatePassword();
				updatepwd.updatePwdInterface();
			}
		});
		menu42 = new MenuItem("�˳�ϵͳ");
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
		//�û��Ժ�����ݵ�¼ϵͳ
		initComponents();
		switch (purview) {
		   //һ���û���¼
		    case 0:
			   menu1.setEnabled(false);
			   menu2.setEnabled(false);
			   break;
			//����Ա��¼
		    case 1:
		    	break;
		}
	}
	//������
	public static void main(String args[]) {
		Login log = new Login();
		log.login();
	}
}
