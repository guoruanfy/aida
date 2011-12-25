var unanimis_availableSizes = /^(728x90|300x250|160x600,120x600|BTF_728x90)$/;
var unanimis_availableTypes = /^(ad|adj|javascript|adi|iframe)$/
if (typeof(unanimis_zone) == 'undefined') {var unanimis_zone = '';}
if (typeof(unanimis_kv) == 'undefined') {var unanimis_kv = '';} else {unanimis_kv = '&'+unanimis_kv.replace(/;/g,'&amp;')}

document.write("<scr"+"ipt type=\"text/javascript\" src=\"http://ad.crwdcntrl.net/5/ct=y/c=571/pe=y/var=ccauds\"></scr"+"ipt>");
unanimis_kv += "&unanimis_cc=";
unanimis_ccauds = "";
function setUnanimisKV() {
	if (typeof(ccauds) != "undefined" && unanimis_ccauds.length==0) {
		for (var cci = 0; cci < ccauds.Profile.Audiences.Audience.length; cci++) {
			if (cci > 0) unanimis_ccauds += "|";
			unanimis_ccauds += ccauds.Profile.Audiences.Audience[cci].abbr;
		}
		unanimis_kv += unanimis_ccauds;
	}
}if (unanimis_zone.length > 0) {unanimis_zone = 'KELKOO_'+unanimis_zone;}

function writeDart(sz, pos,adType) {
	if (typeof(setUnanimisKV)=='function' && typeof(unanimis_kv)!='undefined') {setUnanimisKV();}
  if (typeof(adType)=='undefined' || adType.length == 0) { adType = 'JavaScript'; }
  if (typeof(sz)=='undefined' || !unanimis_availableSizes.test(sz)) {return '';}
  var unms_zone_id = '';

  switch(sz) {
case '728x90': unms_zone_id = '8992'; break;
case '300x250': unms_zone_id = '8994'; break;
case '160x600,120x600': unms_zone_id = '9077'; break;
case 'BTF_728x90': unms_zone_id = '9083'; break;
default: return ''; break;
  }

if (unms_zone_id.length > 0) {
  switch(adType) {
    case 'adj': //JavaScript
    case 'JavaScript':
      write_UNMS_JS(unms_zone_id);
      break;
    case 'adi':  //iFrame
    case 'iFrame': 
      write_UNMS_Iframe(unms_zone_id,sz);
      break;
  } 
}
return '';
}

    var unanimis_url = (location.protocol=='https:'?'https://ssl-a.unanimis.co.uk/':'http://a.unanimis.co.uk/');

function write_UNMS_JS(unms_zone_id)
{
  document.MAX_ct0 = 'http://ad.crwdcntrl.net/5/c=571/clk=y?';
  var m3_u = (location.protocol=='https:'?'https://ssl-a.unanimis.co.uk/ajs.php':'http://a.unanimis.co.uk/ajs.php');
  var m3_r = Math.floor(Math.random()*99999999999);
  if (!document.MAX_used) document.MAX_used = ',';
  document.write ("<scr"+"ipt type='text/javascript' src='"+m3_u);
  document.write ("?zoneid="+unms_zone_id);
  if (unanimis_zone.length > 0) {document.write('&amp;unanimis_zone='+unanimis_zone);}document.write(unanimis_kv);
  
document.write ('&amp;cb=' + m3_r);
  if (document.MAX_used != ',') document.write ("&amp;exclude=" + document.MAX_used);
  document.write (document.charset ? '&amp;charset='+document.charset : (document.characterSet ? '&amp;charset='+document.characterSet : ''));
  document.write ("&amp;loc=" + escape(window.location));
  if (document.referrer) document.write ("&amp;referer=" + escape(document.referrer));
  if (document.context) document.write ("&context=" + escape(document.context));
   if ((typeof(document.MAX_ct0) != 'undefined') && (document.MAX_ct0.substring(0,4) == 'http')) {
       document.write ("&amp;ct0=" + escape(document.MAX_ct0));
   }
  if (document.mmm_fo) document.write ("&amp;mmm_fo=1");
  document.write ("'><\/scr"+"ipt><img src='http://ad.crwdcntrl.net/5/c=571/p=2559/dp=y/rand="+m3_r+"' width='1' height='1'>");
}

function write_UNMS_Iframe(unms_zone_id,sz)
{
var refresh = '';
var UNMS_ORD1 = Math.floor(Math.random()*99999999999);
var UNMS_ORD2 = Math.floor(Math.random()*99999999999);
var UNMS_ORD3 = Math.floor(Math.random()*99999999999);
var aMaxDimensions = _getMaxDimensions(sz);

document.write("<iframe id='"+UNMS_ORD1+"' name='"+UNMS_ORD1+"' src='"+unanimis_url+"afr.php?"+refresh+"cb="+UNMS_ORD1+"&amp;zoneid="+unms_zone_id+"&amp;ct0=http://ad.crwdcntrl.net/5/c=571/clk=y?");
if (unanimis_zone.length > 0) {document.write('&amp;unanimis_zone='+unanimis_zone);}document.write(unanimis_kv);
document.write("' framespacing='0' frameborder='no' scrolling='no' width='"+aMaxDimensions[0]+"' height='"+aMaxDimensions[1]+"' allowtransparency='true'><a href='"+unanimis_url+"ck.php?cb="+UNMS_ORD2+"' target='_blank'><img src='"+unanimis_url+"avw.php?zoneid="+unms_zone_id+"&amp;cb="+UNMS_ORD2);
if (unanimis_zone.length > 0) {document.write('&amp;unanimis_zone='+unanimis_zone);}document.write(unanimis_kv);
document.write("' border='0' alt='' /></a></iframe><img src='http://ad.crwdcntrl.net/5/c=571/p=2559/dp=y/rand="+UNMS_ORD2+"' width='1' height='1'><scr"+"ipt type='text/javascript' src='"+unanimis_url+"ag.php'></scr"+"ipt>");
}
function _getMaxDimensions(sz) {
  allSizes = sz.split(",");
  maxSizes = Array(0,0);
  for (i = 0; i < allSizes.length; i++) {
    curSize = allSizes[i].split("x");
    if (curSize[0] > maxSizes[0]) { maxSizes[0] = curSize[0]; }
    if (curSize[1] > maxSizes[1]) { maxSizes[1] = curSize[1]; }
  }
  return maxSizes;
}
