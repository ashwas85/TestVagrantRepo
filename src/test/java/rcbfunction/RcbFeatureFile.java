package rcbfunction;

import java.io.IOException;
import org.json.JSONException;
import org.json.simple.parser.ParseException;

public class RcbFeatureFile extends Utility {

	public int getTheListOfForeignPlayers() throws IOException, ParseException {

		int foreignplayers = 0;

		for (int i = 0; i < parseJasonData().length(); i++) {

			if (!parseJasonData().getJSONObject(i).getString("country").equals("India")) {
				foreignplayers = foreignplayers + 1;
			}
		}
		return foreignplayers;
	}

	public int getTheListOfWicketKeeper() throws IOException, JSONException, ParseException {
		int wicketkeeper = 0;
		for (int i = 0; i < parseJasonData().length(); i++) {
			if (parseJasonData().getJSONObject(i).getString("role").equals("Wicket-keeper")) {
				wicketkeeper++;

			}

		}
		return wicketkeeper;
	}

}
