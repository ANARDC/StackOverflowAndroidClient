package com.commodo.stackoverflow.Services;

import android.os.AsyncTask;

import com.commodo.stackoverflow.Helpers.Method;

import java.io.IOException;

final public class NetworkServiceTask extends AsyncTask<Method, Void, String> {

  @Override
  protected String doInBackground(Method... methods) {
    NetworkServiceDelegate networkServiceDelegate = new NetworkService();

    String response = null;

    try {
      response = networkServiceDelegate.request(methods[0]);
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
