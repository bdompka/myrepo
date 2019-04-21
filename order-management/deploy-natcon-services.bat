@SET CUR_PATH=%cd%
@CALL cd service-ordermanagement
@CALL mvn fabric8:resource -Pkubernetes,deploy-ordermanagement-service-D.deployment.stage=%STAGE%
@CALL cd server/target/classes/META-INF/fabric8
@CALL kubectl delete -f kubernetes.yml
@CALL kubectl create -f kubernetes.yml
@CALL cd %CUR_PATH%
