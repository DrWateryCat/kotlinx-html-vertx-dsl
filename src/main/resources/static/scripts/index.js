function del(index) {
    $.ajax({
        url: '/api/todo',
        type: 'DELETE',
        data: index,
        success: function(res) {
            window.location.reload(true)
        }
    });
}