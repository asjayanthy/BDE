package saavn.trend.util;

public class Utilities {

	public static boolean isNotNullOrEmpty(String value) {
		if (value == null || value.trim().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public static String getTrimmedString(String value) {
		if (value == null) {
			return "";
		}
		return value.trim();
	}

}
