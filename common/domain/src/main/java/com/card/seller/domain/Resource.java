package com.card.seller.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: minj
 * Date: 13-12-10
 * Time: 上午11:42
 */
@Entity
@Table(name = "resource")
@SequenceGenerator(name = "seq_gen", sequenceName = "seq_resource", allocationSize = 1)
public class Resource extends IdEntity {

    //名称
    private String name;
    //资源类型
    private String type;
    //父类
    private Resource parent;
    //shiro permission 字符串
    private String permission;
    //action url
    private String url;

    //顺序
    private Integer sort;

    //备注
    private String remark;
    //图标
    private String icon;
    //子类
    private List<Resource> children = new ArrayList<Resource>();
    //资源所对应的组集合
    private List<Group> groupsList = new ArrayList<Group>();

    private String typeName;

    private String parentName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    public Resource getParent() {
        return parent;
    }

    /**
     * 获取父类ID
     *
     * @return String
     */
    @Transient
    public Long getParentId() {
        return this.parent == null ? null : parent.getId();
    }

    public void setParent(Resource parent) {
        this.parent = parent;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    public List<Resource> getChildren() {
        return children;
    }

    public void setChildren(List<Resource> children) {
        this.children = children;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "GROUP_RESOURCE", joinColumns = {@JoinColumn(name = "RESOURCE_ID")}, inverseJoinColumns = {@JoinColumn(name = "GROUP_ID")})
    public List<Group> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(List<Group> groupsList) {
        this.groupsList = groupsList;
    }

    @Transient
    public Boolean getLeaf() {
        return this.children != null && this.getChildren().size() > 0;
    }

    @Transient
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Transient
    public String getParentName() {
        if (parentName != null) {
            return parentName;
        } else {
            return this.parent == null ? "" : parent.getName();
        }
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
