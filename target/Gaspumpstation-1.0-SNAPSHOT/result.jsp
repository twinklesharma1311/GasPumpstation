<%-- 
    Document   : result
    Created on : Apr 25, 2016, 12:56:40 PM
    Author     : doctorwho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        
         
         
         <div class="container"> 
             <h1>Pump Station</h1>
             <div class="row">
                 <div class="col-md-12">
                     <h1></h1>
                     <form>
                         <div class="form-group">
                             <label for="fuelType">Fuel Type</label>
                             <select class="form-control" name="fuelType">
                                 <option value="101">Gasoline</option>
                                 <option value="102">Diesel</option>
                             </select>
                         </div>
                         <div class="form-group">
                             <label for="selectGrade">Fuel Type</label>
                             <select class="form-control" name="fuelType">
                                 <option value="87">87</option>
                                 <option value="89">89</option>
                                 <option value="93">93</option>
                             </select>
                         </div>
                         <div class="form-group">
                             <button type="submit" name="start" class="col-md-6 btn btn-success">Start</button>
                             <button type="submit" name="stop" class="col-md-6 btn btn-success">End</button>
                         </div>
                     </form>
                 </div>
             </div>
         </div>
         
         
        
        <script src=https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js></script><script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.min.js"><\/script>');</script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script> 
    </body>
</html>
