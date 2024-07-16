
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Mazesub extends MyFrame{
	Regenerate regenerate = new Regenerate();
	static int Path = 0;
	static int wall = 1;
	public void run() {
		addKeyListener(regenerate);
		Maze(15,15);
	}
	
	public int[][] Maze(int width, int height){
		 
		 var maze = new int[width][height];
		 for(int x =0; x<width; x++) {
			 for(int y =0; y<height; y++) {
				 if(x == 0 || y== 0 || x == width - 1 || y == height - 1) {
					 maze[x][y] = wall;
					 setColor(0,0,0);
					 drawString("■",(x*20+40),(y*20+80),25);
					 //sleep(0.3);
					 if (x == 1 && y == 0) {
						 maze[x][y] = wall;
						 setColor(0,0,255);
						 drawString("■",(x*20+40),(y*20+80),25);
						 //sleep(0.3);
						 }
					 else if(x == 13 && y == 14) {
						 maze[x][y] = wall;
						 setColor(255,0,0);
						 drawString("■",(x*20+40),(y*20+80),25);
						 //sleep(0.3);
					 }
				 }
				 else {
					 maze[x][y] = Path;
				 }
			 }
		 }
		 
		// 棒を立て、倒す
         var rnd = new Random();
         for (int x = 2; x < width - 1; x += 2)
         {
             for (int y = 2; y < height - 1; y += 2)
             {
                 maze[x][y] = wall;// 棒を立てる
                 drawString("■",(x*20+40),(y*20+80),25);
                 //sleep(0.1);
                 
                 while(true) {
                	 int direction;
                	 if(y == 2) {
                		 direction = rnd.nextInt(4);
                	 }else {
                		 direction = rnd.nextInt(3);
                	 }
                	 
                	 int wallx = x;
                	 int wally = y;
                	 
                	 switch(direction) {
                	 case 0: // 右
                         wallx++;
                         drawString("■",(wallx*20+40),(wally*20+80),25);
                         //sleep(0.3);
                         break;
                     case 1: // 下
                         wally++;
                         drawString("■",(wallx*20+40),(wally*20+80),25);
                         //sleep(0.3);
                         break;
                     case 2: // 左
                         wallx--;
                         drawString("■",(wallx*20+40),(wally*20+80),25);
                         //sleep(0.3);
                         break;
                     case 3: // 上
                         wally--;
                         drawString("■",(wallx*20+40),(wally*20+80),25);
                         //sleep(0.3);
                         break;
                	 }
                	 
                	 if(maze[wallx][wally] != wall) {
                		 maze[wallx][wally] = wall;
                		 drawString("■",(wallx*20+40),(wally*20+80),25);
                         //sleep(0.3);
                		 break;
                	 }
                 }
             }
         }
         return maze;
	}
	public class Regenerate implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			if(e.getKeyCode()==KeyEvent.VK_SPACE) {
				System.out.println("再生成します");
				clear();
				Maze(15,15);
			}
		}
		
	}
}
