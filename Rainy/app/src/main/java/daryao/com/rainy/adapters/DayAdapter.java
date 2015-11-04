package daryao.com.rainy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import daryao.com.rainy.R;
import daryao.com.rainy.weather.Day;

/**
 * Created by Darya on 2015-10-05.
 */
public class DayAdapter extends BaseAdapter {
    private Context mContext;
    private Day[] mDays;

    public DayAdapter(Context context, Day[] days){
        mContext = context;
        mDays = days;
    }

    @Override
    public int getCount() {
        return mDays.length;
    }

    @Override
    public Object getItem(int position) {
        return mDays[position];
    }

    @Override
    public long getItemId(int position) {
        return 0; //not used
        //tagging elements for easy reference
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView is the view we get
        //this what we are reusing

        //this is the view item that gets called for each item on the list
        //i.e. for everything initially displayed and then for any NEW items

        //helper object
        ViewHolder holder;

        if (convertView == null) {
            //brand new, we need to create everything
            //layout inflater - takes xml and turns it into a page
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.iconImageView);
            holder.temperatureLabel = (TextView) convertView.findViewById(R.id.tempLabel);
            holder.dayLabel = (TextView) convertView.findViewById(R.id.dayNameLabel);

            //this sets tag
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Day day = mDays[position];

        holder.iconImageView.setImageResource(day.getIconId());
        holder.temperatureLabel.setText(day.getTemperatureMax()+"");
        if (position == 0) {

            holder.dayLabel.setText("Today");
        }
        else{
            holder.dayLabel.setText(day.getDayOfTheWeek());
        }


        return convertView;
    }

    private static class ViewHolder{
        ImageView iconImageView; // public by default
        TextView temperatureLabel;
        TextView dayLabel;
    }
}
