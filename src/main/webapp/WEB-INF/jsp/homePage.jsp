<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<c:import url="/WEB-INF/jsp/header.jsp" />

<section class="homePage">
	<div class="content">

		<c:forEach var="parks" items="${parkList}"> 
		<div class="parkdiv">
				<c:url value="/parkDetail" var="detailURL">
					<c:param name="parkCode" value="${parks.parkCode}" />
				</c:url>
				<a href="${detailURL}"><span class="parkName"><c:out value="${parks.parkName}" /></span></a>
				<p id="stateHomePage"><c:out value="${parks.state}"/>
				
				<div class="parkImg">
					<c:url value="/parkDetail" var="detailURL">
					<c:param name="parkCode" value="${parks.parkCode}" />
					</c:url>
					
					<a href="${detailURL}"><img src="img/parks/${fn:toLowerCase(parks.parkCode)}.jpg" alt="parkImage"  id="parkImage"/></a>
				</div>
	
				<div class="detail">
						<p id="discription"><c:out value="${parks.parkDescription}" /></p>
				</div>
		</div>
		
	</c:forEach>
</div>
</section>
<c:import url="/WEB-INF/jsp/footer.jsp" />