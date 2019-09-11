/**
 * home.jsp와 연동되어 있는 js file
 */

let app = new Vue({
  el: "#app",
  data: function() {
    return {
      loginSuccess: false,
      userInfo: { username: "", password: "" },
      boardData:[]
    };
  },
  methods: {
		getUserLoginData:function(){
			axios.post('/getUserSession').then((res)=>{
				let data=res.data;
				if(data.status ===200){
          this.loginSuccess=true;
          this.userInfo.username=data.comment;
				}
			}).catch((err)=>{
				console.log(err);
			})
		},
    clickLogin: function() {
      // 상단 로그인 클릭
      location.href = "/login";
    },
    getUserData:function(){
      axios.post('/getBoardList').then((res)=>{
        let data=res.data;
        data.status===200
         ?this.boardData=data.results
         :alert('데이터 오류')
        console.log(res);
      }).catch((err)=>{
        console.log(err);
      })
    },
		logout:function(){
			location.href="/logout";
    },
    goToDetail:function(num){
      location.href="/detail/"+num;
    },
    goToNew:function(){
      location.href="/create";
    }
  },
  mounted: function() {
    this.getUserLoginData();
    this.getUserData();
  }
});
