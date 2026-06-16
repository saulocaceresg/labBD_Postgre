package util;

import java.util.ResourceBundle;

public class Configuration {
	public static String getProperties(String cipher) {
		ResourceBundle rscBundle = ResourceBundle.getBundle("bd");
		return rscBundle.getString(cipher);
	}
}
