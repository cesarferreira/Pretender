package github.cesarferreira.sample.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import github.cesarferreira.pretender.models.FakeUser;
import github.cesarferreira.sample.R;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private static List<FakeUser> items;
    private int itemLayout;

    public UsersAdapter(List<FakeUser> items, int itemLayout) {
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FakeUser item = items.get(position);

        holder.titleTextView.setText(item.name.first + " " + item.name.last);
        holder.subtitleTextView.setText(item.email);

        setupImage(holder.imageView, item.picture.medium);

        holder.itemView.setTag(item);
    }

    private void setupImage(ImageView image, String imageUrl) {
        image.setImageBitmap(null);
        Picasso.with(image.getContext()).cancelRequest(image);
        Picasso.with(image.getContext()).load(imageUrl).into(image);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final Context mContext;

        @InjectView(R.id.image)
        public ImageView imageView;

        @InjectView(R.id.title)
        public TextView titleTextView;

        @InjectView(R.id.subtitle)
        public TextView subtitleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
            ButterKnife.inject(this, itemView);
        }

        @Override
        public void onClick(View v) {
            System.out.println("You clicked: " + getAdapterPosition());
        }
    }
}
