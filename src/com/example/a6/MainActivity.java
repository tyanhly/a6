package com.example.a6;

import java.util.Vector;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridView gridview = (GridView) findViewById(R.id.gridview);
        final ImageAdapter imageAdapter = new ImageAdapter(this);
        gridview.setAdapter(imageAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parentView, View childView, int position,
                    long id) {
                imageAdapter.remove(position);
                gridview.setAdapter(imageAdapter);
            }
        });

        Button addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                imageAdapter.add();
                gridview.setAdapter(imageAdapter);
            }
        });

    }

    public class ImageAdapter extends BaseAdapter{
        private Context mContext;
        private Vector<Integer> mThumbIds;

        public ImageAdapter(Context c) {
            mContext = c;
            mThumbIds = new Vector<Integer>();
            mThumbIds.add(R.drawable.a1);
            mThumbIds.add(R.drawable.a2);
            mThumbIds.add(R.drawable.a3);
            mThumbIds.add(R.drawable.a4);
            mThumbIds.add(R.drawable.a5);
            mThumbIds.add(R.drawable.a6);
            mThumbIds.add(R.drawable.a7);
            mThumbIds.add(R.drawable.ic_launcher);
            mThumbIds.add(R.drawable.ic_launcher);
            mThumbIds.add(R.drawable.a5);

        }

        public boolean add(){
            return mThumbIds.add(R.drawable.ic_launcher);
        }

        public int getCount() {
            return mThumbIds.size();
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public int remove(int position){
            return this.mThumbIds.remove(position);
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(90, 90));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(this.mThumbIds.get(position));
            return imageView;
        }


    }

}
