package com.mobile.functions;

import java.io.IOException;
import java.util.Properties;

public class javaFunctions {

	private static String strDate;
	
	private String dtFormatyyyymmdd(String strDate) {
		
		if(strDate == "" || strDate == null || strDate.equals(""))
		{
			strDate="NIL";
			return strDate;
		}
		strDate=strDate.substring(6,10)+"-"+strDate.substring(3,5)+"-"+strDate.substring(0,2);
		return strDate;
	}

	public static String dtFormatyyyymmdd() {
	return strDate;
}
}
