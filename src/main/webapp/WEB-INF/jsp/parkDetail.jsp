<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<c:import url="/WEB-INF/jsp/header.jsp" />

<section class="parkDetail">

	<div class="detailBox">
		<div class="detailTop">
			<p class="parkName"><c:out value="${park.parkName}"/></p>
			<p class="quote"> "<c:out value="${park.inspirationalQuote}"/>"</p>
			<p class="quoteBy">By <c:out value="${park.inspirationalQuoteSource}"/></p>
		</div>
		<div class="imgDetail">
			<img src="img/parks/${fn:toLowerCase(park.parkCode)}.jpg" alt="parkImage" class="parkDetailImg"/>
		</div>
	
		<div>
			<p id="detailDescription"><c:out value="${park.parkDescription}"/></p>
		
			<ul class="detailList">
				<li><span>Year Founded: </span><c:out value="${park.yearFounded}"/></li>
				<li><span>Area: </span><c:out value="${park.acreage}"/> acres</li>
				<li><span>Elevation: </span><c:out value="${park.elevationInFeet}"/> feet</li>
				<li><span>Trail distance: </span><c:out value="${park.milesOfTrail}"/> miles</li>
				<li><span>Number Of Campsites: </span><c:out value="${park.numberOfCampsites}"/></li>
				<li><span>Climate: </span><c:out value="${park.climate}"/></li>
				<li><span>Visitors Count In A Year: </span><c:out value="${park.annualVisitorCount}"/> visitors</li>
				<li><span>Entry Fee: </span>$<c:out value="${park.entryFee}"/></li>
				<li><span>Number Of Animal Species: </span><c:out value="${park.numberOfAnimalSpecies}"/> species</li>
				<li></li>
			</ul>
		</div>
		<div class="forecastLink">
			<c:url value="/weather" var="weatherURL">	
			<c:param name="parkCode" value="${park.parkCode}" />	
			</c:url>	
			
			<p id="forecast"><a href="${weatherURL}">VIEW 5 DAYS FORECAST!!!</a></p>
		</div>
	</div>

</section>
<c:import url="/WEB-INF/jsp/footer.jsp" />