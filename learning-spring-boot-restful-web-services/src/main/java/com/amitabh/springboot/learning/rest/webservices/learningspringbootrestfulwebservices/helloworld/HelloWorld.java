package com.amitabh.springboot.learning.rest.webservices.learningspringbootrestfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Questions :

//Difference between @RequestMapping and @GetMapping

//Spring 4.3. introduced some very cool method-level composed annotations to smooth out the handling 
//@RequestMapping in typical Spring MVC projects.

//Typically, if we want to implement the URL handler using traditional @RequestMapping annotation, 
//it would have been something like this:
//@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
//The new approach makes it possible to shorten this simply to:
//@GetMapping("/get/{id}")
//Spring currently supports five types of inbuilt annotations for handling different types of incoming 
//HTTP request methods which are GET, POST, PUT, DELETE and PATCH. These annotations are:

/*
@GetMapping
@PostMapping
@PutMapping
@DeleteMapping
@PatchMapping
*/

//From the naming convention we can see that each annotation is meant to handle respective incoming 
//request method type, i.e. @GetMapping is used to handle GET type of request method, @PostMapping 
//is used to handle POST type of request method, etc.

//All of the above annotations are already internally annotated with @RequestMapping and 
//the respective value in the method element.

//Difference between @RestController and @Controller
//@RequestController = @Controller + @ResponseBody annotation
//Fundamental difference between WEB API and REST API is that the response from a web application is 
//html & css & Javascript however the response from the rest api is json or xml or desired format
//The job of @Controller is to create a Map of model object and to return a view name to 
//the DispatcherServlet which will then use internally the view resolver to choose appropriate
//for the request @RestController simply 
//return the object and object data is directly written into HTTP response as JSON or XML without 
//using a view resolver.

@RestController
public class HelloWorld {

    public HelloWorld() {
        // TODO Auto-generated constructor stub
    }

    @RequestMapping(method = RequestMethod.GET, path = "hello-world-requestmapping")
    public String helloWorldRequestMapping() {
        return "HelloWorld-RequestMapping method called";
    }

    // mapping path is case sensitive and if it is made upper case as shown below then it will result in exceptio
    // Input request : http://localhost:8080/hello-world-getmapping
    // Generates following exception :
    /*
    {
        "timestamp": "2018-10-04T15:10:56.274+0000",
        "status": 404,
        "error": "Not Found",
        "message": "No message available",
        "path": "/hello-world-getmapping"
    }
    */

    @GetMapping(path = "hello-world-getmappinG")
    public String helloWorldGetMapping() {
        return "HelloWorld-Getmapping method called";
    }

    // returning a hello world bean

    // interesting exception if the bean we are trying to send back does not have getter then
    // the automatic type conversion will not work and will result in the following exception

    /*
    {
        "timestamp": "2018-10-04T16:04:09.267+0000",
        "status": 500,
        "error": "Internal Server Error",
        "message": "No converter found for return value of type: class com.amitabh.springboot.learning.rest.webservices.learningspringbootrestfulwebservices.bean.HelloWorldBean",
        "path": "/hello-world-bean"
    }
    */

    // Quick fix to the above exception is to ensure that the bean being send back must
    // have a getter method

    @GetMapping("hello-world-bean")
    public HelloWorldBean getHelloWorldBean() {
        return new HelloWorldBean("Created Hello World Bean");
    }

    // How Does @ResponseBody annotation works

    // Why JSON Is being returned in the output

    /*
    Further to this, the return type is determined by
    
        What the HTTP Request says it wants - in its Accept header. Try looking at the initial request as see what Accept is set to.
    
        What HttpMessageConverters Spring sets up. Spring MVC will setup converters for XML (using JAXB) and JSON if Jackson libraries are on he classpath.
    
        If there is a choice it picks one - in this example, it happens to be JSON.
    
        This is covered in the course notes. Look for the notes on Message Convertors and Content Negotiation.
        
       */

    // INITIAL HEADER REQUEST

    /*
    Content-Type →application/json;charset=UTF-8
        Date →Thu, 04 Oct 2018 16:06:14 GMT
        Transfer-Encoding →chunked
        
        */

    
    @GetMapping("hello-world-bean/path-variable/{name}" )
    public HelloWorldBean getHelloWorldBeanPathVariable(@PathVariable String name) {
        return new HelloWorldBean("Created Hello World Bean" + name);
    }
}
