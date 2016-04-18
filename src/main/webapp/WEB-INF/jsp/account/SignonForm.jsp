<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog"><stripes:form
	beanclass="org.mybatis.jpetstore.web.actions.AccountActionBean"
	focus="">

	<p>Please enter your username and password.</p>
	<p>Username:<stripes:text name="username" value="pfry" /> <br />
	Password:<stripes:password name="password" value="slurm" /></p>
	<stripes:submit name="signon" value="Login" />

</stripes:form> Need a user name and password? <stripes:link
	beanclass="org.mybatis.jpetstore.web.actions.AccountActionBean"
	event="newAccountForm">Register Now!</stripes:link></div>

<%@ include file="../common/IncludeBottom.jsp"%>

