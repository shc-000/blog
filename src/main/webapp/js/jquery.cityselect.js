/*
Ajax 三级省市联动
bound0@veryhman.com 改良版
日期：2016-7-10

settings 参数说明
-----
url:省市数据josn文件路径
prov:默认省份
city:默认城市
dist:默认地区（县）
nodata:无数据状态
required:必选项
------------------------------ */
(function($){
	$.fn.citySelect=function(settings){
		if(this.length<1){return;};

		// 默认值
		settings=$.extend({
			url:"/js/city.min.js",
			prov:null,
			city:null,
			dist:null,
			nodata:null,
			required:false
		},settings);

		var box_obj=this;
		var prov_obj=box_obj.find(".prov");
		var city_obj=box_obj.find(".city");
		var dist_obj=box_obj.find(".dist");
		var prov_val=settings.prov;
		var city_val=settings.city;
		var dist_val=settings.dist;
		var select_prehtml=(settings.required) ? "" : "<option value=''>请选择</option>";
		var city_json;
var newprov=true;
var newcity=true;
		// 赋值市级函数
		var cityStart=function(){
			var prov_id=prov_obj.get(0).selectedIndex;
			if(!settings.required){
				prov_id--;
			};
			city_obj.empty().attr("disabled",true);
			dist_obj.empty().attr("disabled",true);

			if(prov_id<0||typeof(city_json.citylist[prov_id].c)=="undefined"){
				if(settings.nodata=="none"){
					city_obj.css("display","none");
					dist_obj.css("display","none");
				}else if(settings.nodata=="hidden"){
					city_obj.css("visibility","hidden");
					dist_obj.css("visibility","hidden");
				};
				return;
			};
			
			// 遍历赋值市级下拉列表
			temp_html=select_prehtml;
			if(newprov==false && newcity && settings.city!=null){
				$.each(city_json.citylist[prov_id].c,function(i,city){
				if(settings.city==city.n)newcity=false;
				});
				if(newcity){city_json.citylist[prov_id].c.push({"n": settings.city});newcity=false}
			}
			$.each(city_json.citylist[prov_id].c,function(i,city){
				temp_html+="<option value='"+city.n+"'>"+city.n+"</option>";
			});
			city_obj.html(temp_html).attr("disabled",false).css({"display":"","visibility":""});
			distStart();
		};

		// 赋值地区（县）函数
		var distStart=function(){
			var prov_id=prov_obj.get(0).selectedIndex;
			var city_id=city_obj.get(0).selectedIndex;
			if(!settings.required){
				prov_id--;
				city_id--;
			};
			dist_obj.empty().attr("disabled",true);

			if(prov_id<0||city_id<0||typeof(city_json.citylist[prov_id].c[city_id].a)=="undefined"){
				if(settings.nodata=="none"){
					dist_obj.css("display","none");
				}else if(settings.nodata=="hidden"){
					dist_obj.css("visibility","hidden");
				};
				return;
			};
			
			// 遍历赋值市级下拉列表
			temp_html=select_prehtml;
			$.each(city_json.citylist[prov_id].c[city_id].a,function(i,dist){
				temp_html+="<option value='"+dist.s+"'>"+dist.s+"</option>";
			});
			dist_obj.html(temp_html).attr("disabled",false).css({"display":"","visibility":""});
		};

		var init=function(){
			// 遍历赋值省份下拉列表
			temp_html=select_prehtml;
			if(settings.prov!=null && settings.prov!=""){
var provcall = ["维吾尔自治区", "省", "市", "自治区", "特别行政区"];
var citycall = ["市", "土家族苗族自治州", "林区", "藏族羌族自治州", "朝鲜族自治州", "地区", "盟", "土家族苗族自治州", "布依族苗族自治州",
	"苗族侗族自治州", "傣族景颇族自治州", "傈僳族自治州", "白族自治州", "哈尼族彝族自治州", "壮族苗族自治州", "傣族自治州",
	"回族自治州", "蒙古族藏族自治州", "柯尔克孜自治州", "蒙古自治州", "哈萨克自治州", "藏族自治州", "彝族自治州"];
var provCallLen = provcall.length;
var cityCallLen = citycall.length;
var address;
var addressLen;
for (var p = 0; p < provCallLen; ++p) {
	address = provcall[p];
	addressLen = settings.prov.length - address.length;
	if (addressLen > 0 && settings.prov.lastIndexOf(address) == addressLen) settings.prov = settings.prov.substr(0, addressLen);
}
for (p = 0; p < cityCallLen; ++p) {
	address = citycall[p];
	addressLen = settings.city.length - address.length;
	if (addressLen > 0 && settings.city.lastIndexOf(address) == addressLen) settings.city = settings.city.substr(0, addressLen);
}

				$.each(city_json.citylist,function(i,prov){
				if(prov.p==settings.prov)newprov=false;
				});
				if(newprov)city_json.citylist.push({"p": settings.prov,"c": [{"n": settings.city}]});
			}
			$.each(city_json.citylist,function(i,prov){
				temp_html+="<option value='"+prov.p+"'>"+prov.p+"</option>";
			});
			prov_obj.html(temp_html);

			// 若有传入省份与市级的值，则选中。（setTimeout为兼容IE6而设置）
			setTimeout(function(){
				if(settings.prov!=null){
					prov_obj.val(settings.prov);
					cityStart();
					setTimeout(function(){
						if(settings.city!=null){
							city_obj.val(settings.city);
							distStart();
							setTimeout(function(){
								if(settings.dist!=null){
									dist_obj.val(settings.dist);
								};
							},1);
						};
					},1);
				};
			},1);

			// 选择省份时发生事件
			prov_obj.bind("change",function(){
				cityStart();
			});

			// 选择市级时发生事件
			city_obj.bind("change",function(){
				distStart();
			});
		};

		// 设置省市json数据
		if(typeof(settings.url)=="string"){
			$.getJSON(settings.url,function(json){
				city_json=json;
				init();
			});
		}else{
			city_json=settings.url;
			init();
		};
	};
})(jQuery);