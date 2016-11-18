<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Park Weather Service</title>
    <c:url value="/css/nationalParkWeatherService.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
	<header>
		<div>
			<c:url value="/" var="homePageHref" />
			<c:url value="img/logo.png" var="logoSrc" />
		<a href="${homePageHref}" >
			<img src="${logoSrc}"  alt="National Park logo" class="logoImg"/>
		</a>
		
		<div>
			<c:url value="/surveyInput" var="surveyHref" />
			<c:url value="/img/weather/SurveyButton.gif" var="surveyButton" />
			<a href="${surveyHref}"><img src="${surveyButton}" alt="surveyButton" class="surveyButton"></a>
		</div>
		<div>
			<c:url value="/surveyResult" var="resultHref" />
			<c:url value="/img/weather/topThree.png" var="topThreePark" />
			<a href="${resultHref}"><img src="${topThreePark}" alt="topThreePark" class="topThreePark"></a>
		</div>
		</div>
	</header>
