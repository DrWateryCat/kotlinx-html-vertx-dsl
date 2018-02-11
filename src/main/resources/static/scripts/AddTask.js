function post() {
    $.ajax({
        url: '/api/todo',
        type: 'POST',
        data: {
            todoTitle: $("#todoTitle").val(),
            todoDesc: $("#todoDesc").val(),
            todoDue: $("#todoDesc").val()
        },
        success: function() {
            window.location.href = '/'
        }
    });
}