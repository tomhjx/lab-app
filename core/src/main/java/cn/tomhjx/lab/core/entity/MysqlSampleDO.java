package cn.tomhjx.lab.core.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("app_sample")
public class MysqlSampleDO {
    /***
     * 主键ID
     */
    @TableId
    private Long id;
    
    private String title;
    private String summary;

    private String createTime;

    private String updateTime;
    private Integer isDeleted;
}
