<a class="logo left" href="${absoluteContextPath}/home">
	<img id="info-portrait" src="${absoluteContextPath}/img/logo.png"/>
</a>
<p class="user-info">
    <strong>${Session["sv"].user.name}</strong>
</p>
<div class="pull-right">
    <div class="header-control">
        <a data-toggle="modal" data-target="#profile-seeting" href="javascript:;">
            <span class="glyphicon glyphicon-cog"></span>
        </a>
        <a href="${absoluteContextPath}/logout">
            <span class="glyphicon glyphicon-off"></span>
        </a>
	</div>
</div>