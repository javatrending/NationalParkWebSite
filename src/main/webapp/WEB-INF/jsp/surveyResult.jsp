<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<c:import url="/WEB-INF/jsp/header.jsp" />
<section>
	<div>
		
		<div class="survey">
			<c:forEach var="surveyResult" items="${surveyList}">
			
			<c:url value="/parkDetail" var="detailURL">
				<c:param name="parkCode" value="${surveyResult.parkCode}" />
			</c:url>
					<a href="${detailURL}"><img src="img/parks/${fn:toLowerCase(surveyResult.parkCode)}.jpg" alt="parkImage"  id=""/></a>
					
			<div id="parkName"><c:out value="${surveyResult.parkName}" /></div>
			
			</c:forEach>
		
		</div>
	</div>
</section>
<c:import url="/WEB-INF/jsp/footer.jsp" />