package com.commodo.stackoverflow.Modules.Main.Classes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.commodo.stackoverflow.Modules.Main.Interfaces.MainActivityInterface;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainConfiguratorInterface;
import com.commodo.stackoverflow.Modules.Main.Interfaces.MainPresenterInterface;
import com.commodo.stackoverflow.R;

public final class MainActivity extends AppCompatActivity implements MainActivityInterface {

  private RecyclerView postsRecyclerView;
  private PostsAdapter postsAdapter;

  private MainConfiguratorInterface configurator;
  MainPresenterInterface presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.configurator = new MainConfigurator(this);
    this.configurator.configure(this);
    this.presenter.onCreate();
  }

  public void set(MainPresenterInterface presenter) {
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
