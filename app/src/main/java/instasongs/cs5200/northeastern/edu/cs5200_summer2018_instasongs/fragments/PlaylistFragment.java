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
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;

import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.LandingActivity;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.R;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.Singleton.PlaylistSingleton;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.adapters.PlayListAdapter;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.adapters.SearchArtistAdapter;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.adapters.SearchSongAdapter;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities.Playlist;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.listeners.PlaylistItemClickListener;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.vo.songs.Example;

public class PlaylistFragment extends Fragment implements PlaylistItemClickListener{


    private EditText mPlaylistText;
    private ImageButton mCreatePlaylist;
    private RecyclerView mPlaylistView;
    private PlayListAdapter mPlaylistAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Playlist> mPlaylists;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playlist,
                container, false);
        mCreatePlaylist = (ImageButton) view.findViewById(R.id.btn_create_playlist);
        mPlaylistText = (EditText) view.findViewById(R.id.txt_create_playlist);
        mPlaylistView = (RecyclerView) view.findViewById(R.id.playlist_view);
        mPlaylistView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        mPlaylistView.setLayoutManager(layoutManager);
        ((LandingActivity)getActivity()).fetchPlaylists();

        mCreatePlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ((LandingActivity) getActivity()).createPlaylist(mPlaylistText.getText().toString());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
        return view;
    }


    public void inflatePlaylist(List<Playlist> playlists)
    {
        mPlaylists = playlists;
        mPlaylistAdapter = new PlayListAdapter(playlists,this);
        mPlaylistView.setAdapter(mPlaylistAdapter);
    }

    @Override
    public void onItemClick(View v, int position) {
        PlaylistSingleton.getInstance().setmSelecetedPlayList(position);
        ((LandingActivity) getActivity()).navigateToPlayListSongs(mPlaylists.get(position));
    }
}
