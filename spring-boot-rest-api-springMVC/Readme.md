![mvc1](https://user-images.githubusercontent.com/101598361/159135240-7b0c10f9-e282-44c3-98f7-4b355c2aff77.png)
CLIENT send the REQUEST to the CONTROLLER, CONTROLLER will check if there is any MODEL needed to fullfil this 
particular REQUEST if YES, then it will inject that particular MODEL, it will go and access that particular 
MODEL and then that MODEL will be injected to VIEW and then VIEW is RESPONDED to the CLIENT


![mvc2](https://user-images.githubusercontent.com/101598361/159135239-811e76d6-82c4-483e-8a34-11a049745e71.png)

Browser Request to Dispatcher, Dispatcher will go and communicate to the CONTROLLER, DISPATCHER have multiple 
CONTROLLER register with it so it will go and send the data or request to the appropriate CONTROLLER for that 
there are some HandlerMapping available, HandlerMapping can be done by using some configuration file or can 
use some Annotation etc. Now from the controller, Controller will receive the request and try to understand 
what type of request are given and based on that it will decide if there any Model required for your request 
or not, it will decide which request to be execute, that request you have to specify is there any model or data
from database is expected for particular request. if YES, the it will connect to the to the SERVICE LAYER (This 
is how Service Layer comes into picture). A SERVICE LAYER will go and interact to the DATA ACCESS OBJECT LAYER, 
DAO LAYER will go and interact with DATABASE. The REQUESTED SQL COMMAND will be fired at DB LAYER and the RESULT 
will be send back to the DAO LAYER and will given back to the SERVICE LAYER and SERVICE will give it to CONTROLLER.

NOW WHAT YOU NEED TO DO ? 
You need to inject a MODEL to the VIEW, so whatever data you fetch from SERVICE LAYER you need to put into a MODEL
and then that MODEL along with REQUEST given to the VIEW part/Resolver. So basically the REQUEST goes to VIEW 
resolver decide which view to be rendered and the VIEW will sending the RESPONSE to the CLIENT/BROWSER.


-------------------------------------------------------------------------------------------------------------------
=================================================================================================================== 
-------------------------------------------------------------------------------------------------------------------


> Basically in first configuration you need to do your class which extends the "AbstractAnnotationConfigDispatcherInitializer"
> when we are returning "emp.jsp" ViewResolver is going to create a path for eg. "WEB-INF/jsp/emp.jsp" where we have created
  a from or html page etc.
> Benefit of using springframework form instead of choosing HTML form is what we can add one more attribute to this form that
  is called as model attribute, What it means ?.... WhatEver your data, you are entering that will be entered by using a 
  particular MODEL "modelAttribute = "employee"" and it is get binded.
> http://localhost:8080/SpringMVCJacaConfig/greeting/?msg1=this%20is%20some%20msg&msg2=other%20msg
	path => /greeting
	Request Parameter => ?msg1=this%20is%20some%20msg&msg2=other%20msg     So whatever after question mark we are passing there
							msg1 and msg2 that will be captured by annotation called as ----"@RequestParam"----
	/greeting/{} 		=> 	if something put inside the angular bracket it means it is a VariablePath it can be captured by using 
					  		----"@PathVariable"----
> The entire request is mapped by using ----"@RequestMapping"----
> @SpringBootApplication is combination of = @Configuration + @EnableAutoConfiguration + @ComponentScan
> RestFul API
	GET 	=> Read Resource
	POST 	=> create Resource (insert query)
	PUT		=> Update Resource
	DELETE	=> Delete Resource
	Trace	=> 
	Option	=>
	Head	=>

>	<html>
	<body>
	<form method=post>
	</body>
	</html>
	
	if you want to create this you have two option either use HTML or use JavaScript for generating different type of requests
	
	> Rest Client => Helps to test your ReST API
		like - Postman, Curl, Swagger etc

> produces		=> means what type of response like text etc
	@GetMapping(path="/greet", produces="text/html")
	@GetMapping(path="/greet", produces="text/plain")
	tells what type of response to be produces

> consume		=> Says what type response do we consumes
	By Default if it is String then it will be send as text/html or text/plain
	By Default if it is Object then it will be send as JSON (JavaScript Object Notation)

> @RequestHeader	=> Binds request header values to method parameters		
	@RequestHeader("key_Name") String key
	if you want all Headers -- @RequestHeader Map<String, String> headers
									headers.forEach((k,v)-> {k+"->"+v}
> @RequestBody		=> annotation maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object.
> @ResponseBody	=> annotation tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.			

