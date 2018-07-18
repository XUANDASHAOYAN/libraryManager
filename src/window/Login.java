/*�˲������õ�¼���棬���ֱ�Ϊ��ȷ��������ע�ᡱ��ť��Ӽ�����*/
package window;
import java.awt.*;
import db.BaseDao;
import util.GlobalVar;

import java.awt.event.*;
import javax.swing.JOptionPane;
import java.sql.*;

public class Login {
	private TextField tf_user,tf_pass;
	Frame f;
	public void login(){
		f = new Frame("�û���¼ϵͳ");
	    Label l1 = new Label("�û�����");
	    Label l2 = new Label("����:");
	    Button l3 = new Button("ȷ��");
	    Button l4 = new Button("ȡ��");
	    tf_user = new TextField();
	    tf_pass = new TextField();
	    Button b = new Button("ע��");

	    f.setLayout(null);
	    //���û�������ڴ��ڵ�λ��
	    l1.setBounds(75,35,55,20);
	    f.add(l1);
	    tf_user.setBounds(155,35,80,20);
	    f.add(tf_user);
	    
	    l2.setBounds(78,105,55,20);
	    f.add(l2);
	    tf_pass.setBounds(155,105,80,20);
	    f.add(tf_pass);
	    
	    l3.setBounds(85,150,60,20);
	    f.add(l3);
	    l4.setBounds(160,150,60,20);
	    f.add(l4);
	    
	    b.setBounds(230,170,60,20);
	    f.add(b);
	    //Ϊ"ע��"��ť����������
	    b.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Register reg = new Register();
	    		reg.register();
	    	}
	    });
	    
	    //Ϊ��ȷ������ť����������
	    l3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		btn_okActionPerformed(e);
	    	}
	    });
	    //Ϊ��ȡ������ť����������
	    l4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		System.exit(1);
	    	}
	    });
	    
	    f.setSize(300,200);
	    f.setVisible(true);
	    f.addWindowListener(new WindowAdapter() {
	    	public void windowClosing(WindowEvent e) {
	    		System.exit(1);
	    	}
	    });
	}
	
	//��ȷ������ť���º�ִ�еĲ���
	private void btn_okActionPerformed(ActionEvent e) {
		String name = tf_user.getText();
		String password = tf_pass.getText();
		String username = "";
		int is_admin;
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null,"�û���������Ϊ��!","��ʾ",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(password.equals("")) {
			JOptionPane.showMessageDialog(null,"���벻��Ϊ�գ�","��ʾ",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		try {
			String sql = "select * from [user] where name = '"+name+"' and pwd = '"+password+"'";
		    ResultSet result = BaseDao.executeQuery(sql);
		    if(result.next()) {
			    username = result.getString("name");
			    is_admin = result.getInt("is_admin");
			    BaseDao.close();
		    }
		    else {
		    	JOptionPane.showMessageDialog(null,"�û��������벻��ȷ!","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		    	BaseDao.close();
		    	return;
		    }
		    GlobalVar.login_user = username;  //��¼�µ�ǰ�û�
		    Main main = new Main(); //����������
		    main.setPurView((byte) is_admin);
		    f.dispose();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	
	
}
