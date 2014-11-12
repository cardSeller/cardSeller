/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.card.seller.dao.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 与具体ORM实现无关的分页查询结果封装.
 *
 * @param <T> Page中记录的类型.
 * @author vincent
 */
@SuppressWarnings("serial")
public class Page<T> extends PageRequest implements Serializable {

    protected List<T> result = null;
    protected long totalItems = -1;

    public Page() {
    }

    public Page(PageRequest request) {
        this.pageNo = request.getPageNo();
        this.pageSize = request.getPageSize();
        this.countTotal = request.isCountTotal();
        this.orderBy = request.getOrderBy();
        this.orderDir = request.getOrderDir();
    }

    /**
     * 获得页内的记录列表.
     */
    public List<T> getResult() {
        return result;
    }

    /**
     * 设置页内的记录列表.
     */
    public void setResult(final List<T> result) {
        this.result = result;
    }

    /**
     * 获得总记录数, 默认值为-1.
     */
    public long getTotalItems() {
        return totalItems;
    }

    /**
     * 设置总记录数.
     */
    public void setTotalItems(final long totalItems) {
        this.totalItems = totalItems;
    }

    /**
     * 根据pageSize与totalItems计算总页数.
     */
    public int getTotalPages() {
        return (int) Math.ceil((double) totalItems / (double) getPageSize());

    }

    /**
     * 是否还有下一页.
     */
    public boolean hasNextPage() {
        return (getPageNo() + 1 <= getTotalPages());
    }

    /**
     * 取得下页的页号, 序号从1开始. 当前页为尾页时仍返回尾页序号.
     */
    public int getNextPage() {
        if (hasNextPage()) {
            return getPageNo() + 1;
        } else {
            return getPageNo();
        }
    }

    /**
     * 是否还有上一页.
     */
    public boolean hasPrePage() {
        return (getPageNo() > 1);
    }

    /**
     * 取得上页的页号, 序号从1开始. 当前页为首页时返回首页序号.
     */
    public int getPrePage() {
        if (hasPrePage()) {
            return getPageNo() - 1;
        } else {
            return getPageNo();
        }
    }

    /**
     * 计算以当前页为中心的页面列表,如"首页,23,24,25,26,27,末页"
     *
     * @param count 需要计算的列表大小
     * @return pageNo列表
     */
    public List<Integer> getSlider(int count) {
        int halfSize = count / 2;
        int totalPage = getTotalPages();
        int startPageNo = Math.max(getPageNo() - halfSize, 1);

        int endPageNo = Math.min(startPageNo + count - 1, totalPage);
        if (endPageNo - startPageNo < count) {
            startPageNo = Math.max(endPageNo - count, 1);
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int i = startPageNo; i <= endPageNo; i++) {
            result.add(i);

        }
        return result;
    }

}
