package com.example.bnvtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.bnvtest.model.UserInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    EditText edtFName;
    EditText edtLName;
    EditText edtPhone;
    EditText edtPassword;
    EditText edtEmail;
    EditText edtAddress;
    int userInfoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        edtFName = findViewById(R.id.edtFName);
        edtLName = findViewById(R.id.edtLName);
        edtPhone = findViewById(R.id.edtPhone);
        edtPassword = findViewById(R.id.edtPassword);
        edtEmail = findViewById(R.id.edtEmail);
        edtAddress = findViewById(R.id.edtAddress);

        login_onClick();
    }

    public void btnSignUp_onClick(View view) {

        String firstName = edtFName.getText().toString();
        String lastName = edtLName.getText().toString();
        String phoneNum = edtPhone.getText().toString();
        String userPassword = edtPassword.getText().toString();
        String userRole = "c";
        String email = edtEmail.getText().toString();
        int points = 0;
        String address = edtAddress.getText().toString();

        addNewUserInfo( firstName, lastName,  phoneNum,  userPassword, userRole,
                email,  points,  address );
        getLastUser();
        createNewCart();

        Intent start = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(start);


    }

    private void createNewCart() {

        String url = "http://10.0.2.2:84/project/add_cart.php";

        RequestQueue queue = Volley.newRequestQueue(SignUpActivity.this);
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("TAG", "RESPONSE IS " + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            // on below line we are displaying a success toast message.
                            Toast.makeText(SignUpActivity.this,
                                    jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(SignUpActivity.this,
                        "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public String getBodyContentType() {
                // as we are passing data in the form of url encoded
                // so we are passing the content type below
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() {

                // below line we are creating a map for storing
                // our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our
                // key and value pair to our parameters.

                params.put("userInfoId", userInfoId+"");
                params.put("state", "");



                // at last we are returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);

    }

    private void getLastUser() {
        String url = "http://10.0.2.2:84/project/get_user_byid.php";
        JsonArrayRequest request =new JsonArrayRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                try {
                    JSONObject obj = response.getJSONObject(0);

                    userInfoId = obj.getInt("userInfoId");


                } catch(JSONException exception){
                    Log.d("Error", exception.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                String message = null;
                if (volleyError instanceof NetworkError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (volleyError instanceof ServerError) {
                    message = "The server could not be found. Please try again after some time!!";
                } else if (volleyError instanceof AuthFailureError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (volleyError instanceof ParseError) {
                    message = "Parsing error! Please try again after some time!!";
                } else if (volleyError instanceof NoConnectionError) {
                    message = "Cannot connect to Internet...Please check your connection!";
                } else if (volleyError instanceof TimeoutError) {
                    message = "Connection TimeOut! Please check your internet connection.";
                }
                Toast.makeText(SignUpActivity.this, message,
                        Toast.LENGTH_SHORT).show();
                Log.d("Error_json", message);
            }
        });
        Volley.newRequestQueue(SignUpActivity.this).add(request);


    }

    private void addNewUserInfo(String firstName,String lastName, String phoneNum, String userPassword,
    String userRole, String email, int points, String address ){
        String url = "http://10.0.2.2:84/project/add_user_info.php";

        RequestQueue queue = Volley.newRequestQueue(SignUpActivity.this);
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    // on below line we are displaying a success toast message.
                    Toast.makeText(SignUpActivity.this,
                            jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(SignUpActivity.this,
                        "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public String getBodyContentType() {
                // as we are passing data in the form of url encoded
                // so we are passing the content type below
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() {

                // below line we are creating a map for storing
                // our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our
                // key and value pair to our parameters.

                params.put("firstName", firstName);
                params.put("lastName", lastName);
                params.put("phoneNum", phoneNum);
                params.put("userPassword", userPassword);
                params.put("userRole", userRole);
                params.put("email", email);
                params.put("points", points +"");
                params.put("address", address);


                // at last we are returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);

    }

    private void login_onClick(){

        TextView login_link = findViewById(R.id.login_link);
        login_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(start);
            }
        });
    }

}