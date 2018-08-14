package instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.LandingActivity;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.R;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.Singleton.PlaylistSingleton;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.adapters.SongInPlaylistAdapter;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.adapters.SongListAdapter;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities.Playlist;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities.Song;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.vo.SongListValueObject;

public class SonginPlayListFragment extends Fragment {

    SongInPlaylistAdapter mSongListAdapter;
    private RecyclerView mSongListView;
    private RecyclerView.LayoutManager layoutManager;
    private TextView mPlayListName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.song_in_playlist,
                container, false);
        mPlayListName = (TextView) view.findViewById(R.id.txt_playlist_name);
        mSongListView = (RecyclerView) view.findViewById(R.id.recview_songs_list) ;
        mSongListView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        mSongListView.setLayoutManager(layoutManager);
        wirePlayList();
        return view;
    }

    public void wirePlayList()
    {
        Playlist mPlayList = PlaylistSingleton.getInstance().getmPlaylists().get(PlaylistSingleton.getInstance().getmSelecetedPlayList());
        mPlayListName.setText(mPlayList.getName());
        mSongListAdapter = new SongInPlaylistAdapter(mPlayList.getSongs(),getActivity());
        mSongListView.setAdapter(mSongListAdapter);
    }

}
