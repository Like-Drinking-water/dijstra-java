package com.huanleichen.dijstra.java.test;

import com.huanleichen.dijstra.java.commons.FindPath;

import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        int[][] graph = {
                        {0, 2, 5, 6},
                        {2, 0, 1, 7},
                        {1, 4, 0, 2},
                        {2, 5, 3, 0}
                    };

        FindPath findPath = new FindPath(graph);

        findPath.getEachShortPath(0);

        System.out.println(Arrays.toString(findPath.getDistance()));
        System.out.println(Arrays.toString(findPath.getPath()));
    }
}
