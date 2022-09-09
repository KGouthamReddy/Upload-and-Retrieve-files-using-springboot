<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Uplaod</title>
</head>

<body>
	<h2>Upload files here</h2>
	<form th:action="@{/users/savefile}" method="post"
    th:object="${user}"
    enctype="multipart/form-data">  
    
    <label>Profile Picture: </label>
        <input type="file" name="profilePictureFile" accept="image/png, image/jpeg" required />  <br><br>
    <label>Photo ID: </label>
        <input type="file" name="photoIdFile" accept="image/png, image/jpeg" required /> <br><br>
       <input type="submit" value="save"/>  
</form>
</form>
</form>

</body>

</html>