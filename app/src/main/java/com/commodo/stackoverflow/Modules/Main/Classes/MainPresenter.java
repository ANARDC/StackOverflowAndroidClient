package com.commodo.stackoverflow.Modules.Main.Classes;

import com.commodo.stackoverflow.Modules.Main.Interfaces.MainActivityDelegate;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainInteractorDelegate;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainPresenterDelegate;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainRouterDelegate;

public final class MainPresenter implements MainPresenterDelegate {
  private MainActivityDelegate   view;
  private MainInteractorDelegate interactor;
  private MainRouterDelegate     router;

  MainPresenter(MainActivityDelegate view, MainInteractorDelegate interactor, MainRouterDelegate router) {
    this.view       = view;
    this.interactor = interactor;
    this.router     = router;
  }

  public void onCreate() {
    this.view.makeView();
    this.view.makePostsRecyclerView();
    System.out.println(this.interactor.getPosts());
  }
}
