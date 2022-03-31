![mvc1](https://user-images.githubusercontent.com/101598361/159135240-7b0c10f9-e282-44c3-98f7-4b355c2aff77.png)



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
