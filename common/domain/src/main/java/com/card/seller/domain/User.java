package com.card.seller.domain;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: minj
 * Date: 13-12-10
 * Time: 上午10:08
 */
@Entity
@Table(name = "users")
@SequenceGenerator(name = "seq_gen", sequenceName = "seq_users", allocationSize = 1)
@NamedQuery(name = User.UpdatePassword, query = "update User u set u.pwd = ?1 where u.id = ?2")
public class User extends IdEntity {

    /**
     * 更新用户密码NamedQuery
     */
    public static final String UpdatePassword = "updatePassword";
    //登录名
    private String name;
    //昵称
    private String nickname;
    //密码
    private String pwd;
    //状态
    private Integer status;
    //邮箱
    private String email;
    //用户所在组
    private List<Group> groupsList = new ArrayList<Group>();
    //创建时间
    private Date createTime;
    //最后登录时间
    private Date lastLoginTime;
    //salt
    private String salt;
    private String groupNames;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_GROUP", joinColumns = {@JoinColumn(name = "USER_ID")}, inverseJoinColumns = {@JoinColumn(name = "GROUP_ID")})
    public List<Group> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(List<Group> groupsList) {
        this.groupsList = groupsList;
    }

    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "last_login_time")
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Transient
    public String getGroupNames() {
        if (StringUtils.isNotEmpty(groupNames)) {
            return groupNames;
        } else {
            return CollectionUtils.extractToString(this.groupsList, "name", ",");
        }
    }

    public void setGroupNames(String groupNames) {
        this.groupNames = groupNames;
    }
}
