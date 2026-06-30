package com.AoC.Diego.day2;

public class RepeatedPatternRule implements InvalidRule {

    public enum Mode {
        PART1,
        PART2
    }

    private final Mode mode;

    public RepeatedPatternRule(Mode mode) {
        this.mode = mode;
    }

    @Override
    public boolean isInvalid(long number) {

        if (mode == Mode.PART1) {
            return isPart1(number);
        }

        return isPart2(number);
    }

    private boolean isPart1(long number) {

        String text = String.valueOf(number);

        if (text.length() % 2 != 0) {
            return false;
        }

        int half = text.length() / 2;

        String first = text.substring(0, half);
        String second = text.substring(half);

        return first.equals(second);
    }

    private boolean isPart2(long number) {

        String text = String.valueOf(number);

        int length = text.length();

        for (int blockSize = 1; blockSize <= length / 2; blockSize++) {

            if (length % blockSize != 0) {
                continue;
            }

            String block = text.substring(0, blockSize);

            boolean repeated = true;

            for (int i = blockSize; i < length; i += blockSize) {

                if (!text.substring(i, i + blockSize).equals(block)) {
                    repeated = false;
                    break;
                }

            }

            if (repeated) {
                return true;
            }

        }
        return false;
    }
}
