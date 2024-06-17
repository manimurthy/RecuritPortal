<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/saveFAQJob" method="post">
    <label for="title">Job Title:</label>
    <input type="text" id="jobtitle" name="jobtitle"><br>

    <label for="description">Job Description:</label>
    <textarea id="jobdesc" name="jobdesc"></textarea><br>
	<h5>Department</h5>
	<input type="text" id = "dept" name = "dept" class="with-border" />
									<h5>Admin in charge </h5>
									<input type="text" id = "admin_in_charge" name = "admin_in_charge" class="with-border" />
									<h5>Apply by date </h5>
									<input type="date" id = "applybydate" name ="applybydate" class="with-border" />
									<h5>Years of Experience required </h5>
									<input type="text" id = "yearsofexp" name ="yearsofexp" class="with-border" />
									<h5>Exp. Weightage</h5>
									<input type="text" id ="expweightpercent"  name ="expweightpercent" class="with-border" />
									<h5>Edu. Weightage</h5>
									<input type="text" id = "eduweightpercent" name ="eduweightpercent" class="with-border" />
									<h5>Exp. Skills Weightage</h5>
									<input type="text" id = "expskills" name ="expskills" class="with-border" />
    <label for="question">FAQ Question:</label>
    <input type="text" id="question" name="faqs[0].question"><br>

    <label for="answer">FAQ Answer:</label>
    <input type="text" id="answer" name="faqs[0].answer"><br>
    <label for="question">FAQ Question:</label>
    <input type="text" id="question" name="faqs[1].question"><br>

    <label for="answer">FAQ Answer:</label>
    <input type="text" id="answer" name="faqs[1].answer"><br>
    <label for="question">FAQ Question:</label>
    <input type="text" id="question" name="faqs[2].question"><br>

    <label for="answer">FAQ Answer:</label>
    <input type="text" id="answer" name="faqs[2].answer"><br>

    <div id="faqSection">
        <!-- Dynamic FAQ entries will go here -->
    </div>
    <button type="button" onclick="addFaq()">Add FAQ</button><br>
    <button type="submit">Submit</button>
    
</form>
<script>
    let faqIndex = 0;

    function addFaq() {
        const faqSection = document.getElementById('faqSection');
        const html = `
            <div class="faqGroup">
                <label>Question:</label>
                <input type="text" name="faqs[${faqIndex}].question"><br>
                <label>Answer:</label>
                <input type="text" name="faqs[${faqIndex}].answer"><br>
                <button type="button" onclick="removeFaq(this)">Remove</button>
            </div>
        `;
        faqSection.insertAdjacentHTML('beforeend', html);
        faqIndex++;
    }

    function removeFaq(button) {
        button.parentNode.remove();
    }
</script>
</body>
</html>