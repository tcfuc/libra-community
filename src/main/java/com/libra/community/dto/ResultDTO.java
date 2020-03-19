package com.libra.community.dto;

import com.libra.community.exception.CustomizeErrorCode;
import com.libra.community.exception.CustomizeException;
import lombok.Data;

/**
 * @author zhou
 * @date 2020/2/26
 * @time 15:30
 */
@Data
public class ResultDTO<T> {
    private Integer code;
    private String message;
    private T data;

    public static ResultDTO successOf(){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        return resultDTO;
    }

    public static <T> ResultDTO successOf(T t){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        resultDTO.setData(t);
        return resultDTO;
    }

    public static ResultDTO errorOf(Integer code, String message){
        ResultDTO resultDTO = new ResultDTO();
            resultDTO.setCode(code);
            resultDTO.setMessage(message);
            return resultDTO;
        }

    public static ResultDTO errorOf(CustomizeErrorCode errorCode){
        return errorOf(errorCode.getCode(), errorCode.getMessage());
    }

    public static ResultDTO errorOf(CustomizeException e){
        return errorOf(e.getCode(), e.getMessage());
    }
}
