package menuAndMessages;

//import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
		
	private static String BUNDLE_NAME = "messages.messages"; 

	private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	public static void changeLanguage(String lang) {
		if(lang.toLowerCase().equals("es")) {
			BUNDLE_NAME = "messages.messages_es_ES";
		}else {
			if(lang.toLowerCase().equals("en")) {
				BUNDLE_NAME = "messages.messages_en_EN";
			}else {
				if(lang.toLowerCase().equals("eu")) {
					BUNDLE_NAME = "messages.messages_es_EU";
				}else {
					if(lang.toLowerCase().equals("ca")) {
					BUNDLE_NAME = "messages.messages_es_CA";
					}
				}
			}
		}
		RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	}
}
