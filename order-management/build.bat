@echo setting context...
@IF NOT "%1"=="" SET APP=%1
@IF NOT "%2"=="" SET CLUSTER=%2
@IF NOT "%3"=="" SET STAGE=%3
@IF NOT "%4"=="" SET NAMESPACE=%4
@SET CONTEXT=%APP%-%STAGE%
@kubectl config use-context %CONTEXT%
@echo context %CONTEXT% set.

mvn clean install fabric8:build fabric8:push fabric8:resource -Pkubernetes,
deploy-ordermanagement-service -Dordermanagement.deployment.stage=%STAGE%
