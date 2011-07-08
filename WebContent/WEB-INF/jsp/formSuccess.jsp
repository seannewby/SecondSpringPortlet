<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<portlet:defineObjects/>
<h1>Success</h1>

<p>Location Added</p>

<table>
	<tr><td>&nbsp;</td><td></td></tr>
	<tr><td>Location: </td><td>${location.name}</td></tr>
	<tr><td>Description: </td><td>${location.desc}</td></tr>
	<tr><td>Adddress:</td><td>
	${location.address.address1}<br />
	${location.address.city} ${location.address.state} ${location.address.zip}</td></tr>

	<tr><td>Manager: </td><td>${location.manager}</td></tr>
	<tr><td>Region: </td><td>${location.region}</td></tr>
	

	
	<tr><td>&nbsp;</td><td></td></tr>
</table>

<a href="<portlet:renderURL>
								<portlet:param name="action" value="" />
							  </portlet:renderURL>">back</a>
	

	

