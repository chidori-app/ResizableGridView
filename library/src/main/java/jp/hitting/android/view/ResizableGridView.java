package jp.hitting.android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.GridView;

public class ResizableGridView extends GridView {

	public static interface ResizableGridViewListener {

		void onPinchIn();

		void onPinchOut();
	}

	private ResizableGridViewListener listener = null;

	public void setListener(ResizableGridViewListener listener) {
		this.listener = listener;
	}

	//
	private static final int MAX_NUM_COLUMNS = 6;
	private static final int MIN_NUM_COLUMNS = 2;

	//
	private static final float BASE_SCALE = 1.0f;
	private static final float PINCH_OUT_SCALE = 1.3f;
	private static final float PINCH_IN_SCALE = 0.8f;

	private int minNumColumns;
	private int maxNumColumns;

	private float scale = BASE_SCALE;

	private ScaleGestureDetector gestureDetector;

	private ScaleGestureDetector.SimpleOnScaleGestureListener simpleListener = new ScaleGestureDetector.SimpleOnScaleGestureListener() {
		@Override
		public boolean onScale(ScaleGestureDetector detector) {
			scale *= detector.getScaleFactor();
			if (scale >= PINCH_OUT_SCALE) {
				scale = BASE_SCALE;
				pinchOut();
			} else if (scale <= PINCH_IN_SCALE) {
				scale = BASE_SCALE;
				pinchIn();
			}
			return true;
		}

		@Override
		public boolean onScaleBegin(ScaleGestureDetector detector) {
			scale = BASE_SCALE;
			return true;
		}
	};

	public ResizableGridView(Context context) {
		this(context, null);
	}

	public ResizableGridView(Context context, AttributeSet attrs) {
		super(context, attrs);

		TypedArray typedArray = context.obtainStyledAttributes(attrs,
				R.styleable.ResizableGridView);
		this.minNumColumns = typedArray.getInteger(
				R.styleable.ResizableGridView_min_num_columns, MIN_NUM_COLUMNS);
		this.maxNumColumns = typedArray.getInteger(
				R.styleable.ResizableGridView_max_num_columns, MAX_NUM_COLUMNS);
		int numColumns = typedArray.getInteger(
				R.styleable.ResizableGridView_numColumns, AUTO_FIT);
		typedArray.recycle();

		if (numColumns < this.minNumColumns) {
			numColumns = this.minNumColumns;
		}
		this.setNumColumns(numColumns);

		this.gestureDetector = new ScaleGestureDetector(context,
				this.simpleListener);
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		this.gestureDetector.onTouchEvent(ev);
		return super.onTouchEvent(ev);
	}

	private void pinchIn() {
		int numColumns = this.getNumColumns();
		if (numColumns < this.maxNumColumns) {
			this.setNumColumns(numColumns + 1);

			if (this.listener != null) {
				this.listener.onPinchIn();
			}
		}
	}

	private void pinchOut() {
		int numColumns = this.getNumColumns();
		if (numColumns > this.minNumColumns) {
			this.setNumColumns(numColumns - 1);

			if (this.listener != null) {
				this.listener.onPinchOut();
			}
		}
	}

}
