package jp.hitting.android.view.sample;

import android.app.Activity;
import android.os.Bundle;

import jp.hitting.android.view.ResizableGridView;
import jp.hitting.android.view.ResizableGridView.ResizableGridViewListener;

public class MainActivity extends Activity implements ResizableGridViewListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        ResizableGridView gridView = (ResizableGridView) this.findViewById(R.id.gridView);
        gridView.setAdapter(new SampleAdapter(this));
        gridView.setListener(this);
    }

    @Override
    public void onPinchIn() {
        // pinch in
    }

    @Override
    public void onPinchOut() {
        // pinch out
    }

}
