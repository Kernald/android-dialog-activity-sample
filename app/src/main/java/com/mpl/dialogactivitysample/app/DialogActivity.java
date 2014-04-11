package com.mpl.dialogactivitysample.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;


public class DialogActivity extends Activity {
    public static final String ARG_DIALOG_NUMBER = "arg_dialog_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));

        // Should do a proper argument verification here
        boolean validArg = false;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey(ARG_DIALOG_NUMBER)) {
                displayDialog(extras.getInt(ARG_DIALOG_NUMBER));
                validArg = true;
            }
        }

        if (!validArg) {
            displayDialog(1);
        }
    }

    private void displayDialog(int number) {
        new AlertDialog.Builder(getDialogContext())
                .setTitle("Dialog title")
                .setMessage("This is the dialog number " + number)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle a positive answer
                        dialog.dismiss();
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle a negative answer
                        dialog.dismiss();
                        finish();
                    }
                })
                .setIcon(R.drawable.ic_launcher)
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        finish();
                    }
                })
                .show();
    }

    private Context getDialogContext() {
        final Context context;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            context = new ContextThemeWrapper(this, android.R.style.Theme_Holo_Light);
        } else {
            context = new ContextThemeWrapper(this, android.R.style.Theme_Dialog);
        }

        return context;
    }
}
