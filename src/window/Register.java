/*用户注册将监听器*/
package window;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import java.awt.event.*;
import db.BaseDao;

public class Register {
	Frame f;
	TextField tf;
	public void register() {
		f = new Frame("用户注册");
		f.setBounds(400,400,200,100);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
		f.setLayout(null);
		Label la = new Label("请输入你的姓名：");
		tf = new TextField();
		Button b = new Button("确定");
		la.setBounds(10,30,90,20);
		f.add(la);
		tf.setBounds(110,30,80,20);
		f.add(tf);
		b.setBounds(90,60,30,20);
		f.add(b);
		//为“确定”按钮设定监听器
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_okActionPerformed(e);
			}
		});
		f.setVisible(true);
	}
	
	private void btn_okActionPerformed(ActionEvent e) {
		String name = tf.getText();
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null,"用户名不能为空！");
		}
		else {
			String sql = "insert into [user](name) values('"+name+"')";
		    int i = BaseDao.executeUpdate(sql);  //将用户名插入到user表中，默认其为非管理员，初始密码为111111
		    if(i!=-1) {
			    f.dispose();
			    JOptionPane.showMessageDialog(null,"注册成功，您的初始密码为111111");
		    }
		}
		
	}
}
