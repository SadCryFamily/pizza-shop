# Pizza-Shop

Pizza Shop is an application for ordering food online.

## How to edit it?🧾

Click on this [link](https://github.com/SadCryFamily/pizza-shop.git) or get URL below to download the project.

```bash
https://github.com/SadCryFamily/pizza-shop.git
```

## How to run it?🚀

To launch, you need any IDEA supporting Java projects: **```Eclipse, NetBeans, VScode, etc.```**

If such an **IDE** was not found, you can download **```IntelliJ IDEA```** for 
Windows by clicking on [this](https://www.jetbrains.com/ru-ru/idea/download/#section=windows) link.


**To start** the project, you need to follow the path: **```src/main/java/com/app/pizzashop/PizzaShopApplication.java```**, like in example below:

```java

@SpringBootApplication
public class PizzaShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaShopApplication.class, args);
    }

}

```

Then **clink on green button** on left-side bar of **```PizzaShopApplication.java```**, аfter that, the application will be launched 

and you can enjoy ordering food online!

## How it works?✨

This project uses the ```Spring Boot``` as well as ```Spring Data``` and ```Liquibase```, which allows to create ER diagram below.

![](https://i.ibb.co/VgnkXYN/2022-08-02-212556608.png)

- **``customer``** contains data about all users who have registered in the application.

- **``product``** contains information about the current products that can be ordered.

- **``orders``** is needed to link data from the customer and product tables.

- **``cart``** processes data from the orders entity, displaying customer order amounts individually or by category.

## To learn more📢

You need to run the project in the ``IDE``, go to the browser and follow the path ``localhost:8080/swagger-ui/``, to learn more about the ``entities`` and ``endpoints`` of the project, as well as make several test requests to the server, thanks to the support of ``Swagger 2.0``.
