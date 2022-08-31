package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun=true,publish=true,monochrome=true,snippets=SnippetType.CAMELCASE,stepNotifications=true,
plugin= {"json:\\target\\output.json"},features="src\\test\\resources\\Features",glue="com.stepdefinition")
public class TestRunnerClass {
	
	@AfterClass
	public static void afterclass() {
		
		 Reporting.generateJVMreport("C:\\Users\\Kandasamy\\eclipse-workspace\\OMRBranchAdactinAutomation\\target\\output.json");

	}
	

}
