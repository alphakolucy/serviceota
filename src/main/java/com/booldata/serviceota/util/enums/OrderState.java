package com.booldata.serviceota.util.enums;

import com.booldata.serviceota.util.enums.tools.EmptyUtil;

/**
 * 订单处理
 * 
 * @date 2019/04/24 15:30
 */
public enum OrderState {
    //未处理  已处理  已完成  已取消
    NONE(40010, "未处理"), 
    HANDLE(40020, "已处理"), 
    DONE(40030, "已完成"),  
    CANCEL(-10000,"已取消");

    private Integer value;
    private String txt;

    OrderState(Integer v, String txt) {
        this.value = v;
        this.txt = txt;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getTxt() {
        return this.txt;
    }

    public static String getTxtByValue(Integer value) {
        for (OrderState state : values()) {
            if (state.getValue().equals(value)) {
                return state.getTxt();
            }
        }
        return "";
    }

    /**
     * value是否存在此枚举中
     *
     * @param value 枚举value值
     * @return boolean
     */
    public static boolean isExist(Integer value) {
        if (EmptyUtil.isEmpty(value)) {
            return false;
        }
        for (OrderState e : OrderState.values()) {
            if (e.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }
}