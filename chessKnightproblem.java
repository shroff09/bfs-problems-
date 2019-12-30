import java.util.*; 

  class Main
{ 

 static class cell 
{ 
	int x, y; 
	int dis; 

		public cell(int x, int y, int dis) 
		{ 
			this.x = x; 
			this.y = y; 
			this.dis = dis; 
		} 
	
	
}  
// inside Board 
static boolean isInside(int x, int y, int N) 
{ 
	if (x >= 1 && x <= N && y >= 1 && y <= N) 
		return true; 
	return false; 
} 

  static int minStepToReachTarget(int knightPos[], int targetPos[], 
												int N) 
{ 
 	int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2}; 
	int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1}; 

 	Vector<cell> q = new Vector<>(); 

	// push starting position of knight with 0 distance 
	q.add(new cell(knightPos[0], knightPos[1], 0)); 

	cell t ; 
	int x, y; 
	boolean visit[][] = new boolean[N + 1][N + 1]; 

	                                                            //  make all cell unvisited 
	for (int i = 1; i <= N; i++) 
		for (int j = 1; j <= N; j++) 
			visit[i][j] = false; 

	                                                            // visit starting state 
	visit[knightPos[0]][knightPos[1]] = true; 

	// loop untill we have one element in queue 
	while (!q.isEmpty()) 
	{ 
		t = q.firstElement(); 
		q.remove(0); 

  		if (t.x == targetPos[0] && t.y == targetPos[1]) 
			return t.dis; 

		// loop for all reachable states 
		for (int i = 0; i < 8; i++) 
		{ 
			x = t.x + dx[i]; 
			y = t.y + dy[i]; 

 			if (isInside(x, y, N) && !visit[x][y]) 
			{ 
				visit[x][y] = true; 
				q.add(new cell(x, y, t.dis + 1)); 
			} 
		} 
	} 
		return Integer.MAX_VALUE; 
} 

 public static void main(String[] args) 
{ 
	Scanner sc =new Scanner(System.in);
	int N = sc.nextInt(); 
		int a = sc.nextInt(); 
		int b = sc.nextInt(); 
	    int c = sc.nextInt(); 
		int d = sc.nextInt(); 
	int knightPos[] = {a, b}; 
	int targetPos[] = {c, d}; 
	System.out.print(minStepToReachTarget(knightPos, targetPos, N)); 
	} 
}
