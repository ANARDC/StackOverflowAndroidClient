package com.commodo.stackoverflow.Modules.Main.Classes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.commodo.stackoverflow.Modules.Main.Interfaces.MainActivityDelegate;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainConfiguratorDelegate;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainPresenterDelegate;
import com.commodo.stackoverflow.R;

public final class MainActivity extends AppCompatActivity implements MainActivityDelegate {

  private RecyclerView postsRecyclerView;
  private PostsAdapter postsAdapter;

  private MainConfiguratorDelegate configurator;
  MainPresenterDelegate presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.configurator = new MainConfigurator(this);
    this.configurator.configure(this);
    this.presenter.onCreate();
  }

  public void set(MainPresenterDelegate presenter) {
    this.presenter = presenter;
  }

  public void makeView() {
    this.setContentView(R.layout.activity_main);
  }

  public void makePostsRecyclerView() {
    this.postsRecyclerView = findViewById(R.id.posts);

    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    this.postsRecyclerView.setLayoutManager(layoutManager);

    this.postsRecyclerView.setHasFixedSize(true);

    this.postsAdapter = new PostsAdapter(100);
    this.postsRecyclerView.setAdapter(this.postsAdapter);
  }
}
