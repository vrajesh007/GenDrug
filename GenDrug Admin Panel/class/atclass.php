<?php
//error_reporting(0);
/*connection*/
$connection = new mysqli("localhost", "root", "", "gendrug") or die(mysqli_connect_error());
//DateTimeSet
date_default_timezone_set('Asia/Calcutta');
//FileUpload Max Size
ini_set("upload_max_filesize","300M");
mysqli_set_charset($connection, "utf8");


$baseurl = "http://192.168.0.113/atcart/";

$imageupload_path = "http://192.168.0.113/atcart/upload/";

$imageupload_folder = "upload/";




 

function stringclean($s) {
    $result = preg_replace("/[^a-zA-Z0-9]+/", "", html_entity_decode($s, ENT_QUOTES));
    return $result;
}
// for webservice 
$tokenname ='sarasapidetergent';
$tokenvalue='sAras@2018$';

function getFullHost()
{
    $protocole = $_SERVER['REQUEST_SCHEME'].'://';
    $host = $_SERVER['HTTP_HOST'] . '/';
    $project = explode('/', $_SERVER['REQUEST_URI'])[1];
    return $protocole . $host . $project;
}

function getIP() 
{
        return $_SERVER['REMOTE_ADDR'];
}
function gettodaydate() 
{
        return date('d-m-Y');
}
//Send SMS 

function send_sms($mobile_number,$smsmessage)
{
//Your authentication key
    $authKey = "173294ADQwXrvWU59af6977";

    //Multiple mobiles numbers separated by comma
    //$mobileNumber = "8000147888";

    //Sender ID,While using route4 sender id should be 6 characters long.
    $senderId = "KHEERU";

    //Your message to send, Add URL encoding here.
    $message = urlencode($smsmessage);

    //Define route 
    $route = "4";
//            $route = "default";

    $url="https://control.msg91.com/api/sendhttp.php?authkey=$authKey&mobiles=$mobile_number&message=$message&sender=$senderId&route=$route";

    // init the resource
    $ch = curl_init();
    curl_setopt_array($ch, array(
        CURLOPT_URL => $url,
        CURLOPT_RETURNTRANSFER => true,
        CURLOPT_POST => false,
//            CURLOPT_POSTFIELDS => $postData
        //,CURLOPT_FOLLOWLOCATION => true
    ));


//Ignore SSL certificate verification
curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 0);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, 0);


//get response
$output = curl_exec($ch);

//Print error if any
if(curl_errno($ch))
{
    //echo 'error:' . curl_error($ch);
}

curl_close($ch);

//echo $output;
}



function welcome_template()
{
    $setting = setting();
    
    $body = "<div style='margin:0;padding:0;line-height:1.2'>
            <table cellpadding='0' cellspacing='0' border='0' id='m_-7571788235800459791backgroundTable' style='border-collapse:collapse;margin:0;padding:0;background-color:#ffffff;font-family:Arial,Helvetica,sans-serif;width:100%!important;height:100%!important'>
                <tbody><tr>
                    <td align='center' style='padding-bottom:40px;border-collapse:collapse'>

                        <table style='border-collapse:collapse'>
                            <tbody><tr>
                                <td align='center' style='padding-top:30px;padding-bottom:30px;text-align:center;border-collapse:collapse'>
            <img src='".base_url()."images/{$setting['logo']}' alt='{$GLOBALS['project_name']}' border='0' style='height:auto;width:auto;margin:auto;display:block;outline:none;text-decoration:none' class='CToWUd'>

                                </td>
                            </tr>
                        </tbody></table>


                        <div style='max-width:600px'>
                             <center><h3>Thank You For Signup With {$GLOBALS['project_name']}.</h3></center>
                             <center><h4>See You On Dashboard.</h4></center>
                        </div>

                        <div style='text-align:center;max-width:600px'>
                            <table class='m_-7571788235800459791emailfooter' style='margin-left:auto;margin-right:auto;font-size:95%'>
                                <tbody><tr>
                                    <td style='padding:30px 0'>
                                        <p><span style='color:#999;font-family:'Helvetica Neue',Helvetica,Arial,sans-serif'>
                                            Questions? Comments? Feel Free To <a href='".base_url()."' target='_blank'>Contact Us</a>.    </span></p>

                                            <span style='color:#999;font-family:'Helvetica Neue',Helvetica,Arial,sans-serif'>Team <br>{$GLOBALS['project_name']}</span>
                                    </td>
                                </tr>
                            </tbody></table>
                        </div>
                    </td>
                </tr>
            </tbody></table><div class='yj6qo'></div><div class='adL'>

        </div></div>";
                                
    return $body;
                                
}