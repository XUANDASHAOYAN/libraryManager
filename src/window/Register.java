/*�û�ע�Ὣ������*/
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
		f = new Frame("�û�ע��");
		f.setBounds(400,400,200,100);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
		f.setLayout(null);
		Label la = new Label("���������������");
		tf = new TextField();
		Button b = new Button("ȷ��");
		la.setBounds(10,30,90,20);
		f.add(la);
		tf.setBounds(110,30,80,20);
		f.add(tf);
		b.setBounds(90,60,30,20);
		f.add(b);
		//Ϊ��ȷ������ť�趨������
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
			JOptionPane.showMessageDialog(null,"�û�������Ϊ�գ�");
		}
		else {
			String sql = "insert into [user](name) values('"+name+"')";
		    int i = BaseDao.executeUpdate(sql);  //���û������뵽user���У�Ĭ����Ϊ�ǹ���Ա����ʼ����Ϊ111111
		    if(i!=-1) {
			    f.dispose();
			    JOptionPane.showMessageDialog(null,"ע��ɹ������ĳ�ʼ����Ϊ111111");
		    }
		}
		
	}
}
