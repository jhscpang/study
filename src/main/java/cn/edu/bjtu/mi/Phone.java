package cn.edu.bjtu.mi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by pangchao on 16/9/25.
 */
public class Phone {

    private static Map<Character, Integer> map = new HashMap<Character, Integer>();

    static {
        //提取关键字有顺序，但是顺序不是唯一的， 解析的时候按自己维护的提取顺序解析
        map.put('Z', 0);
        map.put('X', 6);
        map.put('S', 7);
        map.put('U', 4);
        map.put('V', 5);
        map.put('R', 3);
        map.put('G', 8);
        map.put('W', 2);
        map.put('O', 1);
        map.put('I', 9);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                //处理输入
                String s = scanner.next();

                //根据特征字符提取数字
                String number = extractNumber(s);

                //根据减8原则提取出原始数字串
                int[] numArray = extractOriginalNumber(number);

                //提取最小号码
                Arrays.sort(numArray);

                //输出
                printResult(numArray);
            }

        }
    }

    private static void printResult(int[] numArray) {
        if (numArray == null || numArray.length == 0)
            return;

        StringBuffer sb = new StringBuffer();
        for (int number : numArray) {
            sb.append(number);
        }

        System.out.println(sb.toString());
    }

    private static String extractNumber(String s) {
        if (s == null || "".equals(s))
            return s;

        char[] cArray = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        //先提取第一波： Z, X, S, U, G, W
        for (char c : cArray) {
            switch (c) {
                case 'Z':
                    removeOneChar(cArray, 'Z');
                    removeOneChar(cArray, 'E');
                    removeOneChar(cArray, 'R');
                    removeOneChar(cArray, 'O');
                    sb.append(map.get(c));
                    break;
                case 'X':
                    removeOneChar(cArray, 'S');
                    removeOneChar(cArray, 'I');
                    removeOneChar(cArray, 'X');
                    sb.append(map.get(c));
                    break;
                case 'S':
                    removeOneChar(cArray, 'S');
                    removeOneChar(cArray, 'E');
                    removeOneChar(cArray, 'V');
                    removeOneChar(cArray, 'E');
                    removeOneChar(cArray, 'N');
                    sb.append(map.get(c));
                    break;
                case 'U':
                    removeOneChar(cArray, 'F');
                    removeOneChar(cArray, 'O');
                    removeOneChar(cArray, 'U');
                    removeOneChar(cArray, 'R');
                    sb.append(map.get(c));
                    break;
                case 'G':
                    removeOneChar(cArray, 'E');
                    removeOneChar(cArray, 'I');
                    removeOneChar(cArray, 'G');
                    removeOneChar(cArray, 'H');
                    removeOneChar(cArray, 'T');
                    sb.append(map.get(c));
                    break;
                case 'W':
                    removeOneChar(cArray, 'T');
                    removeOneChar(cArray, 'W');
                    removeOneChar(cArray, 'O');
                    sb.append(map.get(c));
                    break;
                default:
                    break;
            }
        }

        //再提取第二波： V, R, O
        for (char c : cArray) {
            switch (c) {
                case 'V':
                    removeOneChar(cArray, 'F');
                    removeOneChar(cArray, 'I');
                    removeOneChar(cArray, 'V');
                    removeOneChar(cArray, 'E');
                    sb.append(map.get(c));
                    break;
                case 'R':
                    removeOneChar(cArray, 'T');
                    removeOneChar(cArray, 'H');
                    removeOneChar(cArray, 'R');
                    removeOneChar(cArray, 'E');
                    removeOneChar(cArray, 'E');
                    sb.append(map.get(c));
                    break;
                case 'O':
                    removeOneChar(cArray, 'Z');
                    removeOneChar(cArray, 'E');
                    removeOneChar(cArray, 'R');
                    removeOneChar(cArray, 'O');
                    sb.append(map.get(c));
                    break;
                default:
                    break;
            }
        }

        //再提取第三波： I
        for (char c : cArray) {
            switch (c) {
                case 'I':
                    removeOneChar(cArray, 'N');
                    removeOneChar(cArray, 'I');
                    removeOneChar(cArray, 'N');
                    removeOneChar(cArray, 'E');
                    sb.append(map.get(c));
                    break;
                default:
                    break;
            }
        }

        return sb.toString();
    }

    private static int[] extractOriginalNumber(String number) {
        if (number == null || "".equals(number))
            return null;

        char[] cArray = number.toCharArray();
        int[] intArray = new int[cArray.length];
        for (int i = 0; i < cArray.length; i++) {
            int tmp = cArray[i] - '0';
            if (tmp >= 8)
                intArray[i] = tmp - 8;
            else
                intArray[i] = tmp + 2;
        }

        return intArray;
    }

    private static void removeOneChar(char[] cArray, Character c) {
        if (cArray == null || cArray.length == 0)
            return;

        for (int i = 0; i < cArray.length; i++) {
            if (c == cArray[i]) {
                cArray[i] = '0';//用字符'0'标记该字符已删除
                break;//一次只删除一个
            }
        }
    }
}
