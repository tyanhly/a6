package com.example.a6;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.widget.Button;
import android.widget.GridView;

import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    MainActivity mainActivity;
    GridView gridView;
    Button addButton;
    @Before
    public void setup(){
        mainActivity = new MainActivity();
        mainActivity.onCreate(null);
        gridView = (GridView) mainActivity.findViewById(R.id.gridview);
        addButton = (Button) mainActivity.findViewById(R.id.addButton);
    }


    @Test
    public void shouldShowGridViewHas10Items() throws Exception{

        Assert.assertEquals(gridView.getCount(), 10);
    }

    @Test
    public void shouldDeleteItemWhenClickOnIt() throws Exception{
        gridView.performItemClick(gridView, 0, 0);
        Assert.assertEquals(gridView.getCount(),9);
    }

    @Test
    public void shouldAddItemWhenClickOnAddButton() throws Exception{

        addButton.performClick();
        addButton.performClick();
        addButton.performClick();
        Assert.assertEquals(gridView.getCount(),13);
    }


}