package instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.R;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities.Artist;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities.RegisteredUser;

public class FollowingListAdapter extends RecyclerView.Adapter<FollowingListAdapter.ViewHolder> {

    private List<Artist> values;


    public class ViewHolder extends RecyclerView.ViewHolder{
        // each data item is just a string in this case
        public TextView txtFollowerName;

        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtFollowerName = (TextView) v.findViewById(R.id.txt_playlist_name);

        }

    }

    public void add(int position, Artist item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public FollowingListAdapter(List<Artist> myDataset) {
        values = myDataset;
    }


    @NonNull
    @Override
    public FollowingListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.playlist_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull FollowingListAdapter.ViewHolder holder, final int position) {
        final Artist track = values.get(position);
        holder.txtFollowerName.setText(track.getFirstName()+track.getLastName());
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
