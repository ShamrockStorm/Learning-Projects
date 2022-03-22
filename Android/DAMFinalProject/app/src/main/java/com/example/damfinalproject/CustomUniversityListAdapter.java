package com.example.damfinalproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class CustomUniversityListAdapter extends BaseAdapter {
    private ArrayList<com.example.damfinalproject.UniversityListItem> listData;
    private LayoutInflater layoutInflater;
    public CustomUniversityListAdapter(Context aContext,
                             ArrayList<com.example.damfinalproject.UniversityListItem> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }
    @Override
    public int getCount() {
        return listData.size();
    }
    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View v, ViewGroup vg) {
        ViewHolder holder;
        if (v == null) {
            v = layoutInflater.inflate(R.layout.list_row_university, null);
            holder = new ViewHolder();
            holder.uUniversityName = (TextView) v.findViewById(R.id.UniversityName);
            holder.uFacultyName = (TextView) v.findViewById(R.id.FacultyName);
            holder.uUniversityCity = (TextView) v.findViewById(R.id.UniversityCity);
            holder.uUniversityIcon = (ImageView) v.findViewById(R.id.UniversityIcon) ;
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        holder.uUniversityName.setText(listData.get(position).getUniversityName());
        holder.uFacultyName.setText(listData.get(position).getFacultyName());
        holder.uUniversityCity.setText(listData.get(position).getUniversityCity());
        new DownloadImageClass(holder.uUniversityIcon,position).execute(listData.get(position).getFacultyImageLink());
        return v;
    }
    static class ViewHolder {
        TextView uUniversityName;
        TextView uFacultyName;
        TextView uUniversityCity;
        ImageView uUniversityIcon;
    }
}
