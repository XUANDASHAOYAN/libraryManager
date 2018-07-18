package window;
import java.awt.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import db.BaseDao;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import util.Constant;

public class ReaderAdd {
	TextField readernum,readername,borrownum,borrowdays;
	JComboBox readertype,readersex;
	Frame framereader;
	public void readerAddInterface() {
		framereader = new Frame("添加读者");
		framereader.setBounds(400,400,480,200);
		framereader.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				framereader.dispose();
			}
		});
		
		framereader.setLayout(null);
		
		Label r1 = new Label("读者编号");
		readernum = new TextField();
		Label r2 = new Label("读者姓名");
		readername = new TextField();
		Label r3 = new Label("读者类别");
		readertype = new JComboBox(Constant.Reader);
		Label r4 = new Label("性别");
		readersex = new JComboBox(Constant.Sex);
		Label r5 = new Label("可借数量");
		borrownum = new TextField();
		Label r6 = new Label("可借天数");
		borrowdays = new TextField();
		Button cer = new Button("保存");
		Button clo = new Button("取消");
		
		r1.setBounds(50,50,50,20);
		framereader.add(r1);
		readernum.setBounds(120,50,80,20);
		framereader.add(readernum);
		
		r2.setBounds(250,50,50,20);
		framereader.add(r2);
		readername.setBounds(320,50,80,20);
		framereader.add(readername);
		
		r3.setBounds(50,80,50,20);
		framereader.add(r3);
		readertype.setBounds(120,80,80,20);
		framereader.add(readertype);
		
		r4.setBounds(250,80,50,20);
		framereader.add(r4);
		readersex.setBounds(320,80,80,20);
		framereader.add(readersex);
		
		r5.setBounds(50,110,50,20);
		framereader.add(r5);
		borrownum.setBounds(120,110,80,20);
		framereader.add(borrownum);
		
		r6.setBounds(250,110,50,20);
		framereader.add(r6);
		borrowdays.setBounds(320,110,80,20);
		framereader.add(borrowdays);
		
		cer.setBounds(250,150,60,20);
		clo.setBounds(350,150,60,20);
		framereader.add(cer);
		framereader.add(clo);
		clo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framereader.dispose();
			}
		});
		//为“保存”按钮添加监听器
		cer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_saveActionPerformed(e);
			}
		});
		framereader.setVisible(true);
	}
	private void btn_saveActionPerformed(ActionEvent e) {
		String id = readernum.getText();
		String name = readername.getText();
		String type = readertype.getSelectedItem().toString();
		String sex = readersex.getSelectedItem().toString();
		String max_num = borrownum.getText();
		String days = borrowdays.getText();
		
		String sqlra = "insert into reader(id,name,type,sex,max_num,days_num) values('"+id+"','"+name+"',"
				        + "'"+type+"','"+sex+"','"+max_num+"','"+days+"')";
		int i = BaseDao.executeUpdate(sqlra);
		if(i!=-1) {	
			framereader.dispose();
			JOptionPane.showMessageDialog(null,"添加成功");
		}
	}
}
