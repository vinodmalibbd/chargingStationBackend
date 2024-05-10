package com.evcharging.station.Service.impl;

import com.evcharging.station.Service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public boolean isLoginUser(HttpServletRequest httpRequest) {
        return false;
    }

    @Override
    public boolean isLoginStation(HttpServletRequest httpRequest) {
        return false;
    }

    @Override
    public boolean isValidUser(HttpServletRequest httpRequest, int userid) {
        return false;
    }

    @Override
    public boolean isAdmin(HttpServletRequest httpRequest, int userid) {
        return false;
    }
}
