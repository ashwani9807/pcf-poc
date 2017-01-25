cf push bootPOC-test -n bluePOC -m 512M
cf unmap-route bootPOC cfapps.io -n greenPOC 
cf map-route bootPOC-test cfapps.io -n greenPOC 
cf delete-route cfapps.io -n bluePOC -f
cf stop bootPOC 
cf delete bootPOC_old -f
cf rename bootPOC bootPOC_old 
cf rename bootPOC-test bootPOC 
