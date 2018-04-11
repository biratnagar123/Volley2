package com.org.curesoft.volley2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {



    Button button;
    TextView text;
    String Url="http://192.168.51.2/greetings.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.bGet);
        text= (TextView) findViewById(R.id.res);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             StringRequest request=new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
                 @Override
                 public void onResponse(String response) {
                  text.setText(response);
                 }
             }, new Response.ErrorListener() {
                 @Override
                 public void onErrorResponse(VolleyError error) {
                  text.setText("something went wrong");
                 }
             });
                Mysingleton.getInstance(getApplicationContext()).addToRequestQueue(request);
            }
        });
    }
}
