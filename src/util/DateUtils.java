/*得到给定日期几日后的日期*/
package util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.util.Locale;

public class DateUtils{
	//获得当前日期
	public static String getDate() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(d);
	}
	//得到给定日期后几日的日期
	public static String getAfterDay(String date,int num) {
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		Date a = null;
		try {
			a = parser.parse(date);  //将所给的String类型的字符串转化为String类型
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		//Calendar类型用于执行日期相加
		Calendar calendar = Calendar.getInstance(); 
		calendar.setTime(a); 
		calendar.add(Calendar.DATE,num);
		//将日期类型转化成字符串返回
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		return simpledateformat.format(calendar.getTime());
	}
}