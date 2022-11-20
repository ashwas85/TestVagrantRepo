package rcbfunction;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

public class RunnerFile extends RcbFeatureFile {

	@Test
	public void validateForignePlayers() throws Throwable {
		try {
			assertsEquals(getTheListOfForeignPlayers(), getexpectedforeignplayer());
			test.log(LogStatus.PASS, "Team has only four foregin players");
		} catch (Throwable e) {
			test.log(LogStatus.INFO, "Team has more than four foregin players");
			test.log(LogStatus.FAIL, e);
			throw e;
		}
		

	}

	@Test
	public void validateWicketPlayers() throws Throwable {
		try {
			
			assertTrue(getTheListOfWicketKeeper(),getexpectedwicketkeeper());
					test.log(LogStatus.PASS, "Team has one or more wicket keeper");
				
		} catch (Throwable e) {
			test.log(LogStatus.INFO, "There is no wicket keeper in the team");
			test.log(LogStatus.FAIL, e);
			throw e;
		}
		

	}

}
