package com.example.demo_blog_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class blogAdapter extends RecyclerView.Adapter<blogAdapter.blogHolder> {

    private Context context;
    private List<blog> blogList;

    public blogAdapter(List<blog> blogs){
        this.context = context;
        blogList = blogs;
    }

    @NonNull
    @Override
    public blogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item , parent , false);
        return new blogHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull blogHolder holder, int position) {
        blog blog = blogList.get(position);
        holder.title.setText(blog.getTitle());
        holder.description.setText(blog.getDescription());
        Glide.with(context).load(blog.getPoster()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return blogList.size();
    }

    public class blogHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title ,description;
        ConstraintLayout constraintLayout;

        public blogHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            constraintLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}
