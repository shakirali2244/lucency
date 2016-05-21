<%@ include file="/WEB-INF/views/templates/header.jsp" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<section id="contact" class="bg-primary">
        <div class="container">
            <div class="row">
            	<div class="col-md-6 col-md-offset-3">
	                <form role="form" action="/login" method="post" >
		                <div class="form-group">
		                	<label for="username">Username</label>
						    <input type="text" class="form-control" id="username" name="username" placeholder="Username">
						 </div>
						 <div class="form-group">
						    <label for="password">Password</label>
						    <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">
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