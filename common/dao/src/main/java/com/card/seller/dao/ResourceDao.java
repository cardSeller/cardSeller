package com.card.seller.dao;

import com.card.seller.dao.hibernate.HibernateSupportDao;
import com.card.seller.domain.Resource;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 资源数据访问
 * 
 * @author vincent
 *
 */
@Repository
public class ResourceDao extends HibernateSupportDao<Resource, Long> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceDao.class);

	/**
	 * 通过用户id获取用户所有资源
	 * 
	 * @param userId 用户id
	 * 
	 * @return List
	 */
	public List<Resource> getUserResources(Long userId) {
		return distinct("select rl from User u left join u.groupsList gl left join gl.resourcesList rl where u.id=?1 order by sort", userId);
	}

    @Transactional
    public Long getTotal() {
        return countHqlResult("select id from " + Resource.class.getName());
    }

    public Resource getResourceByName(String name){
        Map<String,Object> map = Maps.newHashMap();
        map.put("name", name);
        return findUniqueByQuery("from " + Resource.class.getName() + " where name = :name", map);
    }

    public List<Resource> getResources(String queryString, Map<String,Object> params, int offset, int fetchSize) {
        StringBuilder builder = new StringBuilder();
        StringBuilder builderJoin = new StringBuilder();
        builder.append("select r from " + Resource.class.getName() + " as r");
        builderJoin.append(" where 1=1");
        builder.append(builderJoin).append(queryString);
        LOGGER.debug("the request string is::{}.", builder.toString());
        return  findByQuery(builder.toString(), params, offset, fetchSize);
    }

    public Long getResourcesCount(String queryString, Map<String, Object> params) {
        StringBuilder builder = new StringBuilder();
        StringBuilder builderJoin = new StringBuilder();
        builder.append("select r from " + Resource.class.getName() + " as r");
        builderJoin.append(" where 1=1");
        builder.append(builderJoin).append(queryString);
        LOGGER.debug("the request string is::{}.", builder.toString());
        return  Long.valueOf(findByQuery(builder.toString(), params).size());
    }

    public List<Resource> getDistributorResources(Long distributorId) {
        return distinct("select rl from Distributor d left join d.groupsList gl left join gl.resourcesList rl where d.id=?1 order by sort", distributorId);
    }
}
