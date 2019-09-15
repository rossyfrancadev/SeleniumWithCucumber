package runner;

import com.aventstack.extentreports.gherkin.model.Feature;

import base.ExtentReportUtil;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static base.BaseUtil.features;

import java.io.IOException;

/**
 * Created by Karthik on 31/01/2019.
 */

public class NGTestListener implements ITestListener {

    ExtentReportUtil extentReportUtil = new ExtentReportUtil();

    public void onTestStart(ITestResult iTestResult) {
        System.out.println("On test start");
    }

    public void onTestSuccess(ITestResult iTestResult) {

        System.out.println("On test Sucess");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("On test failure");

        try{
            extentReportUtil.ExtentReportScreenshot();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("On test skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("On test percentage");
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("On start");

        extentReportUtil.ExtentReport();

        //ToDo: Feature - Hard coding the feature name
        features = extentReportUtil.extent.createTest(Feature.class, "Login Feature");

    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("On finish");
        extentReportUtil.FlushReport();
    }
}
