package com.gorand.swiperefreshlayoutbottom.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.library21.custom.SwipeRefreshLayoutBottom;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class MainActivity extends Activity implements SwipeRefreshLayoutBottom.OnRefreshListener {

    private static final int         PER_PAGE = 20;

    private int                      mPage;
    private SwipeRefreshLayoutBottom mSwipeRefreshLayout;
    private List<String>             mNames;

    private ListView                 mListView;
    private Handler                  mHandler;

    private FrameLayout              mRootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_main);

        mHandler = new Handler();

        mNames = new ArrayList<String>();

        String[] codes = Locale.getISOCountries();

        for (int i = 0; i < codes.length; i++) {
            Locale locale = new Locale("", codes[i]);
            String str = locale.getDisplayName(Locale.ENGLISH);
            mNames.add(Integer.toString(i + 1) + "  " + str);
        }

        String[] array = makeForPage(mPage);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, array);

        mSwipeRefreshLayout = new SwipeRefreshLayoutBottom(this);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mSwipeRefreshLayout.setColorSchemeResources(R.color.yellow, R.color.blue);

        mListView = new ListView(this);
        mSwipeRefreshLayout.addView(mListView);

        mRootLayout = (FrameLayout) findViewById(R.id.root_layout);
        mRootLayout.setForeground(new ColorDrawable(Color.BLACK));
        mRootLayout.getForeground().setAlpha(0);

        mRootLayout.addView(mSwipeRefreshLayout);

        mListView.setAdapter(adapter);

    }

    private String[] makeForPage(int page) {

        int size = Math.min(PER_PAGE * (page + 1), mNames.size());

        String[] res = new String[size];

        for (int i = 0; i < size; i++) {
            res[i] = mNames.get(i);
        }

        return res;
    }

    @Override
    public void onRefresh() {
        mRootLayout.getForeground().setAlpha(50);
        mSwipeRefreshLayout.setRefreshing(true);
        setProgressBarIndeterminateVisibility(true);

        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                mRootLayout.getForeground().setAlpha(0);
                mSwipeRefreshLayout.setRefreshing(false);
                setProgressBarIndeterminateVisibility(false);
                mPage++;
                String[] array = makeForPage(mPage);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, array);

                int index = mListView.getFirstVisiblePosition();
                View v = mListView.getChildAt(0);
                int top = (v == null) ? 0 : v.getTop();

                mListView.setAdapter(adapter);
                mListView.setSelectionFromTop(index, top);

                mListView.post(new Runnable() {

                    @Override
                    public void run() {
                        mListView.smoothScrollByOffset(PER_PAGE);
                    }
                });

            }
        }, 3000);

    }

    @Override
    protected void onDestroy() {
        mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

}
