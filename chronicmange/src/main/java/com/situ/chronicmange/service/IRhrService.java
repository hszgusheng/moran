package com.situ.chronicmange.service;

import com.situ.chronicmange.entity.Rhr;
import com.baomidou.mybatisplus.extension.service.IService;
import com.situ.chronicmange.entity.User;

/**
 * <p>
 * 档案表 服务类
 * </p>
 *
 * @author admin
 * @since 2023-06-12
 */
public interface IRhrService extends IService<Rhr> {
    Rhr select(Rhr rhr) throws Exception;
    void modifiedPwdRhr(Rhr rhr) throws Exception;
    void add(Rhr rhr) throws Exception;
}
