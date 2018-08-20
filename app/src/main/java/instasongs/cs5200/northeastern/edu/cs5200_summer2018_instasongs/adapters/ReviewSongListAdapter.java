package instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.R;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.fragments.AddReviewDialogFragment;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.fragments.PlaylistDialogFragment;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.utilities.VolleySingleton;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.vo.Track;

public class ReviewSongListAdapter extends RecyclerView.Adapter<ReviewSongListAdapter.ViewHolder> {

    private List<Track> values;
    private ImageLoader mImageLoader;
    private Context context;


    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtSongName;
        public TextView txtArtistName;
        private NetworkImageView songThumbnail;
        public View layout;
        public ImageButton mAddToPlayList;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtSongName = (TextView) v.findViewById(R.id.song_name);
            txtArtistName = (TextView) v.findViewById(R.id.artist_name);
            songThumbnail = (NetworkImageView) v.findViewById(R.id.song_image_thumbnail);
            mAddToPlayList = (ImageButton) v.findViewById(R.id.add_to_playlist);
        }
    }

    public void add(int position, Track item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ReviewSongListAdapter(List<Track> myDataset, Context context) {
        values = myDataset;
        this.context = context;
    }

    @NonNull
    @Override
    public ReviewSongListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.song_item_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewSongListAdapter.ViewHolder holder, final int position) {
        final Track track = values.get(position);
        holder.txtSongName.setText(track.getName());
        holder.txtArtistName.setText(track.getArtist().getName());
        mImageLoader = VolleySingleton.getInstance().getImageLoader();
        holder.songThumbnail.setImageUrl(track.getImage().get(3).getText(),mImageLoader);
        holder.mAddToPlayList.setImageResource(R.drawable.add_review);
        holder.mAddToPlayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentActivity activity = (FragmentActivity)(context);
                FragmentManager fm = activity.getSupportFragmentManager();
                AddReviewDialogFragment alertDialog = new AddReviewDialogFragment();
                alertDialog.setmTrack(track);
                alertDialog.show(fm,"Review Dialog");

            }
        });
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
