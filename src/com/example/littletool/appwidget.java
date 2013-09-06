package com.example.littletool;
import java.util.Calendar;
import java.util.Date;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

public class appwidget extends AppWidgetProvider {
	
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWigetIds) {
		RemoteViews rv = new RemoteViews(context.getPackageName(),R.layout.layout);
		
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		String hour_str = String.format("%1$X", c.get(Calendar.HOUR_OF_DAY));
		String min_str = String.format("%1$X", c.get(Calendar.MINUTE));
		String date_str = String.format("%1$X ¦~ %2$X ¤ë %3$X ¤é",c.get(Calendar.YEAR),c.get(Calendar.MONTH)+1,c.get(Calendar.DATE));
		
		rv.setTextViewText(R.id.hour_label, hour_str);
		rv.setTextViewText(R.id.minute_label, min_str); 
		rv.setTextViewText(R.id.date_label, date_str);
		
		appWidgetManager.updateAppWidget(new ComponentName(context, this.getClass()), rv);
	}
}
