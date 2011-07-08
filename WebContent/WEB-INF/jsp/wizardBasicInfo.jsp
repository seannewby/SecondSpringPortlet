<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<portlet:defineObjects/>
<h1>Add User</h1>
<h2>Basic Info - Step 1 of 3</h2>
<portlet:actionURL var="actionUrl">
</portlet:actionURL>

<form:form action="${actionUrl}" commandName="user" method="post">


<input type="hidden" name="currentPage" value="${page}" />

<table>
	<tr><td>&nbsp;</td><td></td></tr>
	<tr>
		<td>User Id: </td>
		<td>
			<form:input path="username"/> <span class="generalErrorText"><form:errors path="username" /></span>	
		</td>
	</tr>
	<tr>
		<td>First Name: </td>
		<td>
			<form:input path="firstname"/> <span class="generalErrorText"><form:errors path="firstname" /></span>	
		</td>
	</tr>	
	<tr>
		<td>Last Name: </td>
		<td>
			<form:input path="lastname"/> <span class="generalErrorText"><form:errors path="lastname" /></span>
		</td>
	</tr>
	<tr>
		<td>Birthdate: </td>
		<td>
			<form:input path="birthdate"/> <span class="generalErrorText"><form:errors path="birthdate" /></span>
		</td>
	</tr>	
	<tr>
		<td>Password: </td>
		<td>
			<form:input path="password"/> <span class="generalErrorText"><form:errors path="password" /></span>
		</td>
	</tr>

	<tr><td colspan="2" align="center" style="padding-top: 20px;"><input class="wpsButtonText" name="next" value="Next" type="submit" /></td></tr>

</table>
</form:form>
