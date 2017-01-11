
/*************报告页面调用 读取报告用********************/
       /*
   		* ajax 请求生成报告
   		*/
   		function buildReport(thisBtn){
   			$.ajax({ 
   		          url:$(thisBtn).attr("val"),
   		          type:'post', 
   		          timeout:10000, 
   		          beforeSend:function(XMLHttpRequest){ 
   		        	  infoModal3("报告生成中...");
   		         }, 
   		         success:function(data,textStatus){ 
   		        	 $("#infoModal").modal("hide");
   		        	 if(data!='false'){
   		        		var obj = $.parseJSON(data);
   		 				$(".swfpath").val(obj.swfpath);
   		 				$(".pdfpath").val(obj.pdfpath);
   		 				$("#showSwf").modal("show");     
   		 			}else{
   		 				$("#infoModal").modal("hide");
   		 				alertInfo("报告生成失败,请重试!");
   		 			}
   		         },
   		         error:function(error){
   		        	 $("#infoModal").modal("hide");
   		        	 alertInfo("网络传输错误！")
   		         }
   			  }); 
   		}
   		
   		//下载报告
   		function downloadReport(){
   			$("#downloadForm").submit();
   		}
   		