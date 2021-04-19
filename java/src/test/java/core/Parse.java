package core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parse {

    /**
     * 解析一维整数数组
     *
     * @param json 输入Json字符串
     * @return 输出一维正数数组
     */
    public static int[] parseIntArr(String json) {
        try {
            return new ObjectMapper().readValue(json, int[].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[][] parse2dIntArr(String json) {
        try {
            return new ObjectMapper().readValue(json, int[][].class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
