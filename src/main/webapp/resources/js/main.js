/**
 * home.jsp와 연동되어 있는 js file
 */

let app = new Vue({
	el:"#app",
	data:function(){
		return{
			textTest:"1234",
			loginSuccess:false
		}
	},
	methods:{
		getUserLoginData:function(){
			axios.post('/getUserSession').then((res)=>{
				let data=res.data;
				if(data.status ===200){
					this.loginSuccess=true;
				}
			}).catch((err)=>{
				console.log(err);
			})
		},
		clickLogin:function(){
			location.href="/login";
		},
		logout:function(){
			location.href="/logout";
		}
	},mounted:function(){
		this.getUserLoginData();
	}
})