<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog"><stripes:form
	beanclass="org.mybatis.jpetstore.web.actions.OrderActionBean">

	<table>
		<tr>
			<th colspan=2>Payment Details</th>
		</tr>
		<tr>
			<td>Card Type:</td>
			<td><stripes:select name="order.cardType">
				<stripes:options-collection
					collection="${actionBean.creditCardTypes}" />
			</stripes:select></td>
		</tr>
		<tr>
			<td>Card Number:</td>
			<td><stripes:text name="order.creditCard" /> * Use a fake
			number!</td>
		</tr>
		<tr>
			<td>Expiry Date (MM/YYYY):</td>
			<td><stripes:text name="order.expiryDate" /></td>
		</tr>
		<tr>
			<th colspan=2>Billing Address</th>
		</tr>

		<tr>
			<td>First name:</td>
			<td><stripes:text name="order.billingFirstName" /></td>
		</tr>
		<tr>
			<td>Last name:</td>
			<td><stripes:text name="order.billingLastName" /></td>
		</tr>
		<tr>
			<td>Address 1:</td>
			<td><stripes:text size="40" name="order.billingAddress.address1" /></td>
		</tr>
		<tr>
			<td>Address 2:</td>
			<td><stripes:text size="40" name="order.billingAddress.address2" /></td>
		</tr>
		<tr>
			<td>City:</td>
			<td><stripes:text name="order.billingAddress.city" /></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><stripes:text size="4" name="order.billingAddress.state" /></td>
		</tr>
		<tr>
			<td>Zip:</td>
			<td><stripes:text size="10" name="order.billingAddress.zip" /></td>
		</tr>
		<tr>
			<td>Planet:</td>
			<td><stripes:text size="15" name="order.billingAddress.country" /></td>
		</tr>

		<tr>
			<td colspan=2><stripes:checkbox name="shippingAddressRequired" />
			Ship to different address...</td>
		</tr>

	</table>

	<stripes:submit name="newOrder" value="Continue" />

</stripes:form></div>

<%@ include file="../common/IncludeBottom.jsp"%>