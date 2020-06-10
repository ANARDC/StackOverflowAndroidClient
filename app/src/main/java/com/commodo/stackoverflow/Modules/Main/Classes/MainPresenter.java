package com.commodo.stackoverflow.Modules.Main.Classes;

import com.commodo.stackoverflow.Modules.Main.Interfaces.MainActivityInterface;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainInteractorInterface;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainPresenterInterface;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainRouterInterface;

public final class MainPresenter implements MainPresenterInterface {
  private MainActivityInterface view;
  private MainInteractorInterface interactor;
  private MainRouterInterface router;

  MainPresenter(MainActivityInterface view, MainInteractorInterface interactor, MainRouterInterface router) {
    this.view       = view;
    this.interactor = interactor;
    this.router     = router;
  }

  public void onCreate() {
    this.view.makeView();
    this.interactor.setPosts(this.view.getPostsRecyclerViewFragment());
  }
}
