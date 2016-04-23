<%@ include file="../common/IncludeTop.jsp"%>

<div id="BackLink"><stripes:link
	beanclass="org.mybatis.jpetstore.web.actions.CatalogActionBean">
	Return to Main Menu
	</stripes:link></div>

<div id="Catalog">Please confirm the information below and then
press continue...

<table>
	<tr>
		<th align="center" colspan="2"><font size="4"><b>Order</b></font>
		<br />
		<font size="3"><b> <fmt:formatDate
			value="${actionBean.order.orderDate}" pattern="yyyy/MM/dd hh:mm:ss" /></b></font>
		</th>
	</tr>

	<tr>
		<th colspan="2">Billing Address</th>
	</tr>
	<tr>
		<td>First name:</td>
		<td><c:out value="${actionBean.order.billingFirstName}" /></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><c:out value="${actionBean.order.billingLastName}" /></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><c:out value="${actionBean.order.billingAddress.address1}" /></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><c:out value="${actionBean.order.billingAddress.address2}" /></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><c:out value="${actionBean.order.billingAddress.city}" /></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><c:out value="${actionBean.order.billingAddress.state}" /></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><c:out value="${actionBean.order.billingAddress.zip}" /></td>
	</tr>
	<tr>
		<td>Planet:</td>
		<td><c:out value="${actionBean.order.billingAddress.country}" /></td>
	</tr>
	<tr>
		<th colspan="2">Shipping Address</th>
	</tr>
	<tr>
		<td>First name:</td>
		<td><c:out value="${actionBean.order.shippingFirstName}" /></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><c:out value="${actionBean.order.shippingLastName}" /></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><c:out value="${actionBean.order.shippingAddress.address1}" /></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><c:out value="${actionBean.order.shippingAddress.address2}" /></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><c:out value="${actionBean.order.shippingAddress.city}" /></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><c:out value="${actionBean.order.shippingAddress.state}" /></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><c:out value="${actionBean.order.shippingAddress.zip}" /></td>
	</tr>
	<tr>
		<td>Planet:</td>
		<td><c:out value="${actionBean.order.shippingAddress.country}" /></td>
	</tr>

</table>

<stripes:link class="Button"
	beanclass="org.mybatis.jpetstore.web.actions.OrderActionBean"
	event="newOrder">
	<stripes:param name="confirmed" value="true" />
Confirm
</stripes:link></div>

<%@ include file="../common/IncludeBottom.jsp"%>





