package instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.adapters.SongListAdapter;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.fragments.HomeFragment;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.utilities.VolleySingleton;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.vo.SongListValueObject;

public class SplashScreen extends AppCompatActivity {


    SongListAdapter mSongListAdapter;
    private RecyclerView mSongListView;
    private RecyclerView.LayoutManager layoutManager;
    SongListValueObject songList;
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private static final String TAG = LandingActivity.class.getName();
    private ObjectMapper mapper = new ObjectMapper();
    private Button mLogin;
    private String SONG_LIST_URL = "http://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=1733cb589acd22eb69aab1c25efe0c2e&format=json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mLogin = (Button) findViewById(R.id.go_to_login) ;
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(i);
            }
        });
        mSongListView = (RecyclerView) findViewById(R.id.recview_songs_list) ;
        mSongListView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        mSongListView.setLayoutManager(layoutManager);
       sendLatestTrackRequest();

    }

    public void inflateSongListView(SongListValueObject songList){
        mSongListAdapter = new SongListAdapter(songList.getTracks().getTrack(),this);
        mSongListView.setAdapter(mSongListAdapter);
    }


    public void sendLatestTrackRequest(){

        //RequestQueue initialized
        mRequestQueue = VolleySingleton.getInstance().getRequestQueue();

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, SONG_LIST_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    songList = mapper.readValue(response.toString(), SongListValueObject.class);
                    inflateSongListView(songList);

                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                // Toast.makeText(getApplicationContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i(TAG,"Error :" + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
    }
}
