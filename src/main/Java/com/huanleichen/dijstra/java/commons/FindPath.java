package com.huanleichen.dijstra.java.commons;

public class FindPath {
    //要计算路径的图矩阵
    private int[][] graph;
    //是否已经是最短距离
    private boolean[] isShort;
    //起点到终点的最短距离
    private int[] distance;
    //起点到终点的最短路径
    private String[] path;

    public FindPath(int[][] graph) {
        if(!isRightGraph(graph)) {
            throw new RuntimeException("the format of graph is error");
        }
        this.graph = graph;
        isShort = new boolean[graph.length];
        distance = new int[graph.length];
        path = new String[graph.length];
    }

    public int[] getDistance() {
        return distance;
    }

    public String[] getPath() {
        return path;
    }

    /**
     * 将v0到达的所有节点的最短路径和距离分别存储在path跟distance中
     * @param v0 起点
     */
    public void getEachShortPath(int v0) {
        //初始化
        //将是否已经最短路径设为否
        //将距离初始化为两点的直接距离
        for (int v = 0; v < graph.length; v++) {
            isShort[v] = false;
            distance[v] = graph[v0][v];
            //如果是起点
            if (v == v0) {
                //为v0的路径设置节点
                connectPath(v, v);
                isShort[v] = true;
            }
        }

        //循环找出最短距离
        for (int i = 0; i < graph.length - 1; i++) {
            //将最小距离设为整型的最大值
            int min = Integer.MAX_VALUE;
            //用于查找距离v0最近的点
            int v = 0;

            for (int w = 0; w < graph.length; w++) {
                if (!isShort[w]) {
                    if (distance[w] < min) {
                        v = w;
                        min = distance[w];
                    }
                }
            }
            //如果路径中没有元素则直接将终点节点添加进去
            if (path[v] == null) {
                connectPath(v, v);
            }
            isShort[v] = true;

            for (int w = 0; w < graph.length; w++) {
                //如果v0到v的最短距离加上v到w的距离小于distance现在设置距离
                //则将distance设置为v0到v的最短距离加上v到w的距离
                //并修改路径为:v0到v的路径加上到w节点
                if (!isShort[w] && (min + graph[v][w] < distance[w])) {
                    distance[w] = min + graph[v][w];
                    path[w] = path[v] + " -> " + w;
                }
            }
        }

        //将起点加到路径中
        for (int i = 0; i < graph.length; i++) {
            path[i] = v0 + " -> " + path[i];
        }
    }

    /**
     * 拼接路径
     * @param v0 要拼接的路径
     * @param v 要拼接的节点
     */
    private void connectPath(int v0, int v) {
        if (path[v0] == null) {
            path[v0] = "" + v;
        }
        else {
            path[v0] += " -> " + v;
        }
    }

    /**
     * 判断传入的图是否正确
     * @param graph 要进行计算路径的图
     * @return 返回true 表示图合法
     *          返回false 表示图不合法
     */
    private boolean isRightGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            //判断图矩阵的行和列是否相等
            if (graph[i].length != graph.length) {
                return false;
            }
            //判断图矩阵的对角元素是否为零
            if (graph[i][i] != 0) {
                return false;
            }
        }
        //符合条件返回true
        return true;
    }

}
