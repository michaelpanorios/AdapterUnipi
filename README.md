# Adapter pattern 

An Adapter pattern acts as a connector between two incompatible interfaces that otherwise cannot be connected directly. An Adapter wraps an existing class with a new interface so that it becomes compatible with the client’s interface.

The main motive behind using this pattern is to convert an existing interface into another interface that the client expects. It's usually implemented once the application is designed.

In this project case it's important to define the entities that are being used. The first interface that client sees is a simple html form which has to be completed and submitted in order for back-end to work on it. Automatically, web form is transformed to a valid ```.xml``` file which is being parsed on Java and completes any validations needed. Finally, a new final file is generated and shows the order with validation. 


## Installation

Write down the following command on GIT cli:

```bash
git clone https://github.com/michaelpanorios/AdapterUnipi.git
```

## UI files
There is a simple HTML file that includes a web form representing a book order. 
JavaScript file has three methods in it. It makes web headers in order to detect the url for downloading, creates the entry ```.xml``` file and a script which downloads the defined file.


## ElementsBookOrder.class
An important class which give us the ability to save all the values from the XML file to setters. Has no arg constructor, all fields constructor, getters and setters and ```toString()``` method for printing the values.

## DocumentParser.class
Class that has the role of project's heart. It welcomes the user's file and parses it. Has three methods including main, which finds the ```.xml``` file from user's Downloads folder which is defined as ```book-order.xml``` 
```java
String home = System.getProperty("user.home");
File xmlFile = new File(home+"/Downloads/" + "book-order.xml");
```
Method ```showXMLfile()``` parses the file and sets the values of the elements to ```ElementsBookOrder.class``` in order to be easy to handle data.

Method ```showXMLFinalFile()``` usage is to design and set the new values produced after the validations in ```FieldValidation.class```.

## FieldValidation.class
Prepreparation of final .xml file. As we were told we had to handle the elements of an .xml file. I decided that making validations on every .xml file's element will be a good way of utilization. The check that is needed for every situation is to check if the element is empty. Finally a new value, if it is need, will be setted as element's value in the final file.

Author validation: 
```java
elementsBookOrder.setAuthor(elementsBookOrder.getAuthor().toUpperCase());
```

Title validation: 
```java
elementsBookOrder.setTitle(elementsBookOrder.getTitle().trim());
```


Genre validation: 
```java
checkExistingGenres(elementsBookOrder, elementsBookOrder.getGenre());
```

Price validation: 
```java
if (elementsBookOrder.getPrice().isEmpty() || !elementsBookOrder.getPrice().matches(regex)) {
   elementsBookOrder.setPrice("ERROR: Price field is blank, it must start with currency character");
}
```

Publish date validation: 
```java
// Generates dd/MM/yyyy format to fully described date.
```
Description validation: 
```java
elementsBookOrder.setDescription(elementsBookOrder.getDescription().trim());
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

