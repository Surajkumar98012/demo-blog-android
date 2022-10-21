package com.example.demo_blog_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    blogAdapter adapter;
    List<blog> blogList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new blogAdapter(blogList);
        recyclerView.setAdapter(adapter);

        fetchBlogs();


    }

    private void fetchBlogs() {


        RetrofitClient.getRetrofitClient().getblogs().enqueue(new Callback<blogWrapper>() {
            @Override
            public void onResponse(Call<blogWrapper> call, Response<blogWrapper> response) {
                if (response.isSuccessful()&& response.body()!=null){
                    Toast.makeText(MainActivity.this,response.body().getblogs().toString(),Toast.LENGTH_SHORT).show();
                    //blogList.addAll(response.body());
                    //adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<blogWrapper> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}