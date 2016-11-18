<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<c:import url="/WEB-INF/jsp/header.jsp" />
<section>
	<div class="inputSurvey">
		
		<div>
		<p><strong>Which park do you like the most?</strong></p>
		<c:url value="/surveyInput" var="formAction" />
			<form method="POST" action="${formAction}">
				<input type="radio" name="parkCode" value="CVNP">Cuyahoga Valley National Park<br>
				<input type="radio" name="parkCode" value="ENP">Everglades National Park<br>
				<input type="radio" name="parkCode" value="GCNP">Grand Canyon National Park<br>
				<input type="radio" name="parkCode" value="GNP">Glacier National Park<br>
				<input type="radio" name="parkCode" value="GSMNP">Great Smoky Mountains National Park<br>
				<input type="radio" name="parkCode" value="GTNP">Grand Teton National Park<br>
				<input type="radio" name="parkCode" value="MRNP">Mount Rainier National Park<br>
				<input type="radio" name="parkCode" value="RMNP">Rocky Mountain National Park<br>
				<input type="radio" name="parkCode" value="YNP">Yellowstone National Park<br>
				<input type="radio" name="parkCode" value="YNP2">Yosemite National Park<br>
				<br>
				E-mail address: <input type="email" name="emailAddress" ><br>
				
				<div class="formInputGroup">
					<label for="state">State:</label> 
					<select name="state" id="state">
						<option value="AL">Alabama</option>
						<option value="AK">Alaska</option>
						<option value="AZ">Arizona</option>
						<option value="AR">Arkansas</option>
						<option value="CA">California</option>
						<option value="CO">Colorado</option>
						<option value="CT">Connecticut</option>
						<option value="DE">Delaware</option>
						<option value="DC">District Of Columbia</option>
						<option value="FL">Florida</option>
						<option value="GA">Georgia</option>
						<option value="HI">Hawaii</option>
						<option value="ID">Idaho</option>
						<option value="IL">Illinois</option>
						<option value="IN">Indiana</option>
						<option value="IA">Iowa</option>
						<option value="KS">Kansas</option>
						<option value="KY">Kentucky</option>
						<option value="LA">Louisiana</option>
						<option value="ME">Maine</option>
						<option value="MD">Maryland</option>
						<option value="MA">Massachusetts</option>
						<option value="MI">Michigan</option>
						<option value="MN">Minnesota</option>
						<option value="MS">Mississippi</option>
						<option value="MO">Missouri</option>
						<option value="MT">Montana</option>
						<option value="NE">Nebraska</option>
						<option value="NV">Nevada</option>
						<option value="NH">New Hampshire</option>
						<option value="NJ">New Jersey</option>
						<option value="NM">New Mexico</option>
						<option value="NY">New York</option>
						<option value="NC">North Carolina</option>
						<option value="ND">North Dakota</option>
						<option value="OH">Ohio</option>
						<option value="OK">Oklahoma</option>
						<option value="OR">Oregon</option>
						<option value="PA">Pennsylvania</option>
						<option value="RI">Rhode Island</option>
						<option value="SC">South Carolina</option>
						<option value="SD">South Dakota</option>
						<option value="TN">Tennessee</option>
						<option value="TX">Texas</option>
						<option value="UT">Utah</option>
						<option value="VT">Vermont</option>
						<option value="VA">Virginia</option>
						<option value="WA">Washington</option>
						<option value="WV">West Virginia</option>
						<option value="WI">Wisconsin</option>
						<option value="WY">Wyoming</option>
					</select>
				</div>
				
				<label for="activityLevel">Activity Level:</label> 
				<select name="activityLevel" id="activityLevel">
				<option value="Inactive">Inactive</option>
				<option value="Sedentary">Sedentary</option>
				<option value="Active">Active</option>
				<option value="Extremely Active">Extremely Active</option>
				</select>
				<br>
				<div style="padding-top: 7px">
				<input type="submit" value="Submit" id="submit"/>
				</div>
			</form>
		</div>
		
		
		
		</div>
</section>
<c:import url="/WEB-INF/jsp/footer.jsp" />