<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home - Online Library</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            padding-top: 60px; /* Ensure content below navbar */
        }
        .book-card img {
            width: 100%;
            height: 200px;
            object-fit: cover;
        }
        .book-card {
            margin-bottom: 20px;
        }
        .book-description {
            height: 40px;
            overflow: hidden;
        }
        .sidebar {
            height: 100%;
            width: 0;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: white; /* White background for sidebar */
            overflow-x: hidden;
            transition: 0.5s;
            padding-top: 60px;
        }
        .sidebar a {
            padding: 10px 15px;
            text-decoration: none;
            font-size: 18px;
            color: black; /* Black text for sidebar links */
            display: block;
            transition: 0.3s;
        }
        .sidebar a:hover {
            background-color: #f8f9fa; /* Light gray background on hover */
        }
        .sidebar .closebtn {
            position: absolute;
            top: 0;
            right: 25px;
            font-size: 36px;
            margin-left: 50px;
            color: black; /* Black close button */
        }
        .open-sidebar {
            width: 250px;
        }
        .navbar {
            background-color: #007bff; /* Blue navbar */
            margin-bottom: 20px; /* Increase margin bottom */
        }
        .navbar-nav .nav-item {
            margin-right: 20px; /* Increase margin between navbar items */
        }
        .navbar-nav .nav-link {
            transition: 0.3s;
            color: white; /* White text for navbar links */
            margin-left: 20px; /* Increase margin left */
        }
        .navbar-nav .nav-link:hover {
            color: #f8f9fa; /* Lighter white on hover */
        }
        #myLibraryText {
            font-size: 36px;
            font-weight: bold;
            text-align: center;
            margin-bottom: 40px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <!-- Big Text -->
    <div id="myLibraryText">
        MY LIBRARY
    </div>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#" onmouseover="openNav()" onmouseout="closeNav()">Menu</a>
            </li>
        </ul>
        <a class="navbar-brand" href="#">Online Library</a>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <img src="https://t3.ftcdn.net/jpg/02/43/12/34/360_F_243123463_zTooub557xEWABDLk0jJklDyLSGl2jrr.jpg" alt="Profile" class="rounded-circle" width="40">
                    John Doe <!-- Replace with actual user name -->
                </a>
            </li>
        </ul>
    </nav>

    <!-- Sidebar -->
    <div id="mySidebar" class="sidebar" onmouseover="keepOpen()" onmouseout="closeNav()">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="#">Profile</a>
        <a href="authors">Authors</a>
        <a href="users">Users</a>
        <a href="genres">Genres</a>
        <!-- Add more as needed -->
        <a href="logout">Logout</a>
    </div>

    <!-- Filter Section -->
    <div class="row mt-4">
        <div class="col-md-3">
            <div class="form-group">
                <label for="filterAuthor">Filter by Author</label>
                <select id="filterAuthor" class="form-control">
                    <option value="">All Authors</option>
                    <c:forEach var="author" items="${authors}">
                        <option value="${author.id}">${author.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-group">
                <label for="filterGenre">Filter by Genre</label>
                <select id="filterGenre" class="form-control">
                    <option value="">All Genres</option>
                    <c:forEach var="genre" items="${genres}">
                        <option value="${genre.id}">${genre.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-group">
                <label for="filterUploader">Filter by Uploader</label>
                <select id="filterUploader" class="form-control">
                    <option value="">All Uploaders</option>
                    <c:forEach var="uploader" items="${uploaders}">
                        <option value="${uploader.id}">${uploader.name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="col-md-3">
            <div class="form-group">
                <label for="searchTitle">Search by Title</label>
                <input type="text" id="searchTitle" class="form-control" placeholder="Enter book title">
            </div>
        </div>
    </div>

    <!-- Book Display -->
    <div class="row mt-4">
        <c:forEach var="book" items="${books}" varStatus="status">
            <div class="col-md-3">
                <div class="card book-card">
                    <img src="${book.image}" alt="${book.title}" class="card-img-top">
                    <div class="card-body">
                        <h5 class="card-title">${book.title}</h5>
                        <p class="card-text book-description">${fn:substring(book.description, 0, 100)}...</p>
                        <p class="card-text"><strong>Author:</strong> ${book.authorName}</p>
                        <p class="card-text"><strong>Genre:</strong> ${book.genreName}</p>
                        <p class="card-text"><strong>Published:</strong> ${book.publishedYear}</p>
                        <p class="card-text">
                            <strong>Uploader:</strong>
                            <img src="${book.uploaderPicture}" alt="Uploader" class="rounded-circle" width="30">
                                ${book.uploaderName}
                        </p>
                    </div>
                </div>
            </div>
            <c:if test="${status.index % 4 == 3}">
                <div class="w-100"></div> <!-- Ensure 4 columns per row -->
            </c:if>
        </c:forEach>
    </div>

    <!-- Pagination -->
    <div class="row mt-4">
        <div class="col-md-12">
            <nav>
                <ul class="pagination justify-content-center">
                    <li class="page-item">
                        <a class="page-link" href="?page=${currentPage - 1}" aria-label="Previous" <c:if test="${currentPage <= 1}">disabled</c:if>>
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:forEach var="page" begin="1" end="${totalPages}">
                        <li class="page-item <c:if test="${page == currentPage}">active</c:if>">
                            <a class="page-link" href="?page=${page}">${page}</a>
                        </li>
                    </c:forEach>
                    <li class="page-item">
                        <a class="page-link" href="?page=${currentPage + 1}" aria-label="Next" <c:if test="${currentPage >= totalPages}">disabled</c:if>>
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    function openNav() {
        document.getElementById("mySidebar").style.width = "250px";
    }
    function closeNav() {
        document.getElementById("mySidebar").style.width = "0";
    }
    function keepOpen() {
        document.getElementById("mySidebar").style.width = "250px";
    }

    // Add JavaScript for filters and search functionality
    document.getElementById('filterAuthor').addEventListener('change', function() {
        // Implement filtering by author
    });

    document.getElementById('filterGenre').addEventListener('change', function() {
        // Implement filtering by genre
    });

    document.getElementById('filterUploader').addEventListener('change', function() {
        // Implement filtering by uploader
    });

    document.getElementById('searchTitle').addEventListener('input', function() {
        // Implement searching by title
    });
</script>
</body>
</html>
