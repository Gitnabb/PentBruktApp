
package no.ntnu.pentbrukt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListingsFragment extends Fragment {

    private RecyclerView listingsRecView;
    private RelativeLayout relativeLayout;
    ArrayList<Listing> listings = new ArrayList<>();
    private ListingsRecViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragments_listings, container, false);

        listingsRecView = view.findViewById(R.id.listingsRecView);

        // TEST LISTINGS LIST :)
        listings.add(new Listing("Sykkel", "Bra sykkel.", 2500,
                "Hjalmar Gunnarsen", "idag", kidsbike));
        listings.add(new Listing("Sykkel2", "Bra sykkel.", 2600,
                "Hjalmar Gunnarsen", "idag", kidsbike));
        listings.add(new Listing("Sykkel3", "Bra sykkel.", 2700,
                "Hjalmar Gunnarsen", "idag", kidsbike));


        adapter = new ListingsRecViewAdapter();
        adapter.setListings(listings);

        listingsRecView.setAdapter(adapter);
        listingsRecView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        return view;
    }



    private String kidsbike = "https://www.jollyroom.no/storage/ma/b980f0dc5dad471bb41992711ae6c123/" +
            "8dee15e944df4f9db5d08bb4668de4f0/1156-1200-0-jpg.Jpeg/" +
            "2683EDE39BDC7997E175021C92EA5FBDBC22ABE6/EPB-1201-GREEN-2505_1.jpeg";

}
