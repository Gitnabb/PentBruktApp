package no.ntnu.pentbrukt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListingsRecViewAdapter extends RecyclerView.Adapter<ListingsRecViewAdapter.ViewHolder> {


    private ArrayList<Listing> listings = new ArrayList<>();
    private Context context;

    public ListingsRecViewAdapter(Context context) {

        this.context = context;


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
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.txtListingTitle.setText(listings.get(position).getListingTitle());
        holder.txtListingPrice.setText("Pris: " + String.valueOf(listings.get(position).getListingPrice()));
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, listings.get(position).getListingTitle() + "clicked", Toast.LENGTH_SHORT).show();
            }
        });

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
        private TextView txtListingTitle, txtListingPrice;
        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtListingTitle = itemView.findViewById(R.id.txtListingTitle);
            txtListingPrice = itemView.findViewById(R.id.txtListingPrice);
            parent = itemView.findViewById(R.id.parent);

        }
    }

}
