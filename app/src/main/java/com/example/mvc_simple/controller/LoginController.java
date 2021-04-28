package com.example.mvc_simple.controller;

import com.example.mvc_simple.model.User;
import com.example.mvc_simple.view.ILoginView;

public class LoginController implements ILoginController {
    ILoginView loginView;

    public LoginController(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void OnLogin(String email, String Password) {
        User user=new User(email,Password);

        int success=user.isValid();

        if (success==0)
            loginView.OnLoginError("Please enter Email");
        else if (success==1)
            loginView.OnLoginError("Please enter valid email");
        else if (success==2)
            loginView.OnLoginError("Please enter password");
        else if (success==3)
            loginView.OnLoginError("Please enter password legth <6");
        else
            loginView.OnLoginSuccess("Successfull");

    }
}
