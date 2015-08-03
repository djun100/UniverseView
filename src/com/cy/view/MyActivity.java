package com.cy.view;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {
    UniverseView uv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        uv=(UniverseView)findViewById(R.id.uv);
//        List<Integer> icons=new ArrayList<Integer>();
//        icons.add(R.drawable.ic_launcher);
//        icons.add(R.drawable.ic_launcher);
//        icons.add(R.drawable.ic_launcher);
//        icons.add(R.drawable.ic_launcher);
//        icons.add(R.drawable.ic_launcher);
//        icons.add(R.drawable.ic_launcher);
//        uv.setIcons(icons);
        List<String> words=new ArrayList<>();
        words.add("hha1");
        words.add("hha2");
        words.add("hha3");
        words.add("hha4");
        words.add("hha5");
        words.add("hha6");
        uv.setWords(words);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
