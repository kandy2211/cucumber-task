package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

/**
 * 
 * @author Kandasamy
 * @description used to maintain runner class
 * @date 07/09/2022
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(dryRun=false,publish=true,monochrome=true,snippets=SnippetType.CAMELCASE,stepNotifications=true,
plugin= {"json:C:\\Users\\Kandasamy\\eclipse-workspace\\OMRBranchAdactinAutomation\\target\\output.json"},features="src\\test\\resources\\Features",glue="com.stepdefinition")
public class TestRunnerClass extends BaseClass {
	
	@AfterClass
	public static void afterclass() throws FileNotFoundException, IOException {
		

		 
		 Reporting.generateJVMreport(System.getProperty("user.dir")+getPropertyFileValue("jsonPath"));
		 
		 

	}
	

}
