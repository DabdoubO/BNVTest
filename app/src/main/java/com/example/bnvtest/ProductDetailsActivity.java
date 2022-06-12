package com.example.bnvtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.bnvtest.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ProductDetailsActivity extends AppCompatActivity {
    Context context = this;
    private String BASE_URL;
    TextView name;
    ImageView image;
    TextView price;
    TextView description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        name = findViewById(R.id.product_name);
        image = findViewById(R.id.product_image);
        price = findViewById(R.id.product_price);
        description = findViewById(R.id.product_disc);

        Intent intent = getIntent();
        int selected = intent.getIntExtra("SELECTED", 0);


        BASE_URL = "http://10.0.2.2:84/project/get_prod_prodid.php?productid="+selected;

        getProductInfo();


    }

    private void getProductInfo(){
        JsonArrayRequest request =new JsonArrayRequest(Request.Method.GET, BASE_URL,
                null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Product product = new Product();
                try {
                    JSONObject obj = response.getJSONObject(0);

                    product.setProductId(obj.getInt("productId"));
                    product.setCatId(obj.getInt("catId"));
                    product.setProductName(obj.getString("productName"));
                    product.setProductImage(obj.getString("productImage"));
                    product.setPrice(obj.getInt("price"));
                    product.setDescrip(obj.getString("descrip"));
                    product.setRateAvg(obj.getInt("rateAvg"));
                    product.setRateCounter(obj.getInt("rateCounter"));
                    product.setLikes(obj.getInt("likes"));


                } catch(JSONException exception){
                    Log.d("Error", exception.toString());
                }
                name.setText(product.getProductName());
                Glide.with(context).load(product.getProductImage()).into(image);
                price.setText(product.getPrice() + " $");
                description.setText(product.getDescrip());


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
                Toast.makeText(ProductDetailsActivity.this, message,
                        Toast.LENGTH_SHORT).show();
                Log.d("Error_json", message);
            }
        });
        Volley.newRequestQueue(ProductDetailsActivity.this).add(request);
    }

}