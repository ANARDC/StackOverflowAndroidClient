package com.commodo.stackoverflow.Services;

import com.commodo.stackoverflow.Helpers.Method;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Scanner;

final public class NetworkService implements NetworkServiceInterface {
  public String request(Method method) throws IOException {
    HttpURLConnection httpURLConnection = (HttpURLConnection) method.url().openConnection();
    try {
      InputStream inputStream = httpURLConnection.getInputStream();

      Scanner scanner = new Scanner(inputStream);
      scanner.useDelimiter("\\A");

      boolean hasInput = scanner.hasNext();

      if (hasInput) {
        return scanner.next();
      } else {
        return null;
      }
    } finally {
      httpURLConnection.disconnect();
    }
  }
}