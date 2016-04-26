<%-- 
    Document   : index
    Created on : Apr 25, 2016, 3:10:39 AM
    Author     : doctorwho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link href="css/creditcardjs-v0.10.13.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <title>Welcome Gas Station</title>
    </head>
    <body>
        <div class="container">
            <h1>Welcome to Gas Pump Station</h1>
            <div class="row">
                <div class="col-md-12">
                    <form action="result" method="post" class="form">



                        <div class="ccjs-card">
                            <label class="ccjs-number">
                                Card Number
                                <input name="card-number" class="ccjs-number" placeholder="•••• •••• •••• ••••">
                            </label>

                            <label class="ccjs-csc">
                                Security Code
                                <input name="csc" class="ccjs-csc" placeholder="•••">
                            </label>

                            <button type="button" class="ccjs-csc-help">?</button>

                            <label class="ccjs-name">
                                Name on Card
                                <input name="name" class="ccjs-name">
                            </label>

                            <fieldset class="ccjs-expiration">
                                <legend>Expiration</legend>
                                <select name="month" class="ccjs-month">
                                    <option selected disabled>MM</option>
                                    <option value="01">01</option>
                                    <option value="02">02</option>
                                    <option value="03">03</option>
                                    <option value="04">04</option>
                                    <option value="05">05</option>
                                    <option value="06">06</option>
                                    <option value="07">07</option>
                                    <option value="08">08</option>
                                    <option value="09">09</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select>

                                <select name="year" class="ccjs-year">
                                    <option selected disabled>YY</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                    <option value="21">21</option>
                                    <option value="22">22</option>
                                    <option value="23">23</option>
                                    <option value="24">24</option>
                                </select>
                            </fieldset>

                            <select name="card-type" class="ccjs-hidden-card-type">
                                <option value="amex" class="ccjs-amex">American Express</option>
                                <option value="discover" class="ccjs-discover">Discover</option>
                                <option value="mastercard" class="ccjs-mastercard">MasterCard</option>
                                <option value="visa" class="ccjs-visa">Visa</option>
                                <option value="diners-club" class="ccjs-diners-club">Diners Club</option>
                                <option value="jcb" class="ccjs-jcb">JCB</option>
                                <!--<option value="laser" class="laser">Laser</option>-->
                                <!--<option value="maestro" class="maestro">Maestro</option>-->
                                <!--<option value="unionpay" class="unionpay">UnionPay</option>-->
                                <!--<option value="visa-electron" class="visa-electron">Visa Electron</option>-->
                                <!--<option value="dankort" class="dankort">Dankort</option>-->
                            </select>
                            <input type="submit" class="cc-btn" id="authorize" name="authorize" value="Authorize">   
                        </div>



                    </form>
                </div>
            </div>
        </div>     


        <script src=https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js></script><script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.min.js"><\/script>');</script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        <script src="js/creditcardjs-v0.10.13.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
