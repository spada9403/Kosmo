<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSP 페이지에서 사용할 [사용자 정의 태그]의 한 종류인 [JSTL 의 C 코어 태그]를 사용하겠다고 선언 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--
  JSTL이란?
    =>  자카르타라는 단체에서 만든 [사용자 정의 태그]를 말한다.
    =>  자바 문법을 HTML과 같은 태그 형태로 표현한다.
    =>  HTML 과 같은 태그 형태로 표현하면 뒤에서 자바 문법으로 바뀌어 실행된다.
    =>  JSTL 사용 장점
      ->  태그 형태이므로 디자이너 퍼블리셔, 초급 개발자가 접근이 쉽다.
      ->  큰 에러가 아닌 이상 화면이 멈추지 않는다.
      ->  null 처리에 대해 관대하다. null에 대해 민감한 반응을 보이지 않는다.
    =>  JSTL 은 EL 과 같이 쓰인다.
-->
<script src="/resources/jquery-3.6.0.min.js" type="text/javascript"></script>
<link href="/resources/common.css" rel="stylesheet" type="text/css" />
<script>
  $(document).ready(function () {
    $("center").prepend(
      `<div>
        <span style="cursor:pointer;" onClick="location.replace('/logout.do')">
          [로그아웃]
        </span>
      </div>`
    );
  });
  function getRandomData(arr) {
    var randomDataArr = "";
    var arrLength = arr.length;
    var randomCnt = Math.floor(Math.random() * arrLength);
    randomDataArr = arr[randomCnt];
    return randomDataArr;
  }
  function getRandomDataArr2(arr, cnt) {
    var randomDataArr = [];
    for (var i = 0; i < arr.length(); i++) {
      radomDataArr.push(getRandomData(arr));
    }
    return randomDataArr;
  }
  function getRandomDataArr2(arr, min_cnt, max_cnt) {
    var randomDataArr = [];
    var randomCnt = Math.floor(Math.random() * (max_cnt - min_cnt) + min_cnt) + 1;
    radomDataArr = getRandomDataArr2(arr, randomCnt);
    return randomDataArr;
  }
</script>
<c:set var="bgColor" value="#f2f299"></c:set>
