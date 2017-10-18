package com.yg.yourexhibit.App;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.tsengvn.typekit.Typekit;
import com.yg.yourexhibit.Retrofit.NetworkService;
import com.yg.yourexhibit.Retrofit.RetrofitGet.ExhibitCollectionDetailResult;
import com.yg.yourexhibit.Retrofit.RetrofitGet.ExhibitCollectionResult;
import com.yg.yourexhibit.Retrofit.RetrofitGet.ExhibitComingResult;
import com.yg.yourexhibit.Retrofit.RetrofitGet.ExhibitDetailResult;
import com.yg.yourexhibit.Retrofit.RetrofitGet.ExhibitEndResult;
import com.yg.yourexhibit.Retrofit.RetrofitGet.ExhibitGoingResult;
import com.yg.yourexhibit.Retrofit.RetrofitGet.ExhibitSearchResponse;
import com.yg.yourexhibit.Retrofit.RetrofitGet.ExhibitWorkResult;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 2yg on 2017. 10. 8..
 */

public class ApplicationController extends Application{
    public final static String baseUrl = "http://52.78.97.61:3000/api/";
    public static Context appContext = null;
    private static ApplicationController instance;
    private NetworkService networkService;

    private ArrayList<ExhibitEndResult> exhibitEndResult;
    private ArrayList<ExhibitGoingResult> exhibitGoingResult;
    private ArrayList<ExhibitComingResult> exhibitComingResult;
    private ExhibitDetailResult exhibitDetailResult;
    private ArrayList<ExhibitSearchResponse> exhibitSearchResult;


    private ArrayList<ExhibitCollectionResult> exhibitCollectionResultFirst;
    private ArrayList<ExhibitCollectionResult> exhibitCollectionResultSecond;
    private ArrayList<ExhibitCollectionResult> exhibitCollectionResultThird;



    private ExhibitCollectionDetailResult exhibitCollectionDetailResult;



    private ArrayList<ExhibitWorkResult> exhibitWorkResult;

    private int collectionSize = 0;

    public String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImFrc2d1ciIsIm5pY2tuYW1lIjoiYWtzZ3VyIiwiaWF0IjoxNTA4MjI4NzY3LCJleHAiOjE1MDgyNjQ3Njd9.h0MqLTeUR6tuylOv4FTDd6wPsuQNWLru8lsaGrvR4QA";


    private boolean fromDetail = false;

    @Override public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();

        instance = this;
        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this,"NanumGothic.otf"))
                .addBold(Typekit.createFromAsset(this,"NanumGothicBold.otf"))
                .addCustom1(Typekit.createFromAsset(this, "NanumGothicExtraBold.otf"));

        //FacebookSdk.sdkInitialize(getApplicationContext());
        buildNetwork();
    }


    public void buildNetwork() {
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        networkService = retrofit.create(NetworkService.class);

    }

    public static ApplicationController getInstance() {
        return instance;
    }
    public NetworkService getNetworkService() {
        return networkService;
    }
    public void makeToast(String message){
        Toast.makeText(appContext, message, Toast.LENGTH_SHORT).show();
    }

    public ArrayList<ExhibitEndResult> getExhibitEndResult() {
        return exhibitEndResult;
    }

    public void setExhibitEndResult(ArrayList<ExhibitEndResult> exhibitEndResult) {
        this.exhibitEndResult = exhibitEndResult;
    }

    public ArrayList<ExhibitGoingResult> getExhibitGoingResult() {
        return exhibitGoingResult;
    }

    public void setExhibitGoingResult(ArrayList<ExhibitGoingResult> exhibitGoingResult) {
        this.exhibitGoingResult = exhibitGoingResult;
    }

    public ArrayList<ExhibitComingResult> getExhibitComingResult() {
        return exhibitComingResult;
    }

    public void setExhibitComingResult(ArrayList<ExhibitComingResult> exhibitComingResult) {
        this.exhibitComingResult = exhibitComingResult;
    }

    public ExhibitDetailResult getExhibitDetailResult() {
        return exhibitDetailResult;
    }

    public void setExhibitDetailResult(ExhibitDetailResult exhibitDetailResult) {
        this.exhibitDetailResult = exhibitDetailResult;
    }

    public ArrayList<ExhibitSearchResponse> getExhibitSearchResult() {
        return exhibitSearchResult;
    }

    public void setExhibitSearchResult(ArrayList<ExhibitSearchResponse> exhibitSearchResult) {
        this.exhibitSearchResult = exhibitSearchResult;
    }

    public ArrayList<ExhibitCollectionResult> getExhibitCollectionResultFirst() {
        return exhibitCollectionResultFirst;
    }

    public void setExhibitCollectionResultFirst(ArrayList<ExhibitCollectionResult> exhibitCollectionResultFirst) {
        this.exhibitCollectionResultFirst = exhibitCollectionResultFirst;
    }

    public ArrayList<ExhibitCollectionResult> getExhibitCollectionResultSecond() {
        return exhibitCollectionResultSecond;
    }

    public void setExhibitCollectionResultSecond(ArrayList<ExhibitCollectionResult> exhibitCollectionResultSecond) {
        this.exhibitCollectionResultSecond = exhibitCollectionResultSecond;
    }

    public ArrayList<ExhibitCollectionResult> getExhibitCollectionResultThird() {
        return exhibitCollectionResultThird;
    }

    public void setExhibitCollectionResultThird(ArrayList<ExhibitCollectionResult> exhibitCollectionResultThird) {
        this.exhibitCollectionResultThird = exhibitCollectionResultThird;
    }

    public ArrayList<ExhibitWorkResult> getExhibitWorkResult() {
        return exhibitWorkResult;
    }

    public void setExhibitWorkResult(ArrayList<ExhibitWorkResult> exhibitWorkResult) {
        this.exhibitWorkResult = exhibitWorkResult;
    }

    public int getCollectionSize() {
        return collectionSize;
    }

    public void setCollectionSize(int collectionSize) {
        this.collectionSize = collectionSize;
    }

    public ExhibitCollectionDetailResult getExhibitCollectionDetailResult() {
        return exhibitCollectionDetailResult;
    }

    public void setExhibitCollectionDetailResult(ExhibitCollectionDetailResult exhibitCollectionDetailResult) {
        this.exhibitCollectionDetailResult = exhibitCollectionDetailResult;
    }



    public boolean isFromDetail() {
        return fromDetail;
    }

    public void setFromDetail(boolean fromDetail) {
        this.fromDetail = fromDetail;
    }
}
