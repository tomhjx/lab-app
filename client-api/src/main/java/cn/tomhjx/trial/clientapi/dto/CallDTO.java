package cn.tomhjx.trial.clientapi.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CallDTO {
    @NotBlank(message = "p1 must not be null or ''")
    private String p1;
    private Integer p2;
    private Long p3;
}
