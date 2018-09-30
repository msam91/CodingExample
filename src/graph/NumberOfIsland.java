package graph;

public class NumberOfIsland {
        public int numberOfIsland(int[][] graph){
            
            boolean[][] visited = new boolean[graph.length][graph[0].length];
            int count = 0;
            for(int i=0; i < graph.length ; i ++){
                for(int j =0 ; j < graph[i].length ; j++){
                    if( graph[i][j] == 1) {
                        count++;
                        //DFS(graph,visited,i,j);
                        markIsland(graph, i, j, graph.length, graph[0].length);
                        
                    }
                }
            }
            return count;
        }
        
        private void DFS(int[][] graph, boolean[][] visited,int i,int j){
            if(i <0 || j < 0 || i == graph.length || j == graph[i].length)
            {
                return;
                
            }
            visited[i][j] = true;
            if(graph[i][j] == 0){
                return;
            }
            DFS(graph,visited,i,j+1);
            DFS(graph,visited,i+1,j);
            DFS(graph,visited,i+1,j+1);
            DFS(graph,visited,i-1, j+1);
        }
        
        private void markIsland(int[][]grid,int i, int j,int m, int n){
            if(i<0 || i>m-1 || j<0 || j>n-1){
                return;
            }
            if(grid[i][j]==0 || grid[i][j]==3){
                return;
            }
            if(grid[i][j] ==1){
                grid[i][j] =3;
            }
             markIsland(grid,i,j-1,m,n);
             markIsland(grid,i-1,j-1,m,n);
             markIsland(grid,i-1,j,m,n);
             markIsland(grid,i-1,j+1,m,n);
             markIsland(grid,i,j+1,m,n);
             markIsland(grid,i+1,j+1,m,n);
             markIsland(grid,i+1,j,m,n);
             markIsland(grid,i+1,j-1,m,n);
                
        }
        
        public static void main(String args[]){
            
            int matrix[][] = {{1,1,0,0,0},
                              {1,1,0,0,0},
                              {0,0,0,1,1},
                              {0,0,0,1,1}
                            };
            NumberOfIsland island = new NumberOfIsland();
            int count = island.numberOfIsland(matrix);
            System.out.println(count);
        }
}
