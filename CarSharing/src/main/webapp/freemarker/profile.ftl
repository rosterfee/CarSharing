<#ftl encoding="utf-8">

<#import "../headers/admin_header.ftl" as header>

<@header.main>
<body class="bg-info">
<div class="mt-5 bg-light container mb-5" rounded>
    <div class="row">
        <div class="col-md-5 mt-5">
            <h3 class="pl-4">Имя пользователя</h3>
            <img class="rounded-circle" width="70%" src="../pictures/porche_911.jpg"></img>
        </div>
        <div class="col-md-7">
            <form class="mt-3 pb-3">
                <div class="fields form-group">
                    <label for="name">Имя:</label>
                    <input type="text" id="name" value="" placeholder="" required disabled>
                    <span class="dot">*</span>
                </div>
                <div class="fields form-group">
                    <label for="surname">Фамилия:</label>
                    <input type="text" id="surname" value="" placeholder="" required disabled>
                    <span class="dot">*</span>
                </div>
                <div class="fields form-group">
                    <label for="email">E-mail:</label>
                    <input type="text" id="email" value="" placeholder="" required disabled>
                    <span class="dot">*</span>
                </div>
                <div class="fields form-group">
                    <label for="phone_number">Номер телефона:</label>
                    <input type="text" id="phone_number" value="" placeholder="" required disabled>
                    <span class="dot">*</span>
                </div>
                <div class="fields form-group">
                    <label for="pass1">Пароль:</label>
                    <input type="password" id="pass1" value="" disabled>
                    <span class="dot">*</span>
                </div>
                <button type="button" class="btn btn-info" onclick="enableForm()" name="button1" id="enable_btn">Изменить данные профиля</button>
                <button type="submit" class="btn btn-info" onclick="disabeleForm()" name="button2" id="disable_btn" disabled>Подтвердить данные</button>
            </form>
        </div>
    </div>
    <div class="row mt-5 pb-3">
        <div class="col-md-12">
            <h2 class="text-center">История заказов</h2>
            <div class="catalog-content">
                <div class="catalog-product">
                    <div class="card" style="width: 25%">
                        <a href="car_profile.ftl"><img class="card-img-top" src="../pictures/gtr.jpg"></img></a>
                        <div class="card-body text-center">
                            Nissan GTR
                            <div>
                                Data:
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="//code.jquery.com/jquery-1.7.min.js"></script>
<style>
    #main {
        background-color: #f2f2f2;
        padding: 20px;
        -webkit-border-radius: 4px;
        -moz-border-radius: 4px;
        -ms-border-radius: 4px;
        -o-border-radius: 4px;
        border-radius: 4px;
        border-bottom: 4px solid #ddd;
    }

    #real-estates-detail #author img {
        -webkit-border-radius: 100%;
        -moz-border-radius: 100%;
        -ms-border-radius: 100%;
        -o-border-radius: 100%;
        border-radius: 100%;
        border: 5px solid #ecf0f1;
        margin-bottom: 10px;
    }

    #real-estates-detail .sosmed-author i.fa {
        width: 30px;
        height: 30px;
        border: 2px solid #bdc3c7;
        color: #bdc3c7;
        padding-top: 6px;
        margin-top: 10px;
    }

    .panel-default .panel-heading {
        background-color: #fff;
    }

    #real-estates-detail .slides li img {
        height: 450px;
    }
</style>

<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.2/dist/jquery.validate.js"></script>
<script>
    $('#signInForm').validate({
        rules: {
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 8,
            }
        },
        messages: {
            email: {
                required: 'Заполните поле',
                email: 'Введите корректный email'
            },
            password: {
                required: 'Заполните поле',
                minlength: jQuery.validator.format('Минимальная длинна {0} символов'),
            }
        }
    });
</script>
<script>
    function enableForm() {
        document.getElementById('phone_number').removeAttribute('disabled');
        document.getElementById('name').removeAttribute('disabled');
        document.getElementById('surname').removeAttribute('disabled');
        document.getElementById('email').removeAttribute('disabled');
        document.getElementById('pass1').removeAttribute('disabled');
        document.getElementById('disable_btn').removeAttribute('disabled');
        document.getElementById('enable_btn').setAttribute('disabled', '');
    }
    function disabeleForm() {
        document.getElementById('phone_number').setAttribute('disabled', '');
        document.getElementById('name').setAttribute('disabled', '');
        document.getElementById('surname').setAttribute('disabled', '');
        document.getElementById('email').setAttribute('disabled', '');
        document.getElementById('pass1').setAttribute('disabled', '');
        document.getElementById('enable_btn').removeAttribute('disabled');
        document.getElementById('disable_btn').setAttribute('disabled', '');
    }
</script>
</body>
</@header.main>