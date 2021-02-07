package com.example.artkib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class CarftListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Craft> craftsList;

    public CarftListAdapter(Context context, int layout, ArrayList<Craft> craftsList) {
        this.context = context;
        this.layout = layout;
        this.craftsList = craftsList;
    }

    @Override
    public int getCount() {
        return craftsList.size();
    }

    @Override
    public Object getItem(int position) {
        return craftsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtPrice;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView ;
        ViewHolder holder = new ViewHolder();


        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtPrice = (TextView) row.findViewById(R.id.txtPrice);
            holder.imageView = (ImageView) row.findViewById(R.id.imgFood);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Craft craft = craftsList.get(position);

        holder.txtName.setText(craft.getName());
        holder.txtPrice.setText(craft.getCaption());

        byte[] CraftImage = craft.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(CraftImage, 0, CraftImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
