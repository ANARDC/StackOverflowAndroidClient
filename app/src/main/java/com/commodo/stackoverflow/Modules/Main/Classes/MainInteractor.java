package com.commodo.stackoverflow.Modules.Main.Classes;

import com.commodo.stackoverflow.Helpers.Method;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainInteractorInterface;
import com.commodo.stackoverflow.Services.NetworkServiceTask;

public final class MainInteractor implements MainInteractorInterface {
  private NetworkServiceTask networkServiceTask;

  MainInteractor(NetworkServiceTask networkServiceTask) {
    this.networkServiceTask = networkServiceTask;
  }

  public void setPosts(PostsRecyclerViewFragment fragment) {
    this.networkServiceTask.setPostsRecyclerViewFragment(fragment);
    this.networkServiceTask.execute(Method.posts);
  }
}
