package mk.ukim.finki.dnick.prototype.springbootlearningsystem.data;

import lombok.Getter;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.enumerations.Role;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.CourseService;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
public class DataInitializer {

    public UserService userService;
    public CourseService courseService;

    public DataInitializer(CourseService courseService, UserService userService) {
        this.userService = userService;
        this.courseService = courseService;
    }

    @PostConstruct
    public void init(){
        this.courseService.save("Java", "In this lecture you will learn the basics of the programming language Java needed for the rest of the course.","JAVA was developed by James Gosling at Sun Microsystems Inc in the year 1995, later acquired by Oracle Corporation. It is a simple programming language. Java makes writing, compiling, and debugging programming easy. It helps to create reusable code and modular programs.\n" +
                "\n" +
                "Java is a class-based, object-oriented programming language and is designed to have as few implementation dependencies as possible. A general-purpose programming language made for developers to write once run anywhere that is compiled Java code can run on all platforms that support Java. Java applications are compiled to byte code that can run on any Java Virtual Machine. The syntax of Java is similar to c/c++.\n" );
        this.courseService.save("OOP in Java", " In this lecture you will learn the OOP concepts in the programming language Java needed for the rest of the course.", "Java - What is OOP?\n" +
                "OOP stands for Object-Oriented Programming.\n" +
                "\n" +
                "Procedural programming is about writing procedures or methods that perform operations on the data, while object-oriented programming is about creating objects that contain both data and methods.\n" +
                "\n" +
                "Object-oriented programming has several advantages over procedural programming:\n" +
                "\n" +
                "OOP is faster and easier to execute\n" +
                "OOP provides a clear structure for the programs\n" +
                "OOP helps to keep the Java code DRY \"Don't Repeat Yourself\", and makes the code easier to maintain, modify and debug\n" +
                "OOP makes it possible to create full reusable applications with less code and shorter development time");
        this.courseService.save("Introduction to Spring", "In this lecture you will learn the basics of Spring framework.","This spring tutorial provides in-depth concepts of Spring Framework with simplified examples. It was developed by Rod Johnson in 2003. Spring framework makes the easy development of JavaEE application.\n" +
                "\n" +
                "It is helpful for beginners and experienced persons.\n" +
                "\n" +
                "Spring Framework\n" +
                "Spring is a lightweight framework. It can be thought of as a framework of frameworks because it provides support to various frameworks such as Struts, Hibernate, Tapestry, EJB, JSF, etc. The framework, in broader sense, can be defined as a structure where we find solution of the various technical problems.\n" +
                "\n" +
                "The Spring framework comprises several modules such as IOC, AOP, DAO, Context, ORM, WEB MVC etc. We will learn these modules in next page. Let's understand the IOC and Dependency Injection first.\n" +
                "\n" +
                "Inversion Of Control (IOC) and Dependency Injection\n" +
                "These are the design patterns that are used to remove dependency from the programming code. They make the code easier to test and maintain. Let's understand this with the following code:\n" +
                "\n" +
                "class Employee{  \n" +
                "Address address;  \n" +
                "Employee(){  \n" +
                "address=new Address();  \n" +
                "}  \n" +
                "}  \n" +
                "In such case, there is dependency between the Employee and Address (tight coupling). In the Inversion of Control scenario, we do this something like this:\n" +
                "\n" +
                "class Employee{  \n" +
                "Address address;  \n" +
                "Employee(Address address){  \n" +
                "this.address=address;  \n" +
                "}  \n" +
                "}  \n" +
                "Thus, IOC makes the code loosely coupled. In such case, there is no need to modify the code if our logic is moved to new environment.\n" +
                "\n" +
                "In Spring framework, IOC container is responsible to inject the dependency. We provide metadata to the IOC container either by XML file or annotation.\n" +
                "\n" +
                "Advantage of Dependency Injection\n" +
                "makes the code loosely coupled so easy to maintain\n" +
                "makes the code easy to test");
        this.courseService.save("Spring Factory", "In this lecture you will learn the concepts of Spring Beans and Spring Factory.", "There are two kinds of beans in the Spring bean container: ordinary beans and factory beans. Spring uses the former directly, whereas latter can produce objects themselves, which are managed by the framework.\n" +
                "\n" +
                "And, simply put, we can build a factory bean by implementing org.springframework.beans.factory.FactoryBean interface.Let's look at the FactoryBean interface first:\n" +
                "\n" +
                "public interface FactoryBean {\n" +
                "    T getObject() throws Exception;\n" +
                "    Class<?> getObjectType();\n" +
                "    boolean isSingleton();\n" +
                "}\n" +
                "Let's discuss the three methods:\n" +
                "\n" +
                "getObject() – returns an object produced by the factory, and this is the object that will be used by Spring container\n" +
                "getObjectType() – returns the type of object that this FactoryBean produces\n" +
                "isSingleton() – denotes if the object produced by this FactoryBean is a singleton\n" +
                "Now, let's implement an example FactoryBean. We'll implement a ToolFactory which produces objects of the type Tool:");
        this.userService.register("admin","admin","admin","Adam","Adamovski", Role.ROLE_ADMIN);
        this.userService.register("user","user","user","John","Adamovski", Role.ROLE_USER);
    }


}
