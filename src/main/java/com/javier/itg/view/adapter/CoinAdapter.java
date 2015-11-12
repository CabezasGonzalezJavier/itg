package com.javier.itg.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.javier.itg.R;
import com.javier.itg.model.response.Coin;

import java.util.List;

/**
 * Created by javiergonzalezcabezas on 12/11/15.
 */
public class CoinAdapter extends ArrayAdapter<Coin> {
    private final Context mContext;
    private final List<Coin> mList;

    public CoinAdapter(Context context, List<Coin> list) {
        super(context, -1, list);
        this.mContext = context;
        this.mList = list;
    }

    static class ViewHolder {
        public TextView text;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.row_coin, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.row_task_text_view);
            rowView.setTag(viewHolder);
        }
        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.text.setText(mList.get(position).getData().get(position).getName());
        return rowView;
    }

}
