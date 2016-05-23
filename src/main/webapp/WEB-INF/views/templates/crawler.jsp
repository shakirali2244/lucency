<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Utilities</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           Crawler
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="/console/url" method="post" >
                                        <div class="form-group">
                                            <label>URL</label>
                                            <sec:csrfInput />
                                            <input class="form-control" id="url" name="url">
                                            <br/>
                                            <input type="submit" class="btn btn-default" value="Submit">
                                            <p class="help-block">Enter URL to start Crawler with </p>
                                        </div>
                                     </form>
                                 </div>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>
             <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           Instagram Followers Report
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="/console/instareport" method="post" >
                                        <div class="form-group">
                                            <sec:csrfInput />
                                            <input type="submit" class="btn btn-default" value="Generate Report">
                                        </div>
                                     </form>
                                 </div>
                             </div>
                         </div>
                     </div>
                 </div>
             </div>
 </div>
             