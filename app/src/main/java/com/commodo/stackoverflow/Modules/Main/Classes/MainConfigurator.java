package com.commodo.stackoverflow.Modules.Main.Classes;

import com.commodo.stackoverflow.Modules.Main.Interfaces.MainActivityDelegate;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainConfiguratorDelegate;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainInteractorDelegate;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainPresenterDelegate;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainRouterDelegate;
import com.commodo.stackoverflow.Services.NetworkServiceTask;

public final class MainConfigurator implements MainConfiguratorDelegate {
  private MainPresenterDelegate presenter;

  MainConfigurator(MainActivityDelegate view) {
    NetworkServiceTask networkServiceTask = new NetworkServiceTask();
    MainInteractorDelegate interactor     = new MainInteractor(networkServiceTask);
    MainRouterDelegate router             = new MainRouter();
    this.presenter                        = new MainPresenter(view, interactor, router);
  }

  public void configure(MainActivityDelegate view) {
    view.set(this.presenter);
  }
}
