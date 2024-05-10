package com.evcharging.station.Service;

import jakarta.servlet.http.HttpServletRequest;

import java.net.http.HttpRequest;

public interface AuthService {
    boolean isLoginUser(HttpServletRequest httpRequest);
    boolean isLoginStation(HttpServletRequest httpRequest);
    boolean isValidUser(HttpServletRequest httpRequest,int userid);
    boolean isAdmin(HttpServletRequest httpRequest,int userid);

}
