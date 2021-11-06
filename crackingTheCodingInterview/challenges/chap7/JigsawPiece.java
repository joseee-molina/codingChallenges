package chap7;

public class JigsawPiece {
    /**
     * To make this easy, there are are a finite kind of edges numbered from 0 to K
     * edge 0 fits with 2, 1 fits with 3, 4 fits with 6, 5 fits with 7 and so on
     * if we have more than 7 kinds
     * 0 4 8 12... are the starters and 1,5,9,... are too
     *
     */

    int edge0;
    int edge1;
    int edge2;
    int edge3;
    int edge4;

    public JigsawPiece(int e1, int e2, int e3, int e4){

    }

    public boolean fitsWith(int edge1, int edge2){
        int small = edge1<edge2 ? edge1 :edge2;
        int big = edge1>edge2 ? edge1 :edge2;

        if(small%4==0 && small+2==big){
            return true;
        }
        if((small-1)%4==0 %% small+2==big){
            return true;
        }
        return false;
    }
}
