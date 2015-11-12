package com.javier.itg;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.javier.itg.presenter.CoinPresenterImpl;
import com.javier.itg.utils.Constants;
import com.javier.itg.utils.Utils;
import com.javier.itg.view.CoinView;

public class MainActivity extends AppCompatActivity implements CoinView, AdapterView.OnItemClickListener{

    private ListView mListView;
    private View mLoading;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initiateUI();

        CoinPresenterImpl coinPresenter = new CoinPresenterImpl(this);
        coinPresenter.executeAsync(Constants.URL, Constants.TYPE);

    }


    private void initiateUI() {
        mListView = (ListView) findViewById(R.id.activity_main_list_view);
//        mListView.setOnItemClickListener(this);
        mLoading = findViewById(R.id.activity_main_loading);
    }

    @Override
    public void showLoading(boolean state) {
        int visibility= (state)?(View.VISIBLE):(View.GONE);
        mLoading.setVisibility(visibility);
    }

    @Override
    public void onRequestSuccess(Object object) {
        showLoading(false);
    }

    @Override
    public void onRequestError(Object object) {
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
        startActivity(new Intent(this,DetailActivity.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
