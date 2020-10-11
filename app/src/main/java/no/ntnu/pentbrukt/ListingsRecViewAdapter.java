package no.ntnu.pentbrukt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListingsRecViewAdapter extends RecyclerView.Adapter<ListingsRecViewAdapter.ViewHolder> {


    private ArrayList<Listing> listings = new ArrayList<>();

    public ListingsRecViewAdapter() {



    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.listings_list_item, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.txtListingName.setText(listings.get(position).getListingTitle());


    }

    @Override
    public int getItemCount() {
        return listings.size();
    }

    public void setListings(ArrayList<Listing> listings) {
        this.listings = listings;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtListingName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtListingName = itemView.findViewById(R.id.txtListingName);

        }
    }

}
