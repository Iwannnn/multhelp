(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/index/index"],{"4c0f":function(t,a,o){"use strict";(function(t){Object.defineProperty(a,"__esModule",{value:!0}),a.default=void 0;var o=getApp(),e={data:function(){return{nbFrontColor:"#000000",nbBackgroundColor:"#fae4fa",background:["http://47.98.63.97:8080/img/picture/asuka.png","http://47.98.63.97:8080/img/picture/xiaoxin.jpg","http://47.98.63.97:8080/img/picture/eva3.01.0.jpg"],indicatorDots:!0,autoplay:!0,interval:5e3,duration:2e3,canIGet:!1,canIGetMore:!0,pageNum:1,callBackCount:5,miniposts:[],category_list:["全部","代替类","交易类","资源类"],category_idx:0,nbTitle:"",canGetMore:!1,nbLoading:!1}},components:{},props:{},onLoad:function(t){this.setData({nbTitle:"主页",nbLoading:!1,pageNum:1})},onShow:function(t){this.getPosts()},onReachBottom:function(){var t=this;if(1==t.canIGetMore){var a=t.pageNum+1;t.setData({pageNum:a}),console.log(a),t.getPosts()}},methods:{getPostsWithoutCategory:function(){var a=this,e=a.pageNum*a.callBackCount;t.request({url:o.globalData.domain+"/wx/post/getPostsWithoutCategory",data:{nums:e},success:function(t){console.log(t.data),a.setData({canIGet:!0,miniposts:t.data}),a.miniposts.length<e&&a.setData({canIGetMore:!1})}})},getPostsWithCategory:function(){var a=this,e=a.pageNum*a.callBackCount,n=a.category_list[a.category_idx];console.log("get with category"),t.request({url:o.globalData.domain+"/wx/post/getPostsWithCategory",data:{category:n,nums:e},success:function(t){console.log(t.data),a.setData({canIGet:!0,miniposts:t.data}),a.miniposts.length<e&&a.setData({canIGetMore:!1})}})},getPosts:function(){console.log(this.category_idx),"0"==this.category_idx?this.getPostsWithoutCategory():this.getPostsWithCategory()},changetoAll:function(){this.setData({category_idx:0}),this.initPostData(),this.getPosts()},changetoSubstitute:function(){this.setData({category_idx:1}),this.initPostData(),this.getPosts()},changetoTransaction:function(){this.setData({category_idx:2}),this.initPostData(),this.getPosts()},changetoSource:function(){this.setData({category_idx:3}),this.initPostData(),this.getPosts()},initPostData:function(){this.setData({canIGetMore:!0,pageNum:1,callBackCount:5})}}};a.default=e}).call(this,o("543d")["default"])},"5aa3":function(t,a,o){"use strict";o.r(a);var e=o("9e93"),n=o("949f");for(var i in n)"default"!==i&&function(t){o.d(a,t,(function(){return n[t]}))}(i);o("ef6b");var s,c=o("f0c5"),u=Object(c["a"])(n["default"],e["b"],e["c"],!1,null,null,null,!1,e["a"],s);a["default"]=u.exports},"949f":function(t,a,o){"use strict";o.r(a);var e=o("4c0f"),n=o.n(e);for(var i in e)"default"!==i&&function(t){o.d(a,t,(function(){return e[t]}))}(i);a["default"]=n.a},"9e93":function(t,a,o){"use strict";var e;o.d(a,"b",(function(){return n})),o.d(a,"c",(function(){return i})),o.d(a,"a",(function(){return e}));var n=function(){var t=this,a=t.$createElement;t._self._c},i=[]},df69:function(t,a,o){"use strict";(function(t){o("abd9");e(o("66fd"));var a=e(o("5aa3"));function e(t){return t&&t.__esModule?t:{default:t}}t(a.default)}).call(this,o("543d")["createPage"])},ef6b:function(t,a,o){"use strict";var e=o("f669"),n=o.n(e);n.a},f669:function(t,a,o){}},[["df69","common/runtime","common/vendor"]]]);