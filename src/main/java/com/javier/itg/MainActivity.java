package com.javier.itg;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.javier.itg.model.Bet;
import com.javier.itg.model.response.Coin;
import com.javier.itg.presenter.CoinPresenterImpl;
import com.javier.itg.utils.Constants;
import com.javier.itg.utils.Utils;
import com.javier.itg.view.CoinView;
import com.javier.itg.view.adapter.CoinAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CoinView, AdapterView.OnItemClickListener{

    private ListView mListView;
    private View mLoading;
    private List<Bet> mBetList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiateUI();

        CoinPresenterImpl coinPresenter = new CoinPresenterImpl(this);
        coinPresenter.execute(Constants.URL, Constants.TYPE);

    }

    /**
     * this method was created for initing  UI element
     */
    private void initiateUI() {
        mListView = (ListView) findViewById(R.id.activity_main_list_view);
        mListView.setOnItemClickListener(this);
        mLoading = findViewById(R.id.activity_main_loading);
        mLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoading(boolean state) {
        int visibility= (state)?(View.VISIBLE):(View.GONE);
        mLoading.setVisibility(visibility);
    }

    @Override
    public void onRequestSuccess(List<Bet> betList) {
        mBetList = betList;
        buildingListView();
        showLoading(false);
    }

    @Override
    public void onRequestError(Coin object) {
        showLoading(false);
        Toast.makeText(this, R.string.activity_main_on_request_error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onGeneralError() {
        showLoading(false);
        if (Utils.isOnline(this)){
            Toast.makeText(this, R.string.activity_main_general_error, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, R.string.activity_main_no_internet, Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra(Constants.PARCELABLE, mBetList.get(position));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void buildingListView (){

        CoinAdapter coinAdapter = new CoinAdapter(this, mBetList);
        mListView.setAdapter(coinAdapter);
    }
}
