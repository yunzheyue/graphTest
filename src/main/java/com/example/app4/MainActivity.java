package com.example.app4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Gragh gragh = new Gragh(8);
//        int[] a0 = new int[]{0, 1, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT};
//        int[] a1 = new int[]{1, 0, 1, Gragh.Gragh.MAX_WEIGHT, 1, Gragh.Gragh.MAX_WEIGHT, 1, Gragh.Gragh.MAX_WEIGHT};
//        int[] a2 = new int[]{Gragh.Gragh.MAX_WEIGHT, 1, 0, 1, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT};
//        int[] a3 = new int[]{Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, 1, 0, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT};
//        int[] a4 = new int[]{Gragh.Gragh.MAX_WEIGHT, 1, 1, Gragh.Gragh.MAX_WEIGHT, 0, 1, 1, Gragh.Gragh.MAX_WEIGHT};
//        int[] a5 = new int[]{Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, 1, 0, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT};
//        int[] a6 = new int[]{Gragh.Gragh.MAX_WEIGHT, 1, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, 1, Gragh.Gragh.MAX_WEIGHT, 0, 1};
//        int[] a7 = new int[]{Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, Gragh.Gragh.MAX_WEIGHT, 1, 0};
//        gragh.matrix[0] = a0;
//        gragh.matrix[1] = a1;
//        gragh.matrix[2] = a2;
//        gragh.matrix[3] = a3;
//        gragh.matrix[4] = a4;
//        gragh.matrix[5] = a5;
//        gragh.matrix[6] = a6;
//        gragh.matrix[7] = a7;

//        Log.e("TAG", "获取出度==="+gragh.getOutDegree(0));
//        Log.e("TAG", "获取出度==="+gragh.getOutDegree(5));
//        Log.e("TAG", "获取出度==="+gragh.getOutDegree(6));
//        Log.e("TAG", "获取出度==="+gragh.getOutDegree(7));
//        Log.e("TAG", "获取入度==="+gragh.getInDegree(0));
//        Log.e("TAG", "获取入度==="+gragh.getInDegree(5));
//        Log.e("TAG", "获取入度==="+gragh.getInDegree(6));
//        Log.e("TAG", "获取入度==="+gragh.getInDegree(7));
//        Log.e("TAG", "获取第一个邻接点==="+gragh.getFirstNeighbor(0));
//        Log.e("TAG", "获取第一个邻接点==="+gragh.getFirstNeighbor(5));
//        Log.e("TAG", "获取第一个邻接点==="+gragh.getFirstNeighbor(6));
//        Log.e("TAG", "获取第一个邻接点==="+gragh.getFirstNeighbor(7));
//
//
//        Log.e("TAG", "获取下个邻接点==="+gragh.getNextNeighbor(6,1));
//        Log.e("TAG", "获取下个邻接点==="+gragh.getNextNeighbor(7,3));
//        Log.e("TAG", "获取下个邻接点==="+gragh.getNextNeighbor(8,2));
//
//        gragh.dfs(4);
//        try {
//            gragh.bfs(4);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Gragh graph = new Gragh(9);
        int[] a1 = new int[]{0, 10, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, 11, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT};
        int[] a2 = new int[]{10, 0, 18, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, 16, Gragh.MAX_WEIGHT, 12};
        int[] a3 = new int[]{Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, 0, 22, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, 8};
        int[] a4 = new int[]{Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, 22, 0, 20, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, 16, 21};
        int[] a5 = new int[]{Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, 20, 0, 26, Gragh.MAX_WEIGHT, 7, Gragh.MAX_WEIGHT};
        int[] a6 = new int[]{11, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, 26, 0, 17, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT};
        int[] a7 = new int[]{Gragh.MAX_WEIGHT, 16, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, 17, 0, 19, Gragh.MAX_WEIGHT};
        int[] a8 = new int[]{Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, 16, 7, Gragh.MAX_WEIGHT, 19, 0, Gragh.MAX_WEIGHT};
        int[] a9 = new int[]{Gragh.MAX_WEIGHT, 12, 8, 21, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, Gragh.MAX_WEIGHT, 0};

        graph.matrix[0] = a1;
        graph.matrix[1] = a2;
        graph.matrix[2] = a3;
        graph.matrix[3] = a4;
        graph.matrix[4] = a5;
        graph.matrix[5] = a6;
        graph.matrix[6] = a7;
        graph.matrix[7] = a8;
        graph.matrix[8] = a9;
//        try {
//            graph.bfs(0);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        graph.prim(0);
        graph.kruskal();
    }

}
