package com.card.seller.dao;

import com.card.seller.dao.hibernate.HibernateSupportDao;
import com.card.seller.domain.Group;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 部门数据访问
 * 
 * @author vincent
 *
 */
@Repository
public class GroupDao extends HibernateSupportDao<Group, Long> {

    public List<Group> getUserGroups(Long userId) {
        return findByQuery("select gl from User u left join u.groupsList gl  where u.id=?1", userId);
    }

    public Group getGroupById(Long groupId){
        Map<String ,Object> map = Maps.newHashMap();
        map.put("id",groupId);
        return findUniqueByQuery("from "+ Group.class.getName()+ " where id = :id",map);
    }

    public Group getGroupByName(String name){
        Map<String,Object> map = Maps.newHashMap();
        map.put("name",name);
        return findUniqueByQuery("from "+ Group.class.getName()+" where name = :name",map);
    }

    public List<Group> getDistributorGroups(Long distributorId) {
        return findByQuery("select gl from Distributor d left join d.groupsList gl  where d.id=?1", distributorId);
    }
}
