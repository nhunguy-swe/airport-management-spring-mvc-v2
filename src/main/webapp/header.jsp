<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
    <style>
        body { background-color: #f8f9fa; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }
        .navbar-brand { font-weight: 800; letter-spacing: 1px; }
        .card { border: none; border-radius: 15px; transition: transform 0.3s; }
        .card:hover { transform: translateY(-5px); }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm sticky-top">
    <div class="container">
        <a class="navbar-brand" href="index.jsp text-primary">
            <i class="fas fa-plane-departure me-2"></i>SKY-GEMS AIRPORT
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mainNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="index.jsp"><i class="fas fa-home me-1"></i> Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="chuyen-bay"><i class="fas fa-route me-1"></i> Chuyến bay</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="hanh-khach"><i class="fas fa-users me-1"></i> Hành khách</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ve-may-bay"><i class="fas fa-ticket-alt me-1"></i> Vé máy bay</a>
                </li>
            </ul>
        </div>
    </div>
</nav>