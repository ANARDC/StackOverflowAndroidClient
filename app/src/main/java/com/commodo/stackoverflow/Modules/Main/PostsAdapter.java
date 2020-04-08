package com.commodo.stackoverflow.Modules.Main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.commodo.stackoverflow.R;

public final class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder>{

  private static int viewHolderCount;
  private int numberOfItems;

  public PostsAdapter(int numberOfItems) {
    this.numberOfItems = numberOfItems;
    PostsAdapter.viewHolderCount = 0;
  }

  @SuppressLint("SetTextI18n")
  @NonNull
  @Override
  public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    int layoutIdForPostItem = R.layout.posts_list_item;

    LayoutInflater inflater = LayoutInflater.from(context);

    View view = inflater.inflate(layoutIdForPostItem, parent, false);

    PostViewHolder viewHolder = new PostViewHolder(view);
    viewHolder.viewHolderIndex.setText("ViewHolder index: " + PostsAdapter.viewHolderCount);

    PostsAdapter.viewHolderCount++;

    return viewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return this.numberOfItems;
  }

  final class PostViewHolder extends RecyclerView.ViewHolder {

    TextView postItemNumberView;
    TextView viewHolderIndex;

    public PostViewHolder(@NonNull View itemView) {
      super(itemView);

      this.postItemNumberView = itemView.findViewById(R.id.post_item_number);
      this.viewHolderIndex = itemView.findViewById(R.id.post_view_holder_number);
    }

    void bind(int postIndex) {
      this.postItemNumberView.setText(String.valueOf(postIndex));
    }
  }
}
