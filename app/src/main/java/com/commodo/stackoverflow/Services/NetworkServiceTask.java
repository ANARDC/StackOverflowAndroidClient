package com.commodo.stackoverflow.Services;

import android.os.AsyncTask;

import com.commodo.stackoverflow.Entities.Response;
import com.commodo.stackoverflow.Helpers.Method;
import com.commodo.stackoverflow.Modules.Main.Classes.PostsAdapter;
import com.commodo.stackoverflow.Modules.Main.Classes.PostsRecyclerViewFragment;
import com.google.gson.Gson;

import java.io.IOException;

final public class NetworkServiceTask extends AsyncTask<Method, Void, String> {
  PostsRecyclerViewFragment fragment;

  public void setPostsRecyclerViewFragment(PostsRecyclerViewFragment fragment) {
    this.fragment = fragment;
  }

  protected String doInBackground(Method... methods) {
    NetworkServiceInterface networkServiceInterface = new NetworkService();

    String response = null;

    try {
      response = networkServiceInterface.request(methods[0]);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return response;
  }

  protected void onPostExecute(String responseString) {
    Gson gson = new Gson();
    Response response = gson.fromJson(responseString, Response.class);

    this.fragment.postsAdapter = new PostsAdapter(response);
    this.fragment.postsRecyclerView.setAdapter(this.fragment.postsAdapter);
  }
}
