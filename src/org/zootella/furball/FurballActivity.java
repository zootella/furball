package org.zootella.furball;

import java.util.HashMap;
import java.util.Map;

import org.zootella.furball.R;
import org.zootella.furball.kind.Direction;
import org.zootella.furball.kind.Tile;
import org.zootella.furball.original.Define;
import org.zootella.furball.original.Game;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class FurballActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_furball);
		
		instance = this;
		
		Game.initialize(Define.initialStartingLevel);
	}

	private ImageView board[][];
	private int square;
	
	private RelativeLayout layout;
	
	private int boardx, boardy;
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		setupBoard();
	}
	
	private void setupBoard() {
		
		if (board != null || layout != null) return;
		
		//board
		
		RelativeLayout layout = (RelativeLayout)findViewById(R.id.furball_activity_id);
		int w = layout.getWidth();//800, and these are real pixels, apparently
		int h = layout.getHeight();//1097
		
		square = w / Define.boardCols;//size of each square
		boardx = (w - (square * Define.boardCols)) / 2;
		boardy = (h - (square * Define.boardRows)) / 2;
		
		board = new ImageView[Define.boardRows][Define.boardCols];
		for (int r = 0; r < Define.boardRows; r++) {
			for (int c = 0; c < Define.boardCols; c++) {
				
				ImageView image = new ImageView(this);
				
				RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(square, square);//w, h
				p.leftMargin = boardx + (c * square);//x
				p.topMargin = boardy + (r * square);//y
				layout.addView(image, p);
				
				board[r][c] = image;
			}
		}
		
		for (int r = 0; r < Define.boardRows; r++) {
			for (int c = 0; c < Define.boardCols; c++) {
				screen[r][c] = Tile.os;
			}
		}
		
		//layout and puck
		
		layout = (RelativeLayout)findViewById(R.id.furball_activity_id);
		
		puck = new ImageView(this);
		puck.setBackgroundColor(Color.BLUE);
		RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(square, square);//w, h
		p.leftMargin = boardx;//x
		p.topMargin = boardy;//y
		layout.addView(puck, p);
		
		layout.setOnTouchListener(new MyOnTouchListener());
		
		//image resources
		
		images.put(Tile.fg, bitmap(R.drawable.fg));
		images.put(Tile.fs, bitmap(R.drawable.fs));
		images.put(Tile.bg, bitmap(R.drawable.bg));
		images.put(Tile.bs, bitmap(R.drawable.bs));
		images.put(Tile.rk, bitmap(R.drawable.rk));
		images.put(Tile.wl, bitmap(R.drawable.wl));
		images.put(Tile.en, bitmap(R.drawable.en));
		images.put(Tile.gs, bitmap(R.drawable.gs));
		images.put(Tile.sk, bitmap(R.drawable.sk));
		images.put(Tile.hr, bitmap(R.drawable.hr));
		images.put(Tile.dc, bitmap(R.drawable.dc));
		images.put(Tile.dp, bitmap(R.drawable.dp));
		
		//update
		
		updateBoard();
	}
	
	private Map<Tile, Bitmap> images = new HashMap<Tile, Bitmap>();
	
	
	
	private Bitmap bitmap(int id) {
		return BitmapFactory.decodeResource(this.getResources(), id);
	}
	
	public static Tile screen[][] = new Tile[Define.boardRows][Define.boardCols];
	
	private static FurballActivity instance;
	
	public static FurballActivity instance() { return instance; }
	
	
	public void updateBoard() {
		
		for (int r = 0; r < Define.boardRows; r++) {
			for (int c = 0; c < Define.boardCols; c++) {
				
				if (screen[r][c] != Game.board[r][c]) {
					
					screen[r][c] = Game.board[r][c];

					
					
					
					
					board[r][c].setImageBitmap(images.get(screen[r][c]));
					
				}
			}
		}
	}
	
	private class MyOnTouchListener implements View.OnTouchListener {
		
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
			        	Game.moveFurball(Direction.right);
			        }
			        
			        if (dx < -square) {
			        	startx = x;
			        	starty = y;
			        	move(puckx - 1, pucky);//left
			        	Game.moveFurball(Direction.left);
			        }
			        
			        if (dy > square) {
			        	startx = x;
			        	starty = y;
			        	move(puckx, pucky + 1);//down
			        	Game.moveFurball(Direction.down);
			        }
			        
			        if (dy < -square) {
			        	startx = x;
			        	starty = y;
			        	move(puckx, pucky - 1);//up
			        	Game.moveFurball(Direction.up);
			        }
			        
			        break;
			    }
		    }
		    
		    return true;
		}
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
