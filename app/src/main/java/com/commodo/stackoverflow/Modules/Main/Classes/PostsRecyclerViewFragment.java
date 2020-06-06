package com.commodo.stackoverflow.Modules.Main.Classes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.commodo.stackoverflow.R;

public class PostsRecyclerViewFragment extends Fragment {
  private RecyclerView postsRecyclerView;
  private PostsAdapter postsAdapter;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.posts_recycler_view, container, false);

    this.postsRecyclerView = view.findViewById(R.id.posts);

    LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
    this.postsRecyclerView.setLayoutManager(layoutManager);

    this.postsAdapter = new PostsAdapter(100);
    this.postsRecyclerView.setAdapter(this.postsAdapter);

    return view;
  }
}
