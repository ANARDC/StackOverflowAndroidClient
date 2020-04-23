package com.commodo.stackoverflow.Services;

import com.commodo.stackoverflow.Helpers.Method;

import java.io.IOException;

public interface NetworkServiceDelegate {
  String request(Method method) throws IOException;
}
