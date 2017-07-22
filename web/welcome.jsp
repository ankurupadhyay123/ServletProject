<%@ page import="dao.BlogDao" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.impl.BlogDaoImpl" %>
<%@ page import="entities.Blog" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="page1css.css">
	<title>MyPage</title>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/boo
		tstrap.min.css">
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootst
		rap.min.js">
	</script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<style>
	.row{
	border:1.5px solid black;
	border-radius:8px;
	padding:15px;
	}
	.a1{
	text-decoration:underline;
	font-size:20px;
	}
	.searchbox{
	border:2px solid black;
	border-radius:10px;
	padding:0;
	height:35px;
	}
	.input-group-addon, .form-control{
	background-color:white;
	border:2px solid white;
	border-radius:10px;
	height:29px;
	}
	.input-group{
	padding:0;
	margin:0;
	}
	.dynamicDivHead{
	border-bottom:1.5px solid black;
	border-radius:8px 8px 0 0;
	background-color:darkslategrey;
	height:28px;
	padding:5px;
	}
	.dynamicDiv{
	border:1.5px solid black;
	border-radius:8px;
	background: white;
	opacity: 0.85;
	}
	.fa {
	  padding: 5px;
	  font-size: 20px;
	  width: 45px;
	  height: 26px;
	  text-align: center;
	  text-decoration: none;
	  margin: 0;
	}
	.fa-facebook {
	  background: #3B5998;
	  color: white;
	}
	.fa-twitter {
	  background: #55ACEE;
	  color: white;
	}

	.fa-google {
	  background: #dd4b39;
	  color: white;
	}
	.phead{
		 color: white;
		 font-weight: bold;
	 }
	</style>
</head>

<body style="background:url('backgroundImage.jpg'); background-size: 100% 100%; height:100vh; width:100%; padding:0; margin:0;">

<%--TODO: Never use repo in view layer--%>
<%  BlogDao blogDao = new BlogDaoImpl();
	List<Blog> blogs = blogDao.getAll();
	Iterator<Blog> blogIterator = blogs.iterator();
%>
	<div class="container" >
		<div class="row well" >
			<div>
				<a class="pull-left a1" style="text-decoration: none">My Blogs</a>
				<div class="col-md-2 col-sm-3 pull-right searchbox">
					<div class="input-group ">
						<span class="input-group-addon glyphicon glyphicon-search"></span>
						<input type="search" class="form-control" placeholder="search"></input>
						<span class="input-group-addon glyphicon glyphicon-remove-sign"></span>					
					</div>
				</div>
			</div>
		</div>
	<div id="division1" class="col-md-8 col-sm-8">
		<div style="padding-left: 0;">
			<div class="dynamicDiv" style="margin-bottom:15px;">
				<div class="dynamicDivHead">
					<p class="phead">Recent Shares</p>
				</div>

				<% while (blogIterator.hasNext()){ Blog userblog = blogIterator.next();%>
				<div style="margin:10px;">
					<div class="media">
						<div class="media-left">
							<img src="images.png" class="media-object" style="width:90px; height: 90px">
						</div>
						<div class="media-body" >
							<h4 class="media-heading" id="userNameOfBlog" style="margin-right: 5px"><%=userblog.getUserName()%><small id="timeStampOfBlog" style="margin-left:5px "><%=userblog.getDoc()%></small></h4>
							<p id="userblogData" style="font-size: 15px"><%=userblog.getBlogdata()%>></p>
							<a href="#" class="fa fa-facebook"></a>
							<a href="#" class="fa fa-twitter"></a>
							<a href="#" class="fa fa-google"></a>
						</div>
					</div>
				</div>
				<% }%>
			</div>
		</div>
	</div>

	<div id="division2" class="col-md-4 col-sm-4">
		<div style="padding-right: 0;">
			<div class="dynamicDiv" style="margin-bottom:15px;">
				<div class="dynamicDivHead">
					<p class="phead">Login</p>
				</div>
				<form class="form-horizontal" id="loginForm" style="padding:10px;" action="/login" method="post">
			    		<div class="form-group">
				      		<label class="control-label col-sm-4">Username:</label>
				      		<div class="col-sm-8">
							<input type="text" class="form-control" placeholder="Enter username" name="uname" required>
			      			</div>
			    		</div>
				    	<div class="form-group">
					      <label class="control-label col-sm-4">Password:</label>
					      <div class="col-sm-8">
							<input type="password" class="form-control" placeholder="Enter password" name="pass" required>
					      </div>
				    	</div>
				    	<div class="form-group"> 
						<a style="text-decoration:underline;" class="control-label col-sm-5">Forgot Password</a>
						<div class="col-sm-5 pull-right">
							<button type="submit" class="btn btn-default" form="loginForm">Login</button>
				      		</div> 
				      	</div>
				</form>
			</div>
		</div>
		<div style="padding-right: 0;">
			<div class="dynamicDiv">
				<div class="dynamicDivHead">
					<p class="phead">Registration</p>
				</div>
				<form class="form-horizontal" id="registrationForm" style="padding:10px;" action="/registration" method="post">
			    		<div class="form-group">
				      		<label class="control-label col-sm-4">First Name:</label>
				      		<div class="col-sm-8">
							<input type="text" class="form-control" placeholder="Enter name" name="firstName" required></input>
			      			</div>
			    		</div>
			    		<div class="form-group">
				      		<label class="control-label col-sm-4">Last Name:</label>
				      		<div class="col-sm-8">
							<input type="text" class="form-control" placeholder="Enter name" name="lastName" required></input>
			      			</div>
			    		</div>
			    		<div class="form-group">
				      		<label class="control-label col-sm-4">Email:</label>
				      		<div class="col-sm-8">
							<input type="email" class="form-control" placeholder="Enter email" name="email" required></input>
			      			</div>
			    		</div>
			    		<div class="form-group">
				      		<label class="control-label col-sm-4">Username:</label>
				      		<div class="col-sm-8">
							<input type="text" class="form-control" placeholder="Enter username" name="userName" required></input>
			      			</div>
			    		</div>
				    	<div class="form-group">
					      <label class="control-label col-sm-3">Password:</label>
					      <div class="col-sm-9">          
							<input type="password" class="form-control" placeholder="Enter password" name="passWord" required></input>
					      </div>
				    	</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="pwd">Date Of Birth:</label>
							<div class="col-sm-9">
								<input type="date" class="form-control" placeholder="Enter DOB" name="dob" required></input>
							</div>
						</div>
				    	<div class="form-group">
					      <label class="control-label col-sm-3">Photo:</label>
					      <div class="col-sm-9">         
							<input type="file" class="form-control" name="profilePhoto"></input>
					      </div>
				    	</div>
				    	<div class="form-group">       
						<div class="col-sm-5 pull-right">
							<button type="submit" class="btn btn-default" FORM="registrationForm">Register</button>
				      		</div> 
				      	</div>
				</form>
			</div>
		</div>

	</div>
		
	</div>
</body>

</html>
