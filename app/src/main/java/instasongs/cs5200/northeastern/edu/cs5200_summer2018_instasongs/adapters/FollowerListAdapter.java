package instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.R;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities.Playlist;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities.RegisteredUser;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.listeners.PlaylistItemClickListener;

public class FollowerListAdapter extends RecyclerView.Adapter<FollowerListAdapter.ViewHolder> {

    private List<RegisteredUser> values;


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

    public void add(int position, RegisteredUser item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public FollowerListAdapter(List<RegisteredUser> myDataset) {
        values = myDataset;
    }


    @NonNull
    @Override
    public FollowerListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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
    public void onBindViewHolder(@NonNull FollowerListAdapter.ViewHolder holder, final int position) {
        final RegisteredUser track = values.get(position);
        holder.txtFollowerName.setText(track.getFirstName()+track.getLastName());
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
