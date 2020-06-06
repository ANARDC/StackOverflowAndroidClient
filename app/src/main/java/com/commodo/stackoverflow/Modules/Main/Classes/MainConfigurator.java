package com.commodo.stackoverflow.Modules.Main.Classes;

import com.commodo.stackoverflow.Modules.Main.Interfaces.MainActivityInterface;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainConfiguratorInterface;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainInteractorInterface;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainPresenterInterface;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainRouterInterface;
import com.commodo.stackoverflow.Services.NetworkServiceTask;

public final class MainConfigurator implements MainConfiguratorInterface {
  private MainPresenterInterface presenter;

  MainConfigurator(MainActivityInterface view) {
    NetworkServiceTask networkServiceTask = new NetworkServiceTask();
    MainInteractorInterface interactor    = new MainInteractor(networkServiceTask);
    MainRouterInterface router            = new MainRouter();
    this.presenter                        = new MainPresenter(view, interactor, router);
  }

  public void configure(MainActivityInterface view) {
    view.setPresenter(this.presenter);
  }
}
