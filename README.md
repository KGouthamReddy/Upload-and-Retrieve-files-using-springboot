Technologies used:
1. HTML, CSS, Java
2. Springboot, Spring MVC, Maven.
3. Filehandling methods
4. SQL
5. Eclipse IDE

here are the key points:
- Add a column to store file names in the database table.
- Declare a field in the entity class to store name of the uploaded file.
- Use file input in the web form and set attribute enctype=”multipart/form-data” for the form tag.
- Add all the dependancies which are required in teh pom.xml file.
- Use @RequestParam and MultipartFile in Spring controller’s handler method save and authenticate data in the database.
- Authenticate user input data and perform respective actions.
- Use Files.copy() method to copy the uploaded file from temporary location to a fixed directory in the file system.
- Configure Spring MVC to expose the upload directory so image files can show up in the browser.
