package com.situ.chronicmange.service.impl;

import com.situ.chronicmange.entity.Rhr;
import com.situ.chronicmange.entity.User;
import com.situ.chronicmange.mapper.RhrMapper;
import com.situ.chronicmange.service.IRhrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 档案表 服务实现类
 * </p>
 *
 * @author admin
 * @since 2023-06-12
 */
@Service
public class RhrServiceImpl extends ServiceImpl<RhrMapper, Rhr> implements IRhrService {

    @Autowired
    private RhrMapper rhrMapper;


    @Override
    public Rhr select(Rhr rhr) throws Exception {
        String name=rhr.getName();
        Rhr sRhr=rhrMapper.selectUserByName(name);

        return sRhr;
    }

    @Override
    public void modifiedPwdRhr(Rhr rhr) throws Exception {

    }

    @Override
    public void add(Rhr rhr) throws Exception {
        if(rhr.getName()==null||"".equals(rhr.getName()))
        {
            throw new Exception("患者姓名为空");
        }
        if(rhr.getAge()==null||"".equals(rhr.getAge()))
        {
            throw new Exception("患者年龄为空");

        }
        if(rhr.getAge()==null||"".equals(rhr.getAge()))
        {
            throw new Exception("患者年龄为空");
        }
        if(rhr.getDiseaseHis()==null||"".equals(rhr.getDiseaseHis()))
        {
            throw new Exception("患者所患疾病为空");
        }
        if(rhr.getCreateTime()==null||"".equals(rhr.getCreateTime()))
        {
            throw new Exception("患者就诊时间为空");
        }
        rhrMapper.insert(rhr);
    }
}
