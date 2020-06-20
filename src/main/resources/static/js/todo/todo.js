console.log("todo js");
console.log("ususususus ::: ", userInfo);
console.log("todoList  ::: ", todoList);
console.log("doingList  ::: ", doingList);


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
        })

        $('.del_btn.do').on('click', function(){
            var no = $(this).attr('chkno');
            _this.todoDelete(no);
        })
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

    }
};

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