package com.commodo.stackoverflow.Modules.Main;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.commodo.stackoverflow.Helpers.URLFactory;
import com.commodo.stackoverflow.R;
import com.commodo.stackoverflow.Services.NetworkService;
import com.commodo.stackoverflow.Services.NetworkServiceDelegate;

import java.io.IOException;
import java.net.URL;

public final class MainActivity extends AppCompatActivity {

  private RecyclerView postsRecyclerView;
  private PostsAdapter postsAdapter;

  class NetworkServiceTask extends AsyncTask<URL, Void, String> {

    @Override
    protected String doInBackground(URL... urls) {
      NetworkServiceDelegate networkServiceDelegate = new NetworkService();

      String response = null;

      try {
        response = networkServiceDelegate.request(urls[0]);
      } catch (IOException e) {
        e.printStackTrace();
      }

      return response;
    }

    @Override
    protected void onPostExecute(String response) {
      System.out.println(response);
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_main);
    this.makePostsRecyclerView();


    URL url = URLFactory.posts.get();
    this.makeRequestFor(url);
  }

  void makeRequestFor(URL url) {
    new NetworkServiceTask().execute(url);
  }

  void makePostsRecyclerView() {
    this.postsRecyclerView = findViewById(R.id.posts);

    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    this.postsRecyclerView.setLayoutManager(layoutManager);

    this.postsRecyclerView.setHasFixedSize(true);

    this.postsAdapter = new PostsAdapter(100);
    this.postsRecyclerView.setAdapter(this.postsAdapter);
  }
}
