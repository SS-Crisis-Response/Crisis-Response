package com.example.northlandcaps.crisis_response;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://testinghostingdomain.com/Register.php";
    private Map<String, String> parass;
    public RegisterRequest(String username, String password,String isAdmin, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL,listener,null);
        parass = new HashMap<>();
        parass.put("username",username);
        parass.put("password",password);
        parass.put("isAdmin",isAdmin+"");
    }

    public Map<String, String> getParass() {
        return parass;
    }
}
