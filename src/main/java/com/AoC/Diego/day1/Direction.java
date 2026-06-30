package com.AoC.Diego.day1;

public enum Direction {

    L {
        @Override
        public int move(int position, int clicks) {
            position = (position - clicks) % 100;
            return position < 0 ? position + 100 : position;
        }
    },

    R {
        @Override
        public int move(int position, int clicks) {
            return (position + clicks) % 100;
        }
    };

    public abstract int move(int position, int clicks);
}