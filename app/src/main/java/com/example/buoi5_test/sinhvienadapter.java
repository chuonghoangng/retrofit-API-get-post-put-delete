package com.example.buoi5_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lib.Model.SinhVienResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class sinhvienadapter extends BaseAdapter {

    Context context;
    int layout;
    List<SinhVienResponse> lstsv;

    public sinhvienadapter(Context context, int layout, List<SinhVienResponse> lstsv) {
        this.context = context;
        this.layout = layout;
        this.lstsv = lstsv;
    }

    @Override
    public int getCount() {
        return lstsv.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(layout,null);
        TextView txtTieude= (TextView) convertView.findViewById(R.id.txtTieude);
        ImageView img= (ImageView) convertView.findViewById(R.id.imgAnh);;
        TextView txtGroupName= (TextView) convertView.findViewById(R.id.txtGroupName);
        TextView txtContent= (TextView) convertView.findViewById(R.id.txtContent);

        SinhVienResponse sv = lstsv.get(position);
        txtGroupName.setText(sv.getGroupName());
        txtContent.setText(sv.getContent());
        txtTieude.setText(sv.getTitle());
        Picasso.get ().load(sv.getImageUrl()) .into (img);

        return convertView;
    }
}
