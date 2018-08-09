package com.example.app4;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * autour : lbing
 * date : 2018/8/8 0008 14:34
 * className :
 * version : 1.0
 * description :
 */

//按照是有向带权值的邻接矩阵
public class Gragh {
    public static final int MAX_WEIGHT = 9999;//权值最大，表示非联通
    public int[][] matrix;//邻接矩阵
    private int vertexSize;//这是顶点的数量
    private int[] vertexts;//顶点数组
    private boolean[] isVisited;
    //将数据存放在队列中
    private LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
    private HashMap<String, Integer> vertexsMap = new HashMap<>();
    private ArrayList<Integer> vertexsList = new ArrayList<>();
    private int primWeightNum = 0;
    private ArrayList<Integer> kruskalVertexList = new ArrayList<>();
    private HashMap<String, String> kruskalHashMap = new HashMap<String, String>();
    private int[] indexs;

    public Gragh(int vertexSize) {
        this.vertexSize = vertexSize;
        vertexts = new int[vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            vertexts[i] = i;
        }
        matrix = new int[vertexSize][vertexSize];
        isVisited = new boolean[vertexSize];
    }

    //    获取某个节点的出度
    public int getOutDegree(int index) {
        int count = 0;
        for (int i = 0; i < vertexSize; i++) {
            int weight = matrix[index][i];
            if (weight > 0 && weight < Gragh.MAX_WEIGHT) {
                count++;
            }
        }
        return count;
    }

    //获取某个节点的入度
    public int getInDegree(int index) {
        int count = 0;
        for (int i = 0; i < vertexSize; i++) {
            int weight = matrix[i][index];
            if (weight > 0 && weight < Gragh.MAX_WEIGHT) {
                count++;
            }
        }
        return count;
    }

    //获取某个节点的第一个邻接点
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexSize; i++) {
            int weight = matrix[index][i];
            if (weight > 0 && weight < Gragh.MAX_WEIGHT) {
                return i;
            }
        }
        return -1;
    }

    //查找某个节点中的某个邻接点的下个邻接点
    public int getNextNeighbor(int v, int index) {
        for (int i = index + 1; i < vertexSize; i++) {
            if (matrix[v][i] > 0 && matrix[v][i] < MAX_WEIGHT) {
                return i;
            }
        }
        return -1;
    }

    //深度优先遍历  相当于树的前序遍历  depthFirstSearch
    public void dfs(int index) {
        isVisited[index] = true;//将访问后的节点记录下来
        Log.e("TAG", "访问节点===" + index);
        int firstNeighbor = getFirstNeighbor(index);
        //这个负责不停的寻找当前顶点的第一个连接的顶点，实现深度遍历的效果
        if (firstNeighbor != -1) {
            if (!isVisited[firstNeighbor]) {
                dfs(firstNeighbor);
            }
        }
        //如果上面找到的节点没有找到下一个连接点，或是已经被遍历过了，那么就查询当前节点旁边的节点
        //如果已经被访问了，那么继续找其他的旁边相连接的节点，如果没有访问过，那么就查找这个节点的第一个连接点
        int nextNeighbor = getNextNeighbor(index, firstNeighbor);
        while (nextNeighbor != -1) {
            if (!isVisited[nextNeighbor]) {
                dfs(nextNeighbor);
            } else {
                nextNeighbor = getNextNeighbor(index, nextNeighbor);
            }
        }
    }

    //广度优先遍历   broadFirstSearch 就是相当于层次遍历
    // 这里使用队列的原理，当访问完一个节点后就去访问他的兄弟节点，并将节点存放在队列中，当兄弟节点都访问过后
    //就将节点出队，出队的节点找寻他的未被访问过的节点，然后继续入队。这样借助队列实现一个节点的记忆功能.
    public void bfs(int index) throws InterruptedException {
        if (!isVisited[index]) {
            isVisited[index] = true;
            Log.e("TAG", "访问节点===" + index);
            queue.offer(index);//将数据存放在队列中
        }
        //获取到第一个节点
        int firstNeighbor = getFirstNeighbor(index);
        if (firstNeighbor != -1) {
            if (!isVisited[firstNeighbor]) {
                Log.e("TAG", "访问节点===" + firstNeighbor);
                isVisited[firstNeighbor] = true;
                queue.offer(firstNeighbor);
            }
            Integer poll = queue.poll();//将根节点退出栈，然后查询和它相连的其他连接点
            int nextNeighbor = getNextNeighbor(poll, firstNeighbor);
            while (nextNeighbor != -1) {
                if (!isVisited[nextNeighbor]) {
                    Log.e("TAG", "访问节点===" + nextNeighbor);
                    isVisited[nextNeighbor] = true;
                    queue.offer(nextNeighbor);
                }
                nextNeighbor = getNextNeighbor(poll, nextNeighbor);
            }
            while (queue.size() > 0) {
                bfs(queue.peek());//使用queue.peek()查看queue中最前面的数据
            }
        }
    }

    //prim算法
    //这个就是查询当前的节点相连接的节点，然后查询权值，找到最小的权值后就存放在集合中，然后遍历集合的中节点的相连接的各个节点的权值
    //找到其中没有存储过的节点，然后继续存放在集合中。这里要注意避免环的出现，因此在找寻权值最小的节点的时候，要遍历节点集合，如果有相同的
    //节点，那么就证明会出现环。
    public void prim(int index) {
        //先找到当前节点的最小的权值
        Log.e("TAG", "prim遍历节点：" + index + "   权值：" + 0);
        vertexsList.add(index);
        primOriginal();
    }

    public void primOriginal() {
        int minWeight = MAX_WEIGHT;
        int curIndex = -1;
        int curIndex2 = -1;
        //遍历集合中的节点，找到当前节点中的其他的节点，
        for (int i = 0; i < vertexsList.size() && vertexsList.size() < vertexSize; i++) {
            //然后遍历这个节点对应的数组，找寻其中的最小的权值
            for (int j = 0; j < vertexSize; j++) {
                int weight = matrix[vertexsList.get(i)][j];

                if (weight > 0 && weight < minWeight
                        && (vertexsMap.get(vertexsList.get(i) + "---" + j) == null || (vertexsMap.get(vertexsList.get(i) + "---" + j) != weight))
                        && (vertexsMap.get(j + "---" + vertexsList.get(i)) == null || vertexsMap.get(j + "---" + vertexsList.get(i)) != weight)) {
                    boolean temp = false;
                    //这里要进行避免环，进行遍历存储节点的数组，如果有这个节点了，证明已经遍历过了
                    for (int k = 0; k < vertexsList.size(); k++) {
                        if (j == vertexsList.get(k)) {
                            temp = true;
                        }
                    }
                    if (!temp) {
                        minWeight = weight;
                        curIndex = i;
                        curIndex2 = j;
                    }
                }
            }
        }
        if (curIndex >= 0 && vertexsList.get(curIndex) >= 0 && minWeight < MAX_WEIGHT) {
            primWeightNum += minWeight;
            //进行记录已经遍历的弧
            vertexsMap.put(vertexsList.get(curIndex) + "---" + curIndex2, minWeight);
            vertexsMap.put(curIndex2 + "---" + vertexsList.get(curIndex), minWeight);
            //进行记录已经遍历过的点
            vertexsList.add(curIndex2);
            Log.e("TAG", "prim遍历节点：" + curIndex2 + "   权值：" + primWeightNum);
            primOriginal();
        }

    }

    //kruskal算法
    public void kruskal() {
        indexs=new int[vertexSize];
        int minWeight = MAX_WEIGHT;
        int begin = -1;
        int end = -1;
        for (int i = 0; i < vertexSize; i++) {
            for (int j = 0; j < vertexSize; j++) {
                if (matrix[i][j] > 0 && matrix[i][j] < minWeight
                        && kruskalHashMap.get(i + "---" + j) == null
                        && kruskalHashMap.get(j + "---" + i) == null) {
                    //这里也要避免出现环，这里要查找起点和终点
                    //这里采用了一个数组的管理，即：数组中下标索引中对应的是重点的索引



                    minWeight = matrix[i][j];
                    begin = i;
                    end = j;
                }
            }
        }

        if (begin >= 0 && end >= 0 && minWeight < MAX_WEIGHT) {
            kruskalVertexList.add(begin);
            kruskalVertexList.add(end);
            kruskalHashMap.put(begin + "---" + end, begin + "---" + end);
            kruskalHashMap.put(end + "---" + begin, end + "---" + begin);
            Log.e("TAG", "kruskal开始节点：" + begin + "   结束节点：" + end + "   权值：" + minWeight);
            kruskal();
        }


    }
}
