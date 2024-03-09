package com.evcharging.station.Service;

import java.net.http.HttpRequest;

public interface AuthService {
    boolean isLoginUser(HttpRequest httpRequest);
    boolean isLoginStation(HttpRequest httpRequest);
    boolean isValidUser(HttpRequest httpRequest,int userid);
    boolean isAdmin(HttpRequest httpRequest,int userid);

}
