/*!
* Start Bootstrap - Bare v4.3.0 (https://startbootstrap.com/template/bare)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-bare/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project
<script type="text/javascript">
$(document).ready(function() 
		{ 
    
    function reserve(id){
        $.ajax({
         type: "post",
         url: "http://localhost:8080/a/room/makereservation",
         cache: false,    
         data:'roomid=' + id + "&bookingdate";=" + $("#bookingdate"+id).val() + "&bookingslot;=" + $("#bookingdate").val(),
         success: function(response){
          $('#bookingmessage'+id).attr("text","reservation done");
         },
         error: function(){      
          alert('Error while request..Select Amother slot');
         }
        });
       }
		}
	</script>