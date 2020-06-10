package com.commodo.stackoverflow.Modules.Main.Interfaces;

import com.commodo.stackoverflow.Modules.Main.Classes.PostsRecyclerViewFragment;

public interface MainActivityInterface {
  void setPresenter(MainPresenterInterface presenter);

  void makeView();
  PostsRecyclerViewFragment getPostsRecyclerViewFragment();
}
