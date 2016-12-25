/**
 * 
 */
function verifyNumber(a){
		//验证填写年龄与用户的生日之间的关系是否合法
		//alert("开始生日校验");
		var select_id = "#" + a;
		var birthday1 = $('#hdcusbirth').val();
		var birthyear = new Date(birthday1).getFullYear();
		//alert(birthyear);
		var myDate = new Date();
        var yearnow = myDate.getFullYear();
        var k = parseInt(yearnow) - parseInt(birthyear);
        var classname = $(select_id).attr('class');
        //alert(k);
        if(a == "smokeage"){//开始吸烟年龄
        	if(parseInt($(select_id).val())<7){
        	//alert("开始吸烟年龄不科学");
        		$("#hint3").html("开始吸烟年龄不得小于7岁");
        		$("#hint3").show();
        		$(select_id).val("");
        	}
        	else if(parseInt($(select_id).val())>k){
        		$("#hint3").html("开始吸烟年龄不得大于该患者的年龄("+k+")");
        		$("#hint3").show();
        		$(select_id).val("");
        	}
        	else if(parseInt($(select_id).val())>parseInt($("#nosmokeage").val())){
    			$("#hint4").html("开始戒烟年龄不得小于开始吸烟年龄");
            	$("#hint4").show();
            	$("#hint3").hide();
            	$("#nosmokeage").val("");
                //return false;  
    		}
        	else{
        		$("#hint3").hide();
        		$("#hint4").hide();
        	}
        }
        if(a == "nosmokeage"){//开始戒烟年龄
        	if(parseInt($(select_id).val())<7){
        	//alert("开始吸烟年龄不科学");
        		$("#hint4").html("开始戒烟年龄不得小于7岁");
        		$("#hint4").show();
        		$(select_id).val("");
        	}
        	else if(parseInt($(select_id).val())>k){
        		$("#hint4").html("开始戒烟年龄不得大于该患者的年龄("+k+")");
        		$("#hint4").show();
        		$(select_id).val("");
        	}
        	else{
        		$("#hint4").hide();
        	}
        }
        /*if(a == "grainsnum"){
        	var hintlabel =select_id+"hint";
        	var r = /^\d|1\d|20$/;
        	if(r.test($(select_id).val())){
        		if($("#inline-grainsrecurrence2").prop("checked") == true && parseInt($(select_id).val()) <= 200/parseInt($("#grainstimes").val())){
        			$(hintlabel).hide();
        		}
        		else if($("#inline-grainsrecurrence2").prop("checked") == true && !(parseInt($(select_id).val()) <= 200/parseInt($("#grainstimes").val()))){
        			$(hintlabel).html("每日摄入上限200两,请检验输入数据");
        			$(hintlabel).show();
        		}
        	}
        }*/
        /*if(classname.indexOf("timestext")!=-1){
        	var hintlabel =select_id+"hint";
        	var r = /^[1-6]$/;
        	if(!r.test($(select_id).val())){  
            	$(hintlabel).html("每日餐次：1-6");
            	$(hintlabel).show();
            	$(select_id).val("1");
            	flag = false;  
            }else{
            	$(hintlabel).hide();
            }
        	if($(select_id).val() == ""){
        		$(hintlabel).hide();
        	}
     　　	}*/
        /*if($(select_id).attr('class').indexOf("timestext")>=0){
        	var s = $(select_id).attr('class');
        	alert(s);
        }*/
        /*else{
        	var hintlabel =select_id+"hint";
        	var r = /^\d{0,4}$/;
        	if(!r.test($(select_id).val())){  
            	$(hintlabel).html("请输入4位以内正整数");
            	$(hintlabel).show();
            	flag = false;  
            }else{
            	$(hintlabel).hide();
            }
        	if($(select_id).val() == ""){
        		$(hintlabel).hide();
        	}
        }*/
        //if($("#nosmokeage").val()>k){alert("戒烟年龄不科学");}
	//	var birthday = new Date(birthday1);
	//	var myDate= new Date(Date.parse(birthday1.replace(/-/g, "/"))).getFullYear(); 
}
	//一天的24时分钟校验
function verifyHourMinute(a,b){
	//a\b是时和分,c\d是a\b对应的提示label
	var s_hour =   "#" + a;
	var s_minute = "#" + b;
	
	var s_labela = s_hour+"hint";
	var s_labelb = s_minute+"hint";
	
	var v_hour = /^(\d|1\d|2[0-4])$/;
	var v_minute = /^(\d|[1-5]\d)$/;
	var flag = true;
	
	if(!v_hour.test($(s_hour).val())){  
    	$(s_labela).html("小时输入非法");
    	$(s_labela).show();
    	$(s_hour).val("0");
    	flag = false;  
    }else{
    	$(s_labela).hide();
    }
	if($(s_hour).val()=="") {
		$(s_labela).hide();
	}
	if(!v_minute.test($(s_minute).val())){  
    	$(s_labelb).html("分钟输入非法");
    	$(s_labelb).show();
    	$(s_minute).val("0");
    	flag = false;  
    }else{
    	$(s_labelb).hide();
    }
	if($(s_minute).val()=="") {
		$(s_labelb).hide();
	}
	if($(s_hour).val() == "24" && $(s_minute).val() != "0"){
		$(s_minute).val("0");
		$(s_labelb).hide();
	}
	if(flag == false) return flag;
	$(s_labela).hide();
	$(s_labelb).hide();
	
}

;function verifyWeekdays(a){
	
	var s_days =   "#" + a;
	var s_labela = s_days+"hint";
	
	var v_days = /^[0-7]{0,1}$/;
	var flag = true;
	if(!v_days.test($(s_days).val())){  
    	$(s_labela).html("天数输入非法(0-7)");
    	$(s_labela).show();
    	$(s_days).val("0");
    	flag = false;  
    }else{
    	$(s_labela).hide();
    }
}

//提交问卷校验
function verifySubmitData(){
	var flag = true;
	var msg = "";
	//身高
	var r = /^((1\d{2})(\.\d)?|(2[01]\d)(\.\d)?|220(\.0)?)$/; 
	if(!r.test($("#height").val())){
		flag = false;
		msg +="身高,";
		$("#height").val("");
		//alert("身高数据异常，请修改");
	}
	//体重
	r = /^(([3-9]\d)(\.\d{1,2})?|(1\d{2})(\.\d{1,2})?|(2[01]\d)(\.\d{1,2})?|(22[0-2])(\.\d{1,2})?|223(\.0{1,2})?)$/; 
	if(!r.test($("#weight").val())){
		flag = false;
		msg +="体重,";
		$("#weight").val("");
		//alert("体重数据异常，请修改");
	}
	//腰围
	r = /^(([4-9]\d)(\.\d)?|(1[0-4]\d)(\.\d)?|150(\.0)?)$/;
	if(!r.test($("#waistline").val())){
		flag = false;
		msg +="腰围,";
		$("#waistline").val("");
		//alert("腰围数据异常，请修改");
	}
	//收缩压
	r = /^(5[5-9]|[6-9]\d|1\d{2}|2[0-7]\d|280)$/; 
	if(!r.test($("#systolicbp").val())){
		flag = false;
		msg +="收缩压,";
		$("#systolicbp").val("");
		//alert("收缩压数据异常，请修改");
	}
	//舒张压
	r = /^([4-9]\d|1\d{2}|2[01]\d|220)$/;
	if(!r.test($("#diastolicbp").val())){
		flag = false;
		msg +="舒张压,";
		$("#diastolicbp").val("");
		//alert("舒张压数据异常，请修改");
	}
	//总胆固醇
	r = /^(0\.[89]\d?|[1-9](\.\d{1,2})?|1[0-4](\.\d{1,2})?|15(\.0{1,2})?)$/;
	if(!r.test($("#tc").val())){
		flag = false;
		msg +="总胆固醇,";
		$("#tc").val("");
		//alert("总胆固醇数据异常，请修改");
	}
	//高密度脂蛋白
	r = /^(0\.[1-9]\d?|[1-9](\.\d{1,2})?|10(\.0{1,2})?)$/;
	if(!r.test($("#hdl").val())){
		flag = false;
		msg +="高密度脂蛋白,";
		$("#hdl").val("");
		//alert("高密度脂蛋白数据异常，请修改");
	}
	//低密度脂蛋白
	r = /^(0\.[5-9]\d?|[1-9](\.\d{1,2})?|10(\.0{1,2})?)$/;
	if(!r.test($("#ldl").val())){
		flag = false;
		msg +="低密度脂蛋白,";
		$("#ldl").val("");
		//alert("低密度脂蛋白数据异常，请修改");
	}
	//甘油三酯
	r = /^(0\.[1-9]\d?|[1-9](\.\d{1,2})?|10(\.0{1,2})?)$/;
	if(!r.test($("#tg").val())){
		flag = false;
		msg +="甘油三酯,";
		$("#tg").val("");
		//alert("甘油三酯数据异常，请修改");
	}
	//空腹血糖
	r =	/^([1-9](\.\d)?|[1-4]\d(\.\d)?|50(\.0)?)$/;
	if(!r.test($("#fpg").val())){
		flag = false;
		msg +="空腹血糖,";
		$("#fpg").val("");
		//alert("空腹血糖数据异常，请修改");
	}
	msg = msg.substring(0, msg.length-1);
	msg +="数据异常，请修改后提交";
	if(flag == false)
		alert(msg);
	return flag;
}

function verifyMealcord2(a){
	var select_id = "#"+a;
	var hint = select_id+"hint";
	if(a == "soyasalt"){
		var r = /^(([0123456789]|[123456789]\d)|100)$/;
		if(!r.test($(select_id).val())){
			$(hint).html("数值范围：0-100的整数");
			$(hint).show();
			$(select_id).val("");
		}
		else{
			$(hint).hide();
		}
	}
	else if(a == "soyaoil"){
		var r = /^(([0123456789]|[123456789]\d|[123456789]\d\d)|1000)$/;
		if(!r.test($(select_id).val())){
			$(hint).html("数值范围：0-1000的整数");
			$(hint).show();
			$(select_id).val("");
		}
		else{
			$(hint).hide();
		}
	}
	else if(a == "water"){
		var r = /^(([0123456789]|[123456789]\d|[123456789]\d\d|[123456789]\d\d\d)|10000)$/;
		if(!r.test($(select_id).val())){
			$(hint).html("数值范围：0-10000的整数");
			$(hint).show();
			$(select_id).val("");
		}
		else{
			$(hint).hide();
		}
	}
	else if(a == "redwinenum" || a == "ricewinenum"){
		var r = /^(\d|[1-7]\d|80)$/;
		if(!r.test($(select_id).val())){
			$(hint).html("数值范围：0-80的整数");
			$(hint).show();
			$(select_id).val("");
		}
		else{
			$(hint).hide();
		}
	}
	else if(a == "beernum"){
		var r = /^(\d|[1-9]\d|1[01]\d|120)$/;
		if(!r.test($(select_id).val())){
			$(hint).html("数值范围：0-120的整数");
			$(hint).show();
			$(select_id).val("");
		}
		else{
			$(hint).hide();
		}
	}
	else if(a == "spiritlnum" || a == "spirithnum"){
		var r = /^(\d|[1-4]\d|50)$/;
		if(!r.test($(select_id).val())){
			$(hint).html("数值范围：0-50的整数");
			$(hint).show();
			$(select_id).val("");
		}
		else{
			$(hint).hide();
		}
	}
	
}

function verifyMealcord(a,b,c){
	var inline = "#"+a;
	var times = "#"+b;
	var num = "#"+c;
	var b_hintlabel =times+"hint";
	var c_hintlabel =num+"hint";
	var flag = true;
	
	if($(inline).val() == "1"){
		$(times).val("");
		$(times).attr('disabled',true);
		$(num).val("");
		$(num).attr('disabled',true);
		$(b_hintlabel).hide();
		$(c_hintlabel).hide();
	}
	else if($(inline).val() == "2"){
		//每天的膳食逻辑
		$(times).attr('disabled',false);
		$(num).attr('disabled',false);
		
    	var r = /^[1-6]$/;
    	if(!r.test($(times).val())){  
        	$(b_hintlabel).html("每日餐次：1-6");
        	$(b_hintlabel).show();
        	$(times).val("");
        	flag = false;  
    	}else{
    		$(b_hintlabel).hide();
    	}
    	
    	if(c=="grainsnum" || c=="ricenum"){
    		r=/^(\d|1\d|20)$/;
    	}
    	else if(c=="meatnum" || c=="fishnum" || c=="vegetablesnum" || c=="fruitnum" || c=="milknum" || c=="soymilknum"){
    		r=/^(\d|10)$/;
    	}
    	else if(c=="eggnum"){
    		r =/^[0-8]$/;
    	}
    	else if(c=="beannum"){
    		r =/^[0-4]$/;
    	}
    	if(!r.test($(num).val())){  
    		if(c=="grainsnum" || c=="ricenum"){
    			$(c_hintlabel).html("每次范围：1-20两");
            	$(c_hintlabel).show();
    		}
    		else if(c=="meatnum" || c=="fishnum" || c=="vegetablesnum" || c=="fruitnum" || c=="milknum" || c=="soymilknum"){
    			$(c_hintlabel).html("每次范围：1-10两");
            	$(c_hintlabel).show();
        	}
        	else if(c=="eggnum"){
    			$(c_hintlabel).html("每次范围：1-8两");
            	$(c_hintlabel).show();
        	}
        	else if(c=="beannum"){
        		$(c_hintlabel).html("每次范围：1-4两");
            	$(c_hintlabel).show();
        	}
        	//$(c_hintlabel).html("每次范围：");
        	//$(c_hintlabel).show();
        	$(num).val("");
        	flag = false;
    	}else{
    		$(c_hintlabel).hide();
    	}
    	
    	if(flag == true){
    		if(c=="grainsnum" || c=="ricenum"){
    			if(parseInt($(times).val())*parseInt($(num).val())<=100){
            		$(c_hintlabel).hide();
            		$(b_hintlabel).hide();
            	}
    			else{
    				$(c_hintlabel).html("每天摄入量不得超过最大值100两");
    				$(c_hintlabel).show();
    				$(b_hintlabel).hide();
    				$(num).val("");
    				$(times).val("");
    			}
    		}
    		else if(c=="meatnum" || c=="fishnum" || c=="vegetablesnum" || c=="fruitnum" || c=="milknum" || c=="soymilknum"){
    			if(parseInt($(times).val())*parseInt($(num).val())<=50){
            		$(c_hintlabel).hide();
            		$(b_hintlabel).hide();
            	}
    			else{
    				$(c_hintlabel).html("每天摄入量不得超过最大值50两");
    				$(c_hintlabel).show();
    				$(b_hintlabel).hide();
    				$(num).val("");
    				$(times).val("");
    			}
        	}
        	else if(c=="eggnum"){
    			if(parseInt($(times).val())*parseInt($(num).val())<=40){
            		$(c_hintlabel).hide();
            		$(b_hintlabel).hide();
            	}
    			else{
    				$(c_hintlabel).html("每天摄入量不得超过最大值40两");
    				$(c_hintlabel).show();
    				$(b_hintlabel).hide();
    				$(num).val("");
    				$(times).val("");
    			}
        	}
        	else if(c=="beannum"){
        		if(parseInt($(times).val())*parseInt($(num).val())<=20){
            		$(c_hintlabel).hide();
            		$(b_hintlabel).hide();
            	}
    			else{
    				$(c_hintlabel).html("每天摄入量不得超过最大值20两");
    				$(c_hintlabel).show();
    				$(b_hintlabel).hide();
    				$(num).val("");
    				$(times).val("");
    			}
        	}
    	}
    	/*else{
        	if(parseInt($(times).val())*parseInt($(num).val())<=200){
        		$(hintlabel).hide();
        	}
        }*/
	}
	else if($(inline).val() == "3"){
		//每周膳食逻辑
		$(times).attr('disabled',false);
		$(num).attr('disabled',false);
		
    	var r = /^([1-9]|[1-2]\d|3[0-5])$/;
    	if(!r.test($(times).val())){  
        	$(b_hintlabel).html("每周餐次：1-35");
        	$(b_hintlabel).show();
        	$(times).val("");
        	flag = false;  
    	}else{
    		$(b_hintlabel).hide();
    	}
    	
    	if(c=="grainsnum" || c=="ricenum"){
    		r=/^(\d|1\d|20)$/;
    	}
    	else if(c=="meatnum" || c=="fishnum" || c=="vegetablesnum" || c=="fruitnum" || c=="milknum" || c=="soymilknum"){
    		r=/^(\d|10)$/;
    	}
    	else if(c=="eggnum"){
    		r =/^[0-8]$/;
    	}
    	else if(c=="beannum"){
    		r =/^[0-4]$/;
    	}
    	if(!r.test($(num).val())){  
    		if(c=="grainsnum" || c=="ricenum"){
    			$(c_hintlabel).html("每次范围：1-20两");
            	$(c_hintlabel).show();
    		}
    		else if(c=="meatnum" || c=="fishnum" || c=="vegetablesnum" || c=="fruitnum" || c=="milknum" || c=="soymilknum"){
    			$(c_hintlabel).html("每次范围：1-10两");
            	$(c_hintlabel).show();
        	}
        	else if(c=="eggnum"){
    			$(c_hintlabel).html("每次范围：1-8两");
            	$(c_hintlabel).show();
        	}
        	else if(c=="beannum"){
        		$(c_hintlabel).html("每次范围：1-4两");
            	$(c_hintlabel).show();
        	}
        	//$(c_hintlabel).html("每次范围：");
        	//$(c_hintlabel).show();
        	$(num).val("");
        	flag = false;
    	}else{
    		$(c_hintlabel).hide();
    	}
    	
    	if(flag == true){
    		if(c=="grainsnum" || c=="ricenum"){
    			if(parseInt($(times).val())*parseInt($(num).val())<=700){
            		$(c_hintlabel).hide();
            		$(b_hintlabel).hide();
            	}
    			else{
    				$(c_hintlabel).html("每周摄入量不得超过最大值700两");
    				$(c_hintlabel).show();
    				$(b_hintlabel).hide();
    				$(num).val("");
    				$(times).val("");
    			}
    		}
    		else if(c=="meatnum" || c=="fishnum" || c=="vegetablesnum" || c=="fruitnum" || c=="milknum" || c=="soymilknum"){
    			if(parseInt($(times).val())*parseInt($(num).val())<=350){
            		$(c_hintlabel).hide();
            		$(b_hintlabel).hide();
            	}
    			else{
    				$(c_hintlabel).html("每周摄入量不得超过最大值350两");
    				$(c_hintlabel).show();
    				$(b_hintlabel).hide();
    				$(num).val("");
    				$(times).val("");
    			}
        	}
        	else if(c=="eggnum"){
    			if(parseInt($(times).val())*parseInt($(num).val())<=280){
            		$(c_hintlabel).hide();
            		$(b_hintlabel).hide();
            	}
    			else{
    				$(c_hintlabel).html("每周摄入量不得超过最大值280两");
    				$(c_hintlabel).show();
    				$(b_hintlabel).hide();
    				$(num).val("");
    				$(times).val("");
    			}
        	}
        	else if(c=="beannum"){
        		if(parseInt($(times).val())*parseInt($(num).val())<=140){
            		$(c_hintlabel).hide();
            		$(b_hintlabel).hide();
            	}
    			else{
    				$(c_hintlabel).html("每周摄入量不得超过最大值140两");
    				$(c_hintlabel).show();
    				$(b_hintlabel).hide();
    				$(num).val("");
    				$(times).val("");
    			}
        	}
    	}
	}
}

;$(function(){
	verifyHourMinute(1,2);
	/*$("#inline-nowcurerecord1").attr('checked',true);
	
	$('#inline-nowcurerecord2').attr('disabled',true);
	$('#inline-nowcurerecord3').attr('disabled',true);
	$('#inline-nowcurerecord4').attr('disabled',true);
	$('#inline-nowcurerecord5').attr('disabled',true);
	$('#inline-nowcurerecord6').attr('disabled',true);
	$('#inline-nowcurerecord7').attr('disabled',true);
	$('#inline-nowcurerecord8').attr('disabled',true);
	*/
	if($("#inline-nowcurerecord2").is(":checked")){
		$('#inline-nowdrugrecord2').attr('disabled',false);
		$('#inline-nowdrugrecord3').attr('disabled',false);
		$('#inline-nowdrugrecord4').attr('disabled',false);
		$('#inline-nowdrugrecord5').attr('disabled',false);
		$('#inline-nowdrugrecord6').attr('disabled',false);
		$('#inline-nowdrugrecord7').attr('disabled',false);
		$('#inline-nowdrugrecord8').attr('disabled',false);
		$('#inline-nowdrugrecord9').attr('disabled',false);
		$('#inline-nowdrugrecord10').attr('disabled',false);
		$('#inline-nowdrugrecord11').attr('disabled',false);
	}
	else{
		$('#inline-nowdrugrecord2').attr('disabled',true);
		$('#inline-nowdrugrecord3').attr('disabled',true);
		$('#inline-nowdrugrecord4').attr('disabled',true);
		$('#inline-nowdrugrecord5').attr('disabled',true);
		$('#inline-nowdrugrecord6').attr('disabled',true);
		$('#inline-nowdrugrecord7').attr('disabled',true);
		$('#inline-nowdrugrecord8').attr('disabled',true);
		$('#inline-nowdrugrecord9').attr('disabled',true);
		$('#inline-nowdrugrecord10').attr('disabled',true);
		$('#inline-nowdrugrecord11').attr('disabled',true);
	}
	
	$("#inline-nowcurerecord1").bind("change",function(){
		//alert("诶嘿真好玩");
		if(!$('#inline-nowcurerecord1').is(':checked')){
			$('#inline-nowcurerecord2').attr('disabled',false);
			$('#inline-nowcurerecord3').attr('disabled',false);
			$('#inline-nowcurerecord4').attr('disabled',false);
			$('#inline-nowcurerecord5').attr('disabled',false);
			$('#inline-nowcurerecord6').attr('disabled',false);
			$('#inline-nowcurerecord7').attr('disabled',false);
			$('#inline-nowcurerecord8').attr('disabled',false);
			                                            
			/*$('#inline-nowdrugrecord2').attr('disabled',false);
			$('#inline-nowdrugrecord3').attr('disabled',false);
			$('#inline-nowdrugrecord4').attr('disabled',false);
			$('#inline-nowdrugrecord5').attr('disabled',false);
			$('#inline-nowdrugrecord6').attr('disabled',false);
			$('#inline-nowdrugrecord7').attr('disabled',false);
			$('#inline-nowdrugrecord8').attr('disabled',false);
			$('#inline-nowdrugrecord9').attr('disabled',false);
			$('#inline-nowdrugrecord10').attr('disabled',false);
			$('#inline-nowdrugrecord11').attr('disabled',false);*/
			
			$('#inline-nowcurerecord1').attr('checked',false);
		}else {
			$('#inline-nowcurerecord2').attr('checked',false);
			$('#inline-nowcurerecord3').attr('checked',false);
			$('#inline-nowcurerecord4').attr('checked',false);
			$('#inline-nowcurerecord5').attr('checked',false);
			$('#inline-nowcurerecord6').attr('checked',false);
			$('#inline-nowcurerecord7').attr('checked',false);
			$('#inline-nowcurerecord8').attr('checked',false);
			                                      
			$('#inline-nowdrugrecord2').attr('checked',false);
			$('#inline-nowdrugrecord3').attr('checked',false);
			$('#inline-nowdrugrecord4').attr('checked',false);
			$('#inline-nowdrugrecord5').attr('checked',false);
			$('#inline-nowdrugrecord6').attr('checked',false);
			$('#inline-nowdrugrecord7').attr('checked',false);
			$('#inline-nowdrugrecord8').attr('checked',false);
			$('#inline-nowdrugrecord9').attr('checked',false);
			$('#inline-nowdrugrecord10').attr('checked',false);
			$('#inline-nowdrugrecord11').attr('checked',false);
			
			$('#inline-nowcurerecord2').attr('disabled',true);
			$('#inline-nowcurerecord3').attr('disabled',true);
			$('#inline-nowcurerecord4').attr('disabled',true);
			$('#inline-nowcurerecord5').attr('disabled',true);
			$('#inline-nowcurerecord6').attr('disabled',true);
			$('#inline-nowcurerecord7').attr('disabled',true);
			$('#inline-nowcurerecord8').attr('disabled',true);
			                                      
			$('#inline-nowdrugrecord2').attr('disabled',true);
			$('#inline-nowdrugrecord3').attr('disabled',true);
			$('#inline-nowdrugrecord4').attr('disabled',true);
			$('#inline-nowdrugrecord5').attr('disabled',true);
			$('#inline-nowdrugrecord6').attr('disabled',true);
			$('#inline-nowdrugrecord7').attr('disabled',true);
			$('#inline-nowdrugrecord8').attr('disabled',true);
			$('#inline-nowdrugrecord9').attr('disabled',true);
			$('#inline-nowdrugrecord10').attr('disabled',true);
			$('#inline-nowdrugrecord11').attr('disabled',true);
	
			$('#inline-nowcurerecord1').attr('checked',true);
		}
	});
	
	$("#inline-nowcurerecord2").bind("change",function(){
		if($('#inline-nowcurerecord2').is(':checked')){
			$('#inline-nowdrugrecord2').attr('disabled',false);
			$('#inline-nowdrugrecord3').attr('disabled',false);
			$('#inline-nowdrugrecord4').attr('disabled',false);
			$('#inline-nowdrugrecord5').attr('disabled',false);
			$('#inline-nowdrugrecord6').attr('disabled',false);
			$('#inline-nowdrugrecord7').attr('disabled',false);
			$('#inline-nowdrugrecord8').attr('disabled',false);
			$('#inline-nowdrugrecord9').attr('disabled',false);
			$('#inline-nowdrugrecord10').attr('disabled',false);
			$('#inline-nowdrugrecord11').attr('disabled',false);
			
			$('#inline-nowdrugrecord11').attr('checked',true);
		}else{
			$('#inline-nowdrugrecord2').attr('disabled',true);
			$('#inline-nowdrugrecord3').attr('disabled',true);
			$('#inline-nowdrugrecord4').attr('disabled',true);
			$('#inline-nowdrugrecord5').attr('disabled',true);
			$('#inline-nowdrugrecord6').attr('disabled',true);
			$('#inline-nowdrugrecord7').attr('disabled',true);
			$('#inline-nowdrugrecord8').attr('disabled',true);
			$('#inline-nowdrugrecord9').attr('disabled',true);
			$('#inline-nowdrugrecord10').attr('disabled',true);
			$('#inline-nowdrugrecord11').attr('disabled',true);
			
			$('#inline-nowdrugrecord11').attr('checked',false);
		}
	});
	//switch开关
	$("#illnowSwitch").bind("click",function(){
		if($(this).is(":checked")){
			$("#NowIllcomp").show();
		}
		else{
			$(".illnowdel").trigger("click");
			$("#NowIllcomp").hide(); 
			$("#inline-nowcurerecord1").attr('checked',true);
			$("#inline-nowcurerecord1").trigger("change");
		}
	});
	$("#illHisSwitch").bind("click",function(){
		if($(this).is(":checked")){
			$("#Hisillcomp").show();
		}
		else{
			$(".illhisdel").trigger("click");
			$("#Hisillcomp").hide();
		}
	});
	  //米面主食类
	  $("input[name='mealrecord.ricerecurrence']").bind("click",function(){
			var inline = $(this).attr("id");
			verifyMealcord(inline,"ricetimes","ricenum");
	  });
	  $("#ricetimes").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.ricerecurrence']:checked").attr("id");
		  verifyMealcord(inline,"ricetimes","ricenum");
	  });
	  $("#ricenum").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.ricerecurrence']:checked").attr("id");
		  verifyMealcord(inline,"ricetimes","ricenum");
	  });
	  //杂粮类
	  $("input[name='mealrecord.grainsrecurrence']").bind("click",function(){
			var inline = $(this).attr("id");
			verifyMealcord(inline,"grainstimes","grainsnum");
	  });
	  $("#grainstimes").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.grainsrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"grainstimes","grainsnum");
	  });
	  $("#grainsnum").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.grainsrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"grainstimes","grainsnum");
	  });
	   //肉类
	  $("input[name='mealrecord.meatrecurrence']").bind("click",function(){
			var inline = $(this).attr("id");
			verifyMealcord(inline,"meattimes","meatnum");
	  });
	  $("#meattimes").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.meatrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"meattimes","meatnum");
	  });
	  $("#meatnum").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.meatrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"meattimes","meatnum");
	  });
	  //鱼和水产类
	  $("input[name='mealrecord.fishrecurrence']").bind("click",function(){
			var inline = $(this).attr("id");
			verifyMealcord(inline,"fishtimes","fishnum");
	  });
	  $("#fishtimes").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.fishrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"fishtimes","fishnum");
	  });
	  $("#fishnum").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.fishrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"fishtimes","fishnum");
	  });
	  //蛋类
	  $("input[name='mealrecord.eggrecurrence']").bind("click",function(){
			var inline = $(this).attr("id");
			verifyMealcord(inline,"eggtimes","eggnum");
	  });
	  $("#eggtimes").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.eggrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"eggtimes","eggnum");
	  });
	  $("#eggnum").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.eggrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"eggtimes","eggnum");
	  });
	  //奶类
	  $("input[name='mealrecord.milkrecurrence']").bind("click",function(){
			var inline = $(this).attr("id");
			verifyMealcord(inline,"milktimes","milknum");
	  });
	  $("#milktimes").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.milkrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"milktimes","milknum");
	  });
	  $("#milknum").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.milkrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"milktimes","milknum");
	  });
	  //豆类
	  $("input[name='mealrecord.beanrecurrence']").bind("click",function(){
			var inline = $(this).attr("id");
			verifyMealcord(inline,"beantimes","beannum");
	  });
	  $("#beantimes").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.beanrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"beantimes","beannum");
	  });
	  $("#beannum").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.beanrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"beantimes","beannum");
	  });
	  //豆浆
	  $("input[name='mealrecord.soymilkrecurrence']").bind("click",function(){
			var inline = $(this).attr("id");
			verifyMealcord(inline,"soymilktimes","soymilknum");
	  });
	  $("#soymilktimes").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.soymilkrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"soymilktimes","soymilknum");
	  });
	  $("#soymilknum").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.soymilkrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"soymilktimes","soymilknum");
	  });
      //蔬菜类
	  $("input[name='mealrecord.vegetablesrecurrence']").bind("click",function(){
			var inline = $(this).attr("id");
			verifyMealcord(inline,"vegetablestimes","vegetablesnum");
	  });
	  $("#vegetablestimes").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.vegetablesrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"vegetablestimes","vegetablesnum");
	  });
	  $("#vegetablesnum").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.vegetablesrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"vegetablestimes","vegetablesnum");
	  });
	  //水果类
	  $("input[name='mealrecord.fruitrecurrence']").bind("click",function(){
			var inline = $(this).attr("id");
			verifyMealcord(inline,"fruittimes","fruitnum");
	  });
	  $("#fruittimes").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.fruitrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"fruittimes","fruitnum");
	  });
	  $("#fruitnum").bind("blur",function(){
		  var inline=$("input:radio[name='mealrecord.fruitrecurrence']:checked").attr("id");
		  verifyMealcord(inline,"fruittimes","fruitnum");
	  });
	  
	  $("#soyasalt").bind("blur",function(){
		  verifyMealcord2("soyasalt");
	  });
	  $("#soyaoil").bind("blur",function(){
		  verifyMealcord2("soyaoil");
	  });
	  $("#water").bind("blur",function(){
		  verifyMealcord2("water");
	  });
	  $("#redwinenum").bind("blur",function(){
		  verifyMealcord2("redwinenum");
	  });
	  $("#ricewinenum").bind("blur",function(){
		  verifyMealcord2("ricewinenum");
	  });
	  $("#beernum").bind("blur",function(){
		  verifyMealcord2("beernum");
	  });
	  $("#spiritlnum").bind("blur",function(){
		  verifyMealcord2("spiritlnum");
	  });
	  $("#spirithnum").bind("blur",function(){
		  verifyMealcord2("spirithnum");
	  });
	
/*	$(".timestext").bind("blur",function(){
		var select_id = $(this).attr("id");
		//var hintid ="#"+select_id+"hint";
		verifyNumber(select_id)
		//alert(select_id);
	});*/
	  
	$("#bikedays").bind("blur",function(){
		verifyWeekdays("bikedays");
	});
	$("#walkdays").bind("blur",function(){
		verifyWeekdays("walkdays");
	});
	$("#drivedays").bind("blur",function(){
		verifyWeekdays("drivedays");
	});
	$("#highsportsdays").bind("blur",function(){
		verifyWeekdays("highsportsdays");
	});
	$("#midsportsdays").bind("blur",function(){
		verifyWeekdays("midsportsdays");
	});
	$("#highwalkdays").bind("blur",function(){
		verifyWeekdays("highwalkdays");
	});
	$("#highhouseworkdays").bind("blur",function(){
		verifyWeekdays("highhouseworkdays");
	});
	$("#midhouseworkdays").bind("blur",function(){
		verifyWeekdays("midhouseworkdays");
	});
	$("#redwinetimes").bind("blur",function(){
		verifyWeekdays("redwinetimes");
	});
	$("#ricewinetimes").bind("blur",function(){
		verifyWeekdays("ricewinetimes");
	});
	$("#beertimes").bind("blur",function(){
		verifyWeekdays("beertimes");
	});
	$("#spiritltimes").bind("blur",function(){
		verifyWeekdays("spiritltimes");
	});
	$("#spirithtimes").bind("blur",function(){
		verifyWeekdays("spirithtimes");
	});
	
	$("#bikehours").bind("blur",function(){
		verifyHourMinute("bikehours","bikeminutes");
	});
	$("#bikeminutes").bind("blur",function(){
		verifyHourMinute("bikehours","bikeminutes");
	});
	$("#walkhours").bind("blur",function(){
		verifyHourMinute("walkhours","walkminutes");
	});
	$("#walkminutes").bind("blur",function(){
		verifyHourMinute("walkhours","walkminutes");
	});
	$("#drivehours").bind("blur",function(){
		verifyHourMinute("drivehours","driveminutes");
	});
	$("#driveminutes").bind("blur",function(){
		verifyHourMinute("drivehours","driveminutes");
	});
	$("#highsportshours").bind("blur",function(){
		verifyHourMinute("highsportshours","highsportsminutes");
	});
	$("#highsportsminutes").bind("blur",function(){
		verifyHourMinute("highsportshours","highsportsminutes");
	});
	$("#midsportshours").bind("blur",function(){
		verifyHourMinute("midsportshours","midsportsminutes");
	});
	$("#midsportsminutes").bind("blur",function(){
		verifyHourMinute("midsportshours","midsportsminutes");
	});
	$("#highwalkhours").bind("blur",function(){
		verifyHourMinute("highwalkhours","highwalkminutes");
	});
	$("#highwalkminutes").bind("blur",function(){
		verifyHourMinute("highwalkhours","highwalkminutes");
	});
	$("#highhouseworkhours").bind("blur",function(){
		verifyHourMinute("highhouseworkhours","highhouseworkminutes");
	});
	$("#highhouseworkminutes").bind("blur",function(){
		verifyHourMinute("highhouseworkhours","highhouseworkminutes");
	});
	$("#midhouseworkhours").bind("blur",function(){
		verifyHourMinute("midhouseworkhours","midhouseworkminutes");
	});
	$("#midhouseworkminutes").bind("blur",function(){
		verifyHourMinute("midhouseworkhours","midhouseworkminutes");
	});
	$("#recreationhours").bind("blur",function(){
		verifyHourMinute("recreationhours","recreationminutes");
	});
	$("#recreationminutes").bind("blur",function(){
		verifyHourMinute("recreationhours","recreationminutes");
	});
	$("#sleeptimes").bind("blur",function(){
		verifyHourMinute("sleeptimes","sleeptimesmin");
	});
	$("#sleeptimesmin").bind("blur",function(){
		verifyHourMinute("sleeptimes","sleeptimesmin");
	});
	
	
	$("#familyage").bind("blur",function(){
		var r = /^(([123456789]|[123456789]\d)|100)$/;
		//var r = /^([1]?\d{1,2})$/;　　//0-100的正整数            
		if($(this).val() == ""){
			$("#fam-hint1").hide(); 
		}
		else if(!r.test($(this).val())){  
        	$("#fam-hint1").html("请输入不超过100的正整数");
        	$("#fam-hint1").show();
        	$(this).val("");
        }   
		else{
			$("#fam-hint1").hide(); 
		}
	});
	
	
	$("#familyage").bind("keyup",function(){
		var r = /^(([123456789]|[123456789]\d)|100)$/;
		//var r = /^([1]?\d{1,2})$/;　　//0-100的正整数            
        if(!r.test($(this).val())){  
        	$("#fam-hint1").html("请输入不超过100的正整数");
        	$("#fam-hint1").show();
            return false;  
        }   
	});
	
	$("#smokeage").bind("blur",function(){
		var r = /^(([123456789]|[123456789]\d)|100)$/;
		//var r = /^([1]?\d{1,2})$/;　　//0-100的正整数            
		if($(this).val() == ""){
			$("#hint3").html("该项必填不能为空");
			$("#hint3").show();
		}
		else if(!r.test($(this).val())){  
        	$("#hint3").html("请输入不超过100的正整数");
        	$("#hint3").show();
        	$(this).val("");
            return false;  
        }
		/*else if(!(parseInt($(this).val())<=parseInt($("#nosmokeage").val())) && $("#inline-issmoke2").prop("checked") == true){
			$("#hint4").html("开始戒烟年龄不得小于开始吸烟年龄");
        	$("#hint4").show();
        	$(this).val("");
            return false;  
		}*/
		else{
			verifyNumber("smokeage");
		}
	});
	$("#smokeage").bind("keyup",function(){
		var r = /^(([123456789]|[123456789]\d)|100)$/;
		//var r = /^([1]?\d{1,2})$/;　　//0-100的正整数            
        if(!r.test($(this).val())){  
        	$("#hint3").html("请输入不超过100的正整数");
        	$("#hint3").show();
            return false;  
        }   
	});
	
	$("#nosmokeage").bind("blur",function(){
		var r = /^(([123456789]|[123456789]\d)|100)$/;
		//var r = /^([1]?\d{1,2})$/;　　//0-100的正整数            
		if($(this).val() == ""){
			$("#hint4").html("该项必填不能为空");
			$("#hint4").show();
		}
		else if(!r.test($(this).val())){  
        	$("#hint4").html("请输入不超过100的正整数");
        	$("#hint4").show();
        	$(this).val("");
            return false;  
        }
		else if(!(parseInt($(this).val())>=parseInt($("#smokeage").val()))){
			$("#hint4").html("开始戒烟年龄不得小于开始吸烟年龄");
        	$("#hint4").show();
        	$(this).val("");
            return false;  
		}
		else{
			verifyNumber("nosmokeage");
		}
	});
	$("#nosmokeage").bind("keyup",function(){
		var r = /^(([123456789]|[123456789]\d)|100)$/;
		//var r = /^([1]?\d{1,2})$/;　　//0-100的正整数            
        if(!r.test($(this).val())){  
        	$("#hint4").html("请输入不超过100的正整数");
        	$("#hint4").show();
            return false;  
        }   
	});
	$("#dailysmoke").bind("blur",function(){
		var r = /^(([123456789]|[123456789]\d)|100)$/;
		//var r = /^([1]?\d{1,2})$/;　　//0-100的正整数            
		if($(this).val() == ""){
			$("#hint2").html("该项必填不能为空");
			$("#hint2").show();
		}
		else if(!r.test($(this).val())){  
        	$("#hint2").html("请输入不超过100的正整数");
        	$("#hint2").show();
        	$(this).val("");
            return false;  
        }   
		else{
			$("#hint2").hide();
		}
	});
	$("#dailysmoke").bind("keyup",function(){
		var r = /^(([123456789]|[123456789]\d)|100)$/;
		//var r = /^([1]?\d{1,2})$/;　　//0-100的正整数            
        if(!r.test($(this).val())){  
        	$("#hint2").html("请输入不超过100的正整数");
        	$("#hint2").show();
            return false;  
        }   
	});
	$("#height").bind("blur",function(){
		//alert("alala");
		var r = /^((1\d{2})(\.\d)?|(2[01]\d)(\.\d)?|220(\.0)?)$/;   
		if($(this).val() == ""){
			$("#bodycheckhint1").html("该项必填不能为空");
			$("#bodycheckhint1").show();
			$("#bmi").val("");
		}
		else if(!r.test($(this).val())){  
        	$("#bodycheckhint1").html("100-220整数或1位小数");
        	$("#bodycheckhint1").show();
            return false;  
        }
		else{
			$("#bodycheckhint1").hide();
			if($("#bodycheckhint2").is(":hidden")== true){
				var v = parseFloat($("#weight").val())/(parseFloat($("#height").val())*parseFloat($("#height").val())/10000);
				$("#bmi").val(v.toFixed(2));
			}
				
		}
	});
	$("#height").bind("keyup",function(){
		var r = /^((1\d{2})(\.\d)?|(2[01]\d)(\.\d)?|220(\.0)?)$/;        
        if(!r.test($(this).val())){  
        	$("#bodycheckhint1").html("100-220整数或1位小数");
        	$("#bodycheckhint1").show();
            return false;  
        }   
	});
	$("#weight").bind("blur",function(){
		//alert("alala");
		var r = /^(([3-9]\d)(\.\d{1,2})?|(1\d{2})(\.\d{1,2})?|(2[01]\d)(\.\d{1,2})?|(22[0-2])(\.\d{1,2})?|223(\.0{1,2})?)$/;  
		if($(this).val() == ""){
			$("#bodycheckhint2").html("该项必填不能为空");
			$("#bodycheckhint2").show();
			$("#bmi").val("");
		}
		else if(!r.test($(this).val())){  
        	$("#bodycheckhint2").html("30-223整数或2位以内小数");
        	$("#bodycheckhint2").show();
            return false;  
        }
		else{
			$("#bodycheckhint2").hide();
			if($("#bodycheckhint1").is(":hidden")== true){
				var v = parseFloat($("#weight").val())/(parseFloat($("#height").val())*parseFloat($("#height").val())/10000);
				$("#bmi").val(v.toFixed(2));
			}
		}
	});
	$("#weight").bind("keyup",function(){
		var r = /^(([3-9]\d)(\.\d{1,2})?|(1\d{2})(\.\d{1,2})?|(2[01]\d)(\.\d{1,2})?|(22[0-2])(\.\d{1,2})?|223(\.0{1,2})?)$/;      
        if(!r.test($(this).val())){  
        	$("#bodycheckhint2").html("30-223整数或2位以内小数");
        	$("#bodycheckhint2").show();
            return false;  
        }   
	});
	$("#waistline").bind("blur",function(){
		//alert("alala");
		var r = /^(([4-9]\d)(\.\d)?|(1[0-4]\d)(\.\d)?|150(\.0)?)$/;    
		if($(this).val() == ""){
			$("#bodycheckhint3").html("该项必填不能为空");
			$("#bodycheckhint3").show();
		}
		else if(!r.test($(this).val())){  
        	$("#bodycheckhint3").html("40-150之间的整数或1位小数");
        	$("#bodycheckhint3").show();
            return false;  
        }
		else{
			$("#bodycheckhint3").hide();
		}
	});
	$("#waistline").bind("keyup",function(){
		var r = /^(([4-9]\d)(\.\d)?|(1[0-4]\d)(\.\d)?|150(\.0)?)$/;        
        if(!r.test($(this).val())){  
        	$("#bodycheckhint3").html("40-150之间的整数或1位小数");
        	$("#bodycheckhint3").show();
            return false;  
        }   
	});
	$("#systolicbp").bind("blur",function(){
		//alert("alala");
		if($("#bodycheckhint5").is(":hidden")== true &&$("#diastolicbp").val() != ""){
			var max = Math.min(parseInt($("#diastolicbp").val())+100,280);
			var min = Math.max(parseInt($("#diastolicbp").val())+15,55);
			if(parseInt($(this).val())>max || parseInt($(this).val())<min){
				//alert("舒张压输入有误，可选择输入范围为：("+min+"--"+max+")");
				$("#bodycheckhint4").html("收缩压输入有误，可选择输入范围为：("+min+"--"+max+")");
				$("#bodycheckhint4").show();
				$("#systolicbp").val("");
				return false;
			}
		}
		var r = /^(5[5-9]|[6-9]\d|1\d{2}|2[0-7]\d|280)$/;    
		if($(this).val() == ""){
			$("#bodycheckhint4").html("该项必填不能为空");
			$("#bodycheckhint4").show();
			if($("#diastolicbp").val() == ""){
				$("#bodycheckhint5").html("该项必填不能为空");
				$("#bodycheckhint5").hide();
				$("#bodycheckhint4").hide();
			}
		}
		else if(!r.test($(this).val())){
			if($("#bodycheckhint5").is(":hidden")== true &&$("#diastolicbp").val() != ""){
				var max = Math.min(parseInt($("#diastolicbp").val())+100,280);
				var min = Math.max(parseInt($("#diastolicbp").val())+15,55);
					$("#bodycheckhint4").html("收缩压可选择输入范围为：("+min+"--"+max+")");
					$("#bodycheckhint4").show();
					$("#systolicbp").val("");
					return false;	
			}
			else{
				$("#bodycheckhint4").html("55-280之间的整数");
				$("#bodycheckhint4").show();
				return false;  
			}
        }
		else{
			$("#bodycheckhint4").hide();
			$("#bodycheckhint5").hide();
		}
	});
	$("#systolicbp").bind("keyup",function(){
		var r = /^(5[5-9]|[6-9]\d|1\d{2}|2[0-7]\d|280)$/;
		if($("#bodycheckhint5").is(":hidden")== true &&$("#diastolicbp").val() != ""){
			var max = Math.min(parseInt($("#diastolicbp").val())+100,280);
			var min = Math.max(parseInt($("#diastolicbp").val())+15,55);
				$("#bodycheckhint4").html("收缩压可选择输入范围为：("+min+"--"+max+")");
				$("#bodycheckhint4").show();
				return false;	
		}
		else{
			$("#bodycheckhint4").html("55-280之间的整数");
        	$("#bodycheckhint4").show();
            return false; 
		}
        /*if(!r.test($(this).val())){  
        	$("#bodycheckhint4").html("55-280之间的整数");
        	$("#bodycheckhint4").show();
            return false;  
        } 
        */  
	});
	$("#diastolicbp").bind("blur",function(){
		//alert("alala");
		if($("#bodycheckhint4").is(":hidden")== true &&$("#systolicbp").val() != ""){
			var min = Math.max(parseInt($("#systolicbp").val())-100,40);
			var max = Math.min(parseInt($("#systolicbp").val())-15,220);
			if(parseInt($(this).val())>max || parseInt($(this).val())<min){
				//alert("舒张压输入有误，可选择输入范围为：("+min+"--"+max+")");
				$("#bodycheckhint5").html("舒张压输入有误，可选择输入范围为：("+min+"--"+max+")");
				$("#bodycheckhint5").show();
				$("#diastolicbp").val("");
				return false;
			}
		}
		var r = /^([4-9]\d|1\d{2}|2[01]\d|220)$/;    
		if($(this).val() == ""){
			$("#bodycheckhint5").html("该项必填不能为空");
			$("#bodycheckhint5").show();
			if($("#systolicbp").val() == ""){
				$("#bodycheckhint4").html("该项必填不能为空");
				$("#bodycheckhint5").hide();
				$("#bodycheckhint4").hide();
			}
		}
		else if(!r.test($(this).val())){
			if($("#bodycheckhint4").is(":hidden")== true &&$("#systolicbp").val() != ""){
				var min = Math.max(parseInt($("#systolicbp").val())-100,40);
				var max = Math.min(parseInt($("#systolicbp").val())-15,220);
					$("#bodycheckhint5").html("舒张压可选择输入范围为：("+min+"--"+max+")");
					$("#bodycheckhint5").show();
					$("#diastolicbp").val("");
					return false;		
			}
			else{
				$("#bodycheckhint5").html("40-220之间的整数");
				$("#bodycheckhint5").show();
				return false;
			}
        }
		else{
			$("#bodycheckhint4").hide();
			$("#bodycheckhint5").hide();
		}
	});
	$("#diastolicbp").bind("keyup",function(){
		var r = /^([4-9]\d|1\d{2}|2[01]\d|220)$/;
		if($("#bodycheckhint4").is(":hidden")== true &&$("#systolicbp").val() != ""){
			var min = Math.max(parseInt($("#systolicbp").val())-100,40);
			var max = Math.min(parseInt($("#systolicbp").val())-15,220);
				$("#bodycheckhint5").html("舒张压可选择输入范围为：("+min+"--"+max+")");
				$("#bodycheckhint5").show();
				return false;		
		}
		else{  
        	$("#bodycheckhint5").html("40-220之间的整数");
        	$("#bodycheckhint5").show();
            return false;  
        }
        /*if(!r.test($(this).val())){  
        	$("#bodycheckhint5").html("40-220之间的整数");
        	$("#bodycheckhint5").show();
            return false;  
        }
        */   
	});
	
	$("#tc").bind("blur",function(){
		var r = /^(0\.[89]\d?|[1-9](\.\d{1,2})?|1[0-4](\.\d{1,2})?|15(\.0{1,2})?)$/;
		var c = "#tc";
		var a = "#hdl";
		var b = "#ldl";
		if($(this).val() != ""){
			if($(a).val() == ""&&$(b).val() == ""){
				if(!r.test($(this).val())){  
					$("#bodycheckhint6").html("0.8-15整数或不超2位小数");
					$("#bodycheckhint6").show();
					$(this).val("");
					return false;  
				}
				else{
					$("#bodycheckhint6").hide();
				}
			}
			else{
				if(!r.test($(this).val())){
					if($("#bodycheckhint7").is(":hidden")== true &&$(a).val() != ""&&$(b).val() == ""){
						if(parseFloat($(a).val())<0.8){  
							$("#bodycheckhint6").html("0.8-15整数或不超2位小数");
							$("#bodycheckhint6").show();
							$(this).val("");
							 
						}
						else{
							$("#bodycheckhint6").html((parseFloat($(a).val())+0.5).toFixed(2)+"-15整数或不超2位小数");
							$("#bodycheckhint6").show();
							$(this).val("");
							  
						}
					}
				
					else if($("#bodycheckhint8").is(":hidden")== true &&$(a).val() == ""&&$(b).val() != ""){
						if(parseFloat($(b).val())<0.8){  
							$("#bodycheckhint6").html("0.8-15整数或不超2位小数");
							$("#bodycheckhint6").show();
							$(this).val("");
							 
						}
						else{
							$("#bodycheckhint6").html((parseFloat($(b).val())+0.1).toFixed(2)+"-15整数或不超2位小数");
							$("#bodycheckhint6").show();
							$(this).val("");
							 
						}
					}				
					else{
						$("#bodycheckhint6").html("0.8-15整数或不超2位小数");
						$("#bodycheckhint6").show();
						$(this).val(""); 
					}					
				}
				else {
					if($("#bodycheckhint7").is(":hidden")== true &&$(a).val() != ""&&$(b).val() == ""){
						if(parseFloat($(a).val())<0.8){  
							$("#bodycheckhint6").hide();						  
						}
						else{
							//c要大于a
							if(parseFloat($(this).val()) >= parseFloat($(a).val())+0.5){
								$("#bodycheckhint6").hide();
							}
							else{
								$("#bodycheckhint6").html((parseFloat($(a).val())+0.5).toFixed(2)+"-15整数或不超2位小数");
								$("#bodycheckhint6").show();
								$(this).val("");
							}
						}
					}
				
					else if($("#bodycheckhint8").is(":hidden")== true &&$(a).val() == ""&&$(b).val() != ""){
						if(parseFloat($(b).val())<0.8){  
							$("#bodycheckhint6").hide();						  
						}
						else{
							//c要大于a
							if(parseFloat($(this).val()) >= parseFloat($(b).val())+0.1){
								$("#bodycheckhint6").hide();
							}
							else{
								$("#bodycheckhint6").html((parseFloat($(b).val())+0.1).toFixed(2)+"-15整数或不超2位小数");
								$("#bodycheckhint6").show();
								$(this).val("");
							}
						}
					}
			
					else if($("#bodycheckhint8").is(":hidden")== true && $("#bodycheckhint7").is(":hidden")== true && $(a).val() != "" && $(b).val() != ""){
						if(parseFloat($(this).val())<parseFloat($(a).val())+ parseFloat($(b).val())){
							$("#bodycheckhint6").html("总胆固醇应大于高、低密度脂蛋白之和");
							$("#bodycheckhint6").show();
							$(this).val("");
						}
						else{
							$("#bodycheckhint6").hide();
						}
					}
				}
			}
			
		}
		else{  
        	if($(a).val() == ""&&$(b).val() == ""){
				$("#bodycheckhint6").hide();  
			}
			else{
				$("#bodycheckhint6").html("该项必填不能为空");
				$("#bodycheckhint6").show();
			}
        }
	});
	
	$("#tc").bind("keyup",function(){
		var c = "#tc";
		var a = "#hdl";
		var b = "#ldl";
		var r = /^(0\.[89]\d?|[1-9](\.\d{1,2})?|1[0-4](\.\d{1,2})?|15(\.0{1,2})?)$/;    
			if($(a).val() == ""&&$(b).val() == ""){
				$("#bodycheckhint6").html("0.8-15整数或不超2位小数");
				$("#bodycheckhint6").show();
			}
			else{
				if($("#bodycheckhint7").is(":hidden")== true &&$(a).val() != ""&&$(b).val() == ""){
					if(parseFloat($(a).val())<0.8){
						$("#bodycheckhint6").html("0.8-15整数或不超2位小数");
						$("#bodycheckhint6").show();
					}
					else{
						$("#bodycheckhint6").html((parseFloat($(a).val())+0.5).toFixed(2)+"-15整数或不超2位小数");
						$("#bodycheckhint6").show();
					}
				}
				else if($("#bodycheckhint8").is(":hidden")== true &&$(b).val() != "" && $(a).val() == "" ){
					if(parseFloat($(b).val())<0.8){
						$("#bodycheckhint6").html("0.8-15整数或不超2位小数");
						$("#bodycheckhint6").show();
					}
					else{
						$("#bodycheckhint6").html((parseFloat($(b).val())+0.1).toFixed(2)+"-15整数或不超2位小数");
						$("#bodycheckhint6").show();
					}
				}
				else if($("#bodycheckhint7").is(":hidden")== true &&$(a).val() != ""&&$("#bodycheckhint8").is(":hidden")== true &&$(b).val() != ""){
					var s = (parseFloat($(a).val()) + parseFloat($(b).val())).toFixed(2);
					$("#bodycheckhint6").html(s+"-15整数或不超2位小数");
					$("#bodycheckhint6").show();
				}
				
			}
	});
	
	$("#hdl").bind("blur",function(){
		var r = /^(0\.[1-9]\d?|[1-9](\.\d{1,2})?|10(\.0{1,2})?)$/;
		var c = "#tc";
		var a = "#hdl";
		var b = "#ldl";
		if($(this).val() != ""){
			if($(c).val() == ""&&$(b).val() == ""){
				if(!r.test($(this).val())){  
					$("#bodycheckhint7").html("0.1-10整数或不超2位小数");
					$("#bodycheckhint7").show();
					$(this).val("");
					return false;  
				}
				else{
					$("#bodycheckhint7").hide();
				}
			}
			else{
				if(!r.test($(this).val())){
					if($("#bodycheckhint6").is(":hidden")== true &&$(c).val() != ""&&$(b).val() == ""){
						if(parseFloat($(c).val())<10){  
							$("#bodycheckhint7").html("0.1-"+(parseFloat($(c).val())-0.5).toFixed(2)+"整数或不超2位小数");
							$("#bodycheckhint7").show();
							$(this).val("");
							 
						}
						else{
							$("#bodycheckhint7").html("0.1-10整数或不超2位小数");
							$("#bodycheckhint7").show();
							$(this).val("");  
						}
					}
				
					else if($("#bodycheckhint8").is(":hidden")== true &&$(c).val() == ""&&$(b).val() != ""){
							$("#bodycheckhint7").html("0.1-"+(15-parseFloat($(b).val())).toFixed(2)+"整数或不超2位小数");
							$("#bodycheckhint7").show();
							$(this).val("");
					}
					else if($("#bodycheckhint8").is(":hidden")== true && $("#bodycheckhint6").is(":hidden")== true && $(c).val() != "" && $(b).val() != ""){
						var s = parseFloat($(c).val()).toFixed(2) - parseFloat($(b).val()).toFixed(2);
						$("#bodycheckhint7").html("0.1-"+s.toFixed(2)+"整数或不超2位小数");
						$("#bodycheckhint7").show();
						$(this).val(""); 
					}
					else{
						$("#bodycheckhint7").html("0.1-10整数或不超2位小数");
						$("#bodycheckhint7").show();
						$(this).val(""); 
					}					
				}
				else {
					if($("#bodycheckhint6").is(":hidden")== true &&$(c).val() != ""&&$(b).val() == ""){
						if(parseFloat($(c).val())>parseFloat($(this).val())+0.5){  
							$("#bodycheckhint7").hide();						  
						}
						else{
							$("#bodycheckhint7").html("0.1-"+(parseFloat($(c).val())-0.5).toFixed(2)+"整数或不超2位小数");
							$("#bodycheckhint7").show();
							$(this).val("");
							
						}
					}
				
					else if($("#bodycheckhint8").is(":hidden")== true &&$(c).val() == ""&&$(b).val() != ""){
						if(parseFloat($(b).val())+parseFloat($(this).val())>15){
								$("#bodycheckhint7").html("不能超过总胆固醇最大值15");
								$("#bodycheckhint7").show();
								$(this).val("");											  
						}
						else{
							$("#bodycheckhint7").hide();	
						}
					}
		
					else if($("#bodycheckhint8").is(":hidden")== true && $("#bodycheckhint6").is(":hidden")== true && $(c).val() != "" && $(b).val() != ""){
						if(parseFloat($(this).val())+ parseFloat($(b).val())>parseFloat($(c).val())){
							$("#bodycheckhint7").html("总胆固醇应大于高、低密度脂蛋白之和");
							$("#bodycheckhint7").show();
							$(this).val("");
						}
						else{
							$("#bodycheckhint7").hide();
						}
					}
				}
			}
			
		}
		else{  
        	if($(c).val() == ""&&$(b).val() == ""){
				$("#bodycheckhint7").hide();  
			}
			else{
				$("#bodycheckhint7").html("该项必填不能为空");
				$("#bodycheckhint7").show();
			}
        }
	});
	
	$("#hdl").bind("keyup",function(){
		var c = "#tc";
		var a = "#hdl";
		var b = "#ldl";
		
		var r = /^(0\.[1-9]\d?|[1-9](\.\d{1,2})?|10(\.0{1,2})?)$/;     
			if($(c).val() == ""&&$(b).val() == ""){
				$("#bodycheckhint7").html("0.1-10整数或不超2位小数");
				$("#bodycheckhint7").show();
			}
			else{
				if($("#bodycheckhint6").is(":hidden")== true &&$(c).val() != ""&&$(b).val() == ""){
					if(parseFloat($(c).val())<10){  
						$("#bodycheckhint7").html("0.1-"+(parseFloat($(c).val())-0.5).toFixed(2)+"整数或不超2位小数");
						$("#bodycheckhint7").show();
					}
					else{
						$("#bodycheckhint7").html("0.1-10整数或不超2位小数");
						$("#bodycheckhint7").show();
					}
				}
				else if($("#bodycheckhint8").is(":hidden")== true &&$(b).val() != "" && $(c).val() == "" ){
					if(15-parseFloat($(b).val())<10){
						$("#bodycheckhint7").html("0.1-"+(15-parseFloat($(b).val())).toFixed(2)+"整数或不超2位小数");
					}
					else{
						$("#bodycheckhint7").html("0.1-10整数或不超2位小数");
					}
						$("#bodycheckhint7").show();
					
				}
				else if($("#bodycheckhint6").is(":hidden")== true &&$(c).val() != ""&&$("#bodycheckhint8").is(":hidden")== true &&$(b).val() != ""){
					var s = parseFloat($(c).val()).toFixed(2) - parseFloat($(b).val()).toFixed(2);
					if(s<10){
						$("#bodycheckhint7").html("0.1-"+s.toFixed(2)+"整数或不超2位小数");
					}
					else{
						$("#bodycheckhint7").html("0.1-10整数或不超2位小数");
					}
					$("#bodycheckhint7").show();
				}
				
			}
	});
	$("#ldl").bind("blur",function(){
		var r = /^(0\.[5-9]\d?|[1-9](\.\d{1,2})?|10(\.0{1,2})?)$/;
		var c = "#tc";
		var a = "#hdl";
		var b = "#ldl";
		if($(this).val() != ""){
			if($(c).val() == ""&&$(a).val() == ""){
				if(!r.test($(this).val())){  
					$("#bodycheckhint8").html("0.1-10整数或不超2位小数");
					$("#bodycheckhint8").show();
					$(this).val("");
					return false;  
				}
				else{
					$("#bodycheckhint8").hide();
				}
			}
			else{
				if(!r.test($(this).val())){
					if($("#bodycheckhint6").is(":hidden")== true &&$(c).val() != ""&&$(a).val() == ""){
						if(parseFloat($(c).val())<10){  
							$("#bodycheckhint8").html("0.1-"+(parseFloat($(c).val())-0.1).toFixed(2)+"整数或不超2位小数");
							$("#bodycheckhint8").show();
							$(this).val("");
							 
						}
						else{
							$("#bodycheckhint8").html("0.1-10整数或不超2位小数");
							$("#bodycheckhint8").show();
							$(this).val("");  
						}
					}
				
					else if($("#bodycheckhint7").is(":hidden")== true &&$(c).val() == ""&&$(a).val() != ""){
							$("#bodycheckhint8").html("0.1-"+(15-parseFloat($(a).val())).toFixed(2)+"整数或不超2位小数");
							$("#bodycheckhint8").show();
							$(this).val("");
					}
					else if($("#bodycheckhint7").is(":hidden")== true && $("#bodycheckhint6").is(":hidden")== true && $(c).val() != "" && $(a).val() != ""){
						var s = parseFloat($(c).val()).toFixed(2) - parseFloat($(a).val()).toFixed(2);
						$("#bodycheckhint8").html("0.1-"+s.toFixed(2)+"整数或不超2位小数");
						$("#bodycheckhint8").show();
						$(this).val(""); 
					}
					else{
						$("#bodycheckhint8").html("0.1-10整数或不超2位小数");
						$("#bodycheckhint8").show();
						$(this).val(""); 
					}					
				}
				else {
					if($("#bodycheckhint6").is(":hidden")== true &&$(c).val() != ""&&$(a).val() == ""){
						if(parseFloat($(c).val())>parseFloat($(this).val())+0.1){  
							$("#bodycheckhint8").hide();						  
						}
						else{
							$("#bodycheckhint8").html("0.1-"+(parseFloat($(c).val())-0.1).toFixed(2)+"整数或不超2位小数");
							$("#bodycheckhint8").show();
							$(this).val("");
							
						}
					}
				
					else if($("#bodycheckhint7").is(":hidden")== true &&$(c).val() == ""&&$(a).val() != ""){
						if(parseFloat($(a).val())+parseFloat($(this).val())>15){
								$("#bodycheckhint8").html("不能超过总胆固醇最大值15");
								$("#bodycheckhint8").show();
								$(this).val("");											  
						}
						else{
							$("#bodycheckhint8").hide();	
						}
					}
		
					else if($("#bodycheckhint7").is(":hidden")== true && $("#bodycheckhint6").is(":hidden")== true && $(c).val() != "" && $(a).val() != ""){
						if(parseFloat($(this).val())+ parseFloat($(a).val())>parseFloat($(c).val())){
							$("#bodycheckhint8").html("总胆固醇应大于高、低密度脂蛋白之和");
							$("#bodycheckhint8").show();
							$(this).val("");
						}
						else{
							$("#bodycheckhint8").hide();
						}
					}
				}
			}
			
		}
		else{  
        	if($(c).val() == ""&&$(a).val() == ""){
				$("#bodycheckhint8").hide();  
			}
			else{
				$("#bodycheckhint8").html("该项必填不能为空");
				$("#bodycheckhint8").show();
			}
        }
	});
	
	$("#ldl").bind("keyup",function(){
		var c = "#tc";
		var a = "#hdl";
		var b = "#ldl";
		
		var r = /^(0\.[5-9]\d?|[1-9](\.\d{1,2})?|10(\.0{1,2})?)$/;   
			if($(c).val() == ""&&$(a).val() == ""){
				$("#bodycheckhint8").html("0.1-10整数或不超2位小数");
				$("#bodycheckhint8").show();
			}
			else{
				if($("#bodycheckhint6").is(":hidden")== true &&$(c).val() != ""&&$(a).val() == ""){
					if(parseFloat($(c).val())<10){  
						$("#bodycheckhint8").html("0.1-"+(parseFloat($(c).val())-0.1).toFixed(2)+"整数或不超2位小数");
						$("#bodycheckhint8").show();
					}
					else{
						$("#bodycheckhint8").html("0.1-10整数或不超2位小数");
						$("#bodycheckhint8").show();
					}
				}
				else if($("#bodycheckhint7").is(":hidden")== true &&$(a).val() != "" && $(c).val() == "" ){
						if(15-parseFloat($(a).val())<10){
							$("#bodycheckhint8").html("0.1-"+(15-parseFloat($(a).val())).toFixed(2)+"整数或不超2位小数");
						}
						else{
							$("#bodycheckhint8").html("0.1-10整数或不超2位小数");
						}
						$("#bodycheckhint8").show();
					
				}
				else if($("#bodycheckhint6").is(":hidden")== true &&$(c).val() != ""&&$("#bodycheckhint7").is(":hidden")== true &&$(a).val() != ""){
					var s = parseFloat($(c).val()).toFixed(2) - parseFloat($(a).val()).toFixed(2);
					if(s<10){
						$("#bodycheckhint8").html("0.1-"+s.toFixed(2)+"整数或不超2位小数");
					}
					else{
						$("#bodycheckhint8").html("0.1-10整数或不超2位小数");
					}
					$("#bodycheckhint8").show();
				}
				
			}
	});
	$("#tg").bind("blur",function(){
		var r = /^(0\.[1-9]\d?|[1-9](\.\d{1,2})?|10(\.0{1,2})?)$/;
		if($(this).val() == ""){
			$("#bodycheckhint9").html("该项必填不能为空");
			$("#bodycheckhint9").show();
		}
		else if(!r.test($(this).val())){  
        	$("#bodycheckhint9").html("0.1-10整数或不超2位小数");
        	$("#bodycheckhint9").show();
            return false;  
        }
		else{
			$("#bodycheckhint9").hide();
		}
	});
	$("#tg").bind("keyup",function(){
		var r = /^(0\.[1-9]\d?|[1-9](\.\d{1,2})?|10(\.0{1,2})?)$/;     
        if(!r.test($(this).val())){  
        	$("#bodycheckhint9").html("0.1-10整数或不超2位小数");
        	$("#bodycheckhint9").show();
            return false;  
        }   
	});
	$("#fpg").bind("blur",function(){
		var r =	/^([1-9](\.\d)?|[1-4]\d(\.\d)?|50(\.0)?)$/;
		if($(this).val() == ""){
			$("#bodycheckhint10").html("该项必填不能为空");
			$("#bodycheckhint10").show();
		}
		else if(!r.test($(this).val())){  
        	$("#bodycheckhint10").html("1-50整数或1位小数");
        	$("#bodycheckhint10").show();
            return false;  
        }
		else{
			$("#bodycheckhint10").hide();
		}
	});
	$("#fpg").bind("keyup",function(){
		var r =	/^([1-9](\.\d)?|[1-4]\d(\.\d)?|50(\.0)?)$/;    
        if(!r.test($(this).val())){  
        	$("#bodycheckhint10").html("1-50整数或1位小数");
        	$("#bodycheckhint10").show();
            return false;  
        }   
	});
	$("#ogtt2").bind("blur",function(){
		var r =	/^([2-9](\.\d)?|[1-4]\d(\.\d)?|50(\.0)?)$/;
		if($(this).val() == ""){
			//$("#bodycheckhint11").html("该项必填不能为空");
			//$("#bodycheckhint11").show();
			$("#bodycheckhint11").hide();
		}
		else if(!r.test($(this).val())){  
        	$("#bodycheckhint11").html("2-50整数或1位小数");
        	$("#bodycheckhint11").show();
            return false;  
        }
		else{
			$("#bodycheckhint11").hide();
		}
	});
	$("#ogtt2").bind("keyup",function(){
		var r =	/^([2-9](\.\d)?|[1-4]\d(\.\d)?|50(\.0)?)$/;      
        if(!r.test($(this).val())){  
        	$("#bodycheckhint11").html("2-50整数或1位小数");
        	$("#bodycheckhint11").show();
            return false;  
        }   
	});
	$("#hbalc").bind("blur",function(){
		var r =	/^([1-9](\.\d{1,2})?|1\d(\.\d{1,2})?|2[0-4](\.\d{1,2})?|25(\.0{1,2})?)$/;
		if($(this).val() == ""){
			//$("#bodycheckhint12").html("该项必填不能为空");
			//$("#bodycheckhint12").show();
			$("#bodycheckhint12").hide();
		}
		else if(!r.test($(this).val())){  
        	$("#bodycheckhint12").html("1-25整数或不超2位小数");
        	$("#bodycheckhint12").show();
            return false;  
        }
		else{
			$("#bodycheckhint12").hide();
		}
	});
	$("#hbalc").bind("keyup",function(){
		var r =	/^([1-9](\.\d{1,2})?|1\d(\.\d{1,2})?|2[0-4](\.\d{1,2})?|25(\.0{1,2})?)$/;     
        if(!r.test($(this).val())){  
        	$("#bodycheckhint12").html("1-25整数或不超2位小数");
        	$("#bodycheckhint12").show();
            return false;  
        }   
	});
	
	$("#blooduricacid").bind("blur",function(){
		var r =	/^([4-9]\d|[1-9]\d{2}|1000)$/;
		if($(this).val() == ""){
			//$("#bodycheckhint13").html("该项必填不能为空");
			//$("#bodycheckhint13").show();
			$("#bodycheckhint13").hide();
		}
		else if(!r.test($(this).val())){  
        	$("#bodycheckhint13").html("40-1000的整数");
        	$("#bodycheckhint13").show();
            return false;  
        }
		else{
			$("#bodycheckhint13").hide();
		}
	});
	$("#blooduricacid").bind("keyup",function(){
		var r =	/^([4-9]\d|[1-9]\d{2}|1000)$/;      
        if(!r.test($(this).val())){  
        	$("#bodycheckhint13").html("40-1000的整数");
        	$("#bodycheckhint13").show();
            return false;  
        }   
	});
	
	$("#crp").bind("blur",function(){
		var r =	/^(0\.0[5-9]|0\.[1-9]\d?|[1-9](\.\d{1,2})?|[1-9]\d(\.\d{1,2})?|100(\.0{1,2})?)$/;
		if($(this).val() == ""){
			//$("#bodycheckhint14").html("该项必填不能为空");
			//$("#bodycheckhint14").show();
			$("#bodycheckhint14").hide();
		}
		else if(!r.test($(this).val())){  
        	$("#bodycheckhint14").html("0.05-100整数或不超2位小数");
        	$("#bodycheckhint14").show();
            return false;  
        }
		else{
			$("#bodycheckhint14").hide();
		}
	});
	$("#crp").bind("keyup",function(){
		var r =	/^(0\.0[5-9]|0\.[1-9]\d?|[1-9](\.\d{1,2})?|[1-9]\d(\.\d{1,2})?|100(\.0{1,2})?)$/;     
        if(!r.test($(this).val())){  
        	$("#bodycheckhint14").html("0.05-100整数或不超2位小数");
        	$("#bodycheckhint14").show();
            return false;  
        }   
	});
	
})
;(function($) {
		$verifySmoke = function(){
		if($('#inline-issmoke1').is(':checked')){
			$("#inline-worksmoke1").attr("checked",false);
			$("#inline-worksmoke1").attr("disabled", true);
			$("#inline-worksmoke2").attr("checked",false);
			$("#inline-worksmoke2").attr("disabled", true);
			$("#inline-passivesmoke1").attr("checked",false);
			$("#inline-passivesmoke1").attr("disabled", true);
			$("#inline-passivesmoke2").attr("checked",false);
			$("#inline-passivesmoke2").attr("disabled", true);
			$("#inline-passivesmoke3").attr("checked",false);
			$("#inline-passivesmoke3").attr("disabled", true);
			$("#inline-passivesmoke4").attr("checked",false);
			$("#inline-passivesmoke4").attr("disabled", true);
			$("#nosmokeage").attr("value","");
			$("#nosmokeage").attr("disabled", true);
			
			$("#firstsmoke").attr("disabled", false);
			$("#dailysmoke").attr("disabled", false);
			$("#inline-donotgiveup1").attr("disabled", false);
			$("#inline-donotgiveup2").attr("disabled", false);
			$("#inline-firstmore1").attr("disabled", false);
			$("#inline-firstmore2").attr("disabled", false);
			$("#inline-illnesssmoke1").attr("disabled", false);
			$("#inline-illnesssmoke2").attr("disabled", false);
			$("#inline-nosmoke1").attr("disabled", false);
			$("#inline-nosmoke2").attr("disabled", false);
			$("#smokeage").attr("disabled", false);

		}
		else if($('#inline-issmoke2').is(':checked')){
			$("#inline-worksmoke1").attr("disabled", false);//10
			$("#inline-worksmoke2").attr("disabled", false);
			$("#inline-passivesmoke1").attr("disabled", false);//11
			$("#inline-passivesmoke2").attr("disabled", false);
			$("#inline-passivesmoke3").attr("disabled", false);
			$("#inline-passivesmoke4").attr("disabled", false);
			$("#nosmokeage").attr("disabled", false);//9
			$("#smokeage").attr("disabled", false);//8
			
			$("#firstsmoke").attr("disabled", true);
			$("#firstsmoke").attr("value","");
			$("#dailysmoke").attr("disabled", true);
			$("#dailysmoke").attr("value","");
			$("#inline-donotgiveup1").attr("checked",false);
			$("#inline-donotgiveup1").attr("disabled", true);
			$("#inline-donotgiveup2").attr("checked",false);
			$("#inline-donotgiveup2").attr("disabled", true);
			$("#inline-firstmore1").attr("checked",false);
			$("#inline-firstmore1").attr("disabled", true);
			$("#inline-firstmore2").attr("checked",false);
			$("#inline-firstmore2").attr("disabled", true);
			$("#inline-illnesssmoke1").attr("checked",false);
			$("#inline-illnesssmoke1").attr("disabled", true);
			$("#inline-illnesssmoke2").attr("checked",false);
			$("#inline-illnesssmoke2").attr("disabled", true);
			$("#inline-nosmoke1").attr("checked",false);
			$("#inline-nosmoke1").attr("disabled", true);
			$("#inline-nosmoke2").attr("checked",false);
			$("#inline-nosmoke2").attr("disabled", true);
		}
		else{
			verifyNumber();
			$("#firstsmoke").attr("disabled", true);
			$("#firstsmoke").attr("value","");
			$("#dailysmoke").attr("disabled", true);
			$("#dailysmoke").attr("value","");
			$("#inline-donotgiveup1").attr("checked",false);
			$("#inline-donotgiveup1").attr("disabled", true);
			$("#inline-donotgiveup2").attr("checked",false);
			$("#inline-donotgiveup2").attr("disabled", true);
			$("#inline-firstmore1").attr("checked",false);
			$("#inline-firstmore1").attr("disabled", true);
			$("#inline-firstmore2").attr("checked",false);
			$("#inline-firstmore2").attr("disabled", true);
			$("#inline-illnesssmoke1").attr("checked",false);
			$("#inline-illnesssmoke1").attr("disabled", true);
			$("#inline-illnesssmoke2").attr("checked",false);
			$("#inline-illnesssmoke2").attr("disabled", true);
			$("#inline-nosmoke1").attr("checked",false);
			$("#inline-nosmoke1").attr("disabled", true);
			$("#inline-nosmoke2").attr("checked",false);
			$("#inline-nosmoke2").attr("disabled", true);
			$("#nosmokeage").attr("disabled", true);
			$("#nosmokeage").attr("value", "");
			$("#smokeage").attr("disabled", true);
			$("#smokeage").attr("value", "");
			
			$("#inline-worksmoke1").attr("disabled", false);//10
			$("#inline-worksmoke2").attr("disabled", false);
			$("#inline-passivesmoke1").attr("disabled", false);//11
			$("#inline-passivesmoke2").attr("disabled", false);
			$("#inline-passivesmoke3").attr("disabled", false);
			$("#inline-passivesmoke4").attr("disabled", false);
		}
	};
	
	
})(jQuery);
	