<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<portlet:defineObjects/>
<h1>Add User</h1>
<h2>Billing Info - Step 3 of 3</h2>
<portlet:actionURL var="actionUrl">
</portlet:actionURL>

<form:form action="${actionUrl}" commandName="user" method="post">
<input type="hidden" name="currentPage" value="${page}" />

<table>
	<tr><td>&nbsp;</td><td></td></tr>
	<tr>
		<td>Credit Card Number: </td>
		<td>
			<form:input path="creditCardNum"/> <span class="generalErrorText"><form:errors path="creditCardNum" /></span>		
		</td>
	</tr>
	<tr>
		<td>Credit Card Expiration Date: </td>
		<td>
			<form:input path="creditCardExp"/> <span class="generalErrorText"><form:errors path="creditCardExp" /></span>			
		</td>
	</tr>	
	<tr>
		<td>Credit Card Security Number: </td>
		<td>
			<form:input path="creditCardSecurityNum"/> <span class="generalErrorText"><form:errors path="creditCardSecurityNum" /></span>
		</td>
	</tr>
		
	<tr><td colspan="2" align="center" style="padding-top: 20px;"><input class="wpsButtonText" name="previous" value="Previous" type="submit" />&nbsp;&nbsp;&nbsp;<input class="wpsButtonText" name="finish" value="Finish" type="submit" />&nbsp;&nbsp;&nbsp;<input class="wpsButtonText" name="cancel" value="Cancel" type="submit" /></td></tr>

</table>
</form:form>
