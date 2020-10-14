package no.ntnu.pentbrukt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Listing {

    @SerializedName("listingid")
    @Expose
    private long listingid;

    @SerializedName("listingTitle")
    @Expose
    private String listingTitle;

    @SerializedName("listingDesc")
    @Expose
    private String listingDesc;

    @SerializedName("listingPrice")
    @Expose
    private int listingPrice;

    @SerializedName("listingSeller")
    @Expose
    private String listingSeller;

    @SerializedName("listingPublished")
    @Expose
    private String listingPublished;

    @SerializedName("listingSold")
    @Expose
    private Boolean listingSold;

    @SerializedName("imageUrl")
    @Expose
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
                "listingid=" + listingid +
                ", listingTitle='" + listingTitle + '\'' +
                ", listingDesc='" + listingDesc + '\'' +
                ", listingPrice=" + listingPrice +
                ", listingSeller='" + listingSeller + '\'' +
                ", listingPublished='" + listingPublished + '\'' +
                ", listingSold=" + listingSold +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public long getListingid() {
        return listingid;
    }

    public void setListingid(long listingid) {
        this.listingid = listingid;
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

    public Boolean getListingSold() {
        return listingSold;
    }

    public void setListingSold(Boolean listingSold) {
        this.listingSold = listingSold;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
