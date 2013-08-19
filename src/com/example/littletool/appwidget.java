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
		
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		String hour_str = String.format("%1$X", c.get(Calendar.HOUR_OF_DAY));
		String min_str = String.format("%1$X", c.get(Calendar.MINUTE));
		String date_str = String.format("%1$X 年 %2$X 月 %3$X 日 星期 %4$X",c.get(Calendar.YEAR),c.get(Calendar.MONTH)+1,c.get(Calendar.DATE),c.get(Calendar.DAY_OF_WEEK)-1);
		
		rv.setTextViewText(R.id.hour_label, hour_str);
		rv.setTextViewText(R.id.minute_label, min_str); 
		rv.setTextViewText(R.id.date_label, date_str);
		
		appWidgetManager.updateAppWidget(new ComponentName(context, this.getClass()), rv);
	}
}
