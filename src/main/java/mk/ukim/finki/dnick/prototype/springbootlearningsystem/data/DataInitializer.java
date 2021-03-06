package mk.ukim.finki.dnick.prototype.springbootlearningsystem.data;

import lombok.Getter;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.FinalTest;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.Question;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.models.enumerations.Role;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.repository.FinalTestRepository;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.repository.QuestionRepository;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.CourseService;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.QuizService;
import mk.ukim.finki.dnick.prototype.springbootlearningsystem.service.interfaces.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
public class DataInitializer {

    public UserService userService;
    public CourseService courseService;
    public QuizService quizService;
    public QuestionRepository questionRepository;

    public FinalTestRepository finalTestRepository;

    public DataInitializer(CourseService courseService, UserService userService,
                           QuizService quizService, QuestionRepository questionRepository, FinalTestRepository finalTestRepository) {
        this.userService = userService;
        this.courseService = courseService;
        this.quizService = quizService;
        this.questionRepository = questionRepository;
        this.finalTestRepository = finalTestRepository;
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
                "   ???OOP is faster and easier to execute\n" +
                "   ???OOP provides a clear structure for the programs\n" +
                "   ???OOP helps to keep the Java code DRY \"Don't Repeat Yourself\", and makes the code easier to maintain, modify and debug\n" +
                "   ???OOP makes it possible to create full reusable applications with less code and shorter development time");
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
                "   Address address;  \n" +
                "   Employee(){  \n" +
                "       address=new Address();  \n" +
                "   }  \n" +
                "}  \n" +
                "In such case, there is dependency between the Employee and Address (tight coupling). In the Inversion of Control scenario, we do this something like this:\n" +
                "\n" +
                "class Employee{  \n" +
                "   Address address;  \n" +
                "   Employee(Address address){  \n" +
                "       this.address=address;  \n" +
                "   }  \n" +
                "}  \n" +
                "Thus, IOC makes the code loosely coupled. In such case, there is no need to modify the code if our logic is moved to new environment.\n" +
                "\n" +
                "In Spring framework, IOC container is responsible to inject the dependency. We provide metadata to the IOC container either by XML file or annotation.\n" +
                "\n" +
                "Advantage of Dependency Injection:\n" +
                "   - makes the code loosely coupled so easy to maintain\n" +
                "   - makes the code easy to test");
        this.courseService.save("Spring Beans", "In this lecture you will learn the concepts of Spring Beans",
                "1. Overview\n" +
                "Bean is a key concept of the Spring Framework. So understanding this notion is crucial to get the hang of the framework and use it in an effective way.\n" +
                "\n" +
                "Unfortunately, there aren't clear answers to the simple question of what a Spring bean really is. Some explanations go to such a low level that the big picture is missed, whereas others are too vague.\n" +
                "\n" +
                "This tutorial will try to shed light on the topic, starting with a description in the official documentation." +
                "\n" +
                "2. Bean Definition\n" +
                "Here's a definition of beans in the Spring Framework documentation:\n" +
                "\n" +
                "In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container are called beans. A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container." +
                "\n" +
                "This definition is concise and gets to the point but fails to elaborate on an important element: the Spring IoC container. Let's take a closer look to see what it is and the benefits it brings in." +
                "\n" +
                "3. Inversion of Control\n" +
                "Simply put, Inversion of Control (IoC) is a process in which an object defines its dependencies without creating them. This object delegates the job of constructing such dependencies to an IoC container.\n" +
                "\n" +
                "Let's start with the declaration of a couple of domain classes before diving into IoC.\n" +
                "\n" +
                "3.1. Domain Classes\n" +
                "Assume we have a class declaration:\n" +
                "\n" +
                "public class Company {\n" +
                "    private Address address;\n" +
                "\n" +
                "    public Company(Address address) {\n" +
                "        this.address = address;\n" +
                "    }\n" +
                "\n" +
                "    // getter, setter and other properties\n" +
                "}\n" +
                "This class needs a collaborator of type Address:\n" +
                "public class Address {\n" +
                "    private String street;\n" +
                "    private int number;\n" +
                "\n" +
                "    public Address(String street, int number) {\n" +
                "        this.street = street;\n" +
                "        this.number = number;\n" +
                "    }\n" +
                "\n" +
                "    // getters and setters\n" +
                "}"
                );
        this.courseService.save("Spring Factory", "In this lecture you will learn the concepts of Spring Factory.", "There are two kinds of beans in the Spring bean container: ordinary beans and factory beans. Spring uses the former directly, whereas latter can produce objects themselves, which are managed by the framework.\n" +
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
                "   ???getObject() ??? returns an object produced by the factory, and this is the object that will be used by Spring container\n" +
                "   ???getObjectType() ??? returns the type of object that this FactoryBean produces\n" +
                "   ???isSingleton() ??? denotes if the object produced by this FactoryBean is a singleton\n");
        this.userService.register("admin","admin","admin","Adam","Adamovski", Role.ROLE_ADMIN);
        this.userService.register("user","user","user","John","Adamovski", Role.ROLE_USER);


        Question question = new Question("What is a correct syntax to output \"Hello World\" in Java?", "echo \"Hello World\"",
                "printf(\"Hello World\")", "System.out.println(\"Hello World\")", 3, -1);
        this.questionRepository.save(question);
        Question question1 = new Question("Java is short for \"JavaScript.\"", "True", "False", "Partially True", 2, -1);
        this.questionRepository.save(question1);
        Question question2 = new Question("How do you insert COMMENTS in Java code?", "# This is a comment", "// This is a comment", "/* This is a comment", 2, -1);
        this.questionRepository.save(question2);
        Question question3 = new Question("Which data type is used to create a variable that should store text?", "String", "Char", "Both", 1, -1);
        this.questionRepository.save(question3);
        Question question4 = new Question("How do you create a variable with the numeric value 5?", "num x = 5", "float x = 5", "int x = 5", 3, -1);
        this.questionRepository.save(question4);
        Question question5 = new Question("In OO, the concept of IS-A is based on", "Class inheritance","Intefrace implementation","Both",3, -1);
        this.questionRepository.save(question5);
        Question question6 = new Question("Method overloading is done during _______.", "Dynamic binding", "Program compilation","Runtime", 2,-1);
        this.questionRepository.save(question6);
        Question question7 = new Question("The relation between Car and Owner or BankAccount and Customer is example for", "Association", "Aggregation", "None",1,-1);
        this.questionRepository.save(question7);
        Question question8 = new Question("Polymorphism is one interface with __________.", "Multiple methods", "Single record", "Single method",1,-1);
        this.questionRepository.save(question8);
        Question question9 = new Question("At run-time, a Java program is nothing more than objects 'talking' to ___________.","Other classes","Other objects","Other binders",2,-1);
        this.questionRepository.save(question9);
        Question question10 = new Question("Ad hoc polymorphism is ____________.", "Dynamic binding", "Method Overloading", "Method Overriding",2,-1);
        this.questionRepository.save(question10);
        Question question11 = new Question("Which are the modules of Data Access/ integration layer?","JDBC, ORM, OXM, JMS, Transactions","JDBC, ORM, OXM, JMS", "JDBC, ORM, Web, Beans",1,-1);
        this.questionRepository.save(question11);
        Question question12 = new Question("Which of the following database is not supported using jdbcTemplate?","Oracle", "MySql", "NoSql",3,-1);
        this.questionRepository.save(question12);
        Question question13 = new Question("What BeanPostProcessor does?","It processes beans once a bean exits.", "It defines callback methods that you can implement to provide your own instantiation logic, dependency-resolution logic ect.", "It processes beans once a bean is loaded", 2, -1);
        this.questionRepository.save(question13);
        Question question14 = new Question("What is Join point?", "This represents a point in your object where you join values.", "This represents a point in your object where you join injected values.", "This represents a point in your application where you can plug-in AOP aspect.", 3, -1 );
        this.questionRepository.save(question14);
        Question question15 = new Question("What is the scope of stateless bean?", "global-session", "singleton", "request", 2, -1);
        this.questionRepository.save(question15);
        Question question16 = new Question("What is true about collection configuration elements?", "This helps in wiring a list of values but without any duplicates.", "This can be used to inject a collection of name-value pairs where name and value can be of any type.", "This can be used to inject a collection of name-value pairs where the name and value are both Strings.", 3, -1);
        this.questionRepository.save(question16);
        Question question17 = new Question("What is singleton scope?", "This scopes the bean definition to a single instance per HTTP Session.", "This scopes the bean definition to a single instance per HTTP Request.", "This scopes the bean definition to a single instance per Spring IoC container.", 3, -1);
        this.questionRepository.save(question17);
        Question question18 = new Question("Spring is .. .", "a free framework", "a licensed framework", "an open source framework", 3, -1);
        this.questionRepository.save(question18);
        Question question19 = new Question("Which exception class is related to all the exceptions that are thrown in spring applications?", "ArrayIndexOutofBound", "DataAccessException", "NullPointerException", 2,-1);
        this.questionRepository.save(question19);
        Question question20 = new Question("Beans defined in spring framework are by default ..", "Final", "Singleton", "Abstract", 2, -1);
        this.questionRepository.save(question20);
        Question question21 = new Question("What are different types of Bean Injections?", "constructor and setter", "constructor and getter", "getter and setter",1 ,-1);
        this.questionRepository.save(question21);
        Question question22 = new Question("Which of the following is true?", "BeanFactory implements ApplicationContext", "BeanFactory extends ApplicationContext", "ApplicationContext extends BeanFactory",3,-1);
        this.questionRepository.save(question22);
        Question question23 = new Question("IOC or Dependenct injection is a ..", "Java Module", "Framework", "Design Pattern", 3, -1);
        this.questionRepository.save(question23);
        Question question24 = new Question("Which are different points where weaving can be applied?", "Compile Time , Classload Time , Runtime", "Compile Time and Runtime", "Compile Time , Classload Time , load time", 1, -1);
        this.questionRepository.save(question24);

        this.quizService.save("Introduction to Java Quiz");
        this.quizService.save("OOP Quiz");
        this.quizService.save("Introduction to Spring Quiz");
        this.quizService.save("Spring Beans Quiz");
        this.quizService.save("Spring Factory Quiz");

        FinalTest finalTest = new FinalTest("Final Test");

        this.finalTestRepository.save(finalTest);
    }


}
