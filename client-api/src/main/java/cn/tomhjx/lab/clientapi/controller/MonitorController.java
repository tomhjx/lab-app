package cn.tomhjx.lab.clientapi.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tomhjx.lab.clientapi.dto.CallDTO;
import cn.tomhjx.lab.clientapi.vo.ProbeVO;
import cn.tomhjx.lab.core.vo.ApiResponseVO;

@RestController
@RequestMapping("/monitor")
public class MonitorController {

    @PostMapping("/json")
    public ApiResponseVO<ProbeVO<CallDTO>> getJsonByPostRequest(@RequestHeader HttpHeaders headers, @Valid @RequestBody CallDTO callDTO) {
        ProbeVO<CallDTO> probeVO = new ProbeVO<CallDTO>();
        probeVO.setRequest(callDTO);
        probeVO.setRequestMethod("POST");
        probeVO.setVersion(headers.getFirst("x-version"));
        return ApiResponseVO.success(probeVO);
    }

}
