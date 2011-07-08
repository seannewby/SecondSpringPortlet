<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<portlet:defineObjects/>
<h1>Add User</h1>
<h2>Contact Info - Step 2 of 3</h2>
<portlet:actionURL var="actionUrl">
</portlet:actionURL>

<form:form action="${actionUrl}" commandName="user" method="post">
<input type="hidden" name="currentPage" value="${page}" />

<table>
	<tr><td>&nbsp;</td><td></td></tr>
	<tr>
		<td>Phone: </td>
		<td>
			<form:input path="phone"/> <span class="generalErrorText"><form:errors path="phone" /></span>
		</td>
	</tr>	
	<tr>
		<td>Fax: </td>
		<td>
			<form:input path="fax"/> <span class="generalErrorText"><form:errors path="fax" /></span>
		</td>
	</tr>
	<tr>
		<td>Email: </td>
		<td>
			<form:input path="email"/> <span class="generalErrorText"><form:errors path="email" /></span>
		</td>
	</tr>	
	<tr>
		<td>Address: </td>
		<td>
			<form:input path="address.address1"/> <span class="generalErrorText"><form:errors path="address.address1" /></span>
		</td>
	</tr>
	<tr>
		<td>City: </td>
		<td>
			<form:input path="address.city"/> <span class="generalErrorText"><form:errors path="address.city" /></span>
		</td>
	</tr>
	<tr>
		<td>State: </td>
		<td>
			<form:select path="address.state">
				<form:option value="">--Please Select--</form:option>
				<form:options items="${states}" />
			</form:select>
		
			<span class="generalErrorText"><form:errors path="address.state" /></span>
		
		</td>
	</tr>
	<tr>
		<td>Zip: </td>
		<td>
			<form:input path="address.zip"/> <span class="generalErrorText"><form:errors path="address.zip" /></span>
		</td>
	</tr>

		
	<tr><td colspan="2" align="center" style="padding-top: 20px;"><input class="wpsButtonText" name="previous" value="Previous" type="submit" />&nbsp;&nbsp;&nbsp;<input class="wpsButtonText" name="next" value="Next" type="submit" /></td></tr>

</table>
</form:form>
