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
        <span style="cursor:pointer;" onClick="location.replace('/naver/logout.do')">
          [로그아웃]
        </span>
      </div>`
    );
  });
  function getRandomData(arr) {
    if (arr.length == 0 && arr == null) {
      alert("배열변수의 개수보다 랜덤하게 뽑을 개수가 큽니다.");
      return null;
    }
    var cnt = arr.length;
    var idx = Math.floor(Math.random() * cnt);
    return arr[idx];
  }
  function getRandomData_with_Del(arr) {
    var cnt = arr.length;
    var idx = Math.floor(Math.random() * cnt);
    var randomData = arr[idx];
    arr.splice(idx, 1);
    return randomData;
  }
  function getRandomDataArr(arr, cnt) {
    if (arr.length == 0 && arr == null) {
      alert("배열변수의 개수보다 랜덤하게 뽑을 개수가 큽니다.");
      return null;
    }
    if (arr.length < cnt) {
      alert("배열변수의 개수보다 랜덤하게 뽑을 개수가 큽니다.");
      return null;
    }
    var randomDataArr = [];
    var arr2 = arr.slice(0);
    for (var i = 1; i <= cnt; i++) {
      randomDataArr.push(getRandomData_with_Del(arr2));
    }
    randomDataArr;
    // while (true) {
    //   var randomData = getRandomData(arr);
    //var tmpArr = [];
    ///////////////
    // if (!(randomDataArr.indexOf(randomData) > 0)) {
    //   randomDataArr.push(randomData);
    // }
    // if (randomDataArr.length == cnt) {
    //   break;
    // }
    ///////////////
    // var tmp_cnt = 0;
    // for (var i = 0; i < tmpArr.length; i++) {
    //   if (randomData == tmpArr[i]) {
    //     tmp_cnt++;
    //   }
    // }
    // if (tmp_cnt > 0) {
    //   continue;
    // }
    // randomDataArr.push(randomData);
    // tmpArr.push(randomData);
    // if (arr.length == cnt) {
    //   break;
    // }
    //}
    //return randomDataArr;
  }
  function getRandomDataArr2(arr, min_cnt, max_cnt) {
    if (arr.length == 0 && arr == null) {
      alert("배열변수의 개수보다 랜덤하게 뽑을 개수가 큽니다.");
      return null;
    }
    if (arr.length < min_cnt) {
      alert("배열변수의 개수보다 랜덤하게 뽑을 개수가 큽니다.");
      return null;
    }
    if (max_cnt < min_cnt) {
      alert("범위가 이상합니다.");
      return null;
    }
    var randomCntArr = [];
    for (var i = min_cnt; i <= max_cnt; i++) {
      randomCntArr.push(i);
    }
    var randomCnt = getRandomData(randomCntArr);
    return getRandomDataArr(arr2, randomCnt);
  }
</script>
<c:set var="bgColor" value="#f2f299" scope="request" ></c:set>
<c:set var="naverPath" value="/naver" scope="request" ></c:set>
