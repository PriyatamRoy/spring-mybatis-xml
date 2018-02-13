<%@ include file="/WEB-INF/views/init.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <c:url var="home" value="/" scope="request" />
        <link href="${bootstrapCss}" rel="stylesheet" />
        <script src="${jqueryJs}"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Sapient Alumni</a>
                </div>
            </div>
        </nav>

        <div class="container" style="min-height: 500px">            

            <form class="form-horizontal" id="book-form">
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label">ID</label>
                    <div class="col-sm-6">
                        <input type="number" class="form-control" id="id">
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label">Title</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="title">
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label">Author</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="author">
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label">Description</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="description">
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label">Price</label>
                    <div class="col-sm-6">
                        <input type="number" class="form-control" id="price">
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label">ISBN</label>
                    <div class="col-sm-6">
                        <input type="number" class="form-control" id="isbn">
                    </div>
                </div>
                <div class="form-group form-group-sm">
                    <label class="col-sm-2 control-label">Create Date</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="create_date">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" id="bth-search"
                                class="btn btn-primary btn-lg">Save</button>
                    </div>
                </div>
            </form>

            <ul id="allData"></ul>

        </div>

        <script>
            jQuery(document).ready(function ($) {
                console.log('========ready=======');
                getAll();

                $("#book-form").submit(function (event) {
                    save();
                });
            });


            function getAll() {
                $.ajax({
                    type: "GET",
                    url: "${home}rest/getAllBook",
                    timeout: 100000,
                    success: function (data) {
                        console.log("SUCCESS: ", JSON.stringify(data));
                        displayAll(data);
                    },
                    error: function (e) {
                        console.log("ERROR: ", e);
                        //display(e);
                    },
                    done: function (e) {
                        console.log("DONE");
                        //enableSearchButton(true);
                    }
                });
            }

            function displayAll(data) {
                $.each(data, function () {
                    $("#allData").append("<li><a rel='external' href='" + this.id + "'>" +
                            this.bookTitle + ' ' +
                            this.authorName + ' ' +
                            this.bookDescription + ' ' +
                            this.bookPrice + ' ' +
                            this.isbn + ' ' +
                            this.createDate + "</li>");
                });
            }

            function save() {
                var bookData = {};
		bookData["id"] = $("#id").val();
		bookData["title"] = $("#title").val();
                bookData["author"] = $("#author").val();
                bookData["description"] = $("#description").val();
                bookData["price"] = $("#price").val();
                bookData["isbn"] = $("#isbn").val();
                bookData["create_date"] = $("#create_date").val();
                
                $.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${home}/rest/addBook",
			data : JSON.stringify(bookData),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				getAll();
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			},
			done : function(e) {
				console.log("DONE");
				//enableSearchButton(true);
			}
		});
            }

        </script>
    </body>
</html>
