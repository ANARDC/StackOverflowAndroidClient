package com.commodo.stackoverflow.Modules.Main.Classes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.commodo.stackoverflow.Entities.Response;
import com.commodo.stackoverflow.R;

public final class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder>{
  private Response response;
  private int numberOfItems;

  public PostsAdapter(Response response) {
    this.response = response;
    this.numberOfItems = response.items.size();
  }

  @SuppressLint("SetTextI18n")
  @NonNull
  @Override
  public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    int layoutIdForPostItem = R.layout.posts_list_item;

    LayoutInflater inflater = LayoutInflater.from(context);

    View view = inflater.inflate(layoutIdForPostItem, parent, false);

    return new PostViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
    holder.makePostItemNumberView(position);
    holder.makeViewHolderIndexView(this.response.items.get(position).title);
  }

  @Override
  public int getItemCount() {
    return this.numberOfItems;
  }

  final class PostViewHolder extends RecyclerView.ViewHolder {
    TextView postItemNumberView;
    TextView viewHolderIndexView;

    public PostViewHolder(@NonNull View itemView) {
      super(itemView);

      this.postItemNumberView = itemView.findViewById(R.id.post_item_number);
      this.viewHolderIndexView = itemView.findViewById(R.id.post_view_holder_number);
    }

    void makePostItemNumberView(int postIndex) {
      this.postItemNumberView.setText(String.valueOf(postIndex));
    }

    void makeViewHolderIndexView(String title) {
      this.viewHolderIndexView.setText(title);
    }
  }
}
