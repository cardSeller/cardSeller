package com.card.seller.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: minj
 * Date: 13-12-10
 * Time: 上午10:47
 */
@Entity
@Table(name = "groups")
@SequenceGenerator(name = "seq_gen", sequenceName = "seq_groups", allocationSize = 1)
public class Group extends IdEntity {

    private String name;
    //成员
    private List<User> membersList = new ArrayList<User>();
    //上级组
    private Group parent;
    //下级组集合
    private List<Group> children = new ArrayList<Group>();
    //备注
    private String remark;
    //拥有资源
    private List<Resource> resourcesList = new ArrayList<Resource>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_GROUP", joinColumns = {@JoinColumn(name = "GROUP_ID")}, inverseJoinColumns = {@JoinColumn(name = "USER_ID")})
    public List<User> getMembersList() {
        return membersList;
    }

    public void setMembersList(List<User> membersList) {
        this.membersList = membersList;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    public Group getParent() {
        return parent;
    }

    public void setParent(Group parent) {
        this.parent = parent;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = {CascadeType.ALL})
    public List<Group> getChildren() {
        return children;
    }

    public void setChildren(List<Group> children) {
        this.children = children;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "GROUP_RESOURCE", joinColumns = {@JoinColumn(name = "GROUP_ID")}, inverseJoinColumns = {@JoinColumn(name = "RESOURCE_ID")})
    public List<Resource> getResourcesList() {
        return resourcesList;
    }

    public void setResourcesList(List<Resource> resourcesList) {
        this.resourcesList = resourcesList;
    }
}
