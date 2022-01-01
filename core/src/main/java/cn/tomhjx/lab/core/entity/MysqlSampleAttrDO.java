package cn.tomhjx.lab.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("app_sample_attr")
public class MysqlSampleAttrDO {
    /***
     * 主键ID
     */
    @TableId(type = IdType.INPUT)
    private Long id;
    private Integer level;
    private String createTime;
    private String updateTime;
    private Integer isDeleted;
}
