package rcbfunction;

//import java.io.IOThrowable;
import java.util.Properties;
import org.apache.commons.configuration.ConfigurationConverter;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ReadProperty {

	private static Properties property = null;
	private static PropertiesConfiguration propertiesConfiguration = null;
	String webDriverName = System.getProperty("web.driver.name");

	public String getWebDriverName() {
		return webDriverName;
	}

	private static Properties loadProperty() {

		if (null == propertiesConfiguration) {
			try {
				String configFilePath = System.getProperty("systemConfig");
				if (configFilePath == null) {
					configFilePath = System.getProperty("user.dir") +"/src/test/resources/configuration.properties";
				}
				propertiesConfiguration = new PropertiesConfiguration(configFilePath);
				property = ConfigurationConverter.getProperties(propertiesConfiguration);

			} catch (Exception ex) {
				System.err.println(ex.getLocalizedMessage());
				ex.printStackTrace();
				System.exit(-1);
			}
		}
		return property;
	}

	public static String getString(String key) {
		loadProperty();
		return propertiesConfiguration.getString(key);
	}

	public int getexpectedforeignplayer() {

		return Integer.parseInt(getString("expectedforeignplayer"));
	}

	public int getexpectedwicketkeeper() {

		return Integer.parseInt(getString("atleasthowmanywicketkeeper"));
	}
}
