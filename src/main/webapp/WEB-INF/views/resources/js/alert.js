
$.Alert = function(options) {
  var setUI = $.extend({
    textHead: '',
    text: '',
    textcolor: '',
    bgcolors: '',
    position: '',
    icon: '',
    time: 5,
    permanent: false
  }, options);

  var user_inter_alert = 'ui-alert-content';
  user_inter_alert += '-' + setUI.position;
  setUI.bgcolors ='style="background-color: '+setUI.bgcolor+';   box-shadow: 0 0 0 1px rgba(255,255,255,.5) inset,0 0 0 0 transparent;"';
  if(setUI.bgcolors === '') setUI.bgcolors ='style="background-color: ; box-shadow: 0 0 0 1px rgba(255,255,255,.5) inset,0 0 0 0 transparent;"';
  if(!$('body > .' + user_inter_alert).length) {
    $('body').append('<div class="ui-alert-content ' + user_inter_alert + '" style="width: inherit;"></div>');
  }
  var message = $('<div id="messages" class="ui icon message" ' + setUI.bgcolors + '><i class="'+setUI.icon+' icon" style="color: '+setUI.textcolor
      +';"></i><i class="close icon" style="color: '+setUI.textcolor+';" id="messageclose"></i><div style="color: '+setUI.textcolor+
      '; margin-right: 10px;">   <div class="header">'+setUI.textHead+'</div>  <p> '+setUI.text+'</p></div>  </div>');
  $('.' + user_inter_alert).prepend(message);
  message.animate({
    opacity: '1',
  }, 300);
  if(setUI.permanent === false){
    var timer = 0;
    $(message).mouseenter(function(){
      clearTimeout(timer);
    }).mouseleave(function(){
      uiAlertHide();
    });
    uiAlertHide();
  }
  function uiAlertHide(){
    timer = setTimeout(function() {
      message.animate({
        opacity: '0',
      }, 300, function() {
        message.remove();
      });
    }, (setUI.time * 1000) );
  }

  $('#messageclose')
      .on('click', function() {
        $(this)
            .closest('#messages')
            .transition('fade')
        ;
      })
  ;

};
