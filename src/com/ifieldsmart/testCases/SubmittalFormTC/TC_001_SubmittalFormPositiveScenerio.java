package com.ifieldsmart.testCases.SubmittalFormTC;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ifieldsmart.repository.CreateNewRfiPage;
import com.ifieldsmart.repository.CreateNewSubmittalPage;
import com.ifieldsmart.repository.FolderPage;
import com.ifieldsmart.repository.LoginPage;
import com.ifieldsmart.repository.ProjectsPage;

import com.ifieldsmart.repository.SubmittalListPage;
import com.ifieldsmart.utility.Utility;

public class TC_001_SubmittalFormPositiveScenerio extends Utility {
	public String userName = "omkrushana@vcsbim.com";
	public String pwd = "if#2022";

	@Test(priority = 1)
	public void initbrowser() {
		driverSetting();
	}

	@Test(priority = 2)
	public void login() throws InterruptedException {
		starttestcse("Login Positive Scenerio Test Case");
		LoginPage loginpage = new LoginPage(driver);

		// Enter username & password
		loginpage.enterUsername(userName);
		logger.log(Status.INFO, "Username inserted");
		loginpage.enterPassword(pwd);
		logger.log(Status.INFO, "Password inserted");
		// Click on Login button
		loginpage.loginBtnClick();
		logger.log(Status.INFO, "login button clicked");
		loginpage.tearDown();

		// driver.close();
	}

	@Test(priority = 3)
	public void projectCard1() throws InterruptedException {
		starttestcse("User click card1");

//		public HomePage objhomerepo = new HomePage();
		ProjectsPage objProjectsPage = new ProjectsPage(driver);
		objProjectsPage.projectsTabClick();
		logger.log(Status.INFO, "Projects Tab Opened");
		objProjectsPage.projectsCard1Click();
		logger.log(Status.INFO, "Clicked on card");
		Thread.sleep(2000);

	}

	@Test(priority = 4)
	public void SubmittalListCreate() {
		starttestcse("User click on Submittal ");

		FolderPage objFolderPage = new FolderPage(driver);
		// objFolderPage.switchToMainBody();
		objFolderPage.SubmittalInFolderList();

		String actualurl = driver.getCurrentUrl();

		if (actualurl.contains("SubmittalsList")) {
			markstatus("pass", "SubmittalsList list Opened");
		} else {
			markstatus("fail", "Fail to open SubmittalsList list ");
		}

	}

	@Test(priority = 5)
	public void SubmittalFormOpen() {
		starttestcse("User click on createSubmittal ");

		SubmittalListPage objSubmittalListPage = new SubmittalListPage(driver);
		objSubmittalListPage.addSubmittalBtnClick();

		String actualurl = driver.getCurrentUrl();

		if (actualurl.contains("CreateSubmittals")) {
			markstatus("pass", "CreateSubmittals Form Opened");
		} else {
			markstatus("fail", "Fail to open CreateSubmittals Form ");
		}

	}

	@Test(priority = 6)
	public void SubmittalFormFill() throws InterruptedException {
		String Title = "Submital  Form Test";
		String Spec_Section = "013319    Field Test Reporting";// select
		String StatusInput = "Submitted";// select
		String Submitted_By = "Jane Smith(OM)";
		String Assign_To = "Sumeet Maru(iFieldSmart)";
		String Received_From = "NULL NULL(NULL)";// select
		String Received_Date = "06/15/22";//
		String Cost_Code = "something";
		String date = "20";
		String Submittal_Type = "something";
		String Location = "Loaction Added";
		String UrlFileName = "Url file name added";
		String UrlPath = "Url Path Added";

		starttestcse("Create New Submittal form details Test");

		CreateNewSubmittalPage objCreateNewSubmittalPage = new CreateNewSubmittalPage(driver);

		objCreateNewSubmittalPage.TitlePlaceholder(Title);
		objCreateNewSubmittalPage.Spec_sectionPlacholder(Spec_Section);
		objCreateNewSubmittalPage.Submittal_PackageCheck();
		objCreateNewSubmittalPage.RevisionPlaceholderCheck();
		objCreateNewSubmittalPage.StatusSelect(StatusInput);
		objCreateNewSubmittalPage.Submitted_BySelect(Submitted_By);
		objCreateNewSubmittalPage.AssignToInput(Assign_To);
		objCreateNewSubmittalPage.Received_FromPlaceholder(Received_From);
		objCreateNewSubmittalPage.IssueDateSelect();
		objCreateNewSubmittalPage.RecivedDateSelect("June");
		//objCreateNewSubmittalPage.Due_DateSelect(Due_Date);
		objCreateNewSubmittalPage.Cost_CodePlaceholder(Cost_Code);
		objCreateNewSubmittalPage.Submittel_TypePlaceholder(Submittal_Type);
		objCreateNewSubmittalPage.LocationPlaceholder(Location);
		objCreateNewSubmittalPage.fileNamePlaceholderInput(UrlFileName);
		objCreateNewSubmittalPage.urlPlaceholderInput(UrlPath);
		objCreateNewSubmittalPage.addUrl_BtnClick();
		objCreateNewSubmittalPage.distrubutionListChecllist();

	}

}
