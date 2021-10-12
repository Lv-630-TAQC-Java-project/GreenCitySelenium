package com.ss.ita.data;

import org.testng.annotations.DataProvider;

public class DataProviderImpl {
	
	@DataProvider
	public static Object[][] dpTextAreaDescriptionIsRedTest() {
		return new Object[][] { { "too short text", "#ff0000" },
								{ "", "#ff0000" },
								{ "almost enogth text)", "#ff0000" } };
	}
	
}
