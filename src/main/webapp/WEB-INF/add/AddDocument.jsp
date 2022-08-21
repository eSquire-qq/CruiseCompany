<!DOCTYPE html>
<html>
<head>
    <title>Add document</title>
</head>
<body>

<input id="ajaxfile" type="file"/> <br/>
<button onclick="uploadFile()"> Upload </button>

<script>
    async function uploadFile() {
        let formData = new FormData();
        formData.append("file", ajaxfile.files[0]);
        await fetch('fileuploadservlet', {
            method: "POST",
            body: formData
        });
        alert('The file upload with Ajax and Java was a success!');
    }
</script>

</body>
</html>
