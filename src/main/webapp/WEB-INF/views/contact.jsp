<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<section id="contact" class="bg-primary">
        <div class="container">
            <div class="row">
            	<div class="col-md-6 col-md-offset-3">
	                <form role="form" action="/contact" method="post" >
		                <div class="form-group">
		                	<div class="row">
		                	<div class="col-md-6">
		                	<label for="name">Name</label>
						    <input type="text" class="form-control" id="name" name="name" placeholder="Name">
						    </div>
		                	<div class="col-md-6">
						    <label for="email">E-Mail</label>
						    <input type="email" class="form-control" id="email" name="email" placeholder="E-Mail">
						    </div>
						    </div>
						 </div>
					  <div class="form-group">
					    <label for="subject">Subject</label>
					    <input type="text" class="form-control" id="subject" name="subject" placeholder="Subject">
					  </div>
					  <div class="form-group">
					    <label for="message">Message</label>
					    <textarea class="form-control" rows="6" name="message" placeholder="Message"></textarea>
					  </div>
					   <sec:csrfInput />
					  <button type="submit" class="btn btn-default">Submit</button>
					</form>
				</div>
            </div>
        </div>
         <!--<h3><marquee  direction="right"></marquee></h3>-->
    </section>
<%@ include file="/WEB-INF/views/templates/footer.jsp" %>