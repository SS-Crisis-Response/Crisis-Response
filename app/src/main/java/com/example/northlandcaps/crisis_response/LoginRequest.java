package com.example.northlandcaps.crisis_response;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://192.168.12.125:80/phptesting/Login.php";
    private Map<String,String> params;
    public LoginRequest(String username, String password, Response.Listener<String> listener,Response.ErrorListener errListener){
        super(Request.Method.POST,LOGIN_REQUEST_URL,listener,errListener);
        params=new HashMap<>();
        params.put("username",username);
        params.put("password",password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
