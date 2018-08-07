package test.servlet;

import javax.servlet.http.HttpServletRequest;

public class utils {
	public static int getIntParameter(HttpServletRequest request, String paramName, int defaultValue) {
		String paramString = request.getParameter(paramName);
		int paramValue;
		try {
			paramValue = Integer.parseInt(paramString);
		} catch(NumberFormatException nfe) {
			paramValue = defaultValue;
		}
		return (paramValue);
	}
}
