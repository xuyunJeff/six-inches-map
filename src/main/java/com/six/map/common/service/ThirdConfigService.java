package com.six.map.common.service;

import java.util.List;

import com.six.map.common.utils.GsonUtil;
import com.six.map.modules.api.football.dao.ThirdConfigMapper;
import com.six.map.modules.api.football.entity.FeiJingSecure;
import com.six.map.common.constant.FeiJinConstant;
import com.six.map.common.exception.RRException;
import org.springframework.stereotype.Service;

import com.six.map.common.entity.ThirdConfigEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * 第三方配置
 *
 * @author Ryan<>
 */
@Service("thridConfigService")
@Slf4j
public class ThirdConfigService extends AutoBaseService<ThirdConfigMapper, ThirdConfigEntity> {

    public FeiJingSecure getFeiJingConfig() {
        ThirdConfigEntity e = new ThirdConfigEntity();
        e.setConfigName(FeiJinConstant.FEI_JIN_CONFIG_NAME);
        e.setThirdName(FeiJinConstant.FEI_JIN_NAME);
        List<ThirdConfigEntity> rs = mapper.select(e);
        if (rs.size() != 1) {
            throw new RRException("请检查飞鲸配置");
        }
        try {
            return GsonUtil.fromJson(rs.get(0).getJsonValue(), FeiJingSecure.class);
        } catch (Exception ex) {
            log.error("请检查飞鲸配置,jsonValue无法被转化 value = {}", rs.get(0).getJsonValue());
            throw new RRException("请检查飞鲸配置,jsonValue无法被转化");
        }
    }
}
