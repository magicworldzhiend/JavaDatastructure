import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 算法
 *
 * @author 罗中泽
 * @since 2026/4/30
 */

public class Main {
    public static void main(String[] args) {

        String s = "abba", t = "dog cat cat dog";
        System.out.println(wordPattern(s, t));
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

    // leetcode289:生命游戏
    // 纯暴力解法 O(mn)
    public static void gameOfLife(int[][] board) {

        int rows = board.length;
        int columns = board[0].length;
        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int count = 0;
                if (rows == 1 && columns == 1) {
                    count = 0;
                } else if (rows == 1) {
                    if (j == 0) {
                        if (board[i][j + 1] == 1) {
                            count++;
                        }
                    } else if (j == columns - 1) {
                        if (board[i][j - 1] == 1) {
                            count++;
                        }
                    } else {
                        if (board[i][j + 1] == 1) {
                            count++;
                        }
                        if (board[i][j - 1] == 1) {
                            count++;
                        }
                    }

                } else if (columns == 1) {
                    if (i == 0) {
                        if (board[i + 1][j] == 1) {
                            count++;
                        }
                    } else if (i == rows - 1) {
                        if (board[i - 1][j] == 1) {
                            count++;
                        }
                    } else {
                        if (board[i + 1][j] == 1) {
                            count++;
                        }
                        if (board[i - 1][j] == 1) {
                            count++;
                        }
                    }
                } else if (i > 0 && i < rows - 1 && j > 0 && j < columns - 1) {
                    if (board[i - 1][j - 1] == 1) {
                        count++;
                    }

                    if (board[i - 1][j] == 1) {
                        count++;
                    }

                    if (board[i - 1][j + 1] == 1) {
                        count++;
                    }

                    if (board[i][j - 1] == 1) {
                        count++;
                    }

                    if (board[i][j + 1] == 1) {
                        count++;
                    }

                    if (board[i + 1][j - 1] == 1) {
                        count++;
                    }

                    if (board[i + 1][j] == 1) {
                        count++;
                    }

                    if (board[i + 1][j + 1] == 1) {
                        count++;
                    }
                } else if (i > 0 && i < rows - 1) {
                    if (j == 0) {
                        if (board[i - 1][j] == 1) {
                            count++;
                        }

                        if (board[i - 1][j + 1] == 1) {
                            count++;
                        }

                        if (board[i][j + 1] == 1) {
                            count++;
                        }
                        if (board[i + 1][j] == 1) {
                            count++;
                        }

                        if (board[i + 1][j + 1] == 1) {
                            count++;
                        }

                    } else {
                        if (board[i - 1][j - 1] == 1) {
                            count++;
                        }

                        if (board[i - 1][j] == 1) {
                            count++;
                        }

                        if (board[i][j - 1] == 1) {
                            count++;
                        }

                        if (board[i + 1][j - 1] == 1) {
                            count++;
                        }

                        if (board[i + 1][j] == 1) {
                            count++;
                        }
                    }
                } else if (j > 0 && j < columns - 1) {
                    if (i == 0) {
                        if (board[i][j - 1] == 1) {
                            count++;
                        }

                        if (board[i][j + 1] == 1) {
                            count++;
                        }

                        if (board[i + 1][j - 1] == 1) {
                            count++;
                        }

                        if (board[i + 1][j] == 1) {
                            count++;
                        }

                        if (board[i + 1][j + 1] == 1) {
                            count++;
                        }
                    } else {
                        if (board[i - 1][j - 1] == 1) {
                            count++;
                        }

                        if (board[i - 1][j] == 1) {
                            count++;
                        }

                        if (board[i - 1][j + 1] == 1) {
                            count++;
                        }

                        if (board[i][j - 1] == 1) {
                            count++;
                        }

                        if (board[i][j + 1] == 1) {
                            count++;
                        }

                    }

                } else {
                    if (i == 0 && j == 0) {
                        if (board[i][j + 1] == 1) {
                            count++;
                        }
                        if (board[i + 1][j] == 1) {
                            count++;
                        }

                        if (board[i + 1][j + 1] == 1) {
                            count++;
                        }

                    }

                    if (i == 0 && j == columns - 1) {
                        if (board[i][j - 1] == 1) {
                            count++;
                        }
                        if (board[i + 1][j - 1] == 1) {
                            count++;
                        }

                        if (board[i + 1][j] == 1) {
                            count++;
                        }
                    }

                    if (i == rows - 1 && j == 0) {
                        if (board[i - 1][j] == 1) {
                            count++;
                        }

                        if (board[i - 1][j + 1] == 1) {
                            count++;
                        }
                        if (board[i][j + 1] == 1) {
                            count++;
                        }
                    }

                    if (i == rows - 1 && j == columns - 1) {
                        if (board[i - 1][j - 1] == 1) {
                            count++;
                        }

                        if (board[i - 1][j] == 1) {
                            count++;
                        }

                        if (board[i][j - 1] == 1) {
                            count++;
                        }
                    }


                }

                switch (count) {
                    case 0:
                        result[i][j] = 0;
                        break;
                    case 1:
                        result[i][j] = 0;
                        break;
                    case 2:
                        result[i][j] = board[i][j];
                        break;
                    case 3:
                        result[i][j] = 1;
                        break;

                    default:
                        result[i][j] = 0;
                        break;
                }
            }

        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = result[i][j];
            }
        }
    }

    // leetcode383 赎金信(EZ)
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (char c : ransomNote.toCharArray()) {
            if (!map2.containsKey(c)) {
                map2.put(c, 1);
            } else {
                map2.put(c, map2.get(c) + 1);
            }
        }

        for (Character c : map2.keySet()) {
            if (map.containsKey(c)) {
                if (map.get(c) >= map2.get(c)) {
                    continue;
                } else {
                    return false;
                }
            }
            return false;
        }

        return true;
    }

    // leetcode205 同构字符串
    public static boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        if (sCharArray.length != tCharArray.length) {
            return false;
        }

        for (int i = 0; i < sCharArray.length; i++) {
            if (!map.containsKey(sCharArray[i])) {
                if (map.containsValue(tCharArray[i])) {
                    return false;
                }
                map.put(sCharArray[i], tCharArray[i]);
            } else {
                if (map.get(sCharArray[i]) != tCharArray[i]) {
                    return false;
                }
            }

        }
        return true;
    }

    // leecode290 单词规律
    public static boolean wordPattern(String pattern, String s) {

        String[] s1 = s.split(" ");
        char[] charArray = pattern.toCharArray();
        HashMap<Character, String> hashMap = new HashMap<>();

        if (charArray.length != s1.length) {
            return false;
        }

        for (int i = 0; i < charArray.length; i++) {
            if (!hashMap.containsKey(charArray[i])) {
                if (hashMap.containsValue(s1[i])) {
                    return false;
                }
                hashMap.put(charArray[i], s1[i]);
            } else {
                if (!hashMap.get(charArray[i]).equals(s1[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}
