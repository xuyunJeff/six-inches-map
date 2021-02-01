package com.six.map.inch.service;

import com.six.map.common.constant.MsgConstant;
import com.six.map.common.entity.Page;
import com.six.map.common.entity.Query;
import com.six.map.common.entity.R;
import com.six.map.common.service.AutoBaseService;
import com.six.map.common.utils.CommonUtils;
import com.six.map.inch.dao.DtAppVersionMapper;
import com.six.map.inch.entity.DtAppVersionEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ryan<>
 */
@Service("dtAppVersionService")
@Slf4j
public class DtAppVersionService extends AutoBaseService<DtAppVersionMapper, DtAppVersionEntity> {

    @Autowired
    private DtAppVersionMapper mapper;

    public R getLastestVersion() {
        DtAppVersionEntity dto = mapper.getLastestVersion();
        R ok = R.ok(MsgConstant.MSG_OPERATION_SUCCESS);
        ok.put("data", dto);
        return ok;

    }
}
