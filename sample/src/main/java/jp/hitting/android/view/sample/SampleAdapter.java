package jp.hitting.android.view.sample;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class SampleAdapter extends BaseAdapter {

    private static int DATA_NUM = 100;
    private static int[] COLORS = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.WHITE};

    private Context context;

    public SampleAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return DATA_NUM;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new SampleView(this.context);
        }
        view.setBackgroundColor(COLORS[i % COLORS.length]);
        return view;
    }

    private class SampleView extends View {

        public SampleView(Context context) {
            super(context);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            // square
            super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        }
    }

}
