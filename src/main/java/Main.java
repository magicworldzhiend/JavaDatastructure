import java.util.ArrayList;
import java.util.List;

/**
 * 算法
 *
 * @author 罗中泽
 * @since 2026/4/30
 */

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 10},
                {4, 5, 6, 11},
                {7, 0, 9, 12}
        };

        setZeroes(matrix);
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j < matrix[0].length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();

        }
    }

    // 螺旋矩阵
    public static List<Integer> spiralOrder(int[][] matrix) {
        int vector = 0;
        // 0向右（+列），1向下（+行），2向左（-列），3向上（-行）
        List<Integer> output = new ArrayList<>();

        // 尺寸
        int m = matrix.length;
        int n = matrix[0].length;
        int len = m * n;

        // 当前下标
        int x = 0;
        int y = 0;
        int currentInt;

        int round = 0;

        while (output.size() < len) {
            vector = vector % 4;
            if (vector == 0) {
                while (y < n - round) {
                    currentInt = matrix[x][y];
                    output.add(currentInt);
                    y++;
                }
                y--;
                x++;
                vector++;
                continue;
            }

            if (vector == 1) {
                while (x < m - round) {
                    currentInt = matrix[x][y];
                    output.add(currentInt);
                    x++;
                }
                x--;
                y--;
                vector++;
                continue;
            }

            if (vector == 2) {
                while (y >= 0 + round) {
                    currentInt = matrix[x][y];
                    output.add(currentInt);
                    y--;
                }
                y++;
                x--;
                vector++;
                round++;
                continue;
            }

            if (vector == 3) {
                while (x >= 0 + round) {
                    currentInt = matrix[x][y];
                    output.add(currentInt);
                    x--;
                }
                x++;
                y++;
                vector++;
            }
        }
        return output;
    }

    // 旋转矩阵
    public static void rotate(int[][] matrix) {

        // 逆时针旋转之后
        // (x,y) -> (y, n-1-x)
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }

    // 把0所在的行和列置零
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    xList.add(i);
                    yList.add(j);
                }
            }
        }

        for (Integer i : xList) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            };
        }

        for (Integer j : yList) {
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 0;
            }
        }
    }


}
