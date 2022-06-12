package com.example.bnvtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.bnvtest.model.Category;
import com.example.bnvtest.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private String BASE_URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        recycler = findViewById(R.id.products);

        Intent intent = getIntent();
        int selected = intent.getIntExtra("SELECTED", 0);
        String name = intent.getStringExtra("NAME");

        TextView txv = findViewById(R.id.prod);
        txv.setText(name);
        BASE_URL = "http://10.0.2.2:84/project/get_prod_catid.php?catid="+selected;

        getProducts();
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }
    private void getProducts(){
        JsonArrayRequest request =new JsonArrayRequest(Request.Method.GET, BASE_URL,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                ArrayList<Product> products =new ArrayList<>();

                for (int i = 0; i < response.length(); i++){
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        products.add(new Product(obj.getInt("productId"), obj.getInt("catId"),
                                obj.getString("productName"), obj.getString("productImage"),
                                obj.getInt("price"), obj.getString("descrip"), obj.getInt("rateAvg"),
                                obj.getInt("rateCounter"), obj.getInt("likes")));

                    }catch(JSONException exception){
                        Log.d("Error", exception.toString());
                    }
                }
                PCardAdapter adapter = new PCardAdapter(products);
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