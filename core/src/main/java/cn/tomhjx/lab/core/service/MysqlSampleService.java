package cn.tomhjx.lab.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.tomhjx.lab.core.entity.MysqlSampleAttrDO;
import cn.tomhjx.lab.core.entity.MysqlSampleDO;
import cn.tomhjx.lab.core.mapper.MysqlSampleAttrMapper;
import cn.tomhjx.lab.core.mapper.MysqlSampleMapper;

@Service
public class MysqlSampleService {

    @Autowired
    private MysqlSampleMapper mysqlSampleMapper;
    @Autowired
    private MysqlSampleAttrMapper mysqlSampleAttrMapper;

    @Autowired
    private UtilService utilService;

    @Transactional(rollbackFor = Exception.class, readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public MysqlSampleDO createRecordWithTransaction() {
        // MysqlSampleDO
        MysqlSampleDO sampleDO = new MysqlSampleDO();
        sampleDO.setTitle("Sample "+utilService.getCurTime());
        sampleDO.setSummary("this is a lab app action at "+utilService.getCurTime());
        mysqlSampleMapper.insert(sampleDO);

        System.out.println(sampleDO.getId());

        MysqlSampleAttrDO sampleAttrDO = new MysqlSampleAttrDO();
        sampleAttrDO.setId(sampleDO.getId());
        sampleAttrDO.setLevel(1);
        mysqlSampleAttrMapper.insert(sampleAttrDO);

        return sampleDO;
    }

    public void general(MysqlSampleDO sampleDO) {
        // create
        // MysqlSampleDO sampleDO = createRecord();

        // select
        MysqlSampleDO rSampleDO = mysqlSampleMapper.selectById(sampleDO.getId());
        System.out.println(rSampleDO.getTitle());
        System.out.println(rSampleDO.getCreateTime());
        System.out.println(rSampleDO.getUpdateTime());
        
        // update
        MysqlSampleDO changedSampleDO = new MysqlSampleDO();
        changedSampleDO.setId(sampleDO.getId());
        changedSampleDO.setSummary("update at "+utilService.getCurTime());
        mysqlSampleMapper.updateById(changedSampleDO);

        // delete
        mysqlSampleMapper.deleteById(sampleDO.getId());

    }
}
