package com.commodo.stackoverflow.Services;

import java.io.IOException;
import java.net.URL;

public interface NetworkServiceDelegate {
  String request(URL url) throws IOException;
}

