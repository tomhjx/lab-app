package cn.tomhjx.lab.core.vo;

import lombok.Data;

@Data
public class ApiResponseVO<T> {
    private T data;
    private Integer code;
    private String message;
    private String traceId = "";
    public ApiResponseVO(T data, Integer code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }
    public static <T> ApiResponseVO<T> success(T data) {
        return new ApiResponseVO<T>(data, 0, "");
    }    
    public static <T> ApiResponseVO<T> success(T data, String message) {
        return new ApiResponseVO<T>(data, 0, message);
    }

}
