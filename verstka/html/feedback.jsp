<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>CarSharing</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
            integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
            crossorigin="anonymous"></script>
    <style>
        .round {
            border-radius: 100px;
            border: 3px solid green;
            box-shadow: 0 0 7px #666;
        }
    </style>
    <link rel="stylesheet" href="https://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
</head>
<body class="bg-info">
<img class="img-fluid" src="../pictures/main_picture.jpg"/>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">CarSharing</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="catalog.jsp">Каталог</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="about_us.html">О нас</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">Отзывы<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Корзина</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="profile.html">Профиль</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Города
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Казань</a>
                    <a class="dropdown-item" href="#">Москва</a>
                    <a class="dropdown-item" href="#">Санкт-Петербург</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<section class="container">
    <div class="row">

        <div class="col-md-12">
            <div class="panel">
                <div class="panel-body">
                    <textarea class="form-control" rows="2" placeholder="Добавьте Ваш отзыв" name="comment"></textarea>
                    <div class="mar-top clearfix">
                        <button class="btn btn-sm btn-primary pull-right mt-4" type="submit"><i
                                class="fa fa-pencil fa-fw"></i> Добавить
                        </button>
                        <a class="btn btn-trans btn-icon fa fa-video-camera add-tooltip" href="#"></a>
                        <a class="btn btn-trans btn-icon fa fa-camera add-tooltip" href="#"></a>
                        <a class="btn btn-trans btn-icon fa fa-file add-tooltip" href="#"></a>
                    </div>
                </div>
            </div>

<!--            <% for (int i = 0; i < 3; i++) {%>-->
            <div class="panel">
                <div class="panel-body">
                    <!-- Содержание Новостей -->
                    <!--===================================================-->
                    <div class="media-block">
                        <a class="media-left" href="#"><img class="img-circle img-sm" alt="Профиль пользователя" style="width: 75px"
                                                            src="https://bootstraptema.ru/snippets/icons/2016/mia/1.png"></a>
                        <div class="media-body">
                            <div class="mar-btm">
                                <a href="#" class="btn-link text-semibold media-heading box-inline">Максим</a>
                                <p class="text-muted text-sm"><i class="fa fa-mobile fa-lg"></i> - 19-06-2016</p>
                            </div>
                            <p>Секция с комментариями для сайта с подключенным Bootstrap!!!</p>
                        </div>
                    </div>
                </div>
            </div>
<!--            <%}%>-->
        </div>
    </div>
</section>
</div>
</body>
</html>
