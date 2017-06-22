package com.kit.google.homework.lesson3;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.codeSchool.CodeSchoolLoginPage;
import com.kit.pages.codeSchool.CodeSchoolMyBoardPage;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

/**
 * Created by VBashynskyi on 08.06.2017.
 */
public class CodeSchoolSignInTest extends WebDriverTestBase {

    String url = "https://www.codeschool.com/users/sign_in";
    String inputEmail = "underklon@mail.ru";
    String inputPass = "83115261990";
    String getClassProfile = "nav-item-link list-item-link";
    @Test
    public void loginTest() throws InterruptedException {
        //open url
        CodeSchoolLoginPage codeSchoolLoginPage = new CodeSchoolLoginPage(webDriver);
        codeSchoolLoginPage.openUrl(url);
        //login with email and pass
        codeSchoolLoginPage.login(inputEmail,inputPass);
        CodeSchoolMyBoardPage codeSchoolMyBoardPage = new CodeSchoolMyBoardPage(webDriver);
        assertTrue(codeSchoolMyBoardPage.getProfileAtributeClass().equals(getClassProfile));

    }

}
