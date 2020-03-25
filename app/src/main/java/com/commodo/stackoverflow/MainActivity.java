package com.commodo.stackoverflow;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public final class MainActivity extends AppCompatActivity {

    private RecyclerView postsRecyclerView;
    private PostsAdapter postsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        this.postsRecyclerView = findViewById(R.id.posts);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        this.postsRecyclerView.setLayoutManager(layoutManager);

        this.postsRecyclerView.setHasFixedSize(true);

        this.postsAdapter = new PostsAdapter(100);
        this.postsRecyclerView.setAdapter(this.postsAdapter);
    }
}
