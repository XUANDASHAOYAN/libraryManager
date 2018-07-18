package window;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import db.BaseDao;
import db.ReaderDao;
import entity.Reader;
import util.Constant;
public class ReaderUpdate {
	TextField readernum,readernumq,readername,borrownum,borrowdays;
	JComboBox readertype,readersex;
	Frame framereader;
	public void readerUpdateInterface() {
		framereader = new Frame("�޸Ķ�����Ϣ");
		framereader.setBounds(400,400,480,230);
		framereader.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				framereader.dispose();
			}
		});
		
		framereader.setLayout(null);
		
		Label r = new Label("���߱��");
		readernum = new TextField();
		Button search = new Button("��ѯ");
		
		r.setBounds(50,50,50,20);
		framereader.add(r);
		readernum.setBounds(120,50,80,20);
		framereader.add(readernum);
		
		search.setBounds(250,50,50,20);
		framereader.add(search);
		//Ϊ����ѯ����ť����������
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_ActionPerformed(e);
			}
		});
		
		Label r1 = new Label("���߱��");
		readernumq = new TextField();
		Label r2 = new Label("��������");
		readername = new TextField();
		Label r3 = new Label("�������");
		readertype = new JComboBox(Constant.Reader);
		Label r4 = new Label("�Ա�");
		readersex = new JComboBox(Constant.Sex);
		Label r5 = new Label("�ɽ�����");
		borrownum = new TextField();
		Label r6 = new Label("�ɽ�����");
		borrowdays = new TextField();
		Button cer = new Button("����");
		Button clo = new Button("ȡ��");
		
		r1.setBounds(50,80,50,20);
		framereader.add(r1);
		readernumq.setBounds(120,80,80,20);
		framereader.add(readernumq);
		
		r2.setBounds(250,80,50,20);
		framereader.add(r2);
		readername.setBounds(320,80,80,20);
		framereader.add(readername);
		
		r3.setBounds(50,110,50,20);
		framereader.add(r3);
		readertype.setBounds(120,110,80,20);
		framereader.add(readertype);
		
		r4.setBounds(250,110,50,20);
		framereader.add(r4);
		readersex.setBounds(320,110,80,20);
		framereader.add(readersex);
		
		r5.setBounds(50,140,50,20);
		framereader.add(r5);
		borrownum.setBounds(120,140,80,20);
		framereader.add(borrownum);
		
		r6.setBounds(250,140,50,20);
		framereader.add(r6);
		borrowdays.setBounds(320,140,80,20);
		framereader.add(borrowdays);
		
		cer.setBounds(250,170,60,20);
		clo.setBounds(350,170,60,20);
		framereader.add(cer);
		framereader.add(clo);
		clo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				framereader.dispose();
			}
		});
		//Ϊ��ȷ������ť����������
		cer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_saveActionPerformed(e);
			}
		});
		
		framereader.setVisible(true);
	}
	private void btn_ActionPerformed(ActionEvent e) {
		String id = readernum.getText();
		Reader reader = ReaderDao.selectReader(id);
		if(reader != null) {
			readernumq.setText(reader.getId());
			readername.setText(reader.getName());
			readertype.setSelectedItem(reader.getType());
			readersex.setSelectedItem(reader.getSex());
			borrownum.setText(String.valueOf(reader.getMax_num()));
			borrowdays.setText(String.valueOf(reader.getDays_num()));
		}
	}
	
	private void btn_saveActionPerformed(ActionEvent e) {
		String id = readernumq.getText();
		String name = readername.getName();
		String type = readertype.getSelectedItem().toString();
		String sex = readersex.getSelectedItem().toString();
		String Max_num = borrownum.getText();
		String days_num = borrowdays.getText();
		
		String sql = "update reader set id = '"+id+"',name = '"+name+"',type = '"+type+"',sex = '"+sex+"',"
				     + " Max_num = '"+Max_num+"',days_num = '"+days_num+"' where id = '"+id+"'";
		int i = BaseDao.executeUpdate(sql);
		if(i!=-1) {
			framereader.dispose();
			JOptionPane.showMessageDialog(null,"�޸ĳɹ�");
		}
	}
}
