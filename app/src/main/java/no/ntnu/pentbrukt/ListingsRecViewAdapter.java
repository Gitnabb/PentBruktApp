package no.ntnu.pentbrukt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ListingsRecViewAdapter extends RecyclerView.Adapter<ListingsRecViewAdapter.ViewHolder> {


    //private ArrayList<Listing> listings = new ArrayList<>();
    private Context context;
    private ArrayList<Listing> listingsFromDB = new ArrayList<>();

    public ListingsRecViewAdapter(Context context, ArrayList<Listing> listingsFromDB) {

        this.context = context;
        this.listingsFromDB = listingsFromDB;

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

        holder.txtListingTitle.setText(listingsFromDB.get(position).getListingTitle());
        holder.txtListingPrice.setText("Pris: " + String.valueOf(listingsFromDB.get(position).getListingPrice()));
        holder.txtListingDesc.setText(listingsFromDB.get(position).getListingDesc());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, listingsFromDB.get(position).getListingTitle() + "clicked", Toast.LENGTH_SHORT).show();
            }
        });

        Glide.with(context)
                .asBitmap()
                .load(listingsFromDB.get(position).getImageUrl())
                .into(holder.listingImage);

    }

    @Override
    public int getItemCount() {
        return listingsFromDB.size();
    }

    public void setListings(ArrayList<Listing> listings) {
        this.listingsFromDB = listings;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtListingTitle, txtListingPrice, txtListingDesc;
        private CardView parent;
        private ImageView listingImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtListingTitle = itemView.findViewById(R.id.txtListingTitle);
            txtListingPrice = itemView.findViewById(R.id.txtListingPrice);
            txtListingDesc = itemView.findViewById(R.id.txtListingDesc);
            parent = itemView.findViewById(R.id.parent);

            listingImage = itemView.findViewById(R.id.listingImage);

        }
    }

}
