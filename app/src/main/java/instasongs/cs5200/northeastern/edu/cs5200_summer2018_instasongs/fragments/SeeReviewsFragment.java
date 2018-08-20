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

import java.util.List;

import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.LandingActivity;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.R;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.adapters.ReviewListaAdapter;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.adapters.SongInPlaylistAdapter;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities.Review;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.entities.Song;

public class SeeReviewsFragment extends Fragment {

    private RecyclerView mReviewList;
    private RecyclerView.LayoutManager layoutManager;
    private ReviewListaAdapter mReviewListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,
                container, false);
        mReviewList = (RecyclerView) view.findViewById(R.id.recview_songs_list);
        mReviewList.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        mReviewList.setLayoutManager(layoutManager);
        ((LandingActivity) getActivity()).getAllReviews();

        return view;
    }


    public void inflateReviews(List<Review> reviews){
        mReviewListAdapter = new ReviewListaAdapter(reviews,getActivity());
        mReviewList.setAdapter(mReviewListAdapter);
    }


     public void setSongDetails(ReviewListaAdapter.ViewHolder holder, int position, Song song)
    {
        mReviewListAdapter.setSongDetails(holder,position,song);
    }

}
