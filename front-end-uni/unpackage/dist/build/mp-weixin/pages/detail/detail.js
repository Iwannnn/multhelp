(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/detail/detail"],{"0527":function(t,o,n){"use strict";n.r(o);var a=n("e47b"),e=n.n(a);for(var s in a)"default"!==s&&function(t){n.d(o,t,(function(){return a[t]}))}(s);o["default"]=e.a},"0d4c":function(t,o,n){"use strict";n.r(o);var a=n("c2f1"),e=n("0527");for(var s in e)"default"!==s&&function(t){n.d(o,t,(function(){return e[t]}))}(s);n("518f");var i,c=n("f0c5"),l=Object(c["a"])(e["default"],a["b"],a["c"],!1,null,null,null,!1,a["a"],i);o["default"]=l.exports},"518f":function(t,o,n){"use strict";var a=n("c6c6"),e=n.n(a);e.a},6786:function(t,o,n){"use strict";(function(t){n("abd9");a(n("66fd"));var o=a(n("0d4c"));function a(t){return t&&t.__esModule?t:{default:t}}t(o.default)}).call(this,n("543d")["createPage"])},c2f1:function(t,o,n){"use strict";var a;n.d(o,"b",(function(){return e})),n.d(o,"c",(function(){return s})),n.d(o,"a",(function(){return a}));var e=function(){var t=this,o=t.$createElement;t._self._c},s=[]},c6c6:function(t,o,n){},e47b:function(t,o,n){"use strict";(function(t){Object.defineProperty(o,"__esModule",{value:!0}),o.default=void 0;var n=getApp(),a={data:function(){return{nbFrontColor:"#000000",nbBackgroundColor:"#fae4fa",postid:"",postDetail:"",nbTitle:"",nbLoading:!1}},components:{},props:{},onLoad:function(t){var o=t.postid;this.setData({nbTitle:"求助详情",nbLoading:!1,postid:o}),n.globalData.checkSession_3rd(),this.getPostDetail()},methods:{getPostDetail:function(){var o=this;t.request({url:n.globalData.domain+"/wx/post/getPostDetail",data:{postid:o.postid},success:function(t){console.log(t.data),o.setData({postDetail:t.data})}})},helpPost:function(){var o=this;n.globalData.checkSession_3rd(),console.log(n.globalData.session_3rd),console.log(o.postid),t.request({url:n.globalData.domain+"/wx/post/helpPost",data:{session_3rd:n.globalData.session_3rd,postid:o.postid},success:function(t){console.log(t.data)}})},contact:function(){t.navigateTo({url:"/pages/message/chat/chat?postid="+this.postid})}}};o.default=a}).call(this,n("543d")["default"])}},[["6786","common/runtime","common/vendor"]]]);