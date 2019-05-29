package com.huanleichen.dijstra.java.test;

import com.huanleichen.dijstra.java.commons.FindPath;

import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        int[][] graph = {
                        {0, 1, 12, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                        {Integer.MAX_VALUE, 0, 9, 3, Integer.MAX_VALUE, Integer.MAX_VALUE},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 5, Integer.MAX_VALUE},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 0, 13, 15},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 4},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
                    };

        FindPath findPath = new FindPath(graph);

        findPath.getEachShortPath(0);

        System.out.println(Arrays.toString(findPath.getDistance()));
        System.out.println(Arrays.toString(findPath.getPath()));
    }
}
