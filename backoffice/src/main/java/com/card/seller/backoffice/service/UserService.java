package com.card.seller.backoffice.service;

import com.card.seller.backoffice.exception.ServiceException;
import com.card.seller.dao.UserDao;
import com.card.seller.dao.GroupDao;
import com.card.seller.dao.ResourceDao;
import com.card.seller.dao.hibernate.RestrictionNames;
import com.card.seller.domain.*;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.ByteSource;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * User: minj
 * Date: 13-12-10
 * Time: 下午5:11
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private GenerateService generateService;
    /**
     * 通过用户名获取用户实体
     *
     * @param username 用户实体
     *
     * @return {@link com.card.seller.domain.User}
     */
    @Transactional
    public User getUserByUsername(String username) {
        User user = userDao.findUniqueByCriterion(new Criterion[]{
                Restrictions.eq("name", username),
        });
        return user;
    }

    @Transactional
    public List<Group> getAllGroups() {
        return groupDao.getAll();
    }

    /**
     * 通过用户id获取该用户下的所有资源
     *
     * @param userId 用户id
     *
     * @return List
     */
    @Transactional
    public List<Resource> getUserResources(Long userId) {
        return resourceDao.getUserResources(userId);
    }

    /**
     * 通过用户id获取用户所有分组
     *
     * @param userId 用户id
     *
     * @return List
     */
    @Transactional
    public List<Group> getUserGroups(Long userId) {
        return groupDao.getUserGroups(userId);
    }

    /**
     * 并合子类资源到父类中，返回一个新的资源集合
     *
     * @param list 资源集合
     * @param ignoreType 不需要并合的资源类型
     */
    @Transactional
    public List<Resource> mergeResourcesToParent(List<Resource> list,ResourceType ignoreType) {
        List<Resource> result = new ArrayList<Resource>();

        for (Resource r : list) {
            if(r != null) {
                if (r.getParent() == null && !StringUtils.equals(ignoreType.getValue(),r.getType())) {
                    mergeResourcesToParent(list,r,ignoreType);
                    result.add(r);
                }
            }
        }

        return result;
    }

    /**
     * 遍历list中的数据,如果数据的父类与parent相等，将数据加入到parent的children中
     *
     * @param list 资源集合
     * @param parent 父类对象
     * @param ignoreType 不需要加入到parent的资源类型
     */
    @Transactional
    private void mergeResourcesToParent(List<Resource> list, Resource parent,ResourceType ignoreType) {
        if (!parent.getLeaf()) {
            return ;
        }
        parent.setChildren(new ArrayList<Resource>());
        for (Resource r: list) {
            if(r != null) {
                //这是一个递归过程，如果当前遍历的r资源的parentId等于parent父类对象的id，将会在次递归r对象。通过遍历list是否也存在r对象的子级。
                if (!StringUtils.equals(r.getType(), ignoreType.getValue()) && r.getParentId() != null && parent.getId() != null && r.getParentId().equals(parent.getId()) ) {
                    r.setChildren(null);
                    mergeResourcesToParent(list,r,ignoreType);
                    parent.getChildren().add(r);
                }
            }

        }
    }

	/**
	 * 更新当前用户密码
	 *
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 *
	 */
	@Transactional
	public void updateUserPassword(String oldPassword, String newPassword) {
		User user = SystemVariableUtils.getSessionVariable().getUser();
		ByteSource bytes = ByteSource.Util.bytes(Base64.decode(user.getSalt()));
		oldPassword = new Sha256Hash(oldPassword, bytes, 1024).toBase64();
		if (!user.getPwd().equals(oldPassword)) {
			throw new ServiceException("旧密码不正确.");
		}

		newPassword = new Sha256Hash(newPassword, bytes, 1024).toBase64();
		user.setPwd(newPassword);
		userDao.updatePassword(user.getId(),newPassword);
	}

    @Transactional
    public void updateUser(User entity) {
        userDao.update(entity);
    }

    @Transactional
    public List<Resource> getAllResources(Long... ignoreIdValue) {
        if(ArrayUtils.isNotEmpty(ignoreIdValue)) {
            return resourceDao.findByProperty("id", ignoreIdValue, RestrictionNames.NIN);
        }
        return resourceDao.getAll();
    }
}
