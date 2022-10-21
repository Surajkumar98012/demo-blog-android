package com.example.demo_blog_app;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL="http://prod-node.janelaaj.com:3000/blogs/";
    private static Retrofit retrofit=null;
    public static myApi getRetrofitClient(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


    }
       return retrofit.create(myApi.class);
    }
}
