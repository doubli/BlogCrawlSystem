/**
 * 转化时间
 * @author menghucheng
 */
package edu.xiyou.BCS.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateUtil {
	
	public static final Logger LOG = Logger.getLogger(DateUtil.class);
	
	public static Date parseStringToDate(String dateStr){
		SimpleDateFormat sdf = null;
		try {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			LOG.error("parse Str to date error",e);
			return null;
		}
		
	} 
	
	public static Date getNow(){
		return new Date();
	}

	public static String parseDateToString(Date date) {
		SimpleDateFormat sdf = null;
		try {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(date);
		} catch (Exception e) {
			LOG.error("parse date to string error", e);
			return null;
		}
	}
	
}
