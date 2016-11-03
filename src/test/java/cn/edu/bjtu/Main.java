package cn.edu.bjtu;

import java.util.Scanner;
import java.util.LinkedList; 

public class Main {
	static int endX = 0;
	static int endY = 0;
	static int width = 0;
	static int height = 0;
	static int min = Integer.MAX_VALUE;
	static int[][] maze;
	static int[][] mark;
	static LinkedList<Integer> map = new LinkedList<Integer>();
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){			
			width = in.nextInt();
			height = in.nextInt();
            maze = new int[height][width];
	        mark = new int[height][width];
			int value = in.nextInt();
			//in.nextLine();
			endX = 0;
			endY = width - 1;
						
			for(int i = 0; i < height; i++){
				for(int j = 0; j < width; j++){
					maze[i][j] = in.nextInt();
				}
			}
			
			int result = dfs(0, 0, 0);
			if(result <= value && result < Integer.MAX_VALUE)
				System.out.println("最少需要" + result + "步");
			else
				System.out.println("Can not escape");
			
			
		}
	}
	
	 public static int dfs(int startX, int startY, int step) {  
	        int[][] next = new int[][] { //按右->下->左->上的顺序尝试  
	                {1, 0},  
	                {0, 1},  
	                {-1, 0},  
	                {0, -1}  
	        };  
	        int nextX, nextY;  
	        int posible;  
	        if(startX == endX && startY == endY) {  
	            if(step < min)  
	                min = step;  
	            for(int i = map.size() - 1; i >= 0; i -= 2){  
	                nextX = map.get(i);  
	                nextY = map.get(i - 1);  
	                System.out.print("[" + nextX + "," + nextY + "]");  
	                if(i != 1)  
	                    System.out.print(",");  
	            }  
	            System.out.println();  
	            return min;  
	        }  
	        for(posible = 0; posible < next.length; posible++) { //按右->下->左->上的顺序尝试  
	            nextX = startX + next[posible][0];  
	            nextY = startY + next[posible][1];  
	            if(nextX < 0 || nextX >= width || nextY < 0 || nextY >= height) {  //超出边界  
	                continue;  
	            }  
	            if(maze[nextX][nextY] == 0 && mark[nextX][nextY] == 0) {  //非障碍且未标记走过  
	                map.push(nextX);  
	                map.push(nextY);  
	                mark[nextX][nextY] = 1;  
	                dfs(nextX, nextY, step + 1);  //递归调用, 移动到下一格  
	                mark[nextX][nextY] = 0;  
	                map.pop();  
	                map.pop();  
	            }  
	        }
			return 0;  
	    }  
		
}