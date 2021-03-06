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
package com.card.seller.dao.hibernate.restriction;

import com.card.seller.dao.hibernate.RestrictionNames;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 * 左模糊约束 ( from object o where o.value like '%?') RestrictionName:LLIKE
 * <p>
 * 表达式:LLIKE属性类型_属性名称[_OR_属性名称...]
 * </p>
 *
 * @author vincent
 */
public class LLikeRestriction extends CriterionSingleValueSupport {

    /*
     * (non-Javadoc)
     * @see org.exitsoft.orm.core.hibernate.CriterionBuilder#getRestrictionName()
     */
    public String getRestrictionName() {
        return RestrictionNames.LLIKE;
    }

    /*
     * (non-Javadoc)
     * @see org.exitsoft.orm.core.hibernate.CriterionBuilder#build(java.lang.String, java.lang.Object)
     */
    public Criterion build(String propertyName, Object value) {

        return Restrictions.like(propertyName, value.toString(), MatchMode.END);
    }

}

