/**
 * home.jsp와 연동되어 있는 js file
 */

let app = new Vue({
  el: "#app",
  data: function() {
    return {
      loginSuccess: false,
      userInfo: { username: "", password: "" },
      userWantAccount: false
    };
  },
  methods: {
    getUserLoginData: function() {
      // 유저의 로그인여부 확인
      if (this.loginSuccess) {
        console.log("로그인 성공상태");
      } else {
        console.log("로그인 실패상태");
      }
    },
    clickLogin: function() {
      // 상단 로그인 클릭
      location.href = "/login";
    },
    clearUserInfo: function() {
      // 유저 정보 초기화
      this.userInfo = { username: null, password: null };
    },
    changeAccount: function() {
      // Login <-> Account 변화
      this.userWantAccount = !this.userWantAccount;
    },
    checkUserInfo: function() {
      // Login눌렀을 시 값 처리하기
      let postdata = new URLSearchParams();
      postdata.append("username", this.userInfo.username);
      postdata.append("password", this.userInfo.password);
      if (this.userInfo.username == "" || this.userInfo.password == "") {
        alert("빈 값을 다시 입력해주세요");
      } else {
        axios
          .post("/checkUser", postdata)
          .then(res => {
            let data = res.data;

            if (data.status === 200) {
              alert("로그인 성공");
              location.href = "/";
            } else {
              alert("로그인 실패");
            }
            console.log(res);
          })
          .catch(err => {
            console.log("Login주소 전달 오류");
          });
      }
    },
    addUserInfo: function() {
      let postdata = new URLSearchParams();
      postdata.append("username", this.userInfo.username);
      postdata.append("password", this.userInfo.password);
      if (this.userInfo.username == "" || this.userInfo.password == "") {
        alert("빈 값을 다시 입력해주세요");
      } else {
        axios
          .post("/addUserInfo", postdata)
          .then(res => {
            let data = res.data;
            if (data.status === 200) {
              alert("회원가입 성공! 로그인");
              this.userWantAccount=false;
            } else {
              alert(data.comment);
            }
            console.log(res);
          })
          .catch(err => {
            console.log("회원가입 주소 전달 오류");
          });
      }
    }
  },
  mounted: function() {
    this.getUserLoginData();
  }
});
