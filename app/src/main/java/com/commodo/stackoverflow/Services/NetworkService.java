package com.commodo.stackoverflow.Services;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class NetworkService implements NetworkServiceDelegate {
  public String request(URL url) throws IOException {
    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
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