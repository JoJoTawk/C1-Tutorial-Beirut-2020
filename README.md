
# C1 Tutorial 
This tutorial will explain what is the microservices architecture using Java springBoot in Intellij IDE, how to deploy Docker using Docker Hub.

A short video will be attached explaining this document.

### I will cover the below Points:

    What Spring Boot is and how to create a simple Spring Boot application.
    What is Docker and what are its benefits?
    Hosting the Spring Boot application in a Docker container.
 
Additionals (Separate Example)
        
        What is a microservice Architecture and what are the benefits?
        What is Eureka?
        Difference between monolithic and microservices approach


SpringBoot Application

    Spring Boot is a framework that eases the development of web applications. It has a lot of pre-configured modules that eliminate the manual addition of dependencies for developing an application with Spring. This is the sole reason for this being one of the favorites for creating microservices. Let's see how to create a Spring Boot Application in a few minutes.
 
 
Let’s start
        
    Open Spring Starter to create a Java Maven application with Spring Starter libraries. (Or create a new project from Intellij Idea this will be covered later with screenshots for better understanding)
    
    Provide the Artifact ,Group and Name, and in dependencies add “Spring Web” because we will create a simple Rest API and leave everything else with the default, which will create a Maven project with Java and Spring Boot. Finally click generate and you will have a zip which includes your maven project.
    
    Open The project by drag and drop in intellij or from file - >  open -> select the generated project
 
    Now Create a new java class it will be used to create a simple RestController so we can test the API


    Upon running the application and accessing the endpoint of the API, we will see the output “Simple Spring Boot Application” shown in the browser.

`http://localhost:8080/simpleAPI`

As we see tomcat the default engine on intellij runs on port 8080 if we access localhost:8080 we see whiteLabel error that’s because of routing.

Now we need to create a jar file of the project 

    First we need to run mvn clean and then mvn install this can be done from terminal or from the IDE 

    From terminal:
        Open terminal 
            Locate where the project exists cd project_directory 
                mvn clean
                When finish mvn install


This command will create a “.jar” file  in the target directory of the working directory.
 
 ### What Is a Dockerfile?
 
    Docker gives the user the capability to create their own Docker images and deploy them in Docker. To create your own Docker image, we have to create our own Dockerfile. Basically, a Dockerfile is a simple text file with all the instructions required to build the image.

### Create a new file in the project name it Dockerfile and add the following 



    FROM java:8
    EXPOSE 8080
    ADD /target/jhonny.jar jhonny.jar
    ENTRYPOINT ["java", "-jar", "jhonny.jar"]
    
    FROM java:8 means this is a Java application and will require all the Java libraries so it will pull all the Java-related libraries and add them to the container.
    
    EXPOSE 8080 means that we would like to expose 8080 to the outside world to access our application.
    
    ADD <Source of jar with the jar file> <jar file name>
    
    ADD <source from where Docker should create the image> <destination>
    
    ENTRYPOINT [“java”, “-jar”, “jhonny.jar”] will run the command as the entry point as this is a JAR and we need to run this JAR from within Docker.
 
Now to run docker there is some steps which we must follow
    
        Open terminal 
        Go to the project root  cd Project_root
        docker build -f DockerFile -t jhonny .   
        (DockerFile same as named it when we created it)
        (jhonny .) can be your customized docker image name
        docker images (get list of all Images)
        docker run -p 8080:8080 jhonny (jhonny is the image name)


    You can see it running on http://localhost:8080/simpleAPI same as we run it from intelliji IDE



THINGS to include 

### What is maven
    
    It's a build tool used by the IDE to build, run package, install .. the project


### Docker 

    What is Docker and what are its benefits?
    A Docker container is a tool that makes it very easy to deploy and run an application using containers. A container allows a developer to create an all-in-one package of the developed application with all its dependencies.
