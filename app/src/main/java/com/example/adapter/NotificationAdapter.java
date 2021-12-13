package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.NotificationItems;
import com.example.ohfresh.R;

import java.util.List;

public class NotificationAdapter extends BaseAdapter {

    Activity context;
    int item_layout;
    List<NotificationItems> notiList;

    public NotificationAdapter(Activity context, int item_layout, List<NotificationItems> notiList) {
        this.context = context;
        this.item_layout = item_layout;
        this.notiList = notiList;
    }

    @Override
    public int getCount() {
        return notiList.size();
    }

    @Override
    public Object getItem(int i) {
        return notiList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            holder.imvIcon = view.findViewById(R.id.imvIcon);
            holder.txtTitle = view.findViewById(R.id.txtTitle);
            holder.txtContent = view.findViewById(R.id.txtContent);
            holder.txtTime = view.findViewById(R.id.txtTime);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        NotificationItems n = notiList.get(i);
        holder.imvIcon.setImageResource(n.getIcon());
        holder.txtTitle.setText(n.getTitle());
        holder.txtContent.setText(n.getContent());
        holder.txtTime.setText(n.getTime());

        return view;
    }

    public static class ViewHolder{
        ImageView imvIcon;
        TextView txtTitle, txtContent, txtTime;
    }
}
