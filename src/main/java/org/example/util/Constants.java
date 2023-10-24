package org.example.util;

import java.util.HashSet;
import java.util.Set;

public class Constants {

    public static final String[] keywords = {"loop","num","rln","num","chr","if","else","void"};
    public static final char[] symbols = {'(',')',';','{','}','+','/','-','%','&','^','|','='};
    public static final char[] numbers = {'1','2','3','4','5','6','7','8','9','0'};
    public static final String code1 =
            "num main(){\n" +
            "    num x = 5;\n" +
            "    num y;\n" +
            "    input(y);\n" +
            "    num z = x + y;\n" +
            "    print(z);\n" +
            "}";
    public static final String code2 =
            "num main(){\n" +
            "    num i = 0;\n" +
            "    chr rijec[] = “Dule Savic”;\n" +
            "    num array[10] = {1,2,3,4,5,6,7,8,9,10};\n" +
            "    loop(i < 10){\n" +
            "        print(rijec[i]);\n" +
            "        print(array[i]);\n" +
            "    }\n" + "}";
    public static final String code3 = "void insertionSort(num arr[], num n)\n" +
            "    {\n" +
            "        num i = 0;\n" +
            "        num key, j;\n" +
            "        loop(i < n) {\n" +
            "            key = arr[i];\n" +
            "            j = i - 1;\n" +
            "            loop(j >= 0 && arr[j] > key) {\n" +
            "                arr[j + 1] = arr[j];\n" +
            "                j = j - 1;\n" +
            "            }\n" +
            "            arr[j + 1] = key;\n" +
            "            i++;\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            ""+
            "    void printArray(num arr[], num n) {\n" +
            "        int i = 0;\n" +
            "        loop(i < n) {\n" +
            "            print(arr[i]);\n" +
            "            i++;\n" +
            "        }    \n" +
            "        print(\"\\n\");\n" +
            "    }\n" +
            "\n" +
            "" +
            "    num main()\n" +
            "    {\n" +
            "        num arr[] = { 12, 11, 13, 5, 6 };\n" +
            "        num n = sizeof(arr) / sizeof(arr[0]);\n" +
            "\n" +
            "        insertionSort(arr, n);\n" +
            "        printArray(arr, n);\n" +
            "\n" +
            "        return 0;\n" +
            "    }";
    public static final String code4 =
            "num main(){\n" +
                    "    num x = 5;\n" +
                    "    num y;\n" +
                    "    input(y);\n" +
                    "    num z = x + y;\n" +
                    "    print(z);\n" +
                    "}";
    public static String code5;
    public static String code6;
    public static String code7;
    public static String code8;
    public static String code9;

    public static String code10;
    public static String code11;
    public static String code12;
    public static String code13;
    public static String code14;

    public static String code15;
    public static String code16;
    public static String code17;
    public static String code18;
    public static String code19;

    public static String code20;
    public static String[] code = {code1,code2,code3,code4,code5,code6,code7,code8,code9,
                                   code11,code12,code13,code14,code15,code16,code17,code18,code19,code20};
}
