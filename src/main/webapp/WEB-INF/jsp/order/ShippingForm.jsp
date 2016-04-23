<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog"><stripes:form
	beanclass="org.mybatis.jpetstore.web.actions.OrderActionBean">

	<table>
		<tr>
			<th colspan=2>Shipping Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td><stripes:text name="order.shippingFirstName" /></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><stripes:text name="order.shippingLastName" /></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><stripes:text size="40" name="order.shippingAddress.address1" /></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><stripes:text size="40" name="order.shippingAddress.address2" /></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><stripes:text name="order.shippingAddress.city" /></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><stripes:text size="4" name="order.shippingAddress.state" /></td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td><stripes:text size="10" name="order.shippingAddress.zip" /></td>
		</tr>
		<tr>
			<td>Planet:</td>
			<td><stripes:text size="15" name="order.shippingAddress.country" /></td>
		</tr>


	</table>

	<stripes:submit name="newOrder" value="Continue" />

</stripes:form></div>

<%@ include file="../common/IncludeBottom.jsp"%>