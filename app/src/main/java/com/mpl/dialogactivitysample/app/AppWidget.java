package com.mpl.dialogactivitysample.app;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;


/**
 * Implementation of App Widget functionality.
 */
public class AppWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.app_widget);

        Intent firstDialogIntent = new Intent(context, DialogActivity.class);
        firstDialogIntent.putExtra(DialogActivity.ARG_DIALOG_NUMBER, 1);
        // Old activities shouldn't be in the history stack
        firstDialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent firstDialogPendingIntent = PendingIntent.getActivity(context,
                0,
                firstDialogIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        // Link the PendingIntent to a Button
        views.setOnClickPendingIntent(R.id.btn_first_dialog, firstDialogPendingIntent);

        Intent secondDialogIntent = new Intent(context, DialogActivity.class);
        firstDialogIntent.putExtra(DialogActivity.ARG_DIALOG_NUMBER, 2);
        // Old activities shouldn't be in the history stack
        secondDialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent secondDialogPendingIntent = PendingIntent.getActivity(context,
                0,
                secondDialogIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        // Link the PendingIntent to a Button
        views.setOnClickPendingIntent(R.id.btn_second_dialog, secondDialogPendingIntent);


        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        final int N = appWidgetIds.length;
        for (int i = 0; i < N; i++) {
            updateAppWidget(context, appWidgetManager, appWidgetIds[i]);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}


