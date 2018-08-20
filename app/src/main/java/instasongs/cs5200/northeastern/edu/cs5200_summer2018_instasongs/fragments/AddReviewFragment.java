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

import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.LandingActivity;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.R;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.adapters.ReviewSongListAdapter;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.adapters.SongListAdapter;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.vo.SongListValueObject;

public class AddReviewFragment extends Fragment {

    ReviewSongListAdapter mSongListAdapter;
    private RecyclerView mSongListView;
    private RecyclerView.LayoutManager layoutManager;
    SongListValueObject songList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,
                container, false);
        mSongListView = (RecyclerView) view.findViewById(R.id.recview_songs_list) ;
        mSongListView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        mSongListView.setLayoutManager(layoutManager);
        ((LandingActivity)getActivity()).sendLatestTrackRequestForReview();
        return view;
    }


    public void inflateSongListView(SongListValueObject songList){
        mSongListAdapter = new ReviewSongListAdapter(songList.getTracks().getTrack(),getActivity());
        mSongListView.setAdapter(mSongListAdapter);
    }
}
