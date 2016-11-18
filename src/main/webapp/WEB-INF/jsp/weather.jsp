<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:import url="/WEB-INF/jsp/header.jsp" />
<section class="weather">
	<div class="todayForecast">
		<h1>Today's Forecast at <c:out value="${today.parkName}" /> </h1>

		<div class="todayDiv">
		<c:choose>
		<c:when test="${today.forecast=='partly cloudy'}">
		<img src="img/weather/partlyCloudy.png" alt="partly Cloudy" id="todaypic"/>
		</c:when>
		<c:otherwise>
			<img src="img/weather/${today.forecast}.png" alt="todayPic" id="todaypic" />
			</c:otherwise>
			</c:choose>
		</div>

		<div class="changeTemp">
		<c:url value="/weather" var="formAction" />
			<form method="POST" action="${formAction}">
				<input type="radio" name="choice" value="false"> °C<br>
				<input type="radio" name="choice" value="true" checked> °F<br>
				<input type="hidden" name="parkCode" value="${today.parkCode}"/>
				<input type="submit" value="Temparature Preference" id="tempPref">
			</form>
		</div>

		<div class="details">
			<c:choose>
				<c:when test="${today.choice=='true'}">
					<p id="dailyHi">High:<c:out value="${today.high}" /></p>
					<p id="dailyLo">Low:<c:out value="${today.low}" /></p>
				</c:when>
				<c:otherwise>
					<p id="dailyHi">High : 
						<fmt:formatNumber var="hiTempC" value="${(today.high-32)/1.8}" maxFractionDigits="0"/>
						<span><c:out value="${hiTempC}" />°</span></p>
					<p id="dailyLo">Low : 
						<fmt:formatNumber var="loTempC" value="${(today.low-32)/1.8}" maxFractionDigits="0"/>
						<c:out value="${loTempC}" />°</p>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${today.forecast == 'cloudy'}">
					<p>Carry umbrella.</p>
				</c:when>

				<c:when test="${today.forecast == 'rain'}">
					<p>Pack rain gear and wear waterproof shoes.</p>
				</c:when>

				<c:when test="${today.forecast == 'snow'}">
					<p>Pack snowshoes.</p>
				</c:when>

				<c:when test="${today.forecast == 'thunderstorms'}">
					<p>Caution:Seek shelter and avoid hiking on exposed ridges.</p>
				</c:when>

				<c:when test="${today.forecast == 'sunny'}">
					<p>Pack sunblock.</p>
				</c:when>

				<c:when test="${today.high >75}">
					<p>Bring an extra gallon of water.</p>
				</c:when>

				<c:when test="${today.high-today.low>20}">
					<p>Wear breathable layers.</p>
				</c:when>
				<c:when test="${today.low<20}">
					<p>Beware of frigid temperatures.</p>
				</c:when>
			</c:choose>
			
		</div>
		
	</div>


	<div class="fiveDaysForecast">
		<c:forEach var="fiveDays" items="${weatherDetail}">
			<div class="fiveDays">
				<ul>
					<li><c:choose>
							<c:when test="${fiveDays.forecast =='snow'}">
								<img src="img/weather/snow.png" id="forecastPic" />
							</c:when>

							<c:when test="${fiveDays.forecast =='partly cloudy'}">
								<img src="img/weather/partlyCloudy.png" id="forecastPic" />
							</c:when>

							<c:when test="${fiveDays.forecast =='cloudy'}">
								<img src="img/weather/cloudy.png" id="forecastPic" />
							</c:when>

							<c:when test="${fiveDays.forecast =='sunny'}">
								<img src="img/weather/sunny.png" id="forecastPic" />
							</c:when>

							<c:when test="${fiveDays.forecast =='rain'}">
								<img src="img/weather/rain.png" id="forecastPic" />
							</c:when>

							<c:when test="${fiveDays.forecast =='thunderstorms'}">
								<img src="img/weather/thunderstorms.png" id="forecastPic" />
							</c:when>
						</c:choose></li>

				<c:choose>
				<c:when test="${fiveDays.choice=='true'}">
					<li class="high">High : <c:out value="${fiveDays.high}" /></li>
					<li class="low">Low : <c:out value="${fiveDays.low}" /></li>
				</c:when>
				<c:otherwise>
					<li class="high">High :
						<fmt:formatNumber var="hiTempC" value="${(today.high-32)/1.8}" maxFractionDigits="0"/>
						<c:out value="${hiTempC}" /></li>
					<li class="low">Low : 
						<fmt:formatNumber var="loTempC" value="${(today.low-32)/1.8}" maxFractionDigits="0"/>
						<c:out value="${loTempC}" /></li>
				</c:otherwise>
				</c:choose>
				
				
				</ul>
			</div>
		</c:forEach>
	</div>
	
</section>
<c:import url="/WEB-INF/jsp/footer.jsp" />