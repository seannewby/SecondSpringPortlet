<%@taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<portlet:defineObjects/>
<h1>Locations</h1>


<table>
<c:forEach items="${locations}" var="location">
	<tr><td>&nbsp;</td><td></td></tr>
	<tr><td>Location: </td><td>${location.name}</td></tr>
	<tr><td>Description: </td><td>${location.desc}</td></tr>

	<tr><td></td><td><a href="<portlet:renderURL>
								<portlet:param name="action" value="detail" />
								<portlet:param name="locationId" value="${location.id}" />
							  </portlet:renderURL>">Details</a></td></tr>	
	<tr><td>&nbsp;</td><td></td></tr>
</c:forEach>
</table>
