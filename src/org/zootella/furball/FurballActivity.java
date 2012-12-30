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
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class FurballActivity extends Activity {

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_furball);
		
		game = new Game(this);
	}
	
	@Override public void onWindowFocusChanged(boolean hasFocus) {
		setupBoard();
	}

	@Override public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_furball, menu);
		return true;
	}
	
	private class MyOnTouchListener implements View.OnTouchListener {
		
		@Override public boolean onTouch(View view, MotionEvent event) {
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
			        	game.moveFurball(Direction.right);
			        }
			        
			        if (dx < -square) {
			        	startx = x;
			        	starty = y;
			        	game.moveFurball(Direction.left);
			        }
			        
			        if (dy > square) {
			        	startx = x;
			        	starty = y;
			        	game.moveFurball(Direction.down);
			        }
			        
			        if (dy < -square) {
			        	startx = x;
			        	starty = y;
			        	game.moveFurball(Direction.up);
			        }
			        
			        break;
			    }
		    }
		    
		    return true;
		}
	}
	
	private Game game;
	private ImageView board[][];
	private int square;
	private Map<Tile, Bitmap> imagesDay = new HashMap<Tile, Bitmap>();
	private Map<Tile, Bitmap> imagesNight = new HashMap<Tile, Bitmap>();
	public Tile screen[][] = new Tile[Define.boardRows][Define.boardCols];
	private int startx;
	private int starty;
	
	private void setupBoard() {
		
		if (board != null) return;
		
		//board
		
		RelativeLayout layout = (RelativeLayout)findViewById(R.id.furball_activity_id);
		int w = layout.getWidth();//800, and these are real pixels, apparently
		int h = layout.getHeight();//1097
		
		square = w / Define.boardCols;//size of each square
		int boardx = (w - (square * Define.boardCols)) / 2;
		int boardy = (h - (square * Define.boardRows)) / 2;
		
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
		
		//layout
		
		layout.setOnTouchListener(new MyOnTouchListener());
		
		//image resources
		
		imagesDay.put(Tile.fg, BitmapFactory.decodeResource(this.getResources(), R.drawable.fg));
		imagesDay.put(Tile.fs, BitmapFactory.decodeResource(this.getResources(), R.drawable.fs));
		imagesDay.put(Tile.bg, BitmapFactory.decodeResource(this.getResources(), R.drawable.bg));
		imagesDay.put(Tile.bs, BitmapFactory.decodeResource(this.getResources(), R.drawable.bs));
		imagesDay.put(Tile.rk, BitmapFactory.decodeResource(this.getResources(), R.drawable.rk));
		imagesDay.put(Tile.wl, BitmapFactory.decodeResource(this.getResources(), R.drawable.wl));
		imagesDay.put(Tile.en, BitmapFactory.decodeResource(this.getResources(), R.drawable.en));
		imagesDay.put(Tile.gs, BitmapFactory.decodeResource(this.getResources(), R.drawable.gs));
		imagesDay.put(Tile.sk, BitmapFactory.decodeResource(this.getResources(), R.drawable.sk));
		imagesDay.put(Tile.hr, BitmapFactory.decodeResource(this.getResources(), R.drawable.hr));
		imagesDay.put(Tile.dc, BitmapFactory.decodeResource(this.getResources(), R.drawable.dc));
		imagesDay.put(Tile.dp, BitmapFactory.decodeResource(this.getResources(), R.drawable.dp));
		
		imagesNight.put(Tile.fg, BitmapFactory.decodeResource(this.getResources(), R.drawable.fgn));
		imagesNight.put(Tile.fs, BitmapFactory.decodeResource(this.getResources(), R.drawable.fsn));
		imagesNight.put(Tile.bg, BitmapFactory.decodeResource(this.getResources(), R.drawable.bgn));
		imagesNight.put(Tile.bs, BitmapFactory.decodeResource(this.getResources(), R.drawable.bsn));
		imagesNight.put(Tile.rk, BitmapFactory.decodeResource(this.getResources(), R.drawable.rkn));
		imagesNight.put(Tile.wl, BitmapFactory.decodeResource(this.getResources(), R.drawable.wln));
		imagesNight.put(Tile.en, BitmapFactory.decodeResource(this.getResources(), R.drawable.enn));
		imagesNight.put(Tile.gs, BitmapFactory.decodeResource(this.getResources(), R.drawable.gsn));
		imagesNight.put(Tile.sk, BitmapFactory.decodeResource(this.getResources(), R.drawable.skn));
		imagesNight.put(Tile.hr, BitmapFactory.decodeResource(this.getResources(), R.drawable.hrn));
		imagesNight.put(Tile.dc, BitmapFactory.decodeResource(this.getResources(), R.drawable.dcn));
		imagesNight.put(Tile.dp, BitmapFactory.decodeResource(this.getResources(), R.drawable.dpn));

		//update
		
		updateBoard();
	}
	
	public void updateBoard() {
		if (board == null) return;
		
		for (int r = 0; r < Define.boardRows; r++) {
			for (int c = 0; c < Define.boardCols; c++) {
				
				if (screen[r][c] != game.board[r][c]) {
					
					screen[r][c] = game.board[r][c];
					board[r][c].setImageBitmap(imagesDay.get(screen[r][c]));
				}
			}
		}
	}
}
