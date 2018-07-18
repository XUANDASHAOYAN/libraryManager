/*�õ��������ڼ��պ������*/
package util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.util.Locale;

public class DateUtils{
	//��õ�ǰ����
	public static String getDate() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d);
	}
	//�õ��������ں��յ�����
	public static String getAfterDay(String date,int num) {
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		Date a = null;
		try {
			a = parser.parse(date);  //��������String���͵��ַ���ת��ΪString����
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		//Calendar��������ִ���������
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(a); 
		calendar.add(Calendar.DATE,num);
		//����������ת�����ַ�������
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		return simpledateformat.format(calendar.getTime());
	}
}