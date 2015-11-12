package com.javier.itg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
    @Override
    public void onBackPressed()
    {
        cameback();
    }

    /**
     * this method was created for animation between activities
     */
    public void cameback()
    {
        finish();
        overridePendingTransition(R.anim.right, R.anim.left);
    }
}
