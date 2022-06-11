package com.example.bnvtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
import com.android.volley.toolbox.Volley;
import com.example.bnvtest.model.Category;
import com.example.bnvtest.model.MenuMockUp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    private RequestQueue queue;
    private RecyclerView recycler;
    private static  final String BASE_URL = "http://10.0.2.2:84/project/get_products.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        recycler = findViewById(R.id.products);

        Intent intent = getIntent();
        String selected = intent.getStringExtra("SELECTED");

        TextView txv = findViewById(R.id.prod);
        txv.setText(selected);


        getCat();
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }
    private void getCat(){
        JsonArrayRequest request =new JsonArrayRequest(Request.Method.GET, BASE_URL,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                ArrayList<Category> categories =new ArrayList<>();

                for (int i = 0; i < response.length(); i++){
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        categories.add(new Category(obj.getInt("catId"), obj.getString("catName"),
                                obj.getString("catImage")));

                    }catch(JSONException exception){
                        Log.d("Error", exception.toString());
                    }
                }
                CardAdapter adapter = new CardAdapter(categories);
                recycler.setAdapter(adapter);

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
                Toast.makeText(ProductActivity.this, message,
                        Toast.LENGTH_SHORT).show();
                Log.d("Error_json", message);
            }
        });
        Volley.newRequestQueue(ProductActivity.this).add(request);
    }
}