#!/bin/bash
chmod +x config/deploy.after.sh && chmod +x config/deploy.before.sh
mv -f app/target/application.jar $WORKSPACE/
mv -f config/appspec.yml $WORKSPACE/
mv -f config/deploy.after.sh $WORKSPACE/
mv -f config/deploy.before.sh $WORKSPACE/
zip -r sigmaversion-test.zip application.jar appspec.yml deploy.after.sh deploy.before.sh -x app -x config -x deploy -x Jenkinsfile -x backend.sh
aws s3 cp sigmaversion-test.zip s3://infra.sigmaversion.dev/codedeploy/becacloud_backend/sigmaweb/${BUILD_ID}/
aws deploy create-deployment --application-name becacloud --deployment-group-name sigmaweb --s3-location bucket=infra.sigmaversion.dev,key=codedeploy/becacloud_backend/sigmaweb/${BUILD_ID}/sigmaversion-test.zip,bundleType=zip --deployment-config-name CodeDeployDefault.OneAtATime --region us-east-2