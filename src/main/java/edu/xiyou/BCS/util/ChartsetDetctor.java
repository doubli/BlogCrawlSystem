package edu.xiyou.BCS.util;

import org.mozilla.universalchardet.UniversalDetector;

public class ChartsetDetctor {
	
	public static String getCharset(byte[] content){
		
		UniversalDetector detector = null;
		
		if(content == null  || content.length == 0){
			return null;
		}
		
		detector = new UniversalDetector(null);
		
		detector.handleData(content,0,content.length);
		detector.dataEnd();
		
		return detector.getDetectedCharset();
	}
}
