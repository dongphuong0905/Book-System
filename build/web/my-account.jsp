<%@page import="DAO.OrderDAO"%>
<%@page import="DAO.OrderStatusDAO"%>
<%@page import="DAO.CityDAO"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/mutual_bars/header.jsp" %>
<c:if test="${CurrUser == null}">
    <c:redirect url="GetAllBook"/>
</c:if>
<%@ include file="/mutual_bars/site-header.jsp" %>
<jsp:include page="viewallorder"></jsp:include>
    <div class="site-mobile-menu">
        <header class="mobile-header d-block d-lg-none pt--10 pb-md--10">
            <div class="container">
                <div class="row align-items-sm-end align-items-center">
                    <div class="col-md-4 col-7">
                        <a href="index-user.jsp" class="site-brand">
                            <img src="image/logo.png" alt="">
                        </a>
                    </div>
                    <div class="col-md-5 order-3 order-md-2">
                        <nav class="category-nav   ">
                            <div>
                                <a href="javascript:void(0)" class="category-trigger"><i
                                        class="fa fa-bars"></i>Browse
                                    categories</a>
                                <ul class="category-menu">
                                    <li class="cat-item has-children">
                                        <a href="#">Arts & Photography</a>
                                        <ul class="sub-menu">
                                            <li><a href="#">Bags & Cases</a></li>
                                            <li><a href="#">Binoculars & Scopes</a></li>
                                            <li><a href="#">Digital Cameras</a></li>
                                            <li><a href="#">Film Photography</a></li>
                                            <li><a href="#">Lighting & Studio</a></li>
                                        </ul>
                                    </li>
                                    <li class="cat-item has-children mega-menu"><a href="#">Biographies</a>
                                        <ul class="sub-menu">
                                            <li class="single-block">
                                                <h3 class="title">WHEEL SIMULATORS</h3>
                                                <ul>
                                                    <li><a href="#">Bags & Cases</a></li>
                                                    <li><a href="#">Binoculars & Scopes</a></li>
                                                    <li><a href="#">Digital Cameras</a></li>
                                                    <li><a href="#">Film Photography</a></li>
                                                    <li><a href="#">Lighting & Studio</a></li>
                                                </ul>
                                            </li>
                                            <li class="single-block">
                                                <h3 class="title">WHEEL SIMULATORS</h3>
                                                <ul>
                                                    <li><a href="#">Bags & Cases</a></li>
                                                    <li><a href="#">Binoculars & Scopes</a></li>
                                                    <li><a href="#">Digital Cameras</a></li>
                                                    <li><a href="#">Film Photography</a></li>
                                                    <li><a href="#">Lighting & Studio</a></li>
                                                </ul>
                                            </li>
                                            <li class="single-block">
                                                <h3 class="title">WHEEL SIMULATORS</h3>
                                                <ul>
                                                    <li><a href="#">Bags & Cases</a></li>
                                                    <li><a href="#">Binoculars & Scopes</a></li>
                                                    <li><a href="#">Digital Cameras</a></li>
                                                    <li><a href="#">Film Photography</a></li>
                                                    <li><a href="#">Lighting & Studio</a></li>
                                                </ul>
                                            </li>
                                            <li class="single-block">
                                                <h3 class="title">WHEEL SIMULATORS</h3>
                                                <ul>
                                                    <li><a href="#">Bags & Cases</a></li>
                                                    <li><a href="#">Binoculars & Scopes</a></li>
                                                    <li><a href="#">Digital Cameras</a></li>
                                                    <li><a href="#">Film Photography</a></li>
                                                    <li><a href="#">Lighting & Studio</a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                    <li class="cat-item has-children"><a href="#">Business & Money</a>
                                        <ul class="sub-menu">
                                            <li><a href="#">Brake Tools</a></li>
                                            <li><a href="#">Driveshafts</a></li>
                                            <li><a href="#">Emergency Brake</a></li>
                                            <li><a href="#">Spools</a></li>
                                        </ul>
                                    </li>
                                    <li class="cat-item has-children"><a href="#">Calendars</a>
                                        <ul class="sub-menu">
                                            <li><a href="#">Brake Tools</a></li>
                                            <li><a href="#">Driveshafts</a></li>
                                            <li><a href="#">Emergency Brake</a></li>
                                            <li><a href="#">Spools</a></li>
                                        </ul>
                                    </li>
                                    <li class="cat-item has-children"><a href="#">Children's Books</a>
                                        <ul class="sub-menu">
                                            <li><a href="#">Brake Tools</a></li>
                                            <li><a href="#">Driveshafts</a></li>
                                            <li><a href="#">Emergency Brake</a></li>
                                            <li><a href="#">Spools</a></li>
                                        </ul>
                                    </li>
                                    <li class="cat-item has-children"><a href="#">Comics</a>
                                        <ul class="sub-menu">
                                            <li><a href="#">Brake Tools</a></li>
                                            <li><a href="#">Driveshafts</a></li>
                                            <li><a href="#">Emergency Brake</a></li>
                                            <li><a href="#">Spools</a></li>
                                        </ul>
                                    </li>
                                    <li class="cat-item"><a href="#">Perfomance Filters</a></li>
                                    <li class="cat-item has-children"><a href="#">Cookbooks</a>
                                        <ul class="sub-menu">
                                            <li><a href="#">Brake Tools</a></li>
                                            <li><a href="#">Driveshafts</a></li>
                                            <li><a href="#">Emergency Brake</a></li>
                                            <li><a href="#">Spools</a></li>
                                        </ul>
                                    </li>
                                    <li class="cat-item "><a href="#">Accessories</a></li>
                                    <li class="cat-item "><a href="#">Education</a></li>
                                    <li class="cat-item hidden-menu-item"><a href="#">Indoor Living</a></li>
                                    <li class="cat-item"><a href="#" class="js-expand-hidden-menu">More
                                            Categories</a></li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                    <div class="col-md-3 col-5  order-md-3 text-right">
                        <div class="mobile-header-btns header-top-widget">
                            <ul class="header-links">
                                <li class="sin-link">
                                    <a href="cart.html" class="cart-link link-icon"><i class="ion-bag"></i></a>
                                </li>
                                <li class="sin-link">
                                    <a href="javascript:" class="link-icon hamburgur-icon off-canvas-btn"><i
                                            class="ion-navicon"></i></a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!--Off Canvas Navigation Start-->
        <aside class="off-canvas-wrapper">
            <div class="btn-close-off-canvas">
                <i class="ion-android-close"></i>
            </div>
            <div class="off-canvas-inner">
                <!-- search box start -->
                <div class="search-box offcanvas">
                    <form>
                        <input type="text" placeholder="Search Here">
                        <button class="search-btn"><i class="ion-ios-search-strong"></i></button>
                    </form>
                </div>
                <!-- search box end -->
                <!-- mobile menu start -->
                <div class="mobile-navigation">
                    <!-- mobile menu navigation start -->
                    <nav class="off-canvas-nav">
                        <ul class="mobile-menu main-mobile-menu">
                            <li class="menu-item-has-children">
                                <a href="#">Home</a>
                                <ul class="sub-menu">
                                    <li> <a href="index-user.jsp">Home One</a></li>
                                    <li> <a href="index-2.html">Home Two</a></li>
                                    <li> <a href="index-3.html">Home Three</a></li>
                                    <li> <a href="index-4.html">Home Four</a></li>
                                </ul>
                            </li>
                            <li class="menu-item-has-children">
                                <a href="#">Blog</a>
                                <ul class="sub-menu">
                                    <li class="menu-item-has-children">
                                        <a href="#">Blog Grid</a>
                                        <ul class="sub-menu">
                                            <li><a href="blog.html">Full Widh (Default)</a></li>
                                            <li><a href="blog-left-sidebar.html">left Sidebar</a></li>
                                            <li><a href="blog-right-sidebar.html">Right Sidebar</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="#">Blog List</a>
                                        <ul class="sub-menu">
                                            <li><a href="blog-list.html">Full Widh (Default)</a></li>
                                            <li><a href="blog-list-left-sidebar.html">left Sidebar</a></li>
                                            <li><a href="blog-list-right-sidebar.html">Right Sidebar</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="#">Blog Details</a>
                                        <ul class="sub-menu">
                                            <li><a href="blog-details.html">Image Format (Default)</a></li>
                                            <li><a href="blog-details-gallery.html">Gallery Format</a></li>
                                            <li><a href="blog-details-audio.html">Audio Format</a></li>
                                            <li><a href="blog-details-video.html">Video Format</a></li>
                                            <li><a href="blog-details-left-sidebar.html">left Sidebar</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li class="menu-item-has-children">
                                <a href="#">Shop</a>
                                <ul class="sub-menu">
                                    <li class="menu-item-has-children">
                                        <a href="#">Shop Grid</a>
                                        <ul class="sub-menu">
                                            <li><a href="shop-grid.html">Fullwidth</a></li>
                                            <li><a href="shop-grid-left-sidebar.html">left Sidebar</a></li>
                                            <li><a href="shop-grid-right-sidebar.html">Right Sidebar</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="#">Shop List</a>
                                        <ul class="sub-menu">
                                            <li><a href="shop-list.html">Fullwidth</a></li>
                                            <li><a href="shop-list-left-sidebar.html">left Sidebar</a></li>
                                            <li><a href="shop-list-right-sidebar.html">Right Sidebar</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="#">Product Details 1</a>
                                        <ul class="sub-menu">
                                            <li><a href="product-details.html">Product Details Page</a></li>
                                            <li><a href="product-details-affiliate.html">Product Details
                                                    Affiliate</a></li>
                                            <li><a href="product-details-group.html">Product Details Group</a></li>
                                            <li><a href="product-details-variable.html">Product Details
                                                    Variables</a></li>
                                        </ul>
                                    </li>
                                    <li class="menu-item-has-children">
                                        <a href="#">Product Details 2</a>
                                        <ul class="sub-menu">
                                            <li><a href="product-details-left-thumbnail.html">left Thumbnail</a>
                                            </li>
                                            <li><a href="product-details-right-thumbnail.html">Right Thumbnail</a>
                                            </li>
                                            <li><a href="product-details-left-gallery.html">Left Gallery</a></li>
                                            <li><a href="product-details-right-gallery.html">Right Gallery</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li class="menu-item-has-children">
                                <a href="#">Pages</a>
                                <ul class="sub-menu">
                                    <li><a href="cart.html">Cart</a></li>
                                    <li><a href="checkout.html">Checkout</a></li>
                                    <li><a href="compare.html">Compare</a></li>
                                    <li><a href="wishlist.html">Wishlist</a></li>
                                    <li><a href="login-register.html">Login Register</a></li>
                                    <li><a href="my-account.html">My Account</a></li>
                                    <li><a href="order-complete.html">Order Complete</a></li>
                                    <li><a href="faq.html">Faq</a></li>
                                    <li><a href="contact-2.html">contact 02</a></li>
                                </ul>
                            </li>
                            <li><a href="contact.html">Contact</a></li>
                        </ul>
                    </nav>
                    <!-- mobile menu navigation end -->
                </div>
                <!-- mobile menu end -->
                <nav class="off-canvas-nav">
                    <ul class="mobile-menu menu-block-2">
                        <li class="menu-item-has-children">
                            <a href="#">Currency - USD $ <i class="fas fa-angle-down"></i></a>
                            <ul class="sub-menu">
                                <li> <a href="cart.html">USD $</a></li>
                                <li> <a href="checkout.html">EUR â¬</a></li>
                            </ul>
                        </li>
                        <li class="menu-item-has-children">
                            <a href="#">Lang - Eng<i class="fas fa-angle-down"></i></a>
                            <ul class="sub-menu">
                                <li>Eng</li>
                                <li>Ban</li>
                            </ul>
                        </li>
                        <li class="menu-item-has-children">
                            <a href="#">My Account <i class="fas fa-angle-down"></i></a>
                            <ul class="sub-menu">
                                <li><a href="#">My Account</a></li>
                                <li><a href="#">Order History</a></li>
                                <li><a href="#">Transactions</a></li>
                                <li><a href="#">Downloads</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
                <div class="off-canvas-bottom">
                    <div class="contact-list mb--10">
                        <a href="#" class="sin-contact"><i class="fas fa-mobile-alt"></i>(12345) 78790220</a>
                        <a href="#" class="sin-contact"><i class="fas fa-envelope"></i>examle@handart.com</a>
                    </div>
                    <div class="off-canvas-social">
                        <a href="#" class="single-icon"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="single-icon"><i class="fab fa-twitter"></i></a>
                        <a href="#" class="single-icon"><i class="fas fa-rss"></i></a>
                        <a href="#" class="single-icon"><i class="fab fa-youtube"></i></a>
                        <a href="#" class="single-icon"><i class="fab fa-google-plus-g"></i></a>
                        <a href="#" class="single-icon"><i class="fab fa-instagram"></i></a>
                    </div>
                </div>
            </div>
        </aside>
        <!--Off Canvas Navigation End-->
    </div>
    <div class="sticky-init fixed-header common-sticky">
        <div class="container d-none d-lg-block">
            <div class="row align-items-center">
                <div class="col-lg-4">
                    <a href="index-user.jsp" class="site-brand">
                        <img src="image/logo.png" alt="">
                    </a>
                </div>
                <div class="col-lg-8">
                    <div class="main-navigation flex-lg-right">
                        <ul class="main-menu menu-right ">
                            <li class="menu-item has-children">
                                <a href="javascript:void(0)">Home <i
                                        class="fas fa-chevron-down dropdown-arrow"></i></a>
                                <ul class="sub-menu">
                                    <li> <a href="index-user.jsp">Home One</a></li>
                                    <li> <a href="index-2.html">Home Two</a></li>
                                    <li> <a href="index-3.html">Home Three</a></li>
                                    <li> <a href="index-4.html">Home Four</a></li>
                                </ul>
                            </li>
                            <!-- Shop -->
                            <li class="menu-item has-children mega-menu">
                                <a href="javascript:void(0)">shop <i
                                        class="fas fa-chevron-down dropdown-arrow"></i></a>
                                <ul class="sub-menu four-column">
                                    <li class="cus-col-25">
                                        <h3 class="menu-title"><a href="javascript:void(0)">Shop Grid </a></h3>
                                        <ul class="mega-single-block">
                                            <li><a href="shop-grid.html">Fullwidth</a></li>
                                            <li><a href="shop-grid-left-sidebar.html">left Sidebar</a></li>
                                            <li><a href="shop-grid-right-sidebar.html">Right Sidebar</a></li>
                                        </ul>
                                    </li>
                                    <li class="cus-col-25">
                                        <h3 class="menu-title"> <a href="javascript:void(0)">Shop List</a></h3>
                                        <ul class="mega-single-block">
                                            <li><a href="shop-list.html">Fullwidth</a></li>
                                            <li><a href="shop-list-left-sidebar.html">left Sidebar</a></li>
                                            <li><a href="shop-list-right-sidebar.html">Right Sidebar</a></li>
                                        </ul>
                                    </li>
                                    <li class="cus-col-25">
                                        <h3 class="menu-title"> <a href="javascript:void(0)">Product Details 1</a>
                                        </h3>
                                        <ul class="mega-single-block">
                                            <li><a href="product-details.html">Product Details Page</a></li>
                                            <li><a href="product-details-affiliate.html">Product Details
                                                    Affiliate</a></li>
                                            <li><a href="product-details-group.html">Product Details Group</a></li>
                                            <li><a href="product-details-variable.html">Product Details
                                                    Variables</a></li>
                                        </ul>
                                    </li>
                                    <li class="cus-col-25">
                                        <h3 class="menu-title"><a href="javascript:void(0)">Product Details 2</a>
                                        </h3>
                                        <ul class="mega-single-block">
                                            <li><a href="product-details-left-thumbnail.html">left Thumbnail</a>
                                            </li>
                                            <li><a href="product-details-right-thumbnail.html">Right Thumbnail</a>
                                            </li>
                                            <li><a href="product-details-left-gallery.html">Left Gallery</a></li>
                                            <li><a href="product-details-right-gallery.html">Right Gallery</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <!-- Pages -->
                            <li class="menu-item has-children">
                                <a href="javascript:void(0)">Pages <i
                                        class="fas fa-chevron-down dropdown-arrow"></i></a>
                                <ul class="sub-menu">
                                    <li><a href="cart.html">Cart</a></li>
                                    <li><a href="checkout.html">Checkout</a></li>
                                    <li><a href="compare.html">Compare</a></li>
                                    <li><a href="wishlist.html">Wishlist</a></li>
                                    <li><a href="login-register.html">Login Register</a></li>
                                    <li><a href="my-account.html">My Account</a></li>
                                    <li><a href="order-complete.html">Order Complete</a></li>
                                    <li><a href="faq.html">Faq</a></li>
                                    <li><a href="contact-2.html">contact 02</a></li>
                                </ul>
                            </li>
                            <!-- Blog -->
                            <li class="menu-item has-children mega-menu">
                                <a href="javascript:void(0)">Blog <i
                                        class="fas fa-chevron-down dropdown-arrow"></i></a>
                                <ul class="sub-menu three-column">
                                    <li class="cus-col-33">
                                        <h3 class="menu-title"><a href="javascript:void(0)">Blog Grid</a></h3>
                                        <ul class="mega-single-block">
                                            <li><a href="blog.html">Full Widh (Default)</a></li>
                                            <li><a href="blog-left-sidebar.html">left Sidebar</a></li>
                                            <li><a href="blog-right-sidebar.html">Right Sidebar</a></li>
                                        </ul>
                                    </li>
                                    <li class="cus-col-33">
                                        <h3 class="menu-title"><a href="javascript:void(0)">Blog List </a></h3>
                                        <ul class="mega-single-block">
                                            <!-- <li><a href="blog-list.html">Full Widh (Default)</a></li> -->
                                            <li><a href="blog-list-left-sidebar.html">left Sidebar</a></li>
                                            <li><a href="blog-list-right-sidebar.html">Right Sidebar</a></li>
                                        </ul>
                                    </li>
                                    <li class="cus-col-33">
                                        <h3 class="menu-title"><a href="javascript:void(0)">Blog Details</a></h3>
                                        <ul class="mega-single-block">
                                            <li><a href="blog-details.html">Image Format (Default)</a></li>
                                            <li><a href="blog-details-gallery.html">Gallery Format</a></li>
                                            <li><a href="blog-details-audio.html">Audio Format</a></li>
                                            <li><a href="blog-details-video.html">Video Format</a></li>
                                            <li><a href="blog-details-left-sidebar.html">left Sidebar</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li class="menu-item">
                                <a href="contact.html">Contact</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <section class="breadcrumb-section">
        <h2 class="sr-only">Site Breadcrumb</h2>
        <div class="container">
            <div class="breadcrumb-contents">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="index-user.jsp">Home</a></li>
                        <li class="breadcrumb-item active">My Account</li>
                    </ol>
                </nav>
            </div>
        </div>
    </section>
    <div class="page-section inner-page-sec-padding">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="row">
                        <!-- My Account Tab Menu Start -->
                        <div class="col-lg-3 col-12">
                            <div class="myaccount-tab-menu nav" role="tablist">
                                <a href="#dashboad" class="active" data-toggle="tab"><i
                                        class="fas fa-tachometer-alt"></i>
                                    Dashboard</a>
                                <a href="#orders" data-toggle="tab"><i class="fa fa-cart-arrow-down"></i> Orders</a>
                                <a href="#download" data-toggle="tab"><i class="fas fa-download"></i> Download</a>
                                <a href="#payment-method" data-toggle="tab"><i class="fa fa-credit-card"></i>
                                    Payment
                                    Method</a>
                                <a href="#address-edit" data-toggle="tab"><i class="fa fa-map-marker"></i>
                                    Password</a>
                                <a href="#account-info" data-toggle="tab"><i class="fa fa-user"></i> Account
                                    Details</a>
                                <a href="Logout"><i class="fas fa-sign-out-alt"></i> Logout</a>
                            </div>
                        </div>
                        <!-- My Account Tab Menu End -->
                        <!-- My Account Tab Content Start -->
                        <div class="col-lg-9 col-12 mt--30 mt-lg--0">
                            <div class="tab-content" id="myaccountContent">
                                <!-- Single Tab Content Start -->
                                <div class="tab-pane fade show active" id="dashboad" role="tabpanel">
                                    <div class="myaccount-content">
                                        <h3>Dashboard</h3>
                                        <div class="welcome mb-20">
                                            <p>Hello, <strong>${CurrUser.firstname} ${CurrUser.lastname}</strong> (If Not <strong>${CurrUser.firstname}!</strong> <a href="Logout" style="font-style: italic" class="logout">
                                                Logout</a>)</p>
                                    </div>
                                    <p class="mb-0">From your account dashboard. you can easily check &amp; view
                                        your
                                        recent orders, manage your shipping and billing addresses and edit your
                                        password and account details.</p>
                                </div>
                            </div>
                            <!-- Single Tab Content End -->
                            <!-- Single Tab Content Start -->
                            <div class="tab-pane fade" id="orders" role="tabpanel">
                                <div class="myaccount-content">
                                    <h3>Orders</h3>
                                    <div class="myaccount-table table-responsive text-center">
                                        <table class="table table-bordered">
                                            <thead class="thead-light">                                                
                                                <tr>
                                                    <th>No</th>
                                                    <th>Order Number</th>
                                                    <th>Date</th>
                                                    <th>Status</th>
                                                    <th>Total</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:set var="i" value="1"></c:set>
                                                <c:forEach var="order" items="${orderList}">
                                                    <tr>
                                                        <td>${i}</td>
                                                        <td>${order.id}</td>
                                                        <td>${order.orderDate}</td> 
                                                        <td>${order.payStatus}</td>
                                                        <td>$${order.totalPrice}</td>
                                                        <td><a href="vieworderedcart?orderId=${order.id}" class="btn">View</a></td>
                                                        <c:set var="i" value="${i + 1}"></c:set>
                                                        </tr>
                                                </c:forEach> 
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!-- Single Tab Content End -->
                            <!-- Single Tab Content Start -->
                            <div class="tab-pane fade" id="download" role="tabpanel">
                                <div class="myaccount-content">
                                    <h3>Downloads</h3>
                                    <div class="myaccount-table table-responsive text-center">
                                        <table class="table table-bordered">
                                            <thead class="thead-light">
                                                <tr>
                                                    <th>Product</th>
                                                    <th>Date</th>
                                                    <th>Expire</th>
                                                    <th>Download</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>Mostarizing Oil</td>
                                                    <td>Aug 22, 2018</td>
                                                    <td>Yes</td>
                                                    <td><a href="#" class="btn">Download File</a></td>
                                                </tr>
                                                <tr>
                                                    <td>Katopeno Altuni</td>
                                                    <td>Sep 12, 2018</td>
                                                    <td>Never</td>
                                                    <td><a href="#" class="btn">Download File</a></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <!-- Single Tab Content End -->
                            <!-- Single Tab Content Start -->
                            <div class="tab-pane fade" id="payment-method" role="tabpanel">
                                <div class="myaccount-content">
                                    <h3>Payment Method</h3>
                                    <p class="saved-message">You Can't Saved Your Payment Method yet.</p>
                                </div>
                            </div>
                            <!-- Single Tab Content End -->
                            <!-- Single Tab Content Start -->
                            <div class="tab-pane fade" id="address-edit" role="tabpanel">
                                <div class="myaccount-content">
                                    <h3>Change Password</h3>
                                    <form action="ChangePass" method="post">
                                        <div class="row">
                                            <div class="col-lg-6 col-12  mb--30">
                                                <input id="current-pwd" placeholder="Current Password"
                                                       type="password" name="curPass">
                                            </div>
                                            <div class="col-lg-6 col-12  mb--30">
                                                <input id="new-pwd" placeholder="New Password"
                                                       type="password" name="newPass">
                                            </div>
                                            <div class="col-lg-6 col-12  mb--30">
                                                <input id="confirm-pwd" placeholder="Confirm Password"
                                                       type="password" name="confPass">
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <button class="btn btn--primary" type="submit"><i class="fa fa-edit"></i>Save Changes</button>
                                        </div>
                                        <input hidden value="${CurrUser.userId}" name="userId"/>
                                        <c:if test="${stt=="true"}">
                                            <div style="color:green">${msg}</div>
                                        </c:if>
                                        <c:if test="${stt=="false"}">
                                            <div style="color:red">${msg}</div>
                                        </c:if>
                                    </form>
                                </div>
                            </div>
                            <!-- Single Tab Content End -->
                            <!-- Single Tab Content Start -->
                            <div class="tab-pane fade" id="account-info" role="tabpanel">
                                <div class="myaccount-content">
                                    <h3>Account Details</h3>
                                    <div class="account-details-form">
                                        <form action="UpdateInf">
                                            <div class="row">
                                                <div class="col-lg-6 col-12  mb--30">
                                                    <input id="first-name" placeholder="First Name" value="${CurrUser.firstname}" type="text"
                                                           name="firstname">
                                                </div>
                                                <div class="col-lg-6 col-12  mb--30">
                                                    <input id="last-name" placeholder="Last Name" value="${CurrUser.lastname}" type="text"
                                                           name="lastname">
                                                </div>
                                                <div class="col-12  mb--30">
                                                    <input id="display-name" placeholder="Display Name" value="${CurrUser.userAccount}"
                                                           type="text" name="userAccount">
                                                </div>
                                                <div class="col-12  mb--30">
                                                    <input id="email" placeholder="Email Address" value="${CurrUser.email}" type="email"
                                                           name="email" disabled="true">
                                                </div>
                                                <div class="col-12  mb--30">
                                                    <input id="phone" placeholder="Phone Number" value="${CurrUser.phoneNumber}" type="text"
                                                           name="phone">
                                                </div>
                                                <div class="col-12  mb--30">
                                                    <label>City/Province</label>
                                                    <select class="nice-select" name="city">
                                                        <c:forEach var="i" items="<%=CityDAO.getCities()%>">
                                                            <c:choose>
                                                                <c:when test="${CurrUser.address.city.id == i.id}"><option value="${i.id}" selected>${i.name}</option></c:when>
                                                                <c:when test="${CurrUser.address.city.id != i.id}"><option value="${i.id}">${i.name}</option></c:when> 
                                                            </c:choose>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-12  mb--30">
                                                    <input id="address" placeholder="Address" value="${CurrUser.address.address}" type="text"
                                                           name="address">
                                                </div>
                                                <div class="col-12  mb--30">
                                                    <input id="birthday" value="${CurrUser.birthday}" type="date" name="birthday">
                                                </div>
                                                <div class="col-12">
                                                    <button class="btn btn--primary" type="submit">Save Changes</button>
                                                </div>

                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <!-- Single Tab Content End -->
                        </div>
                    </div>
                    <!-- My Account Tab Content End -->
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!--=================================
Brands Slider
===================================== -->
<section class="section-margin">
    <h2 class="sr-only">Brand Slider</h2>
    <div class="container">
        <div class="brand-slider sb-slick-slider border-top border-bottom" data-slick-setting='{
             "autoplay": true,
             "autoplaySpeed": 8000,
             "slidesToShow": 6
             }' data-slick-responsive='[
             {"breakpoint":992, "settings": {"slidesToShow": 4} },
             {"breakpoint":768, "settings": {"slidesToShow": 3} },
             {"breakpoint":575, "settings": {"slidesToShow": 3} },
             {"breakpoint":480, "settings": {"slidesToShow": 2} },
             {"breakpoint":320, "settings": {"slidesToShow": 1} }
             ]'>
            <div class="single-slide">
                <img src="image/others/brand-1.jpg" alt="">
            </div>
            <div class="single-slide">
                <img src="image/others/brand-2.jpg" alt="">
            </div>
            <div class="single-slide">
                <img src="image/others/brand-3.jpg" alt="">
            </div>
            <div class="single-slide">
                <img src="image/others/brand-4.jpg" alt="">
            </div>
            <div class="single-slide">
                <img src="image/others/brand-5.jpg" alt="">
            </div>
            <div class="single-slide">
                <img src="image/others/brand-6.jpg" alt="">
            </div>
            <div class="single-slide">
                <img src="image/others/brand-1.jpg" alt="">
            </div>
            <div class="single-slide">
                <img src="image/others/brand-2.jpg" alt="">
            </div>
        </div>
    </div>
</section>
<!--=================================
Footer Area
===================================== -->
<footer class="site-footer">
    <div class="container">
        <div class="row justify-content-between  section-padding">
            <div class=" col-xl-3 col-lg-4 col-sm-6">
                <div class="single-footer pb--40">
                    <div class="brand-footer footer-title">
                        <img src="image/logo--footer.png" alt="">
                    </div>
                    <div class="footer-contact">
                        <p><span class="label">Address:</span><span class="text">Example Street 98, HH2 BacHa, New
                                York, USA</span></p>
                        <p><span class="label">Phone:</span><span class="text">+18088 234 5678</span></p>
                        <p><span class="label">Email:</span><span class="text">suport@hastech.com</span></p>
                    </div>
                </div>
            </div>
            <div class=" col-xl-3 col-lg-2 col-sm-6">
                <div class="single-footer pb--40">
                    <div class="footer-title">
                        <h3>Information</h3>
                    </div>
                    <ul class="footer-list normal-list">
                        <li><a href="#">Prices drop</a></li>
                        <li><a href="#">New products</a></li>
                        <li><a href="#">Best sales</a></li>
                        <li><a href="#">Contact us</a></li>
                        <li><a href="#">Sitemap</a></li>
                    </ul>
                </div>
            </div>
            <div class=" col-xl-3 col-lg-2 col-sm-6">
                <div class="single-footer pb--40">
                    <div class="footer-title">
                        <h3>Extras</h3>
                    </div>
                    <ul class="footer-list normal-list">
                        <li><a href="#">Delivery</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Stores</a></li>
                        <li><a href="#">Contact us</a></li>
                        <li><a href="#">Sitemap</a></li>
                    </ul>
                </div>
            </div>
            <div class=" col-xl-3 col-lg-4 col-sm-6">
                <div class="footer-title">
                    <h3>Newsletter Subscribe</h3>
                </div>
                <div class="newsletter-form mb--30">
                    <form action="https://demo.hasthemes.com/pustok-preview/pustok/php/mail.php">
                        <input type="email" class="form-control" placeholder="Enter Your Email Address Here...">
                        <button class="btn btn--primary w-100">Subscribe</button>
                    </form>
                </div>
                <div class="social-block">
                    <h3 class="title">STAY CONNECTED</h3>
                    <ul class="social-list list-inline">
                        <li class="single-social facebook"><a href="#"><i class="ion ion-social-facebook"></i></a>
                        </li>
                        <li class="single-social twitter"><a href="#"><i class="ion ion-social-twitter"></i></a></li>
                        <li class="single-social google"><a href="#"><i
                                    class="ion ion-social-googleplus-outline"></i></a></li>
                        <li class="single-social youtube"><a href="#"><i class="ion ion-social-youtube"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="footer-bottom">
        <div class="container">
            <p class="copyright-heading">Suspendisse in auctor augue. Cras fermentum est ac fermentum tempor. Etiam
                vel magna volutpat, posuere eros</p>
            <a href="#" class="payment-block">
                <img src="image/icon/payment.png" alt="">
            </a>
            <p class="copyright-text">Copyright Â© 2019 <a href="#" class="author">Pustok</a>. All Right Reserved.
                <br>
                Design By Pustok</p>
        </div>
    </div>
</footer>
<!-- Use Minified Plugins Version For Fast Page Load -->
<script src="js/plugins.js"></script>
<script src="js/ajax-mail.js"></script>
<script src="js/custom.js"></script>
</body>


<!-- Mirrored from demo.hasthemes.com/pustok-preview/pustok/my-account.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 07 Oct 2019 14:09:21 GMT -->
</html>