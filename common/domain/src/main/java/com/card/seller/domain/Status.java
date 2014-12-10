package com.card.seller.domain;

/**
 * 状态枚举
 *
 * @author vincent
 */
public enum Status {

    /**
     * 启用
     */
    Enable(1, "启用"),
    /**
     * 禁用
     */
    Disable(2, "禁用"),
    /**
     * 删除
     */
    Delete(3, "删除");

    //值
    private Integer value;
    //名称
    private String name;

    private Status(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * 获取值
     *
     * @return Integer
     */
    public Integer getValue() {
        return value;
    }

    /**
     * 获取名称
     *
     * @return String
     */
    public String getName() {
        return name;
    }

}
