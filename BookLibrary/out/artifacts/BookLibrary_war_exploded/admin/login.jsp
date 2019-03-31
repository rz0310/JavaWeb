<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.0.js"></script>
<LINK href="<%=request.getContextPath()%>/admin/image/css1.css" type=text/css rel=stylesheet>
<LINK href="<%=request.getContextPath()%>/admin/image/newhead.css" type=text/css rel=stylesheet>
</HEAD>
<BODY bgColor=#eef8e0 leftMargin=0 topMargin=0 MARGINWIDTH="0"
	MARGINHEIGHT="0">
	<center>
	<div style="width: 100%;position: absolute;">
	<marquee id="myalert" scrollamount="16" onMouseOver="this.stop()" onMouseOut="this.start()"  width="50%" style="color: red;font-size: 36px;line-height: 100px;font-family: 'MV Boli'">${alert }</marquee>
	</div>
	<FORM id="myform" name=adminlogin action="/BookStore/admin?method=login" method=post>
		<TABLE cellSpacing=0 cellPadding=0 width=1004 border=0>
			<TBODY>
			
				<TR>
					<TD colSpan=6><IMG height=92 alt="" src="<%=request.getContextPath()%>/admin/image/crm_1.gif"
						width=345></TD>
					<TD colSpan=4><IMG height=92 alt="" src="<%=request.getContextPath()%>/admin/image/crm_2.gif"
						width=452></TD>
					<TD><IMG height=92 alt="" src="<%=request.getContextPath()%>/admin/image/crm_3.gif" width=207></TD>
				</TR>
				<TR>
					<TD colSpan=6><IMG height=98 alt="" src="<%=request.getContextPath()%>/admin/image/crm_4.gif"
						width=345></TD>
					<TD colSpan=4><IMG height=98 alt="" src="<%=request.getContextPath()%>/admin/image/crm_5.gif"
						width=452></TD>
					<TD><IMG height=98 alt="" src="<%=request.getContextPath()%>/admin/image/crm_6.gif" width=207></TD>
				</TR>
				<TR>
					<TD rowSpan=5><IMG height=370 alt="" src="<%=request.getContextPath()%>/admin/image/crm_7.gif"
						width=59></TD>
					<TD colSpan=5><IMG height=80 alt="" src="<%=request.getContextPath()%>/admin/image/crm_8.gif"
						width=286></TD>
					<TD colSpan=4><IMG height=80 alt="" src="<%=request.getContextPath()%>/admin/image/crm_9.gif"
						width=452></TD>
					<TD><IMG height=80 alt="" src="<%=request.getContextPath()%>/admin/image/crm_10.gif" width=207></TD>
				</TR>
				<TR>
					<TD><IMG height=110 alt="" src="<%=request.getContextPath()%>/admin/image/crm_11.gif" width=127></TD>
					<TD background="<%=request.getContextPath()%>/admin/image/crm_12.gif" colSpan=6>
						<TABLE id=table1 cellSpacing=0 cellPadding=0 width="98%" border=0>
							<TBODY>
								<TR>
									<TD>
										<TABLE id=table2 cellSpacing=1 cellPadding=0 width="100%"
											border=0>
											<TBODY>
												<TR>
													<TD align=middle width=81><FONT color=#ffffff>用户名：</FONT></TD>
													<TD><INPUT id="username" class=regtxt title=请填写用户名
														maxLength=16 size=16 value="" name=username></TD>
												</TR>
												<TR>
													<TD align=middle width=81><FONT color=#ffffff></FONT></TD>
													<TD id="namealert" height=20 style="font-size: 12px;"></TD>
												</TR>
												<TR>
													<TD align=middle width=81><FONT color=#ffffff>密&nbsp;
															码：</FONT></TD>
													<TD><INPUT id="password" class=regtxt title=请填写密码
														type=password maxLength=16 size=16 value=""
														name=password></TD>
												</TR>
												<TR>
													<TD align=middle width=81><FONT color=#ffffff></FONT></TD>
													<TD id="passalert" height=20 style="font-size: 12px;"></TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD colSpan=2 rowSpan=2><IMG height=158 alt=""
						src="<%=request.getContextPath()%>/admin/image/crm_13.gif" width=295></TD>
					<TD rowSpan=2><IMG height=158 alt="" src="<%=request.getContextPath()%>/admin/image/crm_14.gif"
						width=207></TD>
				</TR>
				<TR>
					<TD rowSpan=3><IMG height=180 alt="" src="<%=request.getContextPath()%>/admin/image/crm_15.gif"
						width=127></TD>
					<TD rowSpan=3><IMG height=180 alt="" src="<%=request.getContextPath()%>/admin/image/crm_16.gif"
						width=24></TD>
					<TD><INPUT id="mysubmit" title=登录后台 type=image height=48
						alt="" width=86 src="<%=request.getContextPath()%>/admin/image/crm_17.gif" name=image></TD>
					<TD><IMG height=48 alt="" src="<%=request.getContextPath()%>/admin/image/crm_18.gif" width=21></TD>
					<TD colSpan=2><IMG id="myreset" title=返回首页 height=48 alt=""
						src="<%=request.getContextPath()%>/admin/image/crm_19.gif" width=84 border=0></TD>
					<TD><IMG height=48 alt="" src="<%=request.getContextPath()%>/admin/image/crm_20.gif" width=101></TD>
				</TR>
				<TR>
					<TD colSpan=5 rowSpan=2><IMG height=132 alt=""
						src="<%=request.getContextPath()%>/admin/image/crm_21.gif" width=292></TD>
					<TD rowSpan=2><IMG height=132 alt="" src="<%=request.getContextPath()%>/admin/image/crm_22.gif"
						width=170></TD>
					<TD colSpan=2><IMG height=75 alt="" src="<%=request.getContextPath()%>/admin/image/crm_23.gif"
						width=332></TD>
				</TR>
				<TR>
					<TD colSpan=2><IMG height=57 alt="" src="<%=request.getContextPath()%>/admin/image/crm_24.gif"
						width=332></TD>
				</TR>
				<TR>
					<TD><IMG height=1 alt="" src="<%=request.getContextPath()%>/admin/image/spacer.gif" width=59></TD>
					<TD><IMG height=1 alt="" src="<%=request.getContextPath()%>/admin/image/spacer.gif" width=127></TD>
					<TD><IMG height=1 alt="" src="<%=request.getContextPath()%>/admin/image/spacer.gif" width=24></TD>
					<TD><IMG height=1 alt="" src="<%=request.getContextPath()%>/admin/image/spacer.gif" width=86></TD>
					<TD><IMG height=1 alt="" src="<%=request.getContextPath()%>/admin/image/spacer.gif" width=21></TD>
					<TD><IMG height=1 alt="" src="<%=request.getContextPath()%>/admin/image/spacer.gif" width=28></TD>
					<TD><IMG height=1 alt="" src="<%=request.getContextPath()%>/admin/image/spacer.gif" width=56></TD>
					<TD><IMG height=1 alt="" src="<%=request.getContextPath()%>/admin/image/spacer.gif" width=101></TD>
					<TD><IMG height=1 alt="" src="<%=request.getContextPath()%>/admin/image/spacer.gif" width=170></TD>
					<TD><IMG height=1 alt="" src="<%=request.getContextPath()%>/admin/image/spacer.gif" width=125></TD>
					<TD><IMG height=1 alt="" src="<%=request.getContextPath()%>/admin/image/spacer.gif" width=207></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
	</center>
</BODY>
<script type="text/javascript">
	var result = 0;
	function myreg(ss){
		var s = ss.prop("name");
		var reg = /^[0-9a-zA-Z]{2,20}$/;
		if (ss.val() != "") {
			if (reg.test(ss.val())) {
				if (s == "username") {
					$("#namealert").text("");
					result++;
				}
				if (s == "password") {
					$("#passalert").text("");
					result++;
				}
			} else {
				if (s == "username") {
					$("#namealert").text("用户名由字母或数字组成2-20位").css(
							"color", "red");
					;
				}
				if (s == "password") {
					$("#passalert").text("密码由字母或数字组成2-20位").css(
							"color", "red");
					;
				}
			}
		} else {
			if (s == "username") {
				$("#namealert").text("用户名不能为空名").css("color", "red");
			}
			if (s == "password") {
				$("#passalert").text("密码不能为空名").css("color", "red");
			}
		}
	};
	$("input").blur(
			function() {
				myreg($(this));
				
			});
	$("#mysubmit").click(function() {
		result = 0;
		$("input").each(function(){
			myreg($(this));
		});
		return (result==2);
	});
	$("#myreset").click(function() {
		$("input").val('');
		$("#namealert").text("");
		$("#passalert").text("");
		$("marquee").text("");
	});
</script>
</HTML>
