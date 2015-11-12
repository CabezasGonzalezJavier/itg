package com.javier.itg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.javier.itg.model.Bet;
import com.javier.itg.utils.Constants;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        Bet result = extras.getParcelable(Constants.PARCELABLE);
        initiateUI(result);
    }


    private void initiateUI(Bet datumResult) {
        TextView nameTextView = (TextView) findViewById(R.id.activity_detail_name_text_view);
        TextView jackpotTextView = (TextView) findViewById(R.id.activity_detail_jackpot_text_view);
        TextView dateTextView = (TextView) findViewById(R.id.activity_detail_date_text_view);

        nameTextView.setText(datumResult.getName());
        jackpotTextView.setText(String.valueOf(datumResult.getJackpot()));
        dateTextView.setText(datumResult.getDate());

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
