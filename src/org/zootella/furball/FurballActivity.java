package org.zootella.furball;

import org.zootella.furball.R;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class FurballActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_furball);
	}

	private ImageView board[][];
	private final int boardSize = 11;
	private int square;
	
	private RelativeLayout layout;
	
	private int boardx, boardy;
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		
		if (board == null) {
			
			RelativeLayout layout = (RelativeLayout)findViewById(R.id.furball_activity_id);
			int w = layout.getWidth();//800, and these are real pixels, apparently
			int h = layout.getHeight();//1097

			int limit = Math.min(w, h);//find the smallest dimension
			square = limit / boardSize;//size of each square
			boardx = (w - (square * boardSize)) / 2;
			boardy = (h - (square * boardSize)) / 2;

			int x = boardx + (10 * square);
			int y = boardy + (10 * square);
			
			boolean checker = false;
			
			board = new ImageView[boardSize][boardSize];
			for (int squarex = 0; squarex < boardSize; squarex++) {
				for (int squarey = 0; squarey < boardSize; squarey++) {
					
					int color;
					if (checker) {
						color = Color.BLACK;
					} else {
						color = Color.RED;
					}
					checker = !checker;
					
					ImageView image = new ImageView(this);
					image.setBackgroundColor(color);

					RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(square, square);//w, h
					p.leftMargin = boardx + (squarex * square);//x
					p.topMargin = boardy + (squarey * square);//y
					layout.addView(image, p);
					
					board[squarex][squarey] = image;
				}
			}
		}
		
		if (layout != null) return;
		
		layout = (RelativeLayout)findViewById(R.id.furball_activity_id);

		puck = new ImageView(this);
		puck.setBackgroundColor(Color.BLUE);
		RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(square, square);//w, h
		p.leftMargin = boardx;//x
		p.topMargin = boardy;//y
		layout.addView(puck, p);
		
		
		layout.setOnTouchListener(new OnTouchListener(){
			@Override
			public boolean onTouch(View view, MotionEvent event) {
			    final int action = event.getAction();
			    switch (action) {
				    case MotionEvent.ACTION_DOWN: {
				        startx = (int)event.getX();//where the finger is now
				        starty = (int)event.getY();
				        break;
				    }
				        
				    case MotionEvent.ACTION_MOVE: {
				        int x = (int)event.getX();//where the finger is now
				        int y = (int)event.getY();
				        
				        int dx = x - startx;
				        int dy = y - starty;
				        
				        if (dx > square) {
				        	startx = x;
				        	starty = y;
				        	move(puckx + 1, pucky);//right
				        }
				        
				        if (dx < -square) {
				        	startx = x;
				        	starty = y;
				        	move(puckx - 1, pucky);//left
				        }
				        
				        if (dy > square) {
				        	startx = x;
				        	starty = y;
				        	move(puckx, pucky + 1);//down
				        }
				        
				        if (dy < -square) {
				        	startx = x;
				        	starty = y;
				        	move(puckx, pucky - 1);//up
				        }
				        
				        break;
				    }
			    }
			    
			    return true;
			}
		});
	}

	//move the puck to x, y in board coordinates, and record where it is
	private void move(int x, int y) {
		puckx = x;
		pucky = y;
		
		RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)puck.getLayoutParams();
        params.leftMargin = boardx + (square * puckx);
        params.topMargin = boardy + (square * pucky);
        params.rightMargin = square;
        params.bottomMargin = square;
        puck.setLayoutParams(params);
	}

	private int startx;
	private int starty;
	
	private int puckx;
	private int pucky;
	
	private ImageView puck;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_furball, menu);
		return true;
	}

}
