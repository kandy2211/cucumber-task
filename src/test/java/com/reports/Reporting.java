package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
	public static void generateJVMreport(String jsonfile) {

		File file = new File(System.getProperty("user.dir")+"\\target");

		Configuration configuration = new Configuration(file, "adcatin hotel automation" );

		configuration.addClassifications("Browser", "chrome");
		configuration.addClassifications("Browser version", "104");
		configuration.addClassifications("OS", "WIN10");
		configuration.addClassifications("Sprint", "22");

		List<String> jsonfiles = new ArrayList<String>();

		jsonfiles.add(jsonfile);

		ReportBuilder builder = new ReportBuilder(jsonfiles, configuration);

		builder.generateReports();

	}

}
