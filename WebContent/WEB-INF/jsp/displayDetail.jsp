<%@taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<portlet:defineObjects/>
<h1>Location Details</h1>


<table>
	<tr><td>&nbsp;</td><td></td></tr>
	<tr><td>Location: </td><td>${location.name}</td></tr>
	<tr><td>Description: </td><td>${location.desc}</td></tr>
	<tr><td>Address:</td><td>
	${location.address.address1}<br />
	${location.address.city} ${location.address.state} ${location.address.zip}</td></tr>

	<tr><td>Manager: </td><td>${location.manager}</td></tr>
	<tr><td>Region: </td><td>${location.region}</td></tr>
	

	<tr><td></td><td><a href="<portlet:renderURL>
							  </portlet:renderURL>">Return to List</a></td></tr>
	

	
	<tr><td>&nbsp;</td><td></td></tr>
</table>
