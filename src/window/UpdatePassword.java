package window;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import db.BaseDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import util.GlobalVar;

public class UpdatePassword {
	TextField pwd1,pwd2;
	Frame f;
	public void updatePwdInterface() {
		f = new Frame("�޸�����");
		f.setBounds(400,400,240,120);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setLayout(null);
		Label l1 = new Label("�����������룺");
		pwd1 = new TextField();
		Label l2 = new Label("�ڴ�ȷ�����룺");
		pwd2 = new TextField();
		
		l1.setBounds(20,30,80,20);
		f.add(l1);
		pwd1.setBounds(120,30,100,20);
		f.add(pwd1);
		l2.setBounds(20,50,80,20);
		f.add(l2);
		pwd2.setBounds(120,50,100,20);
		f.add(pwd2);
		
		Button cer = new Button("ȷ��");
		Button clo = new Button("ȡ��");
		cer.setBounds(95,80,60,20);
		clo.setBounds(165,80,60,20);
		f.add(cer);
		f.add(clo);
		clo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		cer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okButtonActionPerformed(e);
			}
		});
		f.setVisible(true);
	}
	private void okButtonActionPerformed(ActionEvent e) {
		String pass1 = pwd1.getText();
		String pass2 = pwd2.getText();
		if(!pass1.equals(pass2)) {
			JOptionPane.showMessageDialog(null,"�����������벻һ�£����������룡");
			pwd1.setText("");
			pwd2.setText("");
			return;
		}
		String sql = "update [user] set pwd = '"+pass1+"'where name = '"+GlobalVar.login_user+"'";
		int i = BaseDao.executeUpdate(sql);
		if(i==1) {
			f.dispose();
			JOptionPane.showMessageDialog(null,"�����޸ĳɹ�");
		}
	}
}


