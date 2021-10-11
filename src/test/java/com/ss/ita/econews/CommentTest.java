package com.ss.ita.econews;

import com.ss.ita.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.ss.ita.data.UserSignInData.*;

public class CommentTest extends TestRuner {

    @Test
    public void comment() {
        new HomePage(driver)
                .getHeader()
                .login(VLAD_DMYTRIV.getEmail(), VLAD_DMYTRIV.getPassword());
        NewsPage newsPage = new HomePage(driver)
                .getHeader()
                .clickEcoNewsLink()
                .clickNewsButton()
                .setComment("comment")
                .clickComment();
    }
}
