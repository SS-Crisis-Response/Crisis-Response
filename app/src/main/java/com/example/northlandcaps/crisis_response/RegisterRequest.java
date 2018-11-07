package com.example.northlandcaps.crisis_response;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://192.168.6.104:80/phptesting/Register.php";
    private Map<String, String> params;
    public RegisterRequest(String username, String password,String isAdmin, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("username",username);
        params.put("password",password);
        params.put("isAdmin",isAdmin+"");
    }

    public Map<String, String> getparams() {
        return params;
    }
}
//db name, username, password, host