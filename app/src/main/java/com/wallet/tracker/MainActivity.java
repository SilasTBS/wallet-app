package com.wallet.tracker;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scrollView = new ScrollView(this);

        container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);

        scrollView.addView(container);

        setContentView(scrollView);

        Intent intent = new Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        container.removeAllViews();

        for (String transaction : TransactionStore.transactions) {

            TextView textView = new TextView(this);

            textView.setText(transaction + "\n\n");

            textView.setPadding(20,20,20,20);

            container.addView(textView);
        }
    }
}