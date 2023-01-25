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
                <h1 id="mainHead">${headline}</h1>
            </main>

            <aside class="col-sm-4 py-3" id="asideBox">
            </aside>
        </div>
    </div>

    <%@include file="foot.html"%>

    <script>
        let url = "http://localhost:8080/firststeps_war_exploded/submit"

        document.getElementById("mainHead").addEventListener('click', () => {
            fetch(url) // Fragt asynchron Daten vom Server ab. asynchron = ohne die Seite neu zu laden
                .then(res => res.json()) // Das was der Server liefert wird als JSON eingelesen
                .then(out => { // das empfangene JSON wird verarbeitet
                    document.getElementById("asideBox").innerText = out[0].name; // Name des ersten Objektes im out-Array wird in die box1 ausgegeben
                })
                .catch(error => console.log(error)); // Wird aufgerufen, wenn etwas schief läuft
        });
    </script>

</body>
</html>
