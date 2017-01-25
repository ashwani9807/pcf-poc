Create user provided service
cf cups SERVICE_INSTANCE -p '{"name":"db_details", "username":"admin","password":"pa55woRD"}'

cf unmap-route pcf-poc-springboot  cfapps.io --hostname tempArun
cf map-route aruntemp-poc cfapps.io -n tempArun

Step1:
cf push bootPOC -n greenPOC -m 512M

Test the URL

Blue-Green Deployment
cf push bootPOC-test -n bluePOC -m 512M

Test all features against blue POC URL.


Flip the App Urls.
cf push bootPOC-test -n bluePOC -m 512M
cf unmap-route bootPOC cfapps.io -n greenPOC 
cf map-route bootPOC-test cfapps.io -n greenPOC 
cf delete-route cfapps.io -n bluePOC -f
cf stop bootPOC 
cf delete bootPOC_old -f
cf rename bootPOC bootPOC_old 
cf rename bootPOC-test bootPOC 
    

