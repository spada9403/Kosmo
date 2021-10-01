import React, { Component } from "react";
import styled from "styled-components";
import $ from "jquery";

const Tr = styled.tr`
  background-color: ${(props) => (props.className === "odd" ? "lightcoral" : "lightpink")};
  cursor: pointer;
  :hover {
    background-color: lightcyan;
  }
`;

class Search2 extends Component {
  //DB 연동으로 가지고온 데이터
  allDev = null;
  state = {
    inputText: "",
    developers: [],
    isLoading: false,
  };
  nameRef = React.createRef();
  changeText = (e) => {
    this.setState({ inputText: e.target.value });
  };
  search = () => {
    const val = this.state.inputText.trim();
    if (val === "" || val === undefined || val === null) {
      alert("검색할 키워드가 없습니다!");
      this.nameRef.current.focus();
      return;
    }
    const array = this.allDev.filter((item) => item.EMP_NAME.indexOf(val) >= 0 || item.JIKUP.indexOf(val) >= 0 || item.HIRE_DATE.indexOf(val) >= 0);
    this.setState({ developers: array });
    this.setState({ inputText: "" });
    this.nameRef.current.focus();
  };
  allSearch = () => {
    this.setState({ developers: this.allDev });
    this.setState({ inputText: "" });
    this.nameRef.current.focus();
  };
  goEmplInfo = async (id, event) => {
    await $.ajax({
      url: "http://localhost:8081/employeeInfoApi.do",
      data: `id=${id}`,
      type: "post",
      success: function (json) {},
      error: function (error) {
        console.log(error);
        alert("DB서버 에러!!");
      },
    }).then((json) => {
      console.log(json);
      const clientX = event.clientX;
      const clientY = event.clientY;
      const obj = $(".emplInfo");
      obj.css({
        position: "absolute",
        left: clientX + 20,
        top: clientY + 20,
      });
      obj.html(`
        <table border="1" cellpadding="3" style = "border-collapse:collapse" class="emplInfoTable" >
          <tr>
            <th>직원번호</th>
            <th>직원이름</th>
            <th>직급</th>
            <th>부서이름</th>
            <th>입사일</th>
            <th>주민번호</th>
            <th>폰번호</th>
            <th>상사이름</th>
          </tr>
          <tr>
            <td>${json.EMP_NO}</td>
            <td>${json.EMP_NAME}</td>
            <td>${json.JIKUP}</td>
            <td>${json.DEP_NAME}</td>
            <td>${json.HIRE_DATE}</td>
            <td>${json.JUMIN_NUM}</td>
            <td>${json.PHONE_NUM}</td>
            <td>${json.MGR_EMP_NAME}</td>
          </tr>
        </table>
        <button>수정화면</button>
        <button>닫기</button>
        `);
      const emplInfoTable = $(".emplInfoTable");
      emplInfoTable.find("th").css({
        backgroundColor: "lightgray",
      });
      emplInfoTable.css({
        backgroundColor: "white",
      });
      obj.show();
    });
  };
  async componentDidMount() {
    var keywordObj = $(".searchBtn");
    keywordObj.prop("disabled", true);
    if (this.allDev == null) {
      await $.ajax({
        url: "http://localhost:8081/employeeApi.do",
        type: "post",
        success: function (json) {},
        error: function (error) {
          console.log(error);
          alert("DB서버 에러!!");
        },
      }).then((json) => {
        setTimeout(() => {
          this.allDev = json;
          this.setState({
            developers: this.allDev,
            isLoading: true,
          });
          keywordObj.prop("disabled", false);
          $("body").keyup((e) => {
            if (e.keyCode === 13) {
              this.search();
            }
          });
          $(".emplInfo").hide();
        }, 3000);
      });
    }
  }
  render() {
    const developers = this.state.developers;
    let devList = null;
    if (developers != null && developers.length > 0) {
      devList = developers.map((dev, index) => {
        let even_or_odd = "odd";
        if (index % 2 === 0) {
          even_or_odd = "even";
        }
        return (
          <Tr
            id={dev.EMP_NO}
            className={even_or_odd}
            onClick={(event) => {
              this.goEmplInfo(dev.EMP_NO, event);
            }}
          >
            <td>{dev.EMP_NO}</td>
            <td>{dev.EMP_NAME}</td>
            <td>{dev.JIKUP}</td>
            <td>{dev.HIRE_DATE}</td>
          </Tr>
        );
      });
    }
    const inputText = this.state.inputText;
    return (
      <>
        <center>
          <br />
          <br />
          <span>
            키워드: <input type="text" className="searchBtn" onChange={this.changeText} ref={this.nameRef} value={inputText} />
          </span>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <button onClick={this.search} className="searchBtn">
            검색
          </button>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <button onClick={this.allSearch} className="searchBtn">
            모두 검색
          </button>
          <br />
          <br />
          <span>총 {developers.length}명</span>
          <br />
          <br />
          {this.state.isLoading === false ? (
            <h1>Loading. . .</h1>
          ) : (
            <>
              <table border="1" cellPadding="5" style={{ borderCollapse: "collapse" }}>
                <tr style={{ backgroundColor: "gray" }}>
                  <th>번호</th>
                  <th>직원명</th>
                  <th>직급</th>
                  <th>입사일</th>
                </tr>
                {devList !== null ? devList : ""}
              </table>
              {devList !== null && devList.length > 0 ? "" : <span>검색결과가 없습니다.</span>}
              <div className="emplInfo"></div>
            </>
          )}
        </center>
      </>
    );
  }
}

export default Search2;
