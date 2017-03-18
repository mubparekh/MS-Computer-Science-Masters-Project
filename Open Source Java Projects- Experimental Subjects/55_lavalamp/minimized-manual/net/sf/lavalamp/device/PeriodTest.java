package net.sf.lavalamp.device;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class PeriodTest {
	
	private Calendar now = Calendar.getInstance();

	@Before
	public void setUp() {
		now.set(Calendar.HOUR_OF_DAY, 10);
		now.set(Calendar.MINUTE, 0);
		
	}

}
