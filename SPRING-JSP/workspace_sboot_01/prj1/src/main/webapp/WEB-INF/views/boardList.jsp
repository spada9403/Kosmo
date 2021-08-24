<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//w3c//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Board List!!</title>
    <script src="/resources/jquery-3.6.0.min.js" type="text/javascript"></script>
    <script>
      function goBoardRegForm() {
        location.replace("/boardRegForm.do");
      }
      function paintList(trObj) {
        var visibleTrObj = trObj.not(":first-child").filter(":visible");
        var oddTr = visibleTrObj.filter(":odd");
        var evenTr = visibleTrObj.filter(":even");
        oddTr.css({
          "background-color": "#FBE7C6",
        });
        evenTr.css({
          "background-color": "#A0E7E5",
        });
      }
      function ajaxprecess(pageNum = 1) {
        $.ajax({
          url: "/boardList.do",
          type: "post",
          data: `pageNum=${pageNum}`,
          success: function (responseHtml) {
            $(responseHtml).ready(function () {
              var boardTable = $(responseHtml).filter(".boardTable");
              var tableBox = $(".table");
              tableBox.empty();
              tableBox.append(boardTable);
              boardTable.css({
                "margin-top": "10px",
              });
              $(".boardTable").find("tr:first-child").css({
                "background-color": "lightgray",
              });
              var trObj = boardTable.find("tr");
              $(".paging").click(function () {
                var pagingNum = $.trim($(this).val());
                ajaxprecess(pagingNum);
              });
              paintList(trObj);
            });
          },
          error: function () {
            var state = $(".state");
            state.empty();
            state.append("Server Access Failed");
          },
        });
      }

      $(document).ready(function () {
        $(".table").append("<h1 class='state'>Loading...</h1>");
        ajaxprecess();
      });
    </script>
  </head>
  <body>
    <center>
      <a href="javascript:goBoardRegForm();">[새글쓰기]</a>
      <div class="table"></div>
    </center>
  </body>
</html>
