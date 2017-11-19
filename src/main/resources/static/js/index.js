$('#guide').on('click', 'li', function () {
    $(this).addClass('active').siblings().removeClass('active');
    $('iframe').attr('src', $(this).children('a').text() + '.html');
});