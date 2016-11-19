
/* Merged Plone Javascript file
 * This file is dynamically assembled from separate parts.
 * Some of these parts have 3rd party licenses or copyright information attached
 * Such information is valid for that section,
 * not for the entire composite file
 * originating files are separated by - filename.js -
 */

/* XXX ERROR -- could not find '++resource++sc.embedder/video-js/video.js'*/

/* - ++resource++pb_attachment.js - */
// https://www.prf.gov.br/portal/portal_javascripts/++resource++pb_attachment.js?original=1
function AddAttachmentField(inp){var parent=inp.parentNode;if(parent.attachments==null){parent.attachments=1;parent.maxattachments=parent.getAttribute("attachments")}
var e=document.createElement("input");e.setAttribute("type","file");e.setAttribute("name","files:list");e.setAttribute("size","30");parent.insertBefore(e,inp);e=document.createElement("br");parent.insertBefore(e,inp);parent.attachments++;if(parent.attachments>=parent.maxattachments)
parent.removeChild(inp);return false}


/* - ++resource++jquery.ajaxfileupload.js - */
// https://www.prf.gov.br/portal/portal_javascripts/++resource++jquery.ajaxfileupload.js?original=1
(function(){var d=document,w=window;
function get(element){if(typeof element=="string")
element=d.getElementById(element);return element}
function addEvent(el,type,fn){if(w.addEventListener){el.addEventListener(type,fn,false)} else if(w.attachEvent){var f=function(){fn.call(el,w.event)};el.attachEvent('on'+type,f)}}
var toElement=function(){var div=d.createElement('div');return function(html){div.innerHTML=html;var el=div.childNodes[0];div.removeChild(el);return el}}();
function hasClass(ele,cls){return ele.className.match(new RegExp('(\\s|^)'+cls+'(\\s|$)'))}
function addClass(ele,cls){if(!hasClass(ele,cls)) ele.className+=" "+cls}
function removeClass(ele,cls){var reg=new RegExp('(\\s|^)'+cls+'(\\s|$)');ele.className=ele.className.replace(reg,' ')}
if(document.documentElement["getBoundingClientRect"]){var getOffset=function(el){var box=el.getBoundingClientRect(),doc=el.ownerDocument,body=doc.body,docElem=doc.documentElement,clientTop=docElem.clientTop||body.clientTop||0,clientLeft=docElem.clientLeft||body.clientLeft||0,zoom=1;if(body.getBoundingClientRect){var bound=body.getBoundingClientRect();zoom=(bound.right-bound.left)/body.clientWidth}
if(zoom>1){clientTop=0;clientLeft=0}
var top=box.top/zoom+(window.pageYOffset||docElem&&docElem.scrollTop/zoom||body.scrollTop/zoom)-clientTop,left=box.left/zoom+(window.pageXOffset||docElem&&docElem.scrollLeft/zoom||body.scrollLeft/zoom)-clientLeft;return{top:top,left:left}}} else{var getOffset=function(el){if(w.jQuery){return jQuery(el).offset()}
var top=0,left=0;do{top+=el.offsetTop||0;left+=el.offsetLeft||0}
while(el=el.offsetParent);return{left:left,top:top}}}
function getBox(el){var left,right,top,bottom;var offset=getOffset(el);left=offset.left;top=offset.top;right=left+el.offsetWidth;bottom=top+el.offsetHeight;return{left:left,right:right,top:top,bottom:bottom}}
function getMouseCoords(e){if(!e.pageX&&e.clientX){var zoom=1;var body=document.body;if(body.getBoundingClientRect){var bound=body.getBoundingClientRect();zoom=(bound.right-bound.left)/body.clientWidth}
return{x:e.clientX/zoom+d.body.scrollLeft+d.documentElement.scrollLeft,y:e.clientY/zoom+d.body.scrollTop+d.documentElement.scrollTop}}
return{x:e.pageX,y:e.pageY}}
var getUID=function(){var id=0;return function(){return 'ValumsAjaxUpload'+id++}}();
function fileFromPath(file){return file.replace(/.*(\/|\\)/,"")}
function getExt(file){return (/[.]/.exec(file))?/[^.]+$/.exec(file.toLowerCase()):''}
Ajax_upload=AjaxUpload=function(button,options){if(button.jquery){button=button[0]} else if(typeof button=="string"&&/^#.*/.test(button)){button=button.slice(1)}
button=get(button);this._input=null;this._button=button;this._disabled=false;this._submitting=false;this._justClicked=false;this._parentDialog=d.body;if(window.jQuery&&jQuery.ui&&jQuery.ui.dialog){var parentDialog=jQuery(self._button).parents('.ui-dialog-content');if(parentDialog.length){this._parentDialog=parentDialog[0]}}
this._settings={action:'upload.php',name:'userfile',data:{},autoSubmit:true,responseType:false,onChange: function(file,extension){},onSubmit: function(file,extension){},onComplete: function(file,response){}};for(var i in options){this._settings[i]=options[i]}
this._createInput();this._rerouteClicks()}
AjaxUpload.prototype={setData: function(data){this._settings.data=data},disable: function(){this._disabled=true},enable: function(){this._disabled=false},destroy: function(){if(this._input){if(this._input.parentNode){this._input.parentNode.removeChild(this._input)}
this._input=null}},_createInput: function(){var self=this;var input=d.createElement("input");input.setAttribute('type','file');input.setAttribute('name',this._settings.name);var styles={'position':'absolute','margin':'-5px 0 0 -175px','padding':0,'width':'220px','height':'30px','fontSize':'14px','opacity':0,'cursor':'pointer','display':'none','zIndex':2147483583};for(var i in styles){input.style[i]=styles[i]}
if(!(input.style.opacity==="0")){input.style.filter="alpha(opacity=0)"}
this._parentDialog.appendChild(input);addEvent(input,'change', function(){var file=fileFromPath(this.value);if(self._settings.onChange.call(self,file,getExt(file))==false){return}
if(self._settings.autoSubmit){self.submit()}});addEvent(input,'click', function(){self.justClicked=true;setTimeout(function(){self.justClicked=false},3000)});this._input=input},_rerouteClicks: function(){var self=this;var box,dialogOffset={top:0,left:0},over=false;addEvent(self._button,'mouseover', function(e){if(!self._input||over) return;over=true;box=getBox(self._button);if(self._parentDialog!=d.body){dialogOffset=getOffset(self._parentDialog)}});addEvent(document,'mousemove', function(e){var input=self._input;if(!input||!over) return;if(self._disabled){removeClass(self._button,'hover');input.style.display='none';return}
var c=getMouseCoords(e);if((c.x>=box.left)&&(c.x<=box.right)&&(c.y>=box.top)&&(c.y<=box.bottom)){input.style.top=c.y-dialogOffset.top+'px';input.style.left=c.x-dialogOffset.left+'px';input.style.display='block';addClass(self._button,'hover')} else{over=false;if(!self.justClicked){input.style.display='none'}
removeClass(self._button,'hover')}})},_createIframe: function(){var id=getUID();var iframe=toElement('<iframe src="javascript:false;" name="'+id+'" />');iframe.id=id;iframe.style.display='none';d.body.appendChild(iframe);return iframe},submit: function(){var self=this,settings=this._settings;if(this._input.value===''){return}
var file=fileFromPath(this._input.value);if(!(settings.onSubmit.call(this,file,getExt(file))==false)){var iframe=this._createIframe();var form=this._createForm(iframe);form.appendChild(this._input);form.submit();d.body.removeChild(form);form=null;this._input=null;this._createInput();var toDeleteFlag=false;addEvent(iframe,'load', function(e){if(iframe.src=="about:blank"){if(toDeleteFlag){setTimeout( function(){d.body.removeChild(iframe)},0)}
return}
var doc=iframe.contentDocument?iframe.contentDocument:frames[iframe.id].document;if(doc.readyState&&doc.readyState!='complete'){return}
if(doc.body&&doc.body.innerHTML=="false"){return}
var response;if(doc.XMLDocument){response=doc.XMLDocument} else if(doc.body){response=doc.body.innerHTML;if(settings.responseType=='json'){response=window["eval"]("("+response+")")}} else{var response=doc}
settings.onComplete.call(self,file,response);toDeleteFlag=true;iframe.src="about:blank"})} else{d.body.removeChild(this._input);this._input=null;this._createInput()}},_createForm: function(iframe){var settings=this._settings;var form=toElement('<form method="post" enctype="multipart/form-data"></form>');form.style.display='none';form.action=settings.action;form.target=iframe.name;d.body.appendChild(form);for(var prop in settings.data){var el=d.createElement("input");el.type='hidden';el.name=prop;el.value=settings.data[prop];form.appendChild(el)}
return form}}})();

/* - ++resource++jquery.bbq.js - */
// https://www.prf.gov.br/portal/portal_javascripts/++resource++jquery.bbq.js?original=1
(function($,r){var h,n=Array.prototype.slice,t=decodeURIComponent,a=$.param,j,c,m,y,b=$.bbq=$.bbq||{},s,x,k,e=$.event.special,d="hashchange",B="querystring",F="fragment",z="elemUrlAttr",l="href",w="src",p=/^.*\?|#.*$/g,u,H,g,i,C,E={};function G(I){return typeof I==="string"}function D(J){var I=n.call(arguments,1);return function(){return J.apply(this,I.concat(n.call(arguments)))}}function o(I){return I.replace(H,"$2")}function q(I){return I.replace(/(?:^[^?#]*\?([^#]*).*$)?.*/,"$1")}function f(K,P,I,L,J){var R,O,N,Q,M;if(L!==h){N=I.match(K?H:/^([^#?]*)\??([^#]*)(#?.*)/);M=N[3]||"";if(J===2&&G(L)){O=L.replace(K?u:p,"")}else{Q=m(N[2]);L=G(L)?m[K?F:B](L):L;O=J===2?L:J===1?$.extend({},L,Q):$.extend({},Q,L);O=j(O);if(K){O=O.replace(g,t)}}R=N[1]+(K?C:O||!N[1]?"?":"")+O+M}else{R=P(I!==h?I:location.href)}return R}a[B]=D(f,0,q);a[F]=c=D(f,1,o);a.sorted=j=function(J,K){var I=[],L={};$.each(a(J,K).split("&"),function(P,M){var O=M.replace(/(?:%5B|=).*$/,""),N=L[O];if(!N){N=L[O]=[];I.push(O)}N.push(M)});return $.map(I.sort(),function(M){return L[M]}).join("&")};c.noEscape=function(J){J=J||"";var I=$.map(J.split(""),encodeURIComponent);g=new RegExp(I.join("|"),"g")};c.noEscape(",/");c.ajaxCrawlable=function(I){if(I!==h){if(I){u=/^.*(?:#!|#)/;H=/^([^#]*)(?:#!|#)?(.*)$/;C="#!"}else{u=/^.*#/;H=/^([^#]*)#?(.*)$/;C="#"}i=!!I}return i};c.ajaxCrawlable(0);$.deparam=m=function(L,I){var K={},J={"true":!0,"false":!1,"null":null};$.each(L.replace(/\+/g," ").split("&"),function(O,T){var N=T.split("="),S=t(N[0]),M,R=K,P=0,U=S.split("]["),Q=U.length-1;if(/\[/.test(U[0])&&/\]$/.test(U[Q])){U[Q]=U[Q].replace(/\]$/,"");U=U.shift().split("[").concat(U);Q=U.length-1}else{Q=0}if(N.length===2){M=t(N[1]);if(I){M=M&&!isNaN(M)?+M:M==="undefined"?h:J[M]!==h?J[M]:M}if(Q){for(;P<=Q;P++){S=U[P]===""?R.length:U[P];R=R[S]=P<Q?R[S]||(U[P+1]&&isNaN(U[P+1])?{}:[]):M}}else{if($.isArray(K[S])){K[S].push(M)}else{if(K[S]!==h){K[S]=[K[S],M]}else{K[S]=M}}}}else{if(S){K[S]=I?h:""}}});return K};function A(K,I,J){if(I===h||typeof I==="boolean"){J=I;I=a[K?F:B]()}else{I=G(I)?I.replace(K?u:p,""):I}return m(I,J)}m[B]=D(A,0);m[F]=y=D(A,1);$[z]||($[z]=function(I){return $.extend(E,I)})({a:l,base:l,iframe:w,img:w,input:w,form:"action",link:l,script:w});k=$[z];function v(L,J,K,I){if(!G(K)&&typeof K!=="object"){I=K;K=J;J=h}return this.each(function(){var O=$(this),M=J||k()[(this.nodeName||"").toLowerCase()]||"",N=M&&O.attr(M)||"";O.attr(M,a[L](N,K,I))})}$.fn[B]=D(v,B);$.fn[F]=D(v,F);b.pushState=s=function(L,I){if(G(L)&&/^#/.test(L)&&I===h){I=2}var K=L!==h,J=c(location.href,K?L:{},K?I:2);location.href=J};b.getState=x=function(I,J){return I===h||typeof I==="boolean"?y(I):y(J)[I]};b.removeState=function(I){var J={};if(I!==h){J=x();$.each($.isArray(I)?I:arguments,function(L,K){delete J[K]})}s(J,2)};e[d]=$.extend(e[d],{add:function(I){var K;function J(M){var L=M[F]=c();M.getState=function(N,O){return N===h||typeof N==="boolean"?m(L,N):m(L,O)[N]};K.apply(this,arguments)}if($.isFunction(I)){K=I;return J}else{K=I.handler;I.handler=J}}})})(jQuery,this);(function($,e,b){var c="hashchange",h=document,f,g=$.event.special,i=h.documentMode,d="on"+c in e&&(i===b||i>7);function a(j){j=j||location.href;return"#"+j.replace(/^[^#]*#?(.*)$/,"$1")}$.fn[c]=function(j){return j?this.bind(c,j):this.trigger(c)};$.fn[c].delay=50;g[c]=$.extend(g[c],{setup:function(){if(d){return false}$(f.start)},teardown:function(){if(d){return false}$(f.stop)}});f=(function(){var j={},p,m=a(),k=function(q){return q},l=k,o=k;j.start=function(){p||n()};j.stop=function(){p&&clearTimeout(p);p=b};function n(){var r=a(),q=o(m);if(r!==m){l(m=r,q);$(e).trigger(c)}else{if(q!==m){location.href=location.href.replace(/#.*/,"")+q}}p=setTimeout(n,$.fn[c].delay)}return j})()})(jQuery,this);

/* - ++resource++jquery.jstree.js - */
// https://www.prf.gov.br/portal/portal_javascripts/++resource++jquery.jstree.js?original=1
(function($){$.tree={datastores:{},plugins:{},defaults:{data:{async:false,type:"html",opts:{method:"GET",url:false}},selected:false,opened:[],languages:[],ui:{dots:true,animation:0,scroll_spd:4,theme_path:false,theme_name:"default",selected_parent_close:"select_parent",selected_delete:"select_previous"},types:{"default":{clickable:true,renameable:true,deletable:true,creatable:true,draggable:true,max_children:-1,max_depth:-1,valid_children:"all",icon:{image:false,position:false}}},rules:{multiple:false,multitree:"none",type_attr:"rel",createat:"bottom",drag_copy:"ctrl",drag_button:"left",use_max_children:true,use_max_depth:true,max_children:-1,max_depth:-1,valid_children:"all"},lang:{new_node:"New folder",loading:"Loading ..."},callback:{beforechange: function(NODE,TREE_OBJ){return true},beforeopen: function(NODE,TREE_OBJ){return true},beforeclose: function(NODE,TREE_OBJ){return true},beforemove: function(NODE,REF_NODE,TYPE,TREE_OBJ){return true},beforecreate: function(NODE,REF_NODE,TYPE,TREE_OBJ){return true},beforerename: function(NODE,LANG,TREE_OBJ){return true},beforedelete: function(NODE,TREE_OBJ){return true},beforedata: function(NODE,TREE_OBJ){return{id:$(NODE).attr("id")||0}},ondata: function(DATA,TREE_OBJ){return DATA},onparse: function(STR,TREE_OBJ){return STR},onhover: function(NODE,TREE_OBJ){},onselect: function(NODE,TREE_OBJ){},ondeselect: function(NODE,TREE_OBJ){},onchange: function(NODE,TREE_OBJ){},onrename: function(NODE,TREE_OBJ,RB){},onmove: function(NODE,REF_NODE,TYPE,TREE_OBJ,RB){},oncopy: function(NODE,REF_NODE,TYPE,TREE_OBJ,RB){},oncreate: function(NODE,REF_NODE,TYPE,TREE_OBJ,RB){},ondelete: function(NODE,TREE_OBJ,RB){},onopen: function(NODE,TREE_OBJ){},onopen_all: function(TREE_OBJ){},onclose_all: function(TREE_OBJ){},onclose: function(NODE,TREE_OBJ){},error: function(TEXT,TREE_OBJ){},ondblclk: function(NODE,TREE_OBJ){TREE_OBJ.toggle_branch.call(TREE_OBJ,NODE);TREE_OBJ.select_branch.call(TREE_OBJ,NODE)},onrgtclk: function(NODE,TREE_OBJ,EV){},onload: function(TREE_OBJ){},oninit: function(TREE_OBJ){},onfocus: function(TREE_OBJ){},ondestroy: function(TREE_OBJ){},onsearch: function(NODES,TREE_OBJ){NODES.addClass("search")},ondrop: function(NODE,REF_NODE,TYPE,TREE_OBJ){},check: function(RULE,NODE,VALUE,TREE_OBJ){return VALUE},check_move: function(NODE,REF_NODE,TYPE,TREE_OBJ){return true}},plugins:{}},create: function(){return new tree_component()},focused: function(){return tree_component.inst[tree_component.focused]},reference: function(obj){var o=$(obj);if(!o.size()) o=$("#"+obj);if(!o.size()) return null;o=(o.is(".tree"))?o.attr("id"):o.parents(".tree:eq(0)").attr("id");return tree_component.inst[o]||null},rollback: function(data){for(var i in data){if(!data.hasOwnProperty(i)) continue;var tmp=tree_component.inst[i];var lock=!tmp.locked;if(lock) tmp.lock(true);tmp.inp=false;tmp.container.html(data[i].html).find(".dragged").removeClass("dragged").end().find(".hover").removeClass("hover");if(data[i].selected){tmp.selected=$("#"+data[i].selected);tmp.selected_arr=[];tmp.container.find("a.clicked").each( function(){tmp.selected_arr.push(tmp.get_node(this))})}
if(lock) tmp.lock(false);delete lock;delete tmp}},drop_mode: function(opts){opts=$.extend(opts,{show:false,type:"default",str:"Foreign node"});tree_component.drag_drop.foreign=true;tree_component.drag_drop.isdown=true;tree_component.drag_drop.moving=true;tree_component.drag_drop.appended=false;tree_component.drag_drop.f_type=opts.type;tree_component.drag_drop.f_data=opts;if(!opts.show){tree_component.drag_drop.drag_help=false;tree_component.drag_drop.drag_node=false}
else{tree_component.drag_drop.drag_help=$("<div id='jstree-dragged' class='tree tree-default'><ul><li class='last dragged foreign'><a href='#'><ins>&nbsp;</ins>"+opts.str+"</a></li></ul></div>");tree_component.drag_drop.drag_node=tree_component.drag_drop.drag_help.find("li:eq(0)")}
if($.tree.drag_start!==false) $.tree.drag_start.call(null,false)},drag_start:false,drag:false,drag_end:false};$.fn.tree=function(opts){return this.each(function(){var conf=$.extend({},opts);if(tree_component.inst&&tree_component.inst[$(this).attr('id')]) tree_component.inst[$(this).attr('id')].destroy();if(conf!==false) new tree_component().init(this,conf)})};
function tree_component(){return{cntr:++tree_component.cntr,settings:$.extend({},$.tree.defaults),init: function(elem,conf){var _this=this;this.container=$(elem);if(this.container.size==0) return false;tree_component.inst[this.cntr]=this;if(!this.container.attr("id")) this.container.attr("id","jstree_"+this.cntr);tree_component.inst[this.container.attr("id")]=tree_component.inst[this.cntr];tree_component.focused=this.cntr;this.settings=$.extend(true,{},this.settings,conf);if(this.settings.languages&&this.settings.languages.length){this.current_lang=this.settings.languages[0];var st=false;var id="#"+this.container.attr("id");for(var ln=0;ln<this.settings.languages.length;ln++){st=tree_component.add_css(id+" ."+this.settings.languages[ln]);if(st!==false) st.style.display=(this.settings.languages[ln]==this.current_lang)?"":"none"}}
else this.current_lang=false;this.container.addClass("tree");if(this.settings.ui.theme_name!==false){if(this.settings.ui.theme_path===false){$("script").each(function(){if(this.src.toString().match(/jquery\.tree.*?js$/)) { _this.settings.ui.theme_path = this.src.toString().replace(/jquery\.tree.*?js$/,"")+"themes/"+_this.settings.ui.theme_name+"/style.css";return false}})}
if(this.settings.ui.theme_path!=""&&$.inArray(this.settings.ui.theme_path,tree_component.themes)==-1){tree_component.add_sheet({url:this.settings.ui.theme_path});tree_component.themes.push(this.settings.ui.theme_path)}
this.container.addClass("tree-"+this.settings.ui.theme_name)}
var type_icons="";for(var t in this.settings.types){if(!this.settings.types.hasOwnProperty(t)) continue;if(!this.settings.types[t].icon) continue;if(this.settings.types[t].icon.image||this.settings.types[t].icon.position){if(t=="default") type_icons+="#"+this.container.attr("id")+" li > a ins { ";else type_icons+="#"+this.container.attr("id")+" li[rel="+t+"] > a ins { ";if(this.settings.types[t].icon.image) type_icons+=" background-image:url("+this.settings.types[t].icon.image+"); ";if(this.settings.types[t].icon.position) type_icons+=" background-position:"+this.settings.types[t].icon.position+"; ";type_icons+="} "}}
if(type_icons!="") tree_component.add_sheet({str:type_icons});if(this.settings.rules.multiple) this.selected_arr=[];this.offset=false;this.hovered=false;this.locked=false;if(tree_component.drag_drop.marker===false) tree_component.drag_drop.marker=$("<div>").attr({id:"jstree-marker"}).hide().appendTo("body");this.callback("oninit",[this]);this.refresh();this.attach_events();this.focus()},refresh: function(obj){if(this.locked) return this.error("LOCKED");var _this=this;if(obj&&!this.settings.data.async) obj=false;this.is_partial_refresh=obj?true:false;this.opened=Array();if(this.settings.opened!=false){$.each(this.settings.opened, function(i,item){if(this.replace(/^#/,"").length > 0) { _this.opened.push("#" + this.replace(/^#/,""))}});this.settings.opened=false}
else{this.container.find("li.open").each(function(i){if(this.id){_this.opened.push("#"+this.id)}})}
if(this.selected){this.settings.selected=Array();if(obj){$(obj).find("li:has(a.clicked)").each(function(){if(this.id) _this.settings.selected.push("#"+this.id)})}
else{if(this.selected_arr){$.each(this.selected_arr, function(){if(this.attr("id")) _this.settings.selected.push("#"+this.attr("id"))})}
else{if(this.selected.attr("id")) this.settings.selected.push("#"+this.selected.attr("id"))}}}
else if(this.settings.selected!==false){var tmp=Array();if((typeof this.settings.selected).toLowerCase()=="object"){$.each(this.settings.selected, function(){if(this.replace(/^#/,"").length > 0) tmp.push("#" + this.replace(/^#/,""))})}
else{if(this.settings.selected.replace(/^#/,"").length > 0) tmp.push("#" + this.settings.selected.replace(/^#/,""))}
this.settings.selected=tmp}
if(obj&&this.settings.data.async){this.opened=Array();obj=this.get_node(obj);obj.find("li.open").each(function(i){_this.opened.push("#"+this.id)});if(obj.hasClass("open")) obj.removeClass("open").addClass("closed");if(obj.hasClass("leaf")) obj.removeClass("leaf");obj.children("ul:eq(0)").html("");return this.open_branch(obj,true, function(){_this.reselect.apply(_this)})}
var _this=this;var _datastore=new $.tree.datastores[this.settings.data.type]();if(this.container.children("ul").size()==0){this.container.html("<ul class='ltr' style='direction:ltr;'><li class='last'><a class='loading' href='#'><ins>&nbsp;</ins>"+(this.settings.lang.loading||"Loading ...")+"</a></li></ul>")}
_datastore.load(this.callback("beforedata",[false,this]),this,this.settings.data.opts,function(data){data=_this.callback("ondata",[data,_this]);_datastore.parse(data,_this,_this.settings.data.opts,function(str){str=_this.callback("onparse",[str,_this]);_this.container.empty().append($("<ul class='ltr'>").html(str));_this.container.find("li:last-child").addClass("last").end().find("li:has(ul)").not(".open").addClass("closed");_this.container.find("li").not(".open").not(".closed").addClass("leaf");_this.reselect()})})},reselect: function(is_callback){var _this=this;if(!is_callback) this.cl_count=0;else this.cl_count--;if(this.opened&&this.opened.length){var opn=false;for(var j=0;this.opened&&j<this.opened.length;j++){if(this.settings.data.async){var tmp=this.get_node(this.opened[j]);if(tmp.size()&&tmp.hasClass("closed")>0){opn=true;var tmp=this.opened[j].toString().replace('/','\\/');delete this.opened[j];this.open_branch(tmp,true, function(){_this.reselect.apply(_this,[true])});this.cl_count++}}
else this.open_branch(this.opened[j],true)}
if(this.settings.data.async&&opn) return;if(this.cl_count>0) return;delete this.opened}
if(this.cl_count>0) return;this.container.css("direction","ltr").children("ul:eq(0)").addClass("ltr");if(this.settings.ui.dots==false) this.container.children("ul:eq(0)").addClass("no_dots");if(this.scrtop){this.container.scrollTop(_this.scrtop);delete this.scrtop}
if(this.settings.selected!==false){$.each(this.settings.selected, function(i){if(_this.is_partial_refresh) _this.select_branch($(_this.settings.selected[i].toString().replace('/','\\/'),_this.container),(_this.settings.rules.multiple!==false));else _this.select_branch($(_this.settings.selected[i].toString().replace('/','\\/'),_this.container),(_this.settings.rules.multiple!==false&&i>0))});this.settings.selected=false}
this.callback("onload",[_this])},get: function(obj,format,opts){if(!format) format=this.settings.data.type;if(!opts) opts=this.settings.data.opts;return new $.tree.datastores[format]().get(obj,this,opts)},attach_events: function(){var _this=this;this.container.bind("mousedown.jstree", function(event){if(tree_component.drag_drop.isdown){tree_component.drag_drop.move_type=false;event.preventDefault();event.stopPropagation();event.stopImmediatePropagation();return false}}).bind("mouseup.jstree", function(event){setTimeout( function(){_this.focus.apply(_this)},5)}).bind("click.jstree", function(event){return true});$("#"+this.container.attr("id")+" li").live("click", function(event){if(event.target.tagName!="LI") return true;_this.off_height();if(event.pageY-$(event.target).offset().top>_this.li_height) return true;_this.toggle_branch.apply(_this,[event.target]);event.stopPropagation();return false});$("#"+this.container.attr("id")+" li a").live("click.jstree", function(event){if(event.which&&event.which==3) return true;if(_this.locked){event.preventDefault();event.target.blur();return _this.error("LOCKED")}
_this.select_branch.apply(_this,[event.target,event.ctrlKey||_this.settings.rules.multiple=="on"]);if(_this.inp){_this.inp.blur()}
event.preventDefault();event.target.blur();return false}).live("dblclick.jstree", function(event){if(_this.locked){event.preventDefault();event.stopPropagation();event.target.blur();return _this.error("LOCKED")}
_this.callback("ondblclk",[_this.get_node(event.target).get(0),_this]);event.preventDefault();event.stopPropagation();event.target.blur()}).live("contextmenu.jstree", function(event){if(_this.locked){event.target.blur();return _this.error("LOCKED")}
return _this.callback("onrgtclk",[_this.get_node(event.target).get(0),_this,event])}).live("mouseover.jstree", function(event){if(_this.locked){event.preventDefault();event.stopPropagation();return _this.error("LOCKED")}
if(_this.hovered!==false&&(event.target.tagName=="A"||event.target.tagName=="INS")){_this.hovered.children("a").removeClass("hover");_this.hovered=false}
_this.callback("onhover",[_this.get_node(event.target).get(0),_this])}).live("mousedown.jstree", function(event){if(_this.settings.rules.drag_button=="left"&&event.which&&event.which!=1) return true;if(_this.settings.rules.drag_button=="right"&&event.which&&event.which!=3) return true;_this.focus.apply(_this);if(_this.locked) return _this.error("LOCKED");var obj=_this.get_node(event.target);if(_this.settings.rules.multiple!=false&&_this.selected_arr.length>1&&obj.children("a:eq(0)").hasClass("clicked")){var counter=0;for(var i in _this.selected_arr){if(!_this.selected_arr.hasOwnProperty(i)) continue;if(_this.check("draggable",_this.selected_arr[i])){_this.selected_arr[i].addClass("dragged");tree_component.drag_drop.origin_tree=_this;counter++}}
if(counter>0){if(_this.check("draggable",obj)) tree_component.drag_drop.drag_node=obj;else tree_component.drag_drop.drag_node=_this.container.find("li.dragged:eq(0)");tree_component.drag_drop.isdown=true;tree_component.drag_drop.drag_help=$("<div id='jstree-dragged' class='tree "+(_this.settings.ui.theme_name!=""?" tree-"+_this.settings.ui.theme_name:"")+"' />").append("<ul class='"+_this.container.children("ul:eq(0)").get(0).className+"' />");var tmp=tree_component.drag_drop.drag_node.clone();if(_this.settings.languages.length>0) tmp.find("a").not("."+_this.current_lang).hide();tree_component.drag_drop.drag_help.children("ul:eq(0)").append(tmp);tree_component.drag_drop.drag_help.find("li:eq(0)").removeClass("last").addClass("last").children("a").html("<ins>&nbsp;</ins>Multiple selection").end().children("ul").remove();tree_component.drag_drop.dragged=_this.container.find("li.dragged")}}
else{if(_this.check("draggable",obj)){tree_component.drag_drop.drag_node=obj;tree_component.drag_drop.drag_help=$("<div id='jstree-dragged' class='tree "+(_this.settings.ui.theme_name!=""?" tree-"+_this.settings.ui.theme_name:"")+"' />").append("<ul class='"+_this.container.children("ul:eq(0)").get(0).className+"' />");var tmp=obj.clone();if(_this.settings.languages.length>0) tmp.find("a").not("."+_this.current_lang).hide();tree_component.drag_drop.drag_help.children("ul:eq(0)").append(tmp);tree_component.drag_drop.drag_help.find("li:eq(0)").removeClass("last").addClass("last");tree_component.drag_drop.isdown=true;tree_component.drag_drop.foreign=false;tree_component.drag_drop.origin_tree=_this;obj.addClass("dragged");tree_component.drag_drop.dragged=_this.container.find("li.dragged")}}
tree_component.drag_drop.init_x=event.pageX;tree_component.drag_drop.init_y=event.pageY;obj.blur();event.preventDefault();event.stopPropagation();return false})},focus: function(){if(this.locked) return false;if(tree_component.focused!=this.cntr){tree_component.focused=this.cntr;this.callback("onfocus",[this])}},off_height: function(){if(this.offset===false){this.container.css({position:"relative"});this.offset=this.container.offset();var tmp=0;tmp=parseInt($.curCSS(this.container.get(0),"paddingTop",true),10);if(tmp) this.offset.top+=tmp;tmp=parseInt($.curCSS(this.container.get(0),"borderTopWidth",true),10);if(tmp) this.offset.top+=tmp;this.container.css({position:""})}
if(!this.li_height){var tmp=this.container.find("ul li.closed, ul li.leaf").eq(0);this.li_height=tmp.height();if(tmp.children("ul:eq(0)").size()) this.li_height-=tmp.children("ul:eq(0)").height();if(!this.li_height) this.li_height=18}},scroll_check: function(x,y){var _this=this;var cnt=_this.container;var off=_this.container.offset();var st=cnt.scrollTop();var sl=cnt.scrollLeft();var h_cor=(cnt.get(0).scrollWidth>cnt.width())?40:20;if(y-off.top<20) cnt.scrollTop(Math.max((st-_this.settings.ui.scroll_spd),0));if(cnt.height()-(y-off.top)<h_cor) cnt.scrollTop(st+_this.settings.ui.scroll_spd);if(x-off.left<20) cnt.scrollLeft(Math.max((sl-_this.settings.ui.scroll_spd),0));if(cnt.width()-(x-off.left)<40) cnt.scrollLeft(sl+_this.settings.ui.scroll_spd);if(cnt.scrollLeft()!=sl||cnt.scrollTop()!=st){tree_component.drag_drop.move_type=false;tree_component.drag_drop.ref_node=false;tree_component.drag_drop.marker.hide()}
tree_component.drag_drop.scroll_time=setTimeout( function(){_this.scroll_check(x,y)},50)},scroll_into_view: function(obj){obj=obj?this.get_node(obj):this.selected;if(!obj) return false;var off_t=obj.offset().top;var beg_t=this.container.offset().top;var end_t=beg_t+this.container.height();var h_cor=(this.container.get(0).scrollWidth>this.container.width())?40:20;if(off_t+5<beg_t) this.container.scrollTop(this.container.scrollTop()-(beg_t-off_t+5));if(off_t+h_cor>end_t) this.container.scrollTop(this.container.scrollTop()+(off_t+h_cor-end_t))},get_node: function(obj){return $(obj).closest("li")},get_type: function(obj){obj=!obj?this.selected:this.get_node(obj);if(!obj) return;var tmp=obj.attr(this.settings.rules.type_attr);return tmp||"default"},set_type: function(str,obj){obj=!obj?this.selected:this.get_node(obj);if(!obj||!str) return;obj.attr(this.settings.rules.type_attr,str)},get_text: function(obj,lang){obj=this.get_node(obj);if(!obj||obj.size()==0) return "";if(this.settings.languages&&this.settings.languages.length){lang=lang?lang:this.current_lang;obj=obj.children("a."+lang)}
else obj=obj.children("a:visible");var val="";obj.contents().each(function(){if(this.nodeType==3){val=this.data;return false}});return val},check: function(rule,obj){if(this.locked) return false;var v=false;if(obj===-1){if(typeof this.settings.rules[rule]!="undefined") v=this.settings.rules[rule]}
else{obj=!obj?this.selected:this.get_node(obj);if(!obj) return;var t=this.get_type(obj);if(typeof this.settings.types[t]!="undefined"&&typeof this.settings.types[t][rule]!="undefined") v=this.settings.types[t][rule];else if(typeof this.settings.types["default"]!="undefined"&&typeof this.settings.types["default"][rule]!="undefined") v=this.settings.types["default"][rule]}
if(typeof v=="function") v=v.call(null,obj,this);v=this.callback("check",[rule,obj,v,this]);return v},check_move: function(nod,ref_node,how){if(this.locked) return false;if($(ref_node).closest("li.dragged").size()) return false;var tree1=nod.parents(".tree:eq(0)").get(0);var tree2=ref_node.parents(".tree:eq(0)").get(0);if(tree1&&tree1!=tree2){var m=$.tree.reference(tree2.id).settings.rules.multitree;if(m=="none"||($.isArray(m)&&$.inArray(tree1.id,m)==-1)) return false}
var p=(how!="inside")?this.parent(ref_node):this.get_node(ref_node);nod=this.get_node(nod);if(p==false) return false;var r={max_depth:this.settings.rules.use_max_depth?this.check("max_depth",p):-1,max_children:this.settings.rules.use_max_children?this.check("max_children",p):-1,valid_children:this.check("valid_children",p)};var nod_type=(typeof nod=="string")?nod:this.get_type(nod);if(typeof r.valid_children!="undefined"&&(r.valid_children=="none"||(typeof r.valid_children=="object"&&$.inArray(nod_type,$.makeArray(r.valid_children))==-1))) return false;if(this.settings.rules.use_max_children){if(typeof r.max_children!="undefined"&&r.max_children!=-1){if(r.max_children==0) return false;var c_count=1;if(tree_component.drag_drop.moving==true&&tree_component.drag_drop.foreign==false){c_count=tree_component.drag_drop.dragged.size();c_count=c_count-p.find('> ul > li.dragged').size()}
if(r.max_children<p.find('> ul > li').size()+c_count) return false}}
if(this.settings.rules.use_max_depth){if(typeof r.max_depth!="undefined"&&r.max_depth===0) return this.error("MOVE: MAX-DEPTH REACHED");var mx=(r.max_depth>0)?r.max_depth:false;var i=0;var t=p;while(t!==-1){t=this.parent(t);i++;var m=this.check("max_depth",t);if(m>=0){mx=(mx===false)?(m-i):Math.min(mx,m-i)}
if(mx!==false&&mx<=0) return this.error("MOVE: MAX-DEPTH REACHED")}
if(mx!==false&&mx<=0) return this.error("MOVE: MAX-DEPTH REACHED");if(mx!==false){var incr=1;if(typeof nod!="string"){var t=nod;while(t.size()>0){if(mx-incr<0) return this.error("MOVE: MAX-DEPTH REACHED");t=t.children("ul").children("li");incr++}}}}
if(this.callback("check_move",[nod,ref_node,how,this])==false) return false;return true},hover_branch: function(obj){if(this.locked) return this.error("LOCKED");var _this=this;var obj=_this.get_node(obj);if(!obj.size()) return this.error("HOVER: NOT A VALID NODE");if(!_this.check("clickable",obj)) return this.error("SELECT: NODE NOT SELECTABLE");if(this.hovered) this.hovered.children("A").removeClass("hover");this.hovered=obj;this.hovered.children("a").addClass("hover");this.scroll_into_view(this.hovered)},select_branch: function(obj,multiple){if(this.locked) return this.error("LOCKED");if(!obj&&this.hovered!==false) obj=this.hovered;var _this=this;obj=_this.get_node(obj);if(!obj.size()) return this.error("SELECT: NOT A VALID NODE");obj.children("a").removeClass("hover");if(!_this.check("clickable",obj)) return this.error("SELECT: NODE NOT SELECTABLE");if(_this.callback("beforechange",[obj.get(0),_this])===false) return this.error("SELECT: STOPPED BY USER");if(this.settings.rules.multiple!=false&&multiple&&obj.children("a.clicked").size()>0){return this.deselect_branch(obj)}
if(this.settings.rules.multiple!=false&&multiple){this.selected_arr.push(obj)}
if(this.settings.rules.multiple!=false&&!multiple){for(var i in this.selected_arr){if(!this.selected_arr.hasOwnProperty(i)) continue;this.selected_arr[i].children("A").removeClass("clicked");this.callback("ondeselect",[this.selected_arr[i].get(0),_this])}
this.selected_arr=[];this.selected_arr.push(obj);if(this.selected&&this.selected.children("A").hasClass("clicked")){this.selected.children("A").removeClass("clicked");this.callback("ondeselect",[this.selected.get(0),_this])}}
if(!this.settings.rules.multiple){if(this.selected){this.selected.children("A").removeClass("clicked");this.callback("ondeselect",[this.selected.get(0),_this])}}
this.selected=obj;if(this.hovered!==false){this.hovered.children("A").removeClass("hover");this.hovered=obj}
this.selected.children("a").addClass("clicked").end().parents("li.closed").each( function(){_this.open_branch(this,true)});this.scroll_into_view(this.selected);this.callback("onselect",[this.selected.get(0),_this]);this.callback("onchange",[this.selected.get(0),_this])},deselect_branch: function(obj){if(this.locked) return this.error("LOCKED");var _this=this;var obj=this.get_node(obj);if(obj.children("a.clicked").size()==0) return this.error("DESELECT: NODE NOT SELECTED");obj.children("a").removeClass("clicked");this.callback("ondeselect",[obj.get(0),_this]);if(this.settings.rules.multiple!=false&&this.selected_arr.length>1){this.selected_arr=[];this.container.find("a.clicked").filter(":first-child").parent().each(function(){_this.selected_arr.push($(this))});if(obj.get(0)==this.selected.get(0)){this.selected=this.selected_arr[0]}}
else{if(this.settings.rules.multiple!=false) this.selected_arr=[];this.selected=false}
this.callback("onchange",[obj.get(0),_this])},toggle_branch: function(obj){if(this.locked) return this.error("LOCKED");var obj=this.get_node(obj);if(obj.hasClass("closed")) return this.open_branch(obj);if(obj.hasClass("open")) return this.close_branch(obj)},open_branch: function(obj,disable_animation,callback){var _this=this;if(this.locked) return this.error("LOCKED");var obj=this.get_node(obj);if(!obj.size()) return this.error("OPEN: NO SUCH NODE");if(obj.hasClass("leaf")) return this.error("OPEN: OPENING LEAF NODE");if(this.settings.data.async&&obj.find("li").size()==0){if(this.callback("beforeopen",[obj.get(0),this])===false) return this.error("OPEN: STOPPED BY USER");obj.children("ul:eq(0)").remove().end().append("<ul><li class='last'><a class='loading' href='#'><ins>&nbsp;</ins>"+(_this.settings.lang.loading||"Loading ...")+"</a></li></ul>");obj.removeClass("closed").addClass("open");var _datastore=new $.tree.datastores[this.settings.data.type]();_datastore.load(this.callback("beforedata",[obj,this]),this,this.settings.data.opts,function(data){data=_this.callback("ondata",[data,_this]);if(!data||data.length==0){obj.removeClass("closed").removeClass("open").addClass("leaf").children("ul").remove();if(callback) callback.call();return}
_datastore.parse(data,_this,_this.settings.data.opts,function(str){str=_this.callback("onparse",[str,_this]);obj.children("ul:eq(0)").replaceWith($("<ul>").html(str));obj.find("li:last-child").addClass("last").end().find("li:has(ul)").not(".open").addClass("closed");obj.find("li").not(".open").not(".closed").addClass("leaf");_this.open_branch.apply(_this,[obj]);if(callback) callback.call()})});return true}
else{if(!this.settings.data.async){if(this.callback("beforeopen",[obj.get(0),this])===false) return this.error("OPEN: STOPPED BY USER")}
if(parseInt(this.settings.ui.animation)>0&&!disable_animation){obj.children("ul:eq(0)").css("display","none");obj.removeClass("closed").addClass("open");obj.children("ul:eq(0)").slideDown(parseInt(this.settings.ui.animation), function(){$(this).css("display","");if(callback) callback.call()})} else{obj.removeClass("closed").addClass("open");if(callback) callback.call()}
this.callback("onopen",[obj.get(0),this]);return true}},close_branch: function(obj,disable_animation){if(this.locked) return this.error("LOCKED");var _this=this;var obj=this.get_node(obj);if(!obj.size()) return this.error("CLOSE: NO SUCH NODE");if(_this.callback("beforeclose",[obj.get(0),_this])===false) return this.error("CLOSE: STOPPED BY USER");if(parseInt(this.settings.ui.animation)>0&&!disable_animation&&obj.children("ul:eq(0)").size()==1){obj.children("ul:eq(0)").slideUp(parseInt(this.settings.ui.animation), function(){if(obj.hasClass("open")) obj.removeClass("open").addClass("closed");$(this).css("display","")})}
else{if(obj.hasClass("open")) obj.removeClass("open").addClass("closed")}
if(this.selected&&this.settings.ui.selected_parent_close!==false&&obj.children("ul:eq(0)").find("a.clicked").size()>0){obj.find("li:has(a.clicked)").each(function(){_this.deselect_branch(this)});if(this.settings.ui.selected_parent_close=="select_parent"&&obj.children("a.clicked").size()==0) this.select_branch(obj,(this.settings.rules.multiple!=false&&this.selected_arr.length>0))}
this.callback("onclose",[obj.get(0),this])},open_all: function(obj,callback){if(this.locked) return this.error("LOCKED");var _this=this;obj=obj?this.get_node(obj):this.container;var s=obj.find("li.closed").size();if(!callback) this.cl_count=0;else this.cl_count--;if(s>0){this.cl_count+=s;obj.find("li.closed").each( function(){var __this=this;_this.open_branch.apply(_this,[this,true, function(){_this.open_all.apply(_this,[__this,true])}])})}
else if(this.cl_count==0) this.callback("onopen_all",[this])},close_all: function(obj){if(this.locked) return this.error("LOCKED");var _this=this;obj=obj?this.get_node(obj):this.container;obj.find("li.open").each( function(){_this.close_branch(this,true)});this.callback("onclose_all",[this])},set_lang: function(i){if(!$.isArray(this.settings.languages)||this.settings.languages.length==0) return false;if(this.locked) return this.error("LOCKED");if(!$.inArray(i,this.settings.languages)&&typeof this.settings.languages[i]!="undefined") i=this.settings.languages[i];if(typeof i=="undefined") return false;if(i==this.current_lang) return true;var st=false;var id="#"+this.container.attr("id");st=tree_component.get_css(id+" ."+this.current_lang);if(st!==false) st.style.display="none";st=tree_component.get_css(id+" ."+i);if(st!==false) st.style.display="";this.current_lang=i;return true},get_lang: function(){if(!$.isArray(this.settings.languages)||this.settings.languages.length==0) return false;return this.current_lang},create: function(obj,ref_node,position){if(this.locked) return this.error("LOCKED");var root=false;if(ref_node==-1){root=true;ref_node=this.container}
else ref_node=ref_node?this.get_node(ref_node):this.selected;if(!root&&(!ref_node||!ref_node.size())) return this.error("CREATE: NO NODE SELECTED");var pos=position;var tmp=ref_node;if(position=="before"){position=ref_node.parent().children().index(ref_node);ref_node=ref_node.parents("li:eq(0)")}
if(position=="after"){position=ref_node.parent().children().index(ref_node)+1;ref_node=ref_node.parents("li:eq(0)")}
if(!root&&ref_node.size()==0){root=true;ref_node=this.container}
if(!root){if(!this.check("creatable",ref_node)) return this.error("CREATE: CANNOT CREATE IN NODE");if(ref_node.hasClass("closed")){if(this.settings.data.async&&ref_node.children("ul").size()==0){var _this=this;return this.open_branch(ref_node,true, function(){_this.create.apply(_this,[obj,ref_node,position])})}
else this.open_branch(ref_node,true)}}
var torename=false;if(!obj) obj={};else obj=$.extend(true,{},obj);if(!obj.attributes) obj.attributes={};if(!obj.attributes[this.settings.rules.type_attr]) obj.attributes[this.settings.rules.type_attr]=this.get_type(tmp)||"default";if(this.settings.languages.length){if(!obj.data){obj.data={};torename=true}
for(var i=0;i<this.settings.languages.length;i++){if(!obj.data[this.settings.languages[i]]) obj.data[this.settings.languages[i]]=((typeof this.settings.lang.new_node).toLowerCase()!="string"&&this.settings.lang.new_node[i])?this.settings.lang.new_node[i]:this.settings.lang.new_node}}
else{if(!obj.data){obj.data=this.settings.lang.new_node;torename=true}}
obj=this.callback("ondata",[obj,this]);var obj_s=$.tree.datastores.json().parse(obj,this);obj_s=this.callback("onparse",[obj_s,this]);var $li=$(obj_s);if($li.children("ul").size()){if(!$li.is(".open")) $li.addClass("closed")}
else $li.addClass("leaf");$li.find("li:last-child").addClass("last").end().find("li:has(ul)").not(".open").addClass("closed");$li.find("li").not(".open").not(".closed").addClass("leaf");var r={max_depth:this.settings.rules.use_max_depth?this.check("max_depth",(root?-1:ref_node)):-1,max_children:this.settings.rules.use_max_children?this.check("max_children",(root?-1:ref_node)):-1,valid_children:this.check("valid_children",(root?-1:ref_node))};var nod_type=this.get_type($li);if(typeof r.valid_children!="undefined"&&(r.valid_children=="none"||($.isArray(r.valid_children)&&$.inArray(nod_type,r.valid_children)==-1))) return this.error("CREATE: NODE NOT A VALID CHILD");if(this.settings.rules.use_max_children){if(typeof r.max_children!="undefined"&&r.max_children!=-1&&r.max_children>=this.children(ref_node).size()) return this.error("CREATE: MAX_CHILDREN REACHED")}
if(this.settings.rules.use_max_depth){if(typeof r.max_depth!="undefined"&&r.max_depth===0) return this.error("CREATE: MAX-DEPTH REACHED");var mx=(r.max_depth>0)?r.max_depth:false;var i=0;var t=ref_node;while(t!==-1&&!root){t=this.parent(t);i++;var m=this.check("max_depth",t);if(m>=0){mx=(mx===false)?(m-i):Math.min(mx,m-i)}
if(mx!==false&&mx<=0) return this.error("CREATE: MAX-DEPTH REACHED")}
if(mx!==false&&mx<=0) return this.error("CREATE: MAX-DEPTH REACHED");if(mx!==false){var incr=1;var t=$li;while(t.size()>0){if(mx-incr<0) return this.error("CREATE: MAX-DEPTH REACHED");t=t.children("ul").children("li");incr++}}}
if((typeof position).toLowerCase()=="undefined"||position=="inside")
position=(this.settings.rules.createat=="top")?0:ref_node.children("ul:eq(0)").children("li").size();if(ref_node.children("ul").size()==0||(root==true&&ref_node.children("ul").children("li").size()==0)){if(!root) var a=this.moved($li,ref_node.children("a:eq(0)"),"inside",true);else var a=this.moved($li,this.container.children("ul:eq(0)"),"inside",true)}
else if(pos=="before"&&ref_node.children("ul:eq(0)").children("li:nth-child("+(position+1)+")").size())
var a=this.moved($li,ref_node.children("ul:eq(0)").children("li:nth-child("+(position+1)+")").children("a:eq(0)"),"before",true);else if(pos=="after"&&ref_node.children("ul:eq(0)").children("li:nth-child("+(position)+")").size())
var a=this.moved($li,ref_node.children("ul:eq(0)").children("li:nth-child("+(position)+")").children("a:eq(0)"),"after",true);else if(ref_node.children("ul:eq(0)").children("li:nth-child("+(position+1)+")").size())
var a=this.moved($li,ref_node.children("ul:eq(0)").children("li:nth-child("+(position+1)+")").children("a:eq(0)"),"before",true);else
var a=this.moved($li,ref_node.children("ul:eq(0)").children("li:last").children("a:eq(0)"),"after",true);if(a===false) return this.error("CREATE: ABORTED");if(torename){this.select_branch($li.children("a:eq(0)"));this.rename()}
return $li},rename: function(obj,new_name){if(this.locked) return this.error("LOCKED");obj=obj?this.get_node(obj):this.selected;var _this=this;if(!obj||!obj.size()) return this.error("RENAME: NO NODE SELECTED");if(!this.check("renameable",obj)) return this.error("RENAME: NODE NOT RENAMABLE");if(!this.callback("beforerename",[obj.get(0),_this.current_lang,_this])) return this.error("RENAME: STOPPED BY USER");obj.parents("li.closed").each(function(){_this.open_branch(this)});if(this.current_lang) obj=obj.find("a."+this.current_lang);else obj=obj.find("a:first");var rb={};rb[this.container.attr("id")]=this.get_rollback();var icn=obj.children("ins").clone();if((typeof new_name).toLowerCase()=="string"){obj.text(new_name).prepend(icn);_this.callback("onrename",[_this.get_node(obj).get(0),_this,rb])}
else{var last_value="";obj.contents().each(function(){if(this.nodeType==3){last_value=this.data;return false}});_this.inp=$("<input type='text' autocomplete='off' />");_this.inp.val(last_value.replace(/&amp;/g,"&").replace(/&gt;/g,">").replace(/&lt;/g,"<")).bind("mousedown", function(event){event.stopPropagation()}).bind("mouseup", function(event){event.stopPropagation()}).bind("click", function(event){event.stopPropagation()}).bind("keyup", function(event){var key=event.keyCode||event.which;if(key==27){this.value=last_value;this.blur();return}
if(key==13){this.blur();return}});_this.inp.blur(function(event){if(this.value=="") this.value=last_value;obj.text(this.value).prepend(icn);obj.get(0).style.display="";obj.prevAll("span").remove();_this.inp=false;_this.callback("onrename",[_this.get_node(obj).get(0),_this,rb])});var spn=$("<span />").addClass(obj.attr("class")).append(icn).append(_this.inp);obj.get(0).style.display="none";obj.parent().prepend(spn);_this.inp.get(0).focus();_this.inp.get(0).select()}},remove: function(obj){if(this.locked) return this.error("LOCKED");var _this=this;var rb={};rb[this.container.attr("id")]=this.get_rollback();if(obj&&(!this.selected||this.get_node(obj).get(0)!=this.selected.get(0))){obj=this.get_node(obj);if(obj.size()){if(!this.check("deletable",obj)) return this.error("DELETE: NODE NOT DELETABLE");if(!this.callback("beforedelete",[obj.get(0),_this])) return this.error("DELETE: STOPPED BY USER");$parent=obj.parent();if(obj.find("a.clicked").size()){var reset_selected=false;_this.selected_arr=[];this.container.find("a.clicked").filter(":first-child").parent().each(function(){if(!reset_selected&&this==_this.selected.get(0)) reset_selected=true;if($(this).parents().index(obj)!=-1) return true;_this.selected_arr.push($(this))});if(reset_selected) this.selected=this.selected_arr[0]||false}
obj=obj.remove();$parent.children("li:last").addClass("last");if($parent.children("li").size()==0){$li=$parent.parents("li:eq(0)");$li.removeClass("open").removeClass("closed").addClass("leaf").children("ul").remove()}
this.callback("ondelete",[obj.get(0),this,rb])}}
else if(this.selected){if(!this.check("deletable",this.selected)) return this.error("DELETE: NODE NOT DELETABLE");if(!this.callback("beforedelete",[this.selected.get(0),_this])) return this.error("DELETE: STOPPED BY USER");$parent=this.selected.parent();var obj=this.selected;if(this.settings.rules.multiple==false||this.selected_arr.length==1){var stop=true;var tmp=this.settings.ui.selected_delete=="select_previous"?this.prev(this.selected):false}
obj=obj.remove();$parent.children("li:last").addClass("last");if($parent.children("li").size()==0){$li=$parent.parents("li:eq(0)");$li.removeClass("open").removeClass("closed").addClass("leaf").children("ul").remove()}
if(!stop&&this.settings.rules.multiple!=false){var _this=this;this.selected_arr=[];this.container.find("a.clicked").filter(":first-child").parent().each(function(){_this.selected_arr.push($(this))});if(this.selected_arr.length>0){this.selected=this.selected_arr[0];this.remove()}}
if(stop&&tmp) this.select_branch(tmp);this.callback("ondelete",[obj.get(0),this,rb])}
else return this.error("DELETE: NO NODE SELECTED")},next: function(obj,strict){obj=this.get_node(obj);if(!obj.size()) return false;if(strict) return(obj.nextAll("li").size()>0)?obj.nextAll("li:eq(0)"):false;if(obj.hasClass("open")) return obj.find("li:eq(0)");else if(obj.nextAll("li").size()>0) return obj.nextAll("li:eq(0)");else return obj.parents("li").next("li").eq(0)},prev: function(obj,strict){obj=this.get_node(obj);if(!obj.size()) return false;if(strict) return(obj.prevAll("li").size()>0)?obj.prevAll("li:eq(0)"):false;if(obj.prev("li").size()){var obj=obj.prev("li").eq(0);while(obj.hasClass("open")) obj=obj.children("ul:eq(0)").children("li:last");return obj}
else return obj.parents("li:eq(0)").size()?obj.parents("li:eq(0)"):false},parent: function(obj){obj=this.get_node(obj);if(!obj.size()) return false;return obj.parents("li:eq(0)").size()?obj.parents("li:eq(0)"):-1},children: function(obj){if(obj===-1) return this.container.children("ul:eq(0)").children("li");obj=this.get_node(obj);if(!obj.size()) return false;return obj.children("ul:eq(0)").children("li")},toggle_dots: function(){if(this.settings.ui.dots){this.settings.ui.dots=false;this.container.children("ul:eq(0)").addClass("no_dots")}
else{this.settings.ui.dots=true;this.container.children("ul:eq(0)").removeClass("no_dots")}},callback: function(cb,args){var p=false;var r=null;for(var i in this.settings.plugins){if(typeof $.tree.plugins[i]!="object") continue;p=$.tree.plugins[i];if(p.callbacks&&typeof p.callbacks[cb]=="function") r=p.callbacks[cb].apply(this,args);if(typeof r!=="undefined"&&r!==null){if(cb=="ondata"||cb=="onparse") args[0]=r;else return r}}
p=this.settings.callback[cb];if(typeof p=="function") return p.apply(null,args)},get_rollback: function(){var rb={};rb.html=this.container.html();rb.selected=this.selected?this.selected.attr("id"):false;return rb},moved: function(what,where,how,is_new,is_copy,rb){var what=$(what);var $parent=$(what).parents("ul:eq(0)");var $where=$(where);if($where.is("ins")) $where=$where.parent();if(!rb){var rb={};rb[this.container.attr("id")]=this.get_rollback();if(!is_new){var tmp=what.size()>1?what.eq(0).parents(".tree:eq(0)"):what.parents(".tree:eq(0)");if(tmp.get(0)!=this.container.get(0)){tmp=tree_component.inst[tmp.attr("id")];rb[tmp.container.attr("id")]=tmp.get_rollback()}
delete tmp}}
if(how=="inside"&&this.settings.data.async){var _this=this;if(this.get_node($where).hasClass("closed")){return this.open_branch(this.get_node($where),true, function(){_this.moved.apply(_this,[what,where,how,is_new,is_copy,rb])})}
if(this.get_node($where).find("> ul > li > a.loading").size()==1){setTimeout(function(){_this.moved.apply(_this,[what,where,how,is_new,is_copy])},200);return}}
if(what.size()>1){var _this=this;var tmp=this.moved(what.eq(0),where,how,false,is_copy,rb);what.each(function(i){if(i==0) return;if(tmp){tmp=_this.moved(this,tmp.children("a:eq(0)"),"after",false,is_copy,rb)}});return what}
if(is_copy){_what=what.clone();_what.each(function(i){this.id=this.id+"_copy";$(this).find("li").each(function(){this.id=this.id+"_copy"});$(this).removeClass("dragged").find("a.clicked").removeClass("clicked").end().find("li.dragged").removeClass("dragged")})}
else _what=what;if(is_new){if(!this.callback("beforecreate",[this.get_node(what).get(0),this.get_node(where).get(0),how,this])) return false}
else{if(!this.callback("beforemove",[this.get_node(what).get(0),this.get_node(where).get(0),how,this])) return false}
if(!is_new){var tmp=what.parents(".tree:eq(0)");if(tmp.get(0)!=this.container.get(0)){tmp=tree_component.inst[tmp.attr("id")];if(tmp.settings.languages.length){var res=[];if(this.settings.languages.length==0) res.push("."+tmp.current_lang);else{for(var i in this.settings.languages){if(!this.settings.languages.hasOwnProperty(i)) continue;for(var j in tmp.settings.languages){if(!tmp.settings.languages.hasOwnProperty(j)) continue;if(this.settings.languages[i]==tmp.settings.languages[j]) res.push("."+this.settings.languages[i])}}}
if(res.length==0) return this.error("MOVE: NO COMMON LANGUAGES");_what.find("a").not(res.join(",")).remove()}
_what.find("a.clicked").removeClass("clicked")}}
what=_what;switch(how){case "before":$where.parents("ul:eq(0)").children("li.last").removeClass("last");$where.parent().before(what.removeClass("last"));$where.parents("ul:eq(0)").children("li:last").addClass("last");break;case "after":$where.parents("ul:eq(0)").children("li.last").removeClass("last");$where.parent().after(what.removeClass("last"));$where.parents("ul:eq(0)").children("li:last").addClass("last");break;case "inside":if($where.parent().children("ul:first").size()){if(this.settings.rules.createat=="top"){$where.parent().children("ul:first").prepend(what.removeClass("last")).children("li:last").addClass("last");var tmp_node=$where.parent().children("ul:first").children("li:first");if(tmp_node.size()){how="before";where=tmp_node}}
else{var tmp_node=$where.parent().children("ul:first").children(".last");if(tmp_node.size()){how="after";where=tmp_node}
$where.parent().children("ul:first").children(".last").removeClass("last").end().append(what.removeClass("last")).children("li:last").addClass("last")}}
else{what.addClass("last");$where.parent().removeClass("leaf").append("<ul/>");if(!$where.parent().hasClass("open")) $where.parent().addClass("closed");$where.parent().children("ul:first").prepend(what)}
if($where.parent().hasClass("closed")){this.open_branch($where)}
break;default:break}
if($parent.find("li").size()==0){var $li=$parent.parent();$li.removeClass("open").removeClass("closed").addClass("leaf");if(!$li.is(".tree")) $li.children("ul").remove();$li.parents("ul:eq(0)").children("li.last").removeClass("last").end().children("li:last").addClass("last")}
else{$parent.children("li.last").removeClass("last");$parent.children("li:last").addClass("last")}
if(is_copy) this.callback("oncopy",[this.get_node(what).get(0),this.get_node(where).get(0),how,this,rb]);else if(is_new) this.callback("oncreate",[this.get_node(what).get(0),($where.is("ul")?-1:this.get_node(where).get(0)),how,this,rb]);else this.callback("onmove",[this.get_node(what).get(0),this.get_node(where).get(0),how,this,rb]);return what},error: function(code){this.callback("error",[code,this]);return false},lock: function(state){this.locked=state;if(this.locked) this.container.children("ul:eq(0)").addClass("locked");else this.container.children("ul:eq(0)").removeClass("locked")},cut: function(obj){if(this.locked) return this.error("LOCKED");obj=obj?this.get_node(obj):this.container.find("a.clicked").filter(":first-child").parent();if(!obj||!obj.size()) return this.error("CUT: NO NODE SELECTED");tree_component.cut_copy.copy_nodes=false;tree_component.cut_copy.cut_nodes=obj},copy: function(obj){if(this.locked) return this.error("LOCKED");obj=obj?this.get_node(obj):this.container.find("a.clicked").filter(":first-child").parent();if(!obj||!obj.size()) return this.error("COPY: NO NODE SELECTED");tree_component.cut_copy.copy_nodes=obj;tree_component.cut_copy.cut_nodes=false},paste: function(obj,position){if(this.locked) return this.error("LOCKED");var root=false;if(obj==-1){root=true;obj=this.container}
else obj=obj?this.get_node(obj):this.selected;if(!root&&(!obj||!obj.size())) return this.error("PASTE: NO NODE SELECTED");if(!tree_component.cut_copy.copy_nodes&&!tree_component.cut_copy.cut_nodes) return this.error("PASTE: NOTHING TO DO");var _this=this;var pos=position;if(position=="before"){position=obj.parent().children().index(obj);obj=obj.parents("li:eq(0)")}
else if(position=="after"){position=obj.parent().children().index(obj)+1;obj=obj.parents("li:eq(0)")}
else if((typeof position).toLowerCase()=="undefined"||position=="inside"){position=(this.settings.rules.createat=="top")?0:obj.children("ul:eq(0)").children("li").size()}
if(!root&&obj.size()==0){root=true;obj=this.container}
if(tree_component.cut_copy.copy_nodes&&tree_component.cut_copy.copy_nodes.size()){var ok=true;if(!root&&!this.check_move(tree_component.cut_copy.copy_nodes,obj.children("a:eq(0)"),"inside")) return false;if(obj.children("ul").size()==0||(root==true&&obj.children("ul").children("li").size()==0)){if(!root) var a=this.moved(tree_component.cut_copy.copy_nodes,obj.children("a:eq(0)"),"inside",false,true);else var a=this.moved(tree_component.cut_copy.copy_nodes,this.container.children("ul:eq(0)"),"inside",false,true)}
else if(pos=="before"&&obj.children("ul:eq(0)").children("li:nth-child("+(position+1)+")").size())
var a=this.moved(tree_component.cut_copy.copy_nodes,obj.children("ul:eq(0)").children("li:nth-child("+(position+1)+")").children("a:eq(0)"),"before",false,true);else if(pos=="after"&&obj.children("ul:eq(0)").children("li:nth-child("+(position)+")").size())
var a=this.moved(tree_component.cut_copy.copy_nodes,obj.children("ul:eq(0)").children("li:nth-child("+(position)+")").children("a:eq(0)"),"after",false,true);else if(obj.children("ul:eq(0)").children("li:nth-child("+(position+1)+")").size())
var a=this.moved(tree_component.cut_copy.copy_nodes,obj.children("ul:eq(0)").children("li:nth-child("+(position+1)+")").children("a:eq(0)"),"before",false,true);else
var a=this.moved(tree_component.cut_copy.copy_nodes,obj.children("ul:eq(0)").children("li:last").children("a:eq(0)"),"after",false,true);tree_component.cut_copy.copy_nodes=false}
if(tree_component.cut_copy.cut_nodes&&tree_component.cut_copy.cut_nodes.size()){var ok=true;obj.parents().andSelf().each(function(){if(tree_component.cut_copy.cut_nodes.index(this)!=-1){ok=false;return false}});if(!ok) return this.error("Invalid paste");if(!root&&!this.check_move(tree_component.cut_copy.cut_nodes,obj.children("a:eq(0)"),"inside")) return false;if(obj.children("ul").size()==0||(root==true&&obj.children("ul").children("li").size()==0)){if(!root) var a=this.moved(tree_component.cut_copy.cut_nodes,obj.children("a:eq(0)"),"inside");else var a=this.moved(tree_component.cut_copy.cut_nodes,this.container.children("ul:eq(0)"),"inside")}
else if(pos=="before"&&obj.children("ul:eq(0)").children("li:nth-child("+(position+1)+")").size())
var a=this.moved(tree_component.cut_copy.cut_nodes,obj.children("ul:eq(0)").children("li:nth-child("+(position+1)+")").children("a:eq(0)"),"before");else if(pos=="after"&&obj.children("ul:eq(0)").children("li:nth-child("+(position)+")").size())
var a=this.moved(tree_component.cut_copy.cut_nodes,obj.children("ul:eq(0)").children("li:nth-child("+(position)+")").children("a:eq(0)"),"after");else if(obj.children("ul:eq(0)").children("li:nth-child("+(position+1)+")").size())
var a=this.moved(tree_component.cut_copy.cut_nodes,obj.children("ul:eq(0)").children("li:nth-child("+(position+1)+")").children("a:eq(0)"),"before");else
var a=this.moved(tree_component.cut_copy.cut_nodes,obj.children("ul:eq(0)").children("li:last").children("a:eq(0)"),"after");tree_component.cut_copy.cut_nodes=false}},search: function(str,func){var _this=this;if(!str||(this.srch&&str!=this.srch)){this.srch="";this.srch_opn=false;this.container.find("a.search").removeClass("search")}
this.srch=str;if(!str) return;if(!func) func="contains";if(this.settings.data.async){if(!this.srch_opn){var dd=$.extend({"search":str},this.callback("beforedata",[false,this]));$.ajax({type:this.settings.data.opts.method,url:this.settings.data.opts.url,data:dd,dataType:"text",success: function(data){_this.srch_opn=$.unique(data.split(","));_this.search.apply(_this,[str,func])}})}
else if(this.srch_opn.length){if(this.srch_opn&&this.srch_opn.length){var opn=false;for(var j=0;j<this.srch_opn.length;j++){if(this.get_node("#"+this.srch_opn[j]).size()>0){opn=true;var tmp="#"+this.srch_opn[j];delete this.srch_opn[j];this.open_branch(tmp,true, function(){_this.search.apply(_this,[str,func])})}}
if(!opn){this.srch_opn=[];_this.search.apply(_this,[str,func])}}}
else{this.srch_opn=false;var selector="a";if(this.settings.languages.length) selector+="."+this.current_lang;this.callback("onsearch",[this.container.find(selector+":"+func+"('"+str+"')"),this])}}
else{var selector="a";if(this.settings.languages.length) selector+="."+this.current_lang;var nn=this.container.find(selector+":"+func+"('"+str+"')");nn.parents("li.closed").each( function(){_this.open_branch(this,true)});this.callback("onsearch",[nn,this])}},add_sheet:tree_component.add_sheet,destroy: function(){this.callback("ondestroy",[this]);this.container.unbind(".jstree");$("#"+this.container.attr("id")).die("click.jstree").die("dblclick.jstree").die("mouseover.jstree").die("mouseout.jstree").die("mousedown.jstree");this.container.removeClass("tree ui-widget ui-widget-content tree-default tree-"+this.settings.ui.theme_name).children("ul").removeClass("no_dots ltr locked").find("li").removeClass("leaf").removeClass("open").removeClass("closed").removeClass("last").children("a").removeClass("clicked hover search");if(this.cntr==tree_component.focused){for(var i in tree_component.inst){if(i!=this.cntr&&i!=this.container.attr("id")){tree_component.inst[i].focus();break}}}
tree_component.inst[this.cntr]=false;tree_component.inst[this.container.attr("id")]=false;delete tree_component.inst[this.cntr];delete tree_component.inst[this.container.attr("id")];tree_component.cntr--}}};tree_component.cntr=0;tree_component.inst={};tree_component.themes=[];tree_component.drag_drop={isdown:false,drag_node:false,drag_help:false,dragged:false,init_x:false,init_y:false,moving:false,origin_tree:false,marker:false,move_type:false,ref_node:false,appended:false,foreign:false,droppable:[],open_time:false,scroll_time:false};tree_component.mouseup=function(event){var tmp=tree_component.drag_drop;if(tmp.open_time) clearTimeout(tmp.open_time);if(tmp.scroll_time) clearTimeout(tmp.scroll_time);if(tmp.moving&&$.tree.drag_end!==false) $.tree.drag_end.call(null,event,tmp);if(tmp.foreign===false&&tmp.drag_node&&tmp.drag_node.size()){tmp.drag_help.remove();if(tmp.move_type){var tree1=tree_component.inst[tmp.ref_node.parents(".tree:eq(0)").attr("id")];if(tree1) tree1.moved(tmp.dragged,tmp.ref_node,tmp.move_type,false,(tmp.origin_tree.settings.rules.drag_copy=="on"||(tmp.origin_tree.settings.rules.drag_copy=="ctrl"&&event.ctrlKey)))}
tmp.move_type=false;tmp.ref_node=false}
if(tmp.foreign!==false){if(tmp.drag_help) tmp.drag_help.remove();if(tmp.move_type){var tree1=tree_component.inst[tmp.ref_node.parents(".tree:eq(0)").attr("id")];if(tree1) tree1.callback("ondrop",[tmp.f_data,tree1.get_node(tmp.ref_node).get(0),tmp.move_type,tree1])}
tmp.foreign=false;tmp.move_type=false;tmp.ref_node=false}
if(tree_component.drag_drop.marker) tree_component.drag_drop.marker.hide();if(tmp.dragged&&tmp.dragged.size()) tmp.dragged.removeClass("dragged");tmp.dragged=false;tmp.drag_help=false;tmp.drag_node=false;tmp.f_type=false;tmp.f_data=false;tmp.init_x=false;tmp.init_y=false;tmp.moving=false;tmp.appended=false;tmp.origin_tree=false;if(tmp.isdown){tmp.isdown=false;event.preventDefault();event.stopPropagation();return false}};tree_component.mousemove=function(event){var tmp=tree_component.drag_drop;var is_start=false;if(tmp.isdown){if(!tmp.moving&&Math.abs(tmp.init_x-event.pageX)<5&&Math.abs(tmp.init_y-event.pageY)<5){event.preventDefault();event.stopPropagation();return false}
else{if(!tmp.moving){tree_component.drag_drop.moving=true;is_start=true}}
if(tmp.open_time) clearTimeout(tmp.open_time);if(tmp.drag_help!==false){if(!tmp.appended){if(tmp.foreign!==false) tmp.origin_tree=$.tree.focused();$("body").append(tmp.drag_help);tmp.w=tmp.drag_help.width();tmp.appended=true}
tmp.drag_help.css({"left":(event.pageX+5),"top":(event.pageY+15)})}
if(is_start&&$.tree.drag_start!==false) $.tree.drag_start.call(null,event,tmp);if($.tree.drag!==false) $.tree.drag.call(null,event,tmp);if(event.target.tagName=="DIV"&&event.target.id=="jstree-marker") return false;var et=$(event.target);if(et.is("ins")) et=et.parent();var cnt=et.is(".tree")?et:et.parents(".tree:eq(0)");if(cnt.size()==0||!tree_component.inst[cnt.attr("id")]){if(tmp.scroll_time) clearTimeout(tmp.scroll_time);if(tmp.drag_help!==false) tmp.drag_help.find("li:eq(0) ins").addClass("forbidden");tmp.move_type=false;tmp.ref_node=false;tree_component.drag_drop.marker.hide();return false}
var tree2=tree_component.inst[cnt.attr("id")];tree2.off_height();if(tmp.scroll_time) clearTimeout(tmp.scroll_time);tmp.scroll_time=setTimeout( function(){tree2.scroll_check(event.pageX,event.pageY)},50);var mov=false;var st=cnt.scrollTop();if(event.target.tagName=="A"||event.target.tagName=="INS"){if(et.is("#jstree-dragged")) return false;if(tree2.get_node(event.target).hasClass("closed")){tmp.open_time=setTimeout( function(){tree2.open_branch(et)},500)}
var et_off=et.offset();var goTo={x:(et_off.left-1),y:(event.pageY-et_off.top)};var arr=[];if(goTo.y<tree2.li_height/3+1) arr=["before","inside","after"];else if(goTo.y>tree2.li_height*2/3-1) arr=["after","inside","before"];else{if(goTo.y<tree2.li_height/2) arr=["inside","before","after"];else arr=["inside","after","before"]}
var ok=false;var nn=(tmp.foreign==false)?tmp.origin_tree.container.find("li.dragged"):tmp.f_type;$.each(arr, function(i,val){if(tree2.check_move(nn,et,val)){mov=val;ok=true;return false}});if(ok){switch(mov){case "before":goTo.y=et_off.top-2;tree_component.drag_drop.marker.attr("class","marker");break;case "after":goTo.y=et_off.top-2+tree2.li_height;tree_component.drag_drop.marker.attr("class","marker");break;case "inside":goTo.x-=2;goTo.y=et_off.top-2+tree2.li_height/2;tree_component.drag_drop.marker.attr("class","marker_plus");break}
tmp.move_type=mov;tmp.ref_node=$(event.target);if(tmp.drag_help!==false) tmp.drag_help.find(".forbidden").removeClass("forbidden");tree_component.drag_drop.marker.css({"left":goTo.x,"top":goTo.y}).show()}}
if((et.is(".tree")||et.is("ul"))&&et.find("li:eq(0)").size()==0){var et_off=et.offset();tmp.move_type="inside";tmp.ref_node=cnt.children("ul:eq(0)");if(tmp.drag_help!==false) tmp.drag_help.find(".forbidden").removeClass("forbidden");tree_component.drag_drop.marker.attr("class","marker_plus");tree_component.drag_drop.marker.css({"left":(et_off.left+10),"top":et_off.top+15}).show()}
else if((event.target.tagName!="A"&&event.target.tagName!="INS")||!ok){if(tmp.drag_help!==false) tmp.drag_help.find("li:eq(0) ins").addClass("forbidden");tmp.move_type=false;tmp.ref_node=false;tree_component.drag_drop.marker.hide()}
event.preventDefault();event.stopPropagation();return false}
return true};$(function(){$(document).bind("mousemove.jstree",tree_component.mousemove);$(document).bind("mouseup.jstree",tree_component.mouseup)});tree_component.cut_copy={copy_nodes:false,cut_nodes:false};tree_component.css=false;tree_component.get_css=function(rule_name,delete_flag){rule_name=rule_name.toLowerCase();var css_rules=tree_component.css.cssRules||tree_component.css.rules;var j=0;do{if(css_rules.length&&j>css_rules.length+5) return false;if(css_rules[j].selectorText&&css_rules[j].selectorText.toLowerCase()==rule_name){if(delete_flag==true){if(tree_component.css.removeRule) document.styleSheets[i].removeRule(j);if(tree_component.css.deleteRule) document.styleSheets[i].deleteRule(j);return true}
else return css_rules[j]}}
while(css_rules[++j]);return false};tree_component.add_css=function(rule_name){if(tree_component.get_css(rule_name)) return false;(tree_component.css.insertRule)?tree_component.css.insertRule(rule_name+' { }',0):tree_component.css.addRule(rule_name,null,0);return tree_component.get_css(rule_name)};tree_component.remove_css=function(rule_name){return tree_component.get_css(rule_name,true)};tree_component.add_sheet=function(opts){if(opts.str){var tmp=document.createElement("style");tmp.type="text/css";if(tmp.styleSheet) tmp.styleSheet.cssText=opts.str;else tmp.appendChild(document.createTextNode(opts.str));document.getElementsByTagName("head")[0].appendChild(tmp);return tmp.sheet}
if(opts.url){if(document.createStyleSheet){try{document.createStyleSheet(opts.url)} catch(e){}}
else{var newSS=document.createElement('link');newSS.rel='stylesheet';newSS.type='text/css';newSS.media="all";newSS.href=opts.url;document.getElementsByTagName("head")[0].appendChild(newSS);return newSS.styleSheet}}};$(function(){var u=navigator.userAgent.toLowerCase();var v=(u.match(/.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/)||[0,'0'])[1];var css='/* TREE LAYOUT */ .tree ul { margin:0 0 0 5px; padding:0 0 0 0; list-style-type:none; } .tree li { display:block; min-height:18px; line-height:18px; padding:0 0 0 15px; margin:0 0 0 0; /* Background fix */ clear:both; } .tree li ul { display:none; } .tree li a, .tree li span { display:inline-block;line-height:16px;height:16px;color:black;white-space:nowrap;text-decoration:none;padding:1px 4px 1px 4px;margin:0; } .tree li a:focus { outline: none; } .tree li a input, .tree li span input { margin:0;padding:0 0;display:inline-block;height:12px !important;border:1px solid white;background:white;font-size:10px;font-family:Verdana; } .tree li a input:not([class="xxx"]), .tree li span input:not([class="xxx"]) { padding:1px 0; } /* FOR DOTS */ .tree .ltr li.last { float:left; } .tree > ul li.last { overflow:visible; } /* OPEN OR CLOSE */ .tree li.open ul { display:block; } .tree li.closed ul { display:none !important; } /* FOR DRAGGING */ #jstree-dragged { position:absolute; top:-10px; left:-10px; margin:0; padding:0; } #jstree-dragged ul ul ul { display:none; } #jstree-marker { padding:0; margin:0; line-height:5px; font-size:1px; overflow:hidden; height:5px; position:absolute; left:-45px; top:-30px; z-index:1000; background-color:transparent; background-repeat:no-repeat; display:none; } #jstree-marker.marker { width:45px; background-position:-32px top; } #jstree-marker.marker_plus { width:5px; background-position:right top; } /* BACKGROUND DOTS */ .tree li li { overflow:hidden; } .tree > .ltr > li { display:table; } /* ICONS */ .tree ul ins { display:inline-block; text-decoration:none; width:16px; height:16px; } .tree .ltr ins { margin:0 4px 0 0px; } ';if(/msie/.test(u) && !/opera/.test(u)){if(parseInt(v)==6) css+='.tree li { height:18px; zoom:1; } .tree li li { overflow:visible; } .tree .ltr li.last { margin-top: expression( (this.previousSibling && /open/.test(this.previousSibling.className) ) ? "-2px" : "0"); } .marker { width:45px; background-position:-32px top; } .marker_plus { width:5px; background-position:right top; }';if(parseInt(v)==7) css+='.tree li li { overflow:visible; } .tree .ltr li.last { margin-top: expression( (this.previousSibling && /open/.test(this.previousSibling.className) ) ? "-2px" : "0"); }'}
if(/opera/.test(u)) css+='.tree > ul > li.last:after { content:"."; display: block; height:1px; clear:both; visibility:hidden; }';if(/mozilla/.test(u) && !/(compatible|webkit)/.test(u)&&v.indexOf("1.8")==0) css+='.tree .ltr li a { display:inline; float:left; } .tree li ul { clear:both; }';tree_component.css=tree_component.add_sheet({str:css})})})(jQuery);(function($){$.extend($.tree.datastores,{"html": function(){return{get: function(obj,tree,opts){return obj&&$(obj).size()?$('<div>').append(tree.get_node(obj).clone()).html():tree.container.children("ul:eq(0)").html()},parse: function(data,tree,opts,callback){if(callback) callback.call(null,data);return data},load: function(data,tree,opts,callback){if(opts.url){$.ajax({'type':opts.method,'url':opts.url,'data':data,'dataType':"html",'success': function(d,textStatus){callback.call(null,d)},'error': function(xhttp,textStatus,errorThrown){callback.call(null,false);tree.error(errorThrown+" "+textStatus)}})}
else{callback.call(null,opts.static||tree.container.children("ul:eq(0)").html())}}}},"json": function(){return{get: function(obj,tree,opts){var _this=this;if(!obj||$(obj).size()==0) obj=tree.container.children("ul").children("li");else obj=$(obj);if(!opts) opts={};if(!opts.outer_attrib) opts.outer_attrib=["id","rel","class"];if(!opts.inner_attrib) opts.inner_attrib=[];if(obj.size()>1){var arr=[];obj.each(function(){arr.push(_this.get(this,tree,opts))});return arr}
if(obj.size()==0) return [];var json={attributes:{},data:{}};if(obj.hasClass("open")) json.data.state="open";if(obj.hasClass("closed")) json.data.state="closed";for(var i in opts.outer_attrib){if(!opts.outer_attrib.hasOwnProperty(i)) continue;var val=(opts.outer_attrib[i]=="class")?obj.attr(opts.outer_attrib[i]).replace(/(^| )last( |$)/ig," ").replace(/(^| )(leaf|closed|open)( |$)/ig," "):obj.attr(opts.outer_attrib[i]);if(typeof val!="undefined"&&val.toString().replace(" ","").length>0) json.attributes[opts.outer_attrib[i]]=val;delete val}
if(tree.settings.languages.length){for(var i in tree.settings.languages){if(!tree.settings.languages.hasOwnProperty(i)) continue;var a=obj.children("a."+tree.settings.languages[i]);if(opts.force||opts.inner_attrib.length||a.children("ins").get(0).style.backgroundImage.toString().length||a.children("ins").get(0).className.length){json.data[tree.settings.languages[i]]={};json.data[tree.settings.languages[i]].title=tree.get_text(obj,tree.settings.languages[i]);if(a.children("ins").get(0).style.className.length){json.data[tree.settings.languages[i]].icon=a.children("ins").get(0).style.className}
if(a.children("ins").get(0).style.backgroundImage.length){json.data[tree.settings.languages[i]].icon=a.children("ins").get(0).style.backgroundImage.replace("url(","").replace(")","")}
if(opts.inner_attrib.length){json.data[tree.settings.languages[i]].attributes={};for(var j in opts.inner_attrib){if(!opts.inner_attrib.hasOwnProperty(j)) continue;var val=a.attr(opts.inner_attrib[j]);if(typeof val!="undefined"&&val.toString().replace(" ","").length>0) json.data[tree.settings.languages[i]].attributes[opts.inner_attrib[j]]=val;delete val}}}
else{json.data[tree.settings.languages[i]]=tree.get_text(obj,tree.settings.languages[i])}}}
else{var a=obj.children("a");json.data.title=tree.get_text(obj);if(a.children("ins").size()&&a.children("ins").get(0).className.length){json.data.icon=a.children("ins").get(0).className}
if(a.children("ins").size()&&a.children("ins").get(0).style.backgroundImage.length){json.data.icon=a.children("ins").get(0).style.backgroundImage.replace("url(","").replace(")","")}
if(opts.inner_attrib.length){json.data.attributes={};for(var j in opts.inner_attrib){if(!opts.inner_attrib.hasOwnProperty(j)) continue;var val=a.attr(opts.inner_attrib[j]);if(typeof val!="undefined"&&val.toString().replace(" ","").length>0) json.data.attributes[opts.inner_attrib[j]]=val;delete val}}}
if(obj.children("ul").size()>0){json.children=[];obj.children("ul").children("li").each(function(){json.children.push(_this.get(this,tree,opts))})}
return json},parse: function(data,tree,opts,callback){if(Object.prototype.toString.apply(data)==="[object Array]"){var str='';for(var i=0;i<data.length;i++){if(typeof data[i]=="function") continue;str+=this.parse(data[i],tree,opts)}
if(callback) callback.call(null,str);return str}
if(!data||!data.data){if(callback) callback.call(null,false);return ""}
var str='';str+="<li ";var cls=false;if(data.attributes){for(var i in data.attributes){if(!data.attributes.hasOwnProperty(i)) continue;if(i=="class"){str+=" class='"+data.attributes[i]+" ";if(data.state=="closed"||data.state=="open") str+=" "+data.state+" ";str+="' ";cls=true}
else str+=" "+i+"='"+data.attributes[i]+"' "}}
if(!cls&&(data.state=="closed"||data.state=="open")) str+=" class='"+data.state+"' ";str+=">";if(tree.settings.languages.length){for(var i=0;i<tree.settings.languages.length;i++){var attr={};attr["href"]="";attr["style"]="";attr["class"]=tree.settings.languages[i];if(data.data[tree.settings.languages[i]]&&(typeof data.data[tree.settings.languages[i]].attributes).toLowerCase()!="undefined"){for(var j in data.data[tree.settings.languages[i]].attributes){if(!data.data[tree.settings.languages[i]].attributes.hasOwnProperty(j)) continue;if(j=="style"||j=="class") attr[j]+=" "+data.data[tree.settings.languages[i]].attributes[j];else attr[j]=data.data[tree.settings.languages[i]].attributes[j]}}
str+="<a";for(var j in attr){if(!attr.hasOwnProperty(j)) continue;str+=' '+j+'="'+attr[j]+'" '}
str+=">";if(data.data[tree.settings.languages[i]]&&data.data[tree.settings.languages[i]].icon){str+="<ins "+(data.data[tree.settings.languages[i]].icon.indexOf("/")==-1?" class='"+data.data[tree.settings.languages[i]].icon+"' ":" style='background-image:url(\""+data.data[tree.settings.languages[i]].icon+"\");' ")+">&nbsp;</ins>"}
else str+="<ins>&nbsp;</ins>";str+=((typeof data.data[tree.settings.languages[i]].title).toLowerCase()!="undefined"?data.data[tree.settings.languages[i]].title:data.data[tree.settings.languages[i]])+"</a>"}}
else{var attr={};attr["href"]="";attr["style"]="";attr["class"]="";if((typeof data.data.attributes).toLowerCase()!="undefined"){for(var i in data.data.attributes){if(!data.data.attributes.hasOwnProperty(i)) continue;if(i=="style"||i=="class") attr[i]+=" "+data.data.attributes[i];else attr[i]=data.data.attributes[i]}}
str+="<a";for(var i in attr){if(!attr.hasOwnProperty(i)) continue;str+=' '+i+'="'+attr[i]+'" '}
str+=">";if(data.data.icon){str+="<ins "+(data.data.icon.indexOf("/")==-1?" class='"+data.data.icon+"' ":" style='background-image:url(\""+data.data.icon+"\");' ")+">&nbsp;</ins>"}
else str+="<ins>&nbsp;</ins>";str+=((typeof data.data.title).toLowerCase()!="undefined"?data.data.title:data.data)+"</a>"}
if(data.children&&data.children.length){str+='<ul>';for(var i=0;i<data.children.length;i++){str+=this.parse(data.children[i],tree,opts)}
str+='</ul>'}
str+="</li>";if(callback) callback.call(null,str);return str},load: function(data,tree,opts,callback){if(opts.static){callback.call(null,opts.static)}
else{$.ajax({'type':opts.method,'url':opts.url,'data':data,'dataType':"json",'success': function(d,textStatus){callback.call(null,d)},'error': function(xhttp,textStatus,errorThrown){callback.call(null,false);tree.error(errorThrown+" "+textStatus)}})}}}}})})(jQuery);

/* - ++resource++jquery.select2uislider.js - */
// https://www.prf.gov.br/portal/portal_javascripts/++resource++jquery.select2uislider.js?original=1
jQuery.fn.selectToUISlider=function(settings){var selects=jQuery(this);var options=jQuery.extend({labels:3,tooltip:true,tooltipSrc:'text',labelSrc:'value',sliderOptions:null},settings);var handleIds=(function(){var tempArr=[];selects.each(function(){tempArr.push('handle_'+jQuery(this).attr('id'))});return tempArr})();var selectOptions=(function(){var opts=[];selects.eq(0).find('option').each(function(){opts.push({value:jQuery(this).attr('value'),text:jQuery(this).text()})});return opts})();var groups=(function(){if(selects.eq(0).find('optgroup').size()>0){var groupedData=[];selects.eq(0).find('optgroup').each(function(i){groupedData[i]={};groupedData[i].label=jQuery(this).attr('label');groupedData[i].options=[];jQuery(this).find('option').each(function(){groupedData[i].options.push({text:jQuery(this).text(),value:jQuery(this).attr('value')})})});return groupedData}
else{return null}})();
function isArray(obj){return obj.constructor==Array}
function ttText(optIndex){return(options.tooltipSrc=='text')?selectOptions[optIndex].text:selectOptions[optIndex].value}
var sliderOptions={step:1,min:0,orientation:'horizontal',max:selectOptions.length-1,range:selects.length>1,slide: function(e,ui){var thisHandle=jQuery(ui.handle);var textval=ttText(ui.value);thisHandle.attr('aria-valuetext',textval).attr('aria-valuenow',ui.value).find('.ui-slider-tooltip .ttContent').text(textval);var currSelect=jQuery('#'+thisHandle.attr('id').split('handle_')[1]);currSelect.find('option').eq(ui.value).attr('selected','selected')},values:(function(){var values=[];selects.each(function(){values.push(jQuery(this).get(0).selectedIndex)});return values})()};options.sliderOptions=(settings)?jQuery.extend(sliderOptions,settings.sliderOptions):sliderOptions;selects.bind('change keyup click', function(){var thisIndex=jQuery(this).get(0).selectedIndex;var thisHandle=jQuery('#handle_'+jQuery(this).attr('id'));var handleIndex=thisHandle.data('handleNum');thisHandle.parents('.ui-slider:eq(0)').slider("values",handleIndex,thisIndex)});var sliderComponent=jQuery('<div></div>');selects.each(function(i){var hidett='';var thisLabel=jQuery('label[for='+jQuery(this).attr('id')+']');var labelText=(thisLabel.size()>0)?'Slider control for '+thisLabel.text()+'':'';var thisLabelId=thisLabel.attr('id')||thisLabel.attr('id','label_'+handleIds[i]).attr('id');if(options.tooltip===false){hidett=' style="display: none;"'}
jQuery('<a '+'href="#" tabindex="0" '+'id="'+handleIds[i]+'" '+'class="ui-slider-handle" '+'role="slider" '+'aria-labelledby="'+thisLabelId+'" '+'aria-valuemin="'+options.sliderOptions.min+'" '+'aria-valuemax="'+options.sliderOptions.max+'" '+'aria-valuenow="'+options.sliderOptions.values[i]+'" '+'aria-valuetext="'+ttText(options.sliderOptions.values[i])+'" '+'><span class="screenReaderContext">'+labelText+'</span>'+'<span class="ui-slider-tooltip ui-widget-content ui-corner-all"'+hidett+'><span class="ttContent"></span>'+'<span class="ui-tooltip-pointer-down ui-widget-content"><span class="ui-tooltip-pointer-down-inner"></span></span>'+'</span></a>').data('handleNum',i).appendTo(sliderComponent)});if(groups){var inc=0;var scale=sliderComponent.append('<dl class="ui-slider-scale ui-helper-reset" role="presentation"></dl>').find('.ui-slider-scale:eq(0)');jQuery(groups).each(function(h){scale.append('<dt style="width: '+(100/groups.length).toFixed(2)+'%'+'; left:'+(h/(groups.length-1) * 100).toFixed(2)+'%'+'"><span>'+this.label+'</span></dt>');var groupOpts=this.options;jQuery(this.options).each(function(i){var style=(inc==selectOptions.length-1||inc===0)?'style="display: none;"':'' ;var labelText=(options.labelSrc=='text')?groupOpts[i].text:groupOpts[i].value;scale.append('<dd style="left:'+leftVal(inc)+'"><span class="ui-slider-label">'+labelText+'</span><span class="ui-slider-tic ui-widget-content"'+style+'></span></dd>');inc++})})}
else{var scale=sliderComponent.append('<ol class="ui-slider-scale ui-helper-reset" role="presentation"></ol>').find('.ui-slider-scale:eq(0)');jQuery(selectOptions).each(function(i){var style=(i==selectOptions.length-1||i===0)?'style="display: none;"':'' ;var labelText=(options.labelSrc=='text')?this.text:this.value;scale.append('<li style="left:'+leftVal(i)+'"><span class="ui-slider-label">'+labelText+'</span><span class="ui-slider-tic ui-widget-content"'+style+'></span></li>')})}
function leftVal(i){return(i/(selectOptions.length-1) * 100).toFixed(2)+'%'}
if(options.labels>1){sliderComponent.find('.ui-slider-scale li:last span.ui-slider-label, .ui-slider-scale dd:last span.ui-slider-label').addClass('ui-slider-label-show')}
var increm=Math.max(1,Math.round(selectOptions.length/options.labels));for(var j=0;j<selectOptions.length;j+=increm){if((selectOptions.length-j)>increm){sliderComponent.find('.ui-slider-scale li:eq('+j+') span.ui-slider-label, .ui-slider-scale dd:eq('+j+') span.ui-slider-label').addClass('ui-slider-label-show')}}
sliderComponent.find('.ui-slider-scale dt').each(function(i){jQuery(this).css({'left':((100/(groups.length))*i).toFixed(2)+'%'})});sliderComponent.insertAfter(jQuery(this).eq(this.length-1)).slider(options.sliderOptions).attr('role','application').find('.ui-slider-label').each(function(){jQuery(this).css('marginLeft',-jQuery(this).width()/2)});sliderComponent.find('.ui-tooltip-pointer-down-inner').each(function(){var bWidth=jQuery('.ui-tooltip-pointer-down-inner').css('borderTopWidth');var bColor=jQuery(this).parents('.ui-slider-tooltip').css('backgroundColor');jQuery(this).css('border-top',bWidth+' solid '+bColor)});var values=sliderComponent.slider('values');if(isArray(values)){jQuery(values).each(function(i){sliderComponent.find('.ui-slider-tooltip .ttContent').eq(i).text(ttText(this))})}
else{sliderComponent.find('.ui-slider-tooltip .ttContent').eq(0).text(ttText(values))}
return this};

/* - ++resource++jquery.tagcloud.js - */
// https://www.prf.gov.br/portal/portal_javascripts/++resource++jquery.tagcloud.js?original=1
;(function($){var oSettings;var oUlCss={};var oLiCss={};var fGAng=2.399963;$.tagcloud={id:"TagCloud",version:"0.5.0",defaults:{height:null,type:"cloud",sizemax:20,sizemin:10,colormax:"00F",colormin:"B4D2FF",seed:null,power:.5}};$.fn.extend({tagcloud: function(_settings){oSettings=$.extend({},$.tagcloud.defaults,_settings);if(oSettings.seed===null) oSettings.seed=Math.ceil(Math.random()*45309714203);switch(oSettings.type){case "sphere":case "cloud":oUlCss={position:"relative"};oLiCss={position:"absolute",display:"block"};break;case "list":oUlCss={height:"auto"};oLiCss={position:"static",display:"inline"};break}
Rng.setSeed(oSettings.seed+123456);return this.each(function(i,o){var mUl=$(o);var aLi=mUl.find(">li");var iNumLi=aLi.length;var iUlW=mUl.width();var iUlH=oSettings.height===null?(.004*iUlW*iNumLi):oSettings.height;mUl.css({width:iUlW,height:iUlH,listStyle:"none",margin:0,padding:0});mUl.css(oUlCss);var iValMx=-2147483647;var iValMn=2147483648;var iLastVal=-1;for(var j=0;j<iNumLi;j++){var mLi=$(aLi[j]);var iVal=mLi.attr("value")==-1?iLastVal++:mLi.attr("value");if(iVal>iValMx) iValMx=iVal;if(iVal<iValMn) iValMn=iVal;iLastVal=iVal}
var iValRn=iValMx-iValMn;var aLine=new Array();for(var j=0;j<iNumLi;j++) aLine[j]=j;for(var j,x,k=aLine.length;k;j=parseInt(Rng.rand(0,1000)/1000 * k),x=aLine[--k],aLine[k]=aLine[j],aLine[j]=x);iLastVal=-1;for(var j=0;j<iNumLi;j++){var mLi=$(aLi[j]);var iVal=mLi.attr("value")==-1?iLastVal++:mLi.attr("value");iLastVal=iVal;var fPrt=((iNumLi-j-1)/(iNumLi-1));var fPrt=(iVal-iValMn)/iValRn;var iSzFnt=oSettings.sizemin+fPrt*(oSettings.sizemax-oSettings.sizemin);var sColor=colorRng(oSettings.colormin,oSettings.colormax,fPrt);mLi.css({"fontSize":iSzFnt,position:"absolute",color:"#"+sColor,margin:0,padding:0}).children().css({color:"#"+sColor});var iLiW=mLi.width();var iLiH=mLi.height()
var oCss={};if(oSettings.type!="list"){if(oSettings.type=="cloud"){var iXps=Rng.rand(0,iUlW-iLiW);var iYps=aLine[j]*(iUlH/iNumLi)-iLiH/2} else{var fRds=Math.pow(j/iNumLi,oSettings.power);var fRad=(j+Math.PI/2)*fGAng;var iXps=iUlW/2-iLiW/2+.5*iUlW*fRds*Math.sin(fRad);var iYps=iUlH/2-iLiH/2+.5*iUlH*fRds*Math.cos(fRad)}
oCss.left=iXps;oCss.top=iYps}
for(var prop in oLiCss) oCss[prop]=oLiCss[prop];mLi.css(oCss)}})}});var Rng=new function(){this.seed=23145678901;this.A=48271;this.M=2147483647;this.Q=this.M/this.A;this.R=this.M%this.A;this.oneOverM=1.0/this.M}
Rng.setSeed=function(seed){this.seed=seed}
Rng.next=function(){var hi=this.seed/this.Q;var lo=this.seed%this.Q;var test=this.A*lo-this.R*hi;this.seed=test+(test>0?0:this.M);return(this.seed*this.oneOverM)}
Rng.rand=function(lrn,urn){return Math.floor((urn-lrn+1) * this.next()+lrn)}
function d2h(d){return d.toString(16)}
function h2d(h){return parseInt(h,16)}
function getRGB(s){var b3=s.length==3;var aClr=[];for(var i=0;i<3;i++){var sClr=s.substring(i*(b3?1:2),(i+1)*(b3?1:2));aClr.push(h2d(b3?sClr+sClr:sClr))}
return aClr}
function getHex(a){var s="";for(var i=0;i<3;i++){var c=d2h(a[i]);if(c.length==1) c="0"+c;s+=c}
return s}
function colorRng(mn,mx,prt){var aMin=getRGB(mn);var aMax=getRGB(mx);var aRtr=[];for(var i=0;i<3;i++) aRtr.push(aMin[i]+Math.floor(prt*(aMax[i]-aMin[i])));return getHex(aRtr)}
function trace(o){if(window.console&&window.console.log){if(typeof(o)=="string") window.console.log(o);else for(var prop in o) window.console.log(prop+": "+o[prop])}};$.fn.TagCloud=$.fn.Tagcloud=$.fn.tagcloud})(jQuery);

/* - ++resource++plonetruegallery-portlet.js - */
// https://www.prf.gov.br/portal/portal_javascripts/++resource++plonetruegallery-portlet.js?original=1
(function($){$.fn.imagesLoaded=function(callback){var elems=this.filter('img'),len=elems.length;elems.bind('load',function(){if(--len<=0){callback.call(elems,this)}}).each(function(){if(this.complete||this.complete===undefined){var src=this.src;this.src='#';this.src=src}})};
function set_controls_position(container){var width=container.find('img').width();var left=(width/2)-43;container.find('div.gallery-portlet-controls').css("left",left)}
function get_image(link){var linkele=link[0];if(linkele.active!=undefined&&linkele.active){return}
linkele.active=true;var container=link.parents('dl.applied-portlet-gallery');var controls=link.parents('div.gallery-portlet-controls');var portlet_item=link.parents('dd.portletItem');var next=controls.find('span.next a');var prev=controls.find('span.prev a');var img=container.find('img');$.ajax({url:'@@get-image-for-gallery-portlet',data:link.attr('href').split('?')[1],type:'GET',success: function(data,results){eval("var json="+data);var newimg=document.createElement('img');newimg.src=json.src;newimg.width=img.width();if(img.attr('height')!==undefined){newimg.height=img.height()}
newimg=$(newimg);newimg.css('display','none');portlet_item.css('height',img.height());img.fadeOut(1000, function(){img.replaceWith(newimg);newimg.imagesLoaded(function(){portlet_item.animate({height:$(this).height()},500,'linear');$(this).fadeIn(1000, function(){linkele.active=false})},newimg)
var linked=newimg.parent()
linked.attr('href',json['image-link']);linked.attr('title',json['title']);linked.attr('alt',json['description']);next.attr('href',next.attr('href').split('?')[0]+'?'+json['next-url']);prev.attr('href',prev.attr('href').split('?')[0]+'?'+json['prev-url']);set_controls_position(container)})}})}
function get_timeout_ele(portlet){if(portlet.hasClass('portletItem')){portlet=portlet.parent()}
return portlet.find("input.timeout_id")}
function get_timeout_id(portlet){var timeout_id=get_timeout_ele(portlet);if(timeout_id.size()==0){return 0}else{return parseInt(timeout_id.attr('value'))}}
function set_timeout_id(portlet,val){var timeout_id=get_timeout_ele(portlet);if(timeout_id.size()==0){portlet.append('<input type="hidden" name="timeout_id" class="timeout_id" value="'+val+'" />')}else{timeout_id.attr('value',val)}}
function perform_play(portlet){portlet.find('span.next a').trigger('click');set_timeout_id(portlet,setTimeout(function(){perform_play(portlet)},5000))}
function play(portlet){portlet.find('span.play-pause').addClass('timed');set_timeout_id(portlet,setTimeout(function(){perform_play(portlet)},5000))}
function pause(portlet){clearTimeout(get_timeout_id(portlet));portlet.find('span.play-pause').removeClass('timed')}
$(document).ready(function(){$('dl.portletGallery span.next a,dl.portletGallery span.prev a').click(function(){get_image($(this));return false});$('dl.portletGallery span.play-pause').css({'display':'inline'});var portlets=$('dl.portletGallery');portlets.addClass('applied-portlet-gallery');portlets.each(function(){var portlet=$(this);set_controls_position(portlet);if(portlet.hasClass('timed')){play(portlet)}else{pause(portlet)}});$('dl.portletGallery span.play-pause a').click(function(){var portlet=$(this).parent().parent().parent();if(portlet.find('span.play-pause').hasClass('timed')){pause(portlet)}else{play(portlet)}
return false});$('dl.portletGallery').hover(
function(){var controls=$(this).find('div.gallery-portlet-controls:not(.hide)');controls.fadeIn()},
function(){var controls=$(this).find('div.gallery-portlet-controls:not(.hide)');controls.fadeOut()})})})(jQuery);

/* - ++resource++brasil.gov.tiles/jquery.cycle2.js - */
/*!
* jQuery Cycle2; version: 2.1.1 build: 20140128
* http://jquery.malsup.com/cycle2/
* Copyright (c) 2014 M. Alsup; Dual licensed: MIT/GPL
*/

/* Cycle2 core engine */
;(function($) {
"use strict";

var version = '2.1.1';

$.fn.cycle = function( options ) {
    // fix mistakes with the ready state
    var o;
    if ( this.length === 0 && !$.isReady ) {
        o = { s: this.selector, c: this.context };
        $.fn.cycle.log('requeuing slideshow (dom not ready)');
        $(function() {
            $( o.s, o.c ).cycle(options);
        });
        return this;
    }

    return this.each(function() {
        var data, opts, shortName, val;
        var container = $(this);
        var log = $.fn.cycle.log;

        if ( container.data('cycle.opts') )
            return; // already initialized

        if ( container.data('cycle-log') === false ||
            ( options && options.log === false ) ||
            ( opts && opts.log === false) ) {
            log = $.noop;
        }

        log('--c2 init--');
        data = container.data();
        for (var p in data) {
            // allow props to be accessed sans 'cycle' prefix and log the overrides
            if (data.hasOwnProperty(p) && /^cycle[A-Z]+/.test(p) ) {
                val = data[p];
                shortName = p.match(/^cycle(.*)/)[1].replace(/^[A-Z]/, lowerCase);
                log(shortName+':', val, '('+typeof val +')');
                data[shortName] = val;
            }
        }

        opts = $.extend( {}, $.fn.cycle.defaults, data, options || {});

        opts.timeoutId = 0;
        opts.paused = opts.paused || false; // #57
        opts.container = container;
        opts._maxZ = opts.maxZ;

        opts.API = $.extend ( { _container: container }, $.fn.cycle.API );
        opts.API.log = log;
        opts.API.trigger = function( eventName, args ) {
            opts.container.trigger( eventName, args );
            return opts.API;
        };

        container.data( 'cycle.opts', opts );
        container.data( 'cycle.API', opts.API );

        // opportunity for plugins to modify opts and API
        opts.API.trigger('cycle-bootstrap', [ opts, opts.API ]);

        opts.API.addInitialSlides();
        opts.API.preInitSlideshow();

        if ( opts.slides.length )
            opts.API.initSlideshow();
    });
};

$.fn.cycle.API = {
    opts: function() {
        return this._container.data( 'cycle.opts' );
    },
    addInitialSlides: function() {
        var opts = this.opts();
        var slides = opts.slides;
        opts.slideCount = 0;
        opts.slides = $(); // empty set

        // add slides that already exist
        slides = slides.jquery ? slides : opts.container.find( slides );

        if ( opts.random ) {
            slides.sort(function() {return Math.random() - 0.5;});
        }

        opts.API.add( slides );
    },

    preInitSlideshow: function() {
        var opts = this.opts();
        opts.API.trigger('cycle-pre-initialize', [ opts ]);
        var tx = $.fn.cycle.transitions[opts.fx];
        if (tx && $.isFunction(tx.preInit))
            tx.preInit( opts );
        opts._preInitialized = true;
    },

    postInitSlideshow: function() {
        var opts = this.opts();
        opts.API.trigger('cycle-post-initialize', [ opts ]);
        var tx = $.fn.cycle.transitions[opts.fx];
        if (tx && $.isFunction(tx.postInit))
            tx.postInit( opts );
    },

    initSlideshow: function() {
        var opts = this.opts();
        var pauseObj = opts.container;
        var slideOpts;
        opts.API.calcFirstSlide();

        if ( opts.container.css('position') == 'static' )
            opts.container.css('position', 'relative');

        $(opts.slides[opts.currSlide]).css({
            opacity: 1,
            display: 'block',
            visibility: 'visible'
        });
        opts.API.stackSlides( opts.slides[opts.currSlide], opts.slides[opts.nextSlide], !opts.reverse );

        if ( opts.pauseOnHover ) {
            // allow pauseOnHover to specify an element
            if ( opts.pauseOnHover !== true )
                pauseObj = $( opts.pauseOnHover );

            pauseObj.hover(
                function(){ opts.API.pause( true ); },
                function(){ opts.API.resume( true ); }
            );
        }

        // stage initial transition
        if ( opts.timeout ) {
            slideOpts = opts.API.getSlideOpts( opts.currSlide );
            opts.API.queueTransition( slideOpts, slideOpts.timeout + opts.delay );
        }

        opts._initialized = true;
        opts.API.updateView( true );
        opts.API.trigger('cycle-initialized', [ opts ]);
        opts.API.postInitSlideshow();
    },

    pause: function( hover ) {
        var opts = this.opts(),
            slideOpts = opts.API.getSlideOpts(),
            alreadyPaused = opts.hoverPaused || opts.paused;

        if ( hover )
            opts.hoverPaused = true;
        else
            opts.paused = true;

        if ( ! alreadyPaused ) {
            opts.container.addClass('cycle-paused');
            opts.API.trigger('cycle-paused', [ opts ]).log('cycle-paused');

            if ( slideOpts.timeout ) {
                clearTimeout( opts.timeoutId );
                opts.timeoutId = 0;

                // determine how much time is left for the current slide
                opts._remainingTimeout -= ( $.now() - opts._lastQueue );
                if ( opts._remainingTimeout < 0 || isNaN(opts._remainingTimeout) )
                    opts._remainingTimeout = undefined;
            }
        }
    },

    resume: function( hover ) {
        var opts = this.opts(),
            alreadyResumed = !opts.hoverPaused && !opts.paused,
            remaining;

        if ( hover )
            opts.hoverPaused = false;
        else
            opts.paused = false;


        if ( ! alreadyResumed ) {
            opts.container.removeClass('cycle-paused');
            // #gh-230; if an animation is in progress then don't queue a new transition; it will
            // happen naturally
            if ( opts.slides.filter(':animated').length === 0 )
                opts.API.queueTransition( opts.API.getSlideOpts(), opts._remainingTimeout );
            opts.API.trigger('cycle-resumed', [ opts, opts._remainingTimeout ] ).log('cycle-resumed');
        }
    },

    add: function( slides, prepend ) {
        var opts = this.opts();
        var oldSlideCount = opts.slideCount;
        var startSlideshow = false;
        var len;

        if ( $.type(slides) == 'string')
            slides = $.trim( slides );

        $( slides ).each(function(i) {
            var slideOpts;
            var slide = $(this);

            if ( prepend )
                opts.container.prepend( slide );
            else
                opts.container.append( slide );

            opts.slideCount++;
            slideOpts = opts.API.buildSlideOpts( slide );

            if ( prepend )
                opts.slides = $( slide ).add( opts.slides );
            else
                opts.slides = opts.slides.add( slide );

            opts.API.initSlide( slideOpts, slide, --opts._maxZ );

            slide.data('cycle.opts', slideOpts);
            opts.API.trigger('cycle-slide-added', [ opts, slideOpts, slide ]);
        });

        opts.API.updateView( true );

        startSlideshow = opts._preInitialized && (oldSlideCount < 2 && opts.slideCount >= 1);
        if ( startSlideshow ) {
            if ( !opts._initialized )
                opts.API.initSlideshow();
            else if ( opts.timeout ) {
                len = opts.slides.length;
                opts.nextSlide = opts.reverse ? len - 1 : 1;
                if ( !opts.timeoutId ) {
                    opts.API.queueTransition( opts );
                }
            }
        }
    },

    calcFirstSlide: function() {
        var opts = this.opts();
        var firstSlideIndex;
        firstSlideIndex = parseInt( opts.startingSlide || 0, 10 );
        if (firstSlideIndex >= opts.slides.length || firstSlideIndex < 0)
            firstSlideIndex = 0;

        opts.currSlide = firstSlideIndex;
        if ( opts.reverse ) {
            opts.nextSlide = firstSlideIndex - 1;
            if (opts.nextSlide < 0)
                opts.nextSlide = opts.slides.length - 1;
        }
        else {
            opts.nextSlide = firstSlideIndex + 1;
            if (opts.nextSlide == opts.slides.length)
                opts.nextSlide = 0;
        }
    },

    calcNextSlide: function() {
        var opts = this.opts();
        var roll;
        if ( opts.reverse ) {
            roll = (opts.nextSlide - 1) < 0;
            opts.nextSlide = roll ? opts.slideCount - 1 : opts.nextSlide-1;
            opts.currSlide = roll ? 0 : opts.nextSlide+1;
        }
        else {
            roll = (opts.nextSlide + 1) == opts.slides.length;
            opts.nextSlide = roll ? 0 : opts.nextSlide+1;
            opts.currSlide = roll ? opts.slides.length-1 : opts.nextSlide-1;
        }
    },

    calcTx: function( slideOpts, manual ) {
        var opts = slideOpts;
        var tx;
        if ( manual && opts.manualFx )
            tx = $.fn.cycle.transitions[opts.manualFx];
        if ( !tx )
            tx = $.fn.cycle.transitions[opts.fx];

        if (!tx) {
            tx = $.fn.cycle.transitions.fade;
            opts.API.log('Transition "' + opts.fx + '" not found.  Using fade.');
        }
        return tx;
    },

    prepareTx: function( manual, fwd ) {
        var opts = this.opts();
        var after, curr, next, slideOpts, tx;

        if ( opts.slideCount < 2 ) {
            opts.timeoutId = 0;
            return;
        }
        if ( manual && ( !opts.busy || opts.manualTrump ) ) {
            opts.API.stopTransition();
            opts.busy = false;
            clearTimeout(opts.timeoutId);
            opts.timeoutId = 0;
        }
        if ( opts.busy )
            return;
        if ( opts.timeoutId === 0 && !manual )
            return;

        curr = opts.slides[opts.currSlide];
        next = opts.slides[opts.nextSlide];
        slideOpts = opts.API.getSlideOpts( opts.nextSlide );
        tx = opts.API.calcTx( slideOpts, manual );

        opts._tx = tx;

        if ( manual && slideOpts.manualSpeed !== undefined )
            slideOpts.speed = slideOpts.manualSpeed;

        // if ( opts.nextSlide === opts.currSlide )
        //     opts.API.calcNextSlide();

        // ensure that:
        //      1. advancing to a different slide
        //      2. this is either a manual event (prev/next, pager, cmd) or
        //              a timer event and slideshow is not paused
        if ( opts.nextSlide != opts.currSlide &&
            (manual || (!opts.paused && !opts.hoverPaused && opts.timeout) )) { // #62

            opts.API.trigger('cycle-before', [ slideOpts, curr, next, fwd ]);
            if ( tx.before )
                tx.before( slideOpts, curr, next, fwd );

            after = function() {
                opts.busy = false;
                // #76; bail if slideshow has been destroyed
                if (! opts.container.data( 'cycle.opts' ) )
                    return;

                if (tx.after)
                    tx.after( slideOpts, curr, next, fwd );
                opts.API.trigger('cycle-after', [ slideOpts, curr, next, fwd ]);
                opts.API.queueTransition( slideOpts);
                opts.API.updateView( true );
            };

            opts.busy = true;
            if (tx.transition)
                tx.transition(slideOpts, curr, next, fwd, after);
            else
                opts.API.doTransition( slideOpts, curr, next, fwd, after);

            opts.API.calcNextSlide();
            opts.API.updateView();
        } else {
            opts.API.queueTransition( slideOpts );
        }
    },

    // perform the actual animation
    doTransition: function( slideOpts, currEl, nextEl, fwd, callback) {
        var opts = slideOpts;
        var curr = $(currEl), next = $(nextEl);
        var fn = function() {
            // make sure animIn has something so that callback doesn't trigger immediately
            next.animate(opts.animIn || { opacity: 1}, opts.speed, opts.easeIn || opts.easing, callback);
        };

        next.css(opts.cssBefore || {});
        curr.animate(opts.animOut || {}, opts.speed, opts.easeOut || opts.easing, function() {
            curr.css(opts.cssAfter || {});
            if (!opts.sync) {
                fn();
            }
        });
        if (opts.sync) {
            fn();
        }
    },

    queueTransition: function( slideOpts, specificTimeout ) {
        var opts = this.opts();
        var timeout = specificTimeout !== undefined ? specificTimeout : slideOpts.timeout;
        if (opts.nextSlide === 0 && --opts.loop === 0) {
            opts.API.log('terminating; loop=0');
            opts.timeout = 0;
            if ( timeout ) {
                setTimeout(function() {
                    opts.API.trigger('cycle-finished', [ opts ]);
                }, timeout);
            }
            else {
                opts.API.trigger('cycle-finished', [ opts ]);
            }
            // reset nextSlide
            opts.nextSlide = opts.currSlide;
            return;
        }
        if ( timeout ) {
            opts._lastQueue = $.now();
            if ( specificTimeout === undefined )
                opts._remainingTimeout = slideOpts.timeout;

            if ( !opts.paused && ! opts.hoverPaused ) {
                opts.timeoutId = setTimeout(function() {
                    opts.API.prepareTx( false, !opts.reverse );
                }, timeout );
            }
        }
    },

    stopTransition: function() {
        var opts = this.opts();
        if ( opts.slides.filter(':animated').length ) {
            opts.slides.stop(false, true);
            opts.API.trigger('cycle-transition-stopped', [ opts ]);
        }

        if ( opts._tx && opts._tx.stopTransition )
            opts._tx.stopTransition( opts );
    },

    // advance slide forward or back
    advanceSlide: function( val ) {
        var opts = this.opts();
        clearTimeout(opts.timeoutId);
        opts.timeoutId = 0;
        opts.nextSlide = opts.currSlide + val;

        if (opts.nextSlide < 0)
            opts.nextSlide = opts.slides.length - 1;
        else if (opts.nextSlide >= opts.slides.length)
            opts.nextSlide = 0;

        opts.API.prepareTx( true,  val >= 0 );
        return false;
    },

    buildSlideOpts: function( slide ) {
        var opts = this.opts();
        var val, shortName;
        var slideOpts = slide.data() || {};
        for (var p in slideOpts) {
            // allow props to be accessed sans 'cycle' prefix and log the overrides
            if (slideOpts.hasOwnProperty(p) && /^cycle[A-Z]+/.test(p) ) {
                val = slideOpts[p];
                shortName = p.match(/^cycle(.*)/)[1].replace(/^[A-Z]/, lowerCase);
                opts.API.log('['+(opts.slideCount-1)+']', shortName+':', val, '('+typeof val +')');
                slideOpts[shortName] = val;
            }
        }

        slideOpts = $.extend( {}, $.fn.cycle.defaults, opts, slideOpts );
        slideOpts.slideNum = opts.slideCount;

        try {
            // these props should always be read from the master state object
            delete slideOpts.API;
            delete slideOpts.slideCount;
            delete slideOpts.currSlide;
            delete slideOpts.nextSlide;
            delete slideOpts.slides;
        } catch(e) {
            // no op
        }
        return slideOpts;
    },

    getSlideOpts: function( index ) {
        var opts = this.opts();
        if ( index === undefined )
            index = opts.currSlide;

        var slide = opts.slides[index];
        var slideOpts = $(slide).data('cycle.opts');
        return $.extend( {}, opts, slideOpts );
    },

    initSlide: function( slideOpts, slide, suggestedZindex ) {
        var opts = this.opts();
        slide.css( slideOpts.slideCss || {} );
        if ( suggestedZindex > 0 )
            slide.css( 'zIndex', suggestedZindex );

        // ensure that speed settings are sane
        if ( isNaN( slideOpts.speed ) )
            slideOpts.speed = $.fx.speeds[slideOpts.speed] || $.fx.speeds._default;
        if ( !slideOpts.sync )
            slideOpts.speed = slideOpts.speed / 2;

        slide.addClass( opts.slideClass );
    },

    updateView: function( isAfter, isDuring, forceEvent ) {
        var opts = this.opts();
        if ( !opts._initialized )
            return;
        var slideOpts = opts.API.getSlideOpts();
        var currSlide = opts.slides[ opts.currSlide ];

        if ( ! isAfter && isDuring !== true ) {
            opts.API.trigger('cycle-update-view-before', [ opts, slideOpts, currSlide ]);
            if ( opts.updateView < 0 )
                return;
        }

        if ( opts.slideActiveClass ) {
            opts.slides.removeClass( opts.slideActiveClass )
                .eq( opts.currSlide ).addClass( opts.slideActiveClass );
        }

        if ( isAfter && opts.hideNonActive )
            opts.slides.filter( ':not(.' + opts.slideActiveClass + ')' ).css('visibility', 'hidden');

        if ( opts.updateView === 0 ) {
            setTimeout(function() {
                opts.API.trigger('cycle-update-view', [ opts, slideOpts, currSlide, isAfter ]);
            }, slideOpts.speed / (opts.sync ? 2 : 1) );
        }

        if ( opts.updateView !== 0 )
            opts.API.trigger('cycle-update-view', [ opts, slideOpts, currSlide, isAfter ]);

        if ( isAfter )
            opts.API.trigger('cycle-update-view-after', [ opts, slideOpts, currSlide ]);
    },

    getComponent: function( name ) {
        var opts = this.opts();
        var selector = opts[name];
        if (typeof selector === 'string') {
            // if selector is a child, sibling combinator, adjancent selector then use find, otherwise query full dom
            return (/^\s*[\>|\+|~]/).test( selector ) ? opts.container.find( selector ) : $( selector );
        }
        if (selector.jquery)
            return selector;

        return $(selector);
    },

    stackSlides: function( curr, next, fwd ) {
        var opts = this.opts();
        if ( !curr ) {
            curr = opts.slides[opts.currSlide];
            next = opts.slides[opts.nextSlide];
            fwd = !opts.reverse;
        }

        // reset the zIndex for the common case:
        // curr slide on top,  next slide beneath, and the rest in order to be shown
        $(curr).css('zIndex', opts.maxZ);

        var i;
        var z = opts.maxZ - 2;
        var len = opts.slideCount;
        if (fwd) {
            for ( i = opts.currSlide + 1; i < len; i++ )
                $( opts.slides[i] ).css( 'zIndex', z-- );
            for ( i = 0; i < opts.currSlide; i++ )
                $( opts.slides[i] ).css( 'zIndex', z-- );
        }
        else {
            for ( i = opts.currSlide - 1; i >= 0; i-- )
                $( opts.slides[i] ).css( 'zIndex', z-- );
            for ( i = len - 1; i > opts.currSlide; i-- )
                $( opts.slides[i] ).css( 'zIndex', z-- );
        }

        $(next).css('zIndex', opts.maxZ - 1);
    },

    getSlideIndex: function( el ) {
        return this.opts().slides.index( el );
    }

}; // API

// default logger
$.fn.cycle.log = function log() {
    /*global console:true */
    //if (window.console && console.log)
    //    console.log('[cycle2] ' + Array.prototype.join.call(arguments, ' ') );
};

$.fn.cycle.version = function() { return 'Cycle2: ' + version; };

// helper functions

function lowerCase(s) {
    return (s || '').toLowerCase();
}

// expose transition object
$.fn.cycle.transitions = {
    custom: {
    },
    none: {
        before: function( opts, curr, next, fwd ) {
            opts.API.stackSlides( next, curr, fwd );
            opts.cssBefore = { opacity: 1, visibility: 'visible', display: 'block' };
        }
    },
    fade: {
        before: function( opts, curr, next, fwd ) {
            var css = opts.API.getSlideOpts( opts.nextSlide ).slideCss || {};
            opts.API.stackSlides( curr, next, fwd );
            opts.cssBefore = $.extend(css, { opacity: 0, visibility: 'visible', display: 'block' });
            opts.animIn = { opacity: 1 };
            opts.animOut = { opacity: 0 };
        }
    },
    fadeout: {
        before: function( opts , curr, next, fwd ) {
            var css = opts.API.getSlideOpts( opts.nextSlide ).slideCss || {};
            opts.API.stackSlides( curr, next, fwd );
            opts.cssBefore = $.extend(css, { opacity: 1, visibility: 'visible', display: 'block' });
            opts.animOut = { opacity: 0 };
        }
    },
    scrollHorz: {
        before: function( opts, curr, next, fwd ) {
            opts.API.stackSlides( curr, next, fwd );
            var w = opts.container.css('overflow','hidden').width();
            opts.cssBefore = { left: fwd ? w : - w, top: 0, opacity: 1, visibility: 'visible', display: 'block' };
            opts.cssAfter = { zIndex: opts._maxZ - 2, left: 0 };
            opts.animIn = { left: 0 };
            opts.animOut = { left: fwd ? -w : w };
        }
    }
};

// @see: http://jquery.malsup.com/cycle2/api
$.fn.cycle.defaults = {
    allowWrap:        true,
    autoSelector:     '.cycle-slideshow[data-cycle-auto-init!=false]',
    delay:            0,
    easing:           null,
    fx:              'fade',
    hideNonActive:    true,
    loop:             0,
    manualFx:         undefined,
    manualSpeed:      undefined,
    manualTrump:      true,
    maxZ:             100,
    pauseOnHover:     false,
    reverse:          false,
    slideActiveClass: 'cycle-slide-active',
    slideClass:       'cycle-slide',
    slideCss:         { position: 'absolute', top: 0, left: 0 },
    slides:          '> img',
    speed:            500,
    startingSlide:    0,
    sync:             true,
    timeout:          4000,
    updateView:       0
};

// automatically find and run slideshows
$(document).ready(function() {
    $( $.fn.cycle.defaults.autoSelector ).cycle();
});

})(jQuery);

/*! Cycle2 autoheight plugin; Copyright (c) M.Alsup, 2012; version: 20130913 */
(function($) {
"use strict";

$.extend($.fn.cycle.defaults, {
    autoHeight: 0, // setting this option to false disables autoHeight logic
    autoHeightSpeed: 250,
    autoHeightEasing: null
});

$(document).on( 'cycle-initialized', function( e, opts ) {
    var autoHeight = opts.autoHeight;
    var t = $.type( autoHeight );
    var resizeThrottle = null;
    var ratio;

    if ( t !== 'string' && t !== 'number' )
        return;

    // bind events
    opts.container.on( 'cycle-slide-added cycle-slide-removed', initAutoHeight );
    opts.container.on( 'cycle-destroyed', onDestroy );

    if ( autoHeight == 'container' ) {
        opts.container.on( 'cycle-before', onBefore );
    }
    else if ( t === 'string' && /\d+\:\d+/.test( autoHeight ) ) {
        // use ratio
        ratio = autoHeight.match(/(\d+)\:(\d+)/);
        ratio = ratio[1] / ratio[2];
        opts._autoHeightRatio = ratio;
    }

    // if autoHeight is a number then we don't need to recalculate the sentinel
    // index on resize
    if ( t !== 'number' ) {
        // bind unique resize handler per slideshow (so it can be 'off-ed' in onDestroy)
        opts._autoHeightOnResize = function () {
            clearTimeout( resizeThrottle );
            resizeThrottle = setTimeout( onResize, 50 );
        };

        $(window).on( 'resize orientationchange', opts._autoHeightOnResize );
    }

    setTimeout( onResize, 30 );

    function onResize() {
        initAutoHeight( e, opts );
    }
});

function initAutoHeight( e, opts ) {
    var clone, height, sentinelIndex;
    var autoHeight = opts.autoHeight;

    if ( autoHeight == 'container' ) {
        height = $( opts.slides[ opts.currSlide ] ).outerHeight();
        opts.container.height( height );
    }
    else if ( opts._autoHeightRatio ) {
        opts.container.height( opts.container.width() / opts._autoHeightRatio );
    }
    else if ( autoHeight === 'calc' || ( $.type( autoHeight ) == 'number' && autoHeight >= 0 ) ) {
        if ( autoHeight === 'calc' )
            sentinelIndex = calcSentinelIndex( e, opts );
        else if ( autoHeight >= opts.slides.length )
            sentinelIndex = 0;
        else
            sentinelIndex = autoHeight;

        // only recreate sentinel if index is different
        if ( sentinelIndex == opts._sentinelIndex )
            return;

        opts._sentinelIndex = sentinelIndex;
        if ( opts._sentinel )
            opts._sentinel.remove();

        // clone existing slide as sentinel
        clone = $( opts.slides[ sentinelIndex ].cloneNode(true) );

        // #50; remove special attributes from cloned content
        clone.removeAttr( 'id name rel' ).find( '[id],[name],[rel]' ).removeAttr( 'id name rel' );

        clone.css({
            position: 'static',
            visibility: 'hidden',
            display: 'block'
        }).prependTo( opts.container ).addClass('cycle-sentinel cycle-slide').removeClass('cycle-slide-active');
        clone.find( '*' ).css( 'visibility', 'hidden' );

        opts._sentinel = clone;
    }
}

function calcSentinelIndex( e, opts ) {
    var index = 0, max = -1;

    // calculate tallest slide index
    opts.slides.each(function(i) {
        var h = $(this).height();
        if ( h > max ) {
            max = h;
            index = i;
        }
    });
    return index;
}

function onBefore( e, opts, outgoing, incoming, forward ) {
    var h = $(incoming).outerHeight();
    opts.container.animate( { height: h }, opts.autoHeightSpeed, opts.autoHeightEasing );
}

function onDestroy( e, opts ) {
    if ( opts._autoHeightOnResize ) {
        $(window).off( 'resize orientationchange', opts._autoHeightOnResize );
        opts._autoHeightOnResize = null;
    }
    opts.container.off( 'cycle-slide-added cycle-slide-removed', initAutoHeight );
    opts.container.off( 'cycle-destroyed', onDestroy );
    opts.container.off( 'cycle-before', onBefore );

    if ( opts._sentinel ) {
        opts._sentinel.remove();
        opts._sentinel = null;
    }
}

})(jQuery);

/*! caption plugin for Cycle2;  version: 20130306 */
(function($) {
"use strict";

$.extend($.fn.cycle.defaults, {
    caption:          '> .cycle-caption',
    captionTemplate:  '{{slideNum}} / {{slideCount}}',
    overlay:          '> .cycle-overlay',
    overlayTemplate:  '<div>{{title}}</div><div>{{desc}}</div>',
    captionModule:    'caption'
});

$(document).on( 'cycle-update-view', function( e, opts, slideOpts, currSlide ) {
    if ( opts.captionModule !== 'caption' )
        return;
    var el;
    $.each(['caption','overlay'], function() {
        var name = this;
        var template = slideOpts[name+'Template'];
        var el = opts.API.getComponent( name );
        if( el.length && template ) {
            el.html( opts.API.tmpl( template, slideOpts, opts, currSlide ) );
            el.show();
        }
        else {
            el.hide();
        }
    });
});

$(document).on( 'cycle-destroyed', function( e, opts ) {
    var el;
    $.each(['caption','overlay'], function() {
        var name = this, template = opts[name+'Template'];
        if ( opts[name] && template ) {
            el = opts.API.getComponent( 'caption' );
            el.empty();
        }
    });
});

})(jQuery);

/*! command plugin for Cycle2;  version: 20130707 */
(function($) {
"use strict";

var c2 = $.fn.cycle;

$.fn.cycle = function( options ) {
    var cmd, cmdFn, opts;
    var args = $.makeArray( arguments );

    if ( $.type( options ) == 'number' ) {
        return this.cycle( 'goto', options );
    }

    if ( $.type( options ) == 'string' ) {
        return this.each(function() {
            var cmdArgs;
            cmd = options;
            opts = $(this).data('cycle.opts');

            if ( opts === undefined ) {
                c2.log('slideshow must be initialized before sending commands; "' + cmd + '" ignored');
                return;
            }
            else {
                cmd = cmd == 'goto' ? 'jump' : cmd; // issue #3; change 'goto' to 'jump' internally
                cmdFn = opts.API[ cmd ];
                if ( $.isFunction( cmdFn )) {
                    cmdArgs = $.makeArray( args );
                    cmdArgs.shift();
                    return cmdFn.apply( opts.API, cmdArgs );
                }
                else {
                    c2.log( 'unknown command: ', cmd );
                }
            }
        });
    }
    else {
        return c2.apply( this, arguments );
    }
};

// copy props
$.extend( $.fn.cycle, c2 );

$.extend( c2.API, {
    next: function() {
        var opts = this.opts();
        if ( opts.busy && ! opts.manualTrump )
            return;

        var count = opts.reverse ? -1 : 1;
        if ( opts.allowWrap === false && ( opts.currSlide + count ) >= opts.slideCount )
            return;

        opts.API.advanceSlide( count );
        opts.API.trigger('cycle-next', [ opts ]).log('cycle-next');
    },

    prev: function() {
        var opts = this.opts();
        if ( opts.busy && ! opts.manualTrump )
            return;
        var count = opts.reverse ? 1 : -1;
        if ( opts.allowWrap === false && ( opts.currSlide + count ) < 0 )
            return;

        opts.API.advanceSlide( count );
        opts.API.trigger('cycle-prev', [ opts ]).log('cycle-prev');
    },

    destroy: function() {
        this.stop(); //#204

        var opts = this.opts();
        var clean = $.isFunction( $._data ) ? $._data : $.noop;  // hack for #184 and #201
        clearTimeout(opts.timeoutId);
        opts.timeoutId = 0;
        opts.API.stop();
        opts.API.trigger( 'cycle-destroyed', [ opts ] ).log('cycle-destroyed');
        opts.container.removeData();
        clean( opts.container[0], 'parsedAttrs', false );

        // #75; remove inline styles
        if ( ! opts.retainStylesOnDestroy ) {
            opts.container.removeAttr( 'style' );
            opts.slides.removeAttr( 'style' );
            opts.slides.removeClass( opts.slideActiveClass );
        }
        opts.slides.each(function() {
            $(this).removeData();
            clean( this, 'parsedAttrs', false );
        });
    },

    jump: function( index ) {
        // go to the requested slide
        var fwd;
        var opts = this.opts();
        if ( opts.busy && ! opts.manualTrump )
            return;
        var num = parseInt( index, 10 );
        if (isNaN(num) || num < 0 || num >= opts.slides.length) {
            opts.API.log('goto: invalid slide index: ' + num);
            return;
        }
        if (num == opts.currSlide) {
            opts.API.log('goto: skipping, already on slide', num);
            return;
        }
        opts.nextSlide = num;
        clearTimeout(opts.timeoutId);
        opts.timeoutId = 0;
        opts.API.log('goto: ', num, ' (zero-index)');
        fwd = opts.currSlide < opts.nextSlide;
        opts.API.prepareTx( true, fwd );
    },

    stop: function() {
        var opts = this.opts();
        var pauseObj = opts.container;
        clearTimeout(opts.timeoutId);
        opts.timeoutId = 0;
        opts.API.stopTransition();
        if ( opts.pauseOnHover ) {
            if ( opts.pauseOnHover !== true )
                pauseObj = $( opts.pauseOnHover );
            pauseObj.off('mouseenter mouseleave');
        }
        opts.API.trigger('cycle-stopped', [ opts ]).log('cycle-stopped');
    },

    reinit: function() {
        var opts = this.opts();
        opts.API.destroy();
        opts.container.cycle();
    },

    remove: function( index ) {
        var opts = this.opts();
        var slide, slideToRemove, slides = [], slideNum = 1;
        for ( var i=0; i < opts.slides.length; i++ ) {
            slide = opts.slides[i];
            if ( i == index ) {
                slideToRemove = slide;
            }
            else {
                slides.push( slide );
                $( slide ).data('cycle.opts').slideNum = slideNum;
                slideNum++;
            }
        }
        if ( slideToRemove ) {
            opts.slides = $( slides );
            opts.slideCount--;
            $( slideToRemove ).remove();
            if (index == opts.currSlide)
                opts.API.advanceSlide( 1 );
            else if ( index < opts.currSlide )
                opts.currSlide--;
            else
                opts.currSlide++;

            opts.API.trigger('cycle-slide-removed', [ opts, index, slideToRemove ]).log('cycle-slide-removed');
            opts.API.updateView();
        }
    }

});

// listen for clicks on elements with data-cycle-cmd attribute
$(document).on('click.cycle', '[data-cycle-cmd]', function(e) {
    // issue cycle command
    e.preventDefault();
    var el = $(this);
    var command = el.data('cycle-cmd');
    var context = el.data('cycle-context') || '.cycle-slideshow';
    $(context).cycle(command, el.data('cycle-arg'));
});


})(jQuery);

/*! hash plugin for Cycle2;  version: 20130905 */
(function($) {
"use strict";

$(document).on( 'cycle-pre-initialize', function( e, opts ) {
    onHashChange( opts, true );

    opts._onHashChange = function() {
        onHashChange( opts, false );
    };

    $( window ).on( 'hashchange', opts._onHashChange);
});

$(document).on( 'cycle-update-view', function( e, opts, slideOpts ) {
    if ( slideOpts.hash && ( '#' + slideOpts.hash ) != window.location.hash ) {
        opts._hashFence = true;
        window.location.hash = slideOpts.hash;
    }
});

$(document).on( 'cycle-destroyed', function( e, opts) {
    if ( opts._onHashChange ) {
        $( window ).off( 'hashchange', opts._onHashChange );
    }
});

function onHashChange( opts, setStartingSlide ) {
    var hash;
    if ( opts._hashFence ) {
        opts._hashFence = false;
        return;
    }

    hash = window.location.hash.substring(1);

    opts.slides.each(function(i) {
        if ( $(this).data( 'cycle-hash' ) == hash ) {
            if ( setStartingSlide === true ) {
                opts.startingSlide = i;
            }
            else {
                var fwd = opts.currSlide < i;
                opts.nextSlide = i;
                opts.API.prepareTx( true, fwd );
            }
            return false;
        }
    });
}

})(jQuery);

/*! loader plugin for Cycle2;  version: 20131121 */
(function($) {
"use strict";

$.extend($.fn.cycle.defaults, {
    loader: false
});

$(document).on( 'cycle-bootstrap', function( e, opts ) {
    var addFn;

    if ( !opts.loader )
        return;

    // override API.add for this slideshow
    addFn = opts.API.add;
    opts.API.add = add;

    function add( slides, prepend ) {
        var slideArr = [];
        if ( $.type( slides ) == 'string' )
            slides = $.trim( slides );
        else if ( $.type( slides) === 'array' ) {
            for (var i=0; i < slides.length; i++ )
                slides[i] = $(slides[i])[0];
        }

        slides = $( slides );
        var slideCount = slides.length;

        if ( ! slideCount )
            return;

        slides.css('visibility','hidden').appendTo('body').each(function(i) { // appendTo fixes #56
            var count = 0;
            var slide = $(this);
            var images = slide.is('img') ? slide : slide.find('img');
            slide.data('index', i);
            // allow some images to be marked as unimportant (and filter out images w/o src value)
            images = images.filter(':not(.cycle-loader-ignore)').filter(':not([src=""])');
            if ( ! images.length ) {
                --slideCount;
                slideArr.push( slide );
                return;
            }

            count = images.length;
            images.each(function() {
                // add images that are already loaded
                if ( this.complete ) {
                    imageLoaded();
                }
                else {
                    $(this).load(function() {
                        imageLoaded();
                    }).on("error", function() {
                        if ( --count === 0 ) {
                            // ignore this slide
                            opts.API.log('slide skipped; img not loaded:', this.src);
                            if ( --slideCount === 0 && opts.loader == 'wait') {
                                addFn.apply( opts.API, [ slideArr, prepend ] );
                            }
                        }
                    });
                }
            });

            function imageLoaded() {
                if ( --count === 0 ) {
                    --slideCount;
                    addSlide( slide );
                }
            }
        });

        if ( slideCount )
            opts.container.addClass('cycle-loading');


        function addSlide( slide ) {
            var curr;
            if ( opts.loader == 'wait' ) {
                slideArr.push( slide );
                if ( slideCount === 0 ) {
                    // #59; sort slides into original markup order
                    slideArr.sort( sorter );
                    addFn.apply( opts.API, [ slideArr, prepend ] );
                    opts.container.removeClass('cycle-loading');
                }
            }
            else {
                curr = $(opts.slides[opts.currSlide]);
                addFn.apply( opts.API, [ slide, prepend ] );
                curr.show();
                opts.container.removeClass('cycle-loading');
            }
        }

        function sorter(a, b) {
            return a.data('index') - b.data('index');
        }
    }
});

})(jQuery);

/*! pager plugin for Cycle2;  version: 20130525 */
(function($) {
"use strict";

$.extend($.fn.cycle.defaults, {
    pager:            '> .cycle-pager',
    pagerActiveClass: 'cycle-pager-active',
    pagerEvent:       'click.cycle',
    pagerTemplate:    '<span>&bull;</span>'
});

$(document).on( 'cycle-bootstrap', function( e, opts, API ) {
    // add method to API
    API.buildPagerLink = buildPagerLink;
});

$(document).on( 'cycle-slide-added', function( e, opts, slideOpts, slideAdded ) {
    if ( opts.pager ) {
        opts.API.buildPagerLink ( opts, slideOpts, slideAdded );
        opts.API.page = page;
    }
});

$(document).on( 'cycle-slide-removed', function( e, opts, index, slideRemoved ) {
    if ( opts.pager ) {
        var pagers = opts.API.getComponent( 'pager' );
        pagers.each(function() {
            var pager = $(this);
            $( pager.children()[index] ).remove();
        });
    }
});

$(document).on( 'cycle-update-view', function( e, opts, slideOpts ) {
    var pagers;

    if ( opts.pager ) {
        pagers = opts.API.getComponent( 'pager' );
        pagers.each(function() {
           $(this).children().removeClass( opts.pagerActiveClass )
            .eq( opts.currSlide ).addClass( opts.pagerActiveClass );
        });
    }
});

$(document).on( 'cycle-destroyed', function( e, opts ) {
    var pager = opts.API.getComponent( 'pager' );

    if ( pager ) {
        pager.children().off( opts.pagerEvent ); // #202
        if ( opts.pagerTemplate )
            pager.empty();
    }
});

function buildPagerLink( opts, slideOpts, slide ) {
    var pagerLink;
    var pagers = opts.API.getComponent( 'pager' );
    pagers.each(function() {
        var pager = $(this);
        if ( slideOpts.pagerTemplate ) {
            var markup = opts.API.tmpl( slideOpts.pagerTemplate, slideOpts, opts, slide[0] );
            pagerLink = $( markup ).appendTo( pager );
        }
        else {
            pagerLink = pager.children().eq( opts.slideCount - 1 );
        }
        pagerLink.on( opts.pagerEvent, function(e) {
            e.preventDefault();
            opts.API.page( pager, e.currentTarget);
        });
    });
}

function page( pager, target ) {
    /*jshint validthis:true */
    var opts = this.opts();
    if ( opts.busy && ! opts.manualTrump )
        return;

    var index = pager.children().index( target );
    var nextSlide = index;
    var fwd = opts.currSlide < nextSlide;
    if (opts.currSlide == nextSlide) {
        return; // no op, clicked pager for the currently displayed slide
    }
    opts.nextSlide = nextSlide;
    opts.API.prepareTx( true, fwd );
    opts.API.trigger('cycle-pager-activated', [opts, pager, target ]);
}

})(jQuery);


/*! prevnext plugin for Cycle2;  version: 20130709 */
(function($) {
"use strict";

$.extend($.fn.cycle.defaults, {
    next:           '> .cycle-next',
    nextEvent:      'click.cycle',
    disabledClass:  'disabled',
    prev:           '> .cycle-prev',
    prevEvent:      'click.cycle',
    swipe:          false
});

$(document).on( 'cycle-initialized', function( e, opts ) {
    opts.API.getComponent( 'next' ).on( opts.nextEvent, function(e) {
        e.preventDefault();
        opts.API.next();
    });

    opts.API.getComponent( 'prev' ).on( opts.prevEvent, function(e) {
        e.preventDefault();
        opts.API.prev();
    });

    if ( opts.swipe ) {
        var nextEvent = opts.swipeVert ? 'swipeUp.cycle' : 'swipeLeft.cycle swipeleft.cycle';
        var prevEvent = opts.swipeVert ? 'swipeDown.cycle' : 'swipeRight.cycle swiperight.cycle';
        opts.container.on( nextEvent, function(e) {
            opts.API.next();
        });
        opts.container.on( prevEvent, function() {
            opts.API.prev();
        });
    }
});

$(document).on( 'cycle-update-view', function( e, opts, slideOpts, currSlide ) {
    if ( opts.allowWrap )
        return;

    var cls = opts.disabledClass;
    var next = opts.API.getComponent( 'next' );
    var prev = opts.API.getComponent( 'prev' );
    var prevBoundry = opts._prevBoundry || 0;
    var nextBoundry = (opts._nextBoundry !== undefined)?opts._nextBoundry:opts.slideCount - 1;

    if ( opts.currSlide == nextBoundry )
        next.addClass( cls ).prop( 'disabled', true );
    else
        next.removeClass( cls ).prop( 'disabled', false );

    if ( opts.currSlide === prevBoundry )
        prev.addClass( cls ).prop( 'disabled', true );
    else
        prev.removeClass( cls ).prop( 'disabled', false );
});


$(document).on( 'cycle-destroyed', function( e, opts ) {
    opts.API.getComponent( 'prev' ).off( opts.nextEvent );
    opts.API.getComponent( 'next' ).off( opts.prevEvent );
    opts.container.off( 'swipeleft.cycle swiperight.cycle swipeLeft.cycle swipeRight.cycle swipeUp.cycle swipeDown.cycle' );
});

})(jQuery);

/*! progressive loader plugin for Cycle2;  version: 20130315 */
(function($) {
"use strict";

$.extend($.fn.cycle.defaults, {
    progressive: false
});

$(document).on( 'cycle-pre-initialize', function( e, opts ) {
    if ( !opts.progressive )
        return;

    var API = opts.API;
    var nextFn = API.next;
    var prevFn = API.prev;
    var prepareTxFn = API.prepareTx;
    var type = $.type( opts.progressive );
    var slides, scriptEl;

    if ( type == 'array' ) {
        slides = opts.progressive;
    }
    else if ($.isFunction( opts.progressive ) ) {
        slides = opts.progressive( opts );
    }
    else if ( type == 'string' ) {
        scriptEl = $( opts.progressive );
        slides = $.trim( scriptEl.html() );
        if ( !slides )
            return;
        // is it json array?
        if ( /^(\[)/.test( slides ) ) {
            try {
                slides = $.parseJSON( slides );
            }
            catch(err) {
                API.log( 'error parsing progressive slides', err );
                return;
            }
        }
        else {
            // plain text, split on delimeter
            slides = slides.split( new RegExp( scriptEl.data('cycle-split') || '\n') );

            // #95; look for empty slide
            if ( ! slides[ slides.length - 1 ] )
                slides.pop();
        }
    }



    if ( prepareTxFn ) {
        API.prepareTx = function( manual, fwd ) {
            var index, slide;

            if ( manual || slides.length === 0 ) {
                prepareTxFn.apply( opts.API, [ manual, fwd ] );
                return;
            }

            if ( fwd && opts.currSlide == ( opts.slideCount-1) ) {
                slide = slides[ 0 ];
                slides = slides.slice( 1 );
                opts.container.one('cycle-slide-added', function(e, opts ) {
                    setTimeout(function() {
                        opts.API.advanceSlide( 1 );
                    },50);
                });
                opts.API.add( slide );
            }
            else if ( !fwd && opts.currSlide === 0 ) {
                index = slides.length-1;
                slide = slides[ index ];
                slides = slides.slice( 0, index );
                opts.container.one('cycle-slide-added', function(e, opts ) {
                    setTimeout(function() {
                        opts.currSlide = 1;
                        opts.API.advanceSlide( -1 );
                    },50);
                });
                opts.API.add( slide, true );
            }
            else {
                prepareTxFn.apply( opts.API, [ manual, fwd ] );
            }
        };
    }

    if ( nextFn ) {
        API.next = function() {
            var opts = this.opts();
            if ( slides.length && opts.currSlide == ( opts.slideCount - 1 ) ) {
                var slide = slides[ 0 ];
                slides = slides.slice( 1 );
                opts.container.one('cycle-slide-added', function(e, opts ) {
                    nextFn.apply( opts.API );
                    opts.container.removeClass('cycle-loading');
                });
                opts.container.addClass('cycle-loading');
                opts.API.add( slide );
            }
            else {
                nextFn.apply( opts.API );
            }
        };
    }

    if ( prevFn ) {
        API.prev = function() {
            var opts = this.opts();
            if ( slides.length && opts.currSlide === 0 ) {
                var index = slides.length-1;
                var slide = slides[ index ];
                slides = slides.slice( 0, index );
                opts.container.one('cycle-slide-added', function(e, opts ) {
                    opts.currSlide = 1;
                    opts.API.advanceSlide( -1 );
                    opts.container.removeClass('cycle-loading');
                });
                opts.container.addClass('cycle-loading');
                opts.API.add( slide, true );
            }
            else {
                prevFn.apply( opts.API );
            }
        };
    }
});

})(jQuery);

/*! tmpl plugin for Cycle2;  version: 20121227 */
(function($) {
"use strict";

$.extend($.fn.cycle.defaults, {
    tmplRegex: '{{((.)?.*?)}}'
});

$.extend($.fn.cycle.API, {
    tmpl: function( str, opts /*, ... */) {
        var regex = new RegExp( opts.tmplRegex || $.fn.cycle.defaults.tmplRegex, 'g' );
        var args = $.makeArray( arguments );
        args.shift();
        return str.replace(regex, function(_, str) {
            var i, j, obj, prop, names = str.split('.');
            for (i=0; i < args.length; i++) {
                obj = args[i];
                if ( ! obj )
                    continue;
                if (names.length > 1) {
                    prop = obj;
                    for (j=0; j < names.length; j++) {
                        obj = prop;
                        prop = prop[ names[j] ] || str;
                    }
                } else {
                    prop = obj[str];
                }

                if ($.isFunction(prop))
                    return prop.apply(obj, args);
                if (prop !== undefined && prop !== null && prop != str)
                    return prop;
            }
            return str;
        });
    }
});

})(jQuery);


/* - ++resource++brasil.gov.tiles/jquery.cycle2.carousel.js - */
/*! carousel transition plugin for Cycle2;  version: 20130528 */
(function($) {
"use strict";

$( document ).on('cycle-bootstrap', function( e, opts, API ) {
    if ( opts.fx !== 'carousel' )
        return;

    API.getSlideIndex = function( el ) {
        var slides = this.opts()._carouselWrap.children();
        var i = slides.index( el );
        return i % slides.length;
    };

    // override default 'next' function
    API.next = function() {
        var count = opts.reverse ? -1 : 1;
        if ( opts.allowWrap === false && ( opts.currSlide + count ) > opts.slideCount - opts.carouselVisible )
            return;
        opts.API.advanceSlide( count );
        opts.API.trigger('cycle-next', [ opts ]).log('cycle-next');
    };

});


$.fn.cycle.transitions.carousel = {
    // transition API impl
    preInit: function( opts ) {
        opts.hideNonActive = false;

        opts.container.on('cycle-destroyed', $.proxy(this.onDestroy, opts.API));
        // override default API implementation
        opts.API.stopTransition = this.stopTransition;

        // issue #10
        for (var i=0; i < opts.startingSlide; i++) {
            opts.container.append( opts.slides[0] );
        }
    },

    // transition API impl
    postInit: function( opts ) {
        var i, j, slide, pagerCutoffIndex, wrap;
        var vert = opts.carouselVertical;
        if (opts.carouselVisible && opts.carouselVisible > opts.slideCount)
            opts.carouselVisible = opts.slideCount - 1;
        var visCount = opts.carouselVisible || opts.slides.length;
        var slideCSS = { display: vert ? 'block' : 'inline-block', position: 'static' };

        // required styles
        opts.container.css({ position: 'relative', overflow: 'hidden' });
        opts.slides.css( slideCSS );

        opts._currSlide = opts.currSlide;

        // wrap slides in a div; this div is what is animated
        wrap = $('<div class="cycle-carousel-wrap"></div>')
            .prependTo( opts.container )
            .css({ margin: 0, padding: 0, top: 0, left: 0, position: 'absolute' })
            .append( opts.slides );

        opts._carouselWrap = wrap;

        if ( !vert )
            wrap.css('white-space', 'nowrap');

        if ( opts.allowWrap !== false ) {
            // prepend and append extra slides so we don't see any empty space when we
            // near the end of the carousel.  for fluid containers, add even more clones
            // so there is plenty to fill the screen
            // @todo: optimzie this based on slide sizes

            for ( j=0; j < (opts.carouselVisible === undefined ? 2 : 1); j++ ) {
                for ( i=0; i < opts.slideCount; i++ ) {
                    wrap.append( opts.slides[i].cloneNode(true) );
                }
                i = opts.slideCount;
                while ( i-- ) { // #160, #209
                    wrap.prepend( opts.slides[i].cloneNode(true) );
                }
            }

            wrap.find('.cycle-slide-active').removeClass('cycle-slide-active');
            opts.slides.eq(opts.startingSlide).addClass('cycle-slide-active');
        }

        if ( opts.pager && opts.allowWrap === false ) {
            // hide "extra" pagers
            pagerCutoffIndex = opts.slideCount - visCount;
            $( opts.pager ).children().filter( ':gt('+pagerCutoffIndex+')' ).hide();
        }

        opts._nextBoundry = opts.slideCount - opts.carouselVisible;

        this.prepareDimensions( opts );
    },

    prepareDimensions: function( opts ) {
        var dim, offset, pagerCutoffIndex, tmp;
        var vert = opts.carouselVertical;
        var visCount = opts.carouselVisible || opts.slides.length;

        if ( opts.carouselFluid && opts.carouselVisible ) {
            if ( ! opts._carouselResizeThrottle ) {
            // fluid container AND fluid slides; slides need to be resized to fit container
                this.fluidSlides( opts );
            }
        }
        else if ( opts.carouselVisible && opts.carouselSlideDimension ) {
            dim = visCount * opts.carouselSlideDimension;
            opts.container[ vert ? 'height' : 'width' ]( dim );
        }
        else if ( opts.carouselVisible ) {
            dim = visCount * $(opts.slides[0])[vert ? 'outerHeight' : 'outerWidth'](true);
            opts.container[ vert ? 'height' : 'width' ]( dim );
        }
        // else {
        //     // fluid; don't size the container
        // }

        offset = ( opts.carouselOffset || 0 );
        if ( opts.allowWrap !== false ) {
            if ( opts.carouselSlideDimension ) {
                offset -= ( (opts.slideCount + opts.currSlide) * opts.carouselSlideDimension );
            }
            else {
                // calculate offset based on actual slide dimensions
                tmp = opts._carouselWrap.children();
                for (var j=0; j < (opts.slideCount + opts.currSlide); j++) {
                    offset -= $(tmp[j])[vert?'outerHeight':'outerWidth'](true);
                }
            }
        }

        opts._carouselWrap.css( vert ? 'top' : 'left', offset );
    },

    fluidSlides: function( opts ) {
        var timeout;
        var slide = opts.slides.eq(0);
        var adjustment = slide.outerWidth() - slide.width();
        var prepareDimensions = this.prepareDimensions;

        // throttle resize event
        $(window).on( 'resize', resizeThrottle);

        opts._carouselResizeThrottle = resizeThrottle;
        onResize();

        function resizeThrottle() {
            clearTimeout( timeout );
            timeout = setTimeout( onResize, 20 );
        }

        function onResize() {
            opts._carouselWrap.stop( false, true );
            var slideWidth = opts.container.width() / opts.carouselVisible;
            slideWidth = Math.ceil( slideWidth - adjustment );
            opts._carouselWrap.children().width( slideWidth );
            if ( opts._sentinel )
                opts._sentinel.width( slideWidth );
            prepareDimensions( opts );
        }
    },

    // transition API impl
    transition: function( opts, curr, next, fwd, callback ) {
        var moveBy, props = {};
        var hops = opts.nextSlide - opts.currSlide;
        var vert = opts.carouselVertical;
        var speed = opts.speed;

        // handle all the edge cases for wrapping & non-wrapping
        if ( opts.allowWrap === false ) {
            fwd = hops > 0;
            var currSlide = opts._currSlide;
            var maxCurr = opts.slideCount - opts.carouselVisible;
            if ( hops > 0 && opts.nextSlide > maxCurr && currSlide == maxCurr ) {
                hops = 0;
            }
            else if ( hops > 0 && opts.nextSlide > maxCurr ) {
                hops = opts.nextSlide - currSlide - (opts.nextSlide - maxCurr);
            }
            else if ( hops < 0 && opts.currSlide > maxCurr && opts.nextSlide > maxCurr ) {
                hops = 0;
            }
            else if ( hops < 0 && opts.currSlide > maxCurr ) {
                hops += opts.currSlide - maxCurr;
            }
            else
                currSlide = opts.currSlide;

            moveBy = this.getScroll( opts, vert, currSlide, hops );
            opts.API.opts()._currSlide = opts.nextSlide > maxCurr ? maxCurr : opts.nextSlide;
        }
        else {
            if ( fwd && opts.nextSlide === 0 ) {
                // moving from last slide to first
                moveBy = this.getDim( opts, opts.currSlide, vert );
                callback = this.genCallback( opts, fwd, vert, callback );
            }
            else if ( !fwd && opts.nextSlide == opts.slideCount - 1 ) {
                // moving from first slide to last
                moveBy = this.getDim( opts, opts.currSlide, vert );
                callback = this.genCallback( opts, fwd, vert, callback );
            }
            else {
                moveBy = this.getScroll( opts, vert, opts.currSlide, hops );
            }
        }

        props[ vert ? 'top' : 'left' ] = fwd ? ( "-=" + moveBy ) : ( "+=" + moveBy );

        // throttleSpeed means to scroll slides at a constant rate, rather than
        // a constant speed
        if ( opts.throttleSpeed )
            speed = (moveBy / $(opts.slides[0])[vert ? 'height' : 'width']() ) * opts.speed;

        opts._carouselWrap.animate( props, speed, opts.easing, callback );
    },

    getDim: function( opts, index, vert ) {
        var slide = $( opts.slides[index] );
        return slide[ vert ? 'outerHeight' : 'outerWidth'](true);
    },

    getScroll: function( opts, vert, currSlide, hops ) {
        var i, moveBy = 0;

        if (hops > 0) {
            for (i=currSlide; i < currSlide+hops; i++)
                moveBy += this.getDim( opts, i, vert);
        }
        else {
            for (i=currSlide; i > currSlide+hops; i--)
                moveBy += this.getDim( opts, i, vert);
        }
        return moveBy;
    },

    genCallback: function( opts, fwd, vert, callback ) {
        // returns callback fn that resets the left/top wrap position to the "real" slides
        return function() {
            var pos = $(opts.slides[opts.nextSlide]).position();
            var offset = 0 - pos[vert?'top':'left'] + (opts.carouselOffset || 0);
            opts._carouselWrap.css( opts.carouselVertical ? 'top' : 'left', offset );
            callback();
        };
    },

    // core API override
    stopTransition: function() {
        var opts = this.opts();
        opts.slides.stop( false, true );
        opts._carouselWrap.stop( false, true );
    },

    // core API supplement
    onDestroy: function( e ) {
        var opts = this.opts();
        if ( opts._carouselResizeThrottle )
            $( window ).off( 'resize', opts._carouselResizeThrottle );
        opts.slides.prependTo( opts.container );
        opts._carouselWrap.remove();
    }
};

})(jQuery);


/* - ++resource++brasil.gov.tiles/tiles.js - */
/*
  Comentario
*/
$(function() {
    var root = typeof exports !== "undefined" && exports !== null ? exports : this;

    //video gallery
    if ($('.videogallery-tile')[0] !== undefined) {
        var videoResponsiveResize;

        root.VideoResponsiveResize = function () {
            var _Singleton, _base;
            _Singleton = (function () {
                function _Singleton() {}

                _Singleton.prototype.qtd_coluna_anterior = '';
                _Singleton.prototype.scrollbar = false;

                _Singleton.prototype.resize = function () {
                    var qtd_coluna_atual;

                    qtd_coluna_atual = 1;

                    if ($(window).width() > 480) {
                        qtd_coluna_atual = 2;
                    }

                    // 3 columns, 460 + 30 padding
                    if ($(window).width() > 960) {
                        qtd_coluna_atual = 3;
                    }

                    if (this.qtd_coluna_anterior !== qtd_coluna_atual) {
                        this.qtd_coluna_anterior = qtd_coluna_atual;

                        $('.videogallery-tile').each(function(){
                            $(this).removeClass('gallery-2-columns');
                            $(this).removeClass('gallery-3-columns');

                            if (qtd_coluna_atual === 2) {
                                $(this).addClass('gallery-2-columns');
                            } else if (qtd_coluna_atual === 3) { // Desktop
                                $(this).addClass('gallery-3-columns');
                            }

                            //resize video onload
                            var video_width = $('.player-holder iframe').width();
                            $('.player-holder iframe').height(video_width/1.3333);

                            //video loading logic
                            var video_gallery = $(this);
                            var gallery_link = video_gallery.find('.gallery-element').find('.gallery-element-link');
                            gallery_link.click(function(e){
                                e.preventDefault();

                                var player = $(this).data('player-dom');
                                var metadata = $(this).siblings('.gallery-element-metadata');

                                video_gallery.find('.selected').removeClass('selected');
                                $(this).parents('.gallery-element').addClass('selected');

                                var player_slot = video_gallery.find('.player-holder');
                                player_slot.find('.player-video').html(player);
                                player_slot.find('.title').html(metadata.find('.title').html());
                                player_slot.find('.description').html(metadata.find('.description').html());

                                //resize video onload
                                var video_width = $('.player-holder iframe').width();
                                $('.player-holder iframe').height(video_width/1.3333);
                            });
                        });
                    }
                };

                return _Singleton;
            })();


            if ((_base = root.VideoResponsiveResize).instance == null) {
                _base.instance = new _Singleton();
            }
            return root.VideoResponsiveResize.instance;
        };

        var resize = function () {
            videoResponsiveResize = new root.VideoResponsiveResize();
            videoResponsiveResize.resize();
        }

        $(window).resize(function () {
            resize();
        });

        resize();
    }

    if ($('.mediacarousel-tile')[0] !== undefined) {
        var carouselResponsiveResize;

        root.CarouselResponsiveResize = function () {
            var _Singleton, _base;
            _Singleton = (function () {
                function _Singleton() {}

                _Singleton.prototype.qtd_coluna_anterior = '';
                _Singleton.prototype.scrollbar = false;

                _Singleton.prototype.resize = function () {
                    var qtd_coluna_atual;

                    qtd_coluna_atual = 1;

                    if ($(window).width() > 480) {
                        qtd_coluna_atual = 2;
                    }

                    // 3 columns, 460 + 30 padding
                    if ($(window).width() > 960) {
                        qtd_coluna_atual = 3;
                    }

                    if (this.qtd_coluna_anterior !== qtd_coluna_atual) {
                        this.qtd_coluna_anterior = qtd_coluna_atual;
                        var _i, _len;
                        var gallerias = Galleria.get();

                        for (_i = 0, _len = gallerias.length; _i < _len; _i++) {
                            var g = gallerias[_i];
                            if (g) {
                                var mediacarousel = '#' + g._target.id;
                                g.resize({
                                    width: g._stageWidth,
                                    height: g._stageWidth*3/4
                                });
                                $(mediacarousel).css({
                                    height: g._stageWidth*3/4
                                });

                                var bottomThumbs = $('.galleria-thumbnails-container', mediacarousel).offset().top +
                                    $('.galleria-thumbnails-container', mediacarousel).height();
                                var bottomContainer = $(mediacarousel).offset().top +
                                    $(mediacarousel).height();
                                var heightContainer = $(mediacarousel).height() +
                                    (bottomThumbs             -
                                     bottomContainer)         +
                                    ($(mediacarousel+' + .mediacarousel-footer-container a').text === '' ? 39: 18) +
                                    8;
                                $(mediacarousel).css({
                                    height: heightContainer
                                });
                                var tile = $(mediacarousel).parent().parent();
                                $('.loading-mask', tile).css({
                                    height: tile.height() + 15
                                });
                            }
                        }
                    }
                };

                return _Singleton;
            })();


            if ((_base = root.CarouselResponsiveResize).instance == null) {
                _base.instance = new _Singleton();
            }
            return root.CarouselResponsiveResize.instance;
        };

        var resize = function () {
            carouselResponsiveResize = new root.CarouselResponsiveResize();
            carouselResponsiveResize.resize();
        }

        $(window).resize(function () {
            resize();
        });

        resize();
    }

    function AudioPlayer(audio_element, conf) {
        var self = this,
            cssSelectorAncestor = conf.cssSelectorAncestor,
            ae = audio_element;

        $.extend(self, {
            init: function(){
                var audio_url = self.get_audio_url();
                var media = self.get_media(audio_url);

                ae.jPlayer({
                    ready: function () {
                        $(this).jPlayer("setMedia", media.media_urls);
                    },
                    swfPath: "/++resource++brasil.gov.tiles",
                    supplied: media.supplied,
                    cssSelectorAncestor: cssSelectorAncestor,
                    solution:"html,flash",
                    wmode: "window",
                    preload: "none"
                });
            },

            /**
             * Construct the setMedia list of option and the supplied list
             **/
            get_media: function(urls){
                var media = {'media_urls':{}, 'supplied':''};
                var media_type, url, _i, _len;

                urls = urls.split(';');
                for (_i = 0, _len = urls.length; _i < _len; _i++) {
                    url = urls[_i];
                    media_type = self.get_media_type(url);
                    if (media_type){
                        media['media_urls'][media_type] = url;
                        if (media['supplied']) {
                            media['supplied'] += ', ';
                        }
                        media['supplied'] += media_type;

                    }
                }

                return media;
            },

            /**
             * Get the audio url from the configuration or the data attribute in the
             * main element
             **/
            get_audio_url: function(){
                var url = conf.audio_url? conf.audio_url : ae.data('audio-url');
                return url;
            },

            /**
             * Function to gleam the media type from the URL
             *
             **/
            get_media_type: function(url) {
                var mediaType = false;
                if(/\.mp3$/i.test(url)) {
                    mediaType = 'mp3';
                } else if(/\.mp4$/i.test(url) || /\.m4v$/i.test(url)) {
                    mediaType = 'm4v';
                } else if(/\.m4a$/i.test(url)) {
                    mediaType = 'm4a';
                } else if(/\.ogg$/i.test(url) || /\.oga$/i.test(url)) {
                    mediaType = 'oga';
                } else if(/\.ogv$/i.test(url)) {
                    mediaType = 'ogv';
                } else if(/\.webm$/i.test(url)) {
                    mediaType = 'webmv';
                }
                return mediaType;
            },

            /**
             * Method to update the media element reproduced in the player
             * requires just a media url
             **/
            update_player: function(new_url) {
                //clear all media (even if is running)
                //ae.jPlayer("clearMedia");
                conf.audio_url = new_url;

                var audio_url = self.get_audio_url();
                var media = self.get_media(audio_url);

                ae.jPlayer( "clearMedia" );
                ae.jPlayer("option", 'swfPath', '/++resource++brasil.gov.tiles');

                ae.jPlayer("option", "supplied", media.supplied);
                ae.jPlayer("setMedia", media.media_urls);

            }
        });
        self.init();
    }

    $.fn.audio_player = function(options) {

        // already instanced, return the data object
        var el = this.data("audio_player");
        if (el) { return el; }


        var default_settings = this.data('audio_player-settings');
        var settings = '';
        //default settings
        if (default_settings) {
            settings = default_settings;
        } else {
            settings = {
                'cssSelectorAncestor': '#jp_container_1',
            }
        }

        if (options) {
            $.extend(settings, options);
        }

        return this.each(function() {
            el = new AudioPlayer($(this), settings);
            $(this).data("audio_player", el);
        });

    };

    function AudioGallery(gallery) {
        var self = this,
            gallery_obj = gallery,
            player = gallery_obj.find('.jp-jplayer'),
            ancestor = '#' + gallery_obj.find('.jp-audio').attr('id');

        $.extend(self, {
            init: function(){
                self.bind_events();
                player.audio_player({'cssSelectorAncestor':ancestor});
            },

            bind_events: function() {
                var links = gallery_obj.find('.audiogallery-item');
                links.click(function(e){
                    e.preventDefault();
                    self.update($(this).attr('href'));
                    links.parent('li').removeClass('selected');
                    $(this).parent('li').addClass('selected');
                    gallery_obj.find('.audiogallery-item-title').html($(this).html());
                });
            },

            update: function(url) {
                var p = player.audio_player({'cssSelectorAncestor':ancestor});
                p.update_player(url);
            }
        });
        self.init();
    }

    $.fn.audiogallery = function() {

        // already instanced, return the data object
        var el = this.data("audiogallery");
        if (el) { return el; }


        var default_settings = this.data('audiogallery-settings');

        return this.each(function() {
            el = new AudioGallery($(this));
            $(this).data("audiogallery", el);
        });

    };

    function MediaCarousel(mediacarousel) {
        var self = this,
            galleria_id = mediacarousel.attr('id');

        $.extend(self, {
            init: function(){
                Galleria.loadTheme(window.location.href.trim('/') + '/++resource++brasil.gov.tiles/galleria.classic.min.js');

                Galleria.configure({
                    _toggleInfo: false, // Set this to false if you want the caption to show always
                    debug      : false, // Set this to false to prevent debug messages
                    imageCrop  : false, // Defines how Galleria will crop the image
                    wait       : true,  // Defines if and how Galleria should wait until it can be displayed using user interaction
                    responsive : false  // This option sets thew Gallery in responsive mode
                });

                Galleria.on('image', function(e) {
                    var mediacarousel = '#'+this._target.id;

                    // Sometimes (I don't know why) Galleria fails, so I need to check if it worked and remove duplicates
                    if (($('.galleria-layer>.rights', mediacarousel).length > 0) &&
                        ($('.galleria-info-text>.rights[data-index='+e.index+']', mediacarousel).length > 0)) {
                        $('.galleria-info-text>.rights[data-index='+e.index+']', mediacarousel).remove();
                    }

                    // Move the layer element to the right place
                    if ($('.galleria-layer>.rights', mediacarousel).length > 0) {
                        $('.galleria-info-text', mediacarousel).append($('.galleria-layer>.rights', mediacarousel));
                    }

                    // Sometimes (I don't know why) Galleria fails, so I need to check if it worked and hide duplicates
                    if ($('.galleria-info-text>.rights[data-index='+e.index+']', mediacarousel).length > 0) {
                        $('.rights', mediacarousel).each(function(){
                            $(this).css('display', 'none');
                        });
                        $('.galleria-info-text>.rights[data-index='+e.index+']', mediacarousel).css('display', 'block');
                    }

                    $('.galleria-thumbnails-container', mediacarousel).insertAfter($('.galleria-info', mediacarousel));
                    var bottomThumbs = $('.galleria-thumbnails-container', mediacarousel).offset().top +
                                       $('.galleria-thumbnails-container', mediacarousel).height();
                    var bottomContainer = $(mediacarousel).offset().top +
                                          $(mediacarousel).height();
                    var heightContainer = $(mediacarousel).height() +
                                          (bottomThumbs             -
                                           bottomContainer)         +
                                          ($(mediacarousel+' + .mediacarousel-footer-container a').text === '' ? 39: 18) +
                                          8;

                    if (!$(mediacarousel).hasClass('image')){
                        $(mediacarousel).addClass('image');
                        $(mediacarousel).animate({
                            height: heightContainer
                        });
                        $('.galleria-thumbnails-container, .galleria-info').animate({
                            opacity: 1
                        }, function () {
                            var tile = $(mediacarousel).parent().parent();
                            $('.loading-mask', tile).css({
                                height: tile.height() + 15
                            });
                        });
                    }
                });
                Galleria.on('loadfinish', function(e) {
                    var mediacarousel = '#'+this._target.id;
                    $('.galleria-thumbnails-container', mediacarousel).insertAfter($('.galleria-info', mediacarousel));
                    var bottomThumbs = $('.galleria-thumbnails-container', mediacarousel).offset().top +
                                       $('.galleria-thumbnails-container', mediacarousel).height();
                    var bottomContainer = $(mediacarousel).offset().top +
                                          $(mediacarousel).height();
                    var heightContainer = $(mediacarousel).height() +
                                          (bottomThumbs             -
                                           bottomContainer)         +
                                          ($(mediacarousel+' + .mediacarousel-footer-container a').text === '' ? 39: 18) +
                                          8;

                    var tile           = $(mediacarousel).parent().parent(),
                        thumbGaleria   = $('.galleria-thumbnails-list', tile),
                        navGaleriaNext = $('.galleria-thumb-nav-right', tile);
                    if (navGaleriaNext.hasClass('disabled')) {
                        thumbGaleria.css({ 'margin-right': 10 });
                    } else {
                        thumbGaleria.css({ 'margin-right': 40 });
                    }
                    if ($(mediacarousel).hasClass('image')) {
                        $(mediacarousel).css({
                            height: heightContainer
                        });
                        var tile = $(mediacarousel).parent().parent();
                        $('.loading-mask', tile).css({
                            height: tile.height() + 15
                        });
                    }
                });
                Galleria.run('#'+galleria_id);

                Galleria.ready(function() {
                    var galleriaContainer = $('#'+this._target.id),
                        tile = $(galleriaContainer).parent().parent();
                    if (!galleriaContainer.hasClass('ready')) {
                        galleriaContainer.addClass('ready');
                        var galleriaContainerWidth  = galleriaContainer.width(),
                            galleriaContainerHeight = (galleriaContainerWidth*3)/4;
                        this.resize({
                            width: galleriaContainerWidth,
                            height: galleriaContainerHeight
                        });
                    }
                    $('.galleria-thumb-nav-left, .galleria-thumb-nav-right, .galleria-thumbnails .galleria-image img', tile).on('click', function() {
                        var thumbGaleria   = $('.galleria-thumbnails-list', tile),
                            navGaleriaNext = $('.galleria-thumb-nav-right', tile);
                        if (navGaleriaNext.hasClass('disabled')) {
                            thumbGaleria.css({ 'margin-right': 10 });
                        } else {
                            thumbGaleria.css({ 'margin-right': 40 });
                        }
                    });
                });
            },
        });
        self.init();
    }
    $.fn.mediacarousel = function() {

        // already instanced, return the data object
        var el = this.data("mediacarousel");
        if (el) { return el; }

        var default_settings = this.data('mediacarousel-settings');

        return this.each(function() {
            el = new MediaCarousel($(this));
            $(this).data("mediacarousel", el);

        });
    };
    $(document).on(
        'submit',
        'form[action*=edit-tile\\/mediacarousel]',
        function(){
            setTimeout(function() {
                location.reload();
            }, 400);
        }
    );

    // Tile Galeria de Albuns
    var albuns = {
        // View de álbum carrossel (carrossel de imagens do álbum)
        carrossel: function () {
            if (!root.cycle2_loaded) {
                root.cycle2_loaded = true;

                var obj = this;
                $('.cycle-slideshow').on('cycle-next cycle-prev', function (e, opts) {
                    var $galeria = $(this).parent().parent();
                    var $slideshows = $('.cycle-slideshow', $galeria);
                    $slideshows.not(this).cycle('goto', opts.currSlide);
                    obj.layoutAdjustment($galeria, opts.currSlide);
                });

                // Aplicando o mesmo controle de navegacao para os thumbs e galerias
                $('.cycle-carrossel .thumb-itens').click(function (e){
                    e.preventDefault();
                    var $thumbs = $(this).parent().parent();
                    var $galeria = $thumbs.parent().parent();
                    var $slideshows = $('.cycle-slideshow', $galeria);
                    var index = $thumbs.data('cycle.API').getSlideIndex(this);
                    $slideshows.cycle('goto', index);
                    obj.layoutAdjustment($galeria, index);
                });

                // Adicionando navegação por teclado
                $(document.documentElement).keyup(function (event) {
                    if (event.keyCode == 37) {
                        $('.cycle-prev').trigger('click');
                    } else if (event.keyCode == 39) {
                        $('.cycle-next').trigger('click');
                    }
                });

                $('.cycle-slideshow').each(function(){
                    var $galeria = $(this).parent().parent();
                    obj.layoutAdjustment($galeria, 0);
                });
            }
        },

        layoutAdjustment: function($galeria, index){
            var aElem = $(".cycle-player .cycle-slide", $galeria),
                elem,
                novaaltura,
                alturaimagem,
                larguracarosel;

            // Pula primeiro elemento
            index = index + 1;
            elem = aElem[index],
            novaaltura = $(elem).height();
            alturaimagem = $('.cycle-sentinel img', $galeria).height();
            larguracarosel = ($('.carousel', $galeria).width() -
                              (36 * 2));

            $('.cycle-sentinel', $galeria).height(novaaltura);
            $('.cycle-hover', $galeria).height(alturaimagem);
            $('.cycle-carrossel', $galeria).width(larguracarosel);
        }
    };
    $(window).load(function(){
        albuns.carrossel();
    });
});


/* - ++resource++brasil.gov.tiles/jquery.jplayer.min.js - */
/*
 * jPlayer Plugin for jQuery JavaScript Library
 * http://www.jplayer.org
 *
 * Copyright (c) 2009 - 2013 Happyworm Ltd
 * Dual licensed under the MIT and GPL licenses.
 *  - http://www.opensource.org/licenses/mit-license.php
 *  - http://www.gnu.org/copyleft/gpl.html
 *
 * Author: Mark J Panaghiston
 * Version: 2.3.0
 * Date: 20th April 2013
 */
(function(b,f){"function"===typeof define&&define.amd?define(["jquery"],f):f(b.jQuery)})(this,function(b,f){b.fn.jPlayer=function(a){var c="string"===typeof a,d=Array.prototype.slice.call(arguments,1),e=this;a=!c&&d.length?b.extend.apply(null,[!0,a].concat(d)):a;if(c&&"_"===a.charAt(0))return e;c?this.each(function(){var c=b.data(this,"jPlayer"),h=c&&b.isFunction(c[a])?c[a].apply(c,d):c;if(h!==c&&h!==f)return e=h,!1}):this.each(function(){var c=b.data(this,"jPlayer");c?c.option(a||{}):b.data(this,
"jPlayer",new b.jPlayer(a,this))});return e};b.jPlayer=function(a,c){if(arguments.length){this.element=b(c);this.options=b.extend(!0,{},this.options,a);var d=this;this.element.bind("remove.jPlayer",function(){d.destroy()});this._init()}};b.jPlayer.emulateMethods="load play pause";b.jPlayer.emulateStatus="src readyState networkState currentTime duration paused ended playbackRate";b.jPlayer.emulateOptions="muted volume";b.jPlayer.reservedEvent="ready flashreset resize repeat error warning";b.jPlayer.event=
{};b.each("ready flashreset resize repeat click error warning loadstart progress suspend abort emptied stalled play pause loadedmetadata loadeddata waiting playing canplay canplaythrough seeking seeked timeupdate ended ratechange durationchange volumechange".split(" "),function(){b.jPlayer.event[this]="jPlayer_"+this});b.jPlayer.htmlEvent="loadstart abort emptied stalled loadedmetadata loadeddata canplay canplaythrough ratechange".split(" ");b.jPlayer.pause=function(){b.each(b.jPlayer.prototype.instances,
function(a,c){c.data("jPlayer").status.srcSet&&c.jPlayer("pause")})};b.jPlayer.timeFormat={showHour:!1,showMin:!0,showSec:!0,padHour:!1,padMin:!0,padSec:!0,sepHour:":",sepMin:":",sepSec:""};var l=function(){this.init()};l.prototype={init:function(){this.options={timeFormat:b.jPlayer.timeFormat}},time:function(a){var c=new Date(1E3*(a&&"number"===typeof a?a:0)),b=c.getUTCHours();a=this.options.timeFormat.showHour?c.getUTCMinutes():c.getUTCMinutes()+60*b;c=this.options.timeFormat.showMin?c.getUTCSeconds():
c.getUTCSeconds()+60*a;b=this.options.timeFormat.padHour&&10>b?"0"+b:b;a=this.options.timeFormat.padMin&&10>a?"0"+a:a;c=this.options.timeFormat.padSec&&10>c?"0"+c:c;b=""+(this.options.timeFormat.showHour?b+this.options.timeFormat.sepHour:"");b+=this.options.timeFormat.showMin?a+this.options.timeFormat.sepMin:"";return b+=this.options.timeFormat.showSec?c+this.options.timeFormat.sepSec:""}};var m=new l;b.jPlayer.convertTime=function(a){return m.time(a)};b.jPlayer.uaBrowser=function(a){a=a.toLowerCase();
var b=/(opera)(?:.*version)?[ \/]([\w.]+)/,d=/(msie) ([\w.]+)/,e=/(mozilla)(?:.*? rv:([\w.]+))?/;a=/(webkit)[ \/]([\w.]+)/.exec(a)||b.exec(a)||d.exec(a)||0>a.indexOf("compatible")&&e.exec(a)||[];return{browser:a[1]||"",version:a[2]||"0"}};b.jPlayer.uaPlatform=function(a){var b=a.toLowerCase(),d=/(android)/,e=/(mobile)/;a=/(ipad|iphone|ipod|android|blackberry|playbook|windows ce|webos)/.exec(b)||[];b=/(ipad|playbook)/.exec(b)||!e.exec(b)&&d.exec(b)||[];a[1]&&(a[1]=a[1].replace(/\s/g,"_"));return{platform:a[1]||
"",tablet:b[1]||""}};b.jPlayer.browser={};b.jPlayer.platform={};var j=b.jPlayer.uaBrowser(navigator.userAgent);j.browser&&(b.jPlayer.browser[j.browser]=!0,b.jPlayer.browser.version=j.version);j=b.jPlayer.uaPlatform(navigator.userAgent);j.platform&&(b.jPlayer.platform[j.platform]=!0,b.jPlayer.platform.mobile=!j.tablet,b.jPlayer.platform.tablet=!!j.tablet);b.jPlayer.getDocMode=function(){var a;b.jPlayer.browser.msie&&(document.documentMode?a=document.documentMode:(a=5,document.compatMode&&"CSS1Compat"===
document.compatMode&&(a=7)));return a};b.jPlayer.browser.documentMode=b.jPlayer.getDocMode();b.jPlayer.nativeFeatures={init:function(){var a=document,b=a.createElement("video"),d={w3c:"fullscreenEnabled fullscreenElement requestFullscreen exitFullscreen fullscreenchange fullscreenerror".split(" "),moz:"mozFullScreenEnabled mozFullScreenElement mozRequestFullScreen mozCancelFullScreen mozfullscreenchange mozfullscreenerror".split(" "),webkit:" webkitCurrentFullScreenElement webkitRequestFullScreen webkitCancelFullScreen webkitfullscreenchange ".split(" "),
webkitVideo:"webkitSupportsFullscreen webkitDisplayingFullscreen webkitEnterFullscreen webkitExitFullscreen  ".split(" ")},e=["w3c","moz","webkit","webkitVideo"],g,h;this.fullscreen=b={support:{w3c:!!a[d.w3c[0]],moz:!!a[d.moz[0]],webkit:"function"===typeof a[d.webkit[3]],webkitVideo:"function"===typeof b[d.webkitVideo[2]]},used:{}};g=0;for(h=e.length;g<h;g++){var f=e[g];if(b.support[f]){b.spec=f;b.used[f]=!0;break}}if(b.spec){var k=d[b.spec];b.api={fullscreenEnabled:!0,fullscreenElement:function(b){b=
b?b:a;return b[k[1]]},requestFullscreen:function(a){return a[k[2]]()},exitFullscreen:function(b){b=b?b:a;return b[k[3]]()}};b.event={fullscreenchange:k[4],fullscreenerror:k[5]}}else b.api={fullscreenEnabled:!1,fullscreenElement:function(){return null},requestFullscreen:function(){},exitFullscreen:function(){}},b.event={}}};b.jPlayer.nativeFeatures.init();b.jPlayer.focus=null;b.jPlayer.keyIgnoreElementNames="INPUT TEXTAREA";var n=function(a){var c=b.jPlayer.focus,d;c&&(b.each(b.jPlayer.keyIgnoreElementNames.split(/\s+/g),
function(b,c){if(a.target.nodeName.toUpperCase()===c.toUpperCase())return d=!0,!1}),d||b.each(c.options.keyBindings,function(d,g){if(g&&a.which===g.key&&b.isFunction(g.fn))return a.preventDefault(),g.fn(c),!1}))};b.jPlayer.keys=function(a){b(document.documentElement).unbind("keydown.jPlayer");a&&b(document.documentElement).bind("keydown.jPlayer",n)};b.jPlayer.keys(!0);b.jPlayer.prototype={count:0,version:{script:"2.3.0",needFlash:"2.3.0",flash:"unknown"},options:{swfPath:"js",solution:"html, flash",
supplied:"mp3",preload:"metadata",volume:0.8,muted:!1,wmode:"opaque",backgroundColor:"#000000",cssSelectorAncestor:"#jp_container_1",cssSelector:{videoPlay:".jp-video-play",play:".jp-play",pause:".jp-pause",stop:".jp-stop",seekBar:".jp-seek-bar",playBar:".jp-play-bar",mute:".jp-mute",unmute:".jp-unmute",volumeBar:".jp-volume-bar",volumeBarValue:".jp-volume-bar-value",volumeMax:".jp-volume-max",currentTime:".jp-current-time",duration:".jp-duration",fullScreen:".jp-full-screen",restoreScreen:".jp-restore-screen",
repeat:".jp-repeat",repeatOff:".jp-repeat-off",gui:".jp-gui",noSolution:".jp-no-solution"},smoothPlayBar:!1,fullScreen:!1,fullWindow:!1,autohide:{restored:!1,full:!0,fadeIn:200,fadeOut:600,hold:1E3},loop:!1,repeat:function(a){a.jPlayer.options.loop?b(this).unbind(".jPlayerRepeat").bind(b.jPlayer.event.ended+".jPlayer.jPlayerRepeat",function(){b(this).jPlayer("play")}):b(this).unbind(".jPlayerRepeat")},nativeVideoControls:{},noFullWindow:{msie:/msie [0-6]\./,ipad:/ipad.*?os [0-4]\./,iphone:/iphone/,
ipod:/ipod/,android_pad:/android [0-3]\.(?!.*?mobile)/,android_phone:/android.*?mobile/,blackberry:/blackberry/,windows_ce:/windows ce/,iemobile:/iemobile/,webos:/webos/},noVolume:{ipad:/ipad/,iphone:/iphone/,ipod:/ipod/,android_pad:/android(?!.*?mobile)/,android_phone:/android.*?mobile/,blackberry:/blackberry/,windows_ce:/windows ce/,iemobile:/iemobile/,webos:/webos/,playbook:/playbook/},timeFormat:{},keyEnabled:!1,audioFullScreen:!1,keyBindings:{play:{key:32,fn:function(a){a.status.paused?a.play():
a.pause()}},fullScreen:{key:13,fn:function(a){(a.status.video||a.options.audioFullScreen)&&a._setOption("fullScreen",!a.options.fullScreen)}},muted:{key:8,fn:function(a){a._muted(!a.options.muted)}},volumeUp:{key:38,fn:function(a){a.volume(a.options.volume+0.1)}},volumeDown:{key:40,fn:function(a){a.volume(a.options.volume-0.1)}}},verticalVolume:!1,idPrefix:"jp",noConflict:"jQuery",emulateHtml:!1,errorAlerts:!1,warningAlerts:!1},optionsAudio:{size:{width:"0px",height:"0px",cssClass:""},sizeFull:{width:"0px",
height:"0px",cssClass:""}},optionsVideo:{size:{width:"480px",height:"270px",cssClass:"jp-video-270p"},sizeFull:{width:"100%",height:"100%",cssClass:"jp-video-full"}},instances:{},status:{src:"",media:{},paused:!0,format:{},formatType:"",waitForPlay:!0,waitForLoad:!0,srcSet:!1,video:!1,seekPercent:0,currentPercentRelative:0,currentPercentAbsolute:0,currentTime:0,duration:0,videoWidth:0,videoHeight:0,readyState:0,networkState:0,playbackRate:1,ended:0},internal:{ready:!1},solution:{html:!0,flash:!0},
format:{mp3:{codec:'audio/mpeg; codecs="mp3"',flashCanPlay:!0,media:"audio"},m4a:{codec:'audio/mp4; codecs="mp4a.40.2"',flashCanPlay:!0,media:"audio"},oga:{codec:'audio/ogg; codecs="vorbis"',flashCanPlay:!1,media:"audio"},wav:{codec:'audio/wav; codecs="1"',flashCanPlay:!1,media:"audio"},webma:{codec:'audio/webm; codecs="vorbis"',flashCanPlay:!1,media:"audio"},fla:{codec:"audio/x-flv",flashCanPlay:!0,media:"audio"},rtmpa:{codec:'audio/rtmp; codecs="rtmp"',flashCanPlay:!0,media:"audio"},m4v:{codec:'video/mp4; codecs="avc1.42E01E, mp4a.40.2"',
flashCanPlay:!0,media:"video"},ogv:{codec:'video/ogg; codecs="theora, vorbis"',flashCanPlay:!1,media:"video"},webmv:{codec:'video/webm; codecs="vorbis, vp8"',flashCanPlay:!1,media:"video"},flv:{codec:"video/x-flv",flashCanPlay:!0,media:"video"},rtmpv:{codec:'video/rtmp; codecs="rtmp"',flashCanPlay:!0,media:"video"}},_init:function(){var a=this;this.element.empty();this.status=b.extend({},this.status);this.internal=b.extend({},this.internal);this.options.timeFormat=b.extend({},b.jPlayer.timeFormat,
this.options.timeFormat);this.internal.cmdsIgnored=b.jPlayer.platform.ipad||b.jPlayer.platform.iphone||b.jPlayer.platform.ipod;this.internal.domNode=this.element.get(0);this.options.keyEnabled&&!b.jPlayer.focus&&(b.jPlayer.focus=this);this.formats=[];this.solutions=[];this.require={};this.htmlElement={};this.html={};this.html.audio={};this.html.video={};this.flash={};this.css={};this.css.cs={};this.css.jq={};this.ancestorJq=[];this.options.volume=this._limitValue(this.options.volume,0,1);b.each(this.options.supplied.toLowerCase().split(","),
function(c,d){var e=d.replace(/^\s+|\s+$/g,"");if(a.format[e]){var f=!1;b.each(a.formats,function(a,b){if(e===b)return f=!0,!1});f||a.formats.push(e)}});b.each(this.options.solution.toLowerCase().split(","),function(c,d){var e=d.replace(/^\s+|\s+$/g,"");if(a.solution[e]){var f=!1;b.each(a.solutions,function(a,b){if(e===b)return f=!0,!1});f||a.solutions.push(e)}});this.internal.instance="jp_"+this.count;this.instances[this.internal.instance]=this.element;this.element.attr("id")||this.element.attr("id",
this.options.idPrefix+"_jplayer_"+this.count);this.internal.self=b.extend({},{id:this.element.attr("id"),jq:this.element});this.internal.audio=b.extend({},{id:this.options.idPrefix+"_audio_"+this.count,jq:f});this.internal.video=b.extend({},{id:this.options.idPrefix+"_video_"+this.count,jq:f});this.internal.flash=b.extend({},{id:this.options.idPrefix+"_flash_"+this.count,jq:f,swf:this.options.swfPath+(".swf"!==this.options.swfPath.toLowerCase().slice(-4)?(this.options.swfPath&&"/"!==this.options.swfPath.slice(-1)?
"/":"")+"Jplayer.swf":"")});this.internal.poster=b.extend({},{id:this.options.idPrefix+"_poster_"+this.count,jq:f});b.each(b.jPlayer.event,function(b,c){a.options[b]!==f&&(a.element.bind(c+".jPlayer",a.options[b]),a.options[b]=f)});this.require.audio=!1;this.require.video=!1;b.each(this.formats,function(b,c){a.require[a.format[c].media]=!0});this.options=this.require.video?b.extend(!0,{},this.optionsVideo,this.options):b.extend(!0,{},this.optionsAudio,this.options);this._setSize();this.status.nativeVideoControls=
this._uaBlocklist(this.options.nativeVideoControls);this.status.noFullWindow=this._uaBlocklist(this.options.noFullWindow);this.status.noVolume=this._uaBlocklist(this.options.noVolume);b.jPlayer.nativeFeatures.fullscreen.api.fullscreenEnabled&&this._fullscreenAddEventListeners();this._restrictNativeVideoControls();this.htmlElement.poster=document.createElement("img");this.htmlElement.poster.id=this.internal.poster.id;this.htmlElement.poster.onload=function(){(!a.status.video||a.status.waitForPlay)&&
a.internal.poster.jq.show()};this.element.append(this.htmlElement.poster);this.internal.poster.jq=b("#"+this.internal.poster.id);this.internal.poster.jq.css({width:this.status.width,height:this.status.height});this.internal.poster.jq.hide();this.internal.poster.jq.bind("click.jPlayer",function(){a._trigger(b.jPlayer.event.click)});this.html.audio.available=!1;this.require.audio&&(this.htmlElement.audio=document.createElement("audio"),this.htmlElement.audio.id=this.internal.audio.id,this.html.audio.available=
!!this.htmlElement.audio.canPlayType&&this._testCanPlayType(this.htmlElement.audio));this.html.video.available=!1;this.require.video&&(this.htmlElement.video=document.createElement("video"),this.htmlElement.video.id=this.internal.video.id,this.html.video.available=!!this.htmlElement.video.canPlayType&&this._testCanPlayType(this.htmlElement.video));this.flash.available=this._checkForFlash(10.1);this.html.canPlay={};this.flash.canPlay={};b.each(this.formats,function(b,c){a.html.canPlay[c]=a.html[a.format[c].media].available&&
""!==a.htmlElement[a.format[c].media].canPlayType(a.format[c].codec);a.flash.canPlay[c]=a.format[c].flashCanPlay&&a.flash.available});this.html.desired=!1;this.flash.desired=!1;b.each(this.solutions,function(c,d){if(0===c)a[d].desired=!0;else{var e=!1,f=!1;b.each(a.formats,function(b,c){a[a.solutions[0]].canPlay[c]&&("video"===a.format[c].media?f=!0:e=!0)});a[d].desired=a.require.audio&&!e||a.require.video&&!f}});this.html.support={};this.flash.support={};b.each(this.formats,function(b,c){a.html.support[c]=
a.html.canPlay[c]&&a.html.desired;a.flash.support[c]=a.flash.canPlay[c]&&a.flash.desired});this.html.used=!1;this.flash.used=!1;b.each(this.solutions,function(c,d){b.each(a.formats,function(b,c){if(a[d].support[c])return a[d].used=!0,!1})});this._resetActive();this._resetGate();this._cssSelectorAncestor(this.options.cssSelectorAncestor);!this.html.used&&!this.flash.used?(this._error({type:b.jPlayer.error.NO_SOLUTION,context:"{solution:'"+this.options.solution+"', supplied:'"+this.options.supplied+
"'}",message:b.jPlayer.errorMsg.NO_SOLUTION,hint:b.jPlayer.errorHint.NO_SOLUTION}),this.css.jq.noSolution.length&&this.css.jq.noSolution.show()):this.css.jq.noSolution.length&&this.css.jq.noSolution.hide();if(this.flash.used){var c,d="jQuery="+encodeURI(this.options.noConflict)+"&id="+encodeURI(this.internal.self.id)+"&vol="+this.options.volume+"&muted="+this.options.muted;if(b.jPlayer.browser.msie&&(9>Number(b.jPlayer.browser.version)||9>b.jPlayer.browser.documentMode)){d=['<param name="movie" value="'+
this.internal.flash.swf+'" />','<param name="FlashVars" value="'+d+'" />','<param name="allowScriptAccess" value="always" />','<param name="bgcolor" value="'+this.options.backgroundColor+'" />','<param name="wmode" value="'+this.options.wmode+'" />'];c=document.createElement('<object id="'+this.internal.flash.id+'" classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" width="0" height="0" tabindex="-1"></object>');for(var e=0;e<d.length;e++)c.appendChild(document.createElement(d[e]))}else e=function(a,
b,c){var d=document.createElement("param");d.setAttribute("name",b);d.setAttribute("value",c);a.appendChild(d)},c=document.createElement("object"),c.setAttribute("id",this.internal.flash.id),c.setAttribute("data",this.internal.flash.swf),c.setAttribute("type","application/x-shockwave-flash"),c.setAttribute("width","1"),c.setAttribute("height","1"),c.setAttribute("tabindex","-1"),e(c,"flashvars",d),e(c,"allowscriptaccess","always"),e(c,"bgcolor",this.options.backgroundColor),e(c,"wmode",this.options.wmode);
this.element.append(c);this.internal.flash.jq=b(c)}this.html.used&&(this.html.audio.available&&(this._addHtmlEventListeners(this.htmlElement.audio,this.html.audio),this.element.append(this.htmlElement.audio),this.internal.audio.jq=b("#"+this.internal.audio.id)),this.html.video.available&&(this._addHtmlEventListeners(this.htmlElement.video,this.html.video),this.element.append(this.htmlElement.video),this.internal.video.jq=b("#"+this.internal.video.id),this.status.nativeVideoControls?this.internal.video.jq.css({width:this.status.width,
height:this.status.height}):this.internal.video.jq.css({width:"0px",height:"0px"}),this.internal.video.jq.bind("click.jPlayer",function(){a._trigger(b.jPlayer.event.click)})));this.options.emulateHtml&&this._emulateHtmlBridge();this.html.used&&!this.flash.used&&setTimeout(function(){a.internal.ready=!0;a.version.flash="n/a";a._trigger(b.jPlayer.event.repeat);a._trigger(b.jPlayer.event.ready)},100);this._updateNativeVideoControls();this._updateInterface();this._updateButtons(!1);this._updateAutohide();
this._updateVolume(this.options.volume);this._updateMute(this.options.muted);this.css.jq.videoPlay.length&&this.css.jq.videoPlay.hide();b.jPlayer.prototype.count++},destroy:function(){this.clearMedia();this._removeUiClass();this.css.jq.currentTime.length&&this.css.jq.currentTime.text("");this.css.jq.duration.length&&this.css.jq.duration.text("");b.each(this.css.jq,function(a,b){b.length&&b.unbind(".jPlayer")});this.internal.poster.jq.unbind(".jPlayer");this.internal.video.jq&&this.internal.video.jq.unbind(".jPlayer");
this._fullscreenRemoveEventListeners();this===b.jPlayer.focus&&(b.jPlayer.focus=null);this.options.emulateHtml&&this._destroyHtmlBridge();this.element.removeData("jPlayer");this.element.unbind(".jPlayer");this.element.empty();delete this.instances[this.internal.instance]},enable:function(){},disable:function(){},_testCanPlayType:function(a){try{return a.canPlayType(this.format.mp3.codec),!0}catch(b){return!1}},_uaBlocklist:function(a){var c=navigator.userAgent.toLowerCase(),d=!1;b.each(a,function(a,
b){if(b&&b.test(c))return d=!0,!1});return d},_restrictNativeVideoControls:function(){this.require.audio&&this.status.nativeVideoControls&&(this.status.nativeVideoControls=!1,this.status.noFullWindow=!0)},_updateNativeVideoControls:function(){this.html.video.available&&this.html.used&&(this.htmlElement.video.controls=this.status.nativeVideoControls,this._updateAutohide(),this.status.nativeVideoControls&&this.require.video?(this.internal.poster.jq.hide(),this.internal.video.jq.css({width:this.status.width,
height:this.status.height})):this.status.waitForPlay&&this.status.video&&(this.internal.poster.jq.show(),this.internal.video.jq.css({width:"0px",height:"0px"})))},_addHtmlEventListeners:function(a,c){var d=this;a.preload=this.options.preload;a.muted=this.options.muted;a.volume=this.options.volume;a.addEventListener("progress",function(){c.gate&&(d.internal.cmdsIgnored&&0<this.readyState&&(d.internal.cmdsIgnored=!1),d._getHtmlStatus(a),d._updateInterface(),d._trigger(b.jPlayer.event.progress))},!1);
a.addEventListener("timeupdate",function(){c.gate&&(d._getHtmlStatus(a),d._updateInterface(),d._trigger(b.jPlayer.event.timeupdate))},!1);a.addEventListener("durationchange",function(){c.gate&&(d._getHtmlStatus(a),d._updateInterface(),d._trigger(b.jPlayer.event.durationchange))},!1);a.addEventListener("play",function(){c.gate&&(d._updateButtons(!0),d._html_checkWaitForPlay(),d._trigger(b.jPlayer.event.play))},!1);a.addEventListener("playing",function(){c.gate&&(d._updateButtons(!0),d._seeked(),d._trigger(b.jPlayer.event.playing))},
!1);a.addEventListener("pause",function(){c.gate&&(d._updateButtons(!1),d._trigger(b.jPlayer.event.pause))},!1);a.addEventListener("waiting",function(){c.gate&&(d._seeking(),d._trigger(b.jPlayer.event.waiting))},!1);a.addEventListener("seeking",function(){c.gate&&(d._seeking(),d._trigger(b.jPlayer.event.seeking))},!1);a.addEventListener("seeked",function(){c.gate&&(d._seeked(),d._trigger(b.jPlayer.event.seeked))},!1);a.addEventListener("volumechange",function(){c.gate&&(d.options.volume=a.volume,
d.options.muted=a.muted,d._updateMute(),d._updateVolume(),d._trigger(b.jPlayer.event.volumechange))},!1);a.addEventListener("suspend",function(){c.gate&&(d._seeked(),d._trigger(b.jPlayer.event.suspend))},!1);a.addEventListener("ended",function(){c.gate&&(b.jPlayer.browser.webkit||(d.htmlElement.media.currentTime=0),d.htmlElement.media.pause(),d._updateButtons(!1),d._getHtmlStatus(a,!0),d._updateInterface(),d._trigger(b.jPlayer.event.ended))},!1);a.addEventListener("error",function(){c.gate&&(d._updateButtons(!1),
d._seeked(),d.status.srcSet&&(clearTimeout(d.internal.htmlDlyCmdId),d.status.waitForLoad=!0,d.status.waitForPlay=!0,d.status.video&&!d.status.nativeVideoControls&&d.internal.video.jq.css({width:"0px",height:"0px"}),d._validString(d.status.media.poster)&&!d.status.nativeVideoControls&&d.internal.poster.jq.show(),d.css.jq.videoPlay.length&&d.css.jq.videoPlay.show(),d._error({type:b.jPlayer.error.URL,context:d.status.src,message:b.jPlayer.errorMsg.URL,hint:b.jPlayer.errorHint.URL})))},!1);b.each(b.jPlayer.htmlEvent,
function(e,g){a.addEventListener(this,function(){c.gate&&d._trigger(b.jPlayer.event[g])},!1)})},_getHtmlStatus:function(a,b){var d=0,e=0,g=0,f=0;isFinite(a.duration)&&(this.status.duration=a.duration);d=a.currentTime;e=0<this.status.duration?100*d/this.status.duration:0;"object"===typeof a.seekable&&0<a.seekable.length?(g=0<this.status.duration?100*a.seekable.end(a.seekable.length-1)/this.status.duration:100,f=0<this.status.duration?100*a.currentTime/a.seekable.end(a.seekable.length-1):0):(g=100,
f=e);b&&(e=f=d=0);this.status.seekPercent=g;this.status.currentPercentRelative=f;this.status.currentPercentAbsolute=e;this.status.currentTime=d;this.status.videoWidth=a.videoWidth;this.status.videoHeight=a.videoHeight;this.status.readyState=a.readyState;this.status.networkState=a.networkState;this.status.playbackRate=a.playbackRate;this.status.ended=a.ended},_resetStatus:function(){this.status=b.extend({},this.status,b.jPlayer.prototype.status)},_trigger:function(a,c,d){a=b.Event(a);a.jPlayer={};
a.jPlayer.version=b.extend({},this.version);a.jPlayer.options=b.extend(!0,{},this.options);a.jPlayer.status=b.extend(!0,{},this.status);a.jPlayer.html=b.extend(!0,{},this.html);a.jPlayer.flash=b.extend(!0,{},this.flash);c&&(a.jPlayer.error=b.extend({},c));d&&(a.jPlayer.warning=b.extend({},d));this.element.trigger(a)},jPlayerFlashEvent:function(a,c){if(a===b.jPlayer.event.ready)if(this.internal.ready){if(this.flash.gate){if(this.status.srcSet){var d=this.status.currentTime,e=this.status.paused;this.setMedia(this.status.media);
0<d&&(e?this.pause(d):this.play(d))}this._trigger(b.jPlayer.event.flashreset)}}else this.internal.ready=!0,this.internal.flash.jq.css({width:"0px",height:"0px"}),this.version.flash=c.version,this.version.needFlash!==this.version.flash&&this._error({type:b.jPlayer.error.VERSION,context:this.version.flash,message:b.jPlayer.errorMsg.VERSION+this.version.flash,hint:b.jPlayer.errorHint.VERSION}),this._trigger(b.jPlayer.event.repeat),this._trigger(a);if(this.flash.gate)switch(a){case b.jPlayer.event.progress:this._getFlashStatus(c);
this._updateInterface();this._trigger(a);break;case b.jPlayer.event.timeupdate:this._getFlashStatus(c);this._updateInterface();this._trigger(a);break;case b.jPlayer.event.play:this._seeked();this._updateButtons(!0);this._trigger(a);break;case b.jPlayer.event.pause:this._updateButtons(!1);this._trigger(a);break;case b.jPlayer.event.ended:this._updateButtons(!1);this._trigger(a);break;case b.jPlayer.event.click:this._trigger(a);break;case b.jPlayer.event.error:this.status.waitForLoad=!0;this.status.waitForPlay=
!0;this.status.video&&this.internal.flash.jq.css({width:"0px",height:"0px"});this._validString(this.status.media.poster)&&this.internal.poster.jq.show();this.css.jq.videoPlay.length&&this.status.video&&this.css.jq.videoPlay.show();this.status.video?this._flash_setVideo(this.status.media):this._flash_setAudio(this.status.media);this._updateButtons(!1);this._error({type:b.jPlayer.error.URL,context:c.src,message:b.jPlayer.errorMsg.URL,hint:b.jPlayer.errorHint.URL});break;case b.jPlayer.event.seeking:this._seeking();
this._trigger(a);break;case b.jPlayer.event.seeked:this._seeked();this._trigger(a);break;case b.jPlayer.event.ready:break;default:this._trigger(a)}return!1},_getFlashStatus:function(a){this.status.seekPercent=a.seekPercent;this.status.currentPercentRelative=a.currentPercentRelative;this.status.currentPercentAbsolute=a.currentPercentAbsolute;this.status.currentTime=a.currentTime;this.status.duration=a.duration;this.status.videoWidth=a.videoWidth;this.status.videoHeight=a.videoHeight;this.status.readyState=
4;this.status.networkState=0;this.status.playbackRate=1;this.status.ended=!1},_updateButtons:function(a){a!==f&&(this.status.paused=!a,this.css.jq.play.length&&this.css.jq.pause.length&&(a?(this.css.jq.play.hide(),this.css.jq.pause.show()):(this.css.jq.play.show(),this.css.jq.pause.hide())));this.css.jq.restoreScreen.length&&this.css.jq.fullScreen.length&&(this.status.noFullWindow?(this.css.jq.fullScreen.hide(),this.css.jq.restoreScreen.hide()):this.options.fullWindow?(this.css.jq.fullScreen.hide(),
this.css.jq.restoreScreen.show()):(this.css.jq.fullScreen.show(),this.css.jq.restoreScreen.hide()));this.css.jq.repeat.length&&this.css.jq.repeatOff.length&&(this.options.loop?(this.css.jq.repeat.hide(),this.css.jq.repeatOff.show()):(this.css.jq.repeat.show(),this.css.jq.repeatOff.hide()))},_updateInterface:function(){this.css.jq.seekBar.length&&this.css.jq.seekBar.width(this.status.seekPercent+"%");this.css.jq.playBar.length&&(this.options.smoothPlayBar?this.css.jq.playBar.stop().animate({width:this.status.currentPercentAbsolute+
"%"},250,"linear"):this.css.jq.playBar.width(this.status.currentPercentRelative+"%"));this.css.jq.currentTime.length&&this.css.jq.currentTime.text(this._convertTime(this.status.currentTime));this.css.jq.duration.length&&this.css.jq.duration.text(this._convertTime(this.status.duration))},_convertTime:l.prototype.time,_seeking:function(){this.css.jq.seekBar.length&&this.css.jq.seekBar.addClass("jp-seeking-bg")},_seeked:function(){this.css.jq.seekBar.length&&this.css.jq.seekBar.removeClass("jp-seeking-bg")},
_resetGate:function(){this.html.audio.gate=!1;this.html.video.gate=!1;this.flash.gate=!1},_resetActive:function(){this.html.active=!1;this.flash.active=!1},setMedia:function(a){var c=this,d=!1,e=this.status.media.poster!==a.poster;this._resetMedia();this._resetGate();this._resetActive();b.each(this.formats,function(e,f){var j="video"===c.format[f].media;b.each(c.solutions,function(b,e){if(c[e].support[f]&&c._validString(a[f])){var g="html"===e;j?(g?(c.html.video.gate=!0,c._html_setVideo(a),c.html.active=
!0):(c.flash.gate=!0,c._flash_setVideo(a),c.flash.active=!0),c.css.jq.videoPlay.length&&c.css.jq.videoPlay.show(),c.status.video=!0):(g?(c.html.audio.gate=!0,c._html_setAudio(a),c.html.active=!0):(c.flash.gate=!0,c._flash_setAudio(a),c.flash.active=!0),c.css.jq.videoPlay.length&&c.css.jq.videoPlay.hide(),c.status.video=!1);d=!0;return!1}});if(d)return!1});if(d){if((!this.status.nativeVideoControls||!this.html.video.gate)&&this._validString(a.poster))e?this.htmlElement.poster.src=a.poster:this.internal.poster.jq.show();
this.status.srcSet=!0;this.status.media=b.extend({},a);this._updateButtons(!1);this._updateInterface()}else this._error({type:b.jPlayer.error.NO_SUPPORT,context:"{supplied:'"+this.options.supplied+"'}",message:b.jPlayer.errorMsg.NO_SUPPORT,hint:b.jPlayer.errorHint.NO_SUPPORT})},_resetMedia:function(){this._resetStatus();this._updateButtons(!1);this._updateInterface();this._seeked();this.internal.poster.jq.hide();clearTimeout(this.internal.htmlDlyCmdId);this.html.active?this._html_resetMedia():this.flash.active&&
this._flash_resetMedia()},clearMedia:function(){this._resetMedia();this.html.active?this._html_clearMedia():this.flash.active&&this._flash_clearMedia();this._resetGate();this._resetActive()},load:function(){this.status.srcSet?this.html.active?this._html_load():this.flash.active&&this._flash_load():this._urlNotSetError("load")},focus:function(){this.options.keyEnabled&&(b.jPlayer.focus=this)},play:function(a){a="number"===typeof a?a:NaN;this.status.srcSet?(this.focus(),this.html.active?this._html_play(a):
this.flash.active&&this._flash_play(a)):this._urlNotSetError("play")},videoPlay:function(){this.play()},pause:function(a){a="number"===typeof a?a:NaN;this.status.srcSet?this.html.active?this._html_pause(a):this.flash.active&&this._flash_pause(a):this._urlNotSetError("pause")},pauseOthers:function(){var a=this;b.each(this.instances,function(b,d){a.element!==d&&d.data("jPlayer").status.srcSet&&d.jPlayer("pause")})},stop:function(){this.status.srcSet?this.html.active?this._html_pause(0):this.flash.active&&
this._flash_pause(0):this._urlNotSetError("stop")},playHead:function(a){a=this._limitValue(a,0,100);this.status.srcSet?this.html.active?this._html_playHead(a):this.flash.active&&this._flash_playHead(a):this._urlNotSetError("playHead")},_muted:function(a){this.options.muted=a;this.html.used&&this._html_mute(a);this.flash.used&&this._flash_mute(a);!this.html.video.gate&&!this.html.audio.gate&&(this._updateMute(a),this._updateVolume(this.options.volume),this._trigger(b.jPlayer.event.volumechange))},
mute:function(a){a=a===f?!0:!!a;this._muted(a)},unmute:function(a){a=a===f?!0:!!a;this._muted(!a)},_updateMute:function(a){a===f&&(a=this.options.muted);this.css.jq.mute.length&&this.css.jq.unmute.length&&(this.status.noVolume?(this.css.jq.mute.hide(),this.css.jq.unmute.hide()):a?(this.css.jq.mute.hide(),this.css.jq.unmute.show()):(this.css.jq.mute.show(),this.css.jq.unmute.hide()))},volume:function(a){a=this._limitValue(a,0,1);this.options.volume=a;this.html.used&&this._html_volume(a);this.flash.used&&
this._flash_volume(a);!this.html.video.gate&&!this.html.audio.gate&&(this._updateVolume(a),this._trigger(b.jPlayer.event.volumechange))},volumeBar:function(a){if(this.css.jq.volumeBar.length){var b=this.css.jq.volumeBar.offset(),d=a.pageX-b.left,e=this.css.jq.volumeBar.width();a=this.css.jq.volumeBar.height()-a.pageY+b.top;b=this.css.jq.volumeBar.height();this.options.verticalVolume?this.volume(a/b):this.volume(d/e)}this.options.muted&&this._muted(!1)},volumeBarValue:function(a){this.volumeBar(a)},
_updateVolume:function(a){a===f&&(a=this.options.volume);a=this.options.muted?0:a;this.status.noVolume?(this.css.jq.volumeBar.length&&this.css.jq.volumeBar.hide(),this.css.jq.volumeBarValue.length&&this.css.jq.volumeBarValue.hide(),this.css.jq.volumeMax.length&&this.css.jq.volumeMax.hide()):(this.css.jq.volumeBar.length&&this.css.jq.volumeBar.show(),this.css.jq.volumeBarValue.length&&(this.css.jq.volumeBarValue.show(),this.css.jq.volumeBarValue[this.options.verticalVolume?"height":"width"](100*a+
"%")),this.css.jq.volumeMax.length&&this.css.jq.volumeMax.show())},volumeMax:function(){this.volume(1);this.options.muted&&this._muted(!1)},_cssSelectorAncestor:function(a){var c=this;this.options.cssSelectorAncestor=a;this._removeUiClass();this.ancestorJq=a?b(a):[];a&&1!==this.ancestorJq.length&&this._warning({type:b.jPlayer.warning.CSS_SELECTOR_COUNT,context:a,message:b.jPlayer.warningMsg.CSS_SELECTOR_COUNT+this.ancestorJq.length+" found for cssSelectorAncestor.",hint:b.jPlayer.warningHint.CSS_SELECTOR_COUNT});
this._addUiClass();b.each(this.options.cssSelector,function(a,b){c._cssSelector(a,b)})},_cssSelector:function(a,c){var d=this;"string"===typeof c?b.jPlayer.prototype.options.cssSelector[a]?(this.css.jq[a]&&this.css.jq[a].length&&this.css.jq[a].unbind(".jPlayer"),this.options.cssSelector[a]=c,this.css.cs[a]=this.options.cssSelectorAncestor+" "+c,this.css.jq[a]=c?b(this.css.cs[a]):[],this.css.jq[a].length&&this.css.jq[a].bind("click.jPlayer",function(c){c.preventDefault();d[a](c);b(this).blur()}),c&&
1!==this.css.jq[a].length&&this._warning({type:b.jPlayer.warning.CSS_SELECTOR_COUNT,context:this.css.cs[a],message:b.jPlayer.warningMsg.CSS_SELECTOR_COUNT+this.css.jq[a].length+" found for "+a+" method.",hint:b.jPlayer.warningHint.CSS_SELECTOR_COUNT})):this._warning({type:b.jPlayer.warning.CSS_SELECTOR_METHOD,context:a,message:b.jPlayer.warningMsg.CSS_SELECTOR_METHOD,hint:b.jPlayer.warningHint.CSS_SELECTOR_METHOD}):this._warning({type:b.jPlayer.warning.CSS_SELECTOR_STRING,context:c,message:b.jPlayer.warningMsg.CSS_SELECTOR_STRING,
hint:b.jPlayer.warningHint.CSS_SELECTOR_STRING})},seekBar:function(a){if(this.css.jq.seekBar){var b=this.css.jq.seekBar.offset();a=a.pageX-b.left;b=this.css.jq.seekBar.width();this.playHead(100*a/b)}},playBar:function(a){this.seekBar(a)},repeat:function(){this._loop(!0)},repeatOff:function(){this._loop(!1)},_loop:function(a){this.options.loop!==a&&(this.options.loop=a,this._updateButtons(),this._trigger(b.jPlayer.event.repeat))},currentTime:function(){},duration:function(){},gui:function(){},noSolution:function(){},
option:function(a,c){var d=a;if(0===arguments.length)return b.extend(!0,{},this.options);if("string"===typeof a){var e=a.split(".");if(c===f){for(var d=b.extend(!0,{},this.options),g=0;g<e.length;g++)if(d[e[g]]!==f)d=d[e[g]];else return this._warning({type:b.jPlayer.warning.OPTION_KEY,context:a,message:b.jPlayer.warningMsg.OPTION_KEY,hint:b.jPlayer.warningHint.OPTION_KEY}),f;return d}for(var g=d={},h=0;h<e.length;h++)h<e.length-1?(g[e[h]]={},g=g[e[h]]):g[e[h]]=c}this._setOptions(d);return this},_setOptions:function(a){var c=
this;b.each(a,function(a,b){c._setOption(a,b)});return this},_setOption:function(a,c){var d=this;switch(a){case "volume":this.volume(c);break;case "muted":this._muted(c);break;case "cssSelectorAncestor":this._cssSelectorAncestor(c);break;case "cssSelector":b.each(c,function(a,b){d._cssSelector(a,b)});break;case "fullScreen":if(this.options[a]!==c){var e=b.jPlayer.nativeFeatures.fullscreen.used.webkitVideo;if(!e||e&&!this.status.waitForPlay)e||(this.options[a]=c),c?this._requestFullscreen():this._exitFullscreen(),
e||this._setOption("fullWindow",c)}break;case "fullWindow":this.options[a]!==c&&(this._removeUiClass(),this.options[a]=c,this._refreshSize());break;case "size":!this.options.fullWindow&&this.options[a].cssClass!==c.cssClass&&this._removeUiClass();this.options[a]=b.extend({},this.options[a],c);this._refreshSize();break;case "sizeFull":this.options.fullWindow&&this.options[a].cssClass!==c.cssClass&&this._removeUiClass();this.options[a]=b.extend({},this.options[a],c);this._refreshSize();break;case "autohide":this.options[a]=
b.extend({},this.options[a],c);this._updateAutohide();break;case "loop":this._loop(c);break;case "nativeVideoControls":this.options[a]=b.extend({},this.options[a],c);this.status.nativeVideoControls=this._uaBlocklist(this.options.nativeVideoControls);this._restrictNativeVideoControls();this._updateNativeVideoControls();break;case "noFullWindow":this.options[a]=b.extend({},this.options[a],c);this.status.nativeVideoControls=this._uaBlocklist(this.options.nativeVideoControls);this.status.noFullWindow=
this._uaBlocklist(this.options.noFullWindow);this._restrictNativeVideoControls();this._updateButtons();break;case "noVolume":this.options[a]=b.extend({},this.options[a],c);this.status.noVolume=this._uaBlocklist(this.options.noVolume);this._updateVolume();this._updateMute();break;case "emulateHtml":this.options[a]!==c&&((this.options[a]=c)?this._emulateHtmlBridge():this._destroyHtmlBridge());break;case "timeFormat":this.options[a]=b.extend({},this.options[a],c);break;case "keyEnabled":this.options[a]=
c;!c&&this===b.jPlayer.focus&&(b.jPlayer.focus=null);break;case "keyBindings":this.options[a]=b.extend(!0,{},this.options[a],c);break;case "audioFullScreen":this.options[a]=c}return this},_refreshSize:function(){this._setSize();this._addUiClass();this._updateSize();this._updateButtons();this._updateAutohide();this._trigger(b.jPlayer.event.resize)},_setSize:function(){this.options.fullWindow?(this.status.width=this.options.sizeFull.width,this.status.height=this.options.sizeFull.height,this.status.cssClass=
this.options.sizeFull.cssClass):(this.status.width=this.options.size.width,this.status.height=this.options.size.height,this.status.cssClass=this.options.size.cssClass);this.element.css({width:this.status.width,height:this.status.height})},_addUiClass:function(){this.ancestorJq.length&&this.ancestorJq.addClass(this.status.cssClass)},_removeUiClass:function(){this.ancestorJq.length&&this.ancestorJq.removeClass(this.status.cssClass)},_updateSize:function(){this.internal.poster.jq.css({width:this.status.width,
height:this.status.height});!this.status.waitForPlay&&this.html.active&&this.status.video||this.html.video.available&&this.html.used&&this.status.nativeVideoControls?this.internal.video.jq.css({width:this.status.width,height:this.status.height}):!this.status.waitForPlay&&(this.flash.active&&this.status.video)&&this.internal.flash.jq.css({width:this.status.width,height:this.status.height})},_updateAutohide:function(){var a=this,b=function(){a.css.jq.gui.fadeIn(a.options.autohide.fadeIn,function(){clearTimeout(a.internal.autohideId);
a.internal.autohideId=setTimeout(function(){a.css.jq.gui.fadeOut(a.options.autohide.fadeOut)},a.options.autohide.hold)})};this.css.jq.gui.length&&(this.css.jq.gui.stop(!0,!0),clearTimeout(this.internal.autohideId),this.element.unbind(".jPlayerAutohide"),this.css.jq.gui.unbind(".jPlayerAutohide"),this.status.nativeVideoControls?this.css.jq.gui.hide():this.options.fullWindow&&this.options.autohide.full||!this.options.fullWindow&&this.options.autohide.restored?(this.element.bind("mousemove.jPlayer.jPlayerAutohide",
b),this.css.jq.gui.bind("mousemove.jPlayer.jPlayerAutohide",b),this.css.jq.gui.hide()):this.css.jq.gui.show())},fullScreen:function(){this._setOption("fullScreen",!0)},restoreScreen:function(){this._setOption("fullScreen",!1)},_fullscreenAddEventListeners:function(){var a=this,c=b.jPlayer.nativeFeatures.fullscreen;c.api.fullscreenEnabled&&c.event.fullscreenchange&&("function"!==typeof this.internal.fullscreenchangeHandler&&(this.internal.fullscreenchangeHandler=function(){a._fullscreenchange()}),
document.addEventListener(c.event.fullscreenchange,this.internal.fullscreenchangeHandler,!1))},_fullscreenRemoveEventListeners:function(){var a=b.jPlayer.nativeFeatures.fullscreen;this.internal.fullscreenchangeHandler&&document.addEventListener(a.event.fullscreenchange,this.internal.fullscreenchangeHandler,!1)},_fullscreenchange:function(){this.options.fullScreen&&!b.jPlayer.nativeFeatures.fullscreen.api.fullscreenElement()&&this._setOption("fullScreen",!1)},_requestFullscreen:function(){var a=this.ancestorJq.length?
this.ancestorJq[0]:this.element[0],c=b.jPlayer.nativeFeatures.fullscreen;c.used.webkitVideo&&(a=this.htmlElement.video);c.api.fullscreenEnabled&&c.api.requestFullscreen(a)},_exitFullscreen:function(){var a=b.jPlayer.nativeFeatures.fullscreen,c;a.used.webkitVideo&&(c=this.htmlElement.video);a.api.fullscreenEnabled&&a.api.exitFullscreen(c)},_html_initMedia:function(a){var c=b(this.htmlElement.media).empty();b.each(a.track||[],function(a,b){var g=document.createElement("track");g.setAttribute("kind",
b.kind?b.kind:"");g.setAttribute("src",b.src?b.src:"");g.setAttribute("srclang",b.srclang?b.srclang:"");g.setAttribute("label",b.label?b.label:"");b.def&&g.setAttribute("default",b.def);c.append(g)});this.htmlElement.media.src=this.status.src;"none"!==this.options.preload&&this._html_load();this._trigger(b.jPlayer.event.timeupdate)},_html_setFormat:function(a){var c=this;b.each(this.formats,function(b,e){if(c.html.support[e]&&a[e])return c.status.src=a[e],c.status.format[e]=!0,c.status.formatType=
e,!1})},_html_setAudio:function(a){this._html_setFormat(a);this.htmlElement.media=this.htmlElement.audio;this._html_initMedia(a)},_html_setVideo:function(a){this._html_setFormat(a);this.status.nativeVideoControls&&(this.htmlElement.video.poster=this._validString(a.poster)?a.poster:"");this.htmlElement.media=this.htmlElement.video;this._html_initMedia(a)},_html_resetMedia:function(){this.htmlElement.media&&(this.htmlElement.media.id===this.internal.video.id&&!this.status.nativeVideoControls&&this.internal.video.jq.css({width:"0px",
height:"0px"}),this.htmlElement.media.pause())},_html_clearMedia:function(){this.htmlElement.media&&(this.htmlElement.media.src="about:blank",this.htmlElement.media.load())},_html_load:function(){this.status.waitForLoad&&(this.status.waitForLoad=!1,this.htmlElement.media.load());clearTimeout(this.internal.htmlDlyCmdId)},_html_play:function(a){var b=this,d=this.htmlElement.media;this._html_load();if(isNaN(a))d.play();else{this.internal.cmdsIgnored&&d.play();try{if(!d.seekable||"object"===typeof d.seekable&&
0<d.seekable.length)d.currentTime=a,d.play();else throw 1;}catch(e){this.internal.htmlDlyCmdId=setTimeout(function(){b.play(a)},250);return}}this._html_checkWaitForPlay()},_html_pause:function(a){var b=this,d=this.htmlElement.media;0<a?this._html_load():clearTimeout(this.internal.htmlDlyCmdId);d.pause();if(!isNaN(a))try{if(!d.seekable||"object"===typeof d.seekable&&0<d.seekable.length)d.currentTime=a;else throw 1;}catch(e){this.internal.htmlDlyCmdId=setTimeout(function(){b.pause(a)},250);return}0<
a&&this._html_checkWaitForPlay()},_html_playHead:function(a){var b=this,d=this.htmlElement.media;this._html_load();try{if("object"===typeof d.seekable&&0<d.seekable.length)d.currentTime=a*d.seekable.end(d.seekable.length-1)/100;else if(0<d.duration&&!isNaN(d.duration))d.currentTime=a*d.duration/100;else throw"e";}catch(e){this.internal.htmlDlyCmdId=setTimeout(function(){b.playHead(a)},250);return}this.status.waitForLoad||this._html_checkWaitForPlay()},_html_checkWaitForPlay:function(){this.status.waitForPlay&&
(this.status.waitForPlay=!1,this.css.jq.videoPlay.length&&this.css.jq.videoPlay.hide(),this.status.video&&(this.internal.poster.jq.hide(),this.internal.video.jq.css({width:this.status.width,height:this.status.height})))},_html_volume:function(a){this.html.audio.available&&(this.htmlElement.audio.volume=a);this.html.video.available&&(this.htmlElement.video.volume=a)},_html_mute:function(a){this.html.audio.available&&(this.htmlElement.audio.muted=a);this.html.video.available&&(this.htmlElement.video.muted=
a)},_flash_setAudio:function(a){var c=this;try{b.each(this.formats,function(b,d){if(c.flash.support[d]&&a[d]){switch(d){case "m4a":case "fla":c._getMovie().fl_setAudio_m4a(a[d]);break;case "mp3":c._getMovie().fl_setAudio_mp3(a[d]);break;case "rtmpa":c._getMovie().fl_setAudio_rtmp(a[d])}c.status.src=a[d];c.status.format[d]=!0;c.status.formatType=d;return!1}}),"auto"===this.options.preload&&(this._flash_load(),this.status.waitForLoad=!1)}catch(d){this._flashError(d)}},_flash_setVideo:function(a){var c=
this;try{b.each(this.formats,function(b,d){if(c.flash.support[d]&&a[d]){switch(d){case "m4v":case "flv":c._getMovie().fl_setVideo_m4v(a[d]);break;case "rtmpv":c._getMovie().fl_setVideo_rtmp(a[d])}c.status.src=a[d];c.status.format[d]=!0;c.status.formatType=d;return!1}}),"auto"===this.options.preload&&(this._flash_load(),this.status.waitForLoad=!1)}catch(d){this._flashError(d)}},_flash_resetMedia:function(){this.internal.flash.jq.css({width:"0px",height:"0px"});this._flash_pause(NaN)},_flash_clearMedia:function(){try{this._getMovie().fl_clearMedia()}catch(a){this._flashError(a)}},
_flash_load:function(){try{this._getMovie().fl_load()}catch(a){this._flashError(a)}this.status.waitForLoad=!1},_flash_play:function(a){try{this._getMovie().fl_play(a)}catch(b){this._flashError(b)}this.status.waitForLoad=!1;this._flash_checkWaitForPlay()},_flash_pause:function(a){try{this._getMovie().fl_pause(a)}catch(b){this._flashError(b)}0<a&&(this.status.waitForLoad=!1,this._flash_checkWaitForPlay())},_flash_playHead:function(a){try{this._getMovie().fl_play_head(a)}catch(b){this._flashError(b)}this.status.waitForLoad||
this._flash_checkWaitForPlay()},_flash_checkWaitForPlay:function(){this.status.waitForPlay&&(this.status.waitForPlay=!1,this.css.jq.videoPlay.length&&this.css.jq.videoPlay.hide(),this.status.video&&(this.internal.poster.jq.hide(),this.internal.flash.jq.css({width:this.status.width,height:this.status.height})))},_flash_volume:function(a){try{this._getMovie().fl_volume(a)}catch(b){this._flashError(b)}},_flash_mute:function(a){try{this._getMovie().fl_mute(a)}catch(b){this._flashError(b)}},_getMovie:function(){return document[this.internal.flash.id]},
_getFlashPluginVersion:function(){var a=0,b;if(window.ActiveXObject)try{if(b=new ActiveXObject("ShockwaveFlash.ShockwaveFlash")){var d=b.GetVariable("$version");d&&(d=d.split(" ")[1].split(","),a=parseInt(d[0],10)+"."+parseInt(d[1],10))}}catch(e){}else navigator.plugins&&0<navigator.mimeTypes.length&&(b=navigator.plugins["Shockwave Flash"])&&(a=navigator.plugins["Shockwave Flash"].description.replace(/.*\s(\d+\.\d+).*/,"$1"));return 1*a},_checkForFlash:function(a){var b=!1;this._getFlashPluginVersion()>=
a&&(b=!0);return b},_validString:function(a){return a&&"string"===typeof a},_limitValue:function(a,b,d){return a<b?b:a>d?d:a},_urlNotSetError:function(a){this._error({type:b.jPlayer.error.URL_NOT_SET,context:a,message:b.jPlayer.errorMsg.URL_NOT_SET,hint:b.jPlayer.errorHint.URL_NOT_SET})},_flashError:function(a){var c;c=this.internal.ready?"FLASH_DISABLED":"FLASH";this._error({type:b.jPlayer.error[c],context:this.internal.flash.swf,message:b.jPlayer.errorMsg[c]+a.message,hint:b.jPlayer.errorHint[c]});
this.internal.flash.jq.css({width:"1px",height:"1px"})},_error:function(a){this._trigger(b.jPlayer.event.error,a);this.options.errorAlerts&&this._alert("Error!"+(a.message?"\n\n"+a.message:"")+(a.hint?"\n\n"+a.hint:"")+"\n\nContext: "+a.context)},_warning:function(a){this._trigger(b.jPlayer.event.warning,f,a);this.options.warningAlerts&&this._alert("Warning!"+(a.message?"\n\n"+a.message:"")+(a.hint?"\n\n"+a.hint:"")+"\n\nContext: "+a.context)},_alert:function(a){alert("jPlayer "+this.version.script+
" : id='"+this.internal.self.id+"' : "+a)},_emulateHtmlBridge:function(){var a=this;b.each(b.jPlayer.emulateMethods.split(/\s+/g),function(b,d){a.internal.domNode[d]=function(b){a[d](b)}});b.each(b.jPlayer.event,function(c,d){var e=!0;b.each(b.jPlayer.reservedEvent.split(/\s+/g),function(a,b){if(b===c)return e=!1});e&&a.element.bind(d+".jPlayer.jPlayerHtml",function(){a._emulateHtmlUpdate();var b=document.createEvent("Event");b.initEvent(c,!1,!0);a.internal.domNode.dispatchEvent(b)})})},_emulateHtmlUpdate:function(){var a=
this;b.each(b.jPlayer.emulateStatus.split(/\s+/g),function(b,d){a.internal.domNode[d]=a.status[d]});b.each(b.jPlayer.emulateOptions.split(/\s+/g),function(b,d){a.internal.domNode[d]=a.options[d]})},_destroyHtmlBridge:function(){var a=this;this.element.unbind(".jPlayerHtml");b.each((b.jPlayer.emulateMethods+" "+b.jPlayer.emulateStatus+" "+b.jPlayer.emulateOptions).split(/\s+/g),function(b,d){delete a.internal.domNode[d]})}};b.jPlayer.error={FLASH:"e_flash",FLASH_DISABLED:"e_flash_disabled",NO_SOLUTION:"e_no_solution",
NO_SUPPORT:"e_no_support",URL:"e_url",URL_NOT_SET:"e_url_not_set",VERSION:"e_version"};b.jPlayer.errorMsg={FLASH:"jPlayer's Flash fallback is not configured correctly, or a command was issued before the jPlayer Ready event. Details: ",FLASH_DISABLED:"jPlayer's Flash fallback has been disabled by the browser due to the CSS rules you have used. Details: ",NO_SOLUTION:"No solution can be found by jPlayer in this browser. Neither HTML nor Flash can be used.",NO_SUPPORT:"It is not possible to play any media format provided in setMedia() on this browser using your current options.",
URL:"Media URL could not be loaded.",URL_NOT_SET:"Attempt to issue media playback commands, while no media url is set.",VERSION:"jPlayer "+b.jPlayer.prototype.version.script+" needs Jplayer.swf version "+b.jPlayer.prototype.version.needFlash+" but found "};b.jPlayer.errorHint={FLASH:"Check your swfPath option and that Jplayer.swf is there.",FLASH_DISABLED:"Check that you have not display:none; the jPlayer entity or any ancestor.",NO_SOLUTION:"Review the jPlayer options: support and supplied.",NO_SUPPORT:"Video or audio formats defined in the supplied option are missing.",
URL:"Check media URL is valid.",URL_NOT_SET:"Use setMedia() to set the media URL.",VERSION:"Update jPlayer files."};b.jPlayer.warning={CSS_SELECTOR_COUNT:"e_css_selector_count",CSS_SELECTOR_METHOD:"e_css_selector_method",CSS_SELECTOR_STRING:"e_css_selector_string",OPTION_KEY:"e_option_key"};b.jPlayer.warningMsg={CSS_SELECTOR_COUNT:"The number of css selectors found did not equal one: ",CSS_SELECTOR_METHOD:"The methodName given in jPlayer('cssSelector') is not a valid jPlayer method.",CSS_SELECTOR_STRING:"The methodCssSelector given in jPlayer('cssSelector') is not a String or is empty.",
OPTION_KEY:"The option requested in jPlayer('option') is undefined."};b.jPlayer.warningHint={CSS_SELECTOR_COUNT:"Check your css selector and the ancestor.",CSS_SELECTOR_METHOD:"Check your method name.",CSS_SELECTOR_STRING:"Check your css selector is a string.",OPTION_KEY:"Check your option name."}});
