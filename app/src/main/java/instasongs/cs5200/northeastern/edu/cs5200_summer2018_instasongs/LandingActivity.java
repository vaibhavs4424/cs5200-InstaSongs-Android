package instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.fragments.HomeFragment;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.fragments.SearchSongFragment;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.utilities.VolleySingleton;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.vo.SongListValueObject;
import instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.vo.songs.Example;

public class LandingActivity extends AppCompatActivity {

    private Fragment currFragment;
    private static final String TAG = LandingActivity.class.getName();
    private Button btnRequest;
    ObjectMapper mapper = new ObjectMapper();
    SongListValueObject songList;
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private DrawerLayout mDrawerLayout;
    private String SONG_LIST_URL = "http://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=1733cb589acd22eb69aab1c25efe0c2e&format=json";
    private Example searchQuery;
    private instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.vo.artists.Example artistSearchQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        switch (menuItem.getItemId()) {

                            case android.R.id.home:
                                mDrawerLayout.openDrawer(GravityCompat.START);
                                return true;
                            case R.id.Home:
                                currFragment = new HomeFragment();
                                switchFragments(currFragment);
                                return true;
                            case R.id.search_song:
                                currFragment = new SearchSongFragment();
                                switchFragments(currFragment);
                                return true;
                        }
                    return true;
                    }
                });
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("InstaSongs");
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        currFragment = new HomeFragment();
        switchFragments(currFragment);

    }


    public void switchFragments(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.contentFragment, fragment);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
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
                    ((HomeFragment) currFragment).inflateSongListView(songList);

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

    public void searchSongs(String trackName)
    {
        String URL  = "http://ws.audioscrobbler.com/2.0/?method=track.search&track="+trackName +"&api_key=1733cb589acd22eb69aab1c25efe0c2e&format=json";
        //RequestQueue initialized
        mRequestQueue = VolleySingleton.getInstance().getRequestQueue();

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    searchQuery = mapper.readValue(response.toString(), Example.class);

                    ((SearchSongFragment) currFragment).inflateSongListView(searchQuery);

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

    public void searchArtists(String artistName)
    {
        String URL  = "http://ws.audioscrobbler.com/2.0/?method=artist.search&artist="+artistName +"&api_key=1733cb589acd22eb69aab1c25efe0c2e&format=json";
        //RequestQueue initialized
        mRequestQueue = VolleySingleton.getInstance().getRequestQueue();

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    artistSearchQuery = mapper.readValue(response.toString(), instasongs.cs5200.northeastern.edu.cs5200_summer2018_instasongs.vo.artists.Example.class);

                    ((SearchSongFragment) currFragment).inflateArtists(artistSearchQuery);

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
