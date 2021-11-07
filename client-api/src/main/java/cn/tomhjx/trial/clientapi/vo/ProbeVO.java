package cn.tomhjx.trial.clientapi.vo;

import lombok.Data;

@Data
public class ProbeVO<T> {
    private T request;
    private String version;
    private String requestMethod;

}
