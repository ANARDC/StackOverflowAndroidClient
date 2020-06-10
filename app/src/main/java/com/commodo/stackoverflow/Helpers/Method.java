package com.commodo.stackoverflow.Helpers;

import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

public enum Method {
  posts;

  public URL url() {
    String base_url    = "https://api.stackexchange.com";
    String api_version = "/2.2";
    String method      = "/" + this.toString();
    String filter      = "!*MFq*0D.VWKZHCG9";

    Uri uri = Uri.parse(base_url + api_version + method)
            .buildUpon()
            .appendQueryParameter("order", "desc")
            .appendQueryParameter("sort", "activity")
            .appendQueryParameter("site", "stackoverflow")
            .appendQueryParameter("filter", filter)
            .build();

    URL url = null;

    try {
      url = new URL(uri.toString());
//      url = new URL("https://api.stackexchange.com/2.2/posts?page=1&pagesize=1&order=desc&sort=activity&site=stackoverflow&filter=!7v48hZEO)sgLGmW2-Yu2K0o-DW32003vEm");
    } catch (MalformedURLException error) {
      error.printStackTrace();
    }

    return url;
  }
}