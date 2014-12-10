<@shiro.user>
	<#include "profile-setting.ftl" />
</@shiro.user>

<header class="navbar-inverse navbar-fixed-top">
<@shiro.user>
    <#include "info.ftl" />
</@shiro.user>
</header>
<div class="main-container" xmlns:sitemesh="">
    <div class="border-black">
        <div class="content-container wrap">
            <div class="content-widget clearfix" id="content-widget">
            <@shiro.user>
                <#include "navbar.ftl" />
            </@shiro.user>
            <div class="col-lg-10 right-container">
                <sitemesh:write property="body"/>
			</div>
            </div>
        </div>
    </div>
</div>