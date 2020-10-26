<#ftl encoding="utf-8">

<#import "../headers/admin_header.ftl" as header>

<@header.main>
<body class="bg-info">
<div class="container bg center">
    <div class="row main-form" style="margin: 30px 60px">
        <div class="col-md-4">
        </div>
        <div class="col-md-4 mt-5 bg-light rounded">
            <form class="needs-validation mt-3 mb-3" id="signInForm" novalidate method="post" action="/sign_in">
                <div class="form-group">
                    <label for="login">Логин</label>
                    <input class="form-control" id="login" name="login" placeholder="Логин" required>
                    <small id="emailHelp" class="form-text text-muted">Введите логин</small>
                </div>
                <div class="form-group">
                    <label for="userPassword">Пароль</label>
                    <input type="password" class="form-control" name="password" id="userPassword"
                           placeholder="Пароль" required>
                    <small id="emailHelp" class="form-text text-muted">Введите пароль</small>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="checkbox" class="form-check-input" name="remember_me">
                        Запомнить меня
                    </label>
                </div>
                <button type="submit" class="btn btn-primary">Войти</button>
                <a type="button" class="btn btn-primary" href="registration">Регистрация</a>
            </form>
        </div>
    </div>
</div>
</body>
</@header.main>