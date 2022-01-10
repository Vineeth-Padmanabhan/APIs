#Plan ->
//Input -> the root directory of the project to scan or file
//Input -> destination package


//If Directory - Scan all xml files and collect  xmls having routes .Also create map of bean id and class names
//If File -> Expectation is all beans are in same file 

For each file with route
	//Scan all tags and attribues in a xml and collect all fields which were not handled by the tool -> Inform the user
	//If unsupported tags ,update the utility and run again

For each file with route
	//XmlName will be the class name.This will make it easier to compare. Also Means multiple routes in a  class similar to xml.
	//
	//Scan again to load all routes in a file -> For simplicity scanning is repeated as we performance is not a constraint 
	For each  route 
		iterate over each node and call appropriate dsl converter to convert each line to java dsl code block -> o/p will be list of java dsl line statements (Builder Pattern)
		Where ever bean reference ,look up map created in step 1 and update autowire map
	Separate code blocks with \n
	Create Java Class with filename decided and create skelton
	Add fields from Autowire map and add @Autowire annotation -> Can consider construtor add later stage to avoid Autowire
	Join code blocks and insert into the configure method
	
Special condition - Error Handler are route builder specific in java dsl -> XML might have global ->
