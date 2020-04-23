package com.commodo.stackoverflow.Modules.Main.Interfaces;

public interface MainActivityDelegate {
  void set(MainPresenterDelegate presenter);

  void makeView();
  void makePostsRecyclerView();
}
