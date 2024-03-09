package com.evcharging.station.ServiceImplementation;

import com.evcharging.station.Service.AuthService;

import java.net.http.HttpRequest;

public class AuthServiceImpl implements AuthService {
    @Override
    public boolean isLoginUser(HttpRequest httpRequest) {
        return false;
    }

    @Override
    public boolean isLoginStation(HttpRequest httpRequest) {
        return false;
    }

    @Override
    public boolean isValidUser(HttpRequest httpRequest, int userid) {
        return false;
    }

    @Override
    public boolean isAdmin(HttpRequest httpRequest, int userid) {
        return false;
    }
}
