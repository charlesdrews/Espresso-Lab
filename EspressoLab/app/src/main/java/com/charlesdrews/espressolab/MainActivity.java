package com.charlesdrews.espressolab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private double mBalanceAmount;
    private TextView mBalanceView;
    private EditText mTransactionAmount;
    private Button mDeposit, mWithdraw, mViewProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBalanceView = (TextView) findViewById(R.id.balance);
        mTransactionAmount = (EditText) findViewById(R.id.transaction_amount);
        mDeposit = (Button) findViewById(R.id.deposit_button);
        mWithdraw = (Button) findViewById(R.id.withdraw_button);
        mViewProfile = (Button) findViewById(R.id.view_profile_button);

        mDeposit.setOnClickListener(this);
        mWithdraw.setOnClickListener(this);
        mViewProfile.setOnClickListener(this);

        mBalanceAmount = 999999.99;
        updateBalanceView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.deposit_button:
                mBalanceAmount += Double.parseDouble(mTransactionAmount.getText().toString());
                updateBalanceView();
                break;
            case R.id.withdraw_button:
                mBalanceAmount -= Double.parseDouble(mTransactionAmount.getText().toString());
                updateBalanceView();
                break;
            case R.id.view_profile_button:
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void updateBalanceView() {
        mBalanceView.setText(String.format("Current balance: $%,.2f", mBalanceAmount));

        if (mBalanceAmount >= 1000000.00) {
            Toast.makeText(MainActivity.this, "Congrats ur a millionaire", Toast.LENGTH_SHORT).show();
        }

        mTransactionAmount.setText(null);
        mTransactionAmount.requestFocus();
    }
}
