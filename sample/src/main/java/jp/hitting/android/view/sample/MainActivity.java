package jp.hitting.android.view.sample;

import java.util.ArrayList;
import java.util.List;

import jp.hitting.android.view.ResizableGridView;
import jp.hitting.android.view.ResizableGridView.ResizableGridViewListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends Activity implements ResizableGridViewListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        // set A to Z
        final List<String> list = new ArrayList<String>();
        char c = 'A';
        for (int i = 0; i < 26; i++) {
            list.add(String.valueOf((char) (c + i)));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this.getApplicationContext(),
                android.R.layout.simple_list_item_1, list);

        ResizableGridView gridView = (ResizableGridView) this
                .findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
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
