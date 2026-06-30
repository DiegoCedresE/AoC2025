package com.AoC.Diego.day9;
import java.util.List;

import java.util.*;

public class PolygonService {

    private final boolean[][] valid;
    private final int width;
    private final int height;
    private final int offsetX;
    private final int offsetY;

    public PolygonService(List<Point> points) {

        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        for (Point p : points) {
            minX = Math.min(minX, p.x());
            maxX = Math.max(maxX, p.x());
            minY = Math.min(minY, p.y());
            maxY = Math.max(maxY, p.y());
        }

        offsetX = (int) minX - 1;
        offsetY = (int) minY - 1;

        width = (int)(maxX - minX + 3);
        height = (int)(maxY - minY + 3);

        valid = new boolean[width][height];

        drawBorder(points);
        fillInside();
    }

    private void drawBorder(List<Point> points) {

        for (int i = 0; i < points.size(); i++) {

            Point a = points.get(i);
            Point b = points.get((i + 1) % points.size());

            if (a.x() == b.x()) {

                int x = (int) (a.x() - offsetX);

                int from = (int) Math.min(a.y(), b.y());
                int to = (int) Math.max(a.y(), b.y());

                for (int y = from; y <= to; y++) {
                    valid[x][y - offsetY] = true;
                }

            } else {

                int y = (int) (a.y() - offsetY);

                int from = (int) Math.min(a.x(), b.x());
                int to = (int) Math.max(a.x(), b.x());

                for (int x = from; x <= to; x++) {
                    valid[x - offsetX][y] = true;
                }
            }
        }
    }

    private void fillInside() {

        boolean[][] outside = new boolean[width][height];

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{0,0});
        outside[0][0] = true;

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        while(!queue.isEmpty()){

            int[] c = queue.poll();

            for(int k=0;k<4;k++){

                int nx = c[0]+dx[k];
                int ny = c[1]+dy[k];

                if(nx<0 || ny<0 || nx>=width || ny>=height)
                    continue;

                if(outside[nx][ny])
                    continue;

                if(valid[nx][ny])
                    continue;

                outside[nx][ny]=true;
                queue.add(new int[]{nx,ny});
            }
        }

        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){
                if(!outside[x][y]){
                    valid[x][y]=true;
                }
            }
        }
    }

    public boolean rectangleInside(Point p1, Point p2){

        int minX=(int)Math.min(p1.x(),p2.x())-offsetX;
        int maxX=(int)Math.max(p1.x(),p2.x())-offsetX;

        int minY=(int)Math.min(p1.y(),p2.y())-offsetY;
        int maxY=(int)Math.max(p1.y(),p2.y())-offsetY;

        for(int x=minX;x<=maxX;x++){
            for(int y=minY;y<=maxY;y++){

                if(!valid[x][y]){
                    return false;
                }
            }
        }
        return true;
    }

}