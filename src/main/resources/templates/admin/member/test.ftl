<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>成员列表</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${ctx!}/assets/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ctx!}/assets/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${ctx!}/assets/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">

    <link href="${ctx!}/assets/css/animate.css" rel="stylesheet">
    <link href="${ctx!}/assets/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>jQuery Validate 简介</h5>
                </div>

            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>返回结果</h5>
                </div>
                <div class="ibox-content">

                 <div class="form-group">
                     <label class="col-sm-3 control-label">msg：</label>
                     <div class="col-sm-8">
                         <input id="msg" name="msg" class="form-control" type="text" value="${resdata.msg}">
                     </div>
                 </div>
                    <div class="form-group">
                        <div class="col-sm-8 col-sm-offset-3">
<#--                            <button class="btn btn-primary" onclick="close()">确定</button>-->
                            <a href="javascript:window.opener=null;window.open('','_self');window.close();" class="btn btn-primary">关闭</a>
                        </div>
                    </div>

<#--                    <a href="javascript:window.opener=null;window.open('','_self');window.close();">关闭</a>-->


                </div>
            </div>
        </div>
    </div>

</div>


<!-- 全局js -->
<script src="${ctx!}/assets/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx!}/assets/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="${ctx!}/assets/js/content.js?v=1.0.0"></script>

<!-- jQuery Validation plugin javascript-->
<script src="${ctx!}/assets/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctx!}/assets/js/plugins/validate/messages_zh.min.js"></script>
<script src="${ctx!}/assets/js/plugins/layer/layer.min.js"></script>
<script src="${ctx!}/assets/js/plugins/layer/laydate/laydate.js"></script>
<script type="text/javascript">
   function close(){
       // alert(1);
       window.opener=null;
       window.open('','_self');
       window.close();
       var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
       parent.layer.close(index);

   }
</script>

</body>

</html>
