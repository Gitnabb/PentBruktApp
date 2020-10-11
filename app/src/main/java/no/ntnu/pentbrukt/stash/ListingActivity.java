/*
package no.ntnu.pentbrukt.stash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import no.ntnu.pentbrukt.Listing;
import no.ntnu.pentbrukt.ListingsRecViewAdapter;
import no.ntnu.pentbrukt.R;

public class ListingActivity extends AppCompatActivity {

    private RecyclerView listingsRecView;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragments_listings);

        listingsRecView = findViewById(R.id.listingsRecView);

        ArrayList<Listing> listings = new ArrayList<>();
        listings.add(new Listing("Sykkel", "Bra sykkel.", 2500,
                "Hjalmar Gunnarsen", "idag", kidsbike));
        listings.add(new Listing("Sykkel2", "Bra sykkel.", 2600,
                "Hjalmar Gunnarsen", "idag", kidsbike));
        listings.add(new Listing("Sykkel3", "Bra sykkel.", 2700,
                "Hjalmar Gunnarsen", "idag", kidsbike));


        ListingsRecViewAdapter adapter = new ListingsRecViewAdapter();
        adapter.setListings(listings);

        listingsRecView.setAdapter(adapter);
        listingsRecView.setLayoutManager(new LinearLayoutManager(this));

    }

    private String kidsbike = "https://www.jollyroom.no/storage/ma/b980f0dc5dad471bb41992711ae6c123/" +
            "8dee15e944df4f9db5d08bb4668de4f0/1156-1200-0-jpg.Jpeg/" +
            "2683EDE39BDC7997E175021C92EA5FBDBC22ABE6/EPB-1201-GREEN-2505_1.jpeg";
}*/
