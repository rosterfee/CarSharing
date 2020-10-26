<!DOCTYPE html>
<html lang="en">
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
<!--    <link rel="stylesheet" href="https://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
</head>
<body class="bg-info">
<section class="container">
    <div class="row">

        <div class="col-md-12">
            <div class="panel bg-light mt-5 rounded">
                <div class="panel-body pt-3 pr-2 pl-2">
                    <textarea class="form-control" rows="2" placeholder="Добавьте Ваш отзыв" name="comment"></textarea>
                    <div class="mar-top clearfix pb-2 pr-2">
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
                    <div class="media-block row bg-light mt-5 pt-2 pr-2 pl-2 rounded">
                        <a class="media-left" href="#"><img class="img-circle img-sm" alt="Профиль пользователя" style="width: 75px"
                                                            src="https://bootstraptema.ru/snippets/icons/2016/mia/1.png"></a>
                        <div class="media-body">
                            <div class="mar-btm col-md-3">
                                <a href="#" class="btn-link text-semibold media-heading box-inline">Максим</a>
                                <p class="text-muted text-sm"><i class="fa fa-mobile fa-lg"></i> - 19-06-2016</p>
                            </div>
                            <div class="col-md-9">
                            <p>Секция с комментариями для сайта с подключенным Bootstrap!!!</p>
                            </div>
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
