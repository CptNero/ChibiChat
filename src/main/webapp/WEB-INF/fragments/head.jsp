<head>
    <meta charset="UTF-8">
    <title>Chibi Chat</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://cdn.tiny.cloud/1/in1xb1ct2uhp5kvj8o06zfpuu7rmjdeqhmolche1eszvlhrd/tinymce/5/tinymce.min.js"
            referrerpolicy="origin"></script>
    <style>
        <%@include file="/WEB-INF/stylesheets/style.css" %>
    </style>
    <script>
        tinymce.init({
            selector: '#mytextarea',
            plugins: 'a11ychecker advcode casechange formatpainter linkchecker autolink lists checklist media mediaembed pageembed permanentpen powerpaste table advtable tinycomments tinymcespellchecker',
            toolbar: 'a11ycheck addcomment showcomments casechange checklist code formatpainter pageembed permanentpen table',
            toolbar_mode: 'floating',
            tinycomments_mode: 'embedded',
            tinycomments_author: 'Author name',
        });
    </script>
</head>

