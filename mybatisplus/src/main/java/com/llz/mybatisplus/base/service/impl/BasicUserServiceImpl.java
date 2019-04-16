package com.llz.mybatisplus.base.service.impl;

import com.llz.mybatisplus.base.entity.BasicUser;
import com.llz.mybatisplus.base.mapper.BasicUserMapper;
import com.llz.mybatisplus.base.service.IBasicUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author llz
 * @since 2019-04-16
 */
@Service
public class BasicUserServiceImpl extends ServiceImpl<BasicUserMapper, BasicUser> implements IBasicUserService {

}
