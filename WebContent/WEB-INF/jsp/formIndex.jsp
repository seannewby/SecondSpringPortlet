<%@taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<portlet:defineObjects/>
<h1>Add/Edit Location</h1>

<c:choose>
	<c:when test="${param.action == 'editLocation'}">
		<portlet:actionURL var="formAction">
		    <portlet:param name="action" value="editLocation"/>
		</portlet:actionURL>	
	</c:when>
	<c:otherwise>
		<portlet:actionURL var="formAction">
		    <portlet:param name="action" value="addLocation"/>
		</portlet:actionURL>	
	</c:otherwise>
</c:choose>


<table>
	<tr>
		<td>
			<form:form commandName="location" method="post" action="${formAction}">
			<form:errors path="*" cssStyle="color:red"/>
			<form:hidden path="id"/>
			<table>
				<tr><td>&nbsp;</td><td></td></tr>
				<tr>
					<td>Location: </td>
					<td>
					<%-- 
						*****************************************************
							path is attributes on command object, in this case, location.name.
						*****************************************************
					--%>		
					<form:input path="name" size="20" maxlength="20"/>	
					</td>
				</tr>
				<tr>
					<td>Description: </td>
					<td>
					<form:input path="desc" size="20" maxlength="20"/>
					</td>
				</tr>	
				<tr>
					<td>Address: </td>
					<td>
					<form:input path="address.address1" size="20" maxlength="20"/>	
					</td>
				</tr>
				<tr>
					<td>City: </td>
					<td>
					<form:input path="address.city" size="20" maxlength="20"/>
					</td>
				</tr>
				<tr>
					<td>State: </td>
					<td>
					<form:select path="address.state" items="${states}"/>
					</td>
				</tr>
				<tr>
					<td>Zip: </td>
					<td>
					<form:input path="address.zip" size="20" maxlength="20"/>
					</td>
				</tr>			
				<tr>
					<td>Manager: </td>
					<td>
					<form:input path="manager" size="20" maxlength="20"/>
					</td>
				</tr>
				<tr>
					<td>Region: </td>
					<td>
					<form:input path="region" size="20" maxlength="20"/>
					</td>
				</tr>
					
				<tr><td colspan="2" align="center" style="padding-top: 20px;"><input class="wpsButtonText" value="Add/Edit Location" type="submit" /></td></tr>
			
			</table>
			</form:form>
		</td>
		<td style="padding-left: 40px;" valign="top">
			<p><strong>Edit current location</strong></p>		
			<c:forEach items="${locations}" var="location">
				<portlet:renderURL var="editLocationUrl">
					<portlet:param name="action" value="editLocation" />
					<portlet:param name="locationId" value="${location.id}" />
			  	</portlet:renderURL>
				<p>${location.name} - <a href="${editLocationUrl}">Edit</a></p>
			</c:forEach>
		</td>
	</tr>
</table>