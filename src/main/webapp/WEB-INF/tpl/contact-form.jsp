<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <%@include file="head.jsp"%>
<body>
    <%@include file="header.jsp"%>
    <%@include file="main-nav.html"%>

    <div id="content" class="container">
        <div class="row">
            <main class="col-sm-8 py-3">
                <h1>${headline}</h1>

                <form action="submit" method="get">
                    <div class="mb-3">
                        <div class="form-check">
                            <input type="radio" name="title" id="title_1" value="w" class="form-check-input">
                            <label for="title_1" class="form-check-label">Frau</label>
                        </div>
                        <div class="form-check">
                            <input type="radio" name="title" id="title_2" value="m" class="form-check-input">
                            <label for="title_2" class="form-check-label">Herr</label>
                        </div>
                    </div>

                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" name="name" id="name" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="country" class="form-label">Land</label>
                        <select name="country" id="country" class="form-select">
                            <option value="de">Deutschland</option>
                            <option value="es">Spanien</option>
                            <option value="uk">England</option>
                            <option value="us">USA</option>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label for="email" class="form-label">E-Mail</label>
                        <input type="email" name="email" id="email" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="message" class="form-label">Nachricht</label>
                        <textarea name="message" id="message" rows="5" class="form-control"></textarea>
                    </div>
                    <button type="submit" class="btn btn-success">Senden</button>

                </form>
            </main>

            <aside class="col-sm-4 py-3">
                Nebeninhalt
            </aside>
        </div>
    </div>

    <%@include file="foot.html"%>

</body>
</html>
