package com.mpl.dialogactivitysample.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_first_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                intent.putExtra(DialogActivity.ARG_DIALOG_NUMBER, 1);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_second_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                intent.putExtra(DialogActivity.ARG_DIALOG_NUMBER, 2);
                startActivity(intent);
            }
        });
    }
}
