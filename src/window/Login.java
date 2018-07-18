/*此部分设置登录界面，并分别为“确定”，“注册”按钮添加监听器*/
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
		f = new Frame("用户登录系统");
	    Label l1 = new Label("用户名：");
	    Label l2 = new Label("密码:");
	    Button l3 = new Button("确定");
	    Button l4 = new Button("取消");
	    tf_user = new TextField();
	    tf_pass = new TextField();
	    Button b = new Button("注册");

	    f.setLayout(null);
	    //设置基本组件在窗口的位置
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
	    //为"注册"按钮创建监听器
	    b.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Register reg = new Register();
	    		reg.register();
	    	}
	    });
	    
	    //为“确定”按钮创建监听器
	    l3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		btn_okActionPerformed(e);
	    	}
	    });
	    //为“取消”按钮创建监听器
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
	
	//“确定”按钮按下后执行的操作
	private void btn_okActionPerformed(ActionEvent e) {
		String name = tf_user.getText();
		String password = tf_pass.getText();
		String username = "";
		int is_admin;
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null,"用户名不允许为空!","提示",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(password.equals("")) {
			JOptionPane.showMessageDialog(null,"密码不能为空！","提示",JOptionPane.INFORMATION_MESSAGE);
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
		    	JOptionPane.showMessageDialog(null,"用户名或密码不正确!","提示",JOptionPane.INFORMATION_MESSAGE);
		    	BaseDao.close();
		    	return;
		    }
		    GlobalVar.login_user = username;  //记录下当前用户
		    Main main = new Main(); //进入主界面
		    main.setPurView((byte) is_admin);
		    f.dispose();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	
	
}
