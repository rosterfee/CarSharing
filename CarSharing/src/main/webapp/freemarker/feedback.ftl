<#ftl encoding="utf-8">

<#import "../headers/admin_header.ftl" as header>

<@header.main>
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

<style>
    .round {
        border-radius: 100px;
        border: 3px solid green;
        box-shadow: 0 0 7px #666;
    }
</style>
<!--    <link rel="stylesheet" href="https://bootstraptema.ru/plugins/2015/bootstrap3/bootstrap.min.css"/>-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
</body>
</@header.main>