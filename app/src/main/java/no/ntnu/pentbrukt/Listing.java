package no.ntnu.pentbrukt;

import com.google.gson.annotations.SerializedName;

public class Listing {

    private String listingTitle;
    @SerializedName("body")
    private String listingDesc;
    private int listingPrice;
    private String listingSeller;
    private String listingPublished;

    private String imageUrl;

    public Listing(String listingTitle, String listingDesc,
                   int listingPrice, String listingSeller,
                   String listingPublished, String imageUrl) {
        this.listingTitle = listingTitle;
        this.listingDesc = listingDesc;
        this.listingPrice = listingPrice;
        this.listingSeller = listingSeller;
        this.listingPublished = listingPublished;
        this.imageUrl = imageUrl;
    }


    @Override
    public String toString() {
        return "Listing{" +
                "listingTitle='" + listingTitle + '\'' +
                ", listingDesc='" + listingDesc + '\'' +
                ", listingPrice=" + listingPrice +
                ", listingSeller='" + listingSeller + '\'' +
                ", listingPublished='" + listingPublished + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public String getListingTitle() {
        return listingTitle;
    }

    public void setListingTitle(String listingTitle) {
        this.listingTitle = listingTitle;
    }

    public String getListingDesc() {
        return listingDesc;
    }

    public void setListingDesc(String listingDesc) {
        this.listingDesc = listingDesc;
    }

    public int getListingPrice() {
        return listingPrice;
    }

    public void setListingPrice(int listingPrice) {
        this.listingPrice = listingPrice;
    }

    public String getListingSeller() {
        return listingSeller;
    }

    public void setListingSeller(String listingSeller) {
        this.listingSeller = listingSeller;
    }

    public String getListingPublished() {
        return listingPublished;
    }

    public void setListingPublished(String listingPublished) {
        this.listingPublished = listingPublished;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
