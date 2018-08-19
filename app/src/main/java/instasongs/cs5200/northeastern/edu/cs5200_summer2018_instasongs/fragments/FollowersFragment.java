package instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.List;

import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.LandingActivity;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.R;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.Singleton.PlaylistSingleton;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.Singleton.UserSingleton;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.adapters.FollowerListAdapter;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.adapters.PlayListAdapter;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities.Playlist;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities.RegisteredUser;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.listeners.PlaylistItemClickListener;

public class FollowersFragment extends Fragment{


    private RecyclerView mFollowerListView;
    private FollowerListAdapter mPlaylistAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<RegisteredUser> mPlaylists;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_followers,
                container, false);
        mFollowerListView = (RecyclerView) view.findViewById(R.id.follower_list);
        mFollowerListView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        mFollowerListView.setLayoutManager(layoutManager);
        inflatePlaylist(UserSingleton.getInstance().getArtist().getFollowers());
        return view;
    }


    public void inflatePlaylist(List<RegisteredUser> playlists)
    {
        mPlaylists = playlists;
        mPlaylistAdapter = new FollowerListAdapter(playlists);
        mFollowerListView.setAdapter(mPlaylistAdapter);
    }

}
