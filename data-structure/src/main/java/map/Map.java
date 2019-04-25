package map;

import java.util.Arrays;

/**
 * Class Map ...
 *
 * @author LiJun
 * Created on 2019/4/25
 */
public class Map {
    public int numVertex;
    public String[] vertex;
    public int[][] edge;
    public int numEdge;

    public Map() {
        this(0, 0);
    }


    public Map(int numVertex, int numEdge) {
        init(numVertex, numEdge);
    }

    public void init(int numVertex, int numEdge) {
        this.numVertex = numVertex;
        this.numEdge = numEdge;
        this.vertex = new String[numVertex];
        this.edge = new int[numVertex][numVertex];
        for (int i = 0; i < numVertex; i++) {
            for (int j = 0; j < numVertex; j++) {
                // 代表不可达
                // this.edge[i][j] = Integer.MAX_VALUE;
                this.edge[i][j] = 0;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < numVertex; i++){
            str.append(Arrays.toString(edge[i]));
            str.append("\n");
        }
        return str.toString();
    }
}
