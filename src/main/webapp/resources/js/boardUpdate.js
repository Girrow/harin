/**
 * home.jsp와 연동되어 있는 js file
 */

let app = new Vue({
  el: "#app",
  data: function() {
    return {
      loginSuccess: false,
      userInfo: { username: "", password: "" },
      boardData:{},
      isYours:false
    };
  },
  methods: {
		getUserLoginData:function(){
			axios.post('/getUserSession').then((res)=>{
				let data=res.data;
				if(data.status ===200){
          this.loginSuccess=true;
          this.userInfo.username=data.comment;
          this.getUserData();
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
    	let view=location.href.split("/").length-1;
    	const viewN=location.href.split("/")[view];
      axios.post('/getOneView/'+viewN).then((res)=>{
        let data=res.data;
        this.boardData=data;
        if(this.userInfo.username === data.writer){
        	this.isYours=true;
        }else{
        	console.log(this.userInfo.username,data.writer);
        }
        console.log(res);
      }).catch((err)=>{
        console.log(err);
      })
    },logout:function(){
			location.href="/logout";
    },updateIt:function(){
    	let postdata = new URLSearchParams();
        postdata.append("no", this.boardData.no);
        postdata.append("title", this.boardData.title);
        postdata.append("content", this.boardData.content);
    	axios.post('/board/update',postdata).then((res)=>{
    		console.log(res);
    		location.href="/board";
    	}).catch((err)=>{
    		console.log(err);
    	})
    }
  },
  mounted: function() {
    this.getUserLoginData();

  }
});
