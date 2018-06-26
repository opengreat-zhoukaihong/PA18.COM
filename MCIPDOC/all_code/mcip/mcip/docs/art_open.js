function js_openSmallPage(url) {
  var 
newwin=window.open(url,"NewWin","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=400,height=190");
  newwin.focus();
  return false;
}

function js_openMeetingSmallPage(url) {
  var newwin=window.open(url,"NewWin","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=400,height=400");
  newwin.focus();
  return false;
}
function js_openClientSmallPage(url) {
  var newwin=window.open(url,"client","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=600,height=450");
  newwin.focus();
  return ;
}
function js_openServerSmallPage(url) {
  var newwin=window.open(url,"server","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=400,height=400");
  newwin.focus();
  return false;
}
function js_openMeetingSmallPageI(url,i) {
  newwin = "win"+i;
  var
  p=window.open(url,newwin,"toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=600,height=450");
  return false;
}
function js_openpage(url) {
  var
newwin=window.open(url,"NewWin","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,width=580,height=450");
  newwin.focus();
  return false;
}

function js_openclause(url) {
  var 
newwin=window.open(url,"NewWin","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=yes,width=450,height=310");
  newwin.focus();
  return false;
}
