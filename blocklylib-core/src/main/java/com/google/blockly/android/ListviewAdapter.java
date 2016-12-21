package com.google.blockly.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cha on 2016-12-10.
 */

public class ListviewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<String> data;
    private int layout;

    public ListviewAdapter(Context context, int layout, ArrayList<String> data) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data = data;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }
        String s = data.get(position);

        String ges = s.substring(s.indexOf("#") + 1, s.indexOf("/"));
        TextView name = (TextView) convertView.findViewById(R.id.gesName);
        name.setText("동작명 : " + ges);

        String fingerState = "";
        int thumb = 0;
        int index = 0;
        int middle = 0;
        int ring = 0;
        int baby = 0;

        String[] bsArray = s.split("\n");
        ArrayList<String[]> mArrayList = new ArrayList<String[]>();
        for (int i = 0; i < bsArray.length; i++) {
            mArrayList.add(bsArray[i].split("/"));
        }
        for (int i = 1; i < mArrayList.size(); i++) {
            switch (mArrayList.get(i)[0]) {
                case "  thumb":
                    thumb = Integer.parseInt(mArrayList.get(i)[1]);
                    break;
                case "  index":
                    index = Integer.parseInt(mArrayList.get(i)[1]);
                    break;
                case "  middle":
                    middle = Integer.parseInt(mArrayList.get(i)[1]);
                    break;
                case "  ring":
                    ring = Integer.parseInt(mArrayList.get(i)[1]);
                    break;
                case "  baby":
                    baby = Integer.parseInt(mArrayList.get(i)[1]);
                    break;
            }
        }


        TextView state = (TextView) convertView.findViewById(R.id.fingerState);
        state.setText("엄지 : "+thumb+" / 검지 : "+ford(index)+" / 중지 : "+ford(middle)+ " / 약지 : "+ ford(ring)+" / 소지 : "+ford(baby));
        return convertView;
    }

    public String ford(int f) {
        if (f == 0) {
            return "펴기";
        } else if (f == 1) {
            return "접기";
        } else
            return "";

    }
}
