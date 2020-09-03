function update(work_id) {
    $.ajax({
        url: "/agent/update",
        type: "POST",
        data: $("#form" + work_id).serialize(),
        success: function (result) {
            layui.use("layer", function () {
                var layer = layui.layer;
                layer.open({
                    type: 1,
                    title: "编辑席座",
                    area: ["600px", "400px"],
                    offset: "auto",
                    id: "auto",
                    content: result,
                    cancel: function () {
                        window.location.reload();
                    }
                })
            })

        }
    });
}

function del(work_id) {
    if (confirm('确定删除工号为' + work_id + '的座席吗?')) {
        var method = '<input type="hidden" name="_method" value="DELETE" />';
        $("#form" + work_id).attr("method", "POST");
        $("#form" + work_id).append(method);
        $("#form" + work_id).attr("action", "/agent/" + work_id);
        $("#form" + work_id).submit();
    }
}

function add() {
    $.ajax({
        url: "/agent/insert",
        type: "GET",
        success: function (result) {
            layui.use("layer", function () {
                var layer = layui.layer;
                layer.open({
                    type: 1,
                    title: "添加席座",
                    area: ["600px", "400px"],
                    offset: "auto",
                    id: "auto",
                    content: result,
                    cancel: function () {
                        window.location.reload();
                    }
                })
            })
        }
    })

}