package com.ss.ita.econews.ui.data;

public enum UserSignInData {
    TARAS_KRASITSKYI("email_registration@ukr.net", "Password_2021"),
    TEST_USER("greencity.test.user@gmail.com", "LeVq3ucLZRVPJuA!"),
    VLAD_DMYTRIV("vladdmutriv@gmail.com", "1203Vlad01*"),
    TEST_USER_GC_871("green.city.test2@gmail.com","Green.city#500");

    private final String email;
    private final String password;

    UserSignInData(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

}
