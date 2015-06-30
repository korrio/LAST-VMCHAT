package com.dev.chat.vdomax.model;

import java.util.ArrayList;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import android.os.Parcel;


public class Tattoo implements Parcelable{

    private static final String FIELD_ITEM_DESC = "item_desc";
    private static final String FIELD_PRICE = "price";
    private static final String FIELD_VOTE_ORDER = "vote_order";
    private static final String FIELD_COUNT_TATTOO = "count_tattoo";
    private static final String FIELD_USER_ITEM = "user_item";
    private static final String FIELD_PAYPERVIEW_MONTH = "payperview_month";
    private static final String FIELD_CATEGORY_NAME = "category_name";
    private static final String FIELD_IMGPATH = "imgpath";
    private static final String FIELD_OWNER = "owner";
    private static final String FIELD_ID = "id";
    private static final String FIELD_AVATAR_URL = "avatar_url";
    private static final String FIELD_ITEM_NAME = "item_name";
    private static final String FIELD_ITEM_SET_NAME = "item_set_name";
    private static final String FIELD_CREATE_BY_ID = "create_by_id";
    private static final String FIELD_SQL = "sql";
    private static final String FIELD_TATTOO_DAY = "tattoo_day";
    private static final String FIELD_VOTE_POINT = "vote_point";
    private static final String FIELD_ITEMSET = "itemset";
    private static final String FIELD_CREATE_BY_NAME = "create_by_name";


    @SerializedName(FIELD_ITEM_DESC)
    private String mItemDesc;
    @SerializedName(FIELD_PRICE)
    private int mPrice;
    @SerializedName(FIELD_VOTE_ORDER)
    private int mVoteOrder;
    @SerializedName(FIELD_COUNT_TATTOO)
    private int mCountTattoo;
    @SerializedName(FIELD_USER_ITEM)
    private int mUserItem;
    @SerializedName(FIELD_PAYPERVIEW_MONTH)
    private String mPayperviewMonth;
    @SerializedName(FIELD_CATEGORY_NAME)
    private String mCategoryName;
    @SerializedName(FIELD_IMGPATH)
    private String mImgpath;
    @SerializedName(FIELD_OWNER)
    private int mOwner;
    @SerializedName(FIELD_ID)
    private long mId;
    @SerializedName(FIELD_AVATAR_URL)
    private String mAvatarUrl;
    @SerializedName(FIELD_ITEM_NAME)
    private String mItemName;
    @SerializedName(FIELD_ITEM_SET_NAME)
    private String mItemSetName;
    @SerializedName(FIELD_CREATE_BY_ID)
    private int mCreateById;
    @SerializedName(FIELD_SQL)
    private String mSql;
    @SerializedName(FIELD_TATTOO_DAY)
    private int mTattooDay;
    @SerializedName(FIELD_VOTE_POINT)
    private int mVotePoint;
    @SerializedName(FIELD_ITEMSET)
    private List<String> mItemsets;
    @SerializedName(FIELD_CREATE_BY_NAME)
    private String mCreateByName;


    public Tattoo(){

    }

    public void setItemDesc(String itemDesc) {
        mItemDesc = itemDesc;
    }

    public String getItemDesc() {
        return mItemDesc;
    }

    public void setPrice(int price) {
        mPrice = price;
    }

    public int getPrice() {
        return mPrice;
    }

    public void setVoteOrder(int voteOrder) {
        mVoteOrder = voteOrder;
    }

    public int getVoteOrder() {
        return mVoteOrder;
    }

    public void setCountTattoo(int countTattoo) {
        mCountTattoo = countTattoo;
    }

    public int getCountTattoo() {
        return mCountTattoo;
    }

    public void setUserItem(int userItem) {
        mUserItem = userItem;
    }

    public int getUserItem() {
        return mUserItem;
    }

    public void setPayperviewMonth(String payperviewMonth) {
        mPayperviewMonth = payperviewMonth;
    }

    public String getPayperviewMonth() {
        return mPayperviewMonth;
    }

    public void setCategoryName(String categoryName) {
        mCategoryName = categoryName;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public void setImgpath(String imgpath) {
        mImgpath = imgpath;
    }

    public String getImgpath() {
        return mImgpath;
    }

    public void setOwner(int owner) {
        mOwner = owner;
    }

    public int getOwner() {
        return mOwner;
    }

    public void setId(long id) {
        mId = id;
    }

    public long getId() {
        return mId;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setItemName(String itemName) {
        mItemName = itemName;
    }

    public String getItemName() {
        return mItemName;
    }

    public void setItemSetName(String itemSetName) {
        mItemSetName = itemSetName;
    }

    public String getItemSetName() {
        return mItemSetName;
    }

    public void setCreateById(int createById) {
        mCreateById = createById;
    }

    public int getCreateById() {
        return mCreateById;
    }

    public void setSql(String sql) {
        mSql = sql;
    }

    public String getSql() {
        return mSql;
    }

    public void setTattooDay(int tattooDay) {
        mTattooDay = tattooDay;
    }

    public int getTattooDay() {
        return mTattooDay;
    }

    public void setVotePoint(int votePoint) {
        mVotePoint = votePoint;
    }

    public int getVotePoint() {
        return mVotePoint;
    }

    public void setItemsets(List<String> itemsets) {
        mItemsets = itemsets;
    }

    public List<String> getItemsets() {
        return mItemsets;
    }

    public void setCreateByName(String createByName) {
        mCreateByName = createByName;
    }

    public String getCreateByName() {
        return mCreateByName;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Tattoo){
            return ((Tattoo) obj).getId() == mId;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return ((Long)mId).hashCode();
    }

    public Tattoo(Parcel in) {
        mItemDesc = in.readString();
        mPrice = in.readInt();
        mVoteOrder = in.readInt();
        mCountTattoo = in.readInt();
        mUserItem = in.readInt();
        mPayperviewMonth = in.readString();
        mCategoryName = in.readString();
        mImgpath = in.readString();
        mOwner = in.readInt();
        mId = in.readLong();
        mAvatarUrl = in.readString();
        mItemName = in.readString();
        mItemSetName = in.readString();
        mCreateById = in.readInt();
        mSql = in.readString();
        mTattooDay = in.readInt();
        mVotePoint = in.readInt();
        in.readArrayList(String.class.getClassLoader());
        mCreateByName = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Tattoo> CREATOR = new Creator<Tattoo>() {
        public Tattoo createFromParcel(Parcel in) {
            return new Tattoo(in);
        }

        public Tattoo[] newArray(int size) {
        return new Tattoo[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mItemDesc);
        dest.writeInt(mPrice);
        dest.writeInt(mVoteOrder);
        dest.writeInt(mCountTattoo);
        dest.writeInt(mUserItem);
        dest.writeString(mPayperviewMonth);
        dest.writeString(mCategoryName);
        dest.writeString(mImgpath);
        dest.writeInt(mOwner);
        dest.writeLong(mId);
        dest.writeString(mAvatarUrl);
        dest.writeString(mItemName);
        dest.writeString(mItemSetName);
        dest.writeInt(mCreateById);
        dest.writeString(mSql);
        dest.writeInt(mTattooDay);
        dest.writeInt(mVotePoint);
        dest.writeList(mItemsets);
        dest.writeString(mCreateByName);
    }

    @Override
    public String toString(){
        return "itemDesc = " + mItemDesc + ", price = " + mPrice + ", voteOrder = " + mVoteOrder + ", countTattoo = " + mCountTattoo + ", userItem = " + mUserItem + ", payperviewMonth = " + mPayperviewMonth + ", categoryName = " + mCategoryName + ", imgpath = " + mImgpath + ", owner = " + mOwner + ", id = " + mId + ", avatarUrl = " + mAvatarUrl + ", itemName = " + mItemName + ", itemSetName = " + mItemSetName + ", createById = " + mCreateById + ", sql = " + mSql + ", tattooDay = " + mTattooDay + ", votePoint = " + mVotePoint + ", itemsets = " + mItemsets + ", createByName = " + mCreateByName;
    }


}