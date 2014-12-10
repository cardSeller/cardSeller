<nav class="nav col-lg-2 left-menu" role="navigation" id="navigation">
    <dl>
        <dt>
            <a href="${absoluteContextPath}/home">
                <span class="glyphicon glyphicon-home"></span>
                <span class="nav-title">首 页</span>
            </a>
        </dt>
    <#list Session["sv"].menusList as m>
        <dt>
            <a id="${m.id?c}" href="javascript:;">
                <span class="glyphicon ${m.icon!}"></span>
                <span class="nav-title">${m.name!}</span>
				<span class="glyphicon navbar-right glyphicon-chevron-right"></span>
            </a>
        </dt>
        <dd>
            <#if m.children?size gt 0>
                <ul class="nav">
                    <#list m.children as c>
                        <li id="tab_${c.id?c}">
                            <a id="${c.id?c}" href="${absoluteContextPath}/<#if c.url?exists&&c.url?length gt 0>${c.url?substring(1,c.url?length - 3)}</#if>">
                                <span class="glyphicon ${c.icon!}"></span> ${c.name!}
                            </a>
                        </li>
                    </#list>
                </ul>
            </#if>
        </dd>
    </#list>
    </dl>
</nav>