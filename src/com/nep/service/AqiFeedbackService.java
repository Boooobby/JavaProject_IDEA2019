package com.nep.service;

import com.nep.entity.AqiFeedback;

public interface AqiFeedbackService {

    /**
     * 添加反馈信息
     * @param afb
     */
    public void saveFeedBack(AqiFeedback afb);

    /**
     * 指派网格员,修改反馈信息中网格员和状态
     * @param afId
     * @param realName
     */
    public void assignGridMember(String afId,String realName);

    /**
     * 提交实测AQI数据
     * @param afb
     */
    public void confirmData(AqiFeedback afb);
}
