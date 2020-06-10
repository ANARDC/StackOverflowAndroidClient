package com.commodo.stackoverflow.Modules.Main.Classes;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.commodo.stackoverflow.Modules.Main.Interfaces.MainActivityInterface;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainConfiguratorInterface;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainPresenterInterface;
import com.commodo.stackoverflow.R;

import org.json.JSONException;

public final class MainActivity extends FragmentActivity implements MainActivityInterface {
  private PostsRecyclerViewFragment postsRecyclerViewFragment;

  private FragmentManager fragmentManager;
  private FragmentTransaction fragmentTransaction;

  private MainConfiguratorInterface configurator;
  MainPresenterInterface presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.configurator = new MainConfigurator(this);
    this.configurator.configure(this);
    try {
      this.presenter.onCreate();
    } catch (JSONException e) {
      e.printStackTrace();
    }
  }

  public void setPresenter(MainPresenterInterface presenter) {
    this.presenter = presenter;
  }

  public void makeView() {
    this.setContentView(R.layout.activity_main);
    this.postsRecyclerViewFragment = new PostsRecyclerViewFragment();
    this.fragmentManager = this.getSupportFragmentManager();
    this.fragmentTransaction = this.fragmentManager.beginTransaction();
    this.fragmentTransaction.add(R.id.view, this.postsRecyclerViewFragment);
    this.fragmentTransaction.commit();
  }

  public PostsRecyclerViewFragment getPostsRecyclerViewFragment() {
    return this.postsRecyclerViewFragment;
  }
}
