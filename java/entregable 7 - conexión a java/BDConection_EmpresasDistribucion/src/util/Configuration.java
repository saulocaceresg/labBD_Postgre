package util;

import java.util.ResourceBundle;

public class Configuration {

	// ÚNICAMENTE lee las credenciales de la bd 
	public static String getProperties(String cipher) {
		ResourceBundle rscBundle = ResourceBundle.getBundle("bd");
		return rscBundle.getString(cipher);
	}
}
