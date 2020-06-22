
var todo = {
    init : function () {
        var _this = this;

        $('#todoAddBtn').on('click', function(){
            _this.todoAdd();
        });

        $('.check_btn.doing').on('click', function(e){
            var no = $(this).attr('chkno');
            _this.todoUpdate(no, "doing");
        });

        $('.check_btn.done').on('click', function(){
            var no = $(this).attr('chkno');
            _this.todoUpdate(no, "done");
        });

        $('.del_btn.do').on('click', function(){
            var no = $(this).attr('chkno');
            _this.todoDelete(no);
        });

        $('.li_content_box').dblclick(function(e){
            var no = $(this).attr('no');
            _this.todoGetDetail(no, "#todoDetailPopup");
        });

        $('#todoTitle').on('keydown', function(e){
            if(e.keyCode == 13){
                $('#todoAddBtn').click();
            }
        });
    },

    todoAdd : function () {
        if(!inputBoxCssChange("todoTitle")) return;

        var sendData = {
            title : $('#todoTitle').val()
        };

        $.ajax({
            type : 'POST',
            url : '/api/v1/todo',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(sendData)
        }).done(function(response, status){
            window.location.href = "/";
        }).fail(function(error){
            console.log("todo add error :: ", JSON.stringify(error));
        })
    },

    todoUpdate : function (no, state) {
        var sendData = {
            no : no,
            state : state
        };

        $.ajax({
            type : 'PUT',
            url : '/api/v1/todo',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(sendData)
        }).done(function(){
            window.location.href = "/";
        }).fail(function(error){
            console.log("todo update error :: ", JSON.stringify(error));
        })
    },

    todoDelete : function (no) {
        var sendData = {
            no : no
        };

        $.ajax({
            type : 'DELETE',
            url : '/api/v1/todo',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(sendData)
        }).done(function(){
            window.location.href = "/";
        }).fail(function(error){
            console.log("todo delete error :: ", JSON.stringify(error));
        })
    },

    todoGetDetail : function (no, el) {
        $.ajax({
            type : 'GET',
            url : '/api/v1/todo/' + no,
            contentType : 'application/json; charset=utf-8',
        }).done(function(response){
            $(el).replaceWith(response);
            openTodoDetailPopup(el);
        }).fail(function(error){
            alert("getTodoDetail 상세정보 API 호출 실패");
            console.log("getTodoDetail :: ", error);

        })
    }
};

function openTodoDetailPopup(el){
    var $el = $(el);		//레이어의 id를 $el 변수에 저장
    var isDim = $el.prev().hasClass('dimBg');	//dimmed 레이어를 감지하기 위한 boolean 변수

    isDim ? $('.dim-layer').fadeIn() : $el.fadeIn();

    var $elWidth = ~~($el.outerWidth()),
        $elHeight = ~~($el.outerHeight()),
        docWidth = $(document).width(),
        docHeight = $(document).height();
    // 화면의 중앙에 레이어를 띄운다.
    if ($elHeight < docHeight || $elWidth < docWidth) {
        $el.css({
            marginTop: -$elHeight /2,
            marginLeft: -$elWidth/2
        })
    } else {
        $el.css({top: 0, left: 0});
    }

    $el.find('a.btn-layerClose').click(function(){
        isDim ? $('.dim-layer').fadeOut() : $el.fadeOut(); // 닫기 버튼을 클릭하면 레이어가 닫힌다.
        return false;
    });

    $el.find('a.btn-layerSave').click(function(){
        let sendData = {
            no : $('#no').val(),
            state : $('#todoStateSelectBox option:selected').val(),
            content : $('#todoContent').val(),
            startDate : $('#startDate').val(),
            startTime : $('#startTime').val(),
            endDate : $('#endDate').val(),
            endTime : $('#endTime').val()
        };

        $.ajax({
            type : 'PUT',
            url : '/api/v1/todoDetail',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(sendData)
        }).done(function(response){
            window.location.href = "/";
            isDim ? $('.dim-layer').fadeOut() : $el.fadeOut();
            return false;
        }).fail(function(error){
            console.log("update Detail :: ", JSON.stringify(error));
            alert("저장 실패");
            return false;
        })
    });

    $('.layer .dimBg').click(function(){
        $('.dim-layer').fadeOut();
        return false;
    });

}

function inputBoxCssChange(el){
    var title = $('#' + el).val();

    if(title == ''){
        $('#' + el).addClass("input_requried");
        return false;
    }else{
        $('#' + el).removeClass("input_requried");
        return true;
    }
}

todo.init();